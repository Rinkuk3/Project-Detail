package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class TelephoneNumber implements Serializable {
    private String telephoneNum;
    private String countryCodeNum;
    private String extensionNum;
}
