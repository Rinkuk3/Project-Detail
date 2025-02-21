package com.td.api.mbcca.response.account;

import java.util.Date;

import com.td.api.mbcca.shared.Cccyamt;

public class PromotionTransactionCategoryInfo {

    private String transactionCategoryCd;
    private String termBalanceCd;
    private Cccyamt earlyExpirationRemainingBalanceCccyamt;
    private String transactionCategoryDesc;
    private String termBalanceDesc;
    private String reasonCd;
    private String promotionEndDt;
    private String promotionEarlyExpirationDt;
    private String expirationToTermBalanceCd;
    private String featureClassificationCd;
    private String statementDataDt;
    private Date postedDttm;
    private Boolean reinstatedInd;

    public String getTransactionCategoryCd() {
        return transactionCategoryCd;
    }

    public void setTransactionCategoryCd(String transactionCategoryCd) {
        this.transactionCategoryCd = transactionCategoryCd;
    }

    public String getTermBalanceCd() {
        return termBalanceCd;
    }

    public void setTermBalanceCd(String termBalanceCd) {
        this.termBalanceCd = termBalanceCd;
    }

    public Cccyamt getEarlyExpirationRemainingBalanceCccyamt() {
        return earlyExpirationRemainingBalanceCccyamt;
    }

    public void setEarlyExpirationRemainingBalanceCccyamt(Cccyamt earlyExpirationRemainingBalanceCccyamt) {
        this.earlyExpirationRemainingBalanceCccyamt = earlyExpirationRemainingBalanceCccyamt;
    }

    public String getTransactionCategoryDesc() {
        return transactionCategoryDesc;
    }

    public void setTransactionCategoryDesc(String transactionCategoryDesc) {
        this.transactionCategoryDesc = transactionCategoryDesc;
    }

    public String getTermBalanceDesc() {
        return termBalanceDesc;
    }

    public void setTermBalanceDesc(String termBalanceDesc) {
        this.termBalanceDesc = termBalanceDesc;
    }

