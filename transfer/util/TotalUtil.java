package com.td.mbna.msec.midtier.transfer.util;

import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPaymentInfoType;
import com.td.mbna.msec.midtier.util.FeeUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * TotalUtil
 * 
 * This class provides utiltity methods to handle balance transfer related totals.
 *  
 */
public class TotalUtil {


	public static BigDecimal getDepositToChequingTotal(com.td.mbna.msec.midtier.transfer.payload.deposittochequing.RequestPayload req) {
		BigDecimal transferAmt = req.getPaymentInfo().getAmount();
		com.td.mbna.msec.midtier.types.common.PromotionOfferType offer = req.getSelectedOffer();
		BigDecimal transerFee = FeeUtil.getBalanceTransferFee(offer, transferAmt);
		BigDecimal total = transferAmt.add(transerFee);
		return total;
	}

	public static BigDecimal getDepositToChequingFee(com.td.mbna.msec.midtier.transfer.payload.deposittochequing.RequestPayload req) {
		BigDecimal transferAmt = req.getPaymentInfo().getAmount();
		com.td.mbna.msec.midtier.types.common.PromotionOfferType offer = req.getSelectedOffer();
		BigDecimal transerFee = FeeUtil.getBalanceTransferFee(offer, transferAmt);
		return transerFee;
	}

	static BigDecimal getbalanceTransferToCreditorTotal(com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.RequestPayload req) {
		BigDecimal total;
		total = getTransferAmountTotal(req).add(getTransferFeeTotal(req));
		return total;
	}

	public static BigDecimal getbalanceTransferToCreditorTotal(com.td.mbna.msec.midtier.types.common.PromotionOfferType offer, List<BalanceTransferToCreditorPaymentInfoType> payments) {
		BigDecimal total;
		total = getTransferAmountTotal(payments).add(getTransferFeeTotal(offer, payments));
		return total;
	}

	static BigDecimal getTransferFeeTotal(com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.RequestPayload req) {
		return getTransferFeeTotal(req.getSelectedOffer(), req.getPaymentInfo());
	}

	public static BigDecimal getTransferFeeTotal(com.td.mbna.msec.midtier.types.common.PromotionOfferType offer, List<BalanceTransferToCreditorPaymentInfoType> payments) {
		BigDecimal fee = BigDecimal.ZERO;
		for (BalanceTransferToCreditorPaymentInfoType payment : payments) {
			BigDecimal curFee = FeeUtil.getBalanceTransferFee(offer,payment.getAmount());
			fee = fee.add(curFee);
		}
		return fee;
	}

	static BigDecimal getTransferAmountTotal(com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.RequestPayload req) {
		return getTransferAmountTotal(req.getPaymentInfo());
	}

	public static BigDecimal getTransferAmountTotal(List<BalanceTransferToCreditorPaymentInfoType> payments) {
		BigDecimal transferAmt = BigDecimal.ZERO;
		for (BalanceTransferToCreditorPaymentInfoType payment : payments) {
			transferAmt = transferAmt.add(payment.getAmount());
		}
		return transferAmt;
	}

}