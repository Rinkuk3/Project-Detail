package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;

@Data
public class StmtActivityType implements Serializable
{
	private final static long serialVersionUID = -59662762059793742L;

    private String acctId;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long transactionDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long postingDate;
    private String postingTime;
    private String description;
    private String promotionalOfferId;
    private String referenceNumber;
    private BigDecimal amount;
    private String currencyCode;
    private String transactionType;
    private String transactionCode;
    private String merchantName;
    private String merchantCity;
    private String merchantStateProvince;
    private String cardHolderName;
    private Boolean ipEligibility;
    private String statementDataDt;
   
}
