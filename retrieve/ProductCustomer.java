package com.td.api.enrollment.retrieve;

import java.util.ArrayList;
import java.util.List;

public class ProductCustomer {

    private String connectId;
    private String productVal;
    private String productCd;
    private List<Relationship> relationship = new ArrayList<Relationship>();

    public String getConnectId() {
        return connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public String getProductVal() {
        return productVal;
    }

    public void setProductVal(String productVal) {
        this.productVal = productVal;
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    public List<Relationship> getRelationship() {
        return relationship;
    }

    public void setRelationship(List<Relationship> relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProductCustomer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connectId");
        sb.append('=');
        sb.append(((this.connectId == null)?"<null>":this.connectId));
        sb.append(',');
        sb.append("productVal");
        sb.append('=');
        sb.append(((this.productVal == null)?"<null>":this.productVal));
        sb.append(',');
        sb.append("productCd");
        sb.append('=');
        sb.append(((this.productCd == null)?"<null>":this.productCd));
        sb.append(',');
        sb.append("relationship");
        sb.append('=');
        sb.append(((this.relationship == null)?"<null>":this.relationship));
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
        result = ((result* 31)+((this.connectId == null)? 0 :this.connectId.hashCode()));
        result = ((result* 31)+((this.relationship == null)? 0 :this.relationship.hashCode()));
        result = ((result* 31)+((this.productVal == null)? 0 :this.productVal.hashCode()));
        result = ((result* 31)+((this.productCd == null)? 0 :this.productCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductCustomer) == false) {
            return false;
        }
        ProductCustomer rhs = ((ProductCustomer) other);
        return (((((this.connectId == rhs.connectId)||((this.connectId!= null)&&this.connectId.equals(rhs.connectId)))&&((this.relationship == rhs.relationship)||((this.relationship!= null)&&this.relationship.equals(rhs.relationship))))&&((this.productVal == rhs.productVal)||((this.productVal!= null)&&this.productVal.equals(rhs.productVal))))&&((this.productCd == rhs.productCd)||((this.productCd!= null)&&this.productCd.equals(rhs.productCd))));
    }

}
