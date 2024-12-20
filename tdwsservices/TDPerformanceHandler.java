package com.td.mbna.msec.midtier.tdwsservices;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.td.mbna.msec.midtier.util.MbnaLogger;


public class TDPerformanceHandler implements SOAPHandler<SOAPMessageContext>{
	 
	protected MbnaLogger logger = new MbnaLogger(this.getClass());
	public static final String PERF_TIME_CLOCK = "PERF_TIME_CLOCK";
	public static final String PERF_JAMON= "PERF_JAMON";

    public Set<QName> getHeaders() {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext smc) {
        return true;
    }

    public boolean handleFault(SOAPMessageContext smc) {
        return true;
    }

    // nothing to clean up
    public void close(MessageContext messageContext) {
    }


    

}