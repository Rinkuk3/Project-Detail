package com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;
import com.td.mbna.msec.midtier.types.common.UnformattedAddress;
import com.td.mbna.msec.midtier.types.common.UserNameType;

import java.io.Serializable;

public class ResponsePayload implements Serializable {

	private static final long serialVersionUID = 3602941275384507389L;
    private String newCustId;
    private String newAliasCustId;
    private UserNameType userName;
    private UnformattedAddress authorizedUserAddress;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long dateOfBirth;
    private String businessPhone;
    private String homePhone;
    private String mobilePhone;
    private String relationToPrimaryUser;

    public String getNewCustId() {
        return newCustId;
    }

    public void setNewCustId(String newCustId) {
        this.newCustId = newCustId;
    }

    public String getNewAliasCustId() {
        return newAliasCustId;
    }

    public void setNewAliasCustId(String newAliasCustId) {
        this.newAliasCustId = newAliasCustId;
    }

    public UserNameType getUserName() {
        return userName;
    }

    public void setUserName(UserNameType userName) {
        this.userName = userName;
    }

    public UnformattedAddress getAuthorizedUserAddress() {
        return authorizedUserAddress;
    }

    public void setAuthorizedUserAddress(UnformattedAddress authorizedUserAddress) {
        this.authorizedUserAddress = authorizedUserAddress;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("newCustId");
        sb.append('=');
        sb.append(((this.newCustId == null)?"<null>":this.newCustId));
        sb.append(',');
        sb.append("newAliasCustId");
        sb.append('=');
        sb.append(((this.newAliasCustId == null)?"<null>":this.newAliasCustId));
        sb.append(',');
        sb.append("userName");
        sb.append('=');
        sb.append(((this.userName == null)?"<null>":this.userName));
        sb.append(',');
        sb.append("authorizedUserAddress");
        sb.append('=');
        sb.append(((this.authorizedUserAddress == null)?"<null>":this.authorizedUserAddress));
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
        result = ((result* 31)+((this.newCustId == null)? 0 :this.newCustId.hashCode()));
        result = ((result* 31)+((this.relationToPrimaryUser == null)? 0 :this.relationToPrimaryUser.hashCode()));
        result = ((result* 31)+((this.newAliasCustId == null)? 0 :this.newAliasCustId.hashCode()));
        result = ((result* 31)+((this.authorizedUserAddress == null)? 0 :this.authorizedUserAddress.hashCode()));
        result = ((result* 31)+((this.mobilePhone == null)? 0 :this.mobilePhone.hashCode()));
        result = ((result* 31)+((this.homePhone == null)? 0 :this.homePhone.hashCode()));
        result = ((result* 31)+((this.dateOfBirth == null)? 0 :this.dateOfBirth.hashCode()));
        result = ((result* 31)+((this.businessPhone == null)? 0 :this.businessPhone.hashCode()));
        result = ((result* 31)+((this.userName == null)? 0 :this.userName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return ((((((((((this.newCustId == rhs.newCustId)||((this.newCustId!= null)&&this.newCustId.equals(rhs.newCustId)))&&((this.relationToPrimaryUser == rhs.relationToPrimaryUser)||((this.relationToPrimaryUser!= null)&&this.relationToPrimaryUser.equals(rhs.relationToPrimaryUser))))&&((this.newAliasCustId == rhs.newAliasCustId)||((this.newAliasCustId!= null)&&this.newAliasCustId.equals(rhs.newAliasCustId))))&&((this.authorizedUserAddress == rhs.authorizedUserAddress)||((this.authorizedUserAddress!= null)&&this.authorizedUserAddress.equals(rhs.authorizedUserAddress))))&&((this.mobilePhone == rhs.mobilePhone)||((this.mobilePhone!= null)&&this.mobilePhone.equals(rhs.mobilePhone))))&&((this.homePhone == rhs.homePhone)||((this.homePhone!= null)&&this.homePhone.equals(rhs.homePhone))))&&((this.dateOfBirth == rhs.dateOfBirth)||((this.dateOfBirth!= null)&&this.dateOfBirth.equals(rhs.dateOfBirth))))&&((this.businessPhone == rhs.businessPhone)||((this.businessPhone!= null)&&this.businessPhone.equals(rhs.businessPhone))))&&((this.userName == rhs.userName)||((this.userName!= null)&&this.userName.equals(rhs.userName))));
    }

}
