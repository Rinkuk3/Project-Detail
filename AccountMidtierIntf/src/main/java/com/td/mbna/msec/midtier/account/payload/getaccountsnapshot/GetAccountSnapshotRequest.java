package com.td.mbna.msec.midtier.account.payload.getaccountsnapshot;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.CardHolderInfo;

public class GetAccountSnapshotRequest extends BaseRequest{

	private static final long serialVersionUID = 3248263381340512271L;
    private List<CardHolderInfo> cardHolderInfos = new ArrayList<>();
    
    public List<CardHolderInfo> getCardHolderInfos() {
        return cardHolderInfos;
    }

    public void setCardHolderInfos(List<CardHolderInfo> cardHolderInfos) {
        this.cardHolderInfos = cardHolderInfos;
    }

}
