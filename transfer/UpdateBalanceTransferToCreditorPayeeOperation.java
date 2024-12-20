package com.td.mbna.msec.midtier.transfer;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.persistance.entity.BtDestinations;
import com.td.mbna.msec.midtier.persistance.entity.Creditors;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPayeeType;
import com.td.mbna.msec.midtier.transfer.payload.updatebalancetransfertocreditorpayee.UpdateBalanceTransferToCreditorPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.updatebalancetransfertocreditorpayee.UpdateBalanceTransferToCreditorPayeeResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

@Component
public class UpdateBalanceTransferToCreditorPayeeOperation implements MsecMidtierCommonOperations<UpdateBalanceTransferToCreditorPayeeRequest, UpdateBalanceTransferToCreditorPayeeResponse>
{

	@Autowired
	private ValangValidator updateBalanceTransferToCreditorPayeeRequestValidator;
	private MsecValidator msecValidator;

	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(updateBalanceTransferToCreditorPayeeRequestValidator);
	}

	private static MbnaLogger logger = new MbnaLogger(UpdateBalanceTransferToCreditorPayeeOperation.class);

	public UpdateBalanceTransferToCreditorPayeeResponse invokeService(UpdateBalanceTransferToCreditorPayeeRequest jsonRequest, String... token)
	{
		UpdateBalanceTransferToCreditorPayeeResponse response = new UpdateBalanceTransferToCreditorPayeeResponse();
		BalanceTransferToCreditorPayeeType payee = jsonRequest.getRequestPayload().getPayee();
		if(payee == null){
			return response;
		}
    	try {
    		
//			Creditors creditor = DBService.getCreditorByMerchantId(payee.getMerchantId());
			Creditors creditor = DBMybatisService.getCreditorByMerchantId(payee.getMerchantId());
			
	    	BtDestinations payeeDto = new BtDestinations();
	    	String payeeId = payee.getId();
			NumberFormat numFormat = NumberFormat.getInstance(Locale.CANADA);
	       	payeeDto.setBtDestinationId(numFormat.parse(payeeId).intValue());
	    	payeeDto.setCustomerId(jsonRequest.getCustId());
	    	payeeDto.setNickname(payee.getNickName());
	    	payeeDto.setCreditorId(creditor.getCreditorId());
	    	payeeDto.setAccountNumber(payee.getCardNum());
//	    	DBService.updateBtDestination(payeeDto);
	       	DBMybatisService.updateBtDestination(payeeDto);
	       	
	       	return response;
	       	
    	} catch (Exception e) {
			logger.error("invokeService ", e.getMessage(), e);
			throw ExceptionUtil.genRuntimeException(e);
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
		return msecValidator;
	}
}
