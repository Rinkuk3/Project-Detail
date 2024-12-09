package com.td.mbna.msec.midtier.cardreplacement;

import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardRequest;
import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardResponse;


public interface CardReplacementService {
	
	public ReplaceCardResponse replaceCard(ReplaceCardRequest replaceCardRequest, String... token);

}
