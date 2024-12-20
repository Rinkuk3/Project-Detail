package com.td.api.mbcca.request.cancelip;

import java.util.Date;

public class PostedEventAltkey {

    private String statementDataDt;
    private Date postedDttm;

    public String getStatementDataDt() {
        return statementDataDt;
    }

    public void setStatementDataDt(String statementDataDt) {
        this.statementDataDt = statementDataDt;
    }

    public Date getPostedDttm() {
        return postedDttm;
    }

    public void setPostedDttm(Date postedDttm) {
        this.postedDttm = postedDttm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PostedEventAltkey.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("statementDataDt");
        sb.append('=');
        sb.append(((this.statementDataDt == null)?"<null>":this.statementDataDt));
        sb.append(',');
        sb.append("postedDttm");
        sb.append('=');
        sb.append(((this.postedDttm == null)?"<null>":this.postedDttm));
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
        result = ((result* 31)+((this.postedDttm == null)? 0 :this.postedDttm.hashCode()));
        result = ((result* 31)+((this.statementDataDt == null)? 0 :this.statementDataDt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PostedEventAltkey) == false) {
            return false;
        }
        PostedEventAltkey rhs = ((PostedEventAltkey) other);
        return (((this.postedDttm == rhs.postedDttm)||((this.postedDttm!= null)&&this.postedDttm.equals(rhs.postedDttm)))&&((this.statementDataDt == rhs.statementDataDt)||((this.statementDataDt!= null)&&this.statementDataDt.equals(rhs.statementDataDt))));
    }

}
