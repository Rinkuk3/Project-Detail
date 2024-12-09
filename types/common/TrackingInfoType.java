package com.td.mbna.msec.midtier.types.common;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TrackingInfoType implements Serializable {

	private static final long serialVersionUID = -2730169030348572683L;
    private String connectId;
    private String loginId;
    private String token;
    @NotNull
    @NotBlank(message = "can not be null or blank")
    private String sessionId;
    private String ipAddr;
    private String clientAction;
    private String firstName;
    private String lastName;

    public String getConnectId() {
        return connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getClientAction() {
        return clientAction;
    }

    public void setClientAction(String clientAction) {
        this.clientAction = clientAction;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
