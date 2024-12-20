package com.td.mbna.msec.midtier.mbcapd.adaptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.td.api.mbcapd.request.retrievecapd.AgreementInquiryRequest;
import com.td.api.mbcapd.response.retrievecapd.Agreement;
import com.td.api.mbcapd.response.retrievecapd.AgreementInquiryResponse;
import com.td.api.mbcapd.response.retrievecapd.AlertBlocklistSetup;
import com.td.api.mbcapd.response.retrievecapd.AlertGroup;
import com.td.api.mbcapd.response.retrievecapd.AlertSetup;
import com.td.api.mbcapd.response.retrievecapd.Contact;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.CapdAccount;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.ResponsePayload;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

@Service
public class MbnaCapdAdaptor {
	private static final String ALERT_TYPE_OL ="OL";
	private static final String ALERT_TYPE_TH ="TH";
	private static final String ALERT_TYPE_SP_TH ="SPEND_TH";
	private static final String DELIVERY_METHOD_BOTH = "SMS,EMAIL";
	private static final String DELIVERY_METHOD_SMS = "SMS";
	private static final String DELIVERY_METHOD_EMAIL = "EMAIL";
	//	private static final String DELIVERY_METHOD_NONE = "NONE";
	private static final String NOTIFICATION_NONE = "0";
	private static final String NOTIFICATION_TEXT_EMAIL = "1";
	private static final String NOTIFICATION_TEXT = "2";
	private static final String NOTIFICATION_EMAIL = "3";
	private static final String NOTIFICATION_WATERFALL = "4";
	private static final String ADDRESS_TYPE_EMAIL= "Email";
	private static final String ADDRESS_TYPE_MOBILE= "Mobile";
	private static final String ADDRESS_TYPE_PHONE= "Phone";
	private static final String ALERT_GROUP_OL = "CA_MBNA_CPF_OVERLIMIT";
	private static final String ALERT_GROUP_TH = "CA_MBNA_CPF_THRESHOLD";

	private static final String ALERT_GROUP_SP = "CA_MBNA_SPENDNOTIF_1";

	public RetrieveCapdResponse getResponse(String connectId){
		RetrieveCapdResponse response = new RetrieveCapdResponse();

		String mockContent = null;
		com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.ResponsePayload cpaf = null;

		if(MSECConstants.CPAF_JSON_MOCK && connectId != null){
			String jsonFile = "cpafMock_" + connectId + ".json";
			String filePath = ConfigUtil.getConfigDirectory() + jsonFile;
			mockContent = TDRestServiceUtil.readLineByLineJava8(filePath);
		}

		if (mockContent != null){
			Gson gson = new Gson();
			cpaf = gson.fromJson(mockContent, com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.ResponsePayload.class);
		}

		response.setResponsePayload(cpaf);

		return response;
	}

	public AgreementInquiryRequest getRequest(RetrieveCapdRequest retrieveCapdRequest) {
		AgreementInquiryRequest agreementInquiryRequest = new AgreementInquiryRequest();
		if (retrieveCapdRequest == null || retrieveCapdRequest.getRequestPayload() == null){
			return null;
		}

		agreementInquiryRequest.setPartyKey(retrieveCapdRequest.getRequestPayload().getCustId());
		agreementInquiryRequest.getAgreementKey().addAll(retrieveCapdRequest.getRequestPayload().getAcctIds());
		return agreementInquiryRequest;
	}

