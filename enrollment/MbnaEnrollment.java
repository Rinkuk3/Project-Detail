package com.td.mbna.msec.midtier.enrollment;

import com.td.mbna.msec.midtier.account.payload.deleteaccount.DeleteAccountResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentResponse;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

public interface MbnaEnrollment {

    String ENROLLMENT_ENDPOINT = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_ENROLLMENT_API_ENDPT)+"/productcustomer";
    String ENROLLMENT_TEST_SET_ENV  = TDRestServiceUtil.getTDServiceParam("TD_CS_HEADER_WSA_AddressValue");

    public RetrieveEnrollmentResponse retrieveEnrollment(String connectId, String token);
    public DeleteAccountResponse unEnroll(String connectId, String accountId, String token);
    public String cleanApiCache(String connectId);
}
