package com.td.api.mbpad.request.addconsent;

import com.td.api.mbnaap.common.CreditCardAgreementAltkey;

public class CreditCardAgreementPaymentInstruction {
	private CreditCardAgreementAltkey creditCardAgreementAltkey;
	private String paymentHoldConsentCd;
    private String paymentHoldDt;  
	private boolean confirmationLetterRequiredInd;
    
    public CreditCardAgreementAltkey getCreditCardAgreementAltkey() {
		return creditCardAgreementAltkey;
	}

    public void setCreditCardAgreementAltkey(
			CreditCardAgreementAltkey creditCardAgreementAltkey) {
		this.creditCardAgreementAltkey = creditCardAgreementAltkey;
	}
	
    public String getPaymentHoldConsentCd() {
		return paymentHoldConsentCd;
	}
	
    public void setPaymentHoldConsentCd(String paymentHoldConsentCd) {
		this.paymentHoldConsentCd = paymentHoldConsentCd;
	}
	
    public String getPaymentHoldDt() {
		return paymentHoldDt;
	}
	
    public void setPaymentHoldDt(String paymentHoldDt) {
		this.paymentHoldDt = paymentHoldDt;
	}
	
    public boolean isConfirmationLetterRequiredInd() {
		return confirmationLetterRequiredInd;
	}
	
    public boolean getConfirmationLetterRequiredInd() {
    	return confirmationLetterRequiredInd;
    }
    
    public void setConfirmationLetterRequiredInd(boolean confirmationLetterRequiredInd) {
		this.confirmationLetterRequiredInd = confirmationLetterRequiredInd;
	}
}
