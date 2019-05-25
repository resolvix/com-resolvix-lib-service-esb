package com.resolvix.lib.service.esb.builder;

import com.resolvix.lib.service.builder.BaseElementBuilder;
import com.resolvix.soa.servicedefinitions.RequestHeader;

/**
 * A base implementation of a builder for a {@link RequestHeader} relevant
 * to the enterprise service bus.
 *
 * @param <S> the request header builder sub-type
 * @param <R> the return type
 */
public abstract class BaseRequestHeaderBuilder<S extends BaseRequestHeaderBuilder<S, R>, R>
    extends BaseElementBuilder<S, R> {

    private RequestHeader requestHeader;

    protected BaseRequestHeaderBuilder(
        RequestHeader requestHeader
    ) {
        super();
        this.requestHeader = requestHeader;
    }

    /**
     * Configures the request identifier for the request header.
     *
     * @param requestId the request identifier
     * @return the request header builder instance
     */
    public S requestId(String requestId) {
        requestHeader.setRequestId(requestId);
        return self();
    }
}
