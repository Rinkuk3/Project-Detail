package com.td.api.mbalert.request.addalertevent;

import java.util.Date;

import lombok.Data;

@Data
public class ExpiryDateTime {

    private Date expiryDttm;
    private String timeZoneCd;
}
