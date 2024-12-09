package com.td.mbna.msec.midtier.customerprofile;

import com.td.mbna.msec.midtier.customerprofile.payload.customeragreement.CaptureAgreementRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.customeragreement.CaptureAgreementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts.GetUserInfoAndAccountsRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts.GetUserInfoAndAccountsResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecustomerprofile.RetrieveCustomerProfileRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecustomerprofile.RetrieveCustomerProfileResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.SaveValetDataRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.SaveValetDataResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileResponse;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    private GetUserInfoAndAccountsOperation getUserInfoAndAccountsOperation;

    @Autowired
    @Qualifier("enrollmentOperation")
    private RetrieveEnrollmentOperation retrieveEnrollmentOperation;

    @Autowired
    private AddAuthorizedUserOperation addAuthorizedUserOperation;

    @Autowired
    private RetrieveCustomerProfileOperation retrieveCustomerProfileOperation;

    @Autowired
    private UpdateCustomerProfileOperation updateCustomerProfileOperation;

    @Autowired
    private GetKycAcctsInfoOperation getKycAcctsInfoOperation;

    @Autowired
    private SetKycAcctsInfoOperation setKycAcctsInfoOperation;
    
    @Autowired
    private RetrieveCapdOperation retrieveCapdOperation;

    @Autowired 
    private SaveValetDataOperation saveValetDataOperation;
    
    @Autowired 
    private RetrieveValetDataOperation retrieveValetDataOperation;

   @Autowired
    private CaptureCustomerAgreementOperation captureCustomerAgreementOperation;
    
    @Override
    @ProfileLog
    public RetrieveEnrollmentResponse retrieveEnrollment(RetrieveEnrollmentRequest retrieveEnrollmentRequest, String... token) {
        return retrieveEnrollmentOperation.invokeService(retrieveEnrollmentRequest, token);
    }

    @Override
    @ProfileLog
    public AddAuthorizedUserResponse addAuthorizedUser(AddAuthorizedUserRequest addAuthorizedUserRequest,String... token) {
        return addAuthorizedUserOperation.invokeService(addAuthorizedUserRequest,token);

    }

    @Override
    @ProfileLog
    public RetrieveCustomerProfileResponse retrieveCustomerProfile(RetrieveCustomerProfileRequest retrieveCustomerProfileRequest, String... token) {
        return retrieveCustomerProfileOperation.invokeService(retrieveCustomerProfileRequest, token);
    }

    @Override
    @ProfileLog
    public UpdateCustomerProfileResponse updateCustomerProfile(UpdateCustomerProfileRequest updateCustomerProfileRequest, String... token) {
        return updateCustomerProfileOperation.invokeService(updateCustomerProfileRequest, token);
    }

    @Override
    @ProfileLog
    public GetUserInfoAndAccountsResponse getUserInfoAndAccounts(GetUserInfoAndAccountsRequest getUserInfoAndAccountsRequest, String... token) {
        return getUserInfoAndAccountsOperation.invokeService(getUserInfoAndAccountsRequest, token);
    }

    @Override
    @ProfileLog
    public GetKycAcctsInfoResponse getKycAcctsInfo(GetKycAcctsInfoRequest getKycAcctsInfoRequest, String... token) {
        return getKycAcctsInfoOperation.invokeService(getKycAcctsInfoRequest, token);
    }

    @Override
    @ProfileLog
    public SetKycAcctsInfoResponse setKycAcctsInfo(SetKycAcctsInfoRequest setKycAcctsInfoRequest, String... token) {
        return setKycAcctsInfoOperation.invokeService(setKycAcctsInfoRequest, token);
    }

	@Override
    @ProfileLog
	public RetrieveCapdResponse retrieveCapd(RetrieveCapdRequest retrieveCapdRequest,String... token){
		return retrieveCapdOperation.invokeService(retrieveCapdRequest, token);
	}

	@Override
    @ProfileLog
	public SaveValetDataResponse saveValetData(SaveValetDataRequest request, String... token){
		return saveValetDataOperation.invokeService(request, token);
	}

	@Override
	@ProfileLog
	public RetrieveValetDataResponse retrieveValetData(RetrieveValetDataRequest request, String... token){
		return retrieveValetDataOperation.invokeService(request, token);
	}

    @Override
    @ProfileLog
    public CaptureAgreementResponse captureAgreement(CaptureAgreementRequest request, String... token){
        return captureCustomerAgreementOperation.invokeService(request, token);
    }
}
