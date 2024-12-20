package com.td.api.mbalert.request.addalertevent;

import lombok.Data;

@Data
public class Locator {

    private EmailAddress emailAddress;
    private TelephoneNumber telephoneNumber;
    private SecureMessageBox secureMessageBox;
    private MobilePush mobilePush;

}
