package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class ResponsePayload implements Serializable {
    private Pagination pagination;
    private ArrayList<Individual> individual;
}
