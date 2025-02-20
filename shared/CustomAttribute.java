package com.td.api.mbofp.shared;

public class CustomAttribute {

    private String customAttributeId;
    private String customAttributeDesc;
    private String labelTxt;
    private Boolean requiredInd;
    private String defaultVal;
    private Integer minimumLengthCnt;
    private Integer maximumLengthCnt;
    private String dataTypeCd;
    private Boolean visibleInd;
    private Boolean readOnlyInd;
    private Boolean checkDigitRequiredInd;
    private String formatVal;

    public String getCustomAttributeId() {
        return customAttributeId;
    }

    public void setCustomAttributeId(String customAttributeId) {
        this.customAttributeId = customAttributeId;
    }

    public String getCustomAttributeDesc() {
        return customAttributeDesc;
    }

    public void setCustomAttributeDesc(String customAttributeDesc) {
        this.customAttributeDesc = customAttributeDesc;
    }

    public String getLabelTxt() {
        return labelTxt;
    }

    public void setLabelTxt(String labelTxt) {
        this.labelTxt = labelTxt;
    }

    public Boolean getRequiredInd() {
        return requiredInd;
    }

    public void setRequiredInd(Boolean requiredInd) {
        this.requiredInd = requiredInd;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public Integer getMinimumLengthCnt() {
        return minimumLengthCnt;
    }

    public void setMinimumLengthCnt(Integer minimumLengthCnt) {
        this.minimumLengthCnt = minimumLengthCnt;
    }

    public Integer getMaximumLengthCnt() {
        return maximumLengthCnt;
    }

    public void setMaximumLengthCnt(Integer maximumLengthCnt) {
        this.maximumLengthCnt = maximumLengthCnt;
    }

    public String getDataTypeCd() {
        return dataTypeCd;
    }

    public void setDataTypeCd(String dataTypeCd) {
        this.dataTypeCd = dataTypeCd;
    }

    public Boolean getVisibleInd() {
        return visibleInd;
    }

    public void setVisibleInd(Boolean visibleInd) {
        this.visibleInd = visibleInd;
    }

    public Boolean getReadOnlyInd() {
        return readOnlyInd;
    }

    public void setReadOnlyInd(Boolean readOnlyInd) {
        this.readOnlyInd = readOnlyInd;
    }

    public Boolean getCheckDigitRequiredInd() {
        return checkDigitRequiredInd;
    }

    public void setCheckDigitRequiredInd(Boolean checkDigitRequiredInd) {
        this.checkDigitRequiredInd = checkDigitRequiredInd;
    }

    public String getFormatVal() {
        return formatVal;
    }

    public void setFormatVal(String formatVal) {
        this.formatVal = formatVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomAttribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customAttributeId");
        sb.append('=');
        sb.append(((this.customAttributeId == null)?"<null>":this.customAttributeId));
        sb.append(',');
        sb.append("customAttributeDesc");
        sb.append('=');
        sb.append(((this.customAttributeDesc == null)?"<null>":this.customAttributeDesc));
        sb.append(',');
        sb.append("labelTxt");
        sb.append('=');
        sb.append(((this.labelTxt == null)?"<null>":this.labelTxt));
        sb.append(',');
        sb.append("requiredInd");
        sb.append('=');
        sb.append(((this.requiredInd == null)?"<null>":this.requiredInd));
        sb.append(',');
        sb.append("defaultVal");
        sb.append('=');
        sb.append(((this.defaultVal == null)?"<null>":this.defaultVal));
        sb.append(',');
        sb.append("minimumLengthCnt");
        sb.append('=');
        sb.append(((this.minimumLengthCnt == null)?"<null>":this.minimumLengthCnt));
        sb.append(',');
        sb.append("maximumLengthCnt");
        sb.append('=');
        sb.append(((this.maximumLengthCnt == null)?"<null>":this.maximumLengthCnt));
        sb.append(',');
        sb.append("dataTypeCd");
        sb.append('=');
        sb.append(((this.dataTypeCd == null)?"<null>":this.dataTypeCd));
        sb.append(',');
        sb.append("visibleInd");
        sb.append('=');
        sb.append(((this.visibleInd == null)?"<null>":this.visibleInd));
        sb.append(',');
        sb.append("readOnlyInd");
        sb.append('=');
        sb.append(((this.readOnlyInd == null)?"<null>":this.readOnlyInd));
        sb.append(',');
        sb.append("checkDigitRequiredInd");
        sb.append('=');
        sb.append(((this.checkDigitRequiredInd == null)?"<null>":this.checkDigitRequiredInd));
        sb.append(',');
        sb.append("formatVal");
        sb.append('=');
        sb.append(((this.formatVal == null)?"<null>":this.formatVal));
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
        result = ((result* 31)+((this.requiredInd == null)? 0 :this.requiredInd.hashCode()));
        result = ((result* 31)+((this.minimumLengthCnt == null)? 0 :this.minimumLengthCnt.hashCode()));
        result = ((result* 31)+((this.customAttributeId == null)? 0 :this.customAttributeId.hashCode()));
        result = ((result* 31)+((this.labelTxt == null)? 0 :this.labelTxt.hashCode()));
        result = ((result* 31)+((this.maximumLengthCnt == null)? 0 :this.maximumLengthCnt.hashCode()));
        result = ((result* 31)+((this.visibleInd == null)? 0 :this.visibleInd.hashCode()));
        result = ((result* 31)+((this.formatVal == null)? 0 :this.formatVal.hashCode()));
        result = ((result* 31)+((this.dataTypeCd == null)? 0 :this.dataTypeCd.hashCode()));
        result = ((result* 31)+((this.defaultVal == null)? 0 :this.defaultVal.hashCode()));
        result = ((result* 31)+((this.checkDigitRequiredInd == null)? 0 :this.checkDigitRequiredInd.hashCode()));
        result = ((result* 31)+((this.customAttributeDesc == null)? 0 :this.customAttributeDesc.hashCode()));
        result = ((result* 31)+((this.readOnlyInd == null)? 0 :this.readOnlyInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomAttribute) == false) {
            return false;
        }
        CustomAttribute rhs = ((CustomAttribute) other);
        return (((((((((((((this.requiredInd == rhs.requiredInd)||((this.requiredInd!= null)&&this.requiredInd.equals(rhs.requiredInd)))&&((this.minimumLengthCnt == rhs.minimumLengthCnt)||((this.minimumLengthCnt!= null)&&this.minimumLengthCnt.equals(rhs.minimumLengthCnt))))&&((this.customAttributeId == rhs.customAttributeId)||((this.customAttributeId!= null)&&this.customAttributeId.equals(rhs.customAttributeId))))&&((this.labelTxt == rhs.labelTxt)||((this.labelTxt!= null)&&this.labelTxt.equals(rhs.labelTxt))))&&((this.maximumLengthCnt == rhs.maximumLengthCnt)||((this.maximumLengthCnt!= null)&&this.maximumLengthCnt.equals(rhs.maximumLengthCnt))))&&((this.visibleInd == rhs.visibleInd)||((this.visibleInd!= null)&&this.visibleInd.equals(rhs.visibleInd))))&&((this.formatVal == rhs.formatVal)||((this.formatVal!= null)&&this.formatVal.equals(rhs.formatVal))))&&((this.dataTypeCd == rhs.dataTypeCd)||((this.dataTypeCd!= null)&&this.dataTypeCd.equals(rhs.dataTypeCd))))&&((this.defaultVal == rhs.defaultVal)||((this.defaultVal!= null)&&this.defaultVal.equals(rhs.defaultVal))))&&((this.checkDigitRequiredInd == rhs.checkDigitRequiredInd)||((this.checkDigitRequiredInd!= null)&&this.checkDigitRequiredInd.equals(rhs.checkDigitRequiredInd))))&&((this.customAttributeDesc == rhs.customAttributeDesc)||((this.customAttributeDesc!= null)&&this.customAttributeDesc.equals(rhs.customAttributeDesc))))&&((this.readOnlyInd == rhs.readOnlyInd)||((this.readOnlyInd!= null)&&this.readOnlyInd.equals(rhs.readOnlyInd))));
    }

}
