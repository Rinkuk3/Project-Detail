package com.td.api.mbalert.request.addalertevent;

import lombok.Data;

@Data
public class EventToEvent {

    private ContactEvent contactEvent;
    private String roleCd;

}
