package com.td.mbna.msec.midtier.creditcard.payload.decreasecardlimit;

import java.math.BigDecimal;

import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;

public class RequestPayload {

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
    private EmailNotificationInfoType emailNotificationInfo;

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
        result = ((result* 31)+((this.currentCreditLimit == null)? 0 :this.currentCreditLimit.hashCode()));
        result = ((result* 31)+((this.currentBalance == null)? 0 :this.currentBalance.hashCode()));
        result = ((result* 31)+((this.acctId == null)? 0 :this.acctId.hashCode()));
        result = ((result* 31)+((this.emailNotificationInfo == null)? 0 :this.emailNotificationInfo.hashCode()));
        result = ((result* 31)+((this.custName == null)? 0 :this.custName.hashCode()));
        result = ((result* 31)+((this.confirmed == null)? 0 :this.confirmed.hashCode()));
        result = ((result* 31)+((this.unbilledAmount == null)? 0 :this.unbilledAmount.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.phone == null)? 0 :this.phone.hashCode()));
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.creditLimit == null)? 0 :this.creditLimit.hashCode()));
        result = ((result* 31)+((this.emailRequired == null)? 0 :this.emailRequired.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
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
        return ((((((((((((((this.currentCreditLimit == rhs.currentCreditLimit)||((this.currentCreditLimit!= null)&&this.currentCreditLimit.equals(rhs.currentCreditLimit)))&&((this.currentBalance == rhs.currentBalance)||((this.currentBalance!= null)&&this.currentBalance.equals(rhs.currentBalance))))&&((this.acctId == rhs.acctId)||((this.acctId!= null)&&this.acctId.equals(rhs.acctId))))&&((this.emailNotificationInfo == rhs.emailNotificationInfo)||((this.emailNotificationInfo!= null)&&this.emailNotificationInfo.equals(rhs.emailNotificationInfo))))&&((this.custName == rhs.custName)||((this.custName!= null)&&this.custName.equals(rhs.custName))))&&((this.confirmed == rhs.confirmed)||((this.confirmed!= null)&&this.confirmed.equals(rhs.confirmed))))&&((this.unbilledAmount == rhs.unbilledAmount)||((this.unbilledAmount!= null)&&this.unbilledAmount.equals(rhs.unbilledAmount))))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.phone == rhs.phone)||((this.phone!= null)&&this.phone.equals(rhs.phone))))&&((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId))))&&((this.creditLimit == rhs.creditLimit)||((this.creditLimit!= null)&&this.creditLimit.equals(rhs.creditLimit))))&&((this.emailRequired == rhs.emailRequired)||((this.emailRequired!= null)&&this.emailRequired.equals(rhs.emailRequired))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))));
    }

}
