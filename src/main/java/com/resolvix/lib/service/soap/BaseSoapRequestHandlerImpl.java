package com.resolvix.lib.service.soap;

import org.slf4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

public abstract class BaseSoapRequestHandlerImpl
    implements SOAPHandler<SOAPMessageContext>
{
    protected abstract Logger getLogger();

    @Override
    public Set<QName> getHeaders() {
        getLogger().debug("BaseSoapRequestHandlerImpl::getHeaders invoked.");
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext soapMessageContext) {
        getLogger().debug("BaseSoapRequestHandlerImpl::handleMessage invoked.");
        return false;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {
        getLogger().debug("BaseSoapRequestHandlerImpl::handleFault invoked.");
        return false;
    }

    @Override
    public void close(MessageContext messageContext) {
        getLogger().debug("BaseSoapRequestHandlerImpl::close invoked.");
    }
}
