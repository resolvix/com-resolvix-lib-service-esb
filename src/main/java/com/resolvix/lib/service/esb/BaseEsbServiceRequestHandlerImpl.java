package com.resolvix.lib.service.esb;

import com.google.common.base.Preconditions;
import com.resolvix.lib.service.BaseServiceRequestHandlerImpl;
import com.resolvix.lib.service.esb.api.EsbServiceException;
import com.resolvix.lib.service.esb.api.EsbServiceFault;

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
    protected BaseEsbServiceRequestHandlerImpl() {
        //
    }

    @Override
    protected void validate(C c)
        throws EsbServiceException, EsbServiceFault
    {
        Preconditions.checkArgument(c != null);
    }
}
