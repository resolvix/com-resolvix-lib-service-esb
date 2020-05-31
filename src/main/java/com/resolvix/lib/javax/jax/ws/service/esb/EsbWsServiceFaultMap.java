package com.resolvix.lib.javax.jax.ws.service.esb;

import com.resolvix.lib.javax.jax.ws.service.api.ServiceFault;
import com.resolvix.lib.javax.jax.ws.service.api.ServiceFaultMaplet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class EsbWsServiceFaultMap {

    protected Map<Class<? extends ServiceFault>, BiFunction<?, ? extends ServiceFault, ? extends Exception>> serviceFaultExceptionMap;

    private EsbWsServiceFaultMap(
        Map<Class<? extends ServiceFault>, BiFunction<?, ? extends ServiceFault, ? extends Exception>> serviceFaultExceptionMap
    ) {
        this.serviceFaultExceptionMap = serviceFaultExceptionMap;
    }

    public static final EsbWsServiceFaultMap of(
        List<ServiceFaultMaplet<?, ?, ?>> serviceFaultMaplets) {
        Map<Class<? extends ServiceFault>, BiFunction<?, ? extends ServiceFault, ? extends Exception>> serviceFaultExceptionMap
            = new HashMap<>();
        serviceFaultMaplets.stream()
            .forEach((ServiceFaultMaplet m) -> {
                serviceFaultExceptionMap.put(
                    m.getServiceFaultClass(),
                    m.getServiceFaultTransformer()
                );
            });
        return new EsbWsServiceFaultMap(serviceFaultExceptionMap);
    }

    public <C, F extends ServiceFault, E extends Exception> E map(C c, F serviceFault) {
        BiFunction<C, F, E> transformer
            = (BiFunction<C, F, E>) serviceFaultExceptionMap.get(serviceFault.getClass());
        if (transformer == null)
            throw new IllegalStateException(serviceFault);
        return transformer.apply(c, serviceFault);
    }
}
