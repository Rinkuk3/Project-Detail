package com.td.mbna.msec.midtier.customerprofile.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;
import com.td.mbna.msec.midtier.types.common.AuditInfo;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;

public class ProfileUpdateType implements Serializable {

	private static final long serialVersionUID = -9046031972624590605L;
    private String custId;
    private String aliasCustomerID;
    private String acctId;
    private String mailingAddressPartyLocationID;
    private String mailingAddressLine1;
    private String mailingAddressLine2;
    private String mailingCity;
    private String mailingProvince;
    private String mailingPostalCode;
    private String businessPhonePartyLocationID;
    private String businessPhone;
    private String homePhonePartyLocationID;
    private String homePhone;
    private String mobilePhonePartyLocationID;
    private String mobilePhone;
    private boolean differentPhysicalAddress;
    private String physicalAddressLine1;
    private String physicalAddressLine2;
    private String physicalCity;
    private String physicalProvince;
    private String physicalPostalCode;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long physicalLastUpdatedTS;
    private String emailPartyLocationID;
    private String email;
    private String confirmEmailAddress;
    private boolean confirmationEmailWanted;
    private String occupation;
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
    private BigDecimal income;
    private String incomeFrequency;
    private boolean hasOtherIncome;
    private BigDecimal otherIncome;
    private String otherIncomeFrequency;
    private String otherIncomeSource;
    private boolean confirmed;
    private boolean authorizedUser;
    private EmailNotificationInfoType emailNotificationInfo;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long personLastUpdatedTS;
    private String bookOfBusCD;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long bookOfBusLastUpdatedTS;
    private String physicalPartyLocationID;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long physicalPartyLocationLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long partyAgreementLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long primIncomeLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long otherIncomeLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long grossIncomeLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long employmentLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long preferenceLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long emailLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long emailAddressLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long businessPhoneLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long businessPhoneLocLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneLocLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneLocLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long primaryResidenceLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long primaryResidenceEndTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mailingLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mailingEndTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mailingArgLocLastUpdatedTS;
    private boolean marketingEmailWanted;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long personalEmailLocLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long personalEmailLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long marketingByPersonalEmailOptionLastUpdatedTS;
    private List<AccountKycAuInfoType> authorizedUsers = new ArrayList<AccountKycAuInfoType>();
    private Boolean kyc;
    private Boolean isPrimaryUser;
    private String languagePref;
    private String custInterface;
    private AuditInfo auditInfo;
    private Boolean status;
    private List<String> errorMsgs = new ArrayList<String>();

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAliasCustomerID() {
        return aliasCustomerID;
    }

