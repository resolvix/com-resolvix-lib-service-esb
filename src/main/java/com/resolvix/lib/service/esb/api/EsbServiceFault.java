package com.resolvix.lib.service.esb.api;

import com.resolvix.lib.esb.api.event.EsbEventCategory;
import com.resolvix.lib.service.api.ServiceFault;
import com.resolvix.lib.service.esb.api.event.EsbServiceEvent;

public abstract class EsbServiceFault
    extends ServiceFault
    implements EsbServiceEvent
{
    private EsbEventCategory category;

    @Override
    public EsbEventCategory getCategory() {
        return category;
    }
}
