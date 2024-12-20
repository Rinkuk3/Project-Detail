package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
    private String roleCd;
    private String startDt;
    private String endDt;
    private String key;
}
