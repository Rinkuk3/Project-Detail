package com.td.mbna.msec.midtier.ofm;

import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsRequest;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsResponse;
import com.td.mbna.msec.midtier.ofm.facade.MbnaOfmFacade;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MbnaOfmImpl implements MbnaOfm {

    @Autowired
    private MbnaOfmFacade mbnaOfmFacade;

    @Override
    @ProfileLog
    public GetEntitlementFlagsResponse retrieveEligibility(GetEntitlementFlagsRequest retrieveEligibilityRequest, boolean chatElig, String token) {
        return mbnaOfmFacade.retrieveEligibility(retrieveEligibilityRequest, chatElig, token);
    }

}
