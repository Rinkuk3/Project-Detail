package com.td.mbna.msec.midtier.ofm.adapter;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.ofm.MbnaOfmImpl;
import com.td.mbna.msec.midtier.ofm.util.EligibilityUtils;
import com.td.mbna.msec.midtier.util.EligibilityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.api.ofm.common.TCCAAPIAgreementPartyFeature;
import com.td.api.ofm.request.TSvcRetrieveCreditCardAgreementPartyFeatureListRq;
import com.td.api.ofm.response.TSvcRetrieveCreditCardAgreementPartyFeatureListRs;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsRequest;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsResponse;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.ResponsePayload;
import com.td.mbna.msec.midtier.ofm.util.OfmEligibilityUtil;
import com.td.mbna.msec.midtier.types.common.EligIdType;
import com.td.mbna.msec.midtier.types.eligibility.AcctEligType;
import com.td.mbna.msec.midtier.types.eligibility.CustEligType;
import com.td.mbna.msec.midtier.types.eligibility.EligType;
import com.td.mbna.msec.midtier.util.MbnaLogger;

@Component
public class MbnaOfmAdapter {
    MbnaLogger logger = new MbnaLogger(MbnaOfmAdapter.class);

    public GetEntitlementFlagsResponse convert(TSvcRetrieveCreditCardAgreementPartyFeatureListRs ofmApiResponse, GetEntitlementFlagsRequest retrieveEligibilityRequest, boolean chatElig) {
        GetEntitlementFlagsResponse response = new GetEntitlementFlagsResponse();
        ResponsePayload responsePayload = new ResponsePayload();
        response.setResponsePayload(responsePayload);
        CustEligType custEligType = new CustEligType();
        responsePayload.setCustElig(custEligType);

        custEligType.setCustId(retrieveEligibilityRequest.getCustId());
        List<EligType> custElig = buildCustElig(ofmApiResponse);
        custEligType.setCustElig(custElig);

        List<AcctEligType> acctsElig = buildAcctsElig(retrieveEligibilityRequest.getAcctNum(), ofmApiResponse, chatElig, retrieveEligibilityRequest.getIsPrimaryUser());;
        custEligType.setAcctsElig(acctsElig);
        return response;
    }

    private List<AcctEligType> buildAcctsElig(String acctId, TSvcRetrieveCreditCardAgreementPartyFeatureListRs ofmApiResponse, boolean chatElig, Boolean isPrimary) {
        List<AcctEligType> acctsElig = new ArrayList<>(1); // 1 account only
        AcctEligType aet = new AcctEligType();
        aet.setAcctId(acctId);
        acctsElig.add(aet);
        List<EligType> eligTypeList = new ArrayList<>();
        aet.setAcctElig(eligTypeList);
        // <xsl:template match="impl:Sub-ArrangementFeature/impl:FeatureEligibility/impl:EligibilityRule" >
        boolean hasChat = false;
        if (ofmApiResponse != null && ofmApiResponse.getAgreementPartyFeature() != null && ofmApiResponse.getAgreementPartyFeature().size() > 0){
            for (TCCAAPIAgreementPartyFeature f: ofmApiResponse.getAgreementPartyFeature()) {
                EligType e = buildEligType(f, chatElig, isPrimary);
                if (e != null) {
                    eligTypeList.add(e);
                    if (e.getEligId() == EligIdType.CHAT) {
                        hasChat = true;
                        break;
                    }
                }
            }
        }
        if (!hasChat) {
            EligType eligType = new EligType();
            eligType.setEligId(EligIdType.CHAT);
            eligType.setEligValue(chatElig);
            eligTypeList.add(eligType);
        }
        return acctsElig;
    }

    private EligType buildEligType(TCCAAPIAgreementPartyFeature agreementPartyFeature, boolean chatElig, Boolean isPrimary) {
        String featureName = agreementPartyFeature.getFeature().getFeatureName();
        if (EligibilityUtils.isValidEligId(featureName)) {
            EligType eligType = new EligType();
            eligType.setEligId(EligIdType.fromValue(featureName));
            if (eligType.getEligId() == EligIdType.CHAT) {
                eligType.setEligValue(chatElig);
            } else if (isPrimary != null && isPrimary){
                eligType.setEligValue(agreementPartyFeature.getEligibleInd());
            } else if (EligibilityUtils.isEligForPrimary(featureName)) {
            	eligType.setEligValue(false);
            } else {
                eligType.setEligValue(agreementPartyFeature.getEligibleInd());
            }
            return eligType;
        } else {
            return null;
        }
    }

    private List<EligType> buildCustElig(TSvcRetrieveCreditCardAgreementPartyFeatureListRs ofmApiResponse) {
        List<EligType> custElig = new ArrayList<>();
        // assuming no Customer Eligibility
        /*
        List<TCCAAPIAgreementPartyFeature> agreementPartyFeature = ofmApiResponse.getAgreementPartyFeature();
        for (int i = 0; i < agreementPartyFeature.size(); i++) {
            EligType eligType = new EligType();
            TCCAAPIAgreementPartyFeature tccaapiAgreementPartyFeature = agreementPartyFeature.get(i);
            if(!("PRODUCT-CHANGE").equalsIgnoreCase(tccaapiAgreementPartyFeature.getFeature().getFeatureId()) && !("INSTALLMENT-PLAN").equalsIgnoreCase(tccaapiAgreementPartyFeature.getFeature().getFeatureId()) && !("CREDIT-INSURANCE").equalsIgnoreCase(tccaapiAgreementPartyFeature.getFeature().getFeatureId())) {
                eligType.setEligId(EligIdType.fromValue(tccaapiAgreementPartyFeature.getFeature().getFeatureName()));
                eligType.setEligValue(agreementPartyFeature.get(i).getEligibleInd());
                custElig.add(eligType);
            }
        }
         */
        return custElig;
    }

    public TSvcRetrieveCreditCardAgreementPartyFeatureListRq buildTsvcRetrieveCreditCardAgreementPartyFeatureListRq(GetEntitlementFlagsRequest retrieveEligibilityRequest) {
		logger.toJson(retrieveEligibilityRequest);
        TSvcRetrieveCreditCardAgreementPartyFeatureListRq tSvcRetrieveCreditCardAgreementPartyFeatureListRq = new TSvcRetrieveCreditCardAgreementPartyFeatureListRq();
        tSvcRetrieveCreditCardAgreementPartyFeatureListRq.setCardNum(retrieveEligibilityRequest.getCardNum());
        tSvcRetrieveCreditCardAgreementPartyFeatureListRq.setPartyId(retrieveEligibilityRequest.getCustId());
        tSvcRetrieveCreditCardAgreementPartyFeatureListRq.setSolicitationChannelTypeCd("INTERNET-SECURE");
        tSvcRetrieveCreditCardAgreementPartyFeatureListRq.setAccessChannelTypeCd("ONLINE-SECURE-SITE");
		logger.toJson(tSvcRetrieveCreditCardAgreementPartyFeatureListRq);
        return tSvcRetrieveCreditCardAgreementPartyFeatureListRq;
    }


}
