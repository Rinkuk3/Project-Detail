package com.td.mbna.msec.midtier.customerprofile.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.CardHolderType;
import com.td.mbna.msec.midtier.types.common.CustAcctType;

public class CustomerAcctType extends CustAcctType implements Serializable {

	private static final long serialVersionUID = -1825501201207316196L;
    private CardHolderType primaryCardHolder;
    private List<CardHolderType> otherCardHolders = new ArrayList<>();
    private CustomerAcctInfoType cardHolderAcctInfo;
    private CustomerAcctProfileType pchAcctProfile;
    private List<CustomerAcctProfileType> otherAcctProfiles = new ArrayList<>();

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

    public CustomerAcctInfoType getCardHolderAcctInfo() {
        return cardHolderAcctInfo;
    }

    public void setCardHolderAcctInfo(CustomerAcctInfoType cardHolderAcctInfo) {
        this.cardHolderAcctInfo = cardHolderAcctInfo;
    }

    public CustomerAcctProfileType getPchAcctProfile() {
        return pchAcctProfile;
    }

    public void setPchAcctProfile(CustomerAcctProfileType pchAcctProfile) {
        this.pchAcctProfile = pchAcctProfile;
    }

    public List<CustomerAcctProfileType> getOtherAcctProfiles() {
        return otherAcctProfiles;
    }

    public void setOtherAcctProfiles(List<CustomerAcctProfileType> otherAcctProfiles) {
        this.otherAcctProfiles = otherAcctProfiles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomerAcctType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append(super.toString());
        sb.append(',');
        sb.append("primaryCardHolder");
        sb.append('=');
        sb.append(((this.primaryCardHolder == null)?"<null>":this.primaryCardHolder));
        sb.append(',');
        sb.append("otherCardHolders");
        sb.append('=');
        sb.append(((this.otherCardHolders == null)?"<null>":this.otherCardHolders));
        sb.append(',');
        sb.append("cardHolderAcctInfo");
        sb.append('=');
        sb.append(((this.cardHolderAcctInfo == null)?"<null>":this.cardHolderAcctInfo));
        sb.append(',');
        sb.append("pchAcctProfile");
        sb.append('=');
        sb.append(((this.pchAcctProfile == null)?"<null>":this.pchAcctProfile));
        sb.append(',');
        sb.append("otherAcctProfiles");
        sb.append('=');
        sb.append(((this.otherAcctProfiles == null)?"<null>":this.otherAcctProfiles));
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
        result = (result * 31) + super.hashCode();
        result = ((result* 31)+((this.otherAcctProfiles == null)? 0 :this.otherAcctProfiles.hashCode()));
        result = ((result* 31)+((this.primaryCardHolder == null)? 0 :this.primaryCardHolder.hashCode()));
        result = ((result* 31)+((this.cardHolderAcctInfo == null)? 0 :this.cardHolderAcctInfo.hashCode()));
        result = ((result* 31)+((this.otherCardHolders == null)? 0 :this.otherCardHolders.hashCode()));
        result = ((result* 31)+((this.pchAcctProfile == null)? 0 :this.pchAcctProfile.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerAcctType) == false) {
            return false;
        }
        CustomerAcctType rhs = ((CustomerAcctType) other);
        return  super.equals(other)
                &&((this.otherAcctProfiles == rhs.otherAcctProfiles)||((this.otherAcctProfiles!= null)&&this.otherAcctProfiles.equals(rhs.otherAcctProfiles)))
                &&((this.primaryCardHolder == rhs.primaryCardHolder)||((this.primaryCardHolder!= null)&&this.primaryCardHolder.equals(rhs.primaryCardHolder)))
                &&((this.cardHolderAcctInfo == rhs.cardHolderAcctInfo)||((this.cardHolderAcctInfo!= null)&&this.cardHolderAcctInfo.equals(rhs.cardHolderAcctInfo)))
                &&((this.otherCardHolders == rhs.otherCardHolders)||((this.otherCardHolders!= null)&&this.otherCardHolders.equals(rhs.otherCardHolders)))
                &&((this.pchAcctProfile == rhs.pchAcctProfile)||((this.pchAcctProfile!= null)&&this.pchAcctProfile.equals(rhs.pchAcctProfile)));
    }

}
