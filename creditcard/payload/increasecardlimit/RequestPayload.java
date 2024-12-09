package com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;
import com.td.mbna.msec.midtier.types.common.CustomerIncomeInfoType;
import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;

public class RequestPayload implements Serializable {

	private static final long serialVersionUID = 4605822980380825061L;
    private String custId;
    private String custName;
    private String acctId;
    private String cardNum;
    private BigDecimal creditLimit;
    private BigDecimal currentCreditLimit;
    private BigDecimal currentBalance;
    private BigDecimal unbilledAmount;
    private String email;
    private String phone;
    private Boolean confirmed;
    private Boolean emailRequired;
    private String promotionOfferId;
    private Boolean longForm;
    private BigDecimal promotionOfferAmount;
    private DisclosureInfoType disclosureInfo;
    private CustomerIncomeInfoType customerInfo;
    private EmailNotificationInfoType emailNotificationInfo;
    private String roleCD;
    private String position;
    private String employerName;
    private String employerAddress;
    private String employerCity;
    private String employerProvince;
    private String employerPostalCode;
    private String employerPhoneType;
    private String employerPhone;
    private String natureOfBusiness;
    private String employmentStatus;
    private String lengthOfService;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long personLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long bookOfBusLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long primIncomeLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long otherIncomeLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long employmentLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long partyAgreementLastUpdatedTS;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCurrentCreditLimit() {
        return currentCreditLimit;
    }

