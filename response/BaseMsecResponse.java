package com.td.mbna.msec.midtier.auditlog.payload.response;


import java.util.List;

public interface BaseMsecResponse {
    String getStatus();

    void setStatus(String status);

    List<String> getErrorMsgs();

    void setErrorMsgs(List<String> errorMsgs);

    ResponsePayload getResponsePayload();

    void setResponsePayload(ResponsePayload responsePayload);
}
