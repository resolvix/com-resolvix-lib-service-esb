package com.resolvix.lib.javax.jax.ws.service.esb;

import com.resolvix.lib.javax.jax.ws.service.BaseWsServiceImpl;

/**
 * Base implementation of an ESB -compatible service.
 */
public abstract class BaseEsbWsServiceImpl
    extends BaseWsServiceImpl
{

    protected BaseEsbWsServiceImpl() {
        super();
    }

    protected <Q, R, C, H extends BaseEsbWsServiceRequestHandlerImpl<Q, R, C>> R execute(
            Class<? extends BaseEsbWsServiceRequestHandlerImpl<Q, R, C>> handlerClass,
            Q request)
        throws Exception
    {
        BaseEsbWsServiceRequestHandlerImpl<Q, R, C> handler
            = handlerClass.newInstance();
        return handler.execute(request);
    }
}
