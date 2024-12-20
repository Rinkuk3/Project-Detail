package com.td.mbna.msec.midtier.transfer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.persistance.entity.Creditors;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.transfer.payload.getknowncardissuers.GetKnownCardIssuersRequest;
import com.td.mbna.msec.midtier.transfer.payload.getknowncardissuers.GetKnownCardIssuersResponse;
import com.td.mbna.msec.midtier.transfer.payload.getknowncardissuers.ResponsePayload;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;

@Component
public class GetKnownCardIssuersOperation implements MsecMidtierCommonOperations<GetKnownCardIssuersRequest, GetKnownCardIssuersResponse>
{
	private static MbnaLogger logger = new MbnaLogger(GetKnownCardIssuersOperation.class);

	public GetKnownCardIssuersResponse invokeService(GetKnownCardIssuersRequest request, String... token)
	{
		GetKnownCardIssuersResponse response = new GetKnownCardIssuersResponse();
		ResponsePayload payload = new ResponsePayload();
		response.setResponsePayload(payload);
		
		List<String> Issuers = new ArrayList<String>();
    	List<String> IssuersFR = new ArrayList<String>();
    	
    	try {
//    			Collection<Creditors> creditors = DBService.getAllCreditors();
    			List<Creditors> creditors = DBMybatisService.getAllCreditors();
    			if(creditors == null){
    				return response;
    			}
    			// here using 2 loops due to order purpose
//    			for (Creditors creditor : creditors) {
//    				Issuers.add(creditor.getName_EN());
//    				IssuersFR.add(creditor.getName_FR());
//    			}
//    			// 
    			for (Creditors creditor : creditors) {
    				Issuers.add(creditor.getName_EN() + "," + creditor.getMerchantId());
    				IssuersFR.add(creditor.getName_FR() + "," + creditor.getMerchantId());
    			}
    	}
    	catch (Exception tolerate) {
    			// tolerate exception; otherwise class would not load properly
    			logger.error("GetKnownCardIssuersOperation", tolerate.getMessage(), tolerate);
    	}

    	List<String> issuers = payload.getCardIssuer();
   		
   		if(request.getLanguagePref().equals("fr_CA")){
    		issuers.addAll(IssuersFR);   	
   		}else{
    		issuers.addAll(Issuers);
   		}
   		return response;
    }

	@Override
	public boolean requiresDisclosureConsent() {
		return false;
	}

	@Override
	public String getConsentDisclosureFailedMsgCode() {
		return null;
	}

	@Override
	public boolean generateAutoComment() {
		return false;
	}

	@Override
	public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
		return null;
	}

	@Override
	public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
		return null;
	}

	@Override
	public MsecValidator getValidator() {
		return null;
	}
}
