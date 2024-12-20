package com.td.api.mbalert.request.addalertevent;

import lombok.Data;

@Data
public class ContactEvent {

    private String key;
    private AltKey altKey;
    private String reasonCd;

}
