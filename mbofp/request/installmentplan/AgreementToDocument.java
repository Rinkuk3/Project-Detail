package com.td.api.mbofp.request.installmentplan;

public class AgreementToDocument {

    private String statementDataDt;

    public String getStatementDataDt() {
        return statementDataDt;
    }

    public void setStatementDataDt(String statementDataDt) {
        this.statementDataDt = statementDataDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgreementToDocument.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("statementDataDt");
        sb.append('=');
        sb.append(((this.statementDataDt == null)?"<null>":this.statementDataDt));
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
        result = ((result* 31)+((this.statementDataDt == null)? 0 :this.statementDataDt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementToDocument) == false) {
            return false;
        }
        AgreementToDocument rhs = ((AgreementToDocument) other);
        return ((this.statementDataDt == rhs.statementDataDt)||((this.statementDataDt!= null)&&this.statementDataDt.equals(rhs.statementDataDt)));
    }

}
