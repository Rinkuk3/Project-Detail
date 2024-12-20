package com.td.mbna.msec.midtier.disclosure;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.disclosure.payload.consentdisclosure.ConsentDisclosureResponse;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;

@Service
public class ConsentDisclosureOperation	implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.disclosure.payload.consentdisclosure.ConsentDisclosureRequest, ConsentDisclosureResponse> {

	@Autowired
	private ValangValidator consentDisclosureRequestValidator;
	
	private static final String EAA_DOCUMENT_TYPE_ID = TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_DSCFG_EAA1);
	private MsecValidator msecValidator;

	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(consentDisclosureRequestValidator);
	}

	@Override
	public ConsentDisclosureResponse invokeService(com.td.mbna.msec.midtier.disclosure.payload.consentdisclosure.ConsentDisclosureRequest request,	String... token) {

		ConsentDisclosureResponse response = new ConsentDisclosureResponse();
		if(request ==  null){
			return response;
		}
		String customerId = request.getCustId();
		
		response.setStatus("Success");

		DisclosureInfoType disc = null;
		List<DisclosureInfoType> types = request.getRequestPayload().getDisclosureInfo();
		
		if(types ==  null){
			return response;
		}
		// loop through the disclosureInfo list and find the disclosure for
		// EAA.. We don't care about the preconsent disclosure
		for (DisclosureInfoType info : types) {
			if (info != null && EAA_DOCUMENT_TYPE_ID.equalsIgnoreCase(info.getDisclosureDocTypeId())) {
				disc = info;
				break;
			}
		}
		
		if(disc ==  null){
			return response;
		}
		
		Date eAAPublishedDateAccepted= JAXBJsonConverter.convert(disc.getDisclosureDocPublishedDate()).toGregorianCalendar().getTime();

//		DBService.logEAAPublishedDateAccepted(customerId, eAAPublishedDateAccepted);
		DBMybatisService.logEAAPublishedDateAccepted(customerId, eAAPublishedDateAccepted);
		return response;
	}



	@Override
	public boolean requiresDisclosureConsent() {
		return true;
	}

	@Override
	public String getConsentDisclosureFailedMsgCode() {
		return "MS525";
	}

	@Override
	public boolean generateAutoComment() {
		return false;
	}

	@Override
	public List<String> createAutoComment(BaseRequest request,	BaseResponse response) {
		String header = CustomerNotesUtil.getHeaderContent(request,	"EAA Splash");
		StringBuilder strBuffer = new StringBuilder();
		strBuffer.append(header);
		strBuffer.append("Presented and Accepted");
		return Arrays.asList(new String[] { strBuffer.toString() });
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