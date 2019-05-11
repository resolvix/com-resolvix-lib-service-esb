package com.resolvix.lib.service.api;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ServiceFaultMaplet<C, F extends ServiceFault, E extends Exception> {

    private Class<F> serviceFaultClass;

    private BiFunction<C, F, E> serviceFaultTransformer;

    private ServiceFaultMaplet(
        Class<F> serviceFaultClass,
        BiFunction<C, F, E> serviceFaultTransformer
    ) {
        this.serviceFaultClass = serviceFaultClass;
        this.serviceFaultTransformer = serviceFaultTransformer;
    }

    public static <C, F extends ServiceFault, E extends Exception> ServiceFaultMaplet<C, F, E> of(
        Class<F> serviceFaultClass,
        BiFunction<C, F, E> serviceFaultTransformer
    ) {
        return new ServiceFaultMaplet<>(
            serviceFaultClass,
            serviceFaultTransformer);
    }

    public Class<F> getServiceFaultClass() {
        return serviceFaultClass;
    }

    public BiFunction<C, F, E> getServiceFaultTransformer() {
        return serviceFaultTransformer;
    }
}
