package com.td.mbna.msec.midtier.customerprofile.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;
import com.td.mbna.msec.midtier.types.common.CardNumHistoryType;

public class CustomerAcctInfoType implements Serializable {

	private static final long serialVersionUID = 5446827043292607034L;
    private String custId;
    private String acctNum;
    private String cardNum;
    private List<CardNumHistoryType> cardNumList = new ArrayList<CardNumHistoryType>();
    private String mailingAddressPartyLocationID;
    private String mailingAddressLine1;
    private String mailingAddressLine2;
    private String mailingCity;
    private String mailingProvince;
    private String mailingPostalCode;
    private String mailingCountry;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mailingLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mailingEndTS;

    private String businessPhonePartyLocationID;
    private String businessPhone;
    private String homePhonePartyLocationID;
    private String homePhone;
    private String mobilePhonePartyLocationID;
    private String mobilePhone;
    private Boolean differentPhysicalAddress;
    private Boolean updateRequired;
    private String emailPartyLocationID;
    private String email;
    private Boolean marketingEmailWanted;
    private Boolean unsuccessfulDevilery;
    private Boolean confirmationEmailWanted;
    private Boolean updateProfile;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long partyAgreementLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long emailLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long emailAddressLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long businessPhoneEffectiveTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long businessPhoneEndTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long businessPhoneLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long businessPhoneLocLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneEffectiveTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneEndTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneLocLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneEffectiveTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneEndTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneLocLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mailingArgLocLastUpdatedTS;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public List<CardNumHistoryType> getCardNumList() {
        return cardNumList;
    }

    public void setCardNumList(List<CardNumHistoryType> cardNumList) {
        this.cardNumList = cardNumList;
    }

    public String getMailingAddressPartyLocationID() {
        return mailingAddressPartyLocationID;
    }

    public void setMailingAddressPartyLocationID(String mailingAddressPartyLocationID) {
        this.mailingAddressPartyLocationID = mailingAddressPartyLocationID;
    }

    public String getMailingAddressLine1() {
        return mailingAddressLine1;
    }

    public void setMailingAddressLine1(String mailingAddressLine1) {
        this.mailingAddressLine1 = mailingAddressLine1;
    }

    public String getMailingAddressLine2() {
        return mailingAddressLine2;
    }

