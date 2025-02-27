package com.td.api.mbcca.shared;

import com.td.api.mbcca.response.account.OriginalAuthorizationEvent__1;

public class MasterCard {

    private String lifeCycleValidationCd;
    private String securityLevelIndicatorCd;
    private String pointOfServiceTerminalCapabilityCd;
    private String cardSequenceNum;
    private String walletId;
    private OriginalAuthorizationEvent__1 originalAuthorizationEvent;
    private String programParticipationTypeCd;
    private String acquiringFinancialInstitutionBankNum;
    private String auditControlNum;
    private String cardVerificationCodeInvalidIndicatorCd;
    private String processingCd;
    private String secureCd;

    public String getLifeCycleValidationCd() {
        return lifeCycleValidationCd;
    }

    public void setLifeCycleValidationCd(String lifeCycleValidationCd) {
        this.lifeCycleValidationCd = lifeCycleValidationCd;
    }

    public String getSecurityLevelIndicatorCd() {
        return securityLevelIndicatorCd;
    }

    public void setSecurityLevelIndicatorCd(String securityLevelIndicatorCd) {
        this.securityLevelIndicatorCd = securityLevelIndicatorCd;
    }

    public String getPointOfServiceTerminalCapabilityCd() {
        return pointOfServiceTerminalCapabilityCd;
    }

    public void setPointOfServiceTerminalCapabilityCd(String pointOfServiceTerminalCapabilityCd) {
        this.pointOfServiceTerminalCapabilityCd = pointOfServiceTerminalCapabilityCd;
    }

    public String getCardSequenceNum() {
        return cardSequenceNum;
    }