	public RetrieveCapdResponse getResponse(AgreementInquiryResponse body) {
		RetrieveCapdResponse retrieveCapdResponse = new RetrieveCapdResponse();
		ResponsePayload payload = new ResponsePayload();

		List<CapdAccount> capdAccounts = new ArrayList<>();

		if (body != null && body.getAgreement() != null && body.getAgreement().size() > 0){
			for (Agreement agreement : body.getAgreement()){
				boolean blockEmailOverlimit = false;
				boolean blockEmailThreshold = false;
				boolean blockMobileOverlimit = false;
				boolean blockMobileThreshold = false;
				boolean blockEmailSpend = false;
				boolean blockMobileSpend = false;

				CapdAccount capdAccount = new CapdAccount();
				capdAccount.setaccountId(agreement.getAgreementKey());
				if (agreement.getContact() != null && agreement.getContact().size() > 0){
					for (Contact contact : agreement.getContact()){
						String addressSubtypeCd = contact.getAddressSubtypeCd();
						if (contact.getAlertBlocklistSetup()==null || contact.getAlertBlocklistSetup().isEmpty()){
							continue;
						}
						AlertBlocklistSetup alertBlocklistSetup = contact.getAlertBlocklistSetup().get(0);
						if (alertBlocklistSetup != null && alertBlocklistSetup.getAlertGroup() != null && alertBlocklistSetup.getAlertGroup().size() > 0){
							for (AlertGroup alertGroup : alertBlocklistSetup.getAlertGroup()){
								if (ALERT_GROUP_OL.equalsIgnoreCase(alertGroup.getGroupCd()) && alertGroup.getBlocklistedInd()!=null && alertGroup.getBlocklistedInd()){
									if (ADDRESS_TYPE_EMAIL.equalsIgnoreCase(addressSubtypeCd)){
										blockEmailOverlimit = true;
									} else if (ADDRESS_TYPE_MOBILE.equalsIgnoreCase(addressSubtypeCd) || ADDRESS_TYPE_PHONE.equalsIgnoreCase(addressSubtypeCd)){
										blockMobileOverlimit = true;
									}
								} else if (ALERT_GROUP_TH.equalsIgnoreCase(alertGroup.getGroupCd()) && alertGroup.getBlocklistedInd()!=null && alertGroup.getBlocklistedInd()){
									if (ADDRESS_TYPE_EMAIL.equalsIgnoreCase(addressSubtypeCd)){
										blockEmailThreshold = true;
									} else if (ADDRESS_TYPE_MOBILE.equalsIgnoreCase(addressSubtypeCd) || ADDRESS_TYPE_PHONE.equalsIgnoreCase(addressSubtypeCd)){
										blockMobileThreshold = true;
									}
								} else if (ALERT_GROUP_SP.equalsIgnoreCase(alertGroup.getGroupCd()) && alertGroup.getBlocklistedInd() != null && alertGroup.getBlocklistedInd()) {
									if (ADDRESS_TYPE_EMAIL.equalsIgnoreCase(addressSubtypeCd)) {
										blockEmailSpend = true;
									} else if (ADDRESS_TYPE_MOBILE.equalsIgnoreCase(addressSubtypeCd) || ADDRESS_TYPE_PHONE.equalsIgnoreCase(addressSubtypeCd)) {
										blockMobileSpend = true;
									}
								}
							}
						}
					}
				}

				if (agreement.getAlertSetup() != null && agreement.getAlertSetup().size() > 0){
					capdAccount.setOverLimitPref(null);
					capdAccount.setThresholdPref(null);
					for (AlertSetup alertSetup : agreement.getAlertSetup()){

						String deliveryMethods = DELIVERY_METHOD_BOTH;
						if (alertSetup.getDeliveryMethodCd() != null){
							deliveryMethods = alertSetup.getDeliveryMethodCd().toUpperCase();
						}

						if (ALERT_TYPE_OL.equalsIgnoreCase(alertSetup.getAlertTypeCd())){

							if (!blockEmailOverlimit && deliveryMethods.contains(DELIVERY_METHOD_EMAIL)){
								capdAccount.setOverLimitPref(NOTIFICATION_EMAIL);
								if (!blockMobileOverlimit && deliveryMethods.contains(DELIVERY_METHOD_SMS)){
									if (alertSetup.getDeliveryMethodCd() == null){
										capdAccount.setOverLimitPref(NOTIFICATION_WATERFALL);
									} else {
										capdAccount.setOverLimitPref(NOTIFICATION_TEXT_EMAIL);
									}
								}
							} else if (!blockMobileOverlimit && deliveryMethods.contains(DELIVERY_METHOD_SMS)){
								capdAccount.setOverLimitPref(NOTIFICATION_TEXT);
							} else {
								capdAccount.setOverLimitPref(NOTIFICATION_NONE);
							}
						} else if (ALERT_TYPE_TH.equalsIgnoreCase(alertSetup.getAlertTypeCd())){
							capdAccount.setThresholdValue(alertSetup.getAlertSetupVal());

							if (!blockEmailThreshold && deliveryMethods.contains(DELIVERY_METHOD_EMAIL)){
								capdAccount.setThresholdPref(NOTIFICATION_EMAIL);
								if (!blockMobileThreshold && deliveryMethods.contains(DELIVERY_METHOD_SMS)){
									if (alertSetup.getDeliveryMethodCd() == null){
										capdAccount.setThresholdPref(NOTIFICATION_WATERFALL);
									} else {
										capdAccount.setThresholdPref(NOTIFICATION_TEXT_EMAIL);
									}
								}
							} else if (!blockMobileThreshold && deliveryMethods.contains(DELIVERY_METHOD_SMS)){
								capdAccount.setThresholdPref(NOTIFICATION_TEXT);
							} else {
								capdAccount.setThresholdPref(NOTIFICATION_NONE);
							}
						}
						else if (ALERT_TYPE_SP_TH.equalsIgnoreCase(alertSetup.getAlertTypeCd())){
							capdAccount.setSpendValue(alertSetup.getAlertSetupVal());

							if (!blockEmailSpend && deliveryMethods.contains(DELIVERY_METHOD_EMAIL)) {
								capdAccount.setSpendPref(NOTIFICATION_EMAIL);
								if (!blockMobileSpend && deliveryMethods.contains(DELIVERY_METHOD_SMS)) {
									if (alertSetup.getDeliveryMethodCd() == null) {
										capdAccount.setSpendPref(NOTIFICATION_NONE);
									} else {
										capdAccount.setSpendPref(NOTIFICATION_TEXT_EMAIL);
									}
								}
							} else if (blockEmailSpend && deliveryMethods.contains(DELIVERY_METHOD_EMAIL)) {
								capdAccount.setSpendPref(NOTIFICATION_EMAIL);
								if (!blockMobileSpend && deliveryMethods.contains(DELIVERY_METHOD_SMS)) {
									if (alertSetup.getDeliveryMethodCd() == null) {
										capdAccount.setSpendPref(NOTIFICATION_NONE);
									} else {
										capdAccount.setSpendPref(NOTIFICATION_TEXT_EMAIL);
									}
								}
							} else if (!blockMobileSpend && deliveryMethods.contains(DELIVERY_METHOD_SMS)) {
								capdAccount.setSpendPref(NOTIFICATION_TEXT);
							} else if (blockEmailSpend && blockMobileSpend) {
								capdAccount.setSpendPref(NOTIFICATION_EMAIL);
								if (deliveryMethods.contains(DELIVERY_METHOD_SMS)) {
									capdAccount.setSpendPref(NOTIFICATION_NONE);
								}
							} else {
								capdAccount.setSpendPref(NOTIFICATION_NONE);
							}
						}
					}
				}
				capdAccounts.add(capdAccount);
			}
		}

		payload.setCapdAccounts(capdAccounts);
		retrieveCapdResponse.setResponsePayload(payload);
		retrieveCapdResponse.setStatus("Success");

		return retrieveCapdResponse;
	}
}