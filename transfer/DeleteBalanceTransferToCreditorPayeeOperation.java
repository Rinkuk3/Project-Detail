package com.td.mbna.msec.midtier.transfer;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.persistance.entity.BtDestinations;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPayeeType;
import com.td.mbna.msec.midtier.transfer.payload.deletebalancetransfertocreditorpayee.DeleteBalanceTransferToCreditorPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.deletebalancetransfertocreditorpayee.DeleteBalanceTransferToCreditorPayeeResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

@Component
public class DeleteBalanceTransferToCreditorPayeeOperation implements MsecMidtierCommonOperations<DeleteBalanceTransferToCreditorPayeeRequest,DeleteBalanceTransferToCreditorPayeeResponse>
{
	
	private static MbnaLogger logger = new MbnaLogger(DeleteBalanceTransferToCreditorPayeeOperation.class);

	public DeleteBalanceTransferToCreditorPayeeResponse invokeService(DeleteBalanceTransferToCreditorPayeeRequest request, String... token) {
		
    	try {
			DeleteBalanceTransferToCreditorPayeeResponse response = new DeleteBalanceTransferToCreditorPayeeResponse();
			BalanceTransferToCreditorPayeeType payee = request.getRequestPayload().getPayee();
	       	BtDestinations payeeDto = new BtDestinations();
	    	String payeeId = payee.getId();
			NumberFormat numFormat = NumberFormat.getInstance(Locale.CANADA);
	       	payeeDto.setBtDestinationId(numFormat.parse(payeeId).intValue());
//	       	DBService.deleteBtDestination(payeeDto);
	     	DBMybatisService.deleteBtDestination(payeeDto);
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
		return null;
	}
}
