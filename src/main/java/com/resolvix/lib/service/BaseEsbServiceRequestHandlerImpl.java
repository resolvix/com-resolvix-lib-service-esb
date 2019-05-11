package com.resolvix.lib.service;

import com.google.common.base.Preconditions;
import com.resolvix.lib.service.api.ServiceException;
import com.resolvix.lib.service.api.ServiceFault;
import com.resolvix.lib.service.api.ServiceFaultMaplet;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Base implementation of an ESB -compatible service request handler.
 *
 * @param <Q> the request type
 * @param <R> the response type
 * @param <C> the context type
 */
public abstract class BaseEsbServiceRequestHandlerImpl<Q, R, C>
    extends BaseServiceRequestHandlerImpl<Q, R, C>
{
//    protected BaseEsbServiceRequestHandlerImpl() {
//        //
//        serviceFaultExceptionMap = new HashMap<>();

//    }


//    /**
//     * Maps a service fault to the relevant SOAP fault exception.
//     *
//     * @param serviceFault the service fault exception
//     * @return the equivalent SOAP fault exception
//     */
//    private Exception map(ServiceFault serviceFault) {
//        Function<ServiceFault, Exception> serviceFaultExceptionMaplet
//            = serviceFaultExceptionMap.get(serviceFault);
//        if (serviceFaultExceptionMaplet == null)
//            throw new IllegalStateException();
//        return serviceFaultExceptionMaplet.apply(serviceFault);
//    }

    @Override
    protected void validate(C c)
        throws ServiceException, ServiceFault
    {
        Preconditions.checkArgument(c != null);
    }
}
