package com.td.mbna.msec.midtier.customerprofile.payload.retrievecustomerprofile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.customerprofile.payload.AccountKycAuInfoType;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;
import com.td.mbna.msec.midtier.types.common.AcctContactInfoType;
import com.td.mbna.msec.midtier.types.common.CardHolderType;
import com.td.mbna.msec.midtier.types.common.UserNameType;

@Data
public class ResponsePayload implements Serializable {

	private static final long serialVersionUID = 1L;
    private UserNameType name;
	@JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long legalNameLastUpdatedTS;
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
    private String birthDate;
    private Boolean differentPhysicalAddress;
    private String physicalAddressLine1;
    private String physicalAddressLine2;
    private String physicalCity;
    private String physicalProvince;
    private String physicalPostalCode;
    private String physicalCountry;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long physicalLastUpdatedTS;
    private Boolean updateRequired;
    private CardHolderType primaryUser;
    private AcctContactInfoType primaryContact;
    private List<CardHolderType> authorizedUser = new ArrayList<CardHolderType>();
    private String emailPartyLocationID;
    private String email;
    private Boolean unsuccessfulDevilery;
    private Boolean confirmationEmailWanted;
    private String occupation;
    private String employerName;
    private String employerAddress;
    private String employerCity;
    private String employerProvince;
    private String employerPostalCode;
    private String employerPhoneType;
    private String employerPhone;
    private String natureOfBusiness;
    private String employmentStatus;
    private String employmentId;
    private String position;
    private String incomeId;
    private BigDecimal income;
    private String incomeFrequency;
    private Boolean hasOtherIncome;
    private String otherIncomeId;
    private BigDecimal otherIncome;
    private String otherIncomeFrequency;
    private String otherIncomeSource;
    private Boolean updateProfile;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long lastKYCUpdate;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long lastKYCRefresh;
    private String riskScore;
    private String languagePref;
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
    private String grossIncomeId;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long employmentLastUpdatedTS;
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
    private String businessPhoneNumber;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneEffectiveTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneEndTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long homePhoneLocLastUpdatedTS;
    private String homePhoneNumber;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneEffectiveTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneEndTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mobilePhoneLocLastUpdatedTS;
    private String mobilePhoneNumber;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long primaryResidenceLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long primaryResidenceEndTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long mailingArgLocLastUpdatedTS;
    private Boolean marketingEmailWanted;
    private String personalEmail;
    private String personalEmailLocId;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long personalEmailLocLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long personalEmailLastUpdatedTS;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long marketingByPersonalEmailOptionLastUpdatedTS;
    private List<AccountKycAuInfoType> authorizedUsers = new ArrayList<AccountKycAuInfoType>();

    public UserNameType getName() {
        return name;
    }

    public void setName(UserNameType name) {
        this.name = name;
    }

    public Long getLegalNameLastUpdatedTS() {
        return legalNameLastUpdatedTS;
    }

