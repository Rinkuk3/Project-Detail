package com.td.api.mbcca.request.cancelip;

public class OriginalAuthorizationEvent {

    private String terminalChannelTypeCd;
    private String mailTelephoneOrderTransactionCd;
    private String merchantPointOfServiceTerminalCapabilityCd;
    private String merchantPointOfServiceTerminalEntryCd;

    public String getTerminalChannelTypeCd() {
        return terminalChannelTypeCd;
    }

    public void setTerminalChannelTypeCd(String terminalChannelTypeCd) {
        this.terminalChannelTypeCd = terminalChannelTypeCd;
    }

    public String getMailTelephoneOrderTransactionCd() {
        return mailTelephoneOrderTransactionCd;
    }

    public void setMailTelephoneOrderTransactionCd(String mailTelephoneOrderTransactionCd) {
        this.mailTelephoneOrderTransactionCd = mailTelephoneOrderTransactionCd;
    }

    public String getMerchantPointOfServiceTerminalCapabilityCd() {
        return merchantPointOfServiceTerminalCapabilityCd;
    }

    public void setMerchantPointOfServiceTerminalCapabilityCd(String merchantPointOfServiceTerminalCapabilityCd) {
        this.merchantPointOfServiceTerminalCapabilityCd = merchantPointOfServiceTerminalCapabilityCd;
    }

    public String getMerchantPointOfServiceTerminalEntryCd() {
        return merchantPointOfServiceTerminalEntryCd;
    }

    public void setMerchantPointOfServiceTerminalEntryCd(String merchantPointOfServiceTerminalEntryCd) {
        this.merchantPointOfServiceTerminalEntryCd = merchantPointOfServiceTerminalEntryCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OriginalAuthorizationEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("terminalChannelTypeCd");
        sb.append('=');
        sb.append(((this.terminalChannelTypeCd == null)?"<null>":this.terminalChannelTypeCd));
        sb.append(',');
        sb.append("mailTelephoneOrderTransactionCd");
        sb.append('=');
        sb.append(((this.mailTelephoneOrderTransactionCd == null)?"<null>":this.mailTelephoneOrderTransactionCd));
        sb.append(',');
        sb.append("merchantPointOfServiceTerminalCapabilityCd");
        sb.append('=');
        sb.append(((this.merchantPointOfServiceTerminalCapabilityCd == null)?"<null>":this.merchantPointOfServiceTerminalCapabilityCd));
        sb.append(',');
        sb.append("merchantPointOfServiceTerminalEntryCd");
        sb.append('=');
        sb.append(((this.merchantPointOfServiceTerminalEntryCd == null)?"<null>":this.merchantPointOfServiceTerminalEntryCd));
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
        result = ((result* 31)+((this.terminalChannelTypeCd == null)? 0 :this.terminalChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.mailTelephoneOrderTransactionCd == null)? 0 :this.mailTelephoneOrderTransactionCd.hashCode()));
        result = ((result* 31)+((this.merchantPointOfServiceTerminalEntryCd == null)? 0 :this.merchantPointOfServiceTerminalEntryCd.hashCode()));
        result = ((result* 31)+((this.merchantPointOfServiceTerminalCapabilityCd == null)? 0 :this.merchantPointOfServiceTerminalCapabilityCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OriginalAuthorizationEvent) == false) {
            return false;
        }
        OriginalAuthorizationEvent rhs = ((OriginalAuthorizationEvent) other);
        return (((((this.terminalChannelTypeCd == rhs.terminalChannelTypeCd)||((this.terminalChannelTypeCd!= null)&&this.terminalChannelTypeCd.equals(rhs.terminalChannelTypeCd)))&&((this.mailTelephoneOrderTransactionCd == rhs.mailTelephoneOrderTransactionCd)||((this.mailTelephoneOrderTransactionCd!= null)&&this.mailTelephoneOrderTransactionCd.equals(rhs.mailTelephoneOrderTransactionCd))))&&((this.merchantPointOfServiceTerminalEntryCd == rhs.merchantPointOfServiceTerminalEntryCd)||((this.merchantPointOfServiceTerminalEntryCd!= null)&&this.merchantPointOfServiceTerminalEntryCd.equals(rhs.merchantPointOfServiceTerminalEntryCd))))&&((this.merchantPointOfServiceTerminalCapabilityCd == rhs.merchantPointOfServiceTerminalCapabilityCd)||((this.merchantPointOfServiceTerminalCapabilityCd!= null)&&this.merchantPointOfServiceTerminalCapabilityCd.equals(rhs.merchantPointOfServiceTerminalCapabilityCd))));
    }

}
