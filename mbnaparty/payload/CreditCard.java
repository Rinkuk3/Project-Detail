package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreditCard implements Serializable {
    private String cardNum;
    private String onCardName;
    private String statusCd;
}
