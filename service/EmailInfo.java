package com.td.mbna.msec.midtier.service;

import com.td.mbna.msec.midtier.types.common.PrimaryCardMemberInfo;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public interface EmailInfo {
    String getLogonId();
    String getConnectId();
    String getCustId();
    String getAcctNum();
    String getToken();
    void setToken(String token);
    boolean isTriggerEmailNotification();
    String getBusinessEventID();
    String getPrimaryEmailAddress();
    void setPrimaryEmailAddress(String primaryEmailAddress);
    String getPrimaryLanguagePref() ;
	String getAccountFirstName();
	String getAccountLastName();
    PrimaryCardMemberInfo getPrimaryUserInfo();
    String getCardName();
    String getCardEnding();
    String getConfirmationNumber();
    List<String> getConfirmationNumbers();
    String getInitiatedBy();
    String getOldEmailAddress();
    String getStatementDeliveryPreferenceSelected();
    Object getAttribute(String key);
    void addAttribute(String key, Object value);
    Map<String, Object> getAttributes();
    <T> Consumer<T> getRetryLogic();
    <T> void setRetryLogic(Consumer<T> retry);
    default <T> void retry(T t) {
        if (getRetryLogic() != null) {
            getRetryLogic().accept(t);
        }
    };
}
