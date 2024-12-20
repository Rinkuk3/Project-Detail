package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactResponse implements Serializable {
    private ResponsePayloadContact responsePayloadContact;
    private Boolean status;
}
