package com.resolvix.lib.service;

import com.google.common.base.Preconditions;
import com.resolvix.lib.service.api.ServiceException;

public abstract class BaseEsbServiceRequestHandlerImpl<Q, R, C>
    extends BaseServiceRequestHandlerImpl<Q, R, C>
{

    protected BaseEsbServiceRequestHandlerImpl() {
        //
    }

    @Override
    protected void validate(C c)
        throws ServiceException
    {
        Preconditions.checkArgument(c != null);
    }
}
