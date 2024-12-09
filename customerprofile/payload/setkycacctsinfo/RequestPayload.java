package com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.customerprofile.payload.AccountKycInfoType;
import com.td.mbna.msec.midtier.customerprofile.payload.CustomerInfoType;

public class RequestPayload implements Serializable {

	private static final long serialVersionUID = -5654491783839497606L;
	private CustomerInfoType kycCustInfo;
    private List<AccountKycInfoType> kycAcctsInfo = new ArrayList<AccountKycInfoType>();

    public CustomerInfoType getKycCustInfo() {
        return kycCustInfo;
    }

    public void setKycCustInfo(CustomerInfoType kycCustInfo) {
        this.kycCustInfo = kycCustInfo;
    }

    public List<AccountKycInfoType> getKycAcctsInfo() {
        return kycAcctsInfo;
    }

    public void setKycAcctsInfo(List<AccountKycInfoType> kycAcctsInfo) {
        this.kycAcctsInfo = kycAcctsInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("kycCustInfo");
        sb.append('=');
        sb.append(((this.kycCustInfo == null)?"<null>":this.kycCustInfo));
        sb.append(',');
        sb.append("kycAcctsInfo");
        sb.append('=');
        sb.append(((this.kycAcctsInfo == null)?"<null>":this.kycAcctsInfo));
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
        result = ((result* 31)+((this.kycCustInfo == null)? 0 :this.kycCustInfo.hashCode()));
        result = ((result* 31)+((this.kycAcctsInfo == null)? 0 :this.kycAcctsInfo.hashCode()));
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
        return (((this.kycCustInfo == rhs.kycCustInfo)||((this.kycCustInfo!= null)&&this.kycCustInfo.equals(rhs.kycCustInfo)))&&((this.kycAcctsInfo == rhs.kycAcctsInfo)||((this.kycAcctsInfo!= null)&&this.kycAcctsInfo.equals(rhs.kycAcctsInfo))));
    }

}
