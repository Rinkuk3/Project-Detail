package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.td.api.mbcca.shared.Cccyamt;
import com.td.api.mbcca.shared.Pin;

public class Card {

    private String key;
    private String statusCd;
    private Date statusDttm;
    private String statusReasonCd;
    private String cardNum;
    private String cardNumMasked;
    private String cardNickname;
    private String typeCd;
    private String onCardName;
    private String onCardCompanyName;
    private CardExpiration cardExpiration;
    private String cardVerificationNum;
    private String activationDt;
    private String cardIssueDt;
    private String bin;
    private Cccyamt annualFeeCccyamt;
    private LoyaltyInfo loyaltyInfo;
    java.math.BigDecimal balanceAmt;
    java.math.BigDecimal creditLimitAmt;
    private String transferFromCardNum;
    private String transferToCardNum;
    private String transferSequenceNum;
    private String deviceTypeCd;
    private DeviceTSYSExtension deviceTSYSExtension;
    private String lastCardRequestReasonCd;
    private String receiptVerificationDt;
    private Boolean receiptVerificationInd;
    private List<AgreementToParty> agreementToParty = new ArrayList<AgreementToParty>();
    private Integer numberOfPrimaryCardCnt;
    private Integer numberOfIssuingPrimaryCardsCnt;
    private Pin pin;
    private String lastCardRequestDt;
    private String lastCardRequestOperatorPartyId;
    private String cardRequestStatusCd;
    private String receiptCardTypeCd;
    private String cardMailerTypeCd;
    private String chipCardFeatureId;
    private Boolean massCompromisedInd;
    private String lastCompromisedAuthorizationApprovalDt;
    private String lastCompromisedAuthorizationReferralDt;
    private Integer numberOfTokenCnt;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public Date getStatusDttm() {
        return statusDttm;
    }

    public void setStatusDttm(Date statusDttm) {
        this.statusDttm = statusDttm;
    }

    public String getStatusReasonCd() {
        return statusReasonCd;
    }

