package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Identification implements Serializable {
    private String typeCd;
    private String identificationNum;
    private String issuingTerritoryCd;
    private String issuingCountryCd;
    private Date startDttm;
}
