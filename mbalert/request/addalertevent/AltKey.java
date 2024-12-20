package com.td.api.mbalert.request.addalertevent;

import lombok.Data;

@Data
public class AltKey {

    private String partyKey;
    private String partyKeyTypeCd;
    private String partyTypeCd;
    private EventMessageKey eventMessageKey;

}