    public String getReasonCd() {
        return reasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    public String getPromotionEndDt() {
        return promotionEndDt;
    }

    public void setPromotionEndDt(String promotionEndDt) {
        this.promotionEndDt = promotionEndDt;
    }

    public String getPromotionEarlyExpirationDt() {
        return promotionEarlyExpirationDt;
    }

    public void setPromotionEarlyExpirationDt(String promotionEarlyExpirationDt) {
        this.promotionEarlyExpirationDt = promotionEarlyExpirationDt;
    }

    public String getExpirationToTermBalanceCd() {
        return expirationToTermBalanceCd;
    }

    public void setExpirationToTermBalanceCd(String expirationToTermBalanceCd) {
        this.expirationToTermBalanceCd = expirationToTermBalanceCd;
    }

    public String getFeatureClassificationCd() {
        return featureClassificationCd;
    }

    public void setFeatureClassificationCd(String featureClassificationCd) {
        this.featureClassificationCd = featureClassificationCd;
    }

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

    public Boolean getReinstatedInd() {
        return reinstatedInd;
    }

    public void setReinstatedInd(Boolean reinstatedInd) {
        this.reinstatedInd = reinstatedInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PromotionTransactionCategoryInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transactionCategoryCd");
        sb.append('=');
        sb.append(((this.transactionCategoryCd == null)?"<null>":this.transactionCategoryCd));
        sb.append(',');
        sb.append("termBalanceCd");
        sb.append('=');
        sb.append(((this.termBalanceCd == null)?"<null>":this.termBalanceCd));
        sb.append(',');
        sb.append("earlyExpirationRemainingBalanceCccyamt");
        sb.append('=');
        sb.append(((this.earlyExpirationRemainingBalanceCccyamt == null)?"<null>":this.earlyExpirationRemainingBalanceCccyamt));
        sb.append(',');
        sb.append("transactionCategoryDesc");
        sb.append('=');
        sb.append(((this.transactionCategoryDesc == null)?"<null>":this.transactionCategoryDesc));
        sb.append(',');
        sb.append("termBalanceDesc");
        sb.append('=');
        sb.append(((this.termBalanceDesc == null)?"<null>":this.termBalanceDesc));
        sb.append(',');
        sb.append("reasonCd");
        sb.append('=');
        sb.append(((this.reasonCd == null)?"<null>":this.reasonCd));
        sb.append(',');
        sb.append("promotionEndDt");
        sb.append('=');
        sb.append(((this.promotionEndDt == null)?"<null>":this.promotionEndDt));
        sb.append(',');
        sb.append("promotionEarlyExpirationDt");
        sb.append('=');
        sb.append(((this.promotionEarlyExpirationDt == null)?"<null>":this.promotionEarlyExpirationDt));
        sb.append(',');
        sb.append("expirationToTermBalanceCd");
        sb.append('=');
        sb.append(((this.expirationToTermBalanceCd == null)?"<null>":this.expirationToTermBalanceCd));
        sb.append(',');
        sb.append("featureClassificationCd");
        sb.append('=');
        sb.append(((this.featureClassificationCd == null)?"<null>":this.featureClassificationCd));
        sb.append(',');
        sb.append("statementDataDt");
        sb.append('=');
        sb.append(((this.statementDataDt == null)?"<null>":this.statementDataDt));
        sb.append(',');
        sb.append("postedDttm");
        sb.append('=');
        sb.append(((this.postedDttm == null)?"<null>":this.postedDttm));
        sb.append(',');
        sb.append("reinstatedInd");
        sb.append('=');
        sb.append(((this.reinstatedInd == null)?"<null>":this.reinstatedInd));
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
        result = ((result* 31)+((this.promotionEarlyExpirationDt == null)? 0 :this.promotionEarlyExpirationDt.hashCode()));
        result = ((result* 31)+((this.featureClassificationCd == null)? 0 :this.featureClassificationCd.hashCode()));
        result = ((result* 31)+((this.reinstatedInd == null)? 0 :this.reinstatedInd.hashCode()));
        result = ((result* 31)+((this.postedDttm == null)? 0 :this.postedDttm.hashCode()));
        result = ((result* 31)+((this.transactionCategoryDesc == null)? 0 :this.transactionCategoryDesc.hashCode()));
        result = ((result* 31)+((this.promotionEndDt == null)? 0 :this.promotionEndDt.hashCode()));
        result = ((result* 31)+((this.reasonCd == null)? 0 :this.reasonCd.hashCode()));
        result = ((result* 31)+((this.termBalanceDesc == null)? 0 :this.termBalanceDesc.hashCode()));
        result = ((result* 31)+((this.transactionCategoryCd == null)? 0 :this.transactionCategoryCd.hashCode()));
        result = ((result* 31)+((this.earlyExpirationRemainingBalanceCccyamt == null)? 0 :this.earlyExpirationRemainingBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.statementDataDt == null)? 0 :this.statementDataDt.hashCode()));
        result = ((result* 31)+((this.termBalanceCd == null)? 0 :this.termBalanceCd.hashCode()));
        result = ((result* 31)+((this.expirationToTermBalanceCd == null)? 0 :this.expirationToTermBalanceCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PromotionTransactionCategoryInfo) == false) {
            return false;
        }
        PromotionTransactionCategoryInfo rhs = ((PromotionTransactionCategoryInfo) other);
        return ((((((((((((((this.promotionEarlyExpirationDt == rhs.promotionEarlyExpirationDt)||((this.promotionEarlyExpirationDt!= null)&&this.promotionEarlyExpirationDt.equals(rhs.promotionEarlyExpirationDt)))&&((this.featureClassificationCd == rhs.featureClassificationCd)||((this.featureClassificationCd!= null)&&this.featureClassificationCd.equals(rhs.featureClassificationCd))))&&((this.reinstatedInd == rhs.reinstatedInd)||((this.reinstatedInd!= null)&&this.reinstatedInd.equals(rhs.reinstatedInd))))&&((this.postedDttm == rhs.postedDttm)||((this.postedDttm!= null)&&this.postedDttm.equals(rhs.postedDttm))))&&((this.transactionCategoryDesc == rhs.transactionCategoryDesc)||((this.transactionCategoryDesc!= null)&&this.transactionCategoryDesc.equals(rhs.transactionCategoryDesc))))&&((this.promotionEndDt == rhs.promotionEndDt)||((this.promotionEndDt!= null)&&this.promotionEndDt.equals(rhs.promotionEndDt))))&&((this.reasonCd == rhs.reasonCd)||((this.reasonCd!= null)&&this.reasonCd.equals(rhs.reasonCd))))&&((this.termBalanceDesc == rhs.termBalanceDesc)||((this.termBalanceDesc!= null)&&this.termBalanceDesc.equals(rhs.termBalanceDesc))))&&((this.transactionCategoryCd == rhs.transactionCategoryCd)||((this.transactionCategoryCd!= null)&&this.transactionCategoryCd.equals(rhs.transactionCategoryCd))))&&((this.earlyExpirationRemainingBalanceCccyamt == rhs.earlyExpirationRemainingBalanceCccyamt)||((this.earlyExpirationRemainingBalanceCccyamt!= null)&&this.earlyExpirationRemainingBalanceCccyamt.equals(rhs.earlyExpirationRemainingBalanceCccyamt))))&&((this.statementDataDt == rhs.statementDataDt)||((this.statementDataDt!= null)&&this.statementDataDt.equals(rhs.statementDataDt))))&&((this.termBalanceCd == rhs.termBalanceCd)||((this.termBalanceCd!= null)&&this.termBalanceCd.equals(rhs.termBalanceCd))))&&((this.expirationToTermBalanceCd == rhs.expirationToTermBalanceCd)||((this.expirationToTermBalanceCd!= null)&&this.expirationToTermBalanceCd.equals(rhs.expirationToTermBalanceCd))));
    }

}
