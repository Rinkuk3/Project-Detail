package com.td.mbna.msec.midtier.transfer;

import java.text.NumberFormat;
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
import com.td.mbna.msec.midtier.transfer.payload.deletedeposittochequingpayee.DeleteDepositToChequingPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.deletedeposittochequingpayee.DeleteDepositToChequingPayeeResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
/**
 * This class contains the actual implementation for the DeleteDepositToChequingPayee operation.
 * - It will invoke the deleteTtcDestination operation of the DB Service to remove the payee.
 *
 *
 */
@Component
public class DeleteDepositToChequingPayeeOperation implements MsecMidtierCommonOperations<DeleteDepositToChequingPayeeRequest, DeleteDepositToChequingPayeeResponse>
{

	private static MbnaLogger logger = new MbnaLogger(DeleteDepositToChequingPayeeOperation.class);

	public DeleteDepositToChequingPayeeResponse invokeService(DeleteDepositToChequingPayeeRequest request, String... token) {
		try {
			DeleteDepositToChequingPayeeResponse response = new DeleteDepositToChequingPayeeResponse();
			DepositToChequingPayeeType payee = request.getRequestPayload().getPayee();
	       	TtcDestinations payeeDto = new TtcDestinations();
	    	String payeeId = payee.getId();
			NumberFormat numFormat = NumberFormat.getInstance(Locale.CANADA);
	       	payeeDto.setTtcDestinationId(numFormat.parse(payeeId).intValue());
//	       	DBService.deleteTtcDestination(payeeDto);
	     	DBMybatisService.deleteTtcDestination(payeeDto);
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
