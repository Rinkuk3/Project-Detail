package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
@Data
public class ResponsePayloadContact implements Serializable {
    private ArrayList<Contact> contact;
}
