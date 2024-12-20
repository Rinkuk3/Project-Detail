package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class PartyToPartyGroup implements Serializable {
    private String partyGroupCd;
    private Date startDttm;
}
