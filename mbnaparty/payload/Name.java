package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Name implements Serializable {
    private String typeCd;
    private String lastName;
    private String firstName;
    private String titlePrefix;
    private Date startDttm;
}
