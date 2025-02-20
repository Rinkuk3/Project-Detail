package com.td.api.mbofp.response.retrievecampaign;

public class PlasticEmbossing {

    private String brandLevelCd;

    public String getBrandLevelCd() {
        return brandLevelCd;
    }

    public void setBrandLevelCd(String brandLevelCd) {
        this.brandLevelCd = brandLevelCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PlasticEmbossing.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("brandLevelCd");
        sb.append('=');
        sb.append(((this.brandLevelCd == null)?"<null>":this.brandLevelCd));
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
        result = ((result* 31)+((this.brandLevelCd == null)? 0 :this.brandLevelCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlasticEmbossing) == false) {
            return false;
        }
        PlasticEmbossing rhs = ((PlasticEmbossing) other);
        return ((this.brandLevelCd == rhs.brandLevelCd)||((this.brandLevelCd!= null)&&this.brandLevelCd.equals(rhs.brandLevelCd)));
    }

}
