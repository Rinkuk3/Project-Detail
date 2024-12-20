
package com.td.api.mbcapd.response.retrievecapd;

import java.util.ArrayList;
import java.util.List;
public class Contact {

    private String addressSubtypeCd;
    private String addressVal;
    private List<AlertBlocklistSetup> alertBlocklistSetup = new ArrayList<AlertBlocklistSetup>();

    public String getAddressSubtypeCd() {
		return addressSubtypeCd;
	}

	public void setAddressSubtypeCd(String addressSubtypeCd) {
		this.addressSubtypeCd = addressSubtypeCd;
	}

	public String getAddressVal() {
		return addressVal;
	}

	public void setAddressVal(String addressVal) {
		this.addressVal = addressVal;
	}

	public List<AlertBlocklistSetup> getAlertBlocklistSetup() {
		return alertBlocklistSetup;
	}

	public void setAlertBlocklistSetup(List<AlertBlocklistSetup> alertBlocklistSetup) {
		this.alertBlocklistSetup = alertBlocklistSetup;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Contact.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("addressSubtypeCd");
        sb.append('=');
        sb.append(((this.addressSubtypeCd == null)?"<null>":this.addressSubtypeCd));
        sb.append(',');
        sb.append("addressVal");
        sb.append('=');
        sb.append(((this.addressVal == null)?"<null>":this.addressVal));
        sb.append(',');
        sb.append("alertBlocklistSetup");
        sb.append('=');
        sb.append(((this.alertBlocklistSetup == null)?"<null>":this.alertBlocklistSetup));
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
        result = ((result* 31)+((this.addressVal == null)? 0 :this.addressVal.hashCode()));
        result = ((result* 31)+((this.addressSubtypeCd == null)? 0 :this.addressSubtypeCd.hashCode()));
        result = ((result* 31)+((this.alertBlocklistSetup == null)? 0 :this.alertBlocklistSetup.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Contact) == false) {
            return false;
        }
        Contact rhs = ((Contact) other);
        return ((((this.addressVal == rhs.addressVal)||((this.addressVal!= null)&&this.addressVal.equals(rhs.addressVal)))&&((this.addressSubtypeCd == rhs.addressSubtypeCd)||((this.addressSubtypeCd!= null)&&this.addressSubtypeCd.equals(rhs.addressSubtypeCd))))&&((this.alertBlocklistSetup == rhs.alertBlocklistSetup)||((this.alertBlocklistSetup!= null)&&this.alertBlocklistSetup.equals(rhs.alertBlocklistSetup))));
    }

}
