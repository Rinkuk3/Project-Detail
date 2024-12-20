package com.td.api.mbalert.request.addalertevent;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class EmailAddress {

    private String locatorUsageTypeCd;
    private String deliveryStatusCd;
    private List<LocatorText> locatorText = new ArrayList<LocatorText>();
    private AltrExtension altrExtension;
    private String text;
    private List<FeatureLocator> featureLocator = new ArrayList<FeatureLocator>();
    private String alertLocatorSequenceNum;

}
