package com.td.api.mbalert.request.addalertevent;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TelephoneNumber {

    private String locatorUsageTypeCd;
    private String deliveryStatusCd;
    private List<LocatorText> locatorText = new ArrayList<LocatorText>();
    private AltrExtension altrExtension;
    private String telephoneNum;
    private String shortNum;
    private String countryCodeNum;
    private String areaCodeNum;
    private List<FeatureLocator> featureLocator = new ArrayList<FeatureLocator>();
    private String mobileCountryCd;
    private String mobileNetworkCd;
    private String alertLocatorSequenceNum;

   
}
