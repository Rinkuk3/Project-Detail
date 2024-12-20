package com.td.api.mbalert.request.addalertevent;

import java.util.Date;

import lombok.Data;

@Data
public class EffectiveDateTime {

    private Date effectiveDttm;
    private String timeZoneCd;

}
