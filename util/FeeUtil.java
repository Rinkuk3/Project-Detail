package com.td.mbna.msec.midtier.util;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.td.mbna.msec.midtier.persistance.entity.TransactionFee;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.types.common.BTOfferType;
import com.td.mbna.msec.midtier.types.common.IpCalculation;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;

/**
 * This class contains helper methods related to fees.
 *
 */
public class FeeUtil {
	
	private static final String Property_StatementFee = "statementFee";
	private static final String Property_StatementDiscountPercent = "statementDiscountPercent";
	private static BigDecimal stmtFee;
	private static BigDecimal stmtDiscountPercent;
	
	private static MbnaLogger logger = new MbnaLogger(FeeUtil.class);
	
	static {
		InputStream inProps = null;
		try {
		   stmtFee = getDecimalProperty(Property_StatementFee);
		   stmtDiscountPercent = getDecimalProperty(Property_StatementDiscountPercent);
		   
		} catch (Exception e) {
			// Tolerate exception otherwise class will not get loaded
			logger.error(e.getMessage(), e);
		}
		finally {
			if (inProps != null) {
				try {inProps.close();} catch (Exception e) {logger.error(e.getMessage(), e);}
			}
		}
	}
	
	/**
	 * get BT fee
	 */
	public static BigDecimal getBalanceTransferFee(PromotionOfferType offer, BigDecimal transferAmt) {
		if (transferAmt.compareTo(BigDecimal.ZERO) == 0) {
			return BigDecimal.ZERO;
		}
		if(offer == null){
			return BigDecimal.ZERO;			
		}
		BTOfferType btOffer = offer.getBtOffer();
		
		if(btOffer == null){
			return BigDecimal.ZERO;			
		}
		
		BigDecimal fixedFee = btOffer.getFixedFeeAmount();
		if (fixedFee != null && (btOffer.getFeePercentage() == null || btOffer.getFeePercentage().compareTo(BigDecimal.ZERO) == 0)) {
			return fixedFee;
		}
		
		BigDecimal transferRate = BigDecimal.ZERO;
		
		if (btOffer.getFeePercentage() != null) {
			transferRate = btOffer.getFeePercentage().divide(new BigDecimal(100));
		}
		
		BigDecimal calculatedFee =  transferAmt.multiply(transferRate);
		BigDecimal minFee = btOffer.getMinimumFeeAmount();
		if (minFee != null && calculatedFee.compareTo(minFee) < 0) {
			return minFee;
		} 
		return calculatedFee;
	}
	
	/**
	 * get statement fee
	 * @return
	 */
	public static BigDecimal getStatementFee() {
		return stmtFee;
	}
	
	/**
	 * get statement discount percentage
	 * @return
	 */
	public static BigDecimal getStatementDiscountPercent() {
		return stmtDiscountPercent;
	}
	
	private static BigDecimal getDecimalProperty(String propName) {
		BigDecimal value = null;
		String sValue = ConfigUtil.getProperty(propName);
		if (sValue != null) {
			 value = new BigDecimal(sValue).setScale(2, RoundingMode.HALF_EVEN);
		}
		return value;
	}
	
	public final static BigDecimal TsysNullMinValue = new BigDecimal("0.01");	// an alternate value in TSYS to signify no minimum fee
	public final static BigDecimal TsysNullMaxValue = new BigDecimal("999.99");	// an alternate value in TSYS to signify no maximum fee
	
	public static BTOfferType genBtContractOffer (String txnFeeNum, BigDecimal annualRate) throws Exception {
		TransactionFee txnFee;
		if (txnFeeNum == null || txnFeeNum.isEmpty()) {
			txnFee = new TransactionFee();
			txnFee.setFixed_amount(BigDecimal.ZERO);
			return convertToBtOffer(txnFee, annualRate);
		}
		
//		txnFee = DBService.getTransactionFee(txnFeeNum, "DOMESTIC");
		txnFee = DBMybatisService.getTransactionFee(txnFeeNum, "DOMESTIC");
		BTOfferType btContractOffer = null;
		if (txnFee != null) {
			btContractOffer = convertToBtOffer(txnFee, annualRate);
			com.mbnaweb.xsd.types.common.BTOfferType jaxbBtOfferType = JAXBJsonConverter.convertJsonToJAXBInterface(btContractOffer, com.mbnaweb.xsd.types.common.BTOfferType.class);
			OffersUtil.marshalBtOffer(jaxbBtOfferType, TsysNullMinValue, TsysNullMaxValue);
		}
		return btContractOffer;
	}
	
