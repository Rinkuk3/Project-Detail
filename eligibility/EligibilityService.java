package com.td.mbna.msec.midtier.eligibility;

import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsRequest;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsResponse;


public interface EligibilityService {
	public GetEntitlementFlagsResponse getEntitlementFlags(GetEntitlementFlagsRequest getEntitlementFlagsRequest);
}
