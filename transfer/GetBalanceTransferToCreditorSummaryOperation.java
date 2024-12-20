package com.td.mbna.msec.midtier.transfer;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPaymentInfoType;
import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorSummaryType;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorsummary.GetBalanceTransferToCreditorSummaryRequest;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorsummary.GetBalanceTransferToCreditorSummaryResponse;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorsummary.ResponsePayload;
import com.td.mbna.msec.midtier.transfer.util.TotalUtil;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;

@Component
public class GetBalanceTransferToCreditorSummaryOperation {

	public GetBalanceTransferToCreditorSummaryResponse invokeService(GetBalanceTransferToCreditorSummaryRequest request, String... token){
		
		GetBalanceTransferToCreditorSummaryResponse response = new GetBalanceTransferToCreditorSummaryResponse();
		ResponsePayload payload = new ResponsePayload();
		response.setResponsePayload(payload);
		
		PromotionOfferType offer = request.getRequestPayload().getSelectedOffer();
    	List<BalanceTransferToCreditorPaymentInfoType> payments = request.getRequestPayload().getPaymentInfo();
    	BigDecimal creditRemaining = request.getRequestPayload().getCurrentCreditRemaining();
    	
    	BalanceTransferToCreditorSummaryType summary = new BalanceTransferToCreditorSummaryType();
    	summary.setTransferAmt(TotalUtil.getTransferAmountTotal(payments));
    	summary.setTransferFee(TotalUtil.getTransferFeeTotal(offer, payments));
    	BigDecimal newCreditRemaining = creditRemaining.subtract(TotalUtil.getbalanceTransferToCreditorTotal(offer,payments));
    	summary.setCreditRemaining(newCreditRemaining);
    	
    	payload.setSummary(summary);
    	
    	return response;
	}

}