    public void setLegalNameLastUpdatedTS(Long legalNameLastUpdatedTS) {
        this.legalNameLastUpdatedTS = legalNameLastUpdatedTS;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean isDifferentPhysicalAddress() {
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

    public String getPhysicalCountry() {
        return physicalCountry;
    }

    public void setPhysicalCountry(String physicalCountry) {
        this.physicalCountry = physicalCountry;
    }

    public Long getPhysicalLastUpdatedTS() {
        return physicalLastUpdatedTS;
    }

    public void setPhysicalLastUpdatedTS(Long physicalLastUpdatedTS) {
        this.physicalLastUpdatedTS = physicalLastUpdatedTS;
    }

    public Boolean getUpdateRequired() {
        return updateRequired;
    }

    public void setUpdateRequired(Boolean updateRequired) {
        this.updateRequired = updateRequired;
    }

    public CardHolderType getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(CardHolderType primaryUser) {
        this.primaryUser = primaryUser;
    }

    public AcctContactInfoType getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(AcctContactInfoType primaryContact) {
        this.primaryContact = primaryContact;
    }

    public List<CardHolderType> getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(List<CardHolderType> authorizedUser) {
        this.authorizedUser = authorizedUser;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public String getEmploymentId() {
		return employmentId;
	}

	public void setEmploymentId(String employmentId) {
		this.employmentId = employmentId;
	}

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
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

    public String getOtherIncomeId() {
		return otherIncomeId;
	}

	public void setOtherIncomeId(String otherIncomeId) {
		this.otherIncomeId = otherIncomeId;
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

    public Boolean getUpdateProfile() {
        return updateProfile;
    }

    public void setUpdateProfile(Boolean updateProfile) {
        this.updateProfile = updateProfile;
    }

    public Long getLastKYCUpdate() {
        return lastKYCUpdate;
    }

    public void setLastKYCUpdate(Long lastKYCUpdate) {
        this.lastKYCUpdate = lastKYCUpdate;
    }

    public Long getLastKYCRefresh() {
        return lastKYCRefresh;
    }

    public void setLastKYCRefresh(Long lastKYCRefresh) {
        this.lastKYCRefresh = lastKYCRefresh;
    }

    public String getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(String riskScore) {
        this.riskScore = riskScore;
    }

    public String getLanguagePref() {
        return languagePref;
    }

    public void setLanguagePref(String languagePref) {
        this.languagePref = languagePref;
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

    public String getGrossIncomeId() {
		return grossIncomeId;
	}

	public void setGrossIncomeId(String grossIncomeId) {
		this.grossIncomeId = grossIncomeId;
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

    public String getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public void setBusinessPhoneNumber(String businessPhoneNumber) {
        this.businessPhoneNumber = businessPhoneNumber;
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

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
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

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
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

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPersonalEmailLocId() {
        return personalEmailLocId;
    }

    public void setPersonalEmailLocId(String personalEmailLocId) {
        this.personalEmailLocId = personalEmailLocId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("legalNameLastUpdatedTS");
        sb.append('=');
        sb.append(((this.legalNameLastUpdatedTS == null)?"<null>":this.legalNameLastUpdatedTS));
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
        sb.append("birthDate");
        sb.append('=');
        sb.append(((this.birthDate == null)?"<null>":this.birthDate));
        sb.append(',');
        sb.append("differentPhysicalAddress");
        sb.append('=');
        sb.append(((this.differentPhysicalAddress == null)?"<null>":this.differentPhysicalAddress));
        sb.append(',');
        sb.append("physicalAddressLine1");
        sb.append('=');
        sb.append(((this.physicalAddressLine1 == null)?"<null>":this.physicalAddressLine1));
        sb.append(',');
        sb.append("physicalAddressLine2");
        sb.append('=');
        sb.append(((this.physicalAddressLine2 == null)?"<null>":this.physicalAddressLine2));
        sb.append(',');
        sb.append("physicalCity");
        sb.append('=');
        sb.append(((this.physicalCity == null)?"<null>":this.physicalCity));
        sb.append(',');
        sb.append("physicalProvince");
        sb.append('=');
        sb.append(((this.physicalProvince == null)?"<null>":this.physicalProvince));
        sb.append(',');
        sb.append("physicalPostalCode");
        sb.append('=');
        sb.append(((this.physicalPostalCode == null)?"<null>":this.physicalPostalCode));
        sb.append(',');
        sb.append("physicalCountry");
        sb.append('=');
        sb.append(((this.physicalCountry == null)?"<null>":this.physicalCountry));
        sb.append(',');
        sb.append("physicalLastUpdatedTS");
        sb.append('=');
        sb.append(((this.physicalLastUpdatedTS == null)?"<null>":this.physicalLastUpdatedTS));
        sb.append(',');
        sb.append("updateRequired");
        sb.append('=');
        sb.append(((this.updateRequired == null)?"<null>":this.updateRequired));
        sb.append(',');
        sb.append("primaryUser");
        sb.append('=');
        sb.append(((this.primaryUser == null)?"<null>":this.primaryUser));
        sb.append(',');
        sb.append("primaryContact");
        sb.append('=');
        sb.append(((this.primaryContact == null)?"<null>":this.primaryContact));
        sb.append(',');
        sb.append("authorizedUser");
        sb.append('=');
        sb.append(((this.authorizedUser == null)?"<null>":this.authorizedUser));
        sb.append(',');
        sb.append("emailPartyLocationID");
        sb.append('=');
        sb.append(((this.emailPartyLocationID == null)?"<null>":this.emailPartyLocationID));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("unsuccessfulDevilery");
        sb.append('=');
        sb.append(((this.unsuccessfulDevilery == null)?"<null>":this.unsuccessfulDevilery));
        sb.append(',');
        sb.append("confirmationEmailWanted");
        sb.append('=');
        sb.append(((this.confirmationEmailWanted == null)?"<null>":this.confirmationEmailWanted));
        sb.append(',');
        sb.append("occupation");
        sb.append('=');
        sb.append(((this.occupation == null)?"<null>":this.occupation));
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
        sb.append("position");
        sb.append('=');
        sb.append(((this.position == null)?"<null>":this.position));
        sb.append(',');
        sb.append("income");
        sb.append('=');
        sb.append(((this.income == null)?"<null>":this.income));
        sb.append(',');
        sb.append("incomeFrequency");
        sb.append('=');
        sb.append(((this.incomeFrequency == null)?"<null>":this.incomeFrequency));
        sb.append(',');
        sb.append("hasOtherIncome");
        sb.append('=');
        sb.append(((this.hasOtherIncome == null)?"<null>":this.hasOtherIncome));
        sb.append(',');
        sb.append("otherIncome");
        sb.append('=');
        sb.append(((this.otherIncome == null)?"<null>":this.otherIncome));
        sb.append(',');
        sb.append("otherIncomeFrequency");
        sb.append('=');
        sb.append(((this.otherIncomeFrequency == null)?"<null>":this.otherIncomeFrequency));
        sb.append(',');
        sb.append("otherIncomeSource");
        sb.append('=');
        sb.append(((this.otherIncomeSource == null)?"<null>":this.otherIncomeSource));
        sb.append(',');
        sb.append("updateProfile");
        sb.append('=');
        sb.append(((this.updateProfile == null)?"<null>":this.updateProfile));
        sb.append(',');
        sb.append("lastKYCUpdate");
        sb.append('=');
        sb.append(((this.lastKYCUpdate == null)?"<null>":this.lastKYCUpdate));
        sb.append(',');
        sb.append("lastKYCRefresh");
        sb.append('=');
        sb.append(((this.lastKYCRefresh == null)?"<null>":this.lastKYCRefresh));
        sb.append(',');
        sb.append("riskScore");
        sb.append('=');
        sb.append(((this.riskScore == null)?"<null>":this.riskScore));
        sb.append(',');
        sb.append("languagePref");
        sb.append('=');
        sb.append(((this.languagePref == null)?"<null>":this.languagePref));
        sb.append(',');
        sb.append("personLastUpdatedTS");
        sb.append('=');
        sb.append(((this.personLastUpdatedTS == null)?"<null>":this.personLastUpdatedTS));
        sb.append(',');
        sb.append("bookOfBusCD");
        sb.append('=');
        sb.append(((this.bookOfBusCD == null)?"<null>":this.bookOfBusCD));
        sb.append(',');
        sb.append("bookOfBusLastUpdatedTS");
        sb.append('=');
        sb.append(((this.bookOfBusLastUpdatedTS == null)?"<null>":this.bookOfBusLastUpdatedTS));
        sb.append(',');
        sb.append("physicalPartyLocationID");
        sb.append('=');
        sb.append(((this.physicalPartyLocationID == null)?"<null>":this.physicalPartyLocationID));
        sb.append(',');
        sb.append("physicalPartyLocationLastUpdatedTS");
        sb.append('=');
        sb.append(((this.physicalPartyLocationLastUpdatedTS == null)?"<null>":this.physicalPartyLocationLastUpdatedTS));
        sb.append(',');
        sb.append("partyAgreementLastUpdatedTS");
        sb.append('=');
        sb.append(((this.partyAgreementLastUpdatedTS == null)?"<null>":this.partyAgreementLastUpdatedTS));
        sb.append(',');
        sb.append("primIncomeLastUpdatedTS");
        sb.append('=');
        sb.append(((this.primIncomeLastUpdatedTS == null)?"<null>":this.primIncomeLastUpdatedTS));
        sb.append(',');
        sb.append("otherIncomeLastUpdatedTS");
        sb.append('=');
        sb.append(((this.otherIncomeLastUpdatedTS == null)?"<null>":this.otherIncomeLastUpdatedTS));
        sb.append(',');
        sb.append("grossIncomeLastUpdatedTS");
        sb.append('=');
        sb.append(((this.grossIncomeLastUpdatedTS == null)?"<null>":this.grossIncomeLastUpdatedTS));
        sb.append(',');
        sb.append("employmentLastUpdatedTS");
        sb.append('=');
        sb.append(((this.employmentLastUpdatedTS == null)?"<null>":this.employmentLastUpdatedTS));
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
        sb.append("businessPhoneNumber");
        sb.append('=');
        sb.append(((this.businessPhoneNumber == null)?"<null>":this.businessPhoneNumber));
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
        sb.append("homePhoneNumber");
        sb.append('=');
        sb.append(((this.homePhoneNumber == null)?"<null>":this.homePhoneNumber));
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
        sb.append("mobilePhoneNumber");
        sb.append('=');
        sb.append(((this.mobilePhoneNumber == null)?"<null>":this.mobilePhoneNumber));
        sb.append(',');
        sb.append("primaryResidenceLastUpdatedTS");
        sb.append('=');
        sb.append(((this.primaryResidenceLastUpdatedTS == null)?"<null>":this.primaryResidenceLastUpdatedTS));
        sb.append(',');
        sb.append("primaryResidenceEndTS");
        sb.append('=');
        sb.append(((this.primaryResidenceEndTS == null)?"<null>":this.primaryResidenceEndTS));
        sb.append(',');
        sb.append("mailingArgLocLastUpdatedTS");
        sb.append('=');
        sb.append(((this.mailingArgLocLastUpdatedTS == null)?"<null>":this.mailingArgLocLastUpdatedTS));
        sb.append(',');
        sb.append("marketingEmailWanted");
        sb.append('=');
        sb.append(((this.marketingEmailWanted == null)?"<null>":this.marketingEmailWanted));
        sb.append(',');
        sb.append("personalEmail");
        sb.append('=');
        sb.append(((this.personalEmail == null)?"<null>":this.personalEmail));
        sb.append(',');
        sb.append("personalEmailLocId");
        sb.append('=');
        sb.append(((this.personalEmailLocId == null)?"<null>":this.personalEmailLocId));
        sb.append(',');
        sb.append("personalEmailLocLastUpdatedTS");
        sb.append('=');
        sb.append(((this.personalEmailLocLastUpdatedTS == null)?"<null>":this.personalEmailLocLastUpdatedTS));
        sb.append(',');
        sb.append("personalEmailLastUpdatedTS");
        sb.append('=');
        sb.append(((this.personalEmailLastUpdatedTS == null)?"<null>":this.personalEmailLastUpdatedTS));
        sb.append(',');
        sb.append("marketingByPersonalEmailOptionLastUpdatedTS");
        sb.append('=');
        sb.append(((this.marketingByPersonalEmailOptionLastUpdatedTS == null)?"<null>":this.marketingByPersonalEmailOptionLastUpdatedTS));
        sb.append(',');
        sb.append("authorizedUsers");
        sb.append('=');
        sb.append(((this.authorizedUsers == null)?"<null>":this.authorizedUsers));
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
        result = ((result* 31)+((this.hasOtherIncome == null)? 0 :this.hasOtherIncome.hashCode()));
        result = ((result* 31)+((this.bookOfBusCD == null)? 0 :this.bookOfBusCD.hashCode()));
        result = ((result* 31)+((this.homePhonePartyLocationID == null)? 0 :this.homePhonePartyLocationID.hashCode()));
        result = ((result* 31)+((this.occupation == null)? 0 :this.occupation.hashCode()));
        result = ((result* 31)+((this.employerAddress == null)? 0 :this.employerAddress.hashCode()));
        result = ((result* 31)+((this.homePhoneNumber == null)? 0 :this.homePhoneNumber.hashCode()));
        result = ((result* 31)+((this.physicalProvince == null)? 0 :this.physicalProvince.hashCode()));
        result = ((result* 31)+((this.marketingByPersonalEmailOptionLastUpdatedTS == null)? 0 :this.marketingByPersonalEmailOptionLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.employerPostalCode == null)? 0 :this.employerPostalCode.hashCode()));
        result = ((result* 31)+((this.authorizedUsers == null)? 0 :this.authorizedUsers.hashCode()));
        result = ((result* 31)+((this.mobilePhonePartyLocationID == null)? 0 :this.mobilePhonePartyLocationID.hashCode()));
        result = ((result* 31)+((this.employmentStatus == null)? 0 :this.employmentStatus.hashCode()));
        result = ((result* 31)+((this.personalEmail == null)? 0 :this.personalEmail.hashCode()));
        result = ((result* 31)+((this.homePhoneLastUpdatedTS == null)? 0 :this.homePhoneLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mailingAddressLine1 == null)? 0 :this.mailingAddressLine1 .hashCode()));
        result = ((result* 31)+((this.mailingAddressLine2 == null)? 0 :this.mailingAddressLine2 .hashCode()));
        result = ((result* 31)+((this.mailingProvince == null)? 0 :this.mailingProvince.hashCode()));
        result = ((result* 31)+((this.homePhoneEffectiveTS == null)? 0 :this.homePhoneEffectiveTS.hashCode()));
        result = ((result* 31)+((this.mailingArgLocLastUpdatedTS == null)? 0 :this.mailingArgLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mailingCountry == null)? 0 :this.mailingCountry.hashCode()));
        result = ((result* 31)+((this.businessPhoneEffectiveTS == null)? 0 :this.businessPhoneEffectiveTS.hashCode()));
        result = ((result* 31)+((this.riskScore == null)? 0 :this.riskScore.hashCode()));
        result = ((result* 31)+((this.employerPhone == null)? 0 :this.employerPhone.hashCode()));
        result = ((result* 31)+((this.businessPhoneEndTS == null)? 0 :this.businessPhoneEndTS.hashCode()));
        result = ((result* 31)+((this.marketingEmailWanted == null)? 0 :this.marketingEmailWanted.hashCode()));
        result = ((result* 31)+((this.personLastUpdatedTS == null)? 0 :this.personLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mailingAddressPartyLocationID == null)? 0 :this.mailingAddressPartyLocationID.hashCode()));
        result = ((result* 31)+((this.homePhone == null)? 0 :this.homePhone.hashCode()));
        result = ((result* 31)+((this.primaryUser == null)? 0 :this.primaryUser.hashCode()));
        result = ((result* 31)+((this.otherIncomeLastUpdatedTS == null)? 0 :this.otherIncomeLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.incomeFrequency == null)? 0 :this.incomeFrequency.hashCode()));
        result = ((result* 31)+((this.otherIncome == null)? 0 :this.otherIncome.hashCode()));
        result = ((result* 31)+((this.mobilePhoneEffectiveTS == null)? 0 :this.mobilePhoneEffectiveTS.hashCode()));
        result = ((result* 31)+((this.mailingLastUpdatedTS == null)? 0 :this.mailingLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.otherIncomeSource == null)? 0 :this.otherIncomeSource.hashCode()));
        result = ((result* 31)+((this.mobilePhone == null)? 0 :this.mobilePhone.hashCode()));
        result = ((result* 31)+((this.mobilePhoneEndTS == null)? 0 :this.mobilePhoneEndTS.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.businessPhone == null)? 0 :this.businessPhone.hashCode()));
        result = ((result* 31)+((this.position == null)? 0 :this.position.hashCode()));
        result = ((result* 31)+((this.authorizedUser == null)? 0 :this.authorizedUser.hashCode()));
        result = ((result* 31)+((this.bookOfBusLastUpdatedTS == null)? 0 :this.bookOfBusLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.businessPhoneNumber == null)? 0 :this.businessPhoneNumber.hashCode()));
        result = ((result* 31)+((this.income == null)? 0 :this.income.hashCode()));
        result = ((result* 31)+((this.physicalPartyLocationID == null)? 0 :this.physicalPartyLocationID.hashCode()));
        result = ((result* 31)+((this.updateProfile == null)? 0 :this.updateProfile.hashCode()));
        result = ((result* 31)+((this.differentPhysicalAddress == null)? 0 :this.differentPhysicalAddress.hashCode()));
        result = ((result* 31)+((this.businessPhonePartyLocationID == null)? 0 :this.businessPhonePartyLocationID.hashCode()));
        result = ((result* 31)+((this.unsuccessfulDevilery == null)? 0 :this.unsuccessfulDevilery.hashCode()));
        result = ((result* 31)+((this.employerName == null)? 0 :this.employerName.hashCode()));
        result = ((result* 31)+((this.emailAddressLastUpdatedTS == null)? 0 :this.emailAddressLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.natureOfBusiness == null)? 0 :this.natureOfBusiness.hashCode()));
        result = ((result* 31)+((this.primaryResidenceLastUpdatedTS == null)? 0 :this.primaryResidenceLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.grossIncomeLastUpdatedTS == null)? 0 :this.grossIncomeLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mobilePhoneLastUpdatedTS == null)? 0 :this.mobilePhoneLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.otherIncomeFrequency == null)? 0 :this.otherIncomeFrequency.hashCode()));
        result = ((result* 31)+((this.employerPhoneType == null)? 0 :this.employerPhoneType.hashCode()));
        result = ((result* 31)+((this.lastKYCRefresh == null)? 0 :this.lastKYCRefresh.hashCode()));
        result = ((result* 31)+((this.mobilePhoneLocLastUpdatedTS == null)? 0 :this.mobilePhoneLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.employerProvince == null)? 0 :this.employerProvince.hashCode()));
        result = ((result* 31)+((this.partyAgreementLastUpdatedTS == null)? 0 :this.partyAgreementLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.languagePref == null)? 0 :this.languagePref.hashCode()));
        result = ((result* 31)+((this.employmentLastUpdatedTS == null)? 0 :this.employmentLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.personalEmailLastUpdatedTS == null)? 0 :this.personalEmailLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.primIncomeLastUpdatedTS == null)? 0 :this.primIncomeLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.physicalPartyLocationLastUpdatedTS == null)? 0 :this.physicalPartyLocationLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mailingEndTS == null)? 0 :this.mailingEndTS.hashCode()));
        result = ((result* 31)+((this.confirmationEmailWanted == null)? 0 :this.confirmationEmailWanted.hashCode()));
        result = ((result* 31)+((this.personalEmailLocLastUpdatedTS == null)? 0 :this.personalEmailLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.physicalAddressLine2 == null)? 0 :this.physicalAddressLine2 .hashCode()));
        result = ((result* 31)+((this.physicalAddressLine1 == null)? 0 :this.physicalAddressLine1 .hashCode()));
        result = ((result* 31)+((this.mobilePhoneNumber == null)? 0 :this.mobilePhoneNumber.hashCode()));
        result = ((result* 31)+((this.personalEmailLocId == null)? 0 :this.personalEmailLocId.hashCode()));
        result = ((result* 31)+((this.mailingCity == null)? 0 :this.mailingCity.hashCode()));
        result = ((result* 31)+((this.businessPhoneLocLastUpdatedTS == null)? 0 :this.businessPhoneLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.updateRequired == null)? 0 :this.updateRequired.hashCode()));
        result = ((result* 31)+((this.legalNameLastUpdatedTS == null)? 0 :this.legalNameLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.physicalLastUpdatedTS == null)? 0 :this.physicalLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.homePhoneLocLastUpdatedTS == null)? 0 :this.homePhoneLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.birthDate == null)? 0 :this.birthDate.hashCode()));
        result = ((result* 31)+((this.employerCity == null)? 0 :this.employerCity.hashCode()));
        result = ((result* 31)+((this.businessPhoneLastUpdatedTS == null)? 0 :this.businessPhoneLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.mailingPostalCode == null)? 0 :this.mailingPostalCode.hashCode()));
        result = ((result* 31)+((this.physicalCity == null)? 0 :this.physicalCity.hashCode()));
        result = ((result* 31)+((this.primaryContact == null)? 0 :this.primaryContact.hashCode()));
        result = ((result* 31)+((this.physicalPostalCode == null)? 0 :this.physicalPostalCode.hashCode()));
        result = ((result* 31)+((this.homePhoneEndTS == null)? 0 :this.homePhoneEndTS.hashCode()));
        result = ((result* 31)+((this.physicalCountry == null)? 0 :this.physicalCountry.hashCode()));
        result = ((result* 31)+((this.emailLastUpdatedTS == null)? 0 :this.emailLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.primaryResidenceEndTS == null)? 0 :this.primaryResidenceEndTS.hashCode()));
        result = ((result* 31)+((this.lastKYCUpdate == null)? 0 :this.lastKYCUpdate.hashCode()));
        result = ((result* 31)+((this.emailPartyLocationID == null)? 0 :this.emailPartyLocationID.hashCode()));
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
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.hasOtherIncome == rhs.hasOtherIncome)||((this.hasOtherIncome!= null)&&this.hasOtherIncome.equals(rhs.hasOtherIncome)))&&((this.bookOfBusCD == rhs.bookOfBusCD)||((this.bookOfBusCD!= null)&&this.bookOfBusCD.equals(rhs.bookOfBusCD))))&&((this.homePhonePartyLocationID == rhs.homePhonePartyLocationID)||((this.homePhonePartyLocationID!= null)&&this.homePhonePartyLocationID.equals(rhs.homePhonePartyLocationID))))&&((this.occupation == rhs.occupation)||((this.occupation!= null)&&this.occupation.equals(rhs.occupation))))&&((this.employerAddress == rhs.employerAddress)||((this.employerAddress!= null)&&this.employerAddress.equals(rhs.employerAddress))))&&((this.homePhoneNumber == rhs.homePhoneNumber)||((this.homePhoneNumber!= null)&&this.homePhoneNumber.equals(rhs.homePhoneNumber))))&&((this.physicalProvince == rhs.physicalProvince)||((this.physicalProvince!= null)&&this.physicalProvince.equals(rhs.physicalProvince))))&&((this.marketingByPersonalEmailOptionLastUpdatedTS == rhs.marketingByPersonalEmailOptionLastUpdatedTS)||((this.marketingByPersonalEmailOptionLastUpdatedTS!= null)&&this.marketingByPersonalEmailOptionLastUpdatedTS.equals(rhs.marketingByPersonalEmailOptionLastUpdatedTS))))&&((this.employerPostalCode == rhs.employerPostalCode)||((this.employerPostalCode!= null)&&this.employerPostalCode.equals(rhs.employerPostalCode))))&&((this.authorizedUsers == rhs.authorizedUsers)||((this.authorizedUsers!= null)&&this.authorizedUsers.equals(rhs.authorizedUsers))))&&((this.mobilePhonePartyLocationID == rhs.mobilePhonePartyLocationID)||((this.mobilePhonePartyLocationID!= null)&&this.mobilePhonePartyLocationID.equals(rhs.mobilePhonePartyLocationID))))&&((this.employmentStatus == rhs.employmentStatus)||((this.employmentStatus!= null)&&this.employmentStatus.equals(rhs.employmentStatus))))&&((this.personalEmail == rhs.personalEmail)||((this.personalEmail!= null)&&this.personalEmail.equals(rhs.personalEmail))))&&((this.homePhoneLastUpdatedTS == rhs.homePhoneLastUpdatedTS)||((this.homePhoneLastUpdatedTS!= null)&&this.homePhoneLastUpdatedTS.equals(rhs.homePhoneLastUpdatedTS))))&&((this.mailingAddressLine1 == rhs.mailingAddressLine1)||((this.mailingAddressLine1 != null)&&this.mailingAddressLine1 .equals(rhs.mailingAddressLine1))))&&((this.mailingAddressLine2 == rhs.mailingAddressLine2)||((this.mailingAddressLine2 != null)&&this.mailingAddressLine2 .equals(rhs.mailingAddressLine2))))&&((this.mailingProvince == rhs.mailingProvince)||((this.mailingProvince!= null)&&this.mailingProvince.equals(rhs.mailingProvince))))&&((this.homePhoneEffectiveTS == rhs.homePhoneEffectiveTS)||((this.homePhoneEffectiveTS!= null)&&this.homePhoneEffectiveTS.equals(rhs.homePhoneEffectiveTS))))&&((this.mailingArgLocLastUpdatedTS == rhs.mailingArgLocLastUpdatedTS)||((this.mailingArgLocLastUpdatedTS!= null)&&this.mailingArgLocLastUpdatedTS.equals(rhs.mailingArgLocLastUpdatedTS))))&&((this.mailingCountry == rhs.mailingCountry)||((this.mailingCountry!= null)&&this.mailingCountry.equals(rhs.mailingCountry))))&&((this.businessPhoneEffectiveTS == rhs.businessPhoneEffectiveTS)||((this.businessPhoneEffectiveTS!= null)&&this.businessPhoneEffectiveTS.equals(rhs.businessPhoneEffectiveTS))))&&((this.riskScore == rhs.riskScore)||((this.riskScore!= null)&&this.riskScore.equals(rhs.riskScore))))&&((this.employerPhone == rhs.employerPhone)||((this.employerPhone!= null)&&this.employerPhone.equals(rhs.employerPhone))))&&((this.businessPhoneEndTS == rhs.businessPhoneEndTS)||((this.businessPhoneEndTS!= null)&&this.businessPhoneEndTS.equals(rhs.businessPhoneEndTS))))&&((this.marketingEmailWanted == rhs.marketingEmailWanted)||((this.marketingEmailWanted!= null)&&this.marketingEmailWanted.equals(rhs.marketingEmailWanted))))&&((this.personLastUpdatedTS == rhs.personLastUpdatedTS)||((this.personLastUpdatedTS!= null)&&this.personLastUpdatedTS.equals(rhs.personLastUpdatedTS))))&&((this.mailingAddressPartyLocationID == rhs.mailingAddressPartyLocationID)||((this.mailingAddressPartyLocationID!= null)&&this.mailingAddressPartyLocationID.equals(rhs.mailingAddressPartyLocationID))))&&((this.homePhone == rhs.homePhone)||((this.homePhone!= null)&&this.homePhone.equals(rhs.homePhone))))&&((this.primaryUser == rhs.primaryUser)||((this.primaryUser!= null)&&this.primaryUser.equals(rhs.primaryUser))))&&((this.otherIncomeLastUpdatedTS == rhs.otherIncomeLastUpdatedTS)||((this.otherIncomeLastUpdatedTS!= null)&&this.otherIncomeLastUpdatedTS.equals(rhs.otherIncomeLastUpdatedTS))))&&((this.incomeFrequency == rhs.incomeFrequency)||((this.incomeFrequency!= null)&&this.incomeFrequency.equals(rhs.incomeFrequency))))&&((this.otherIncome == rhs.otherIncome)||((this.otherIncome!= null)&&this.otherIncome.equals(rhs.otherIncome))))&&((this.mobilePhoneEffectiveTS == rhs.mobilePhoneEffectiveTS)||((this.mobilePhoneEffectiveTS!= null)&&this.mobilePhoneEffectiveTS.equals(rhs.mobilePhoneEffectiveTS))))&&((this.mailingLastUpdatedTS == rhs.mailingLastUpdatedTS)||((this.mailingLastUpdatedTS!= null)&&this.mailingLastUpdatedTS.equals(rhs.mailingLastUpdatedTS))))&&((this.otherIncomeSource == rhs.otherIncomeSource)||((this.otherIncomeSource!= null)&&this.otherIncomeSource.equals(rhs.otherIncomeSource))))&&((this.mobilePhone == rhs.mobilePhone)||((this.mobilePhone!= null)&&this.mobilePhone.equals(rhs.mobilePhone))))&&((this.mobilePhoneEndTS == rhs.mobilePhoneEndTS)||((this.mobilePhoneEndTS!= null)&&this.mobilePhoneEndTS.equals(rhs.mobilePhoneEndTS))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.businessPhone == rhs.businessPhone)||((this.businessPhone!= null)&&this.businessPhone.equals(rhs.businessPhone))))&&((this.position == rhs.position)||((this.position!= null)&&this.position.equals(rhs.position))))&&((this.authorizedUser == rhs.authorizedUser)||((this.authorizedUser!= null)&&this.authorizedUser.equals(rhs.authorizedUser))))&&((this.bookOfBusLastUpdatedTS == rhs.bookOfBusLastUpdatedTS)||((this.bookOfBusLastUpdatedTS!= null)&&this.bookOfBusLastUpdatedTS.equals(rhs.bookOfBusLastUpdatedTS))))&&((this.businessPhoneNumber == rhs.businessPhoneNumber)||((this.businessPhoneNumber!= null)&&this.businessPhoneNumber.equals(rhs.businessPhoneNumber))))&&((this.income == rhs.income)||((this.income!= null)&&this.income.equals(rhs.income))))&&((this.physicalPartyLocationID == rhs.physicalPartyLocationID)||((this.physicalPartyLocationID!= null)&&this.physicalPartyLocationID.equals(rhs.physicalPartyLocationID))))&&((this.updateProfile == rhs.updateProfile)||((this.updateProfile!= null)&&this.updateProfile.equals(rhs.updateProfile))))&&((this.differentPhysicalAddress == rhs.differentPhysicalAddress)||((this.differentPhysicalAddress!= null)&&this.differentPhysicalAddress.equals(rhs.differentPhysicalAddress))))&&((this.businessPhonePartyLocationID == rhs.businessPhonePartyLocationID)||((this.businessPhonePartyLocationID!= null)&&this.businessPhonePartyLocationID.equals(rhs.businessPhonePartyLocationID))))&&((this.unsuccessfulDevilery == rhs.unsuccessfulDevilery)||((this.unsuccessfulDevilery!= null)&&this.unsuccessfulDevilery.equals(rhs.unsuccessfulDevilery))))&&((this.employerName == rhs.employerName)||((this.employerName!= null)&&this.employerName.equals(rhs.employerName))))&&((this.emailAddressLastUpdatedTS == rhs.emailAddressLastUpdatedTS)||((this.emailAddressLastUpdatedTS!= null)&&this.emailAddressLastUpdatedTS.equals(rhs.emailAddressLastUpdatedTS))))&&((this.natureOfBusiness == rhs.natureOfBusiness)||((this.natureOfBusiness!= null)&&this.natureOfBusiness.equals(rhs.natureOfBusiness))))&&((this.primaryResidenceLastUpdatedTS == rhs.primaryResidenceLastUpdatedTS)||((this.primaryResidenceLastUpdatedTS!= null)&&this.primaryResidenceLastUpdatedTS.equals(rhs.primaryResidenceLastUpdatedTS))))&&((this.grossIncomeLastUpdatedTS == rhs.grossIncomeLastUpdatedTS)||((this.grossIncomeLastUpdatedTS!= null)&&this.grossIncomeLastUpdatedTS.equals(rhs.grossIncomeLastUpdatedTS))))&&((this.mobilePhoneLastUpdatedTS == rhs.mobilePhoneLastUpdatedTS)||((this.mobilePhoneLastUpdatedTS!= null)&&this.mobilePhoneLastUpdatedTS.equals(rhs.mobilePhoneLastUpdatedTS))))&&((this.otherIncomeFrequency == rhs.otherIncomeFrequency)||((this.otherIncomeFrequency!= null)&&this.otherIncomeFrequency.equals(rhs.otherIncomeFrequency))))&&((this.employerPhoneType == rhs.employerPhoneType)||((this.employerPhoneType!= null)&&this.employerPhoneType.equals(rhs.employerPhoneType))))&&((this.lastKYCRefresh == rhs.lastKYCRefresh)||((this.lastKYCRefresh!= null)&&this.lastKYCRefresh.equals(rhs.lastKYCRefresh))))&&((this.mobilePhoneLocLastUpdatedTS == rhs.mobilePhoneLocLastUpdatedTS)||((this.mobilePhoneLocLastUpdatedTS!= null)&&this.mobilePhoneLocLastUpdatedTS.equals(rhs.mobilePhoneLocLastUpdatedTS))))&&((this.employerProvince == rhs.employerProvince)||((this.employerProvince!= null)&&this.employerProvince.equals(rhs.employerProvince))))&&((this.partyAgreementLastUpdatedTS == rhs.partyAgreementLastUpdatedTS)||((this.partyAgreementLastUpdatedTS!= null)&&this.partyAgreementLastUpdatedTS.equals(rhs.partyAgreementLastUpdatedTS))))&&((this.languagePref == rhs.languagePref)||((this.languagePref!= null)&&this.languagePref.equals(rhs.languagePref))))&&((this.employmentLastUpdatedTS == rhs.employmentLastUpdatedTS)||((this.employmentLastUpdatedTS!= null)&&this.employmentLastUpdatedTS.equals(rhs.employmentLastUpdatedTS))))&&((this.personalEmailLastUpdatedTS == rhs.personalEmailLastUpdatedTS)||((this.personalEmailLastUpdatedTS!= null)&&this.personalEmailLastUpdatedTS.equals(rhs.personalEmailLastUpdatedTS))))&&((this.primIncomeLastUpdatedTS == rhs.primIncomeLastUpdatedTS)||((this.primIncomeLastUpdatedTS!= null)&&this.primIncomeLastUpdatedTS.equals(rhs.primIncomeLastUpdatedTS))))&&((this.physicalPartyLocationLastUpdatedTS == rhs.physicalPartyLocationLastUpdatedTS)||((this.physicalPartyLocationLastUpdatedTS!= null)&&this.physicalPartyLocationLastUpdatedTS.equals(rhs.physicalPartyLocationLastUpdatedTS))))&&((this.mailingEndTS == rhs.mailingEndTS)||((this.mailingEndTS!= null)&&this.mailingEndTS.equals(rhs.mailingEndTS))))&&((this.confirmationEmailWanted == rhs.confirmationEmailWanted)||((this.confirmationEmailWanted!= null)&&this.confirmationEmailWanted.equals(rhs.confirmationEmailWanted))))&&((this.personalEmailLocLastUpdatedTS == rhs.personalEmailLocLastUpdatedTS)||((this.personalEmailLocLastUpdatedTS!= null)&&this.personalEmailLocLastUpdatedTS.equals(rhs.personalEmailLocLastUpdatedTS))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.physicalAddressLine2 == rhs.physicalAddressLine2)||((this.physicalAddressLine2 != null)&&this.physicalAddressLine2 .equals(rhs.physicalAddressLine2))))&&((this.physicalAddressLine1 == rhs.physicalAddressLine1)||((this.physicalAddressLine1 != null)&&this.physicalAddressLine1 .equals(rhs.physicalAddressLine1))))&&((this.mobilePhoneNumber == rhs.mobilePhoneNumber)||((this.mobilePhoneNumber!= null)&&this.mobilePhoneNumber.equals(rhs.mobilePhoneNumber))))&&((this.personalEmailLocId == rhs.personalEmailLocId)||((this.personalEmailLocId!= null)&&this.personalEmailLocId.equals(rhs.personalEmailLocId))))&&((this.mailingCity == rhs.mailingCity)||((this.mailingCity!= null)&&this.mailingCity.equals(rhs.mailingCity))))&&((this.businessPhoneLocLastUpdatedTS == rhs.businessPhoneLocLastUpdatedTS)||((this.businessPhoneLocLastUpdatedTS!= null)&&this.businessPhoneLocLastUpdatedTS.equals(rhs.businessPhoneLocLastUpdatedTS))))&&((this.updateRequired == rhs.updateRequired)||((this.updateRequired!= null)&&this.updateRequired.equals(rhs.updateRequired))))&&((this.legalNameLastUpdatedTS == rhs.legalNameLastUpdatedTS)||((this.legalNameLastUpdatedTS!= null)&&this.legalNameLastUpdatedTS.equals(rhs.legalNameLastUpdatedTS))))&&((this.physicalLastUpdatedTS == rhs.physicalLastUpdatedTS)||((this.physicalLastUpdatedTS!= null)&&this.physicalLastUpdatedTS.equals(rhs.physicalLastUpdatedTS))))&&((this.homePhoneLocLastUpdatedTS == rhs.homePhoneLocLastUpdatedTS)||((this.homePhoneLocLastUpdatedTS!= null)&&this.homePhoneLocLastUpdatedTS.equals(rhs.homePhoneLocLastUpdatedTS))))&&((this.birthDate == rhs.birthDate)||((this.birthDate!= null)&&this.birthDate.equals(rhs.birthDate))))&&((this.employerCity == rhs.employerCity)||((this.employerCity!= null)&&this.employerCity.equals(rhs.employerCity))))&&((this.businessPhoneLastUpdatedTS == rhs.businessPhoneLastUpdatedTS)||((this.businessPhoneLastUpdatedTS!= null)&&this.businessPhoneLastUpdatedTS.equals(rhs.businessPhoneLastUpdatedTS))))&&((this.mailingPostalCode == rhs.mailingPostalCode)||((this.mailingPostalCode!= null)&&this.mailingPostalCode.equals(rhs.mailingPostalCode))))&&((this.physicalCity == rhs.physicalCity)||((this.physicalCity!= null)&&this.physicalCity.equals(rhs.physicalCity))))&&((this.primaryContact == rhs.primaryContact)||((this.primaryContact!= null)&&this.primaryContact.equals(rhs.primaryContact))))&&((this.physicalPostalCode == rhs.physicalPostalCode)||((this.physicalPostalCode!= null)&&this.physicalPostalCode.equals(rhs.physicalPostalCode))))&&((this.homePhoneEndTS == rhs.homePhoneEndTS)||((this.homePhoneEndTS!= null)&&this.homePhoneEndTS.equals(rhs.homePhoneEndTS))))&&((this.physicalCountry == rhs.physicalCountry)||((this.physicalCountry!= null)&&this.physicalCountry.equals(rhs.physicalCountry))))&&((this.emailLastUpdatedTS == rhs.emailLastUpdatedTS)||((this.emailLastUpdatedTS!= null)&&this.emailLastUpdatedTS.equals(rhs.emailLastUpdatedTS))))&&((this.primaryResidenceEndTS == rhs.primaryResidenceEndTS)||((this.primaryResidenceEndTS!= null)&&this.primaryResidenceEndTS.equals(rhs.primaryResidenceEndTS))))&&((this.lastKYCUpdate == rhs.lastKYCUpdate)||((this.lastKYCUpdate!= null)&&this.lastKYCUpdate.equals(rhs.lastKYCUpdate))))&&((this.emailPartyLocationID == rhs.emailPartyLocationID)||((this.emailPartyLocationID!= null)&&this.emailPartyLocationID.equals(rhs.emailPartyLocationID))));
    }

}
