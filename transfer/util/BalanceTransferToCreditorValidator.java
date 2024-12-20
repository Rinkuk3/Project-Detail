package com.td.mbna.msec.midtier.transfer.util;

import java.math.BigDecimal;
import java.util.List;

import org.springmodules.validation.valang.functions.AbstractFunction;
import org.springmodules.validation.valang.functions.Function;

import com.td.mbna.msec.midtier.persistance.entity.BtDestinations;
import com.td.mbna.msec.midtier.persistance.entity.Creditors;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPayeeType;
import com.td.mbna.msec.midtier.util.ConfigUtil;

/**
 * This is the web service implementation class. All it does is delegate the work for each operation
 * to an OperationImpl class, which it gets from Spring.
 */
public class BalanceTransferToCreditorValidator
{
	private static final String Property_MaxTransferAmount = "bt.max.transfer.amount";
	// max transfer amount allowed
	public static final BigDecimal MaxTransferAmount;
	static {
		String sMaxTransferAmt = ConfigUtil.getProperty(Property_MaxTransferAmount);
		MaxTransferAmount = new BigDecimal(sMaxTransferAmt);
	}


    public static class ValidateTotal extends AbstractFunction {

    	/**
    	 *  validate total
    	 * 
    	 */
     	public ValidateTotal(Function[] arguments, int line, int column) {
	   		super(arguments, line, column);
	   		definedExactNumberOfArguments(1);
	   	}
   	
     	/**
     	 * get result
     	 */
		@Override
		protected Object doGetResult(Object target) throws Exception {
			boolean rc = false;
			com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.RequestPayload req = (com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.RequestPayload) getArguments()[0].getResult(target);
			BigDecimal transferTotal = TotalUtil.getbalanceTransferToCreditorTotal(req);
			if (transferTotal.compareTo(req.getCreditAvail()) < 1) {
				rc = true;
			}
			return rc;
		}
    }
    /**
     * 
     *
     */
    public static class ValidPayeeMerchantCardNum extends AbstractFunction {

    	/**
    	 *  validate the merchant ID and account number combination is valid
    	 * 
    	 */
     	public ValidPayeeMerchantCardNum(Function[] arguments, int line, int column) {
	   		super(arguments, line, column);
	   		definedExactNumberOfArguments(1);
	   	}
   	
     	/**
     	 * get result
     	 */
		@Override
		protected Object doGetResult(Object target) throws Exception {
			BalanceTransferToCreditorPayeeType payee = (BalanceTransferToCreditorPayeeType) getArguments()[0].getResult(target);
			return CardNumUtil.isValidMerchantCardNum(payee);
		}
    }
    
    /**
	 * This class contains the validation code for Merchant ID field used by VALANG.
	 *
	 */
    public static class ValidateMerchantId extends AbstractFunction {

    	/**
    	 *  validate merhcandid
    	 * 
    	 */
     	public ValidateMerchantId(Function[] arguments, int line, int column) {
	   		super(arguments, line, column);
	   		definedExactNumberOfArguments(1);
	   	}
   	
     	/**
     	 * get result
     	 */
		@Override
		protected Object doGetResult(Object target) throws Exception {
			boolean rc = false;
			String merchantId = (String) getArguments()[0].getResult(target);
//			Creditors creditor = DBService.getCreditorByMerchantId(merchantId);
			Creditors creditor = DBMybatisService.getCreditorByMerchantId(merchantId);
	   		if ( creditor != null) {
	   			rc = true;
	   		}
			return rc;
		}
    }
    
	/**
	 * This class contains the validation code for new payee nickname field used by VALANG.
	 *
	 */
    public static class IsNewPayeeNickname extends AbstractFunction {

    	/**
    	 *  determine whehter the payee nickname is new
    	 * 
    	 */
     	public IsNewPayeeNickname(Function[] arguments, int line, int column) {
	   		super(arguments, line, column);
	   		definedExactNumberOfArguments(2);
	   	}
   	
     	/**
     	 * get result
     	 */
		@Override
		protected Object doGetResult(Object target) throws Exception {
			boolean rc = false;
			String nickname = (String) getArguments()[0].getResult(target);
			String custId = (String) getArguments()[1].getResult(target);
//	   		Collection<BtDestinations> payeeWithNickname = DBService.findBtDestinationsByNickname(custId, nickname);
	   		List<BtDestinations> payeeWithNickname = DBMybatisService.findBtDestinationsByNickname(custId, nickname);
	   		if (payeeWithNickname == null || payeeWithNickname.size()== 0) {
	   			rc = true;
	   		}
	   		return rc;
		}
    }

    /**
     * This class provides the ability to determine whether the payee is new or existing in a BT scenario. 
     *
     */
    public static class IsNewOrSamePayeeNickname extends AbstractFunction {

    	/**
    	 *  determine whehter the payee nickname is new or same
    	 * 
    	 */
     	public IsNewOrSamePayeeNickname(Function[] arguments, int line, int column) {
	   		super(arguments, line, column);
	   		definedExactNumberOfArguments(3);
	   	}
   	
     	/**
     	 * get result
     	 */
		@Override
		protected Object doGetResult(Object target) throws Exception {
			boolean rc = false;
			String nickname = (String) getArguments()[0].getResult(target);
			String curNickname = (String) getArguments()[1].getResult(target); // nickname currently in DB
			String custId = (String) getArguments()[2].getResult(target); 
			final boolean nicknameChanged = nickname.equals(curNickname) == false;
			if (nicknameChanged) { // check if the nickname is new
//		   		Collection<BtDestinations>payeeWithNickname = DBService.findBtDestinationsByNickname(custId, nickname);
		   		List<BtDestinations>payeeWithNickname = DBMybatisService.findBtDestinationsByNickname(custId, nickname);
		   		if (payeeWithNickname == null || payeeWithNickname.size()== 0) {
		   			rc = true;	// yes it's a new nickname
		   		}
			}
			else {
				rc = true;	// nickname remains the same
			}
	   		return rc;
		}
    }
    
    /**
     * This class provides the ability to determine whether the amount to be transfered in a BT scenario exceeds the max allowed.
     */
    public static class ExceedsMaxTransferAmount extends AbstractFunction {

    	/**
    	 *  determines if the max transfer amount exceeds amount allowed
    	 * 
    	 */
     	public ExceedsMaxTransferAmount(Function[] arguments, int line, int column) {
	   		super(arguments, line, column);
	   		definedExactNumberOfArguments(1);
	   	}
   	
     	/**
     	 * get result
     	 */
		@Override
		protected Object doGetResult(Object target) throws Exception {
			boolean rc = false;
			BigDecimal transferAmt = (BigDecimal) getArguments()[0].getResult(target);
			if (transferAmt.compareTo(MaxTransferAmount) == 1) {
				rc = true;
			}
			return rc;
		}
    }
	

}