package com.td.mbna.msec.midtier.transfer;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.persistance.entity.TtcDestinations;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.transfer.payload.DepositToChequingPayeeType;
import com.td.mbna.msec.midtier.transfer.payload.adddeposittochequingpayee.AddDepositToChequingPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.adddeposittochequingpayee.AddDepositToChequingPayeeResponse;
import com.td.mbna.msec.midtier.transfer.payload.adddeposittochequingpayee.ResponsePayload;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

@Component
public class AddDepositToChequingPayeeOperation implements MsecMidtierCommonOperations<AddDepositToChequingPayeeRequest, AddDepositToChequingPayeeResponse>
{

	@Autowired
	private ValangValidator addDepositToChequingPayeeRequestValidator;

	private MsecValidator msecValidator;

	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(addDepositToChequingPayeeRequestValidator);
	}

	private static MbnaLogger logger = new MbnaLogger(AddDepositToChequingPayeeOperation.class);

	public AddDepositToChequingPayeeResponse invokeService(AddDepositToChequingPayeeRequest request, String... strings) {

		AddDepositToChequingPayeeResponse response = new AddDepositToChequingPayeeResponse();
		if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
			return response;
		}
		DepositToChequingPayeeType payee = request.getRequestPayload().getPayee();
		if(payee == null){
			return response;
		}
		try {
			TtcDestinations payeeDto = new TtcDestinations();
			payeeDto.setCustomerId(request.getCustId());
			payeeDto.setNickname(payee.getNickName());
			payeeDto.setBankId(payee.getBankId());
			payeeDto.setTransitNum(payee.getTransitNum());
			payeeDto.setAccountNumber(payee.getAcctNum());
//			DBService.deleteTtcDestination(payeeDto);
//			DBService.saveTtcDestination(payeeDto);
			DBMybatisService.saveTtcDestination(payeeDto);
			
			ResponsePayload resPayload = new ResponsePayload();
			response.setResponsePayload(resPayload);
			response.getResponsePayload().setPayeeId(payeeDto.getTtcDestinationId());
			return response;
		} catch (Exception e) {
			logger.error("invokeService ", e.getMessage(), e);
			throw ExceptionUtil.genRuntimeException(e);
		}
    }

	public boolean requiresDisclosureConsent() {
		return false;
	}

	public String getConsentDisclosureFailedMsgCode() {
		return null;
	}

	public boolean generateAutoComment() {
		return false;
	}

	public List<String> createAutoComment(BaseRequest baseRequest, BaseResponse baseResponse) {
		return null;
	}

	public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse baseResponse) {
		return null;
	}

	public MsecValidator getValidator() {
		return msecValidator;
	}
}
