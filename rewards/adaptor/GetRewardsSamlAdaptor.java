package com.td.mbna.msec.midtier.rewards.adaptor;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.td.api.rewards.request.getrewardssaml.Parameters;
import com.td.api.rewards.request.getrewardssaml.RewardsSamlRequest;
import com.td.api.rewards.response.getrewardssaml.RewardsSamlResponse;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;

@Service
public class GetRewardsSamlAdaptor extends MbnaRewardsAdaptor {

    private static MbnaLogger logger = new MbnaLogger(GetRewardsSamlAdaptor.class);
    
    public GetRewardsSamlResponse getResponse(RewardsSamlResponse rsr, String timestamp) {
    	timestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now());
    	
		GetRewardsSamlResponse response = new GetRewardsSamlResponse();
        
        if (rsr != null && rsr.getSsoToken() != null){
        	response.getResponsePayload().setSsoSaml(convertSamlResponse(rsr.getSsoToken(), timestamp));
        } else {
        	response.getResponsePayload().setSsoSaml(null);
        }

        return response;
    }

	private String convertSamlResponse(String encodedSamlAssertion, String timestamp) {
		if (encodedSamlAssertion == null || encodedSamlAssertion.length() == 0) {
			return null;
		}
		
		try{
			String decodedAssertion = new String(Base64.getDecoder().decode(encodedSamlAssertion));
			String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			
			int pos = 0;
			if (decodedAssertion.indexOf("<?xml") >= 0) {
				pos = decodedAssertion.indexOf("?>") +2;
				xmlHeader = decodedAssertion.substring(0, pos);
			}
			
			String xmlAssertion = decodedAssertion.substring(pos);
			
			StringBuffer sb = new StringBuffer();
			sb.append(xmlHeader)
			.append("<samlp:Response Destination=\"https://onlinerewards.mbna.ca/ssologin2.htm\" IssueInstant=\"")
			.append(timestamp)
			.append("\" Version=\"2.0\" xmlns:samlp=\"urn:oasis:names:tc:SAML:2.0:protocol\">")
			.append("<saml2:Issuer Format=\"urn:oasis:names:tc:SAML:2.0:nameid-format:entity\" xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\">CSSP</saml2:Issuer>")
			.append("<samlp:Status><samlp:StatusCode Value=\"urn:oasis:names:tc:SAML:2.0:status:Success\" /></samlp:Status>")
			.append(xmlAssertion)
			.append("</samlp:Response>");

			return Base64.getEncoder().encodeToString(sb.toString().getBytes("UTF-8"));
		} catch (Exception e){
			logger.error("convertSamlResponse():", encodedSamlAssertion, e);
			return null;
		}
	}

    public RewardsSamlRequest getRequest(GetRewardsSamlRequest getRewardsSamlRequest) {
    	Parameters parameters = new Parameters();
    	parameters.setAccountId(getRewardsSamlRequest.getAcctNum());
    	parameters.setSubject(CHANNEL_PARAMETERS);
    	parameters.setLocale(getRewardsSamlRequest.getLanguagePref().toUpperCase());
    	
    	RewardsSamlRequest request = new RewardsSamlRequest();
    	request.setParameters(parameters);
    	request.setPingConnectionID(PING_CONNECT);
        return request;
    }

	public GetRewardsSamlResponse getResponse(RewardsSamlResponse rsr) {
		GetRewardsSamlResponse response = new GetRewardsSamlResponse();
        
        if (rsr != null && rsr.getSsoToken() != null){
        	response.getResponsePayload().setSsoSaml(rsr.getSsoToken());
        } else {
        	response.getResponsePayload().setSsoSaml(null);
        }

        return response;
	}

}
