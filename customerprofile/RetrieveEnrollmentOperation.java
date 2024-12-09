package com.td.mbna.msec.midtier.customerprofile;

import com.mbnaweb.xsd.msgs.customerprofile.RetrieveEnrollmentResponse;
import com.td.mbna.msec.midtier.enrollment.MbnaEnrollment;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("enrollmentOperation")
public class RetrieveEnrollmentOperation implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentRequest, com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentResponse> {

    private static final MbnaLogger logger = new MbnaLogger(RetrieveEnrollmentOperation.class);

    private static final String GENERAL_ERROR = "MS601";

    @Autowired
    private MbnaEnrollment mbnaEnrollment;


    public RetrieveEnrollmentResponse doRetrieveEnrollment(final com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentRequest request, String token) {
    	String methodName= "RetrieveEnrollmentOperation::doRetrieveEnrollment";
    	logger.mandatory("calling REST version of Enrollment");
    	com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentResponse retrieveEnrollmentResponse = null;
        try {
             retrieveEnrollmentResponse = mbnaEnrollment.retrieveEnrollment(request.getRequestPayload().getConnectId(),token);
        } catch (Exception e) {
        	String message = " mbnaEnrollment.retrieveEnrollment(request.getRequestPayload().getConnectId(),token) call failed ";
			logger.error(methodName, message);
            throw ExceptionUtil.genRuntimeException(e);
        }
        return JAXBJsonConverter.convertJsonToJAXBInterface(retrieveEnrollmentResponse,com.mbnaweb.xsd.msgs.customerprofile.RetrieveEnrollmentResponse.class);
    }


    @Override
    public com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentResponse invokeService(com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentRequest requestInJson, String... token) {
    	String methodName= "RetrieveEnrollmentOperation::invokeService";

    	logger.mandatory("calling REST version of Enrollment");
        try {
            return mbnaEnrollment.retrieveEnrollment(requestInJson.getRequestPayload().getConnectId(),token[0]);
        } catch (Exception e) {
        	String message = " mbnaEnrollment.retrieveEnrollment(requestInJson.getRequestPayload().getConnectId(),token[0]) call failed ";
        	logger.error(methodName, message);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,message);
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
        return null;
    }
}
