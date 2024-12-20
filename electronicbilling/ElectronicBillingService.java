package com.td.api.mbcca.response.account.electronicbilling;

public class ElectronicBillingService {

    private String enrolledDt;
    private String lastMaintenanceDt;
    private String enrolmentStatusCd;
    private Integer statementCycleCnt;
    private String statementFormatVal;

    public String getEnrolledDt() {
        return enrolledDt;
    }

    public void setEnrolledDt(String enrolledDt) {
        this.enrolledDt = enrolledDt;
    }

    public String getLastMaintenanceDt() {
        return lastMaintenanceDt;
    }

    public void setLastMaintenanceDt(String lastMaintenanceDt) {
        this.lastMaintenanceDt = lastMaintenanceDt;
    }

    public String getEnrolmentStatusCd() {
        return enrolmentStatusCd;
    }

    public void setEnrolmentStatusCd(String enrolmentStatusCd) {
        this.enrolmentStatusCd = enrolmentStatusCd;
    }

    public Integer getStatementCycleCnt() {
        return statementCycleCnt;
    }

    public void setStatementCycleCnt(Integer statementCycleCnt) {
        this.statementCycleCnt = statementCycleCnt;
    }

    public String getStatementFormatVal() {
        return statementFormatVal;
    }

    public void setStatementFormatVal(String statementFormatVal) {
        this.statementFormatVal = statementFormatVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ElectronicBillingService.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("enrolledDt");
        sb.append('=');
        sb.append(((this.enrolledDt == null)?"<null>":this.enrolledDt));
        sb.append(',');
        sb.append("lastMaintenanceDt");
        sb.append('=');
        sb.append(((this.lastMaintenanceDt == null)?"<null>":this.lastMaintenanceDt));
        sb.append(',');
        sb.append("enrolmentStatusCd");
        sb.append('=');
        sb.append(((this.enrolmentStatusCd == null)?"<null>":this.enrolmentStatusCd));
        sb.append(',');
        sb.append("statementCycleCnt");
        sb.append('=');
        sb.append(((this.statementCycleCnt == null)?"<null>":this.statementCycleCnt));
        sb.append(',');
        sb.append("statementFormatVal");
        sb.append('=');
        sb.append(((this.statementFormatVal == null)?"<null>":this.statementFormatVal));
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
        result = ((result* 31)+((this.statementFormatVal == null)? 0 :this.statementFormatVal.hashCode()));
        result = ((result* 31)+((this.lastMaintenanceDt == null)? 0 :this.lastMaintenanceDt.hashCode()));
        result = ((result* 31)+((this.statementCycleCnt == null)? 0 :this.statementCycleCnt.hashCode()));
        result = ((result* 31)+((this.enrolledDt == null)? 0 :this.enrolledDt.hashCode()));
        result = ((result* 31)+((this.enrolmentStatusCd == null)? 0 :this.enrolmentStatusCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ElectronicBillingService) == false) {
            return false;
        }
        ElectronicBillingService rhs = ((ElectronicBillingService) other);
        return ((((((this.statementFormatVal == rhs.statementFormatVal)||((this.statementFormatVal!= null)&&this.statementFormatVal.equals(rhs.statementFormatVal)))&&((this.lastMaintenanceDt == rhs.lastMaintenanceDt)||((this.lastMaintenanceDt!= null)&&this.lastMaintenanceDt.equals(rhs.lastMaintenanceDt))))&&((this.statementCycleCnt == rhs.statementCycleCnt)||((this.statementCycleCnt!= null)&&this.statementCycleCnt.equals(rhs.statementCycleCnt))))&&((this.enrolledDt == rhs.enrolledDt)||((this.enrolledDt!= null)&&this.enrolledDt.equals(rhs.enrolledDt))))&&((this.enrolmentStatusCd == rhs.enrolmentStatusCd)||((this.enrolmentStatusCd!= null)&&this.enrolmentStatusCd.equals(rhs.enrolmentStatusCd))));
    }

}
