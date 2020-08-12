package com.resolvix.lib.service.esb;

import com.resolvix.lib.service.api.ServiceFault;
import com.resolvix.lib.service.api.ServiceFaultMaplet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class ServiceFaultMap {

    protected Map<Class<? extends ServiceFault>, BiFunction<?, ? extends ServiceFault, ? extends Throwable>> serviceFaultThrowableMap;

    private ServiceFaultMap(
        Map<Class<? extends ServiceFault>, BiFunction<?, ? extends ServiceFault, ? extends Throwable>> serviceFaultThrowableMap
    ) {
        this.serviceFaultThrowableMap = serviceFaultThrowableMap;
    }

    public static final ServiceFaultMap of(
        List<ServiceFaultMaplet<?, ?, ?>> serviceFaultMaplets) {
        Map<Class<? extends ServiceFault>, BiFunction<?, ? extends ServiceFault, ? extends Throwable>> serviceFaultThrowableMap
            = new HashMap<>();
        serviceFaultMaplets.stream()
            .forEach((ServiceFaultMaplet m) -> {
                serviceFaultThrowableMap.put(
                    m.getServiceFaultClass(),
                    m.getServiceFaultTransformer()
                );
            });
        return new ServiceFaultMap(serviceFaultThrowableMap);
    }

    public <C, F extends ServiceFault, E extends Throwable> E map(C c, F serviceFault) {
        BiFunction<C, F, E> transformer
            = (BiFunction<C, F, E>) serviceFaultThrowableMap.get(serviceFault.getClass());
        if (transformer == null)
            throw new IllegalStateException(serviceFault);
        return transformer.apply(c, serviceFault);
    }
}
