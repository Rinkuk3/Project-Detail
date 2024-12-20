package com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPaymentInfoType;
import com.td.mbna.msec.midtier.types.common.AcctContactInfoType;
import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;

public class RequestPayload {

    private List<BalanceTransferToCreditorPaymentInfoType> paymentInfo = new ArrayList<BalanceTransferToCreditorPaymentInfoType>();
    private AcctContactInfoType contactInfo;
    private java.math.BigDecimal creditAvail;
    private PromotionOfferType selectedOffer;
    private String roleCD;
    private DisclosureInfoType disclosureInfo;
    private EmailNotificationInfoType emailNotificationInfo;
    private Boolean confirmed = false;

    public List<BalanceTransferToCreditorPaymentInfoType> getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(List<BalanceTransferToCreditorPaymentInfoType> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public AcctContactInfoType getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(AcctContactInfoType contactInfo) {
        this.contactInfo = contactInfo;
    }

    public java.math.BigDecimal getCreditAvail() {
        return creditAvail;
    }

    public void setCreditAvail(java.math.BigDecimal creditAvail) {
        this.creditAvail = creditAvail;
    }

    public PromotionOfferType getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(PromotionOfferType selectedOffer) {
        this.selectedOffer = selectedOffer;
    }

    public String getRoleCD() {
        return roleCD;
    }

    public void setRoleCD(String roleCD) {
        this.roleCD = roleCD;
    }

    public DisclosureInfoType getDisclosureInfo() {
        return disclosureInfo;
    }

    public void setDisclosureInfo(DisclosureInfoType disclosureInfo) {
        this.disclosureInfo = disclosureInfo;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("paymentInfo");
        sb.append('=');
        sb.append(((this.paymentInfo == null)?"<null>":this.paymentInfo));
        sb.append(',');
        sb.append("contactInfo");
        sb.append('=');
        sb.append(((this.contactInfo == null)?"<null>":this.contactInfo));
        sb.append(',');
        sb.append("creditAvail");
        sb.append('=');
        sb.append(((this.creditAvail == null)?"<null>":this.creditAvail));
        sb.append(',');
        sb.append("selectedOffer");
        sb.append('=');
        sb.append(((this.selectedOffer == null)?"<null>":this.selectedOffer));
        sb.append(',');
        sb.append("roleCD");
        sb.append('=');
        sb.append(((this.roleCD == null)?"<null>":this.roleCD));
        sb.append(',');
        sb.append("disclosureInfo");
        sb.append('=');
        sb.append(((this.disclosureInfo == null)?"<null>":this.disclosureInfo));
        sb.append(',');
        sb.append("emailNotificationInfo");
        sb.append('=');
        sb.append(((this.emailNotificationInfo == null)?"<null>":this.emailNotificationInfo));
        sb.append(',');
        sb.append("confirmed");
        sb.append('=');
        sb.append(((this.confirmed == null)?"<null>":this.confirmed));
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
        result = ((result* 31)+((this.creditAvail == null)? 0 :this.creditAvail.hashCode()));
        result = ((result* 31)+((this.roleCD == null)? 0 :this.roleCD.hashCode()));
        result = ((result* 31)+((this.contactInfo == null)? 0 :this.contactInfo.hashCode()));
        result = ((result* 31)+((this.selectedOffer == null)? 0 :this.selectedOffer.hashCode()));
        result = ((result* 31)+((this.emailNotificationInfo == null)? 0 :this.emailNotificationInfo.hashCode()));
        result = ((result* 31)+((this.disclosureInfo == null)? 0 :this.disclosureInfo.hashCode()));
        result = ((result* 31)+((this.confirmed == null)? 0 :this.confirmed.hashCode()));
        result = ((result* 31)+((this.paymentInfo == null)? 0 :this.paymentInfo.hashCode()));
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
        return (((((((((this.creditAvail == rhs.creditAvail)||((this.creditAvail!= null)&&this.creditAvail.equals(rhs.creditAvail)))&&((this.roleCD == rhs.roleCD)||((this.roleCD!= null)&&this.roleCD.equals(rhs.roleCD))))&&((this.contactInfo == rhs.contactInfo)||((this.contactInfo!= null)&&this.contactInfo.equals(rhs.contactInfo))))&&((this.selectedOffer == rhs.selectedOffer)||((this.selectedOffer!= null)&&this.selectedOffer.equals(rhs.selectedOffer))))&&((this.emailNotificationInfo == rhs.emailNotificationInfo)||((this.emailNotificationInfo!= null)&&this.emailNotificationInfo.equals(rhs.emailNotificationInfo))))&&((this.disclosureInfo == rhs.disclosureInfo)||((this.disclosureInfo!= null)&&this.disclosureInfo.equals(rhs.disclosureInfo))))&&((this.confirmed == rhs.confirmed)||((this.confirmed!= null)&&this.confirmed.equals(rhs.confirmed))))&&((this.paymentInfo == rhs.paymentInfo)||((this.paymentInfo!= null)&&this.paymentInfo.equals(rhs.paymentInfo))));
    }

}
