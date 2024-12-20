package com.td.api.mbcca.response.account;

public class Reason {

    private String reasonCd;
    private String reasonDesc;
    private TsysExtension__5 tsysExtension;

    public String getReasonCd() {
        return reasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }

    public TsysExtension__5 getTsysExtension() {
        return tsysExtension;
    }

    public void setTsysExtension(TsysExtension__5 tsysExtension) {
        this.tsysExtension = tsysExtension;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reason.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("reasonCd");
        sb.append('=');
        sb.append(((this.reasonCd == null)?"<null>":this.reasonCd));
        sb.append(',');
        sb.append("reasonDesc");
        sb.append('=');
        sb.append(((this.reasonDesc == null)?"<null>":this.reasonDesc));
        sb.append(',');
        sb.append("tsysExtension");
        sb.append('=');
        sb.append(((this.tsysExtension == null)?"<null>":this.tsysExtension));
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
        result = ((result* 31)+((this.reasonDesc == null)? 0 :this.reasonDesc.hashCode()));
        result = ((result* 31)+((this.reasonCd == null)? 0 :this.reasonCd.hashCode()));
        result = ((result* 31)+((this.tsysExtension == null)? 0 :this.tsysExtension.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Reason) == false) {
            return false;
        }
        Reason rhs = ((Reason) other);
        return ((((this.reasonDesc == rhs.reasonDesc)||((this.reasonDesc!= null)&&this.reasonDesc.equals(rhs.reasonDesc)))&&((this.reasonCd == rhs.reasonCd)||((this.reasonCd!= null)&&this.reasonCd.equals(rhs.reasonCd))))&&((this.tsysExtension == rhs.tsysExtension)||((this.tsysExtension!= null)&&this.tsysExtension.equals(rhs.tsysExtension))));
    }

}
