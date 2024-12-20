package com.td.mbna.msec.midtier.transfer.util;

import java.math.BigDecimal;
import java.util.Collection;

import org.springmodules.validation.valang.functions.AbstractFunction;
import org.springmodules.validation.valang.functions.Function;

import com.td.mbna.msec.midtier.persistance.entity.TtcDestinations;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.util.ConfigUtil;

/**
 * This is the web service implementation class. All it does is delegate the work for each operation
 * to an OperationImpl class, which it gets from Spring.
 * 
 *
 */
public class DepositToChequingValidator
{
	private static final String Property_MaxTransferAmount = "ttc.max.transfer.amount";
	// max transfer amount allowed
	public static final BigDecimal MaxTransferAmount;
	static {
		String sMaxTransferAmt = ConfigUtil.getProperty(Property_MaxTransferAmount);
		MaxTransferAmount = new BigDecimal(sMaxTransferAmt);
	}



	/**
	 * This class contains the validation code for total amount field used by VALANG.
	 *
	 */
    public static class ValidateTotal extends AbstractFunction {

    	/**
    	 * validate total
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
			com.td.mbna.msec.midtier.transfer.payload.deposittochequing.RequestPayload req = (com.td.mbna.msec.midtier.transfer.payload.deposittochequing.RequestPayload) getArguments()[0].getResult(target);

			BigDecimal transferTotal = TotalUtil.getDepositToChequingTotal(req);
			if (transferTotal != null && req.getCreditAvail() != null && transferTotal.compareTo(req.getCreditAvail()) < 1) {
				rc = true;
			}
			return rc;
		}
    }
    
    /**
     * This class contains the validation code for payee nickname used by VALANG.
     *
     */
    public static class IsNewPayeeNickname extends AbstractFunction {

    	/**
    	 * determine whether nickname is new
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
//	   		Collection<TtcDestinations> payeeWithNickname = DBService.findTtcDestinationsByNickname(custId, nickname);
	   		Collection<TtcDestinations> payeeWithNickname = DBMybatisService.findTtcDestinationsByNickname(custId, nickname);
	   		if (payeeWithNickname == null || payeeWithNickname.size()== 0) {
	   			rc = true;
	   		}
	   		return rc;
		}
    }
    
    /**
     * This class contains the validation code for payee nickname used by VALANG.
     *
     */
    public static class IsNewOrSamePayeeNickname extends AbstractFunction {

    	/**
    	 * determine if payee nickname is new or same
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
			String curNickname = (String) getArguments()[1].getResult(target);
			String custId = (String) getArguments()[2].getResult(target);
			boolean nicknameChanged = nickname.equals(curNickname) == false;
			if (nicknameChanged) {	// check if nickname is new
//		   		Collection<TtcDestinations> payeeWithNickname = DBService.findTtcDestinationsByNickname(custId, nickname);
		   		Collection<TtcDestinations> payeeWithNickname = DBMybatisService.findTtcDestinationsByNickname(custId, nickname);
		   		if (payeeWithNickname == null || payeeWithNickname.size()== 0) {
		   			rc = true;	// user entered new nickname
		   		}
			}
			else {
				rc = true;	// nickname remains the same
			}
	   		return rc;
		}
    }

    /**
     * This class contains the validation code for max transfer amount used by VALANG.
     *
     */
    public static class ExceedsMaxTransferAmount extends AbstractFunction {

    	/**
    	 * determine whether transfer amount exceeds max amount allowed
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