    public void setMailingAddressLine2(String mailingAddressLine2) {
        this.mailingAddressLine2 = mailingAddressLine2;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingProvince() {
        return mailingProvince;
    }

    public void setMailingProvince(String mailingProvince) {
        this.mailingProvince = mailingProvince;
    }

    public String getMailingPostalCode() {
        return mailingPostalCode;
    }

    public void setMailingPostalCode(String mailingPostalCode) {
        this.mailingPostalCode = mailingPostalCode;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    public Long getMailingLastUpdatedTS() {
        return mailingLastUpdatedTS;
    }

    public void setMailingLastUpdatedTS(Long mailingLastUpdatedTS) {
        this.mailingLastUpdatedTS = mailingLastUpdatedTS;
    }

    public Long getMailingEndTS() {
        return mailingEndTS;
    }

    public void setMailingEndTS(Long mailingEndTS) {
        this.mailingEndTS = mailingEndTS;
    }

    public String getBusinessPhonePartyLocationID() {
        return businessPhonePartyLocationID;
    }

    public void setBusinessPhonePartyLocationID(String businessPhonePartyLocationID) {
        this.businessPhonePartyLocationID = businessPhonePartyLocationID;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getHomePhonePartyLocationID() {
        return homePhonePartyLocationID;
    }

    public void setHomePhonePartyLocationID(String homePhonePartyLocationID) {
        this.homePhonePartyLocationID = homePhonePartyLocationID;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhonePartyLocationID() {
        return mobilePhonePartyLocationID;
    }

    public void setMobilePhonePartyLocationID(String mobilePhonePartyLocationID) {
        this.mobilePhonePartyLocationID = mobilePhonePartyLocationID;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Boolean getDifferentPhysicalAddress() {
        return differentPhysicalAddress;
    }

    public void setDifferentPhysicalAddress(Boolean differentPhysicalAddress) {
        this.differentPhysicalAddress = differentPhysicalAddress;
    }

    public Boolean getUpdateRequired() {
        return updateRequired;
    }

    public void setUpdateRequired(Boolean updateRequired) {
        this.updateRequired = updateRequired;
    }

    public String getEmailPartyLocationID() {
        return emailPartyLocationID;
    }

    public void setEmailPartyLocationID(String emailPartyLocationID) {
        this.emailPartyLocationID = emailPartyLocationID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMarketingEmailWanted() {
        return marketingEmailWanted;
    }

    public void setMarketingEmailWanted(Boolean marketingEmailWanted) {
        this.marketingEmailWanted = marketingEmailWanted;
    }

    public Boolean getUnsuccessfulDevilery() {
        return unsuccessfulDevilery;
    }

    public void setUnsuccessfulDevilery(Boolean unsuccessfulDevilery) {
        this.unsuccessfulDevilery = unsuccessfulDevilery;
    }

    public Boolean getConfirmationEmailWanted() {
        return confirmationEmailWanted;
    }

    public void setConfirmationEmailWanted(Boolean confirmationEmailWanted) {
        this.confirmationEmailWanted = confirmationEmailWanted;
    }

    public Boolean getUpdateProfile() {
        return updateProfile;
    }

    public void setUpdateProfile(Boolean updateProfile) {
        this.updateProfile = updateProfile;
    }

    public Long getPartyAgreementLastUpdatedTS() {
        return partyAgreementLastUpdatedTS;
    }

    public void setPartyAgreementLastUpdatedTS(Long partyAgreementLastUpdatedTS) {
        this.partyAgreementLastUpdatedTS = partyAgreementLastUpdatedTS;
    }

    public Long getEmailLastUpdatedTS() {
        return emailLastUpdatedTS;
    }

    public void setEmailLastUpdatedTS(Long emailLastUpdatedTS) {
        this.emailLastUpdatedTS = emailLastUpdatedTS;
    }

    public Long getEmailAddressLastUpdatedTS() {
        return emailAddressLastUpdatedTS;
    }

    public void setEmailAddressLastUpdatedTS(Long emailAddressLastUpdatedTS) {
        this.emailAddressLastUpdatedTS = emailAddressLastUpdatedTS;
    }

    public Long getBusinessPhoneEffectiveTS() {
        return businessPhoneEffectiveTS;
    }

    public void setBusinessPhoneEffectiveTS(Long businessPhoneEffectiveTS) {
        this.businessPhoneEffectiveTS = businessPhoneEffectiveTS;
    }

    public Long getBusinessPhoneEndTS() {
        return businessPhoneEndTS;
    }

    public void setBusinessPhoneEndTS(Long businessPhoneEndTS) {
        this.businessPhoneEndTS = businessPhoneEndTS;
    }

    public Long getBusinessPhoneLastUpdatedTS() {
        return businessPhoneLastUpdatedTS;
    }

    public void setBusinessPhoneLastUpdatedTS(Long businessPhoneLastUpdatedTS) {
        this.businessPhoneLastUpdatedTS = businessPhoneLastUpdatedTS;
    }

    public Long getBusinessPhoneLocLastUpdatedTS() {
        return businessPhoneLocLastUpdatedTS;
    }

    public void setBusinessPhoneLocLastUpdatedTS(Long businessPhoneLocLastUpdatedTS) {
        this.businessPhoneLocLastUpdatedTS = businessPhoneLocLastUpdatedTS;
    }

    public Long getHomePhoneEffectiveTS() {
        return homePhoneEffectiveTS;
    }

    public void setHomePhoneEffectiveTS(Long homePhoneEffectiveTS) {
        this.homePhoneEffectiveTS = homePhoneEffectiveTS;
    }

    public Long getHomePhoneEndTS() {
        return homePhoneEndTS;
    }

    public void setHomePhoneEndTS(Long homePhoneEndTS) {
        this.homePhoneEndTS = homePhoneEndTS;
    }

    public Long getHomePhoneLastUpdatedTS() {
        return homePhoneLastUpdatedTS;
    }

    public void setHomePhoneLastUpdatedTS(Long homePhoneLastUpdatedTS) {
        this.homePhoneLastUpdatedTS = homePhoneLastUpdatedTS;
    }

    public Long getHomePhoneLocLastUpdatedTS() {
        return homePhoneLocLastUpdatedTS;
    }

    public void setHomePhoneLocLastUpdatedTS(Long homePhoneLocLastUpdatedTS) {
        this.homePhoneLocLastUpdatedTS = homePhoneLocLastUpdatedTS;
    }

    public Long getMobilePhoneEffectiveTS() {
        return mobilePhoneEffectiveTS;
    }

    public void setMobilePhoneEffectiveTS(Long mobilePhoneEffectiveTS) {
        this.mobilePhoneEffectiveTS = mobilePhoneEffectiveTS;
    }

    public Long getMobilePhoneEndTS() {
        return mobilePhoneEndTS;
    }

    public void setMobilePhoneEndTS(Long mobilePhoneEndTS) {
        this.mobilePhoneEndTS = mobilePhoneEndTS;
    }

    public Long getMobilePhoneLastUpdatedTS() {
        return mobilePhoneLastUpdatedTS;
    }

    public void setMobilePhoneLastUpdatedTS(Long mobilePhoneLastUpdatedTS) {
        this.mobilePhoneLastUpdatedTS = mobilePhoneLastUpdatedTS;
    }

    public Long getMobilePhoneLocLastUpdatedTS() {
        return mobilePhoneLocLastUpdatedTS;
    }

    public void setMobilePhoneLocLastUpdatedTS(Long mobilePhoneLocLastUpdatedTS) {
        this.mobilePhoneLocLastUpdatedTS = mobilePhoneLocLastUpdatedTS;
    }

    public Long getMailingArgLocLastUpdatedTS() {
        return mailingArgLocLastUpdatedTS;
    }

    public void setMailingArgLocLastUpdatedTS(Long mailingArgLocLastUpdatedTS) {
        this.mailingArgLocLastUpdatedTS = mailingArgLocLastUpdatedTS;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomerAcctInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("acctNum");
        sb.append('=');
        sb.append(((this.acctNum == null)?"<null>":this.acctNum));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("cardNumList");
        sb.append('=');
        sb.append(((this.cardNumList == null)?"<null>":this.cardNumList));
        sb.append(',');
        sb.append("mailingAddressPartyLocationID");
        sb.append('=');
        sb.append(((this.mailingAddressPartyLocationID == null)?"<null>":this.mailingAddressPartyLocationID));
        sb.append(',');
        sb.append("mailingAddressLine1");
        sb.append('=');
        sb.append(((this.mailingAddressLine1 == null)?"<null>":this.mailingAddressLine1));
        sb.append(',');
        sb.append("mailingAddressLine2");
        sb.append('=');
        sb.append(((this.mailingAddressLine2 == null)?"<null>":this.mailingAddressLine2));
        sb.append(',');
        sb.append("mailingCity");
        sb.append('=');
        sb.append(((this.mailingCity == null)?"<null>":this.mailingCity));
        sb.append(',');
        sb.append("mailingProvince");
        sb.append('=');
        sb.append(((this.mailingProvince == null)?"<null>":this.mailingProvince));
        sb.append(',');
        sb.append("mailingPostalCode");
        sb.append('=');
        sb.append(((this.mailingPostalCode == null)?"<null>":this.mailingPostalCode));
        sb.append(',');
        sb.append("mailingCountry");
        sb.append('=');
        sb.append(((this.mailingCountry == null)?"<null>":this.mailingCountry));
        sb.append(',');
        sb.append("mailingLastUpdatedTS");
        sb.append('=');
        sb.append(((this.mailingLastUpdatedTS == null)?"<null>":this.mailingLastUpdatedTS));
        sb.append(',');
        sb.append("mailingEndTS");
        sb.append('=');
        sb.append(((this.mailingEndTS == null)?"<null>":this.mailingEndTS));
        sb.append(',');
        sb.append("businessPhonePartyLocationID");
        sb.append('=');
        sb.append(((this.businessPhonePartyLocationID == null)?"<null>":this.businessPhonePartyLocationID));
        sb.append(',');
        sb.append("businessPhone");
        sb.append('=');
        sb.append(((this.businessPhone == null)?"<null>":this.businessPhone));
        sb.append(',');
        sb.append("homePhonePartyLocationID");
        sb.append('=');
        sb.append(((this.homePhonePartyLocationID == null)?"<null>":this.homePhonePartyLocationID));
        sb.append(',');
        sb.append("homePhone");
        sb.append('=');
        sb.append(((this.homePhone == null)?"<null>":this.homePhone));
        sb.append(',');
        sb.append("mobilePhonePartyLocationID");
        sb.append('=');
        sb.append(((this.mobilePhonePartyLocationID == null)?"<null>":this.mobilePhonePartyLocationID));
        sb.append(',');
        sb.append("mobilePhone");
        sb.append('=');
        sb.append(((this.mobilePhone == null)?"<null>":this.mobilePhone));
        sb.append(',');
        sb.append("differentPhysicalAddress");
        sb.append('=');
        sb.append(((this.differentPhysicalAddress == null)?"<null>":this.differentPhysicalAddress));
        sb.append(',');
        sb.append("updateRequired");
        sb.append('=');
        sb.append(((this.updateRequired == null)?"<null>":this.updateRequired));
        sb.append(',');
        sb.append("emailPartyLocationID");
        sb.append('=');
        sb.append(((this.emailPartyLocationID == null)?"<null>":this.emailPartyLocationID));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("marketingEmailWanted");
        sb.append('=');
        sb.append(((this.marketingEmailWanted == null)?"<null>":this.marketingEmailWanted));
        sb.append(',');
        sb.append("unsuccessfulDevilery");
        sb.append('=');
        sb.append(((this.unsuccessfulDevilery == null)?"<null>":this.unsuccessfulDevilery));
        sb.append(',');
        sb.append("confirmationEmailWanted");
        sb.append('=');
        sb.append(((this.confirmationEmailWanted == null)?"<null>":this.confirmationEmailWanted));
        sb.append(',');
        sb.append("updateProfile");
        sb.append('=');
        sb.append(((this.updateProfile == null)?"<null>":this.updateProfile));
        sb.append(',');
        sb.append("partyAgreementLastUpdatedTS");
        sb.append('=');
        sb.append(((this.partyAgreementLastUpdatedTS == null)?"<null>":this.partyAgreementLastUpdatedTS));
        sb.append(',');
        sb.append("emailLastUpdatedTS");
        sb.append('=');
        sb.append(((this.emailLastUpdatedTS == null)?"<null>":this.emailLastUpdatedTS));
        sb.append(',');
        sb.append("emailAddressLastUpdatedTS");
        sb.append('=');
        sb.append(((this.emailAddressLastUpdatedTS == null)?"<null>":this.emailAddressLastUpdatedTS));
        sb.append(',');
        sb.append("businessPhoneEffectiveTS");
        sb.append('=');
        sb.append(((this.businessPhoneEffectiveTS == null)?"<null>":this.businessPhoneEffectiveTS));
        sb.append(',');
        sb.append("businessPhoneEndTS");
        sb.append('=');
        sb.append(((this.businessPhoneEndTS == null)?"<null>":this.businessPhoneEndTS));
        sb.append(',');
        sb.append("businessPhoneLastUpdatedTS");
        sb.append('=');
        sb.append(((this.businessPhoneLastUpdatedTS == null)?"<null>":this.businessPhoneLastUpdatedTS));
        sb.append(',');
        sb.append("businessPhoneLocLastUpdatedTS");
        sb.append('=');
        sb.append(((this.businessPhoneLocLastUpdatedTS == null)?"<null>":this.businessPhoneLocLastUpdatedTS));
        sb.append(',');
        sb.append("homePhoneEffectiveTS");
        sb.append('=');
        sb.append(((this.homePhoneEffectiveTS == null)?"<null>":this.homePhoneEffectiveTS));
        sb.append(',');
        sb.append("homePhoneEndTS");
        sb.append('=');
        sb.append(((this.homePhoneEndTS == null)?"<null>":this.homePhoneEndTS));
        sb.append(',');
        sb.append("homePhoneLastUpdatedTS");
        sb.append('=');
        sb.append(((this.homePhoneLastUpdatedTS == null)?"<null>":this.homePhoneLastUpdatedTS));
        sb.append(',');
        sb.append("homePhoneLocLastUpdatedTS");
        sb.append('=');
        sb.append(((this.homePhoneLocLastUpdatedTS == null)?"<null>":this.homePhoneLocLastUpdatedTS));
        sb.append(',');
        sb.append("mobilePhoneEffectiveTS");
        sb.append('=');
        sb.append(((this.mobilePhoneEffectiveTS == null)?"<null>":this.mobilePhoneEffectiveTS));
        sb.append(',');
        sb.append("mobilePhoneEndTS");
        sb.append('=');
        sb.append(((this.mobilePhoneEndTS == null)?"<null>":this.mobilePhoneEndTS));
        sb.append(',');
        sb.append("mobilePhoneLastUpdatedTS");
        sb.append('=');
        sb.append(((this.mobilePhoneLastUpdatedTS == null)?"<null>":this.mobilePhoneLastUpdatedTS));
        sb.append(',');
        sb.append("mobilePhoneLocLastUpdatedTS");
        sb.append('=');
        sb.append(((this.mobilePhoneLocLastUpdatedTS == null)?"<null>":this.mobilePhoneLocLastUpdatedTS));
        sb.append(',');
        sb.append("mailingArgLocLastUpdatedTS");
        sb.append('=');
        sb.append(((this.mailingArgLocLastUpdatedTS == null)?"<null>":this.mailingArgLocLastUpdatedTS));
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
        result = ((result* 31)+((this.homePhonePartyLocationID == null)? 0 :this.homePhonePartyLocationID.hashCode()));
        result = ((result* 31)+((this.updateProfile == null)? 0 :this.updateProfile.hashCode()));
        result = ((result* 31)+((this.differentPhysicalAddress == null)? 0 :this.differentPhysicalAddress.hashCode()));
        result = ((result* 31)+((this.businessPhonePartyLocationID == null)? 0 :this.businessPhonePartyLocationID.hashCode()));
        result = ((result* 31)+((this.unsuccessfulDevilery == null)? 0 :this.unsuccessfulDevilery.hashCode()));
        result = ((result* 31)+((this.emailAddressLastUpdatedTS == null)? 0 :this.emailAddressLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mobilePhonePartyLocationID == null)? 0 :this.mobilePhonePartyLocationID.hashCode()));
        result = ((result* 31)+((this.mobilePhoneLastUpdatedTS == null)? 0 :this.mobilePhoneLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.homePhoneLastUpdatedTS == null)? 0 :this.homePhoneLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.mailingAddressLine1 == null)? 0 :this.mailingAddressLine1 .hashCode()));
        result = ((result* 31)+((this.mobilePhoneLocLastUpdatedTS == null)? 0 :this.mobilePhoneLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mailingAddressLine2 == null)? 0 :this.mailingAddressLine2 .hashCode()));
        result = ((result* 31)+((this.mailingProvince == null)? 0 :this.mailingProvince.hashCode()));
        result = ((result* 31)+((this.partyAgreementLastUpdatedTS == null)? 0 :this.partyAgreementLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.homePhoneEffectiveTS == null)? 0 :this.homePhoneEffectiveTS.hashCode()));
        result = ((result* 31)+((this.mailingArgLocLastUpdatedTS == null)? 0 :this.mailingArgLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mailingCountry == null)? 0 :this.mailingCountry.hashCode()));
        result = ((result* 31)+((this.businessPhoneEffectiveTS == null)? 0 :this.businessPhoneEffectiveTS.hashCode()));
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.mailingEndTS == null)? 0 :this.mailingEndTS.hashCode()));
        result = ((result* 31)+((this.confirmationEmailWanted == null)? 0 :this.confirmationEmailWanted.hashCode()));
        result = ((result* 31)+((this.marketingEmailWanted == null)? 0 :this.marketingEmailWanted.hashCode()));
        result = ((result* 31)+((this.businessPhoneEndTS == null)? 0 :this.businessPhoneEndTS.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.mailingAddressPartyLocationID == null)? 0 :this.mailingAddressPartyLocationID.hashCode()));
        result = ((result* 31)+((this.mailingCity == null)? 0 :this.mailingCity.hashCode()));
        result = ((result* 31)+((this.businessPhoneLocLastUpdatedTS == null)? 0 :this.businessPhoneLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.acctNum == null)? 0 :this.acctNum.hashCode()));
        result = ((result* 31)+((this.updateRequired == null)? 0 :this.updateRequired.hashCode()));
        result = ((result* 31)+((this.homePhone == null)? 0 :this.homePhone.hashCode()));
        result = ((result* 31)+((this.homePhoneLocLastUpdatedTS == null)? 0 :this.homePhoneLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.businessPhoneLastUpdatedTS == null)? 0 :this.businessPhoneLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.cardNumList == null)? 0 :this.cardNumList.hashCode()));
        result = ((result* 31)+((this.mobilePhoneEffectiveTS == null)? 0 :this.mobilePhoneEffectiveTS.hashCode()));
        result = ((result* 31)+((this.mailingLastUpdatedTS == null)? 0 :this.mailingLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mailingPostalCode == null)? 0 :this.mailingPostalCode.hashCode()));
        result = ((result* 31)+((this.mobilePhone == null)? 0 :this.mobilePhone.hashCode()));
        result = ((result* 31)+((this.mobilePhoneEndTS == null)? 0 :this.mobilePhoneEndTS.hashCode()));
        result = ((result* 31)+((this.homePhoneEndTS == null)? 0 :this.homePhoneEndTS.hashCode()));
        result = ((result* 31)+((this.businessPhone == null)? 0 :this.businessPhone.hashCode()));
        result = ((result* 31)+((this.emailLastUpdatedTS == null)? 0 :this.emailLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.emailPartyLocationID == null)? 0 :this.emailPartyLocationID.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerAcctInfoType) == false) {
            return false;
        }
        CustomerAcctInfoType rhs = ((CustomerAcctInfoType) other);
        return ((((((((((((((((((((((((((((((((((((((((((((this.homePhonePartyLocationID == rhs.homePhonePartyLocationID)||((this.homePhonePartyLocationID!= null)&&this.homePhonePartyLocationID.equals(rhs.homePhonePartyLocationID)))&&((this.updateProfile == rhs.updateProfile)||((this.updateProfile!= null)&&this.updateProfile.equals(rhs.updateProfile))))&&((this.differentPhysicalAddress == rhs.differentPhysicalAddress)||((this.differentPhysicalAddress!= null)&&this.differentPhysicalAddress.equals(rhs.differentPhysicalAddress))))&&((this.businessPhonePartyLocationID == rhs.businessPhonePartyLocationID)||((this.businessPhonePartyLocationID!= null)&&this.businessPhonePartyLocationID.equals(rhs.businessPhonePartyLocationID))))&&((this.unsuccessfulDevilery == rhs.unsuccessfulDevilery)||((this.unsuccessfulDevilery!= null)&&this.unsuccessfulDevilery.equals(rhs.unsuccessfulDevilery))))&&((this.emailAddressLastUpdatedTS == rhs.emailAddressLastUpdatedTS)||((this.emailAddressLastUpdatedTS!= null)&&this.emailAddressLastUpdatedTS.equals(rhs.emailAddressLastUpdatedTS))))&&((this.mobilePhonePartyLocationID == rhs.mobilePhonePartyLocationID)||((this.mobilePhonePartyLocationID!= null)&&this.mobilePhonePartyLocationID.equals(rhs.mobilePhonePartyLocationID))))&&((this.mobilePhoneLastUpdatedTS == rhs.mobilePhoneLastUpdatedTS)||((this.mobilePhoneLastUpdatedTS!= null)&&this.mobilePhoneLastUpdatedTS.equals(rhs.mobilePhoneLastUpdatedTS))))&&((this.homePhoneLastUpdatedTS == rhs.homePhoneLastUpdatedTS)||((this.homePhoneLastUpdatedTS!= null)&&this.homePhoneLastUpdatedTS.equals(rhs.homePhoneLastUpdatedTS))))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.mailingAddressLine1 == rhs.mailingAddressLine1)||((this.mailingAddressLine1 != null)&&this.mailingAddressLine1 .equals(rhs.mailingAddressLine1))))&&((this.mobilePhoneLocLastUpdatedTS == rhs.mobilePhoneLocLastUpdatedTS)||((this.mobilePhoneLocLastUpdatedTS!= null)&&this.mobilePhoneLocLastUpdatedTS.equals(rhs.mobilePhoneLocLastUpdatedTS))))&&((this.mailingAddressLine2 == rhs.mailingAddressLine2)||((this.mailingAddressLine2 != null)&&this.mailingAddressLine2 .equals(rhs.mailingAddressLine2))))&&((this.mailingProvince == rhs.mailingProvince)||((this.mailingProvince!= null)&&this.mailingProvince.equals(rhs.mailingProvince))))&&((this.partyAgreementLastUpdatedTS == rhs.partyAgreementLastUpdatedTS)||((this.partyAgreementLastUpdatedTS!= null)&&this.partyAgreementLastUpdatedTS.equals(rhs.partyAgreementLastUpdatedTS))))&&((this.homePhoneEffectiveTS == rhs.homePhoneEffectiveTS)||((this.homePhoneEffectiveTS!= null)&&this.homePhoneEffectiveTS.equals(rhs.homePhoneEffectiveTS))))&&((this.mailingArgLocLastUpdatedTS == rhs.mailingArgLocLastUpdatedTS)||((this.mailingArgLocLastUpdatedTS!= null)&&this.mailingArgLocLastUpdatedTS.equals(rhs.mailingArgLocLastUpdatedTS))))&&((this.mailingCountry == rhs.mailingCountry)||((this.mailingCountry!= null)&&this.mailingCountry.equals(rhs.mailingCountry))))&&((this.businessPhoneEffectiveTS == rhs.businessPhoneEffectiveTS)||((this.businessPhoneEffectiveTS!= null)&&this.businessPhoneEffectiveTS.equals(rhs.businessPhoneEffectiveTS))))&&((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId))))&&((this.mailingEndTS == rhs.mailingEndTS)||((this.mailingEndTS!= null)&&this.mailingEndTS.equals(rhs.mailingEndTS))))&&((this.confirmationEmailWanted == rhs.confirmationEmailWanted)||((this.confirmationEmailWanted!= null)&&this.confirmationEmailWanted.equals(rhs.confirmationEmailWanted))))&&((this.marketingEmailWanted == rhs.marketingEmailWanted)||((this.marketingEmailWanted!= null)&&this.marketingEmailWanted.equals(rhs.marketingEmailWanted))))&&((this.businessPhoneEndTS == rhs.businessPhoneEndTS)||((this.businessPhoneEndTS!= null)&&this.businessPhoneEndTS.equals(rhs.businessPhoneEndTS))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.mailingAddressPartyLocationID == rhs.mailingAddressPartyLocationID)||((this.mailingAddressPartyLocationID!= null)&&this.mailingAddressPartyLocationID.equals(rhs.mailingAddressPartyLocationID))))&&((this.mailingCity == rhs.mailingCity)||((this.mailingCity!= null)&&this.mailingCity.equals(rhs.mailingCity))))&&((this.businessPhoneLocLastUpdatedTS == rhs.businessPhoneLocLastUpdatedTS)||((this.businessPhoneLocLastUpdatedTS!= null)&&this.businessPhoneLocLastUpdatedTS.equals(rhs.businessPhoneLocLastUpdatedTS))))&&((this.acctNum == rhs.acctNum)||((this.acctNum!= null)&&this.acctNum.equals(rhs.acctNum))))&&((this.updateRequired == rhs.updateRequired)||((this.updateRequired!= null)&&this.updateRequired.equals(rhs.updateRequired))))&&((this.homePhone == rhs.homePhone)||((this.homePhone!= null)&&this.homePhone.equals(rhs.homePhone))))&&((this.homePhoneLocLastUpdatedTS == rhs.homePhoneLocLastUpdatedTS)||((this.homePhoneLocLastUpdatedTS!= null)&&this.homePhoneLocLastUpdatedTS.equals(rhs.homePhoneLocLastUpdatedTS))))&&((this.businessPhoneLastUpdatedTS == rhs.businessPhoneLastUpdatedTS)||((this.businessPhoneLastUpdatedTS!= null)&&this.businessPhoneLastUpdatedTS.equals(rhs.businessPhoneLastUpdatedTS))))&&((this.cardNumList == rhs.cardNumList)||((this.cardNumList!= null)&&this.cardNumList.equals(rhs.cardNumList))))&&((this.mobilePhoneEffectiveTS == rhs.mobilePhoneEffectiveTS)||((this.mobilePhoneEffectiveTS!= null)&&this.mobilePhoneEffectiveTS.equals(rhs.mobilePhoneEffectiveTS))))&&((this.mailingLastUpdatedTS == rhs.mailingLastUpdatedTS)||((this.mailingLastUpdatedTS!= null)&&this.mailingLastUpdatedTS.equals(rhs.mailingLastUpdatedTS))))&&((this.mailingPostalCode == rhs.mailingPostalCode)||((this.mailingPostalCode!= null)&&this.mailingPostalCode.equals(rhs.mailingPostalCode))))&&((this.mobilePhone == rhs.mobilePhone)||((this.mobilePhone!= null)&&this.mobilePhone.equals(rhs.mobilePhone))))&&((this.mobilePhoneEndTS == rhs.mobilePhoneEndTS)||((this.mobilePhoneEndTS!= null)&&this.mobilePhoneEndTS.equals(rhs.mobilePhoneEndTS))))&&((this.homePhoneEndTS == rhs.homePhoneEndTS)||((this.homePhoneEndTS!= null)&&this.homePhoneEndTS.equals(rhs.homePhoneEndTS))))&&((this.businessPhone == rhs.businessPhone)||((this.businessPhone!= null)&&this.businessPhone.equals(rhs.businessPhone))))&&((this.emailLastUpdatedTS == rhs.emailLastUpdatedTS)||((this.emailLastUpdatedTS!= null)&&this.emailLastUpdatedTS.equals(rhs.emailLastUpdatedTS))))&&((this.emailPartyLocationID == rhs.emailPartyLocationID)||((this.emailPartyLocationID!= null)&&this.emailPartyLocationID.equals(rhs.emailPartyLocationID))));
    }

}
