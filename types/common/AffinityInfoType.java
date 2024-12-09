package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class AffinityInfoType implements Serializable {

	private static final long serialVersionUID = 2056047298517732727L;
    private Boolean failed;
    private String affinityCode;
    private String productCodes;
    private AffinityInfoTypeLanguageSpecific englishInfo;
    private AffinityInfoTypeLanguageSpecific frenchInfo;

    public Boolean getFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
    }

    public String getAffinityCode() {
        return affinityCode;
    }

    public void setAffinityCode(String affinityCode) {
        this.affinityCode = affinityCode;
    }

    public String getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(String productCodes) {
        this.productCodes = productCodes;
    }

    public AffinityInfoTypeLanguageSpecific getEnglishInfo() {
        return englishInfo;
    }

    public void setEnglishInfo(AffinityInfoTypeLanguageSpecific englishInfo) {
        this.englishInfo = englishInfo;
    }

    public AffinityInfoTypeLanguageSpecific getFrenchInfo() {
        return frenchInfo;
    }

    public void setFrenchInfo(AffinityInfoTypeLanguageSpecific frenchInfo) {
        this.frenchInfo = frenchInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AffinityInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("failed");
        sb.append('=');
        sb.append(((this.failed == null)?"<null>":this.failed));
        sb.append(',');
        sb.append("affinityCode");
        sb.append('=');
        sb.append(((this.affinityCode == null)?"<null>":this.affinityCode));
        sb.append(',');
        sb.append("productCodes");
        sb.append('=');
        sb.append(((this.productCodes == null)?"<null>":this.productCodes));
        sb.append(',');
        sb.append("englishInfo");
        sb.append('=');
        sb.append(((this.englishInfo == null)?"<null>":this.englishInfo));
        sb.append(',');
        sb.append("frenchInfo");
        sb.append('=');
        sb.append(((this.frenchInfo == null)?"<null>":this.frenchInfo));
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
        result = ((result* 31)+((this.failed == null)? 0 :this.failed.hashCode()));
        result = ((result* 31)+((this.affinityCode == null)? 0 :this.affinityCode.hashCode()));
        result = ((result* 31)+((this.productCodes == null)? 0 :this.productCodes.hashCode()));
        result = ((result* 31)+((this.frenchInfo == null)? 0 :this.frenchInfo.hashCode()));
        result = ((result* 31)+((this.englishInfo == null)? 0 :this.englishInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AffinityInfoType) == false) {
            return false;
        }
        AffinityInfoType rhs = ((AffinityInfoType) other);
        return ((((((this.failed == rhs.failed)||((this.failed!= null)&&this.failed.equals(rhs.failed)))&&((this.affinityCode == rhs.affinityCode)||((this.affinityCode!= null)&&this.affinityCode.equals(rhs.affinityCode))))&&((this.productCodes == rhs.productCodes)||((this.productCodes!= null)&&this.productCodes.equals(rhs.productCodes))))&&((this.frenchInfo == rhs.frenchInfo)||((this.frenchInfo!= null)&&this.frenchInfo.equals(rhs.frenchInfo))))&&((this.englishInfo == rhs.englishInfo)||((this.englishInfo!= null)&&this.englishInfo.equals(rhs.englishInfo))));
    }

}
