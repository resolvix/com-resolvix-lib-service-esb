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

    private <Q, R> R execute(
            Class<BaseEsbServiceRequestHandlerImpl<Q, R, ?>> handlerClass,
            Q request)
        throws Exception
    {
        BaseEsbServiceRequestHandlerImpl<Q, R, ?> handler
            = handlerClass.newInstance();
        return handler.execute(request);
    }
}
