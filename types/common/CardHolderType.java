package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;

public class CardHolderType implements Serializable {

	private static final long serialVersionUID = 1L;
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String suffixCd;
    protected String customerID;
    protected Boolean primaryUser;
    protected String languageCode;
    protected String aliasCustomerID;
    protected String birthDate;
    protected String cardHolderName;
    protected String cardNumber;
    protected String transferFromCardNumber;
    protected List<String> historicalCardNumbers;
    
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    protected Long legalNameLastUpdatedTS;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffixCd() {
        return suffixCd;
    }

    public void setSuffixCd(String suffixCd) {
        this.suffixCd = suffixCd;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Boolean isPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(Boolean primaryUser) {
        this.primaryUser = primaryUser;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Long getLegalNameLastUpdatedTS() {
        return legalNameLastUpdatedTS;
    }

    public void setLegalNameLastUpdatedTS(Long legalNameLastUpdatedTS) {
        this.legalNameLastUpdatedTS = legalNameLastUpdatedTS;
    }

    public String getAliasCustomerID() {
        return aliasCustomerID;
    }

    public void setAliasCustomerID(String aliasCustomerID) {
        this.aliasCustomerID = aliasCustomerID;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getTransferFromCardNumber() {
        return transferFromCardNumber;
    }

    public void setTransferFromCardNumber(String transferFromCardNumber) {
        this.transferFromCardNumber = transferFromCardNumber;
    }

    public List<String> getHistoricalCardNumbers() {
        return historicalCardNumbers;
    }

    public void setHistoricalCardNumbers(List<String> historicalCardNumbers) {
        this.historicalCardNumbers = historicalCardNumbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardHolderType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("middleName");
        sb.append('=');
        sb.append(((this.middleName == null)?"<null>":this.middleName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("suffixCd");
        sb.append('=');
        sb.append(((this.suffixCd == null)?"<null>":this.suffixCd));
        sb.append(',');
        sb.append("customerID");
        sb.append('=');
        sb.append(((this.customerID == null)?"<null>":this.customerID));
        sb.append(',');
        sb.append("primaryUser");
        sb.append('=');
        sb.append(((this.primaryUser == null)?"<null>":this.primaryUser));
        sb.append(',');
        sb.append("languageCode");
        sb.append('=');
        sb.append(((this.languageCode == null)?"<null>":this.languageCode));
        sb.append(',');
        sb.append("legalNameLastUpdatedTS");
        sb.append('=');
        sb.append(((this.legalNameLastUpdatedTS == null)?"<null>":this.legalNameLastUpdatedTS));
        sb.append(',');
        sb.append("aliasCustomerID");
        sb.append('=');
        sb.append(((this.aliasCustomerID == null)?"<null>":this.aliasCustomerID));
        sb.append(',');
        sb.append("birthDate");
        sb.append('=');
        sb.append(((this.birthDate == null)?"<null>":this.birthDate));
        sb.append(',');

        sb.append("cardHolderName");
        sb.append('=');
        sb.append(((this.cardHolderName == null)?"<null>":this.cardHolderName));
        sb.append(',');

        sb.append("cardNumber");
        sb.append('=');
        sb.append(((this.cardNumber == null)?"<null>":this.cardNumber));
        sb.append(',');

        sb.append("transferFromCardNumber");
        sb.append('=');
        sb.append(((this.transferFromCardNumber == null)?"<null>":this.transferFromCardNumber));
        sb.append(',');

        sb.append("historicalCardNumbers");
        sb.append('=');
        sb.append(((this.historicalCardNumbers == null)?"<null>":this.historicalCardNumbers));
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
        result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
        result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
        result = ((result* 31)+((this.primaryUser == null)? 0 :this.primaryUser.hashCode()));
        result = ((result* 31)+((this.customerID == null)? 0 :this.customerID.hashCode()));
        result = ((result* 31)+((this.aliasCustomerID == null)? 0 :this.aliasCustomerID.hashCode()));
        result = ((result* 31)+((this.middleName == null)? 0 :this.middleName.hashCode()));
        result = ((result* 31)+((this.legalNameLastUpdatedTS == null)? 0 :this.legalNameLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.languageCode == null)? 0 :this.languageCode.hashCode()));
        result = ((result* 31)+((this.birthDate == null)? 0 :this.birthDate.hashCode()));
        result = ((result* 31)+((this.suffixCd == null)? 0 :this.suffixCd.hashCode()));

        result = ((result* 31)+((this.cardHolderName == null)? 0 :this.cardHolderName.hashCode()));
        result = ((result* 31)+((this.cardNumber == null)? 0 :this.cardNumber.hashCode()));
        result = ((result* 31)+((this.transferFromCardNumber == null)? 0 :this.transferFromCardNumber.hashCode()));
        result = ((result* 31)+((this.historicalCardNumbers == null)? 0 :this.historicalCardNumbers.hashCode()));

        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardHolderType) == false) {
            return false;
        }
        CardHolderType rhs = ((CardHolderType) other);
        return (((((((((((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName)))&&((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName))))&&((this.primaryUser == rhs.primaryUser)||((this.primaryUser!= null)&&this.primaryUser.equals(rhs.primaryUser))))&&((this.customerID == rhs.customerID)||((this.customerID!= null)&&this.customerID.equals(rhs.customerID))))&&((this.aliasCustomerID == rhs.aliasCustomerID)||((this.aliasCustomerID!= null)&&this.aliasCustomerID.equals(rhs.aliasCustomerID))))&&((this.middleName == rhs.middleName)||((this.middleName!= null)&&this.middleName.equals(rhs.middleName))))&&((this.legalNameLastUpdatedTS == rhs.legalNameLastUpdatedTS)||((this.legalNameLastUpdatedTS!= null)&&this.legalNameLastUpdatedTS.equals(rhs.legalNameLastUpdatedTS))))&&((this.languageCode == rhs.languageCode)||((this.languageCode!= null)&&this.languageCode.equals(rhs.languageCode))))&&((this.birthDate == rhs.birthDate)||((this.birthDate!= null)&&this.birthDate.equals(rhs.birthDate))))&&((this.suffixCd == rhs.suffixCd)||((this.suffixCd!= null)&&this.suffixCd.equals(rhs.suffixCd)))
                &&((this.cardHolderName == rhs.cardHolderName)||((this.cardHolderName!= null)&&this.cardHolderName.equals(rhs.cardHolderName)))
                &&((this.cardNumber == rhs.cardNumber)||((this.cardNumber!= null)&&this.cardNumber.equals(rhs.cardNumber)))
                &&((this.transferFromCardNumber == rhs.transferFromCardNumber)||((this.transferFromCardNumber!= null)&&this.transferFromCardNumber.equals(rhs.transferFromCardNumber)))
                &&((this.historicalCardNumbers == rhs.historicalCardNumbers)||((this.historicalCardNumbers!= null)&&this.historicalCardNumbers.equals(rhs.historicalCardNumbers))));
    }

}
