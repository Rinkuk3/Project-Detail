package com.td.mbna.msec.midtier.transfer;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.persistance.entity.TtcDestinations;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.transfer.payload.DepositToChequingPayeeType;
import com.td.mbna.msec.midtier.transfer.payload.getdeposittochequingpayees.GetDepositToChequingPayeesRequest;
import com.td.mbna.msec.midtier.transfer.payload.getdeposittochequingpayees.GetDepositToChequingPayeesResponse;
import com.td.mbna.msec.midtier.transfer.payload.getdeposittochequingpayees.ResponsePayload;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;

@Component
public class GetDepositToChequingPayeesOperation implements MsecMidtierCommonOperations<GetDepositToChequingPayeesRequest, GetDepositToChequingPayeesResponse>
{
	public GetDepositToChequingPayeesResponse invokeService(GetDepositToChequingPayeesRequest request, String... token)
	{
		GetDepositToChequingPayeesResponse response = new GetDepositToChequingPayeesResponse();
		ResponsePayload payload = new ResponsePayload();
    	response.setResponsePayload(payload);
    	
    	List<DepositToChequingPayeeType> payees = payload.getPayee();
	    String custId = request.getCustId();
//	    Collection<TtcDestinations> payeeDtos = DBService.findTtcDestinationsByCustomer(custId);
	    Collection<TtcDestinations> payeeDtos = DBMybatisService.findTtcDestinationsByCustomer(custId);
	    if (payeeDtos ==null) {
	    	return response;
	    }
	    
	    for (TtcDestinations payeeDto : payeeDtos) {
	    	DepositToChequingPayeeType payee = new DepositToChequingPayeeType();
	    	payee.setId(payeeDto.getTtcDestinationId().toString());
	    	payee.setNickName(payeeDto.getNickname());
	    	payee.setBankId(String.format(Locale.CANADA,"%03d",Integer.parseInt(payeeDto.getBankId())));
	    	payee.setTransitNum(String.format(Locale.CANADA,"%05d",Integer.parseInt(payeeDto.getTransitNum())));
	    	payee.setAcctNum(payeeDto.getAccountNumber());
	    	payees.add(payee);
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
