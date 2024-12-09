package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class TtcDestinationsInfoType implements Serializable {

	private static final long serialVersionUID = -1466086549500972242L;
    private Integer ttcDestinationId;
    private String nickname;
    private String accountEnding;

    public Integer getTtcDestinationId() {
        return ttcDestinationId;
    }

    public void setTtcDestinationId(Integer ttcDestinationId) {
        this.ttcDestinationId = ttcDestinationId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccountEnding() {
        return accountEnding;
    }

    public void setAccountEnding(String accountEnding) {
        this.accountEnding = accountEnding;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TtcDestinationsInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ttcDestinationId");
        sb.append('=');
        sb.append(((this.ttcDestinationId == null)?"<null>":this.ttcDestinationId));
        sb.append(',');
        sb.append("nickname");
        sb.append('=');
        sb.append(((this.nickname == null)?"<null>":this.nickname));
        sb.append(',');
        sb.append("accountEnding");
        sb.append('=');
        sb.append(((this.accountEnding == null)?"<null>":this.accountEnding));
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
        result = ((result* 31)+((this.ttcDestinationId == null)? 0 :this.ttcDestinationId.hashCode()));
        result = ((result* 31)+((this.nickname == null)? 0 :this.nickname.hashCode()));
        result = ((result* 31)+((this.accountEnding == null)? 0 :this.accountEnding.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TtcDestinationsInfoType) == false) {
            return false;
        }
        TtcDestinationsInfoType rhs = ((TtcDestinationsInfoType) other);
        return ((((this.ttcDestinationId == rhs.ttcDestinationId)||((this.ttcDestinationId!= null)&&this.ttcDestinationId.equals(rhs.ttcDestinationId)))&&((this.nickname == rhs.nickname)||((this.nickname!= null)&&this.nickname.equals(rhs.nickname))))&&((this.accountEnding == rhs.accountEnding)||((this.accountEnding!= null)&&this.accountEnding.equals(rhs.accountEnding))));
    }

}
