package com.td.mbna.msec.midtier.customerprofile.payload;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;
import com.td.mbna.msec.midtier.types.common.UserNameType;

import java.io.Serializable;
import java.math.BigDecimal;

public class CustomerInfoType implements Serializable {

	private static final long serialVersionUID = 7180562054265128630L;
    private String custId;
    private UserNameType name;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long legalNameLastUpdatedTS;

    private String birthDate;
    private String physicalAddressLine1;
    private String physicalCity;
    private String physicalProvince;
    private String physicalPostalCode;
    private String physicalCountry;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long physicalLastUpdatedTS;

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
    private Boolean hasOtherIncome;
    private BigDecimal otherIncome;
    private String otherIncomeFrequency;
    private String otherIncomeSource;
    private Long lastKYCUpdate;
    private Long lastKYCRefresh;
    private Boolean enforceKYC;
    private String riskScore;
    private String languagePref;
    private String personalEmail;
    private String personalEmailLocId;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long personalEmailLocLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long personalEmailLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long marketingByPersonalEmailOptionLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long personLastUpdatedTS;

    private String bookOfBusCD;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long bookOfBusLastUpdatedTS;

    private String physicalPartyLocationID;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long physicalPartyLocationLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long primIncomeLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long otherIncomeLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long grossIncomeLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long employmentLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long primaryResidenceLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long primaryResidenceEndTS;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhysicalAddressLine1() {
        return physicalAddressLine1;
    }

