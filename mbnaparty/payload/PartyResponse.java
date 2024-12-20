package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class PartyResponse implements Serializable {
    private ResponsePayload responsePayload;
}
