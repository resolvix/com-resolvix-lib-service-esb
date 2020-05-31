package com.resolvix.lib.javax.jax.ws.service.esb;

import com.google.common.base.Preconditions;
import com.resolvix.lib.javax.jax.ws.service.BaseWsServiceRequestHandlerImpl;
import com.resolvix.lib.javax.jax.ws.service.api.ServiceException;
import com.resolvix.lib.javax.jax.ws.service.api.ServiceFault;

/**
 * Base implementation of an ESB -compatible service request handler.
 *
 * @param <Q> the request type
 * @param <R> the response type
 * @param <C> the context type
 */
public abstract class BaseEsbWsServiceRequestHandlerImpl<Q, R, C>
    extends BaseWsServiceRequestHandlerImpl<Q, R, C>
{
    protected BaseEsbWsServiceRequestHandlerImpl() {
        //
    }

    @Override
    protected void validate(C c)
        throws ServiceException, ServiceFault
    {
        Preconditions.checkArgument(c != null);
    }
}
