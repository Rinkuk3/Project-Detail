package com.td.api.mbalert.request.addalertevent;

import lombok.Data;

@Data
public class EventMessageKey {

    private String contactMessageId;
    private String caseId;
    private String draftId;
}
