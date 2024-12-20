package com.td.mbna.msec.midtier.transfer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.persistance.entity.BtDestinations;
import com.td.mbna.msec.midtier.persistance.entity.Creditors;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPayeeType;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorpayees.GetBalanceTransferToCreditorPayeesRequest;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorpayees.GetBalanceTransferToCreditorPayeesResponse;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorpayees.ResponsePayload;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;

@Component
public class GetBalanceTransferToCreditorPayeesOperation implements MsecMidtierCommonOperations<GetBalanceTransferToCreditorPayeesRequest, GetBalanceTransferToCreditorPayeesResponse>
{
	private static MbnaLogger logger = new MbnaLogger(GetBalanceTransferToCreditorPayeesOperation.class);

	public GetBalanceTransferToCreditorPayeesResponse invokeService(GetBalanceTransferToCreditorPayeesRequest request, String... token)
	{
		GetBalanceTransferToCreditorPayeesResponse response = new GetBalanceTransferToCreditorPayeesResponse();
		ResponsePayload payload = new ResponsePayload();
    	response.setResponsePayload(payload);
    	List<BalanceTransferToCreditorPayeeType> payees = payload.getPayee();
	    String custId = request.getCustId();
//	    Collection<BtDestinations> payeeDtos = DBService.findBtDestinationsByCustomerId(custId);
	    List<BtDestinations> payeeDtos = DBMybatisService.findBtDestinationsByCustomerId(custId);
	    if (payeeDtos!=null) {
		    for (BtDestinations payeeDto : payeeDtos) {
				BalanceTransferToCreditorPayeeType payee = new BalanceTransferToCreditorPayeeType();
		    	payee.setId(payeeDto.getBtDestinationId().toString());
		    	payee.setNickName(payeeDto.getNickname());
//		    	Creditors creditor = DBService.getCreditorById(payeeDto.getCreditorId());
		    	Creditors creditor = DBMybatisService.getCreditorById(payeeDto.getCreditorId());
		    	if (creditor == null) {
		    		//if we can't get the creditor from the database of this saved payee, just skip this saved payee
		    		logger.info("SSMT003: customer attempted to perform balance transfer with an invalid creditor.  The creditor file needs to be synchronized with backend:  merchantId= " + payeeDto.getCreditorId());
		    		continue;
		    	}
		    	payee.setCardIssuerName(creditor.getName_EN());
		    	payee.setMerchantId(creditor.getMerchantId());
		    	payee.setCardNum(payeeDto.getAccountNumber());
		    	payees.add(payee);
		    }
	    }
	    return response;
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