    public void setCurrentCreditLimit(BigDecimal currentCreditLimit) {
        this.currentCreditLimit = currentCreditLimit;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getUnbilledAmount() {
        return unbilledAmount;
    }

    public void setUnbilledAmount(BigDecimal unbilledAmount) {
        this.unbilledAmount = unbilledAmount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getEmailRequired() {
        return emailRequired;
    }

    public void setEmailRequired(Boolean emailRequired) {
        this.emailRequired = emailRequired;
    }

    public String getPromotionOfferId() {
        return promotionOfferId;
    }

    public void setPromotionOfferId(String promotionOfferId) {
        this.promotionOfferId = promotionOfferId;
    }

    public Boolean getLongForm() {
        return longForm;
    }

    public void setLongForm(Boolean longForm) {
        this.longForm = longForm;
    }

    public BigDecimal getPromotionOfferAmount() {
        return promotionOfferAmount;
    }

    public void setPromotionOfferAmount(BigDecimal promotionOfferAmount) {
        this.promotionOfferAmount = promotionOfferAmount;
    }

    public DisclosureInfoType getDisclosureInfo() {
        return disclosureInfo;
    }

    public void setDisclosureInfo(DisclosureInfoType disclosureInfo) {
        this.disclosureInfo = disclosureInfo;
    }

    public CustomerIncomeInfoType getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerIncomeInfoType customerInfo) {
        this.customerInfo = customerInfo;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    public String getRoleCD() {
        return roleCD;
    }

    public void setRoleCD(String roleCD) {
        this.roleCD = roleCD;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getEmployerCity() {
        return employerCity;
    }

    public void setEmployerCity(String employerCity) {
        this.employerCity = employerCity;
    }

    public String getEmployerProvince() {
        return employerProvince;
    }

    public void setEmployerProvince(String employerProvince) {
        this.employerProvince = employerProvince;
    }

    public String getEmployerPostalCode() {
        return employerPostalCode;
    }

    public void setEmployerPostalCode(String employerPostalCode) {
        this.employerPostalCode = employerPostalCode;
    }

    public String getEmployerPhoneType() {
        return employerPhoneType;
    }

    public void setEmployerPhoneType(String employerPhoneType) {
        this.employerPhoneType = employerPhoneType;
    }

    public String getEmployerPhone() {
        return employerPhone;
    }

    public void setEmployerPhone(String employerPhone) {
        this.employerPhone = employerPhone;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getLengthOfService() {
        return lengthOfService;
    }

    public void setLengthOfService(String lengthOfService) {
        this.lengthOfService = lengthOfService;
    }

    public Long getPersonLastUpdatedTS() {
        return personLastUpdatedTS;
    }

    public void setPersonLastUpdatedTS(Long personLastUpdatedTS) {
        this.personLastUpdatedTS = personLastUpdatedTS;
    }

    public Long getBookOfBusLastUpdatedTS() {
        return bookOfBusLastUpdatedTS;
    }

    public void setBookOfBusLastUpdatedTS(Long bookOfBusLastUpdatedTS) {
        this.bookOfBusLastUpdatedTS = bookOfBusLastUpdatedTS;
    }

    public Long getPrimIncomeLastUpdatedTS() {
        return primIncomeLastUpdatedTS;
    }

    public void setPrimIncomeLastUpdatedTS(Long primIncomeLastUpdatedTS) {
        this.primIncomeLastUpdatedTS = primIncomeLastUpdatedTS;
    }

    public Long getOtherIncomeLastUpdatedTS() {
        return otherIncomeLastUpdatedTS;
    }

    public void setOtherIncomeLastUpdatedTS(Long otherIncomeLastUpdatedTS) {
        this.otherIncomeLastUpdatedTS = otherIncomeLastUpdatedTS;
    }

    public Long getEmploymentLastUpdatedTS() {
        return employmentLastUpdatedTS;
    }

    public void setEmploymentLastUpdatedTS(Long employmentLastUpdatedTS) {
        this.employmentLastUpdatedTS = employmentLastUpdatedTS;
    }

    public Long getPartyAgreementLastUpdatedTS() {
        return partyAgreementLastUpdatedTS;
    }

    public void setPartyAgreementLastUpdatedTS(Long partyAgreementLastUpdatedTS) {
        this.partyAgreementLastUpdatedTS = partyAgreementLastUpdatedTS;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("custName");
        sb.append('=');
        sb.append(((this.custName == null)?"<null>":this.custName));
        sb.append(',');
        sb.append("acctId");
        sb.append('=');
        sb.append(((this.acctId == null)?"<null>":this.acctId));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("creditLimit");
        sb.append('=');
        sb.append(((this.creditLimit == null)?"<null>":this.creditLimit));
        sb.append(',');
        sb.append("currentCreditLimit");
        sb.append('=');
        sb.append(((this.currentCreditLimit == null)?"<null>":this.currentCreditLimit));
        sb.append(',');
        sb.append("currentBalance");
        sb.append('=');
        sb.append(((this.currentBalance == null)?"<null>":this.currentBalance));
        sb.append(',');
        sb.append("unbilledAmount");
        sb.append('=');
        sb.append(((this.unbilledAmount == null)?"<null>":this.unbilledAmount));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("phone");
        sb.append('=');
        sb.append(((this.phone == null)?"<null>":this.phone));
        sb.append(',');
        sb.append("confirmed");
        sb.append('=');
        sb.append(((this.confirmed == null)?"<null>":this.confirmed));
        sb.append(',');
        sb.append("emailRequired");
        sb.append('=');
        sb.append(((this.emailRequired == null)?"<null>":this.emailRequired));
        sb.append(',');
        sb.append("promotionOfferId");
        sb.append('=');
        sb.append(((this.promotionOfferId == null)?"<null>":this.promotionOfferId));
        sb.append(',');
        sb.append("longForm");
        sb.append('=');
        sb.append(((this.longForm == null)?"<null>":this.longForm));
        sb.append(',');
        sb.append("promotionOfferAmount");
        sb.append('=');
        sb.append(((this.promotionOfferAmount == null)?"<null>":this.promotionOfferAmount));
        sb.append(',');
        sb.append("disclosureInfo");
        sb.append('=');
        sb.append(((this.disclosureInfo == null)?"<null>":this.disclosureInfo));
        sb.append(',');
        sb.append("customerInfo");
        sb.append('=');
        sb.append(((this.customerInfo == null)?"<null>":this.customerInfo));
        sb.append(',');
        sb.append("emailNotificationInfo");
        sb.append('=');
        sb.append(((this.emailNotificationInfo == null)?"<null>":this.emailNotificationInfo));
        sb.append(',');
        sb.append("roleCD");
        sb.append('=');
        sb.append(((this.roleCD == null)?"<null>":this.roleCD));
        sb.append(',');
        sb.append("position");
        sb.append('=');
        sb.append(((this.position == null)?"<null>":this.position));
        sb.append(',');
        sb.append("employerName");
        sb.append('=');
        sb.append(((this.employerName == null)?"<null>":this.employerName));
        sb.append(',');
        sb.append("employerAddress");
        sb.append('=');
        sb.append(((this.employerAddress == null)?"<null>":this.employerAddress));
        sb.append(',');
        sb.append("employerCity");
        sb.append('=');
        sb.append(((this.employerCity == null)?"<null>":this.employerCity));
        sb.append(',');
        sb.append("employerProvince");
        sb.append('=');
        sb.append(((this.employerProvince == null)?"<null>":this.employerProvince));
        sb.append(',');
        sb.append("employerPostalCode");
        sb.append('=');
        sb.append(((this.employerPostalCode == null)?"<null>":this.employerPostalCode));
        sb.append(',');
        sb.append("employerPhoneType");
        sb.append('=');
        sb.append(((this.employerPhoneType == null)?"<null>":this.employerPhoneType));
        sb.append(',');
        sb.append("employerPhone");
        sb.append('=');
        sb.append(((this.employerPhone == null)?"<null>":this.employerPhone));
        sb.append(',');
        sb.append("natureOfBusiness");
        sb.append('=');
        sb.append(((this.natureOfBusiness == null)?"<null>":this.natureOfBusiness));
        sb.append(',');
        sb.append("employmentStatus");
        sb.append('=');
        sb.append(((this.employmentStatus == null)?"<null>":this.employmentStatus));
        sb.append(',');
        sb.append("lengthOfService");
        sb.append('=');
        sb.append(((this.lengthOfService == null)?"<null>":this.lengthOfService));
        sb.append(',');
        sb.append("personLastUpdatedTS");
        sb.append('=');
        sb.append(((this.personLastUpdatedTS == null)?"<null>":this.personLastUpdatedTS));
        sb.append(',');
        sb.append("bookOfBusLastUpdatedTS");
        sb.append('=');
        sb.append(((this.bookOfBusLastUpdatedTS == null)?"<null>":this.bookOfBusLastUpdatedTS));
        sb.append(',');
        sb.append("primIncomeLastUpdatedTS");
        sb.append('=');
        sb.append(((this.primIncomeLastUpdatedTS == null)?"<null>":this.primIncomeLastUpdatedTS));
        sb.append(',');
        sb.append("otherIncomeLastUpdatedTS");
        sb.append('=');
        sb.append(((this.otherIncomeLastUpdatedTS == null)?"<null>":this.otherIncomeLastUpdatedTS));
        sb.append(',');
        sb.append("employmentLastUpdatedTS");
        sb.append('=');
        sb.append(((this.employmentLastUpdatedTS == null)?"<null>":this.employmentLastUpdatedTS));
        sb.append(',');
        sb.append("partyAgreementLastUpdatedTS");
        sb.append('=');
        sb.append(((this.partyAgreementLastUpdatedTS == null)?"<null>":this.partyAgreementLastUpdatedTS));
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
        result = ((result* 31)+((this.currentCreditLimit == null)? 0 :this.currentCreditLimit.hashCode()));
        result = ((result* 31)+((this.employerAddress == null)? 0 :this.employerAddress.hashCode()));
        result = ((result* 31)+((this.employerPostalCode == null)? 0 :this.employerPostalCode.hashCode()));
        result = ((result* 31)+((this.customerInfo == null)? 0 :this.customerInfo.hashCode()));
        result = ((result* 31)+((this.employerName == null)? 0 :this.employerName.hashCode()));
        result = ((result* 31)+((this.natureOfBusiness == null)? 0 :this.natureOfBusiness.hashCode()));
        result = ((result* 31)+((this.employmentStatus == null)? 0 :this.employmentStatus.hashCode()));
        result = ((result* 31)+((this.confirmed == null)? 0 :this.confirmed.hashCode()));
        result = ((result* 31)+((this.unbilledAmount == null)? 0 :this.unbilledAmount.hashCode()));
        result = ((result* 31)+((this.employerPhoneType == null)? 0 :this.employerPhoneType.hashCode()));
        result = ((result* 31)+((this.promotionOfferAmount == null)? 0 :this.promotionOfferAmount.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.employerProvince == null)? 0 :this.employerProvince.hashCode()));
        result = ((result* 31)+((this.partyAgreementLastUpdatedTS == null)? 0 :this.partyAgreementLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.employmentLastUpdatedTS == null)? 0 :this.employmentLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.primIncomeLastUpdatedTS == null)? 0 :this.primIncomeLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.creditLimit == null)? 0 :this.creditLimit.hashCode()));
        result = ((result* 31)+((this.disclosureInfo == null)? 0 :this.disclosureInfo.hashCode()));
        result = ((result* 31)+((this.employerPhone == null)? 0 :this.employerPhone.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.personLastUpdatedTS == null)? 0 :this.personLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.promotionOfferId == null)? 0 :this.promotionOfferId.hashCode()));
        result = ((result* 31)+((this.currentBalance == null)? 0 :this.currentBalance.hashCode()));
        result = ((result* 31)+((this.otherIncomeLastUpdatedTS == null)? 0 :this.otherIncomeLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.acctId == null)? 0 :this.acctId.hashCode()));
        result = ((result* 31)+((this.emailNotificationInfo == null)? 0 :this.emailNotificationInfo.hashCode()));
        result = ((result* 31)+((this.custName == null)? 0 :this.custName.hashCode()));
        result = ((result* 31)+((this.employerCity == null)? 0 :this.employerCity.hashCode()));
        result = ((result* 31)+((this.longForm == null)? 0 :this.longForm.hashCode()));
        result = ((result* 31)+((this.phone == null)? 0 :this.phone.hashCode()));
        result = ((result* 31)+((this.lengthOfService == null)? 0 :this.lengthOfService.hashCode()));
        result = ((result* 31)+((this.position == null)? 0 :this.position.hashCode()));
        result = ((result* 31)+((this.emailRequired == null)? 0 :this.emailRequired.hashCode()));
        result = ((result* 31)+((this.bookOfBusLastUpdatedTS == null)? 0 :this.bookOfBusLastUpdatedTS.hashCode()));
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
        return (((((((((((((((((((((((((((((((((((((this.roleCD == rhs.roleCD)||((this.roleCD!= null)&&this.roleCD.equals(rhs.roleCD)))&&((this.currentCreditLimit == rhs.currentCreditLimit)||((this.currentCreditLimit!= null)&&this.currentCreditLimit.equals(rhs.currentCreditLimit))))&&((this.employerAddress == rhs.employerAddress)||((this.employerAddress!= null)&&this.employerAddress.equals(rhs.employerAddress))))&&((this.employerPostalCode == rhs.employerPostalCode)||((this.employerPostalCode!= null)&&this.employerPostalCode.equals(rhs.employerPostalCode))))&&((this.customerInfo == rhs.customerInfo)||((this.customerInfo!= null)&&this.customerInfo.equals(rhs.customerInfo))))&&((this.employerName == rhs.employerName)||((this.employerName!= null)&&this.employerName.equals(rhs.employerName))))&&((this.natureOfBusiness == rhs.natureOfBusiness)||((this.natureOfBusiness!= null)&&this.natureOfBusiness.equals(rhs.natureOfBusiness))))&&((this.employmentStatus == rhs.employmentStatus)||((this.employmentStatus!= null)&&this.employmentStatus.equals(rhs.employmentStatus))))&&((this.confirmed == rhs.confirmed)||((this.confirmed!= null)&&this.confirmed.equals(rhs.confirmed))))&&((this.unbilledAmount == rhs.unbilledAmount)||((this.unbilledAmount!= null)&&this.unbilledAmount.equals(rhs.unbilledAmount))))&&((this.employerPhoneType == rhs.employerPhoneType)||((this.employerPhoneType!= null)&&this.employerPhoneType.equals(rhs.employerPhoneType))))&&((this.promotionOfferAmount == rhs.promotionOfferAmount)||((this.promotionOfferAmount!= null)&&this.promotionOfferAmount.equals(rhs.promotionOfferAmount))))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.employerProvince == rhs.employerProvince)||((this.employerProvince!= null)&&this.employerProvince.equals(rhs.employerProvince))))&&((this.partyAgreementLastUpdatedTS == rhs.partyAgreementLastUpdatedTS)||((this.partyAgreementLastUpdatedTS!= null)&&this.partyAgreementLastUpdatedTS.equals(rhs.partyAgreementLastUpdatedTS))))&&((this.employmentLastUpdatedTS == rhs.employmentLastUpdatedTS)||((this.employmentLastUpdatedTS!= null)&&this.employmentLastUpdatedTS.equals(rhs.employmentLastUpdatedTS))))&&((this.primIncomeLastUpdatedTS == rhs.primIncomeLastUpdatedTS)||((this.primIncomeLastUpdatedTS!= null)&&this.primIncomeLastUpdatedTS.equals(rhs.primIncomeLastUpdatedTS))))&&((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId))))&&((this.creditLimit == rhs.creditLimit)||((this.creditLimit!= null)&&this.creditLimit.equals(rhs.creditLimit))))&&((this.disclosureInfo == rhs.disclosureInfo)||((this.disclosureInfo!= null)&&this.disclosureInfo.equals(rhs.disclosureInfo))))&&((this.employerPhone == rhs.employerPhone)||((this.employerPhone!= null)&&this.employerPhone.equals(rhs.employerPhone))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.personLastUpdatedTS == rhs.personLastUpdatedTS)||((this.personLastUpdatedTS!= null)&&this.personLastUpdatedTS.equals(rhs.personLastUpdatedTS))))&&((this.promotionOfferId == rhs.promotionOfferId)||((this.promotionOfferId!= null)&&this.promotionOfferId.equals(rhs.promotionOfferId))))&&((this.currentBalance == rhs.currentBalance)||((this.currentBalance!= null)&&this.currentBalance.equals(rhs.currentBalance))))&&((this.otherIncomeLastUpdatedTS == rhs.otherIncomeLastUpdatedTS)||((this.otherIncomeLastUpdatedTS!= null)&&this.otherIncomeLastUpdatedTS.equals(rhs.otherIncomeLastUpdatedTS))))&&((this.acctId == rhs.acctId)||((this.acctId!= null)&&this.acctId.equals(rhs.acctId))))&&((this.emailNotificationInfo == rhs.emailNotificationInfo)||((this.emailNotificationInfo!= null)&&this.emailNotificationInfo.equals(rhs.emailNotificationInfo))))&&((this.custName == rhs.custName)||((this.custName!= null)&&this.custName.equals(rhs.custName))))&&((this.employerCity == rhs.employerCity)||((this.employerCity!= null)&&this.employerCity.equals(rhs.employerCity))))&&((this.longForm == rhs.longForm)||((this.longForm!= null)&&this.longForm.equals(rhs.longForm))))&&((this.phone == rhs.phone)||((this.phone!= null)&&this.phone.equals(rhs.phone))))&&((this.lengthOfService == rhs.lengthOfService)||((this.lengthOfService!= null)&&this.lengthOfService.equals(rhs.lengthOfService))))&&((this.position == rhs.position)||((this.position!= null)&&this.position.equals(rhs.position))))&&((this.emailRequired == rhs.emailRequired)||((this.emailRequired!= null)&&this.emailRequired.equals(rhs.emailRequired))))&&((this.bookOfBusLastUpdatedTS == rhs.bookOfBusLastUpdatedTS)||((this.bookOfBusLastUpdatedTS!= null)&&this.bookOfBusLastUpdatedTS.equals(rhs.bookOfBusLastUpdatedTS))));
    }

}
