package com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;
import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.UnformattedAddress;
import com.td.mbna.msec.midtier.types.common.UserNameType;

import java.io.Serializable;

public class RequestPayload implements Serializable {

	private static final long serialVersionUID = 1L;
    private UserNameType userName;
    private Boolean addressSameAsPrimary;
    private UnformattedAddress authorizedUserAddress;
    private UnformattedAddress primaryUserAddress;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long dateOfBirth;
    private String businessPhone;
    private String homePhone;
    private String mobilePhone;
    private String relationToPrimaryUser;
    private Boolean confirmed;
    private DisclosureInfoType disclosureInfo;
    private EmailNotificationInfoType emailNotificationInfo;

    public UserNameType getUserName() {
        return userName;
    }

    public void setUserName(UserNameType userName) {
        this.userName = userName;
    }

    public Boolean getAddressSameAsPrimary() {
        return addressSameAsPrimary;
    }

    public void setAddressSameAsPrimary(Boolean addressSameAsPrimary) {
        this.addressSameAsPrimary = addressSameAsPrimary;
    }

    public UnformattedAddress getAuthorizedUserAddress() {
        return authorizedUserAddress;
    }

    public void setAuthorizedUserAddress(UnformattedAddress authorizedUserAddress) {
        this.authorizedUserAddress = authorizedUserAddress;
    }

    public UnformattedAddress getPrimaryUserAddress() {
        return primaryUserAddress;
    }

    public void setPrimaryUserAddress(UnformattedAddress primaryUserAddress) {
        this.primaryUserAddress = primaryUserAddress;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getRelationToPrimaryUser() {
        return relationToPrimaryUser;
    }

    public void setRelationToPrimaryUser(String relationToPrimaryUser) {
        this.relationToPrimaryUser = relationToPrimaryUser;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("userName");
        sb.append('=');
        sb.append(((this.userName == null)?"<null>":this.userName));
        sb.append(',');
        sb.append("addressSameAsPrimary");
        sb.append('=');
        sb.append(((this.addressSameAsPrimary == null)?"<null>":this.addressSameAsPrimary));
        sb.append(',');
        sb.append("authorizedUserAddress");
        sb.append('=');
        sb.append(((this.authorizedUserAddress == null)?"<null>":this.authorizedUserAddress));
        sb.append(',');
        sb.append("primaryUserAddress");
        sb.append('=');
        sb.append(((this.primaryUserAddress == null)?"<null>":this.primaryUserAddress));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("businessPhone");
        sb.append('=');
        sb.append(((this.businessPhone == null)?"<null>":this.businessPhone));
        sb.append(',');
        sb.append("homePhone");
        sb.append('=');
        sb.append(((this.homePhone == null)?"<null>":this.homePhone));
        sb.append(',');
        sb.append("mobilePhone");
        sb.append('=');
        sb.append(((this.mobilePhone == null)?"<null>":this.mobilePhone));
        sb.append(',');
        sb.append("relationToPrimaryUser");
        sb.append('=');
        sb.append(((this.relationToPrimaryUser == null)?"<null>":this.relationToPrimaryUser));
        sb.append(',');
        sb.append("confirmed");
        sb.append('=');
        sb.append(((this.confirmed == null)?"<null>":this.confirmed));
        sb.append(',');
        sb.append("disclosureInfo");
        sb.append('=');
        sb.append(((this.disclosureInfo == null)?"<null>":this.disclosureInfo));
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
        result = ((result* 31)+((this.relationToPrimaryUser == null)? 0 :this.relationToPrimaryUser.hashCode()));
        result = ((result* 31)+((this.authorizedUserAddress == null)? 0 :this.authorizedUserAddress.hashCode()));
        result = ((result* 31)+((this.homePhone == null)? 0 :this.homePhone.hashCode()));
        result = ((result* 31)+((this.emailNotificationInfo == null)? 0 :this.emailNotificationInfo.hashCode()));
        result = ((result* 31)+((this.dateOfBirth == null)? 0 :this.dateOfBirth.hashCode()));
        result = ((result* 31)+((this.userName == null)? 0 :this.userName.hashCode()));
        result = ((result* 31)+((this.confirmed == null)? 0 :this.confirmed.hashCode()));
        result = ((result* 31)+((this.primaryUserAddress == null)? 0 :this.primaryUserAddress.hashCode()));
        result = ((result* 31)+((this.mobilePhone == null)? 0 :this.mobilePhone.hashCode()));
        result = ((result* 31)+((this.addressSameAsPrimary == null)? 0 :this.addressSameAsPrimary.hashCode()));
        result = ((result* 31)+((this.disclosureInfo == null)? 0 :this.disclosureInfo.hashCode()));
        result = ((result* 31)+((this.businessPhone == null)? 0 :this.businessPhone.hashCode()));
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
        return (((((((((((((this.relationToPrimaryUser == rhs.relationToPrimaryUser)||((this.relationToPrimaryUser!= null)&&this.relationToPrimaryUser.equals(rhs.relationToPrimaryUser)))&&((this.authorizedUserAddress == rhs.authorizedUserAddress)||((this.authorizedUserAddress!= null)&&this.authorizedUserAddress.equals(rhs.authorizedUserAddress))))&&((this.homePhone == rhs.homePhone)||((this.homePhone!= null)&&this.homePhone.equals(rhs.homePhone))))&&((this.emailNotificationInfo == rhs.emailNotificationInfo)||((this.emailNotificationInfo!= null)&&this.emailNotificationInfo.equals(rhs.emailNotificationInfo))))&&((this.dateOfBirth == rhs.dateOfBirth)||((this.dateOfBirth!= null)&&this.dateOfBirth.equals(rhs.dateOfBirth))))&&((this.userName == rhs.userName)||((this.userName!= null)&&this.userName.equals(rhs.userName))))&&((this.confirmed == rhs.confirmed)||((this.confirmed!= null)&&this.confirmed.equals(rhs.confirmed))))&&((this.primaryUserAddress == rhs.primaryUserAddress)||((this.primaryUserAddress!= null)&&this.primaryUserAddress.equals(rhs.primaryUserAddress))))&&((this.mobilePhone == rhs.mobilePhone)||((this.mobilePhone!= null)&&this.mobilePhone.equals(rhs.mobilePhone))))&&((this.addressSameAsPrimary == rhs.addressSameAsPrimary)||((this.addressSameAsPrimary!= null)&&this.addressSameAsPrimary.equals(rhs.addressSameAsPrimary))))&&((this.disclosureInfo == rhs.disclosureInfo)||((this.disclosureInfo!= null)&&this.disclosureInfo.equals(rhs.disclosureInfo))))&&((this.businessPhone == rhs.businessPhone)||((this.businessPhone!= null)&&this.businessPhone.equals(rhs.businessPhone))));
    }

}
