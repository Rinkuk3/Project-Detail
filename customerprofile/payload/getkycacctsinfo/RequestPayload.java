package com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.td.mbna.msec.midtier.types.common.CustAcctType;

public class RequestPayload implements Serializable {

	private static final long serialVersionUID = 5666935420595471361L;
    private List<CustAcctType> kycNeededAccts = new ArrayList<CustAcctType>();

    public List<CustAcctType> getKycNeededAccts() {
        return kycNeededAccts;
    }

    public void setKycNeededAccts(List<CustAcctType> kycNeededAccts) {
        this.kycNeededAccts = kycNeededAccts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("kycNeededAccts");
        sb.append('=');
        sb.append(((this.kycNeededAccts == null)?"<null>":this.kycNeededAccts));
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
        result = ((result* 31)+((this.kycNeededAccts == null)? 0 :this.kycNeededAccts.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return ((this.kycNeededAccts == rhs.kycNeededAccts)||((this.kycNeededAccts!= null)&&this.kycNeededAccts.equals(rhs.kycNeededAccts)));
    }

}