    public void setCardSequenceNum(String cardSequenceNum) {
        this.cardSequenceNum = cardSequenceNum;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public OriginalAuthorizationEvent__1 getOriginalAuthorizationEvent() {
        return originalAuthorizationEvent;
    }

    public void setOriginalAuthorizationEvent(OriginalAuthorizationEvent__1 originalAuthorizationEvent) {
        this.originalAuthorizationEvent = originalAuthorizationEvent;
    }

    public String getProgramParticipationTypeCd() {
        return programParticipationTypeCd;
    }

    public void setProgramParticipationTypeCd(String programParticipationTypeCd) {
        this.programParticipationTypeCd = programParticipationTypeCd;
    }

    public String getAcquiringFinancialInstitutionBankNum() {
        return acquiringFinancialInstitutionBankNum;
    }

    public void setAcquiringFinancialInstitutionBankNum(String acquiringFinancialInstitutionBankNum) {
        this.acquiringFinancialInstitutionBankNum = acquiringFinancialInstitutionBankNum;
    }

    public String getAuditControlNum() {
        return auditControlNum;
    }

    public void setAuditControlNum(String auditControlNum) {
        this.auditControlNum = auditControlNum;
    }

    public String getCardVerificationCodeInvalidIndicatorCd() {
        return cardVerificationCodeInvalidIndicatorCd;
    }

    public void setCardVerificationCodeInvalidIndicatorCd(String cardVerificationCodeInvalidIndicatorCd) {
        this.cardVerificationCodeInvalidIndicatorCd = cardVerificationCodeInvalidIndicatorCd;
    }

    public String getProcessingCd() {
        return processingCd;
    }

    public void setProcessingCd(String processingCd) {
        this.processingCd = processingCd;
    }

    public String getSecureCd() {
        return secureCd;
    }

    public void setSecureCd(String secureCd) {
        this.secureCd = secureCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MasterCard.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lifeCycleValidationCd");
        sb.append('=');
        sb.append(((this.lifeCycleValidationCd == null)?"<null>":this.lifeCycleValidationCd));
        sb.append(',');
        sb.append("securityLevelIndicatorCd");
        sb.append('=');
        sb.append(((this.securityLevelIndicatorCd == null)?"<null>":this.securityLevelIndicatorCd));
        sb.append(',');
        sb.append("pointOfServiceTerminalCapabilityCd");
        sb.append('=');
        sb.append(((this.pointOfServiceTerminalCapabilityCd == null)?"<null>":this.pointOfServiceTerminalCapabilityCd));
        sb.append(',');
        sb.append("cardSequenceNum");
        sb.append('=');
        sb.append(((this.cardSequenceNum == null)?"<null>":this.cardSequenceNum));
        sb.append(',');
        sb.append("walletId");
        sb.append('=');
        sb.append(((this.walletId == null)?"<null>":this.walletId));
        sb.append(',');
        sb.append("originalAuthorizationEvent");
        sb.append('=');
        sb.append(((this.originalAuthorizationEvent == null)?"<null>":this.originalAuthorizationEvent));
        sb.append(',');
        sb.append("programParticipationTypeCd");
        sb.append('=');
        sb.append(((this.programParticipationTypeCd == null)?"<null>":this.programParticipationTypeCd));
        sb.append(',');
        sb.append("acquiringFinancialInstitutionBankNum");
        sb.append('=');
        sb.append(((this.acquiringFinancialInstitutionBankNum == null)?"<null>":this.acquiringFinancialInstitutionBankNum));
        sb.append(',');
        sb.append("auditControlNum");
        sb.append('=');
        sb.append(((this.auditControlNum == null)?"<null>":this.auditControlNum));
        sb.append(',');
        sb.append("cardVerificationCodeInvalidIndicatorCd");
        sb.append('=');
        sb.append(((this.cardVerificationCodeInvalidIndicatorCd == null)?"<null>":this.cardVerificationCodeInvalidIndicatorCd));
        sb.append(',');
        sb.append("processingCd");
        sb.append('=');
        sb.append(((this.processingCd == null)?"<null>":this.processingCd));
        sb.append(',');
        sb.append("secureCd");
        sb.append('=');
        sb.append(((this.secureCd == null)?"<null>":this.secureCd));
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
        result = ((result* 31)+((this.walletId == null)? 0 :this.walletId.hashCode()));
        result = ((result* 31)+((this.pointOfServiceTerminalCapabilityCd == null)? 0 :this.pointOfServiceTerminalCapabilityCd.hashCode()));
        result = ((result* 31)+((this.secureCd == null)? 0 :this.secureCd.hashCode()));
        result = ((result* 31)+((this.originalAuthorizationEvent == null)? 0 :this.originalAuthorizationEvent.hashCode()));
        result = ((result* 31)+((this.processingCd == null)? 0 :this.processingCd.hashCode()));
        result = ((result* 31)+((this.securityLevelIndicatorCd == null)? 0 :this.securityLevelIndicatorCd.hashCode()));
        result = ((result* 31)+((this.auditControlNum == null)? 0 :this.auditControlNum.hashCode()));
        result = ((result* 31)+((this.lifeCycleValidationCd == null)? 0 :this.lifeCycleValidationCd.hashCode()));
        result = ((result* 31)+((this.programParticipationTypeCd == null)? 0 :this.programParticipationTypeCd.hashCode()));
        result = ((result* 31)+((this.cardSequenceNum == null)? 0 :this.cardSequenceNum.hashCode()));
        result = ((result* 31)+((this.acquiringFinancialInstitutionBankNum == null)? 0 :this.acquiringFinancialInstitutionBankNum.hashCode()));
        result = ((result* 31)+((this.cardVerificationCodeInvalidIndicatorCd == null)? 0 :this.cardVerificationCodeInvalidIndicatorCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MasterCard) == false) {
            return false;
        }
        MasterCard rhs = ((MasterCard) other);
        return (((((((((((((this.walletId == rhs.walletId)||((this.walletId!= null)&&this.walletId.equals(rhs.walletId)))&&((this.pointOfServiceTerminalCapabilityCd == rhs.pointOfServiceTerminalCapabilityCd)||((this.pointOfServiceTerminalCapabilityCd!= null)&&this.pointOfServiceTerminalCapabilityCd.equals(rhs.pointOfServiceTerminalCapabilityCd))))&&((this.secureCd == rhs.secureCd)||((this.secureCd!= null)&&this.secureCd.equals(rhs.secureCd))))&&((this.originalAuthorizationEvent == rhs.originalAuthorizationEvent)||((this.originalAuthorizationEvent!= null)&&this.originalAuthorizationEvent.equals(rhs.originalAuthorizationEvent))))&&((this.processingCd == rhs.processingCd)||((this.processingCd!= null)&&this.processingCd.equals(rhs.processingCd))))&&((this.securityLevelIndicatorCd == rhs.securityLevelIndicatorCd)||((this.securityLevelIndicatorCd!= null)&&this.securityLevelIndicatorCd.equals(rhs.securityLevelIndicatorCd))))&&((this.auditControlNum == rhs.auditControlNum)||((this.auditControlNum!= null)&&this.auditControlNum.equals(rhs.auditControlNum))))&&((this.lifeCycleValidationCd == rhs.lifeCycleValidationCd)||((this.lifeCycleValidationCd!= null)&&this.lifeCycleValidationCd.equals(rhs.lifeCycleValidationCd))))&&((this.programParticipationTypeCd == rhs.programParticipationTypeCd)||((this.programParticipationTypeCd!= null)&&this.programParticipationTypeCd.equals(rhs.programParticipationTypeCd))))&&((this.cardSequenceNum == rhs.cardSequenceNum)||((this.cardSequenceNum!= null)&&this.cardSequenceNum.equals(rhs.cardSequenceNum))))&&((this.acquiringFinancialInstitutionBankNum == rhs.acquiringFinancialInstitutionBankNum)||((this.acquiringFinancialInstitutionBankNum!= null)&&this.acquiringFinancialInstitutionBankNum.equals(rhs.acquiringFinancialInstitutionBankNum))))&&((this.cardVerificationCodeInvalidIndicatorCd == rhs.cardVerificationCodeInvalidIndicatorCd)||((this.cardVerificationCodeInvalidIndicatorCd!= null)&&this.cardVerificationCodeInvalidIndicatorCd.equals(rhs.cardVerificationCodeInvalidIndicatorCd))));
    }

}
