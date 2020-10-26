package com.resolvix.lib.service.esb.api;

import com.resolvix.lib.esb.api.event.EsbEventCategory;
import com.resolvix.lib.service.api.ServiceException;
import com.resolvix.lib.service.esb.api.event.EsbServiceEvent;

public class EsbServiceException
    extends ServiceException
    implements EsbServiceEvent
{
    private EsbEventCategory category;

    @Override
    public EsbEventCategory getCategory() {
        return category;
    }
}
