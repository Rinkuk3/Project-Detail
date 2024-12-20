package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class IndividualToAgreement implements Serializable {
    private CreditCardAgreement creditCardAgreement;
    private ArrayList<Role> role;
}
