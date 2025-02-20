package com.td.api.mbofp.response.retrievecampaign;

public class Channel {

    private String channelTypeCd;
    private String roleCd;

    public String getChannelTypeCd() {
        return channelTypeCd;
    }

    public void setChannelTypeCd(String channelTypeCd) {
        this.channelTypeCd = channelTypeCd;
    }

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Channel.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("channelTypeCd");
        sb.append('=');
        sb.append(((this.channelTypeCd == null)?"<null>":this.channelTypeCd));
        sb.append(',');
        sb.append("roleCd");
        sb.append('=');
        sb.append(((this.roleCd == null)?"<null>":this.roleCd));
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
        result = ((result* 31)+((this.roleCd == null)? 0 :this.roleCd.hashCode()));
        result = ((result* 31)+((this.channelTypeCd == null)? 0 :this.channelTypeCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Channel) == false) {
            return false;
        }
        Channel rhs = ((Channel) other);
        return (((this.roleCd == rhs.roleCd)||((this.roleCd!= null)&&this.roleCd.equals(rhs.roleCd)))&&((this.channelTypeCd == rhs.channelTypeCd)||((this.channelTypeCd!= null)&&this.channelTypeCd.equals(rhs.channelTypeCd))));
    }

}
