package com.td.api.mbalert.request.addalertevent;

import lombok.Data;

@Data
public class DeliveryChannelType {

    private String typeCd;
    private ExpiryDateTime expiryDateTime;

}
