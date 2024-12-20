package com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.td.mbna.msec.midtier.statement.payload.InsertListType;
import com.td.mbna.msec.midtier.types.common.CardHolderInfo;

@Data
public class RequestPayload implements Serializable
{
	private final static long serialVersionUID = 3724837930390689618L;
	
    private String statementClosingDate;
    private String statementPaymentDueDate;
    private Boolean withAvailableList;
    private InsertListType insertIdList;
    private List<CardHolderInfo> cardHolderInfos = new ArrayList<>();

}
