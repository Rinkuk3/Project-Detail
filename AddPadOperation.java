package com.td.mbna.msec.midtier.autopay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.api.mbpad.response.retrievebranch.Branch;
import com.td.api.mbpad.response.retrievebranch.FinancialInstitutionName;
import com.td.api.mbpad.response.retrievebranch.RetrieveBranchResponse;
import com.td.api.mbpad.response.retrievebranch.StreetAddress;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadRequest;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadResponse;
import com.td.mbna.msec.midtier.mbnaap.MbnaAP;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class AddPadOperation implements MsecMidtierCommonOperations<AddPadRequest, AddPadResponse> {

    private final static MbnaLogger logger = new MbnaLogger(AddPadOperation.class);

    private static final String GENERAL_ERROR = "MS601";
    
	@Autowired
    private MbnaAP mbnaAP;

    @Override
    public AddPadResponse invokeService(AddPadRequest request, String... token) {
    	String methodName ="AddPadOperation:invokeService";
        try {
        	
        	if (request == null || request.getRequestPayload()==null || request.getSessionInfo() == null) {
    			String desc = "AddPadOperation request validation failed ";
    			logger.error(methodName,desc);
    			throw ExceptionUtil.genBusinessException("MS601", desc);
    		}
        	
        	AddPadResponse response = new AddPadResponse();
        	
        	if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
    			return response;
    		}

        	response = mbnaAP.addPad(request, token[0]);
        	if (response != null) {
    	        RetrieveBranchResponse retrieveBranchResponse = mbnaAP.retrieveBranch(request.getRequestPayload().getBankNum(), request.getRequestPayload().getBranchNum(), token[0]);

    	        if (retrieveBranchResponse != null && retrieveBranchResponse.getBranch() != null && retrieveBranchResponse.getBranch().size() > 0) {
    	        	Branch branch = retrieveBranchResponse.getBranch().get(0);
    	        	String bankNameEn = "";
    	        	String bankNameFr = "";
    	        	for (FinancialInstitutionName financialInstitutionName : branch.getFinancialInstitutionName()) {
    	        		if (financialInstitutionName != null && "EN".equalsIgnoreCase(financialInstitutionName.getLanguageCd())) {
    	        			bankNameEn = financialInstitutionName.getText();
    	        		}
    	        		if (financialInstitutionName != null && "FR".equalsIgnoreCase(financialInstitutionName.getLanguageCd())) {
    	        			bankNameFr = financialInstitutionName.getText();
    	        		}
    	        	}
    	        	response.getResponsePayload().setBankNameEn(bankNameEn);
    	        	response.getResponsePayload().setBankNameFr(bankNameFr);
    			}
        	}

	        return response;
            
        } catch (Exception e) {
            logger.error("AccountService:AddPadOperation", e.getLocalizedMessage(), e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR, " AddPadOperation falied ", e);
        }
    }

    @Override
    public boolean requiresDisclosureConsent() {
        return true;
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
