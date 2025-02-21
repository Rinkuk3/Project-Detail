package com.td.api.mbcca.response.account;

public class TsysExtension__5 {

    private String fullFICOReasonDesc;

    public String getFullFICOReasonDesc() {
        return fullFICOReasonDesc;
    }

    public void setFullFICOReasonDesc(String fullFICOReasonDesc) {
        this.fullFICOReasonDesc = fullFICOReasonDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TsysExtension__5 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("fullFICOReasonDesc");
        sb.append('=');
        sb.append(((this.fullFICOReasonDesc == null)?"<null>":this.fullFICOReasonDesc));
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
        result = ((result* 31)+((this.fullFICOReasonDesc == null)? 0 :this.fullFICOReasonDesc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TsysExtension__5) == false) {
            return false;
        }
        TsysExtension__5 rhs = ((TsysExtension__5) other);
        return ((this.fullFICOReasonDesc == rhs.fullFICOReasonDesc)||((this.fullFICOReasonDesc!= null)&&this.fullFICOReasonDesc.equals(rhs.fullFICOReasonDesc)));
    }

}
