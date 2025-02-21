package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.MasterCard;
import com.td.api.mbcca.shared.Visa;

public class TsysExtension__3 {

    private Visa visa;
    private MasterCard masterCard;

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    public MasterCard getMasterCard() {
        return masterCard;
    }

    public void setMasterCard(MasterCard masterCard) {
        this.masterCard = masterCard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TsysExtension__3 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("visa");
        sb.append('=');
        sb.append(((this.visa == null)?"<null>":this.visa));
        sb.append(',');
        sb.append("masterCard");
        sb.append('=');
        sb.append(((this.masterCard == null)?"<null>":this.masterCard));
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
        result = ((result* 31)+((this.visa == null)? 0 :this.visa.hashCode()));
        result = ((result* 31)+((this.masterCard == null)? 0 :this.masterCard.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TsysExtension__3) == false) {
            return false;
        }
        TsysExtension__3 rhs = ((TsysExtension__3) other);
        return (((this.visa == rhs.visa)||((this.visa!= null)&&this.visa.equals(rhs.visa)))&&((this.masterCard == rhs.masterCard)||((this.masterCard!= null)&&this.masterCard.equals(rhs.masterCard))));
    }

}