    public void setAliasCustomerID(String aliasCustomerID) {
        this.aliasCustomerID = aliasCustomerID;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
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

    public String getPhysicalAddressLine1() {
        return physicalAddressLine1;
    }

    public void setPhysicalAddressLine1(String physicalAddressLine1) {
        this.physicalAddressLine1 = physicalAddressLine1;
    }

    public String getPhysicalAddressLine2() {
        return physicalAddressLine2;
    }

    public void setPhysicalAddressLine2(String physicalAddressLine2) {
        this.physicalAddressLine2 = physicalAddressLine2;
    }

    public String getPhysicalCity() {
        return physicalCity;
    }

    public void setPhysicalCity(String physicalCity) {
        this.physicalCity = physicalCity;
    }

    public String getPhysicalProvince() {
        return physicalProvince;
    }

    public void setPhysicalProvince(String physicalProvince) {
        this.physicalProvince = physicalProvince;
    }

    public String getPhysicalPostalCode() {
        return physicalPostalCode;
    }

    public void setPhysicalPostalCode(String physicalPostalCode) {
        this.physicalPostalCode = physicalPostalCode;
    }

    public Long getPhysicalLastUpdatedTS() {
        return physicalLastUpdatedTS;
    }

    public void setPhysicalLastUpdatedTS(Long physicalLastUpdatedTS) {
        this.physicalLastUpdatedTS = physicalLastUpdatedTS;
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

    public void setEmail(String emailAddress) {
    	if(emailAddress == null || emailAddress.isEmpty() || emailAddress.length() <5 ){
			emailAddress = null;
    	}
        this.email = emailAddress;
    }

    public String getconfirmEmailAddress() {
        return confirmEmailAddress;
    }

    public void setconfirmEmailAddress(String confirmEmailAddress) {
    	if(confirmEmailAddress == null || confirmEmailAddress.isEmpty() || confirmEmailAddress.length() <5 ){
    		confirmEmailAddress = null;
    	}
        this.confirmEmailAddress = confirmEmailAddress;
    }

    public Boolean getConfirmationEmailWanted() {
        return confirmationEmailWanted;
    }

    public void setConfirmationEmailWanted(Boolean confirmationEmailWanted) {
        this.confirmationEmailWanted = confirmationEmailWanted;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getIncomeFrequency() {
        return incomeFrequency;
    }

    public void setIncomeFrequency(String incomeFrequency) {
        this.incomeFrequency = incomeFrequency;
    }

    public Boolean getHasOtherIncome() {
        return hasOtherIncome;
    }

    public void setHasOtherIncome(Boolean hasOtherIncome) {
        this.hasOtherIncome = hasOtherIncome;
    }

    public BigDecimal getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(BigDecimal otherIncome) {
        this.otherIncome = otherIncome;
    }

    public String getOtherIncomeFrequency() {
        return otherIncomeFrequency;
    }

    public void setOtherIncomeFrequency(String otherIncomeFrequency) {
        this.otherIncomeFrequency = otherIncomeFrequency;
    }

    public String getOtherIncomeSource() {
        return otherIncomeSource;
    }

    public void setOtherIncomeSource(String otherIncomeSource) {
        this.otherIncomeSource = otherIncomeSource;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(Boolean authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    public Long getPersonLastUpdatedTS() {
        return personLastUpdatedTS;
    }

    public void setPersonLastUpdatedTS(Long personLastUpdatedTS) {
        this.personLastUpdatedTS = personLastUpdatedTS;
    }

    public String getBookOfBusCD() {
        return bookOfBusCD;
    }

    public void setBookOfBusCD(String bookOfBusCD) {
        this.bookOfBusCD = bookOfBusCD;
    }

    public Long getBookOfBusLastUpdatedTS() {
        return bookOfBusLastUpdatedTS;
    }

    public void setBookOfBusLastUpdatedTS(Long bookOfBusLastUpdatedTS) {
        this.bookOfBusLastUpdatedTS = bookOfBusLastUpdatedTS;
    }

    public String getPhysicalPartyLocationID() {
        return physicalPartyLocationID;
    }

    public void setPhysicalPartyLocationID(String physicalPartyLocationID) {
        this.physicalPartyLocationID = physicalPartyLocationID;
    }

    public Long getPhysicalPartyLocationLastUpdatedTS() {
        return physicalPartyLocationLastUpdatedTS;
    }

    public void setPhysicalPartyLocationLastUpdatedTS(Long physicalPartyLocationLastUpdatedTS) {
        this.physicalPartyLocationLastUpdatedTS = physicalPartyLocationLastUpdatedTS;
    }

    public Long getPartyAgreementLastUpdatedTS() {
        return partyAgreementLastUpdatedTS;
    }

    public void setPartyAgreementLastUpdatedTS(Long partyAgreementLastUpdatedTS) {
        this.partyAgreementLastUpdatedTS = partyAgreementLastUpdatedTS;
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

    public Long getGrossIncomeLastUpdatedTS() {
        return grossIncomeLastUpdatedTS;
    }

    public void setGrossIncomeLastUpdatedTS(Long grossIncomeLastUpdatedTS) {
        this.grossIncomeLastUpdatedTS = grossIncomeLastUpdatedTS;
    }

    public Long getEmploymentLastUpdatedTS() {
        return employmentLastUpdatedTS;
    }

    public void setEmploymentLastUpdatedTS(Long employmentLastUpdatedTS) {
        this.employmentLastUpdatedTS = employmentLastUpdatedTS;
    }

    public Long getPreferenceLastUpdatedTS() {
        return preferenceLastUpdatedTS;
    }

    public void setPreferenceLastUpdatedTS(Long preferenceLastUpdatedTS) {
        this.preferenceLastUpdatedTS = preferenceLastUpdatedTS;
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

    public Long getPrimaryResidenceLastUpdatedTS() {
        return primaryResidenceLastUpdatedTS;
    }

    public void setPrimaryResidenceLastUpdatedTS(Long primaryResidenceLastUpdatedTS) {
        this.primaryResidenceLastUpdatedTS = primaryResidenceLastUpdatedTS;
    }

    public Long getPrimaryResidenceEndTS() {
        return primaryResidenceEndTS;
    }

    public void setPrimaryResidenceEndTS(Long primaryResidenceEndTS) {
        this.primaryResidenceEndTS = primaryResidenceEndTS;
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

    public Long getMailingArgLocLastUpdatedTS() {
        return mailingArgLocLastUpdatedTS;
    }

    public void setMailingArgLocLastUpdatedTS(Long mailingArgLocLastUpdatedTS) {
        this.mailingArgLocLastUpdatedTS = mailingArgLocLastUpdatedTS;
    }

    public Boolean getMarketingEmailWanted() {
        return marketingEmailWanted;
    }

    public void setMarketingEmailWanted(Boolean marketingEmailWanted) {
        this.marketingEmailWanted = marketingEmailWanted;
    }

    public Long getPersonalEmailLocLastUpdatedTS() {
        return personalEmailLocLastUpdatedTS;
    }

    public void setPersonalEmailLocLastUpdatedTS(Long personalEmailLocLastUpdatedTS) {
        this.personalEmailLocLastUpdatedTS = personalEmailLocLastUpdatedTS;
    }

    public Long getPersonalEmailLastUpdatedTS() {
        return personalEmailLastUpdatedTS;
    }

    public void setPersonalEmailLastUpdatedTS(Long personalEmailLastUpdatedTS) {
        this.personalEmailLastUpdatedTS = personalEmailLastUpdatedTS;
    }

    public Long getMarketingByPersonalEmailOptionLastUpdatedTS() {
        return marketingByPersonalEmailOptionLastUpdatedTS;
    }

    public void setMarketingByPersonalEmailOptionLastUpdatedTS(Long marketingByPersonalEmailOptionLastUpdatedTS) {
        this.marketingByPersonalEmailOptionLastUpdatedTS = marketingByPersonalEmailOptionLastUpdatedTS;
    }

    public List<AccountKycAuInfoType> getAuthorizedUsers() {
        return authorizedUsers;
    }

    public void setAuthorizedUsers(List<AccountKycAuInfoType> authorizedUsers) {
        this.authorizedUsers = authorizedUsers;
    }

    public Boolean getKyc() {
        return kyc;
    }

    public void setKyc(Boolean kyc) {
        this.kyc = kyc;
    }

    public Boolean getIsPrimaryUser() {
        return isPrimaryUser;
    }

    public void setIsPrimaryUser(Boolean isPrimaryUser) {
        this.isPrimaryUser = isPrimaryUser;
    }

    public String getLanguagePref() {
        return languagePref;
    }

    public void setLanguagePref(String languagePref) {
        this.languagePref = languagePref;
    }

    public String getCustInterface() {
        return custInterface;
    }

    public void setCustInterface(String custInterface) {
        this.custInterface = custInterface;
    }

    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getErrorMsgs() {
        return errorMsgs;
    }

    public void setErrorMsgs(List<String> errorMsgs) {
        this.errorMsgs = errorMsgs;
    }

    @Override
    public String toString() {
        return "ProfileUpdateType{" +
                "custId='" + custId + '\'' +
                ", aliasCustomerID='" + aliasCustomerID + '\'' +
                ", acctId='" + acctId + '\'' +
                ", mailingAddressPartyLocationID='" + mailingAddressPartyLocationID + '\'' +
                ", mailingAddressLine1='" + mailingAddressLine1 + '\'' +
                ", mailingAddressLine2='" + mailingAddressLine2 + '\'' +
                ", mailingCity='" + mailingCity + '\'' +
                ", mailingProvince='" + mailingProvince + '\'' +
                ", mailingPostalCode='" + mailingPostalCode + '\'' +
                ", businessPhonePartyLocationID='" + businessPhonePartyLocationID + '\'' +
                ", businessPhone='" + businessPhone + '\'' +
                ", homePhonePartyLocationID='" + homePhonePartyLocationID + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhonePartyLocationID='" + mobilePhonePartyLocationID + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", differentPhysicalAddress=" + differentPhysicalAddress +
                ", physicalAddressLine1='" + physicalAddressLine1 + '\'' +
                ", physicalAddressLine2='" + physicalAddressLine2 + '\'' +
                ", physicalCity='" + physicalCity + '\'' +
                ", physicalProvince='" + physicalProvince + '\'' +
                ", physicalPostalCode='" + physicalPostalCode + '\'' +
                ", physicalLastUpdatedTS=" + physicalLastUpdatedTS +
                ", emailPartyLocationID='" + emailPartyLocationID + '\'' +
                ", email='" + email + '\'' +
                ", confirmEmailAddress='" + confirmEmailAddress + '\'' +
                ", confirmationEmailWanted=" + confirmationEmailWanted +
                ", occupation='" + occupation + '\'' +
                ", position='" + position + '\'' +
                ", employerName='" + employerName + '\'' +
                ", employerAddress='" + employerAddress + '\'' +
                ", employerCity='" + employerCity + '\'' +
                ", employerProvince='" + employerProvince + '\'' +
                ", employerPostalCode='" + employerPostalCode + '\'' +
                ", employerPhoneType='" + employerPhoneType + '\'' +
                ", employerPhone='" + employerPhone + '\'' +
                ", natureOfBusiness='" + natureOfBusiness + '\'' +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", income=" + income +
                ", incomeFrequency='" + incomeFrequency + '\'' +
                ", hasOtherIncome=" + hasOtherIncome +
                ", otherIncome=" + otherIncome +
                ", otherIncomeFrequency='" + otherIncomeFrequency + '\'' +
                ", otherIncomeSource='" + otherIncomeSource + '\'' +
                ", confirmed=" + confirmed +
                ", authorizedUser=" + authorizedUser +
                ", emailNotificationInfo=" + emailNotificationInfo +
                ", personLastUpdatedTS=" + personLastUpdatedTS +
                ", bookOfBusCD='" + bookOfBusCD + '\'' +
                ", bookOfBusLastUpdatedTS=" + bookOfBusLastUpdatedTS +
                ", physicalPartyLocationID='" + physicalPartyLocationID + '\'' +
                ", physicalPartyLocationLastUpdatedTS=" + physicalPartyLocationLastUpdatedTS +
                ", partyAgreementLastUpdatedTS=" + partyAgreementLastUpdatedTS +
                ", primIncomeLastUpdatedTS=" + primIncomeLastUpdatedTS +
                ", otherIncomeLastUpdatedTS=" + otherIncomeLastUpdatedTS +
                ", grossIncomeLastUpdatedTS=" + grossIncomeLastUpdatedTS +
                ", employmentLastUpdatedTS=" + employmentLastUpdatedTS +
                ", preferenceLastUpdatedTS=" + preferenceLastUpdatedTS +
                ", emailLastUpdatedTS=" + emailLastUpdatedTS +
                ", emailAddressLastUpdatedTS=" + emailAddressLastUpdatedTS +
                ", businessPhoneLastUpdatedTS=" + businessPhoneLastUpdatedTS +
                ", businessPhoneLocLastUpdatedTS=" + businessPhoneLocLastUpdatedTS +
                ", homePhoneLastUpdatedTS=" + homePhoneLastUpdatedTS +
                ", homePhoneLocLastUpdatedTS=" + homePhoneLocLastUpdatedTS +
                ", mobilePhoneLastUpdatedTS=" + mobilePhoneLastUpdatedTS +
                ", mobilePhoneLocLastUpdatedTS=" + mobilePhoneLocLastUpdatedTS +
                ", primaryResidenceLastUpdatedTS=" + primaryResidenceLastUpdatedTS +
                ", primaryResidenceEndTS=" + primaryResidenceEndTS +
                ", mailingLastUpdatedTS=" + mailingLastUpdatedTS +
                ", mailingEndTS=" + mailingEndTS +
                ", mailingArgLocLastUpdatedTS=" + mailingArgLocLastUpdatedTS +
                ", marketingEmailWanted=" + marketingEmailWanted +
                ", personalEmailLocLastUpdatedTS=" + personalEmailLocLastUpdatedTS +
                ", personalEmailLastUpdatedTS=" + personalEmailLastUpdatedTS +
                ", marketingByPersonalEmailOptionLastUpdatedTS=" + marketingByPersonalEmailOptionLastUpdatedTS +
                ", authorizedUsers=" + authorizedUsers +
                ", kyc=" + kyc +
                ", isPrimaryUser=" + isPrimaryUser +
                ", languagePref='" + languagePref + '\'' +
                ", custInterface='" + custInterface + '\'' +
                ", auditInfo=" + auditInfo +
                ", status=" + status +
                ", errorMsgs=" + errorMsgs +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileUpdateType that = (ProfileUpdateType) o;
        return differentPhysicalAddress == that.differentPhysicalAddress &&
                confirmationEmailWanted == that.confirmationEmailWanted &&
                hasOtherIncome == that.hasOtherIncome &&
                confirmed == that.confirmed &&
                authorizedUser == that.authorizedUser &&
                marketingEmailWanted == that.marketingEmailWanted &&
                Objects.equals(custId, that.custId) &&
                Objects.equals(aliasCustomerID, that.aliasCustomerID) &&
                Objects.equals(acctId, that.acctId) &&
                Objects.equals(mailingAddressPartyLocationID, that.mailingAddressPartyLocationID) &&
                Objects.equals(mailingAddressLine1, that.mailingAddressLine1) &&
                Objects.equals(mailingAddressLine2, that.mailingAddressLine2) &&
                Objects.equals(mailingCity, that.mailingCity) &&
                Objects.equals(mailingProvince, that.mailingProvince) &&
                Objects.equals(mailingPostalCode, that.mailingPostalCode) &&
                Objects.equals(businessPhonePartyLocationID, that.businessPhonePartyLocationID) &&
                Objects.equals(businessPhone, that.businessPhone) &&
                Objects.equals(homePhonePartyLocationID, that.homePhonePartyLocationID) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(mobilePhonePartyLocationID, that.mobilePhonePartyLocationID) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(physicalAddressLine1, that.physicalAddressLine1) &&
                Objects.equals(physicalAddressLine2, that.physicalAddressLine2) &&
                Objects.equals(physicalCity, that.physicalCity) &&
                Objects.equals(physicalProvince, that.physicalProvince) &&
                Objects.equals(physicalPostalCode, that.physicalPostalCode) &&
                Objects.equals(physicalLastUpdatedTS, that.physicalLastUpdatedTS) &&
                Objects.equals(emailPartyLocationID, that.emailPartyLocationID) &&
                Objects.equals(email, that.email) &&
                Objects.equals(confirmEmailAddress, that.confirmEmailAddress) &&
                Objects.equals(occupation, that.occupation) &&
                Objects.equals(position, that.position) &&
                Objects.equals(employerName, that.employerName) &&
                Objects.equals(employerAddress, that.employerAddress) &&
                Objects.equals(employerCity, that.employerCity) &&
                Objects.equals(employerProvince, that.employerProvince) &&
                Objects.equals(employerPostalCode, that.employerPostalCode) &&
                Objects.equals(employerPhoneType, that.employerPhoneType) &&
                Objects.equals(employerPhone, that.employerPhone) &&
                Objects.equals(natureOfBusiness, that.natureOfBusiness) &&
                Objects.equals(employmentStatus, that.employmentStatus) &&
                Objects.equals(income, that.income) &&
                Objects.equals(incomeFrequency, that.incomeFrequency) &&
                Objects.equals(otherIncome, that.otherIncome) &&
                Objects.equals(otherIncomeFrequency, that.otherIncomeFrequency) &&
                Objects.equals(otherIncomeSource, that.otherIncomeSource) &&
                Objects.equals(emailNotificationInfo, that.emailNotificationInfo) &&
                Objects.equals(personLastUpdatedTS, that.personLastUpdatedTS) &&
                Objects.equals(bookOfBusCD, that.bookOfBusCD) &&
                Objects.equals(bookOfBusLastUpdatedTS, that.bookOfBusLastUpdatedTS) &&
                Objects.equals(physicalPartyLocationID, that.physicalPartyLocationID) &&
                Objects.equals(physicalPartyLocationLastUpdatedTS, that.physicalPartyLocationLastUpdatedTS) &&
                Objects.equals(partyAgreementLastUpdatedTS, that.partyAgreementLastUpdatedTS) &&
                Objects.equals(primIncomeLastUpdatedTS, that.primIncomeLastUpdatedTS) &&
                Objects.equals(otherIncomeLastUpdatedTS, that.otherIncomeLastUpdatedTS) &&
                Objects.equals(grossIncomeLastUpdatedTS, that.grossIncomeLastUpdatedTS) &&
                Objects.equals(employmentLastUpdatedTS, that.employmentLastUpdatedTS) &&
                Objects.equals(preferenceLastUpdatedTS, that.preferenceLastUpdatedTS) &&
                Objects.equals(emailLastUpdatedTS, that.emailLastUpdatedTS) &&
                Objects.equals(emailAddressLastUpdatedTS, that.emailAddressLastUpdatedTS) &&
                Objects.equals(businessPhoneLastUpdatedTS, that.businessPhoneLastUpdatedTS) &&
                Objects.equals(businessPhoneLocLastUpdatedTS, that.businessPhoneLocLastUpdatedTS) &&
                Objects.equals(homePhoneLastUpdatedTS, that.homePhoneLastUpdatedTS) &&
                Objects.equals(homePhoneLocLastUpdatedTS, that.homePhoneLocLastUpdatedTS) &&
                Objects.equals(mobilePhoneLastUpdatedTS, that.mobilePhoneLastUpdatedTS) &&
                Objects.equals(mobilePhoneLocLastUpdatedTS, that.mobilePhoneLocLastUpdatedTS) &&
                Objects.equals(primaryResidenceLastUpdatedTS, that.primaryResidenceLastUpdatedTS) &&
                Objects.equals(primaryResidenceEndTS, that.primaryResidenceEndTS) &&
                Objects.equals(mailingLastUpdatedTS, that.mailingLastUpdatedTS) &&
                Objects.equals(mailingEndTS, that.mailingEndTS) &&
                Objects.equals(mailingArgLocLastUpdatedTS, that.mailingArgLocLastUpdatedTS) &&
                Objects.equals(personalEmailLocLastUpdatedTS, that.personalEmailLocLastUpdatedTS) &&
                Objects.equals(personalEmailLastUpdatedTS, that.personalEmailLastUpdatedTS) &&
                Objects.equals(marketingByPersonalEmailOptionLastUpdatedTS, that.marketingByPersonalEmailOptionLastUpdatedTS) &&
                Objects.equals(authorizedUsers, that.authorizedUsers) &&
                Objects.equals(kyc, that.kyc) &&
                Objects.equals(isPrimaryUser, that.isPrimaryUser) &&
                Objects.equals(languagePref, that.languagePref) &&
                Objects.equals(custInterface, that.custInterface) &&
                Objects.equals(auditInfo, that.auditInfo) &&
                Objects.equals(status, that.status) &&
                Objects.equals(errorMsgs, that.errorMsgs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId, aliasCustomerID, acctId, mailingAddressPartyLocationID, mailingAddressLine1, mailingAddressLine2, mailingCity, mailingProvince, mailingPostalCode, businessPhonePartyLocationID, businessPhone, homePhonePartyLocationID, homePhone, mobilePhonePartyLocationID, mobilePhone, differentPhysicalAddress, physicalAddressLine1, physicalAddressLine2, physicalCity, physicalProvince, physicalPostalCode, physicalLastUpdatedTS, emailPartyLocationID, email, confirmEmailAddress, confirmationEmailWanted, occupation, position, employerName, employerAddress, employerCity, employerProvince, employerPostalCode, employerPhoneType, employerPhone, natureOfBusiness, employmentStatus, income, incomeFrequency, hasOtherIncome, otherIncome, otherIncomeFrequency, otherIncomeSource, confirmed, authorizedUser, emailNotificationInfo, personLastUpdatedTS, bookOfBusCD, bookOfBusLastUpdatedTS, physicalPartyLocationID, physicalPartyLocationLastUpdatedTS, partyAgreementLastUpdatedTS, primIncomeLastUpdatedTS, otherIncomeLastUpdatedTS, grossIncomeLastUpdatedTS, employmentLastUpdatedTS, preferenceLastUpdatedTS, emailLastUpdatedTS, emailAddressLastUpdatedTS, businessPhoneLastUpdatedTS, businessPhoneLocLastUpdatedTS, homePhoneLastUpdatedTS, homePhoneLocLastUpdatedTS, mobilePhoneLastUpdatedTS, mobilePhoneLocLastUpdatedTS, primaryResidenceLastUpdatedTS, primaryResidenceEndTS, mailingLastUpdatedTS, mailingEndTS, mailingArgLocLastUpdatedTS, marketingEmailWanted, personalEmailLocLastUpdatedTS, personalEmailLastUpdatedTS, marketingByPersonalEmailOptionLastUpdatedTS, authorizedUsers, kyc, isPrimaryUser, languagePref, custInterface, auditInfo, status, errorMsgs);
    }
}
