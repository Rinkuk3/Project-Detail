package com.td.mbna.msec.midtier.disclosure;

import com.td.mbna.msec.midtier.disclosure.payload.consentdisclosure.ConsentDisclosureRequest;
import com.td.mbna.msec.midtier.disclosure.payload.consentdisclosure.ConsentDisclosureResponse;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureRequest;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureResponse;

public interface DisclosureService {
	public GetDisclosureResponse getDisclosure(GetDisclosureRequest getDisclosureRequest);
	
	public ConsentDisclosureResponse consentDisclosure(ConsentDisclosureRequest consentDisclosureRequest);

}
