package com.td.api.mbalert.response.addalertevent;

import lombok.Data;

@Data
public class AlertEventResponse {

    private Status status;
    private Alert alert;

}
