package com.td.mbna.msec.midtier.util.tsys;

import com.td.mbna.msec.midtier.util.TdRequestInfo;

public enum TsysRequest implements TdRequestInfo {
	retrieveCardAccountInfo,
	retrieveCreditCardAccount,
	retrieveCreditCardAccount_customerInformation,
	requestBalanceTransfer,
	updateCardLimit,
	retrieveTransaction,
	activateCard,
	requestInsurance, 
	requestAccessCheques;
	
	
	/**
	 * all TSYS requests require a message ID
	 */
	public boolean requiresMsgId() {
		return true;
	}
}
