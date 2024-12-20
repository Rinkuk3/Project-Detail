package com.td.mbna.msec.midtier.transfer;

import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.persistance.entity.BtDestinations;
import com.td.mbna.msec.midtier.persistance.entity.Creditors;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPayeeType;
import com.td.mbna.msec.midtier.transfer.payload.addbalancetransfertocreditorpayee.AddBalanceTransferToCreditorPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.addbalancetransfertocreditorpayee.AddBalanceTransferToCreditorPayeeResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Component
public class AddBalanceTransferToCreditorPayeeOperation implements MsecMidtierCommonOperations<AddBalanceTransferToCreditorPayeeRequest, AddBalanceTransferToCreditorPayeeResponse>
{
	@Autowired
	private ValangValidator addBalanceTransferToCreditorPayeeRequestValidator;
	private MsecValidator msecValidator;

	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(addBalanceTransferToCreditorPayeeRequestValidator);
	}
	private static final String Property_MaxTransferAmount = "bt.max.transfer.amount";
	// max transfer amount allowed
	public static final BigDecimal MaxTransferAmount;
	static {
		String sMaxTransferAmt = ConfigUtil.getProperty(Property_MaxTransferAmount);
		MaxTransferAmount = new BigDecimal(sMaxTransferAmt);
	}

	private static MbnaLogger logger = new MbnaLogger(AddBalanceTransferToCreditorPayeeOperation.class);

	public AddBalanceTransferToCreditorPayeeResponse invokeService(AddBalanceTransferToCreditorPayeeRequest request, String... token) {
		
		AddBalanceTransferToCreditorPayeeResponse response = new AddBalanceTransferToCreditorPayeeResponse();
		
		if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
			// validate only
			return response;
		}
		
		try {
			
			BalanceTransferToCreditorPayeeType payee = request.getRequestPayload().getPayee();
//			Creditors creditor = DBService.getCreditorByMerchantId(payee.getMerchantId());
			Creditors creditor = DBMybatisService.getCreditorByMerchantId(payee.getMerchantId());
			
			BtDestinations payeeDto = new BtDestinations();
			
			payeeDto.setCustomerId(request.getCustId());
			payeeDto.setNickname(payee.getNickName());
			payeeDto.setCreditorId(creditor.getCreditorId());
			payeeDto.setAccountNumber(payee.getCardNum());			
//			DBService.saveBtDestination(payeeDto);
			DBMybatisService.saveBtDestination(payeeDto);
			
			response.getResponsePayload().setStatus(true);
			return response;
			
		} catch (Exception e) {
			String desc = "BT Step 2:1 - save Payee: oracle database save payee failed "+e.getMessage();
			logger.error("invokeService", desc, e);
			throw ExceptionUtil.genBusinessException(desc);
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
