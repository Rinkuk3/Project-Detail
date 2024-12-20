package com.td.api.enrollment.retrieve;

import java.util.ArrayList;
import java.util.List;

public class RetrieveProductCustomer {

    private List<ProductCustomer> productCustomer = new ArrayList<ProductCustomer>();

    public List<ProductCustomer> getProductCustomer() {
        return productCustomer;
    }

    public void setProductCustomer(List<ProductCustomer> productCustomer) {
        this.productCustomer = productCustomer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveProductCustomer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productCustomer");
        sb.append('=');
        sb.append(((this.productCustomer == null)?"<null>":this.productCustomer));
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
        result = ((result* 31)+((this.productCustomer == null)? 0 :this.productCustomer.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveProductCustomer) == false) {
            return false;
        }
        RetrieveProductCustomer rhs = ((RetrieveProductCustomer) other);
        return ((this.productCustomer == rhs.productCustomer)||((this.productCustomer!= null)&&this.productCustomer.equals(rhs.productCustomer)));
    }

}
