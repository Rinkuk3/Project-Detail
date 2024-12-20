package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class Locator implements Serializable {
    public EmailAddress emailAddress;
    public StreetAddress streetAddress;
    private TelephoneNumber telephoneNumber;
}
