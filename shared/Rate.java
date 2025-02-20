package com.td.api.mbofp.shared;

import java.math.BigDecimal;

public class Rate {

    private String typeCd;
    private String featureClassificationCd;
    private BigDecimal fixedRate;
    private VariableRate variableRate;
    private Boolean rateForLifeInd;
    private PromotionTerm promotionTerm;

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getFeatureClassificationCd() {
        return featureClassificationCd;
    }

    public void setFeatureClassificationCd(String featureClassificationCd) {
        this.featureClassificationCd = featureClassificationCd;
    }

    public BigDecimal getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(BigDecimal fixedRate) {
        this.fixedRate = fixedRate;
    }

    public VariableRate getVariableRate() {
        return variableRate;
    }

    public void setVariableRate(VariableRate variableRate) {
        this.variableRate = variableRate;
    }

    public Boolean getRateForLifeInd() {
		return rateForLifeInd;
	}

	public void setRateForLifeInd(Boolean rateForLifeInd) {
		this.rateForLifeInd = rateForLifeInd;
	}

	public PromotionTerm getPromotionTerm() {
        return promotionTerm;
    }

    public void setPromotionTerm(PromotionTerm promotionTerm) {
        this.promotionTerm = promotionTerm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Rate.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("featureClassificationCd");
        sb.append('=');
        sb.append(((this.featureClassificationCd == null)?"<null>":this.featureClassificationCd));
        sb.append(',');
        sb.append("fixedRate");
        sb.append('=');
        sb.append(((this.fixedRate == null)?"<null>":this.fixedRate));
        sb.append(',');
        sb.append("variableRate");
        sb.append('=');
        sb.append(((this.variableRate == null)?"<null>":this.variableRate));
        sb.append(',');
        sb.append("promotionTerm");
        sb.append('=');
        sb.append(((this.promotionTerm == null)?"<null>":this.promotionTerm));
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
        result = ((result* 31)+((this.fixedRate == null)? 0 :this.fixedRate.hashCode()));
        result = ((result* 31)+((this.promotionTerm == null)? 0 :this.promotionTerm.hashCode()));
        result = ((result* 31)+((this.variableRate == null)? 0 :this.variableRate.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.featureClassificationCd == null)? 0 :this.featureClassificationCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rate) == false) {
            return false;
        }
        Rate rhs = ((Rate) other);
        return ((((((this.fixedRate == rhs.fixedRate)||((this.fixedRate!= null)&&this.fixedRate.equals(rhs.fixedRate)))&&((this.promotionTerm == rhs.promotionTerm)||((this.promotionTerm!= null)&&this.promotionTerm.equals(rhs.promotionTerm))))&&((this.variableRate == rhs.variableRate)||((this.variableRate!= null)&&this.variableRate.equals(rhs.variableRate))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.featureClassificationCd == rhs.featureClassificationCd)||((this.featureClassificationCd!= null)&&this.featureClassificationCd.equals(rhs.featureClassificationCd))));
    }

}
