package com.resolvix.lib.javax.jax.ws.service.esb.builder;

import com.resolvix.lib.javax.jax.ws.service.builder.BaseWsElementBuilder;
import com.resolvix.soa.servicedefinitions.RequestHeader;

/**
 * A base implementation of a builder for a {@link RequestHeader} relevant
 * to the enterprise service bus.
 *
 * @param <S> the request header builder sub-type
 * @param <R> the return type
 */
public abstract class BaseEsbWsRequestHeaderBuilder<S extends BaseEsbWsRequestHeaderBuilder<S, R>, R>
    extends BaseWsElementBuilder<S, R> {

    private RequestHeader requestHeader;

    protected BaseEsbWsRequestHeaderBuilder(
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
