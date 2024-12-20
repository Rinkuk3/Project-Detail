package com.td.api.mbcca.response.account.featureview;

public class RetrieveCreditCardAgreementFeaturesViewRs {

    private FeatureView featureView;

    public FeatureView getFeatureView() {
        return featureView;
    }

    public void setFeatureView(FeatureView featureView) {
        this.featureView = featureView;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementFeaturesViewRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("featureView");
        sb.append('=');
        sb.append(((this.featureView == null)?"<null>":this.featureView));
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
        result = ((result* 31)+((this.featureView == null)? 0 :this.featureView.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementFeaturesViewRs) == false) {
            return false;
        }
        RetrieveCreditCardAgreementFeaturesViewRs rhs = ((RetrieveCreditCardAgreementFeaturesViewRs) other);
        return ((this.featureView == rhs.featureView)||((this.featureView!= null)&&this.featureView.equals(rhs.featureView)));
    }

}
