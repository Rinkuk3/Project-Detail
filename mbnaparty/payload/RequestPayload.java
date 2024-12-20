package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class RequestPayload implements Serializable {
    /*private ArrangementEvent arrangementEvent;
    private EventChannel eventChannel;*/
    private String connectionId;
    private String cardNumber;
    private String cardholderName;
    private String cvc;
    private String cardExpiryDt;
    private String motherMaidenName;
    private String dateOfBirth;
    private String telephoneNo;
    private BigDecimal lastPaymentAmount;
}
