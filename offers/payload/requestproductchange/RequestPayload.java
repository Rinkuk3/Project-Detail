package com.td.mbna.msec.midtier.offers.payload.requestproductchange;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;

public class RequestPayload {

    private List<DisclosureInfoType> disclosureInfo = new ArrayList<DisclosureInfoType>();
    private String languagePref;
    private String cardNumber;
    private String roleCD;
    private PromotionOfferType selectedOffer;
    private EmailNotificationInfoType emailNotificationInfo;

    public List<DisclosureInfoType> getDisclosureInfo() {
        return disclosureInfo;
    }

    public void setDisclosureInfo(List<DisclosureInfoType> disclosureInfo) {
        this.disclosureInfo = disclosureInfo;
    }

    public String getLanguagePref() {
        return languagePref;
    }

    public void setLanguagePref(String languagePref) {
        this.languagePref = languagePref;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getRoleCD() {
        return roleCD;
    }

    public void setRoleCD(String roleCD) {
        this.roleCD = roleCD;
    }

    public PromotionOfferType getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(PromotionOfferType selectedOffer) {
        this.selectedOffer = selectedOffer;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("disclosureInfo");
        sb.append('=');
        sb.append(((this.disclosureInfo == null)?"<null>":this.disclosureInfo));
        sb.append(',');
        sb.append("languagePref");
        sb.append('=');
        sb.append(((this.languagePref == null)?"<null>":this.languagePref));
        sb.append(',');
        sb.append("cardNumber");
        sb.append('=');
        sb.append(((this.cardNumber == null)?"<null>":this.cardNumber));
        sb.append(',');
        sb.append("roleCD");
        sb.append('=');
        sb.append(((this.roleCD == null)?"<null>":this.roleCD));
        sb.append(',');
        sb.append("selectedOffer");
        sb.append('=');
        sb.append(((this.selectedOffer == null)?"<null>":this.selectedOffer));
        sb.append(',');
        sb.append("emailNotificationInfo");
        sb.append('=');
        sb.append(((this.emailNotificationInfo == null)?"<null>":this.emailNotificationInfo));
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
        result = ((result* 31)+((this.roleCD == null)? 0 :this.roleCD.hashCode()));
        result = ((result* 31)+((this.selectedOffer == null)? 0 :this.selectedOffer.hashCode()));
        result = ((result* 31)+((this.emailNotificationInfo == null)? 0 :this.emailNotificationInfo.hashCode()));
        result = ((result* 31)+((this.disclosureInfo == null)? 0 :this.disclosureInfo.hashCode()));
        result = ((result* 31)+((this.languagePref == null)? 0 :this.languagePref.hashCode()));
        result = ((result* 31)+((this.cardNumber == null)? 0 :this.cardNumber.hashCode()));
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
        return (((((((this.roleCD == rhs.roleCD)||((this.roleCD!= null)&&this.roleCD.equals(rhs.roleCD)))&&((this.selectedOffer == rhs.selectedOffer)||((this.selectedOffer!= null)&&this.selectedOffer.equals(rhs.selectedOffer))))&&((this.emailNotificationInfo == rhs.emailNotificationInfo)||((this.emailNotificationInfo!= null)&&this.emailNotificationInfo.equals(rhs.emailNotificationInfo))))&&((this.disclosureInfo == rhs.disclosureInfo)||((this.disclosureInfo!= null)&&this.disclosureInfo.equals(rhs.disclosureInfo))))&&((this.languagePref == rhs.languagePref)||((this.languagePref!= null)&&this.languagePref.equals(rhs.languagePref))))&&((this.cardNumber == rhs.cardNumber)||((this.cardNumber!= null)&&this.cardNumber.equals(rhs.cardNumber))));
    }

}