    public void setStatusReasonCd(String statusReasonCd) {
        this.statusReasonCd = statusReasonCd;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardNumMasked() {
        return cardNumMasked;
    }

    public void setCardNumMasked(String cardNumMasked) {
        this.cardNumMasked = cardNumMasked;
    }

    public String getCardNickname() {
        return cardNickname;
    }

    public void setCardNickname(String cardNickname) {
        this.cardNickname = cardNickname;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getOnCardName() {
        return onCardName;
    }

    public void setOnCardName(String onCardName) {
        this.onCardName = onCardName;
    }

    public String getOnCardCompanyName() {
        return onCardCompanyName;
    }

    public void setOnCardCompanyName(String onCardCompanyName) {
        this.onCardCompanyName = onCardCompanyName;
    }

    public CardExpiration getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(CardExpiration cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public String getCardVerificationNum() {
        return cardVerificationNum;
    }

    public void setCardVerificationNum(String cardVerificationNum) {
        this.cardVerificationNum = cardVerificationNum;
    }

    public String getActivationDt() {
        return activationDt;
    }

    public void setActivationDt(String activationDt) {
        this.activationDt = activationDt;
    }

    public String getCardIssueDt() {
        return cardIssueDt;
    }

    public void setCardIssueDt(String cardIssueDt) {
        this.cardIssueDt = cardIssueDt;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public Cccyamt getAnnualFeeCccyamt() {
        return annualFeeCccyamt;
    }

    public void setAnnualFeeCccyamt(Cccyamt annualFeeCccyamt) {
        this.annualFeeCccyamt = annualFeeCccyamt;
    }

    public LoyaltyInfo getLoyaltyInfo() {
        return loyaltyInfo;
    }

    public void setLoyaltyInfo(LoyaltyInfo loyaltyInfo) {
        this.loyaltyInfo = loyaltyInfo;
    }

    public java.math.BigDecimal getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(java.math.BigDecimal balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public java.math.BigDecimal getCreditLimitAmt() {
        return creditLimitAmt;
    }

    public void setCreditLimitAmt(java.math.BigDecimal creditLimitAmt) {
        this.creditLimitAmt = creditLimitAmt;
    }

    public String getTransferFromCardNum() {
        return transferFromCardNum;
    }

    public void setTransferFromCardNum(String transferFromCardNum) {
        this.transferFromCardNum = transferFromCardNum;
    }

    public String getTransferToCardNum() {
        return transferToCardNum;
    }

    public void setTransferToCardNum(String transferToCardNum) {
        this.transferToCardNum = transferToCardNum;
    }

    public String getTransferSequenceNum() {
        return transferSequenceNum;
    }

    public void setTransferSequenceNum(String transferSequenceNum) {
        this.transferSequenceNum = transferSequenceNum;
    }

    public String getDeviceTypeCd() {
        return deviceTypeCd;
    }

    public void setDeviceTypeCd(String deviceTypeCd) {
        this.deviceTypeCd = deviceTypeCd;
    }

    public DeviceTSYSExtension getDeviceTSYSExtension() {
        return deviceTSYSExtension;
    }

    public void setDeviceTSYSExtension(DeviceTSYSExtension deviceTSYSExtension) {
        this.deviceTSYSExtension = deviceTSYSExtension;
    }

    public String getLastCardRequestReasonCd() {
        return lastCardRequestReasonCd;
    }

    public void setLastCardRequestReasonCd(String lastCardRequestReasonCd) {
        this.lastCardRequestReasonCd = lastCardRequestReasonCd;
    }

    public String getReceiptVerificationDt() {
        return receiptVerificationDt;
    }

    public void setReceiptVerificationDt(String receiptVerificationDt) {
        this.receiptVerificationDt = receiptVerificationDt;
    }

    public Boolean getReceiptVerificationInd() {
        return receiptVerificationInd;
    }

    public void setReceiptVerificationInd(Boolean receiptVerificationInd) {
        this.receiptVerificationInd = receiptVerificationInd;
    }

    public List<AgreementToParty> getAgreementToParty() {
        return agreementToParty;
    }

    public void setAgreementToParty(List<AgreementToParty> agreementToParty) {
        this.agreementToParty = agreementToParty;
    }

    public Integer getNumberOfPrimaryCardCnt() {
        return numberOfPrimaryCardCnt;
    }

    public void setNumberOfPrimaryCardCnt(Integer numberOfPrimaryCardCnt) {
        this.numberOfPrimaryCardCnt = numberOfPrimaryCardCnt;
    }

    public Integer getNumberOfIssuingPrimaryCardsCnt() {
        return numberOfIssuingPrimaryCardsCnt;
    }

    public void setNumberOfIssuingPrimaryCardsCnt(Integer numberOfIssuingPrimaryCardsCnt) {
        this.numberOfIssuingPrimaryCardsCnt = numberOfIssuingPrimaryCardsCnt;
    }

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public String getLastCardRequestDt() {
        return lastCardRequestDt;
    }

    public void setLastCardRequestDt(String lastCardRequestDt) {
        this.lastCardRequestDt = lastCardRequestDt;
    }

    public String getLastCardRequestOperatorPartyId() {
        return lastCardRequestOperatorPartyId;
    }

    public void setLastCardRequestOperatorPartyId(String lastCardRequestOperatorPartyId) {
        this.lastCardRequestOperatorPartyId = lastCardRequestOperatorPartyId;
    }

    public String getCardRequestStatusCd() {
        return cardRequestStatusCd;
    }

    public void setCardRequestStatusCd(String cardRequestStatusCd) {
        this.cardRequestStatusCd = cardRequestStatusCd;
    }

    public String getReceiptCardTypeCd() {
        return receiptCardTypeCd;
    }

    public void setReceiptCardTypeCd(String receiptCardTypeCd) {
        this.receiptCardTypeCd = receiptCardTypeCd;
    }

    public String getCardMailerTypeCd() {
        return cardMailerTypeCd;
    }

    public void setCardMailerTypeCd(String cardMailerTypeCd) {
        this.cardMailerTypeCd = cardMailerTypeCd;
    }

    public String getChipCardFeatureId() {
        return chipCardFeatureId;
    }

    public void setChipCardFeatureId(String chipCardFeatureId) {
        this.chipCardFeatureId = chipCardFeatureId;
    }

    public Boolean getMassCompromisedInd() {
        return massCompromisedInd;
    }

    public void setMassCompromisedInd(Boolean massCompromisedInd) {
        this.massCompromisedInd = massCompromisedInd;
    }

    public String getLastCompromisedAuthorizationApprovalDt() {
        return lastCompromisedAuthorizationApprovalDt;
    }

    public void setLastCompromisedAuthorizationApprovalDt(String lastCompromisedAuthorizationApprovalDt) {
        this.lastCompromisedAuthorizationApprovalDt = lastCompromisedAuthorizationApprovalDt;
    }

    public String getLastCompromisedAuthorizationReferralDt() {
        return lastCompromisedAuthorizationReferralDt;
    }

    public void setLastCompromisedAuthorizationReferralDt(String lastCompromisedAuthorizationReferralDt) {
        this.lastCompromisedAuthorizationReferralDt = lastCompromisedAuthorizationReferralDt;
    }

    public Integer getNumberOfTokenCnt() {
        return numberOfTokenCnt;
    }

    public void setNumberOfTokenCnt(Integer numberOfTokenCnt) {
        this.numberOfTokenCnt = numberOfTokenCnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Card.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
        sb.append(',');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
        sb.append(',');
        sb.append("statusDttm");
        sb.append('=');
        sb.append(((this.statusDttm == null)?"<null>":this.statusDttm));
        sb.append(',');
        sb.append("statusReasonCd");
        sb.append('=');
        sb.append(((this.statusReasonCd == null)?"<null>":this.statusReasonCd));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("cardNumMasked");
        sb.append('=');
        sb.append(((this.cardNumMasked == null)?"<null>":this.cardNumMasked));
        sb.append(',');
        sb.append("cardNickname");
        sb.append('=');
        sb.append(((this.cardNickname == null)?"<null>":this.cardNickname));
        sb.append(',');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("onCardName");
        sb.append('=');
        sb.append(((this.onCardName == null)?"<null>":this.onCardName));
        sb.append(',');
        sb.append("onCardCompanyName");
        sb.append('=');
        sb.append(((this.onCardCompanyName == null)?"<null>":this.onCardCompanyName));
        sb.append(',');
        sb.append("cardExpiration");
        sb.append('=');
        sb.append(((this.cardExpiration == null)?"<null>":this.cardExpiration));
        sb.append(',');
        sb.append("cardVerificationNum");
        sb.append('=');
        sb.append(((this.cardVerificationNum == null)?"<null>":this.cardVerificationNum));
        sb.append(',');
        sb.append("activationDt");
        sb.append('=');
        sb.append(((this.activationDt == null)?"<null>":this.activationDt));
        sb.append(',');
        sb.append("cardIssueDt");
        sb.append('=');
        sb.append(((this.cardIssueDt == null)?"<null>":this.cardIssueDt));
        sb.append(',');
        sb.append("bin");
        sb.append('=');
        sb.append(((this.bin == null)?"<null>":this.bin));
        sb.append(',');
        sb.append("annualFeeCccyamt");
        sb.append('=');
        sb.append(((this.annualFeeCccyamt == null)?"<null>":this.annualFeeCccyamt));
        sb.append(',');
        sb.append("loyaltyInfo");
        sb.append('=');
        sb.append(((this.loyaltyInfo == null)?"<null>":this.loyaltyInfo));
        sb.append(',');
        sb.append("balanceAmt");
        sb.append('=');
        sb.append(((this.balanceAmt == null)?"<null>":this.balanceAmt));
        sb.append(',');
        sb.append("creditLimitAmt");
        sb.append('=');
        sb.append(((this.creditLimitAmt == null)?"<null>":this.creditLimitAmt));
        sb.append(',');
        sb.append("transferFromCardNum");
        sb.append('=');
        sb.append(((this.transferFromCardNum == null)?"<null>":this.transferFromCardNum));
        sb.append(',');
        sb.append("transferToCardNum");
        sb.append('=');
        sb.append(((this.transferToCardNum == null)?"<null>":this.transferToCardNum));
        sb.append(',');
        sb.append("transferSequenceNum");
        sb.append('=');
        sb.append(((this.transferSequenceNum == null)?"<null>":this.transferSequenceNum));
        sb.append(',');
        sb.append("deviceTypeCd");
        sb.append('=');
        sb.append(((this.deviceTypeCd == null)?"<null>":this.deviceTypeCd));
        sb.append(',');
        sb.append("deviceTSYSExtension");
        sb.append('=');
        sb.append(((this.deviceTSYSExtension == null)?"<null>":this.deviceTSYSExtension));
        sb.append(',');
        sb.append("lastCardRequestReasonCd");
        sb.append('=');
        sb.append(((this.lastCardRequestReasonCd == null)?"<null>":this.lastCardRequestReasonCd));
        sb.append(',');
        sb.append("receiptVerificationDt");
        sb.append('=');
        sb.append(((this.receiptVerificationDt == null)?"<null>":this.receiptVerificationDt));
        sb.append(',');
        sb.append("receiptVerificationInd");
        sb.append('=');
        sb.append(((this.receiptVerificationInd == null)?"<null>":this.receiptVerificationInd));
        sb.append(',');
        sb.append("agreementToParty");
        sb.append('=');
        sb.append(((this.agreementToParty == null)?"<null>":this.agreementToParty));
        sb.append(',');
        sb.append("numberOfPrimaryCardCnt");
        sb.append('=');
        sb.append(((this.numberOfPrimaryCardCnt == null)?"<null>":this.numberOfPrimaryCardCnt));
        sb.append(',');
        sb.append("numberOfIssuingPrimaryCardsCnt");
        sb.append('=');
        sb.append(((this.numberOfIssuingPrimaryCardsCnt == null)?"<null>":this.numberOfIssuingPrimaryCardsCnt));
        sb.append(',');
        sb.append("pin");
        sb.append('=');
        sb.append(((this.pin == null)?"<null>":this.pin));
        sb.append(',');
        sb.append("lastCardRequestDt");
        sb.append('=');
        sb.append(((this.lastCardRequestDt == null)?"<null>":this.lastCardRequestDt));
        sb.append(',');
        sb.append("lastCardRequestOperatorPartyId");
        sb.append('=');
        sb.append(((this.lastCardRequestOperatorPartyId == null)?"<null>":this.lastCardRequestOperatorPartyId));
        sb.append(',');
        sb.append("cardRequestStatusCd");
        sb.append('=');
        sb.append(((this.cardRequestStatusCd == null)?"<null>":this.cardRequestStatusCd));
        sb.append(',');
        sb.append("receiptCardTypeCd");
        sb.append('=');
        sb.append(((this.receiptCardTypeCd == null)?"<null>":this.receiptCardTypeCd));
        sb.append(',');
        sb.append("cardMailerTypeCd");
        sb.append('=');
        sb.append(((this.cardMailerTypeCd == null)?"<null>":this.cardMailerTypeCd));
        sb.append(',');
        sb.append("chipCardFeatureId");
        sb.append('=');
        sb.append(((this.chipCardFeatureId == null)?"<null>":this.chipCardFeatureId));
        sb.append(',');
        sb.append("massCompromisedInd");
        sb.append('=');
        sb.append(((this.massCompromisedInd == null)?"<null>":this.massCompromisedInd));
        sb.append(',');
        sb.append("lastCompromisedAuthorizationApprovalDt");
        sb.append('=');
        sb.append(((this.lastCompromisedAuthorizationApprovalDt == null)?"<null>":this.lastCompromisedAuthorizationApprovalDt));
        sb.append(',');
        sb.append("lastCompromisedAuthorizationReferralDt");
        sb.append('=');
        sb.append(((this.lastCompromisedAuthorizationReferralDt == null)?"<null>":this.lastCompromisedAuthorizationReferralDt));
        sb.append(',');
        sb.append("numberOfTokenCnt");
        sb.append('=');
        sb.append(((this.numberOfTokenCnt == null)?"<null>":this.numberOfTokenCnt));
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
        result = ((result* 31)+((this.cardNickname == null)? 0 :this.cardNickname.hashCode()));
        result = ((result* 31)+((this.annualFeeCccyamt == null)? 0 :this.annualFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.bin == null)? 0 :this.bin.hashCode()));
        result = ((result* 31)+((this.transferSequenceNum == null)? 0 :this.transferSequenceNum.hashCode()));
        result = ((result* 31)+((this.activationDt == null)? 0 :this.activationDt.hashCode()));
        result = ((result* 31)+((this.numberOfPrimaryCardCnt == null)? 0 :this.numberOfPrimaryCardCnt.hashCode()));
        result = ((result* 31)+((this.loyaltyInfo == null)? 0 :this.loyaltyInfo.hashCode()));
        result = ((result* 31)+((this.cardMailerTypeCd == null)? 0 :this.cardMailerTypeCd.hashCode()));
        result = ((result* 31)+((this.balanceAmt == null)? 0 :this.balanceAmt.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.statusReasonCd == null)? 0 :this.statusReasonCd.hashCode()));
        result = ((result* 31)+((this.pin == null)? 0 :this.pin.hashCode()));
        result = ((result* 31)+((this.creditLimitAmt == null)? 0 :this.creditLimitAmt.hashCode()));
        result = ((result* 31)+((this.transferFromCardNum == null)? 0 :this.transferFromCardNum.hashCode()));
        result = ((result* 31)+((this.deviceTypeCd == null)? 0 :this.deviceTypeCd.hashCode()));
        result = ((result* 31)+((this.statusDttm == null)? 0 :this.statusDttm.hashCode()));
        result = ((result* 31)+((this.receiptVerificationInd == null)? 0 :this.receiptVerificationInd.hashCode()));
        result = ((result* 31)+((this.cardExpiration == null)? 0 :this.cardExpiration.hashCode()));
        result = ((result* 31)+((this.key == null)? 0 :this.key.hashCode()));
        result = ((result* 31)+((this.massCompromisedInd == null)? 0 :this.massCompromisedInd.hashCode()));
        result = ((result* 31)+((this.lastCardRequestReasonCd == null)? 0 :this.lastCardRequestReasonCd.hashCode()));
        result = ((result* 31)+((this.receiptVerificationDt == null)? 0 :this.receiptVerificationDt.hashCode()));
        result = ((result* 31)+((this.onCardName == null)? 0 :this.onCardName.hashCode()));
        result = ((result* 31)+((this.lastCardRequestOperatorPartyId == null)? 0 :this.lastCardRequestOperatorPartyId.hashCode()));
        result = ((result* 31)+((this.numberOfTokenCnt == null)? 0 :this.numberOfTokenCnt.hashCode()));
        result = ((result* 31)+((this.chipCardFeatureId == null)? 0 :this.chipCardFeatureId.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.numberOfIssuingPrimaryCardsCnt == null)? 0 :this.numberOfIssuingPrimaryCardsCnt.hashCode()));
        result = ((result* 31)+((this.agreementToParty == null)? 0 :this.agreementToParty.hashCode()));
        result = ((result* 31)+((this.receiptCardTypeCd == null)? 0 :this.receiptCardTypeCd.hashCode()));
        result = ((result* 31)+((this.transferToCardNum == null)? 0 :this.transferToCardNum.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.lastCompromisedAuthorizationReferralDt == null)? 0 :this.lastCompromisedAuthorizationReferralDt.hashCode()));
        result = ((result* 31)+((this.cardRequestStatusCd == null)? 0 :this.cardRequestStatusCd.hashCode()));
        result = ((result* 31)+((this.lastCompromisedAuthorizationApprovalDt == null)? 0 :this.lastCompromisedAuthorizationApprovalDt.hashCode()));
        result = ((result* 31)+((this.lastCardRequestDt == null)? 0 :this.lastCardRequestDt.hashCode()));
        result = ((result* 31)+((this.cardVerificationNum == null)? 0 :this.cardVerificationNum.hashCode()));
        result = ((result* 31)+((this.onCardCompanyName == null)? 0 :this.onCardCompanyName.hashCode()));
        result = ((result* 31)+((this.cardIssueDt == null)? 0 :this.cardIssueDt.hashCode()));
        result = ((result* 31)+((this.cardNumMasked == null)? 0 :this.cardNumMasked.hashCode()));
        result = ((result* 31)+((this.deviceTSYSExtension == null)? 0 :this.deviceTSYSExtension.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Card) == false) {
            return false;
        }
        Card rhs = ((Card) other);
        return ((((((((((((((((((((((((((((((((((((((((((this.cardNickname == rhs.cardNickname)||((this.cardNickname!= null)&&this.cardNickname.equals(rhs.cardNickname)))&&((this.annualFeeCccyamt == rhs.annualFeeCccyamt)||((this.annualFeeCccyamt!= null)&&this.annualFeeCccyamt.equals(rhs.annualFeeCccyamt))))&&((this.bin == rhs.bin)||((this.bin!= null)&&this.bin.equals(rhs.bin))))&&((this.transferSequenceNum == rhs.transferSequenceNum)||((this.transferSequenceNum!= null)&&this.transferSequenceNum.equals(rhs.transferSequenceNum))))&&((this.activationDt == rhs.activationDt)||((this.activationDt!= null)&&this.activationDt.equals(rhs.activationDt))))&&((this.numberOfPrimaryCardCnt == rhs.numberOfPrimaryCardCnt)||((this.numberOfPrimaryCardCnt!= null)&&this.numberOfPrimaryCardCnt.equals(rhs.numberOfPrimaryCardCnt))))&&((this.loyaltyInfo == rhs.loyaltyInfo)||((this.loyaltyInfo!= null)&&this.loyaltyInfo.equals(rhs.loyaltyInfo))))&&((this.cardMailerTypeCd == rhs.cardMailerTypeCd)||((this.cardMailerTypeCd!= null)&&this.cardMailerTypeCd.equals(rhs.cardMailerTypeCd))))&&((this.balanceAmt == rhs.balanceAmt)||((this.balanceAmt!= null)&&this.balanceAmt.equals(rhs.balanceAmt))))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.statusReasonCd == rhs.statusReasonCd)||((this.statusReasonCd!= null)&&this.statusReasonCd.equals(rhs.statusReasonCd))))&&((this.pin == rhs.pin)||((this.pin!= null)&&this.pin.equals(rhs.pin))))&&((this.creditLimitAmt == rhs.creditLimitAmt)||((this.creditLimitAmt!= null)&&this.creditLimitAmt.equals(rhs.creditLimitAmt))))&&((this.transferFromCardNum == rhs.transferFromCardNum)||((this.transferFromCardNum!= null)&&this.transferFromCardNum.equals(rhs.transferFromCardNum))))&&((this.deviceTypeCd == rhs.deviceTypeCd)||((this.deviceTypeCd!= null)&&this.deviceTypeCd.equals(rhs.deviceTypeCd))))&&((this.statusDttm == rhs.statusDttm)||((this.statusDttm!= null)&&this.statusDttm.equals(rhs.statusDttm))))&&((this.receiptVerificationInd == rhs.receiptVerificationInd)||((this.receiptVerificationInd!= null)&&this.receiptVerificationInd.equals(rhs.receiptVerificationInd))))&&((this.cardExpiration == rhs.cardExpiration)||((this.cardExpiration!= null)&&this.cardExpiration.equals(rhs.cardExpiration))))&&((this.key == rhs.key)||((this.key!= null)&&this.key.equals(rhs.key))))&&((this.massCompromisedInd == rhs.massCompromisedInd)||((this.massCompromisedInd!= null)&&this.massCompromisedInd.equals(rhs.massCompromisedInd))))&&((this.lastCardRequestReasonCd == rhs.lastCardRequestReasonCd)||((this.lastCardRequestReasonCd!= null)&&this.lastCardRequestReasonCd.equals(rhs.lastCardRequestReasonCd))))&&((this.receiptVerificationDt == rhs.receiptVerificationDt)||((this.receiptVerificationDt!= null)&&this.receiptVerificationDt.equals(rhs.receiptVerificationDt))))&&((this.onCardName == rhs.onCardName)||((this.onCardName!= null)&&this.onCardName.equals(rhs.onCardName))))&&((this.lastCardRequestOperatorPartyId == rhs.lastCardRequestOperatorPartyId)||((this.lastCardRequestOperatorPartyId!= null)&&this.lastCardRequestOperatorPartyId.equals(rhs.lastCardRequestOperatorPartyId))))&&((this.numberOfTokenCnt == rhs.numberOfTokenCnt)||((this.numberOfTokenCnt!= null)&&this.numberOfTokenCnt.equals(rhs.numberOfTokenCnt))))&&((this.chipCardFeatureId == rhs.chipCardFeatureId)||((this.chipCardFeatureId!= null)&&this.chipCardFeatureId.equals(rhs.chipCardFeatureId))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.numberOfIssuingPrimaryCardsCnt == rhs.numberOfIssuingPrimaryCardsCnt)||((this.numberOfIssuingPrimaryCardsCnt!= null)&&this.numberOfIssuingPrimaryCardsCnt.equals(rhs.numberOfIssuingPrimaryCardsCnt))))&&((this.agreementToParty == rhs.agreementToParty)||((this.agreementToParty!= null)&&this.agreementToParty.equals(rhs.agreementToParty))))&&((this.receiptCardTypeCd == rhs.receiptCardTypeCd)||((this.receiptCardTypeCd!= null)&&this.receiptCardTypeCd.equals(rhs.receiptCardTypeCd))))&&((this.transferToCardNum == rhs.transferToCardNum)||((this.transferToCardNum!= null)&&this.transferToCardNum.equals(rhs.transferToCardNum))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.lastCompromisedAuthorizationReferralDt == rhs.lastCompromisedAuthorizationReferralDt)||((this.lastCompromisedAuthorizationReferralDt!= null)&&this.lastCompromisedAuthorizationReferralDt.equals(rhs.lastCompromisedAuthorizationReferralDt))))&&((this.cardRequestStatusCd == rhs.cardRequestStatusCd)||((this.cardRequestStatusCd!= null)&&this.cardRequestStatusCd.equals(rhs.cardRequestStatusCd))))&&((this.lastCompromisedAuthorizationApprovalDt == rhs.lastCompromisedAuthorizationApprovalDt)||((this.lastCompromisedAuthorizationApprovalDt!= null)&&this.lastCompromisedAuthorizationApprovalDt.equals(rhs.lastCompromisedAuthorizationApprovalDt))))&&((this.lastCardRequestDt == rhs.lastCardRequestDt)||((this.lastCardRequestDt!= null)&&this.lastCardRequestDt.equals(rhs.lastCardRequestDt))))&&((this.cardVerificationNum == rhs.cardVerificationNum)||((this.cardVerificationNum!= null)&&this.cardVerificationNum.equals(rhs.cardVerificationNum))))&&((this.onCardCompanyName == rhs.onCardCompanyName)||((this.onCardCompanyName!= null)&&this.onCardCompanyName.equals(rhs.onCardCompanyName))))&&((this.cardIssueDt == rhs.cardIssueDt)||((this.cardIssueDt!= null)&&this.cardIssueDt.equals(rhs.cardIssueDt))))&&((this.cardNumMasked == rhs.cardNumMasked)||((this.cardNumMasked!= null)&&this.cardNumMasked.equals(rhs.cardNumMasked))))&&((this.deviceTSYSExtension == rhs.deviceTSYSExtension)||((this.deviceTSYSExtension!= null)&&this.deviceTSYSExtension.equals(rhs.deviceTSYSExtension))));
    }

}
