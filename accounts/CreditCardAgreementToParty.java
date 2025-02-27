package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.List;

public class CreditCardAgreementToParty {

    private String key;
    private String typeCd;
    private List<Role> role = new ArrayList<Role>();
    private String fullName;
    private List<Contact> contact = new ArrayList<Contact>();
    private String languageCd;
    private TsysExtension tsysExtension;
    private FdrExtension fdrExtension;
    private String nameTypeCd;
    private String statusCd;
    private String onCardName;
    private PartyToTransferEvent partyToTransferEvent;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public String getLanguageCd() {
        return languageCd;
    }

    public void setLanguageCd(String languageCd) {
        this.languageCd = languageCd;
    }

    public TsysExtension getTsysExtension() {
        return tsysExtension;
    }

    public void setTsysExtension(TsysExtension tsysExtension) {
        this.tsysExtension = tsysExtension;
    }

    public FdrExtension getFdrExtension() {
        return fdrExtension;
    }

    public void setFdrExtension(FdrExtension fdrExtension) {
        this.fdrExtension = fdrExtension;
    }

    public String getNameTypeCd() {
        return nameTypeCd;
    }

    public void setNameTypeCd(String nameTypeCd) {
        this.nameTypeCd = nameTypeCd;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getOnCardName() {
        return onCardName;
    }

    public void setOnCardName(String onCardName) {
        this.onCardName = onCardName;
    }

    public PartyToTransferEvent getPartyToTransferEvent() {
        return partyToTransferEvent;
    }

    public void setPartyToTransferEvent(PartyToTransferEvent partyToTransferEvent) {
        this.partyToTransferEvent = partyToTransferEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreditCardAgreementToParty.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
        sb.append(',');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("role");
        sb.append('=');
        sb.append(((this.role == null)?"<null>":this.role));
        sb.append(',');
        sb.append("fullName");
        sb.append('=');
        sb.append(((this.fullName == null)?"<null>":this.fullName));
        sb.append(',');
        sb.append("contact");
        sb.append('=');
        sb.append(((this.contact == null)?"<null>":this.contact));
        sb.append(',');
        sb.append("languageCd");
        sb.append('=');
        sb.append(((this.languageCd == null)?"<null>":this.languageCd));
        sb.append(',');
        sb.append("tsysExtension");
        sb.append('=');
        sb.append(((this.tsysExtension == null)?"<null>":this.tsysExtension));
        sb.append(',');
        sb.append("fdrExtension");
        sb.append('=');
        sb.append(((this.fdrExtension == null)?"<null>":this.fdrExtension));
        sb.append(',');
        sb.append("nameTypeCd");
        sb.append('=');
        sb.append(((this.nameTypeCd == null)?"<null>":this.nameTypeCd));
        sb.append(',');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
        sb.append(',');
        sb.append("onCardName");
        sb.append('=');
        sb.append(((this.onCardName == null)?"<null>":this.onCardName));
        sb.append(',');
        sb.append("partyToTransferEvent");
        sb.append('=');
        sb.append(((this.partyToTransferEvent == null)?"<null>":this.partyToTransferEvent));
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
        result = ((result* 31)+((this.nameTypeCd == null)? 0 :this.nameTypeCd.hashCode()));
        result = ((result* 31)+((this.partyToTransferEvent == null)? 0 :this.partyToTransferEvent.hashCode()));
        result = ((result* 31)+((this.languageCd == null)? 0 :this.languageCd.hashCode()));
        result = ((result* 31)+((this.role == null)? 0 :this.role.hashCode()));
        result = ((result* 31)+((this.onCardName == null)? 0 :this.onCardName.hashCode()));
        result = ((result* 31)+((this.fullName == null)? 0 :this.fullName.hashCode()));
        result = ((result* 31)+((this.fdrExtension == null)? 0 :this.fdrExtension.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.contact == null)? 0 :this.contact.hashCode()));
        result = ((result* 31)+((this.tsysExtension == null)? 0 :this.tsysExtension.hashCode()));
        result = ((result* 31)+((this.key == null)? 0 :this.key.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditCardAgreementToParty) == false) {
            return false;
        }
        CreditCardAgreementToParty rhs = ((CreditCardAgreementToParty) other);
        return (((((((((((((this.nameTypeCd == rhs.nameTypeCd)||((this.nameTypeCd!= null)&&this.nameTypeCd.equals(rhs.nameTypeCd)))&&((this.partyToTransferEvent == rhs.partyToTransferEvent)||((this.partyToTransferEvent!= null)&&this.partyToTransferEvent.equals(rhs.partyToTransferEvent))))&&((this.languageCd == rhs.languageCd)||((this.languageCd!= null)&&this.languageCd.equals(rhs.languageCd))))&&((this.role == rhs.role)||((this.role!= null)&&this.role.equals(rhs.role))))&&((this.onCardName == rhs.onCardName)||((this.onCardName!= null)&&this.onCardName.equals(rhs.onCardName))))&&((this.fullName == rhs.fullName)||((this.fullName!= null)&&this.fullName.equals(rhs.fullName))))&&((this.fdrExtension == rhs.fdrExtension)||((this.fdrExtension!= null)&&this.fdrExtension.equals(rhs.fdrExtension))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.contact == rhs.contact)||((this.contact!= null)&&this.contact.equals(rhs.contact))))&&((this.tsysExtension == rhs.tsysExtension)||((this.tsysExtension!= null)&&this.tsysExtension.equals(rhs.tsysExtension))))&&((this.key == rhs.key)||((this.key!= null)&&this.key.equals(rhs.key))));
    }

}
