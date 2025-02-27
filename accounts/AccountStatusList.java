package com.td.api.mbcca.response.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountStatusList {

    @JsonProperty(namespace = "accountStatus")
    private List<Accountstatus> accountStatus;

    public List<Accountstatus> getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(List<Accountstatus> accountStatus) {
        this.accountStatus = accountStatus;
    }
}
