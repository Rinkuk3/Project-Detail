package com.td.mbna.msec.midtier.customerprofile.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.AcctContactInfoType;
import com.td.mbna.msec.midtier.types.common.CardHolderType;

public class CustomerAcctLogonInfoType implements Serializable {

	private static final long serialVersionUID = -7164480974856971512L;
	
    private CustomerInfoType custInfo;
    private CustomerAcctInfoType acctInfo;
    private CardHolderType cardHolder;
    private CardHolderType primaryCardHolder;
    private List<CardHolderType> otherCardHolders = new ArrayList<CardHolderType>();
    private AcctContactInfoType primaryUserContact;

    public CustomerInfoType getCustInfo() {
        return custInfo;
    }

    public void setCustInfo(CustomerInfoType custInfo) {
        this.custInfo = custInfo;
    }

    public CustomerAcctInfoType getAcctInfo() {
        return acctInfo;
    }

    public void setAcctInfo(CustomerAcctInfoType acctInfo) {
        this.acctInfo = acctInfo;
    }

    public CardHolderType getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolderType cardHolder) {
        this.cardHolder = cardHolder;
    }

    public CardHolderType getPrimaryCardHolder() {
        return primaryCardHolder;
    }

    public void setPrimaryCardHolder(CardHolderType primaryCardHolder) {
        this.primaryCardHolder = primaryCardHolder;
    }

    public List<CardHolderType> getOtherCardHolders() {
        return otherCardHolders;
    }

    public void setOtherCardHolders(List<CardHolderType> otherCardHolders) {
        this.otherCardHolders = otherCardHolders;
    }

    public AcctContactInfoType getPrimaryUserContact() {
        return primaryUserContact;
    }

    public void setPrimaryUserContact(AcctContactInfoType primaryUserContact) {
        this.primaryUserContact = primaryUserContact;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomerAcctLogonInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custInfo");
        sb.append('=');
        sb.append(((this.custInfo == null)?"<null>":this.custInfo));
        sb.append(',');
        sb.append("acctInfo");
        sb.append('=');
        sb.append(((this.acctInfo == null)?"<null>":this.acctInfo));
        sb.append(',');
        sb.append("cardHolder");
        sb.append('=');
        sb.append(((this.cardHolder == null)?"<null>":this.cardHolder));
        sb.append(',');
        sb.append("primaryCardHolder");
        sb.append('=');
        sb.append(((this.primaryCardHolder == null)?"<null>":this.primaryCardHolder));
        sb.append(',');
        sb.append("otherCardHolders");
        sb.append('=');
        sb.append(((this.otherCardHolders == null)?"<null>":this.otherCardHolders));
        sb.append(',');
        sb.append("primaryUserContact");
        sb.append('=');
        sb.append(((this.primaryUserContact == null)?"<null>":this.primaryUserContact));
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
        result = ((result* 31)+((this.custInfo == null)? 0 :this.custInfo.hashCode()));
        result = ((result* 31)+((this.acctInfo == null)? 0 :this.acctInfo.hashCode()));
        result = ((result* 31)+((this.primaryUserContact == null)? 0 :this.primaryUserContact.hashCode()));
        result = ((result* 31)+((this.cardHolder == null)? 0 :this.cardHolder.hashCode()));
        result = ((result* 31)+((this.primaryCardHolder == null)? 0 :this.primaryCardHolder.hashCode()));
        result = ((result* 31)+((this.otherCardHolders == null)? 0 :this.otherCardHolders.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerAcctLogonInfoType) == false) {
            return false;
        }
        CustomerAcctLogonInfoType rhs = ((CustomerAcctLogonInfoType) other);
        return (((((((this.custInfo == rhs.custInfo)||((this.custInfo!= null)&&this.custInfo.equals(rhs.custInfo)))&&((this.acctInfo == rhs.acctInfo)||((this.acctInfo!= null)&&this.acctInfo.equals(rhs.acctInfo))))&&((this.primaryUserContact == rhs.primaryUserContact)||((this.primaryUserContact!= null)&&this.primaryUserContact.equals(rhs.primaryUserContact))))&&((this.cardHolder == rhs.cardHolder)||((this.cardHolder!= null)&&this.cardHolder.equals(rhs.cardHolder))))&&((this.primaryCardHolder == rhs.primaryCardHolder)||((this.primaryCardHolder!= null)&&this.primaryCardHolder.equals(rhs.primaryCardHolder))))&&((this.otherCardHolders == rhs.otherCardHolders)||((this.otherCardHolders!= null)&&this.otherCardHolders.equals(rhs.otherCardHolders))));
    }

}
