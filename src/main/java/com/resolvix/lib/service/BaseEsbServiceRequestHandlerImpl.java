package com.resolvix.lib.service;

import com.google.common.base.Preconditions;
import com.resolvix.lib.service.api.ServiceException;
import com.resolvix.lib.service.api.ServiceFault;

/**
 * Base implementation of an ESB -compatible service request handler.
 *
 * @param <Q> the request type
 * @param <R> the response type
 * @param <F> the fault type
 * @param <C> the context type
 */
public abstract class BaseEsbServiceRequestHandlerImpl<Q, R, F extends ServiceFault, C>
    extends BaseServiceRequestHandlerImpl<Q, R, F, C>
{

    protected BaseEsbServiceRequestHandlerImpl() {
        //
    }

    @Override
    protected void validate(C c)
        throws ServiceException, ServiceFault
    {
        Preconditions.checkArgument(c != null);
    }
}
