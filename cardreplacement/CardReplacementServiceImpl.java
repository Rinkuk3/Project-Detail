package com.td.mbna.msec.midtier.cardreplacement;

import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardRequest;
import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardResponse;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("midtierCardReplacementService")
public class CardReplacementServiceImpl implements CardReplacementService {
	
	@Autowired
	private ReplaceCardOperation replaceCardOperation;
	
	@Override
	@ProfileLog
	public ReplaceCardResponse replaceCard(ReplaceCardRequest replaceCardRequest, String... token) {
		return replaceCardOperation.invokeService(replaceCardRequest, token);
	}

}
