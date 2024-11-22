package com.td.mbna.msec.midtier.account.payload.deleteaccount;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class DeleteAccountRequest extends BaseRequest {

	private final static long serialVersionUID = -1541278121025048639L;
	
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
        sb.append(DeleteAccountRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sessionInfo");
        sb.append('=');
        sb.append(((this.sessionInfo == null)?"<null>":this.sessionInfo));
        sb.append(',');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("aliasCustId");
        sb.append('=');
        sb.append(((this.aliasCustId == null)?"<null>":this.aliasCustId));
        sb.append(',');
        sb.append("acctNum");
        sb.append('=');
        sb.append(((this.acctNum == null)?"<null>":this.acctNum));
        sb.append(',');
        sb.append("acctType");
        sb.append('=');
        sb.append(((this.acctType == null)?"<null>":this.acctType));
        sb.append(',');
        sb.append("languagePref");
        sb.append('=');
        sb.append(((this.languagePref == null)?"<null>":this.languagePref));
        sb.append(',');
        sb.append("auditInfo");
        sb.append('=');
        sb.append(((this.auditInfo == null)?"<null>":this.auditInfo));
        sb.append(',');
        sb.append("isPrimaryUser");
        sb.append('=');
        sb.append(((this.isPrimaryUser == null)?"<null>":this.isPrimaryUser));
        sb.append(',');
        sb.append("reserved1");
        sb.append('=');
        sb.append(((this.reserved1 == null)?"<null>":this.reserved1));
        sb.append(',');
        sb.append("custInterface");
        sb.append('=');
        sb.append(((this.custInterface == null)?"<null>":this.custInterface));
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
        result = ((result* 31)+((this.sessionInfo == null)? 0 :this.sessionInfo.hashCode()));
        result = ((result* 31)+((this.auditInfo == null)? 0 :this.auditInfo.hashCode()));
        result = ((result* 31)+((this.aliasCustId == null)? 0 :this.aliasCustId.hashCode()));
        result = ((result* 31)+((this.custInterface == null)? 0 :this.custInterface.hashCode()));
        result = ((result* 31)+((this.languagePref == null)? 0 :this.languagePref.hashCode()));
        result = ((result* 31)+((this.acctNum == null)? 0 :this.acctNum.hashCode()));
        result = ((result* 31)+((this.requestPayload == null)? 0 :this.requestPayload.hashCode()));
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.acctType == null)? 0 :this.acctType.hashCode()));
        result = ((result* 31)+((this.reserved1 == null)? 0 :this.reserved1 .hashCode()));
        result = ((result* 31)+((this.isPrimaryUser == null)? 0 :this.isPrimaryUser.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeleteAccountRequest) == false) {
            return false;
        }
        DeleteAccountRequest rhs = ((DeleteAccountRequest) other);
        return ((((((((((((this.sessionInfo == rhs.sessionInfo)||((this.sessionInfo!= null)&&this.sessionInfo.equals(rhs.sessionInfo)))&&((this.auditInfo == rhs.auditInfo)||((this.auditInfo!= null)&&this.auditInfo.equals(rhs.auditInfo))))&&((this.aliasCustId == rhs.aliasCustId)||((this.aliasCustId!= null)&&this.aliasCustId.equals(rhs.aliasCustId))))&&((this.custInterface == rhs.custInterface)||((this.custInterface!= null)&&this.custInterface.equals(rhs.custInterface))))&&((this.languagePref == rhs.languagePref)||((this.languagePref!= null)&&this.languagePref.equals(rhs.languagePref))))&&((this.acctNum == rhs.acctNum)||((this.acctNum!= null)&&this.acctNum.equals(rhs.acctNum))))&&((this.requestPayload == rhs.requestPayload)||((this.requestPayload!= null)&&this.requestPayload.equals(rhs.requestPayload))))&&((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId))))&&((this.acctType == rhs.acctType)||((this.acctType!= null)&&this.acctType.equals(rhs.acctType))))&&((this.reserved1 == rhs.reserved1)||((this.reserved1 != null)&&this.reserved1 .equals(rhs.reserved1))))&&((this.isPrimaryUser == rhs.isPrimaryUser)||((this.isPrimaryUser!= null)&&this.isPrimaryUser.equals(rhs.isPrimaryUser))));
    }
	
}
