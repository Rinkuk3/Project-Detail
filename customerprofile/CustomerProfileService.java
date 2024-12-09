package com.td.mbna.msec.midtier.customerprofile;

import com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.customeragreement.CaptureAgreementRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.customeragreement.CaptureAgreementResponse;
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
import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.SaveValetDataRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.SaveValetDataResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileResponse;

public interface CustomerProfileService {
    public RetrieveEnrollmentResponse retrieveEnrollment(RetrieveEnrollmentRequest retrieveEnrollmentRequest, String... token);

	public AddAuthorizedUserResponse addAuthorizedUser(AddAuthorizedUserRequest addAuthorizedUserRequest,String... token);

    public RetrieveCustomerProfileResponse retrieveCustomerProfile(RetrieveCustomerProfileRequest retrieveCustomerProfileRequest, String... token);

    public UpdateCustomerProfileResponse updateCustomerProfile(UpdateCustomerProfileRequest updateCustomerProfileRequest, String... token);

    public GetUserInfoAndAccountsResponse getUserInfoAndAccounts(GetUserInfoAndAccountsRequest getUserInfoAndAccountsRequest, String... token);

    public GetKycAcctsInfoResponse getKycAcctsInfo(GetKycAcctsInfoRequest getKycAcctsInfoRequest, String... token);

    public SetKycAcctsInfoResponse setKycAcctsInfo(SetKycAcctsInfoRequest setKycAcctsInfoRequest, String... token);

	public RetrieveCapdResponse retrieveCapd(RetrieveCapdRequest retrieveCapdRequest, String... token);
	
	public SaveValetDataResponse saveValetData(SaveValetDataRequest saveValetDataRequest, String... token);
	
	public RetrieveValetDataResponse retrieveValetData(RetrieveValetDataRequest request, String... token);

    CaptureAgreementResponse captureAgreement(CaptureAgreementRequest request, String... token);
}
