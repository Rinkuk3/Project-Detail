package com.td.api.mbalert.request.addalertevent;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Alert {

    private Party party;
    private Receiver receiver;
    private Sender sender;
    private String alertTypeCd;
    private String alertCategoryTypeCd;
    private List<Contact> contact = new ArrayList<Contact>();
    private List<Condition> condition = new ArrayList<Condition>();
    private List<Document> document = new ArrayList<Document>();
    private String languageCd;
    private List<EventToEvent> eventToEvent = new ArrayList<EventToEvent>();
    private String batchJobId;
    private String draftId;
    private List<Template> template = new ArrayList<Template>();
    private AltrExtension_TemplateItem altrExtension;
    private EffectiveDateTime effectiveDateTime;
    private List<DeliveryChannelType> deliveryChannelType = new ArrayList<DeliveryChannelType>();


}
