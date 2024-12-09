package com.td.mbna.msec.midtier.creditcard;

import com.td.mbna.msec.midtier.creditcard.payload.decreasecardlimit.DecreaseCardLimitRequest;
import com.td.mbna.msec.midtier.creditcard.payload.decreasecardlimit.DecreaseCardLimitResponse;
import com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit.IncreaseCardLimitRequest;
import com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit.IncreaseCardLimitResponse;
import com.td.mbna.msec.midtier.creditcard.payload.requestcheque.RequestChequeRequest;
import com.td.mbna.msec.midtier.creditcard.payload.requestcheque.RequestChequeResponse;

public interface CreditCardService {
	public RequestChequeResponse requestCheque(RequestChequeRequest requestChequeRequest);
	
	// not used
	//public RetrieveCardLimitResponse retrieveCardLimit(RetrieveCardLimitRequest retrieveCardLimitRequest);
	
	public IncreaseCardLimitResponse increaseCardLimit(IncreaseCardLimitRequest increaseCardLimitRequest, String... token);
	
	public DecreaseCardLimitResponse decreaseCardLimit(DecreaseCardLimitRequest decreaseCardLimitRequest, String... token);
}
