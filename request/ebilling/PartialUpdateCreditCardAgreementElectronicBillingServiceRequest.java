package com.td.api.mbcca.request.ebilling;

public class PartialUpdateCreditCardAgreementElectronicBillingServiceRequest {

    private Boolean deactivationInd;
    private Integer statementCycleCnt;

    public Boolean getDeactivationInd() {
        return deactivationInd;
    }

    public void setDeactivationInd(Boolean deactivationInd) {
        this.deactivationInd = deactivationInd;
    }

    public Integer getStatementCycleCnt() {
        return statementCycleCnt;
    }

    public void setStatementCycleCnt(Integer statementCycleCnt) {
        this.statementCycleCnt = statementCycleCnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PartialUpdateCreditCardAgreementElectronicBillingServiceRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("deactivationInd");
        sb.append('=');
        sb.append(((this.deactivationInd == null)?"<null>":this.deactivationInd));
        sb.append(',');
        sb.append("statementCycleCnt");
        sb.append('=');
        sb.append(((this.statementCycleCnt == null)?"<null>":this.statementCycleCnt));
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
        result = ((result* 31)+((this.statementCycleCnt == null)? 0 :this.statementCycleCnt.hashCode()));
        result = ((result* 31)+((this.deactivationInd == null)? 0 :this.deactivationInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PartialUpdateCreditCardAgreementElectronicBillingServiceRequest) == false) {
            return false;
        }
        PartialUpdateCreditCardAgreementElectronicBillingServiceRequest rhs = ((PartialUpdateCreditCardAgreementElectronicBillingServiceRequest) other);
        return (((this.statementCycleCnt == rhs.statementCycleCnt)||((this.statementCycleCnt!= null)&&this.statementCycleCnt.equals(rhs.statementCycleCnt)))&&((this.deactivationInd == rhs.deactivationInd)||((this.deactivationInd!= null)&&this.deactivationInd.equals(rhs.deactivationInd))));
    }

}
