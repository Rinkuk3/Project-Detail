package com.td.mbna.msec.midtier.disclosure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.disclosure.payload.consentdisclosure.ConsentDisclosureRequest;
import com.td.mbna.msec.midtier.disclosure.payload.consentdisclosure.ConsentDisclosureResponse;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureRequest;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureResponse;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

@Component("midtierDisclosureService")
public class DisclosureServiceImpl implements DisclosureService {

	@Autowired
	private ConsentDisclosureOperation consentDisclosureOperation;
	
	@Autowired
	private GetDisclosureOperation getDisclosureOperation;

    @Override
	@ProfileLog
	public GetDisclosureResponse getDisclosure(GetDisclosureRequest request) {
		return getDisclosureOperation.invokeService(request);
	}
	
	@Override
	@ProfileLog
	public ConsentDisclosureResponse consentDisclosure(ConsentDisclosureRequest request) {
		return consentDisclosureOperation.invokeService(request);
	} 

}

