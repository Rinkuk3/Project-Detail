package com.td.api.mbofp.request.installmentplan;

public class Agreement {

    private String hostAgreementNum;
    private AgreementToCard agreementToCard;
    private AgreementToDocument agreementToDocument;

    public String getHostAgreementNum() {
        return hostAgreementNum;
    }

    public void setHostAgreementNum(String hostAgreementNum) {
        this.hostAgreementNum = hostAgreementNum;
    }

    public AgreementToCard getAgreementToCard() {
        return agreementToCard;
    }

    public void setAgreementToCard(AgreementToCard agreementToCard) {
        this.agreementToCard = agreementToCard;
    }

    public AgreementToDocument getAgreementToDocument() {
        return agreementToDocument;
    }

    public void setAgreementToDocument(AgreementToDocument agreementToDocument) {
        this.agreementToDocument = agreementToDocument;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Agreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("hostAgreementNum");
        sb.append('=');
        sb.append(((this.hostAgreementNum == null)?"<null>":this.hostAgreementNum));
        sb.append(',');
        sb.append("agreementToCard");
        sb.append('=');
        sb.append(((this.agreementToCard == null)?"<null>":this.agreementToCard));
        sb.append(',');
        sb.append("agreementToDocument");
        sb.append('=');
        sb.append(((this.agreementToDocument == null)?"<null>":this.agreementToDocument));
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
        result = ((result* 31)+((this.hostAgreementNum == null)? 0 :this.hostAgreementNum.hashCode()));
        result = ((result* 31)+((this.agreementToCard == null)? 0 :this.agreementToCard.hashCode()));
        result = ((result* 31)+((this.agreementToDocument == null)? 0 :this.agreementToDocument.hashCode()));
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
        return ((((this.hostAgreementNum == rhs.hostAgreementNum)||((this.hostAgreementNum!= null)&&this.hostAgreementNum.equals(rhs.hostAgreementNum)))&&((this.agreementToCard == rhs.agreementToCard)||((this.agreementToCard!= null)&&this.agreementToCard.equals(rhs.agreementToCard))))&&((this.agreementToDocument == rhs.agreementToDocument)||((this.agreementToDocument!= null)&&this.agreementToDocument.equals(rhs.agreementToDocument))));
    }

}
