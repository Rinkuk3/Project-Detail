package com.td.mbna.msec.midtier.offers.payload.requestinsurance;

import com.td.mbna.msec.midtier.types.common.CardHolderType;
import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.PhoneNumber;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;
import com.td.mbna.msec.midtier.types.common.UnformattedAddress;

public class RequestPayload {

    private String accountNo;
    private String cardNumber;
    private String subproductId;
    private CardHolderType cardHolder;
    private PhoneNumber primaryPhoneNumber;
    private UnformattedAddress address;
    private String callId;
    private String associatedId;
    private String roleCD;
    private DisclosureInfoType disclosureInfo;
    private PromotionOfferType selectedOffer;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSubproductId() {
        return subproductId;
    }

    public void setSubproductId(String subproductId) {
        this.subproductId = subproductId;
    }

    public CardHolderType getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolderType cardHolder) {
        this.cardHolder = cardHolder;
    }

    public PhoneNumber getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public void setPrimaryPhoneNumber(PhoneNumber primaryPhoneNumber) {
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    public UnformattedAddress getAddress() {
        return address;
    }

    public void setAddress(UnformattedAddress address) {
        this.address = address;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getAssociatedId() {
        return associatedId;
    }

    public void setAssociatedId(String associatedId) {
        this.associatedId = associatedId;
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

    public PromotionOfferType getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(PromotionOfferType selectedOffer) {
        this.selectedOffer = selectedOffer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountNo");
        sb.append('=');
        sb.append(((this.accountNo == null)?"<null>":this.accountNo));
        sb.append(',');
        sb.append("cardNumber");
        sb.append('=');
        sb.append(((this.cardNumber == null)?"<null>":this.cardNumber));
        sb.append(',');
        sb.append("subproductId");
        sb.append('=');
        sb.append(((this.subproductId == null)?"<null>":this.subproductId));
        sb.append(',');
        sb.append("cardHolder");
        sb.append('=');
        sb.append(((this.cardHolder == null)?"<null>":this.cardHolder));
        sb.append(',');
        sb.append("primaryPhoneNumber");
        sb.append('=');
        sb.append(((this.primaryPhoneNumber == null)?"<null>":this.primaryPhoneNumber));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("callId");
        sb.append('=');
        sb.append(((this.callId == null)?"<null>":this.callId));
        sb.append(',');
        sb.append("associatedId");
        sb.append('=');
        sb.append(((this.associatedId == null)?"<null>":this.associatedId));
        sb.append(',');
        sb.append("roleCD");
        sb.append('=');
        sb.append(((this.roleCD == null)?"<null>":this.roleCD));
        sb.append(',');
        sb.append("disclosureInfo");
        sb.append('=');
        sb.append(((this.disclosureInfo == null)?"<null>":this.disclosureInfo));
        sb.append(',');
        sb.append("selectedOffer");
        sb.append('=');
        sb.append(((this.selectedOffer == null)?"<null>":this.selectedOffer));
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
        result = ((result* 31)+((this.callId == null)? 0 :this.callId.hashCode()));
        result = ((result* 31)+((this.roleCD == null)? 0 :this.roleCD.hashCode()));
        result = ((result* 31)+((this.associatedId == null)? 0 :this.associatedId.hashCode()));
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.subproductId == null)? 0 :this.subproductId.hashCode()));
        result = ((result* 31)+((this.accountNo == null)? 0 :this.accountNo.hashCode()));
        result = ((result* 31)+((this.selectedOffer == null)? 0 :this.selectedOffer.hashCode()));
        result = ((result* 31)+((this.cardHolder == null)? 0 :this.cardHolder.hashCode()));
        result = ((result* 31)+((this.primaryPhoneNumber == null)? 0 :this.primaryPhoneNumber.hashCode()));
        result = ((result* 31)+((this.disclosureInfo == null)? 0 :this.disclosureInfo.hashCode()));
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
        return ((((((((((((this.callId == rhs.callId)||((this.callId!= null)&&this.callId.equals(rhs.callId)))&&((this.roleCD == rhs.roleCD)||((this.roleCD!= null)&&this.roleCD.equals(rhs.roleCD))))&&((this.associatedId == rhs.associatedId)||((this.associatedId!= null)&&this.associatedId.equals(rhs.associatedId))))&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&((this.subproductId == rhs.subproductId)||((this.subproductId!= null)&&this.subproductId.equals(rhs.subproductId))))&&((this.accountNo == rhs.accountNo)||((this.accountNo!= null)&&this.accountNo.equals(rhs.accountNo))))&&((this.disclosureInfo == rhs.disclosureInfo)||((this.disclosureInfo!= null)&&this.disclosureInfo.equals(rhs.disclosureInfo))))&&((this.selectedOffer == rhs.selectedOffer)||((this.selectedOffer!= null)&&this.selectedOffer.equals(rhs.selectedOffer))))&&((this.cardHolder == rhs.cardHolder)||((this.cardHolder!= null)&&this.cardHolder.equals(rhs.cardHolder))))&&((this.primaryPhoneNumber == rhs.primaryPhoneNumber)||((this.primaryPhoneNumber!= null)&&this.primaryPhoneNumber.equals(rhs.primaryPhoneNumber))))&&((this.cardNumber == rhs.cardNumber)||((this.cardNumber!= null)&&this.cardNumber.equals(rhs.cardNumber))));
    }

}
