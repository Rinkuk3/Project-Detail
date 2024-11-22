package com.td.mbna.msec.midtier.account;

import com.td.api.kms.request.*;
import com.td.api.kms.response.AddEncryptionJobRs;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlResponse;
import com.td.mbna.msec.midtier.rewards.MbnaRewards;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class GetRewardsSamlOperation implements MsecMidtierCommonOperations<GetRewardsSamlRequest, GetRewardsSamlResponse> {

    private static MbnaLogger logger = new MbnaLogger(GetRewardsSamlOperation.class);

    @Autowired
    private MbnaRewards mbnaRewards;

    @Autowired
    private TDRestServiceUtil tdRestServiceUtil;

    @Override
    public GetRewardsSamlResponse invokeService(GetRewardsSamlRequest request, String... token) {

		try {
			//encrypt accountId
			String accountId = request.getAcctNum();
			if (accountId != null ) {
				String base64AccountId = Base64.getEncoder().encodeToString(accountId.getBytes("UTF-8"));
				AddEncryptionJobRq addEncryptionJobRq = createEncryptRequest(base64AccountId);
				AddEncryptionJobRs addEncryptionJobRs = tdRestServiceUtil.invokeRestService(BackEndSrvcUtil.TDOperation.TdKeyManagementService_encrypt, addEncryptionJobRq, AddEncryptionJobRs.class, token[0]);
				if (addEncryptionJobRs != null && addEncryptionJobRs.getCipherData() != null) {
					request.setAcctNum(addEncryptionJobRs.getCipherData().getCipherTxt());
				}
			}
			GetRewardsSamlResponse getRewardsSamlResponse = mbnaRewards.getRewardsSaml(request, token[0]);
//			encrypt the SAML assertion			
//			if (getRewardsSamlResponse != null && getRewardsSamlResponse.getResponsePayload() != null) {
//				String ssoToken = getRewardsSamlResponse.getResponsePayload().getSsoSaml();
//				if (ssoToken != null ) {
//					AddEncryptionJobRq addEncryptionJobRq = createEncryptRequest(ssoToken);
//					AddEncryptionJobRs addEncryptionJobRs = tdRestServiceUtil.invokeRestService(BackEndSrvcUtil.TDOperation.TdKeyManagementService_encrypt, addEncryptionJobRq, AddEncryptionJobRs.class, token[0]);
//					if (addEncryptionJobRs != null && addEncryptionJobRs.getCipherData() != null) {
//						getRewardsSamlResponse.getResponsePayload().setSsoSaml(addEncryptionJobRs.getCipherData().getCipherTxt());
//					}
//				}
//			}
			
			return getRewardsSamlResponse;
		} catch (Exception e) {
			logger.error("GetRewardsSamlOperation", "invokeService", e);
			return new GetRewardsSamlResponse(); 
		}

    }

	private AddEncryptionJobRq createEncryptRequest(String ssoToken) {
		
		AddEncryptionJobRq cryptionRequest = new AddEncryptionJobRq();
		
		EncryptionEvent encryptionEvent = new EncryptionEvent();
		
		//party
		Party party = new Party();
	    List<String> roleCd = new ArrayList<String>();
	    roleCd.add("MSEC");
	    List<Name> name = new ArrayList<Name>();
	    Name nameOne = new Name();
	    nameOne.setFullName("TLPSSO");
	    name.add(nameOne);
		party.setRoleCd(roleCd);
		party.setName(name);
		encryptionEvent.setParty(party);
		
		//encryptionMethodCd
		encryptionEvent.setEncryptionMethodCd("RSA");
		
		//cryptographyKey
		List<CryptographyKey> cryptographyKeyList = new ArrayList<CryptographyKey>();
		CryptographyKey cryptographyKeyOne = new CryptographyKey();
		cryptographyKeyOne.setTypeName("Public Key");
		cryptographyKeyOne.setKeyId("ATM.CARD.TSYS.TLP.PUB.RSA2048.2022");
		cryptographyKeyList.add(cryptographyKeyOne);
		encryptionEvent.setCryptographyKey(cryptographyKeyList);
		
		//data
		Data data = new Data();
		data.setEncodingSchemeTypeCd("Base64Binary");
		data.setPlainTxt(ssoToken);
		encryptionEvent.setData(data);
		
		cryptionRequest.setEncryptionEvent(encryptionEvent);
		return cryptionRequest;
		
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