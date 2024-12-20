package com.td.mbna.msec.midtier.ofm;

import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsRequest;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsResponse;

public interface MbnaOfm {

    public GetEntitlementFlagsResponse retrieveEligibility(GetEntitlementFlagsRequest retrieveEligibilityRequest, boolean chatElig, String token) ;

}
