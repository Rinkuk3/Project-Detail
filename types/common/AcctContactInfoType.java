package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class AcctContactInfoType implements Serializable {

	private static final long serialVersionUID = -777840423534645996L;
    private String emailAddr;
    private PhoneNumber businessPhoneNum;
    private PhoneNumber homePhoneNum;
    private PhoneNumber mobilePhoneNum;
    private UnformattedAddress mailingAddress;
    private UnformattedAddress physicalAddress;
    private Boolean physicalAddressSameAsMailing;

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddress) {
    	if(emailAddress == null || emailAddress.isEmpty() || emailAddress.length() < 5){
    		emailAddress = null;
    	}
        this.emailAddr = emailAddress;
    }

    public PhoneNumber getBusinessPhoneNum() {
        return businessPhoneNum;
    }

    public void setBusinessPhoneNum(PhoneNumber businessPhoneNum) {
        this.businessPhoneNum = businessPhoneNum;
    }

    public PhoneNumber getHomePhoneNum() {
        return homePhoneNum;
    }

    public void setHomePhoneNum(PhoneNumber homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
    }

    public PhoneNumber getMobilePhoneNum() {
        return mobilePhoneNum;
    }

    public void setMobilePhoneNum(PhoneNumber mobilePhoneNum) {
        this.mobilePhoneNum = mobilePhoneNum;
    }

    public UnformattedAddress getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(UnformattedAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public UnformattedAddress getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(UnformattedAddress physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public Boolean getPhysicalAddressSameAsMailing() {
        return physicalAddressSameAsMailing;
    }

    public void setPhysicalAddressSameAsMailing(Boolean physicalAddressSameAsMailing) {
        this.physicalAddressSameAsMailing = physicalAddressSameAsMailing;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AcctContactInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("emailAddr");
        sb.append('=');
        sb.append(((this.emailAddr == null)?"<null>":this.emailAddr));
        sb.append(',');
        sb.append("businessPhoneNum");
        sb.append('=');
        sb.append(((this.businessPhoneNum == null)?"<null>":this.businessPhoneNum));
        sb.append(',');
        sb.append("homePhoneNum");
        sb.append('=');
        sb.append(((this.homePhoneNum == null)?"<null>":this.homePhoneNum));
        sb.append(',');
        sb.append("mobilePhoneNum");
        sb.append('=');
        sb.append(((this.mobilePhoneNum == null)?"<null>":this.mobilePhoneNum));
        sb.append(',');
        sb.append("mailingAddress");
        sb.append('=');
        sb.append(((this.mailingAddress == null)?"<null>":this.mailingAddress));
        sb.append(',');
        sb.append("physicalAddress");
        sb.append('=');
        sb.append(((this.physicalAddress == null)?"<null>":this.physicalAddress));
        sb.append(',');
        sb.append("physicalAddressSameAsMailing");
        sb.append('=');
        sb.append(((this.physicalAddressSameAsMailing == null)?"<null>":this.physicalAddressSameAsMailing));
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
        result = ((result* 31)+((this.homePhoneNum == null)? 0 :this.homePhoneNum.hashCode()));
        result = ((result* 31)+((this.mailingAddress == null)? 0 :this.mailingAddress.hashCode()));
        result = ((result* 31)+((this.physicalAddressSameAsMailing == null)? 0 :this.physicalAddressSameAsMailing.hashCode()));
        result = ((result* 31)+((this.emailAddr == null)? 0 :this.emailAddr.hashCode()));
        result = ((result* 31)+((this.physicalAddress == null)? 0 :this.physicalAddress.hashCode()));
        result = ((result* 31)+((this.mobilePhoneNum == null)? 0 :this.mobilePhoneNum.hashCode()));
        result = ((result* 31)+((this.businessPhoneNum == null)? 0 :this.businessPhoneNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AcctContactInfoType) == false) {
            return false;
        }
        AcctContactInfoType rhs = ((AcctContactInfoType) other);
        return ((((((((this.homePhoneNum == rhs.homePhoneNum)||((this.homePhoneNum!= null)&&this.homePhoneNum.equals(rhs.homePhoneNum)))&&((this.mailingAddress == rhs.mailingAddress)||((this.mailingAddress!= null)&&this.mailingAddress.equals(rhs.mailingAddress))))&&((this.physicalAddressSameAsMailing == rhs.physicalAddressSameAsMailing)||((this.physicalAddressSameAsMailing!= null)&&this.physicalAddressSameAsMailing.equals(rhs.physicalAddressSameAsMailing))))&&((this.emailAddr == rhs.emailAddr)||((this.emailAddr!= null)&&this.emailAddr.equals(rhs.emailAddr))))&&((this.physicalAddress == rhs.physicalAddress)||((this.physicalAddress!= null)&&this.physicalAddress.equals(rhs.physicalAddress))))&&((this.mobilePhoneNum == rhs.mobilePhoneNum)||((this.mobilePhoneNum!= null)&&this.mobilePhoneNum.equals(rhs.mobilePhoneNum))))&&((this.businessPhoneNum == rhs.businessPhoneNum)||((this.businessPhoneNum!= null)&&this.businessPhoneNum.equals(rhs.businessPhoneNum))));
    }

}
