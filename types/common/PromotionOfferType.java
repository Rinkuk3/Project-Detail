package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class PromotionOfferType implements Serializable {

	private static final long serialVersionUID = -2163135040485749855L;
    private String offerID;
    private String offerType;
    private String offerDescription;
    private String agreementFeature;
    private String subProductId;
    private String subProductType;
    private String subProductDescription;
    private String disposition;
    private Boolean isEligible;
    private Integer priority;
    private CLIOfferType cliOffer;
    private BTOfferType btOffer;
    private IPOfferType ipOffer;
    private PCOfferType pcOffer;
    private CAOfferType caOffer;
    private ROfferType roffer;

    public String getOfferID() {
        return offerID;
    }

    public void setOfferID(String offerID) {
        this.offerID = offerID;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public String getAgreementFeature() {
        return agreementFeature;
    }

    public void setAgreementFeature(String agreementFeature) {
        this.agreementFeature = agreementFeature;
    }

    public String getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(String subProductId) {
        this.subProductId = subProductId;
    }

    public String getSubProductType() {
        return subProductType;
    }

    public void setSubProductType(String subProductType) {
        this.subProductType = subProductType;
    }

    public String getSubProductDescription() {
        return subProductDescription;
    }

    public void setSubProductDescription(String subProductDescription) {
        this.subProductDescription = subProductDescription;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public Boolean getIsEligible() {
    	if (isEligible == null)
    		return true;
        return isEligible;
    }

    public void setIsEligible(Boolean isEligible) {
        this.isEligible = isEligible;
    }

    public Integer getPriority() {
    	if (this.priority == null)
    		return new Integer(0);
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public CLIOfferType getCliOffer() {
        return cliOffer;
    }

    public void setCliOffer(CLIOfferType cliOffer) {
        this.cliOffer = cliOffer;
    }

    public BTOfferType getBtOffer() {
        return btOffer;
    }

    public void setBtOffer(BTOfferType btOffer) {
        this.btOffer = btOffer;
    }

    public IPOfferType getIpOffer() {
    	return ipOffer;
    }
    
    public void setIpOffer(IPOfferType ipOffer) {
    	this.ipOffer = ipOffer;
    }
    
    public PCOfferType getPcOffer() {
        return pcOffer;
    }

    public void setPcOffer(PCOfferType pcOffer) {
        this.pcOffer = pcOffer;
    }

    public CAOfferType getCaOffer() {
        return caOffer;
    }

    public void setCaOffer(CAOfferType caOffer) {
        this.caOffer = caOffer;
    }

    public ROfferType getRoffer() {
        return roffer;
    }

    public void setRoffer(ROfferType roffer) {
        this.roffer = roffer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PromotionOfferType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offerID");
        sb.append('=');
        sb.append(((this.offerID == null)?"<null>":this.offerID));
        sb.append(',');
        sb.append("offerType");
        sb.append('=');
        sb.append(((this.offerType == null)?"<null>":this.offerType));
        sb.append(',');
        sb.append("offerDescription");
        sb.append('=');
        sb.append(((this.offerDescription == null)?"<null>":this.offerDescription));
        sb.append(',');
        sb.append("agreementFeature");
        sb.append('=');
        sb.append(((this.agreementFeature == null)?"<null>":this.agreementFeature));
        sb.append(',');
        sb.append("subProductId");
        sb.append('=');
        sb.append(((this.subProductId == null)?"<null>":this.subProductId));
        sb.append(',');
        sb.append("subProductType");
        sb.append('=');
        sb.append(((this.subProductType == null)?"<null>":this.subProductType));
        sb.append(',');
        sb.append("subProductDescription");
        sb.append('=');
        sb.append(((this.subProductDescription == null)?"<null>":this.subProductDescription));
        sb.append(',');
        sb.append("disposition");
        sb.append('=');
        sb.append(((this.disposition == null)?"<null>":this.disposition));
        sb.append(',');
        sb.append("isEligible");
        sb.append('=');
        sb.append(((this.isEligible == null)?"<null>":this.isEligible));
        sb.append(',');
        sb.append("priority");
        sb.append('=');
        sb.append(((this.priority == null)?"<null>":this.priority));
        sb.append(',');
        sb.append("cliOffer");
        sb.append('=');
        sb.append(((this.cliOffer == null)?"<null>":this.cliOffer));
        sb.append(',');
        sb.append("btOffer");
        sb.append('=');
        sb.append(((this.btOffer == null)?"<null>":this.btOffer));
        sb.append(',');
        sb.append("ipOffer");
        sb.append('=');
        sb.append(((this.ipOffer == null)?"<null>":this.ipOffer));
        sb.append(',');
        sb.append("pcOffer");
        sb.append('=');
        sb.append(((this.pcOffer == null)?"<null>":this.pcOffer));
        sb.append(',');
        sb.append("caOffer");
        sb.append('=');
        sb.append(((this.caOffer == null)?"<null>":this.caOffer));
        sb.append(',');
        sb.append("roffer");
        sb.append('=');
        sb.append(((this.roffer == null)?"<null>":this.roffer));
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
        result = ((result* 31)+((this.caOffer == null)? 0 :this.caOffer.hashCode()));
        result = ((result* 31)+((this.priority == null)? 0 :this.priority.hashCode()));
        result = ((result* 31)+((this.subProductType == null)? 0 :this.subProductType.hashCode()));
        result = ((result* 31)+((this.subProductDescription == null)? 0 :this.subProductDescription.hashCode()));
        result = ((result* 31)+((this.offerType == null)? 0 :this.offerType.hashCode()));
        result = ((result* 31)+((this.agreementFeature == null)? 0 :this.agreementFeature.hashCode()));
        result = ((result* 31)+((this.disposition == null)? 0 :this.disposition.hashCode()));
        result = ((result* 31)+((this.btOffer == null)? 0 :this.btOffer.hashCode()));
        result = ((result* 31)+((this.ipOffer == null)? 0 :this.ipOffer.hashCode()));
        result = ((result* 31)+((this.offerDescription == null)? 0 :this.offerDescription.hashCode()));
        result = ((result* 31)+((this.cliOffer == null)? 0 :this.cliOffer.hashCode()));
        result = ((result* 31)+((this.offerID == null)? 0 :this.offerID.hashCode()));
        result = ((result* 31)+((this.isEligible == null)? 0 :this.isEligible.hashCode()));
        result = ((result* 31)+((this.subProductId == null)? 0 :this.subProductId.hashCode()));
        result = ((result* 31)+((this.pcOffer == null)? 0 :this.pcOffer.hashCode()));
        result = ((result* 31)+((this.roffer == null)? 0 :this.roffer.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PromotionOfferType) == false) {
            return false;
        }
        PromotionOfferType rhs = ((PromotionOfferType) other);
        return (((((((((((((((((this.caOffer == rhs.caOffer)||((this.caOffer!= null)&&this.caOffer.equals(rhs.caOffer)))&&((this.priority == rhs.priority)||((this.priority!= null)&&this.priority.equals(rhs.priority))))&&((this.subProductType == rhs.subProductType)||((this.subProductType!= null)&&this.subProductType.equals(rhs.subProductType))))&&((this.subProductDescription == rhs.subProductDescription)||((this.subProductDescription!= null)&&this.subProductDescription.equals(rhs.subProductDescription))))&&((this.offerType == rhs.offerType)||((this.offerType!= null)&&this.offerType.equals(rhs.offerType))))&&((this.agreementFeature == rhs.agreementFeature)||((this.agreementFeature!= null)&&this.agreementFeature.equals(rhs.agreementFeature))))&&((this.disposition == rhs.disposition)||((this.disposition!= null)&&this.disposition.equals(rhs.disposition))))&&((this.btOffer == rhs.btOffer)||((this.btOffer!= null)&&this.btOffer.equals(rhs.btOffer))))&&((this.offerDescription == rhs.offerDescription)||((this.offerDescription!= null)&&this.offerDescription.equals(rhs.offerDescription))))&&((this.cliOffer == rhs.cliOffer)||((this.cliOffer!= null)&&this.cliOffer.equals(rhs.cliOffer))))&&((this.offerID == rhs.offerID)||((this.offerID!= null)&&this.offerID.equals(rhs.offerID))))&&((this.isEligible == rhs.isEligible)||((this.isEligible!= null)&&this.isEligible.equals(rhs.isEligible))))&&((this.subProductId == rhs.subProductId)||((this.subProductId!= null)&&this.subProductId.equals(rhs.subProductId))))&&((this.pcOffer == rhs.pcOffer)||((this.pcOffer!= null)&&this.pcOffer.equals(rhs.pcOffer))))&&((this.roffer == rhs.roffer)||((this.roffer!= null)&&this.roffer.equals(rhs.roffer))))&&((this.ipOffer == rhs.ipOffer)||((this.ipOffer!= null)&&this.ipOffer.equals(rhs.ipOffer))));
    }

}
