
package com.td.api.mbcapd.response.retrievecapd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Agreement {

    private String agreementKey;
    private String accountApplicationCd;
    private String accountNum;
    private String branchNum;
    private BigDecimal balanceAmt;
    private BigDecimal creditLimitAmt;
    private List<AlertSetup> alertSetup = new ArrayList<AlertSetup>();
    private List<Contact> contact = new ArrayList<Contact>();
    
    public String getAgreementKey() {
		return agreementKey;
	}

	public void setAgreementKey(String agreementKey) {
		this.agreementKey = agreementKey;
	}

	public String getAccountApplicationCd() {
		return accountApplicationCd;
	}

	public void setAccountApplicationCd(String accountApplicationCd) {
		this.accountApplicationCd = accountApplicationCd;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getBranchNum() {
		return branchNum;
	}

	public void setBranchNum(String branchNum) {
		this.branchNum = branchNum;
	}

	public BigDecimal getBalanceAmt() {
		return balanceAmt;
	}

	public void setBalanceAmt(BigDecimal balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	public BigDecimal getCreditLimitAmt() {
		return creditLimitAmt;
	}

	public void setCreditLimitAmt(BigDecimal creditLimitAmt) {
		this.creditLimitAmt = creditLimitAmt;
	}

	public List<AlertSetup> getAlertSetup() {
		return alertSetup;
	}

	public void setAlertSetup(List<AlertSetup> alertSetup) {
		this.alertSetup = alertSetup;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Agreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("agreementKey");
        sb.append('=');
        sb.append(((this.agreementKey == null)?"<null>":this.agreementKey));
        sb.append(',');
        sb.append("accountApplicationCd");
        sb.append('=');
        sb.append(((this.accountApplicationCd == null)?"<null>":this.accountApplicationCd));
        sb.append(',');
        sb.append("accountNum");
        sb.append('=');
        sb.append(((this.accountNum == null)?"<null>":this.accountNum));
        sb.append(',');
        sb.append("branchNum");
        sb.append('=');
        sb.append(((this.branchNum == null)?"<null>":this.branchNum));
        sb.append(',');
        sb.append("balanceAmt");
        sb.append('=');
        sb.append(((this.balanceAmt == null)?"<null>":this.balanceAmt));
        sb.append(',');
        sb.append("creditLimitAmt");
        sb.append('=');
        sb.append(((this.creditLimitAmt == null)?"<null>":this.creditLimitAmt));
        sb.append(',');
        sb.append("alertSetup");
        sb.append('=');
        sb.append(((this.alertSetup == null)?"<null>":this.alertSetup));
        sb.append(',');
        sb.append("contact");
        sb.append('=');
        sb.append(((this.contact == null)?"<null>":this.contact));
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
        result = ((result* 31)+((this.balanceAmt == null)? 0 :this.balanceAmt.hashCode()));
        result = ((result* 31)+((this.alertSetup == null)? 0 :this.alertSetup.hashCode()));
        result = ((result* 31)+((this.accountApplicationCd == null)? 0 :this.accountApplicationCd.hashCode()));
        result = ((result* 31)+((this.accountNum == null)? 0 :this.accountNum.hashCode()));
        result = ((result* 31)+((this.agreementKey == null)? 0 :this.agreementKey.hashCode()));
        result = ((result* 31)+((this.creditLimitAmt == null)? 0 :this.creditLimitAmt.hashCode()));
        result = ((result* 31)+((this.contact == null)? 0 :this.contact.hashCode()));
        result = ((result* 31)+((this.branchNum == null)? 0 :this.branchNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Agreement) == false) {
            return false;
        }
        Agreement rhs = ((Agreement) other);
        return (((((((((this.balanceAmt == rhs.balanceAmt)||((this.balanceAmt!= null)&&this.balanceAmt.equals(rhs.balanceAmt)))&&((this.alertSetup == rhs.alertSetup)||((this.alertSetup!= null)&&this.alertSetup.equals(rhs.alertSetup))))&&((this.accountApplicationCd == rhs.accountApplicationCd)||((this.accountApplicationCd!= null)&&this.accountApplicationCd.equals(rhs.accountApplicationCd))))&&((this.accountNum == rhs.accountNum)||((this.accountNum!= null)&&this.accountNum.equals(rhs.accountNum))))&&((this.agreementKey == rhs.agreementKey)||((this.agreementKey!= null)&&this.agreementKey.equals(rhs.agreementKey))))&&((this.creditLimitAmt == rhs.creditLimitAmt)||((this.creditLimitAmt!= null)&&this.creditLimitAmt.equals(rhs.creditLimitAmt))))&&((this.contact == rhs.contact)||((this.contact!= null)&&this.contact.equals(rhs.contact))))&&((this.branchNum == rhs.branchNum)||((this.branchNum!= null)&&this.branchNum.equals(rhs.branchNum))));
    }

}
