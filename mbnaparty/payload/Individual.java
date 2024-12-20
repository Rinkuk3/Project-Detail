package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Individual implements Serializable {
    private String key;
    private String birthDt;
    private String genderCd;
    private ArrayList<PartyToPartyGroup> partyToPartyGroup;
    private ArrayList<Name> name;
    private ArrayList<Identification> identification;
    private ArrayList<Contact> contact;
    private ArrayList<IndividualToAgreement> individualToAgreement;
}
