package com.resolvix.lib.service;

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
        throws Exception
    {
        BaseEsbServiceRequestHandlerImpl<Q, R, C> handler
            = handlerClass.newInstance();
        return handler.execute(request);
    }
}
