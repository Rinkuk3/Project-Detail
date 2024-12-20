package com.td.mbna.msec.midtier.tdwsservices;


import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

/**
 * 
 * This class contains the handler resolver.
 *
 */
@SuppressWarnings("rawtypes")
public class TDHandlerResolver implements HandlerResolver{
	private List<Handler> chain;

    public TDHandlerResolver() {
    }

    public List<Handler> getHandlerChain(PortInfo portInfo) {
        return chain;
    }

	public List<Handler> getChain() {
		return chain;
	}

	public void setChain(List<Handler> chain) {
		this.chain = chain;
	}
	 
}