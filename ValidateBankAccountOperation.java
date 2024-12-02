package com.td.mbna.msec.midtier.autopay;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountRequest;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountResponse;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbnaap.MbnaAP;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class ValidateBankAccountOperation implements MsecMidtierCommonOperations<ValidateBankAccountRequest, ValidateBankAccountResponse> {

	@Autowired
	private ValangValidator addPadRequestValidator;

	private MsecValidator msecValidator;

	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(addPadRequestValidator);
	}

    private final static MbnaLogger logger = new MbnaLogger(ValidateBankAccountOperation.class);

    private static final String GENERAL_ERROR = "MS601";
    
	@Autowired
    private MbnaAP mbnaAP;

    @Override
    public ValidateBankAccountResponse invokeService(ValidateBankAccountRequest request, String... token) {

        try {
        	ValidateBankAccountResponse response = mbnaAP.validateBankAccount(request, token[0]);
            return response;
        } catch (Exception e) {
            logger.error("AutoPayService:ValidateBankAccountOperation", e.getLocalizedMessage(), e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR, " AutoPayService:ValidateBankAccountOperation failed ", e);
        }
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
        return msecValidator;
    }

}