	public static IpCalculation calculateIpPaymentDetails(BigDecimal interestRate, BigDecimal contractAnnualRate, BigDecimal setupFee, BigDecimal transactionAmt, int duration, String offerId){
		IpCalculation ipCalculation = new IpCalculation();
		ipCalculation.setOfferId(offerId);
		ipCalculation.setDuration(duration);
		ipCalculation.setInterest(interestRate);
		ipCalculation.setSetupFees(setupFee);

		if (transactionAmt == null || interestRate == null || duration < 1){
			return ipCalculation;
		}
		
    	BigDecimal oldMonthlyPayment = BigDecimal.ZERO;
    	if(contractAnnualRate != null){
	    	if (contractAnnualRate.compareTo(BigDecimal.ZERO) == 0 ){
	    		oldMonthlyPayment = transactionAmt.divide(new BigDecimal(duration), 2, RoundingMode.UP);
	    	} else {
	        	BigDecimal oldInterest = contractAnnualRate.divide(new BigDecimal("1200"), 13, RoundingMode.HALF_UP);
	    		oldMonthlyPayment = (transactionAmt.multiply(oldInterest)).divide(BigDecimal.ONE.subtract(BigDecimal.ONE.divide(oldInterest.add(BigDecimal.ONE).pow(duration), 13, RoundingMode.HALF_UP)), 13, RoundingMode.HALF_UP).setScale(2, RoundingMode.UP);
	    	}
    	}

    	BigDecimal oldCost = oldMonthlyPayment.multiply(new BigDecimal(duration)).setScale(2, RoundingMode.HALF_UP);
    	//oldCost = transactionAmt.multiply(annualInsterestRate).multiply(new BigDecimal(duration)).divide(new BigDecimal("1200")).setScale(2, RoundingMode.HALF_UP);

    	BigDecimal monthlyPayment = BigDecimal.ZERO;
    	BigDecimal totalInterestPaid = BigDecimal.ZERO;
    	BigDecimal oneTimeTransactionFee = transactionAmt.multiply(setupFee).divide(new BigDecimal("100")).setScale(2, RoundingMode.DOWN);
    	BigDecimal totalCost = transactionAmt.add(oneTimeTransactionFee);
    	if (interestRate.compareTo(BigDecimal.ZERO) == 0 ){
    		monthlyPayment = (transactionAmt.add(oneTimeTransactionFee)).divide(new BigDecimal(duration), 5, RoundingMode.DOWN).add(new BigDecimal("0.009")).setScale(2, RoundingMode.DOWN);
    	} else {
        	BigDecimal ipInterest = interestRate.divide(new BigDecimal("1200"), 13, RoundingMode.HALF_UP);
    		monthlyPayment = ((transactionAmt.add(oneTimeTransactionFee)).multiply(ipInterest)).divide(BigDecimal.ONE.subtract(BigDecimal.ONE.divide(ipInterest.add(BigDecimal.ONE).pow(duration), 13, RoundingMode.HALF_UP)), 13, RoundingMode.HALF_UP).setScale(2, RoundingMode.UP);
    		totalCost = monthlyPayment.multiply(new BigDecimal(duration)).setScale(2, RoundingMode.HALF_UP);
    		totalInterestPaid = totalCost.subtract(transactionAmt).subtract(oneTimeTransactionFee).setScale(2, RoundingMode.HALF_UP);
    	}
    	
    	BigDecimal totalSaving = oldCost.subtract(totalCost).setScale(2, RoundingMode.HALF_UP);
    	
    	ipCalculation.setMonthlyPayment(monthlyPayment);
    	ipCalculation.setTotalInterestPaid(totalInterestPaid);
    	ipCalculation.setOneTimeTransactionFee(oneTimeTransactionFee);
    	ipCalculation.setTotalCost(totalCost);
    	ipCalculation.setTotalSaving(totalSaving);
    	
    	return ipCalculation;
	}
	
	public static BigDecimal calculateMonthlyPayment(BigDecimal transactionAmt, BigDecimal setupFee, int duration){
		BigDecimal oneTimeTransactionFee = transactionAmt.multiply(setupFee).divide(new BigDecimal("100")).setScale(2, RoundingMode.DOWN);
		BigDecimal monthlyPayment = (transactionAmt.add(oneTimeTransactionFee)).divide(new BigDecimal(duration), 5, RoundingMode.DOWN).add(new BigDecimal("0.009")).setScale(2, RoundingMode.DOWN);
		
		return monthlyPayment;
	}
	
	private static BTOfferType convertToBtOffer(TransactionFee txnFee, BigDecimal annualRate) {
		BTOfferType btOffer = new BTOfferType();
		btOffer.setFeePercentage(txnFee.getPercentage());
		btOffer.setFixedFeeAmount(txnFee.getFixed_amount());
		btOffer.setMinimumFeeAmount(txnFee.getMinimum_amount());
		btOffer.setMaximumFeeAmount(txnFee.getMaximum_amount());
		btOffer.setRate(annualRate);
		return btOffer;
	}
}