package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class StreetAddress implements Serializable {
    public String addressLine1;
    public String city;
    public String territory;
    public String postalCode;
    public String countryCd;
}