    public void setPhysicalAddressLine1(String physicalAddressLine1) {
        this.physicalAddressLine1 = physicalAddressLine1;
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

    public Boolean getEnforceKYC() {
        return enforceKYC;
    }

    public void setEnforceKYC(Boolean enforceKYC) {
        this.enforceKYC = enforceKYC;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomerInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("legalNameLastUpdatedTS");
        sb.append('=');
        sb.append(((this.legalNameLastUpdatedTS == null)?"<null>":this.legalNameLastUpdatedTS));
        sb.append(',');
        sb.append("birthDate");
        sb.append('=');
        sb.append(((this.birthDate == null)?"<null>":this.birthDate));
        sb.append(',');
        sb.append("physicalAddressLine1");
        sb.append('=');
        sb.append(((this.physicalAddressLine1 == null)?"<null>":this.physicalAddressLine1));
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
        sb.append("occupation");
        sb.append('=');
        sb.append(((this.occupation == null)?"<null>":this.occupation));
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
        sb.append("lastKYCUpdate");
        sb.append('=');
        sb.append(((this.lastKYCUpdate == null)?"<null>":this.lastKYCUpdate));
        sb.append(',');
        sb.append("lastKYCRefresh");
        sb.append('=');
        sb.append(((this.lastKYCRefresh == null)?"<null>":this.lastKYCRefresh));
        sb.append(',');
        sb.append("enforceKYC");
        sb.append('=');
        sb.append(((this.enforceKYC == null)?"<null>":this.enforceKYC));
        sb.append(',');
        sb.append("riskScore");
        sb.append('=');
        sb.append(((this.riskScore == null)?"<null>":this.riskScore));
        sb.append(',');
        sb.append("languagePref");
        sb.append('=');
        sb.append(((this.languagePref == null)?"<null>":this.languagePref));
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
        sb.append("primaryResidenceLastUpdatedTS");
        sb.append('=');
        sb.append(((this.primaryResidenceLastUpdatedTS == null)?"<null>":this.primaryResidenceLastUpdatedTS));
        sb.append(',');
        sb.append("primaryResidenceEndTS");
        sb.append('=');
        sb.append(((this.primaryResidenceEndTS == null)?"<null>":this.primaryResidenceEndTS));
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
        result = ((result* 31)+((this.occupation == null)? 0 :this.occupation.hashCode()));
        result = ((result* 31)+((this.employerAddress == null)? 0 :this.employerAddress.hashCode()));
        result = ((result* 31)+((this.physicalProvince == null)? 0 :this.physicalProvince.hashCode()));
        result = ((result* 31)+((this.marketingByPersonalEmailOptionLastUpdatedTS == null)? 0 :this.marketingByPersonalEmailOptionLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.employerPostalCode == null)? 0 :this.employerPostalCode.hashCode()));
        result = ((result* 31)+((this.employmentStatus == null)? 0 :this.employmentStatus.hashCode()));
        result = ((result* 31)+((this.personalEmail == null)? 0 :this.personalEmail.hashCode()));
        result = ((result* 31)+((this.riskScore == null)? 0 :this.riskScore.hashCode()));
        result = ((result* 31)+((this.employerPhone == null)? 0 :this.employerPhone.hashCode()));
        result = ((result* 31)+((this.personLastUpdatedTS == null)? 0 :this.personLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.otherIncomeLastUpdatedTS == null)? 0 :this.otherIncomeLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.incomeFrequency == null)? 0 :this.incomeFrequency.hashCode()));
        result = ((result* 31)+((this.otherIncome == null)? 0 :this.otherIncome.hashCode()));
        result = ((result* 31)+((this.otherIncomeSource == null)? 0 :this.otherIncomeSource.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.position == null)? 0 :this.position.hashCode()));
        result = ((result* 31)+((this.bookOfBusLastUpdatedTS == null)? 0 :this.bookOfBusLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.income == null)? 0 :this.income.hashCode()));
        result = ((result* 31)+((this.physicalPartyLocationID == null)? 0 :this.physicalPartyLocationID.hashCode()));
        result = ((result* 31)+((this.employerName == null)? 0 :this.employerName.hashCode()));
        result = ((result* 31)+((this.natureOfBusiness == null)? 0 :this.natureOfBusiness.hashCode()));
        result = ((result* 31)+((this.primaryResidenceLastUpdatedTS == null)? 0 :this.primaryResidenceLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.grossIncomeLastUpdatedTS == null)? 0 :this.grossIncomeLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.otherIncomeFrequency == null)? 0 :this.otherIncomeFrequency.hashCode()));
        result = ((result* 31)+((this.employerPhoneType == null)? 0 :this.employerPhoneType.hashCode()));
        result = ((result* 31)+((this.lastKYCRefresh == null)? 0 :this.lastKYCRefresh.hashCode()));
        result = ((result* 31)+((this.employerProvince == null)? 0 :this.employerProvince.hashCode()));
        result = ((result* 31)+((this.languagePref == null)? 0 :this.languagePref.hashCode()));
        result = ((result* 31)+((this.personalEmailLastUpdatedTS == null)? 0 :this.personalEmailLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.employmentLastUpdatedTS == null)? 0 :this.employmentLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.primIncomeLastUpdatedTS == null)? 0 :this.primIncomeLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.physicalPartyLocationLastUpdatedTS == null)? 0 :this.physicalPartyLocationLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.personalEmailLocLastUpdatedTS == null)? 0 :this.personalEmailLocLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.physicalAddressLine1 == null)? 0 :this.physicalAddressLine1 .hashCode()));
        result = ((result* 31)+((this.personalEmailLocId == null)? 0 :this.personalEmailLocId.hashCode()));
        result = ((result* 31)+((this.enforceKYC == null)? 0 :this.enforceKYC.hashCode()));
        result = ((result* 31)+((this.legalNameLastUpdatedTS == null)? 0 :this.legalNameLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.physicalLastUpdatedTS == null)? 0 :this.physicalLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.birthDate == null)? 0 :this.birthDate.hashCode()));
        result = ((result* 31)+((this.employerCity == null)? 0 :this.employerCity.hashCode()));
        result = ((result* 31)+((this.physicalCity == null)? 0 :this.physicalCity.hashCode()));
        result = ((result* 31)+((this.physicalPostalCode == null)? 0 :this.physicalPostalCode.hashCode()));
        result = ((result* 31)+((this.physicalCountry == null)? 0 :this.physicalCountry.hashCode()));
        result = ((result* 31)+((this.primaryResidenceEndTS == null)? 0 :this.primaryResidenceEndTS.hashCode()));
        result = ((result* 31)+((this.lastKYCUpdate == null)? 0 :this.lastKYCUpdate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerInfoType) == false) {
            return false;
        }
        CustomerInfoType rhs = ((CustomerInfoType) other);
        return (((((((((((((((((((((((((((((((((((((((((((((((((this.hasOtherIncome == rhs.hasOtherIncome)||((this.hasOtherIncome!= null)&&this.hasOtherIncome.equals(rhs.hasOtherIncome)))&&((this.bookOfBusCD == rhs.bookOfBusCD)||((this.bookOfBusCD!= null)&&this.bookOfBusCD.equals(rhs.bookOfBusCD))))&&((this.occupation == rhs.occupation)||((this.occupation!= null)&&this.occupation.equals(rhs.occupation))))&&((this.employerAddress == rhs.employerAddress)||((this.employerAddress!= null)&&this.employerAddress.equals(rhs.employerAddress))))&&((this.physicalProvince == rhs.physicalProvince)||((this.physicalProvince!= null)&&this.physicalProvince.equals(rhs.physicalProvince))))&&((this.marketingByPersonalEmailOptionLastUpdatedTS == rhs.marketingByPersonalEmailOptionLastUpdatedTS)||((this.marketingByPersonalEmailOptionLastUpdatedTS!= null)&&this.marketingByPersonalEmailOptionLastUpdatedTS.equals(rhs.marketingByPersonalEmailOptionLastUpdatedTS))))&&((this.employerPostalCode == rhs.employerPostalCode)||((this.employerPostalCode!= null)&&this.employerPostalCode.equals(rhs.employerPostalCode))))&&((this.employmentStatus == rhs.employmentStatus)||((this.employmentStatus!= null)&&this.employmentStatus.equals(rhs.employmentStatus))))&&((this.personalEmail == rhs.personalEmail)||((this.personalEmail!= null)&&this.personalEmail.equals(rhs.personalEmail))))&&((this.riskScore == rhs.riskScore)||((this.riskScore!= null)&&this.riskScore.equals(rhs.riskScore))))&&((this.employerPhone == rhs.employerPhone)||((this.employerPhone!= null)&&this.employerPhone.equals(rhs.employerPhone))))&&((this.personLastUpdatedTS == rhs.personLastUpdatedTS)||((this.personLastUpdatedTS!= null)&&this.personLastUpdatedTS.equals(rhs.personLastUpdatedTS))))&&((this.otherIncomeLastUpdatedTS == rhs.otherIncomeLastUpdatedTS)||((this.otherIncomeLastUpdatedTS!= null)&&this.otherIncomeLastUpdatedTS.equals(rhs.otherIncomeLastUpdatedTS))))&&((this.incomeFrequency == rhs.incomeFrequency)||((this.incomeFrequency!= null)&&this.incomeFrequency.equals(rhs.incomeFrequency))))&&((this.otherIncome == rhs.otherIncome)||((this.otherIncome!= null)&&this.otherIncome.equals(rhs.otherIncome))))&&((this.otherIncomeSource == rhs.otherIncomeSource)||((this.otherIncomeSource!= null)&&this.otherIncomeSource.equals(rhs.otherIncomeSource))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.position == rhs.position)||((this.position!= null)&&this.position.equals(rhs.position))))&&((this.bookOfBusLastUpdatedTS == rhs.bookOfBusLastUpdatedTS)||((this.bookOfBusLastUpdatedTS!= null)&&this.bookOfBusLastUpdatedTS.equals(rhs.bookOfBusLastUpdatedTS))))&&((this.income == rhs.income)||((this.income!= null)&&this.income.equals(rhs.income))))&&((this.physicalPartyLocationID == rhs.physicalPartyLocationID)||((this.physicalPartyLocationID!= null)&&this.physicalPartyLocationID.equals(rhs.physicalPartyLocationID))))&&((this.employerName == rhs.employerName)||((this.employerName!= null)&&this.employerName.equals(rhs.employerName))))&&((this.natureOfBusiness == rhs.natureOfBusiness)||((this.natureOfBusiness!= null)&&this.natureOfBusiness.equals(rhs.natureOfBusiness))))&&((this.primaryResidenceLastUpdatedTS == rhs.primaryResidenceLastUpdatedTS)||((this.primaryResidenceLastUpdatedTS!= null)&&this.primaryResidenceLastUpdatedTS.equals(rhs.primaryResidenceLastUpdatedTS))))&&((this.grossIncomeLastUpdatedTS == rhs.grossIncomeLastUpdatedTS)||((this.grossIncomeLastUpdatedTS!= null)&&this.grossIncomeLastUpdatedTS.equals(rhs.grossIncomeLastUpdatedTS))))&&((this.otherIncomeFrequency == rhs.otherIncomeFrequency)||((this.otherIncomeFrequency!= null)&&this.otherIncomeFrequency.equals(rhs.otherIncomeFrequency))))&&((this.employerPhoneType == rhs.employerPhoneType)||((this.employerPhoneType!= null)&&this.employerPhoneType.equals(rhs.employerPhoneType))))&&((this.lastKYCRefresh == rhs.lastKYCRefresh)||((this.lastKYCRefresh!= null)&&this.lastKYCRefresh.equals(rhs.lastKYCRefresh))))&&((this.employerProvince == rhs.employerProvince)||((this.employerProvince!= null)&&this.employerProvince.equals(rhs.employerProvince))))&&((this.languagePref == rhs.languagePref)||((this.languagePref!= null)&&this.languagePref.equals(rhs.languagePref))))&&((this.personalEmailLastUpdatedTS == rhs.personalEmailLastUpdatedTS)||((this.personalEmailLastUpdatedTS!= null)&&this.personalEmailLastUpdatedTS.equals(rhs.personalEmailLastUpdatedTS))))&&((this.employmentLastUpdatedTS == rhs.employmentLastUpdatedTS)||((this.employmentLastUpdatedTS!= null)&&this.employmentLastUpdatedTS.equals(rhs.employmentLastUpdatedTS))))&&((this.primIncomeLastUpdatedTS == rhs.primIncomeLastUpdatedTS)||((this.primIncomeLastUpdatedTS!= null)&&this.primIncomeLastUpdatedTS.equals(rhs.primIncomeLastUpdatedTS))))&&((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId))))&&((this.physicalPartyLocationLastUpdatedTS == rhs.physicalPartyLocationLastUpdatedTS)||((this.physicalPartyLocationLastUpdatedTS!= null)&&this.physicalPartyLocationLastUpdatedTS.equals(rhs.physicalPartyLocationLastUpdatedTS))))&&((this.personalEmailLocLastUpdatedTS == rhs.personalEmailLocLastUpdatedTS)||((this.personalEmailLocLastUpdatedTS!= null)&&this.personalEmailLocLastUpdatedTS.equals(rhs.personalEmailLocLastUpdatedTS))))&&((this.physicalAddressLine1 == rhs.physicalAddressLine1)||((this.physicalAddressLine1 != null)&&this.physicalAddressLine1 .equals(rhs.physicalAddressLine1))))&&((this.personalEmailLocId == rhs.personalEmailLocId)||((this.personalEmailLocId!= null)&&this.personalEmailLocId.equals(rhs.personalEmailLocId))))&&((this.enforceKYC == rhs.enforceKYC)||((this.enforceKYC!= null)&&this.enforceKYC.equals(rhs.enforceKYC))))&&((this.legalNameLastUpdatedTS == rhs.legalNameLastUpdatedTS)||((this.legalNameLastUpdatedTS!= null)&&this.legalNameLastUpdatedTS.equals(rhs.legalNameLastUpdatedTS))))&&((this.physicalLastUpdatedTS == rhs.physicalLastUpdatedTS)||((this.physicalLastUpdatedTS!= null)&&this.physicalLastUpdatedTS.equals(rhs.physicalLastUpdatedTS))))&&((this.birthDate == rhs.birthDate)||((this.birthDate!= null)&&this.birthDate.equals(rhs.birthDate))))&&((this.employerCity == rhs.employerCity)||((this.employerCity!= null)&&this.employerCity.equals(rhs.employerCity))))&&((this.physicalCity == rhs.physicalCity)||((this.physicalCity!= null)&&this.physicalCity.equals(rhs.physicalCity))))&&((this.physicalPostalCode == rhs.physicalPostalCode)||((this.physicalPostalCode!= null)&&this.physicalPostalCode.equals(rhs.physicalPostalCode))))&&((this.physicalCountry == rhs.physicalCountry)||((this.physicalCountry!= null)&&this.physicalCountry.equals(rhs.physicalCountry))))&&((this.primaryResidenceEndTS == rhs.primaryResidenceEndTS)||((this.primaryResidenceEndTS!= null)&&this.primaryResidenceEndTS.equals(rhs.primaryResidenceEndTS))))&&((this.lastKYCUpdate == rhs.lastKYCUpdate)||((this.lastKYCUpdate!= null)&&this.lastKYCUpdate.equals(rhs.lastKYCUpdate))));
    }

}
