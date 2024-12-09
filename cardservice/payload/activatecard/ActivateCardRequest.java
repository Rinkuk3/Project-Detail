package com.td.mbna.msec.midtier.cardservice.payload.activatecard;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class ActivateCardRequest extends BaseRequest {

	private static final long serialVersionUID = -2033894996832944804L;
    private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ActivateCardRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("getSessionInfo()");
        sb.append('=');
        sb.append(((this.getSessionInfo() == null)?"<null>":this.getSessionInfo()));
        sb.append(',');
        sb.append("getCustId()");
        sb.append('=');
        sb.append(((this.getCustId() == null)?"<null>":this.getCustId()));
        sb.append(',');
        sb.append("getAliasCustId()");
        sb.append('=');
        sb.append(((this.getAliasCustId() == null)?"<null>":this.getAliasCustId()));
        sb.append(',');
        sb.append("getAcctNum()");
        sb.append('=');
        sb.append(((this.getAcctNum() == null)?"<null>":this.getAcctNum()));
        sb.append(',');
        sb.append("getAcctType()");
        sb.append('=');
        sb.append(((this.getAcctType() == null)?"<null>":this.getAcctType()));
        sb.append(',');
        sb.append("getLanguagePref()");
        sb.append('=');
        sb.append(((this.getLanguagePref() == null)?"<null>":this.getLanguagePref()));
        sb.append(',');
        sb.append("getAuditInfo()");
        sb.append('=');
        sb.append(((this.getAuditInfo() == null)?"<null>":this.getAuditInfo()));
        sb.append(',');
        sb.append("getIsPrimaryUser()");
        sb.append('=');
        sb.append(((this.getIsPrimaryUser() == null)?"<null>":this.getIsPrimaryUser()));
        sb.append(',');
        sb.append("getReserved1()");
        sb.append('=');
        sb.append(((this.getReserved1() == null)?"<null>":this.getReserved1()));
        sb.append(',');
        sb.append("getCustInterface()");
        sb.append('=');
        sb.append(((this.getCustInterface() == null)?"<null>":this.getCustInterface()));
        sb.append(',');
        sb.append("requestPayload");
        sb.append('=');
        sb.append(((this.requestPayload == null)?"<null>":this.requestPayload));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.getSessionInfo() == null)? 0 :this.getSessionInfo().hashCode()));
        result = ((result* 31)+((this.getAuditInfo() == null)? 0 :this.getAuditInfo().hashCode()));
        result = ((result* 31)+((this.getAliasCustId() == null)? 0 :this.getAliasCustId().hashCode()));
        result = ((result* 31)+((this.getCustInterface() == null)? 0 :this.getCustInterface().hashCode()));
        result = ((result* 31)+((this.getLanguagePref() == null)? 0 :this.getLanguagePref().hashCode()));
        result = ((result* 31)+((this.getAcctNum() == null)? 0 :this.getAcctNum().hashCode()));
        result = ((result* 31)+((this.requestPayload == null)? 0 :this.requestPayload.hashCode()));
        result = ((result* 31)+((this.getCustId() == null)? 0 :this.getCustId().hashCode()));
        result = ((result* 31)+((this.getAcctType() == null)? 0 :this.getAcctType().hashCode()));
        result = ((result* 31)+((this.getReserved1() == null)? 0 :this.getReserved1() .hashCode()));
        result = ((result* 31)+((this.getIsPrimaryUser() == null)? 0 :this.getIsPrimaryUser().hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ActivateCardRequest) == false) {
            return false;
        }
        ActivateCardRequest rhs = ((ActivateCardRequest) other);
        return ((((((((((((this.getSessionInfo() == rhs.getSessionInfo())||((this.getSessionInfo()!= null)&&this.getSessionInfo().equals(rhs.getSessionInfo())))&&((this.getAuditInfo() == rhs.getAuditInfo())||((this.getAuditInfo()!= null)&&this.getAuditInfo().equals(rhs.getAuditInfo()))))&&((this.getAliasCustId() == rhs.getAliasCustId())||((this.getAliasCustId()!= null)&&this.getAliasCustId().equals(rhs.getAliasCustId()))))&&((this.getCustInterface() == rhs.getCustInterface())||((this.getCustInterface()!= null)&&this.getCustInterface().equals(rhs.getCustInterface()))))&&((this.getLanguagePref() == rhs.getLanguagePref())||((this.getLanguagePref()!= null)&&this.getLanguagePref().equals(rhs.getLanguagePref()))))&&((this.getAcctNum() == rhs.getAcctNum())||((this.getAcctNum()!= null)&&this.getAcctNum().equals(rhs.getAcctNum()))))&&((this.requestPayload == rhs.requestPayload)||((this.requestPayload!= null)&&this.requestPayload.equals(rhs.requestPayload))))&&((this.getCustId() == rhs.getCustId())||((this.getCustId()!= null)&&this.getCustId().equals(rhs.getCustId()))))&&((this.getAcctType() == rhs.getAcctType())||((this.getAcctType()!= null)&&this.getAcctType().equals(rhs.getAcctType()))))&&((this.getReserved1() == rhs.getReserved1())||((this.getReserved1() != null)&&this.getReserved1() .equals(rhs.getReserved1()))))&&((this.getIsPrimaryUser() == rhs.getIsPrimaryUser())||((this.getIsPrimaryUser()!= null)&&this.getIsPrimaryUser().equals(rhs.getIsPrimaryUser()))));
    }

}
