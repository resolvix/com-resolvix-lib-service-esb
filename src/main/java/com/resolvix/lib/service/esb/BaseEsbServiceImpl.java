package com.resolvix.lib.service.esb;

import com.resolvix.lib.service.BaseServiceImpl;

/**
 * Base implementation of an ESB -compatible service.
 */
public class BaseEsbServiceImpl
    extends BaseServiceImpl
{

    protected BaseEsbServiceImpl() {
        super();
    }

    protected <Q, R, C, H extends BaseEsbServiceRequestHandlerImpl<Q, R, C>> R execute(
            Class<? extends BaseEsbServiceRequestHandlerImpl<Q, R, C>> handlerClass,
            Q request)
        throws Throwable
    {
        BaseEsbServiceRequestHandlerImpl<Q, R, C> handler
            = handlerClass.newInstance();
        return handler.execute(request);
    }
}
