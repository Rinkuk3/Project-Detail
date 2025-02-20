package com.td.api.mbofp.response.updateofferdisposition;

public class UpdateOfferDispositionResponse {

    private PartyResponse partyResponse;

    public PartyResponse getPartyResponse() {
        return partyResponse;
    }

    public void setPartyResponse(PartyResponse partyResponse) {
        this.partyResponse = partyResponse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UpdateOfferDispositionResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("partyResponse");
        sb.append('=');
        sb.append(((this.partyResponse == null)?"<null>":this.partyResponse));
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
        result = ((result* 31)+((this.partyResponse == null)? 0 :this.partyResponse.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateOfferDispositionResponse) == false) {
            return false;
        }
        UpdateOfferDispositionResponse rhs = ((UpdateOfferDispositionResponse) other);
        return ((this.partyResponse == rhs.partyResponse)||((this.partyResponse!= null)&&this.partyResponse.equals(rhs.partyResponse)));
    }

}
