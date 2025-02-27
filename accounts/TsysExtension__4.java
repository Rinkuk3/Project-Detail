package com.td.api.mbcca.response.account;

public class TsysExtension__4 {

    private Boolean clearingSweepInd;

    public Boolean getClearingSweepInd() {
        return clearingSweepInd;
    }

    public void setClearingSweepInd(Boolean clearingSweepInd) {
        this.clearingSweepInd = clearingSweepInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TsysExtension__4 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("clearingSweepInd");
        sb.append('=');
        sb.append(((this.clearingSweepInd == null)?"<null>":this.clearingSweepInd));
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
        result = ((result* 31)+((this.clearingSweepInd == null)? 0 :this.clearingSweepInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TsysExtension__4) == false) {
            return false;
        }
        TsysExtension__4 rhs = ((TsysExtension__4) other);
        return ((this.clearingSweepInd == rhs.clearingSweepInd)||((this.clearingSweepInd!= null)&&this.clearingSweepInd.equals(rhs.clearingSweepInd)));
    }

}
