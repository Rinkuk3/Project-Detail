package com.td.api.mbalert.request.addalertevent;

import lombok.Data;

@Data
public class DoNotDisturbFeatureLocator {

    private String locatorSubtypeCd;
    private String fromTimePeriodTm;
    private String toTimePeriodTm;
    private String timeZoneCd;

}
