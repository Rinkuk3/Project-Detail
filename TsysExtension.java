package com.td.api.mbcca.response.account;

public class TsysExtension {

    private String customerId;
    private String businessContactName;
    private String powerOfAttorneyName;
    private String lastName;
    private String firstName;
    private String middleName;
    private String titlePrefix;
    private String birthDt;
    private String identityVerificationVal;
    private String cardNum;
    private String cardNumMasked;
    private Object nameSuffix;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBusinessContactName() {
        return businessContactName;
    }

    public void setBusinessContactName(String businessContactName) {
        this.businessContactName = businessContactName;
    }

    public String getPowerOfAttorneyName() {
        return powerOfAttorneyName;
    }

    public void setPowerOfAttorneyName(String powerOfAttorneyName) {
        this.powerOfAttorneyName = powerOfAttorneyName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTitlePrefix() {
        return titlePrefix;
    }

    public void setTitlePrefix(String titlePrefix) {
        this.titlePrefix = titlePrefix;
    }

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    public String getIdentityVerificationVal() {
        return identityVerificationVal;
    }

    public void setIdentityVerificationVal(String identityVerificationVal) {
        this.identityVerificationVal = identityVerificationVal;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardNumMasked() {
        return cardNumMasked;
    }

    public void setCardNumMasked(String cardNumMasked) {
        this.cardNumMasked = cardNumMasked;
    }

    public Object getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(Object nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TsysExtension.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customerId");
        sb.append('=');
        sb.append(((this.customerId == null)?"<null>":this.customerId));
        sb.append(',');
        sb.append("businessContactName");
        sb.append('=');
        sb.append(((this.businessContactName == null)?"<null>":this.businessContactName));
        sb.append(',');
        sb.append("powerOfAttorneyName");
        sb.append('=');
        sb.append(((this.powerOfAttorneyName == null)?"<null>":this.powerOfAttorneyName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("middleName");
        sb.append('=');
        sb.append(((this.middleName == null)?"<null>":this.middleName));
        sb.append(',');
        sb.append("titlePrefix");
        sb.append('=');
        sb.append(((this.titlePrefix == null)?"<null>":this.titlePrefix));
        sb.append(',');
        sb.append("birthDt");
        sb.append('=');
        sb.append(((this.birthDt == null)?"<null>":this.birthDt));
        sb.append(',');
        sb.append("identityVerificationVal");
        sb.append('=');
        sb.append(((this.identityVerificationVal == null)?"<null>":this.identityVerificationVal));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("cardNumMasked");
        sb.append('=');
        sb.append(((this.cardNumMasked == null)?"<null>":this.cardNumMasked));
        sb.append(',');
        sb.append("nameSuffix");
        sb.append('=');
        sb.append(((this.nameSuffix == null)?"<null>":this.nameSuffix));
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
        result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
        result = ((result* 31)+((this.birthDt == null)? 0 :this.birthDt.hashCode()));
        result = ((result* 31)+((this.identityVerificationVal == null)? 0 :this.identityVerificationVal.hashCode()));
        result = ((result* 31)+((this.nameSuffix == null)? 0 :this.nameSuffix.hashCode()));
        result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.powerOfAttorneyName == null)? 0 :this.powerOfAttorneyName.hashCode()));
        result = ((result* 31)+((this.customerId == null)? 0 :this.customerId.hashCode()));
        result = ((result* 31)+((this.middleName == null)? 0 :this.middleName.hashCode()));
        result = ((result* 31)+((this.titlePrefix == null)? 0 :this.titlePrefix.hashCode()));
        result = ((result* 31)+((this.businessContactName == null)? 0 :this.businessContactName.hashCode()));
        result = ((result* 31)+((this.cardNumMasked == null)? 0 :this.cardNumMasked.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TsysExtension) == false) {
            return false;
        }
        TsysExtension rhs = ((TsysExtension) other);
        return (((((((((((((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName)))&&((this.birthDt == rhs.birthDt)||((this.birthDt!= null)&&this.birthDt.equals(rhs.birthDt))))&&((this.identityVerificationVal == rhs.identityVerificationVal)||((this.identityVerificationVal!= null)&&this.identityVerificationVal.equals(rhs.identityVerificationVal))))&&((this.nameSuffix == rhs.nameSuffix)||((this.nameSuffix!= null)&&this.nameSuffix.equals(rhs.nameSuffix))))&&((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName))))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.powerOfAttorneyName == rhs.powerOfAttorneyName)||((this.powerOfAttorneyName!= null)&&this.powerOfAttorneyName.equals(rhs.powerOfAttorneyName))))&&((this.customerId == rhs.customerId)||((this.customerId!= null)&&this.customerId.equals(rhs.customerId))))&&((this.middleName == rhs.middleName)||((this.middleName!= null)&&this.middleName.equals(rhs.middleName))))&&((this.titlePrefix == rhs.titlePrefix)||((this.titlePrefix!= null)&&this.titlePrefix.equals(rhs.titlePrefix))))&&((this.businessContactName == rhs.businessContactName)||((this.businessContactName!= null)&&this.businessContactName.equals(rhs.businessContactName))))&&((this.cardNumMasked == rhs.cardNumMasked)||((this.cardNumMasked!= null)&&this.cardNumMasked.equals(rhs.cardNumMasked))));
    }

}
