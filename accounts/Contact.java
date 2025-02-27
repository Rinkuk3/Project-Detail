package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String usageCd;
    private List<Locator> locator = new ArrayList<Locator>();
    private String privacyPreferenceConsentCd;

    public String getUsageCd() {
        return usageCd;
    }

    public void setUsageCd(String usageCd) {
        this.usageCd = usageCd;
    }

    public List<Locator> getLocator() {
        return locator;
    }

    public void setLocator(List<Locator> locator) {
        this.locator = locator;
    }

    public String getPrivacyPreferenceConsentCd() {
        return privacyPreferenceConsentCd;
    }

    public void setPrivacyPreferenceConsentCd(String privacyPreferenceConsentCd) {
        this.privacyPreferenceConsentCd = privacyPreferenceConsentCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Contact.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("usageCd");
        sb.append('=');
        sb.append(((this.usageCd == null)?"<null>":this.usageCd));
        sb.append(',');
        sb.append("locator");
        sb.append('=');
        sb.append(((this.locator == null)?"<null>":this.locator));
        sb.append(',');
        sb.append("privacyPreferenceConsentCd");
        sb.append('=');
        sb.append(((this.privacyPreferenceConsentCd == null)?"<null>":this.privacyPreferenceConsentCd));
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
        result = ((result* 31)+((this.locator == null)? 0 :this.locator.hashCode()));
        result = ((result* 31)+((this.usageCd == null)? 0 :this.usageCd.hashCode()));
        result = ((result* 31)+((this.privacyPreferenceConsentCd == null)? 0 :this.privacyPreferenceConsentCd.hashCode()));
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
        return ((((this.locator == rhs.locator)||((this.locator!= null)&&this.locator.equals(rhs.locator)))&&((this.usageCd == rhs.usageCd)||((this.usageCd!= null)&&this.usageCd.equals(rhs.usageCd))))&&((this.privacyPreferenceConsentCd == rhs.privacyPreferenceConsentCd)||((this.privacyPreferenceConsentCd!= null)&&this.privacyPreferenceConsentCd.equals(rhs.privacyPreferenceConsentCd))));
    }

}
