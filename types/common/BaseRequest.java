package com.td.mbna.msec.midtier.types.common;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

public class BaseRequest extends TrackableRequest implements Serializable {

	private static final long serialVersionUID = -3081941393711300375L;
	@NotNull
    @Valid
    protected String custId;
	@NotNull
	@Valid
	protected AuditInfo auditInfo;	
    protected String aliasCustId;
    protected String acctNum;
    protected String acctType;
    protected String languagePref;
    protected String reserved1;
    protected String custInterface;
    protected Boolean isPrimaryUser = false;
    protected Boolean isMultiCard=false;
    protected String cardNum;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAliasCustId() {
        return aliasCustId;
    }
    
    public void setAliasCustId(String aliasCustId) {
        this.aliasCustId = aliasCustId;
    }
    
    public String getAcctNum() {
        return acctNum;
    }
    
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }
    
    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }
    
    public String getLanguagePref() {
        return languagePref;
    }
    
    public void setLanguagePref(String languagePref) {
        this.languagePref = languagePref;
    }
    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    public Boolean getIsPrimaryUser() {
        return isPrimaryUser;
    }

    public void setIsPrimaryUser(Boolean isPrimaryUser) {
        this.isPrimaryUser = isPrimaryUser;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getCustInterface() {
        return custInterface;
    }
    
    public void setCustInterface(String custInterface) {
        this.custInterface = custInterface;
    }

    public Boolean isMultiCard() {
        return isMultiCard;
    }

    public void setMultiCard(Boolean multiCard) {
        isMultiCard = multiCard;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BaseRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sessionInfo");
        sb.append('=');
        sb.append(((this.sessionInfo == null)?"<null>":this.sessionInfo));
        sb.append(',');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("aliasCustId");
        sb.append('=');
        sb.append(((this.aliasCustId == null)?"<null>":this.aliasCustId));
        sb.append(',');
        sb.append("acctNum");
        sb.append('=');
        sb.append(((this.acctNum == null)?"<null>":this.acctNum));
        sb.append(',');
        sb.append("acctType");
        sb.append('=');
        sb.append(((this.acctType == null)?"<null>":this.acctType));
        sb.append(',');
        sb.append("languagePref");
        sb.append('=');
        sb.append(((this.languagePref == null)?"<null>":this.languagePref));
        sb.append(',');
        sb.append("auditInfo");
        sb.append('=');
        sb.append(((this.auditInfo == null)?"<null>":this.auditInfo));
        sb.append(',');
        sb.append("isPrimaryUser");
        sb.append('=');
        sb.append(((this.isPrimaryUser == null)?"<null>":this.isPrimaryUser));
        sb.append(',');
        sb.append("reserved1");
        sb.append('=');
        sb.append(((this.reserved1 == null)?"<null>":this.reserved1));
        sb.append(',');
        sb.append("custInterface");
        sb.append('=');
        sb.append(((this.custInterface == null)?"<null>":this.custInterface));
        sb.append(',');

        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');

        sb.append("isMultiCard");
        sb.append('=');
        sb.append(((this.isMultiCard == null)?"<null>":this.isMultiCard));
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
        result = ((result* 31)+((this.sessionInfo == null)? 0 :this.sessionInfo.hashCode()));
        result = ((result* 31)+((this.auditInfo == null)? 0 :this.auditInfo.hashCode()));
        result = ((result* 31)+((this.aliasCustId == null)? 0 :this.aliasCustId.hashCode()));
        result = ((result* 31)+((this.custInterface == null)? 0 :this.custInterface.hashCode()));
        result = ((result* 31)+((this.languagePref == null)? 0 :this.languagePref.hashCode()));
        result = ((result* 31)+((this.acctNum == null)? 0 :this.acctNum.hashCode()));
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.acctType == null)? 0 :this.acctType.hashCode()));
        result = ((result* 31)+((this.reserved1 == null)? 0 :this.reserved1 .hashCode()));
        result = ((result* 31)+((this.isPrimaryUser == null)? 0 :this.isPrimaryUser.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.isMultiCard == null)? 0 :this.isMultiCard.hashCode()));


        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BaseRequest) == false) {
            return false;
        }
        BaseRequest rhs = ((BaseRequest) other);
        return ((((((((((((this.sessionInfo == rhs.sessionInfo)||((this.sessionInfo!= null)&&this.sessionInfo.equals(rhs.sessionInfo)))&&((this.auditInfo == rhs.auditInfo)||((this.auditInfo!= null)&&this.auditInfo.equals(rhs.auditInfo))))&&((this.aliasCustId == rhs.aliasCustId)||((this.aliasCustId!= null)&&this.aliasCustId.equals(rhs.aliasCustId))))&&((this.custInterface == rhs.custInterface)||((this.custInterface!= null)&&this.custInterface.equals(rhs.custInterface))))&&((this.languagePref == rhs.languagePref)||((this.languagePref!= null)&&this.languagePref.equals(rhs.languagePref))))&&((this.acctNum == rhs.acctNum)||((this.acctNum!= null)&&this.acctNum.equals(rhs.acctNum)))))&&((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId))))&&((this.acctType == rhs.acctType)||((this.acctType!= null)&&this.acctType.equals(rhs.acctType))))&&((this.reserved1 == rhs.reserved1)||((this.reserved1 != null)&&this.reserved1 .equals(rhs.reserved1))))&&((this.isPrimaryUser == rhs.isPrimaryUser)||((this.isPrimaryUser!= null)&&this.isPrimaryUser.equals(rhs.isPrimaryUser)))
                         && ((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum)))
                         && ((this.isMultiCard == rhs.isMultiCard)||((this.isMultiCard!= null)&&this.isMultiCard.equals(rhs.isMultiCard))));
    }
}
