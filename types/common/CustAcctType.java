package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustAcctType implements Serializable {

	private static final long serialVersionUID = 3259485443574131648L;
    private String acctNum;
    private String cardNum;
    private List<CardNumHistoryType> cardNumList = new ArrayList<CardNumHistoryType>();
    private CardHolderType cardHolder;
    private String roleCD;
    private String productCodes;
    private String poCode;
    private String arqCode;
    private AffinitySpecType affinitySpec;
    private AffinityInfoType affinity;

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public List<CardNumHistoryType> getCardNumList() {
        return cardNumList;
    }

    public void setCardNumList(List<CardNumHistoryType> cardNumList) {
        this.cardNumList = cardNumList;
    }

    public CardHolderType getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolderType cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getRoleCD() {
        return roleCD;
    }

    public void setRoleCD(String roleCD) {
        this.roleCD = roleCD;
    }

    public String getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(String productCodes) {
        this.productCodes = productCodes;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }

    public String getArqCode() {
        return arqCode;
    }

    public void setArqCode(String arqCode) {
        this.arqCode = arqCode;
    }

    public AffinitySpecType getAffinitySpec() {
        return affinitySpec;
    }

    public void setAffinitySpec(AffinitySpecType affinitySpec) {
        this.affinitySpec = affinitySpec;
    }

    public AffinityInfoType getAffinity() {
        return affinity;
    }

    public void setAffinity(AffinityInfoType affinity) {
        this.affinity = affinity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustAcctType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("acctNum");
        sb.append('=');
        sb.append(((this.acctNum == null)?"<null>":this.acctNum));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("cardNumList");
        sb.append('=');
        sb.append(((this.cardNumList == null)?"<null>":this.cardNumList));
        sb.append(',');
        sb.append("cardHolder");
        sb.append('=');
        sb.append(((this.cardHolder == null)?"<null>":this.cardHolder));
        sb.append(',');
        sb.append("roleCD");
        sb.append('=');
        sb.append(((this.roleCD == null)?"<null>":this.roleCD));
        sb.append(',');
        sb.append("productCodes");
        sb.append('=');
        sb.append(((this.productCodes == null)?"<null>":this.productCodes));
        sb.append(',');
        sb.append("poCode");
        sb.append('=');
        sb.append(((this.poCode == null)?"<null>":this.poCode));
        sb.append(',');
        sb.append("arqCode");
        sb.append('=');
        sb.append(((this.arqCode == null)?"<null>":this.arqCode));
        sb.append(',');
        sb.append("affinitySpec");
        sb.append('=');
        sb.append(((this.affinitySpec == null)?"<null>":this.affinitySpec));
        sb.append(',');
        sb.append("affinity");
        sb.append('=');
        sb.append(((this.affinity == null)?"<null>":this.affinity));
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
        result = ((result* 31)+((this.arqCode == null)? 0 :this.arqCode.hashCode()));
        result = ((result* 31)+((this.cardNumList == null)? 0 :this.cardNumList.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.acctNum == null)? 0 :this.acctNum.hashCode()));
        result = ((result* 31)+((this.affinitySpec == null)? 0 :this.affinitySpec.hashCode()));
        result = ((result* 31)+((this.poCode == null)? 0 :this.poCode.hashCode()));
        result = ((result* 31)+((this.cardHolder == null)? 0 :this.cardHolder.hashCode()));
        result = ((result* 31)+((this.productCodes == null)? 0 :this.productCodes.hashCode()));
        result = ((result* 31)+((this.affinity == null)? 0 :this.affinity.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustAcctType) == false) {
            return false;
        }
        CustAcctType rhs = ((CustAcctType) other);
        return (((((((((((this.roleCD == rhs.roleCD)||((this.roleCD!= null)&&this.roleCD.equals(rhs.roleCD)))&&((this.arqCode == rhs.arqCode)||((this.arqCode!= null)&&this.arqCode.equals(rhs.arqCode))))&&((this.cardNumList == rhs.cardNumList)||((this.cardNumList!= null)&&this.cardNumList.equals(rhs.cardNumList))))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.acctNum == rhs.acctNum)||((this.acctNum!= null)&&this.acctNum.equals(rhs.acctNum))))&&((this.affinitySpec == rhs.affinitySpec)||((this.affinitySpec!= null)&&this.affinitySpec.equals(rhs.affinitySpec))))&&((this.poCode == rhs.poCode)||((this.poCode!= null)&&this.poCode.equals(rhs.poCode))))&&((this.cardHolder == rhs.cardHolder)||((this.cardHolder!= null)&&this.cardHolder.equals(rhs.cardHolder))))&&((this.productCodes == rhs.productCodes)||((this.productCodes!= null)&&this.productCodes.equals(rhs.productCodes))))&&((this.affinity == rhs.affinity)||((this.affinity!= null)&&this.affinity.equals(rhs.affinity))));
    }

}
