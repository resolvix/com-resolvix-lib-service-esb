package com.resolvix.lib.service;

import com.resolvix.lib.service.api.ServiceFault;
import com.resolvix.lib.service.api.ServiceFaultMaplet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class ServiceFaultMap {

    protected Map<Class<? extends ServiceFault>, BiFunction<?, ? extends ServiceFault, ? extends Exception>> serviceFaultExceptionMap;

    private ServiceFaultMap(
        Map<Class<? extends ServiceFault>, BiFunction<?, ? extends ServiceFault, ? extends Exception>> serviceFaultExceptionMap
    ) {
        this.serviceFaultExceptionMap = serviceFaultExceptionMap;
    }

    public static final ServiceFaultMap of(
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
        return new ServiceFaultMap(serviceFaultExceptionMap);
    }

    public <C, F extends ServiceFault, E extends Exception> E map(C c, F serviceFault) {
        BiFunction<C, F, E> transformer
            = (BiFunction<C, F, E>) serviceFaultExceptionMap.get(serviceFault.getClass());
        if (transformer == null)
            throw new IllegalStateException(serviceFault);
        return transformer.apply(c, serviceFault);
    }
}
