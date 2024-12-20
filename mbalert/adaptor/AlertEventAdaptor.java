package com.td.mbna.msec.midtier.mbalert.adaptor;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.td.api.mbalert.request.addalertevent.AgreementIdentifier;
import com.td.api.mbalert.request.addalertevent.Alert;
import com.td.api.mbalert.request.addalertevent.AlertEventRequest;
import com.td.api.mbalert.request.addalertevent.AltrExtension_BankControl;
import com.td.api.mbalert.request.addalertevent.AltrExtension_TemplateItem;
import com.td.api.mbalert.request.addalertevent.Condition;
import com.td.api.mbalert.request.addalertevent.Contact;
import com.td.api.mbalert.request.addalertevent.EmailAddress;
import com.td.api.mbalert.request.addalertevent.Identifier;
import com.td.api.mbalert.request.addalertevent.Individual;
import com.td.api.mbalert.request.addalertevent.InternalPartyIdentification;
import com.td.api.mbalert.request.addalertevent.Locator;
import com.td.api.mbalert.request.addalertevent.Party;
import com.td.api.mbalert.request.addalertevent.TemplateItem;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.services.IMBNAConstants;

@Service
public class AlertEventAdaptor {
	
	private static final String PARTY_TYPE_CD_PERSON = "P";
	private static final String TYPE_CD_CODS_ID = "CODS_ID";
	private static final String LOCATOR_USAGE_TYPE_CD_EMAIL = "EMAIL";
	private static final String AGREEMENT_TYPE_CD_MBNAACCTID = "MBNAACCTID";
	private static final String HOST_SYSTEM_MSEC = "MSEC";
	
    public AlertEventRequest getRequest(EmailInfo emailInfo) {
    	Alert alert = new Alert();
		alert.setDocument(null);
		alert.setEventToEvent(null);
		alert.setTemplate(null);
		alert.setDeliveryChannelType(null);

    	alert.setAlertTypeCd(emailInfo.getBusinessEventID());
    	alert.setLanguageCd(getLanguageCd(emailInfo));
    	
    	Party party = new Party();
    	party.setPartyTypeCd(PARTY_TYPE_CD_PERSON);
    	party.setPartyGroup(null);
    	
    	Individual individual = new Individual();
    	individual.setFirstName(emailInfo.getPrimaryUserInfo().getFirstName());//.getAccountFirstName());
    	individual.setLastName(emailInfo.getPrimaryUserInfo().getLastName());//.getAccountLastName());
    	party.setIndividual(individual);
    	
    	InternalPartyIdentification internalPartyIdentification = new InternalPartyIdentification();
    	internalPartyIdentification.setTypeCd(TYPE_CD_CODS_ID);
    	internalPartyIdentification.setPartyId(emailInfo.getCustId());
    	party.getInternalPartyIdentification().add(internalPartyIdentification);
    	
    	alert.setParty(party);

    	EmailAddress emailAddress = new EmailAddress();    	
    	emailAddress.setLocatorUsageTypeCd(LOCATOR_USAGE_TYPE_CD_EMAIL);
    	emailAddress.setText(emailInfo.getPrimaryEmailAddress());
    	emailAddress.setLocatorText(null);
    	emailAddress.setFeatureLocator(null);
    	
    	Locator locator = new Locator();
    	locator.setEmailAddress(emailAddress);
    	Contact contact = new Contact();
    	contact.getLocator().add(locator);
    	alert.getContact().add(contact);
    	
    	AltrExtension_BankControl altrExtension4 = new AltrExtension_BankControl();
    	altrExtension4.setHostSystemId(HOST_SYSTEM_MSEC);
    	AgreementIdentifier agreementIdentifier = new AgreementIdentifier();
    	agreementIdentifier.setAgreementTypeCd(AGREEMENT_TYPE_CD_MBNAACCTID);
    	agreementIdentifier.setAgreementNum(emailInfo.getAcctNum());
    	agreementIdentifier.setAltrExtension(altrExtension4);
    	Identifier identifier = new Identifier();
    	identifier.setAgreementIdentifier(agreementIdentifier);
    	Condition condition = new Condition();
    	condition.getIdentifier().add(identifier);
    	alert.getCondition().add(condition);
    	
    	AltrExtension_TemplateItem altrExtension6 = new AltrExtension_TemplateItem();
    	altrExtension6.getTemplate().add(this.genEncodedTemplate(emailInfo.getAttributes()));    	
    	alert.setAltrExtension(altrExtension6);

    	AlertEventRequest request = new AlertEventRequest();
    	request.setAlert(alert);

        return request;
    }

    private TemplateItem genEncodedTemplate(Map<String, Object> attributes) {
    	Map<String, Object> obj = new HashMap<>();
    	obj.put("templateParameters", attributes);
    	
		Gson gson = new GsonBuilder()
		.serializeNulls()
		.setPrettyPrinting()
		.create();

		String objStr = gson.toJson(obj);
		String keyVal = Base64.getEncoder().encodeToString(objStr.getBytes(Charset.forName("UTF-8")));

		TemplateItem template = new TemplateItem();
    	template.setKeyName("metaDataContentVal");
    	template.setKeyVal(keyVal);
    	
    	return template;
    	
    }

    private String getLanguageCd(EmailInfo emailInfo){
    	String langCd = "EN";
    	if (emailInfo != null && IMBNAConstants.LANG_FRENCH.equalsIgnoreCase(emailInfo.getPrimaryLanguagePref())){
    		langCd = "FR";
    	}
    	return langCd;
    }

}
