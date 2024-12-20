package com.td.mbna.msec.midtier.offers;

import com.td.mbna.msec.midtier.cache.ServiceCommand;
import com.td.mbna.msec.midtier.disclosure.GetDisclosureOperation;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureRequest;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureResponse;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.RequestPayload;
import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.TrackingInfoType;
import com.td.mbna.msec.midtier.util.MbnaLogger;

public class StaticDisclosureCacheCmd extends ServiceCommand {

    private static final MbnaLogger logger = new MbnaLogger(StaticDisclosureCacheCmd.class);
    private static final long serialVersionUID = -2788376832783034949L;

    private transient GetDisclosureOperation getDisclosureOperation;

    private String disclosureText;
    private DisclosureInfoType disclosureInfoType;
    private String languageId;
    private String disclosureId ;

    public StaticDisclosureCacheCmd(GetDisclosureOperation getDisclosureOperation, String languageId, String disclosureId) {
        this.getDisclosureOperation = getDisclosureOperation;
        this.languageId = languageId;
        this.disclosureId = disclosureId;
    }

    @Override
    public boolean isReadyToCallExecute() {
        return languageId != null && super.isReadyToCallExecute();
    }

    @Override
    public void performExecute() {
        logger.debug("performExecute", "NO CACHE: disclosureText, " + languageId + "," + disclosureId);
        try {
            logger.debug("StaticDisclosureCacheCmd:performExecute", "calling D&L to retrieve MPPT");
            //this is sent to the D&L service, but populated to avoid null pointer exception.
            TrackingInfoType sessionInfo = new TrackingInfoType();
            sessionInfo.setLoginId("");

            GetDisclosureRequest getMpptDisclosureRequest = new GetDisclosureRequest();
            getMpptDisclosureRequest.setSessionInfo(sessionInfo);
            getMpptDisclosureRequest.setRequestPayload(new RequestPayload());

            getMpptDisclosureRequest.getRequestPayload().setDisclosureInput(null);
            getMpptDisclosureRequest.getRequestPayload().setDisclosureType(disclosureId);
            getMpptDisclosureRequest.setLanguagePref(languageId);


            GetDisclosureResponse mpptDisclosure = getDisclosureOperation.invokeService(getMpptDisclosureRequest, "");
            disclosureText = mpptDisclosure.getResponsePayload().getContent();
            disclosureInfoType = mpptDisclosure.getResponsePayload().getDisclosureInfo();

            logger.debug("performExecute", "CACHE LOADED: disclosureText, " + languageId + "," + disclosureId);
        } catch (Exception e) {
            logger.error("StaticDisclosureCacheCmd:performExecute","Error in retrieving MPPT",e);
            throw e;
        }
    }

    public String getDisclosureText() {
        return disclosureText;
    }

    public DisclosureInfoType getDisclosureInfoType() {
        return disclosureInfoType;
    }

    // Cache key method
    public String getDisclosureId() {
        return disclosureId;
    }

    // Cache key method
    public String getLanguageId() {
        return languageId;
    }
}
