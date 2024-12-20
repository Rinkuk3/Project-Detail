package com.td.api.mbalert.request.addalertevent;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Sender {

    private List<InternalPartyIdentification> internalPartyIdentification = new ArrayList<InternalPartyIdentification>();
    private String partyTypeCd;
    private Individual individual;
    private List<PartyGroup> partyGroup = new ArrayList<PartyGroup>();
    private String roleCd;
}
