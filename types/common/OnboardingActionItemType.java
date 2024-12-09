package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class OnboardingActionItemType implements Serializable {

	private static final long serialVersionUID = 7642457806249953038L;
    private Integer actionId;
    private String actionItemName;
    private String urlen;
    private String urlfr;
    private Integer order;
    private String omnitureView;
    private String omnitureDismiss;
    private String businessEventReasonView;
    private String businessEventReasonDismiss;

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionItemName() {
        return actionItemName;
    }

    public void setActionItemName(String actionItemName) {
        this.actionItemName = actionItemName;
    }

    public String getUrlen() {
        return urlen;
    }

    public void setUrlen(String urlen) {
        this.urlen = urlen;
    }

    public String getUrlfr() {
        return urlfr;
    }

    public void setUrlfr(String urlfr) {
        this.urlfr = urlfr;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getOmnitureView() {
        return omnitureView;
    }

    public void setOmnitureView(String omnitureView) {
        this.omnitureView = omnitureView;
    }

    public String getOmnitureDismiss() {
        return omnitureDismiss;
    }

    public void setOmnitureDismiss(String omnitureDismiss) {
        this.omnitureDismiss = omnitureDismiss;
    }

    public String getBusinessEventReasonView() {
        return businessEventReasonView;
    }

    public void setBusinessEventReasonView(String businessEventReasonView) {
        this.businessEventReasonView = businessEventReasonView;
    }

    public String getBusinessEventReasonDismiss() {
        return businessEventReasonDismiss;
    }

    public void setBusinessEventReasonDismiss(String businessEventReasonDismiss) {
        this.businessEventReasonDismiss = businessEventReasonDismiss;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OnboardingActionItemType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("actionId");
        sb.append('=');
        sb.append(((this.actionId == null)?"<null>":this.actionId));
        sb.append(',');
        sb.append("actionItemName");
        sb.append('=');
        sb.append(((this.actionItemName == null)?"<null>":this.actionItemName));
        sb.append(',');
        sb.append("urlen");
        sb.append('=');
        sb.append(((this.urlen == null)?"<null>":this.urlen));
        sb.append(',');
        sb.append("urlfr");
        sb.append('=');
        sb.append(((this.urlfr == null)?"<null>":this.urlfr));
        sb.append(',');
        sb.append("order");
        sb.append('=');
        sb.append(((this.order == null)?"<null>":this.order));
        sb.append(',');
        sb.append("omnitureView");
        sb.append('=');
        sb.append(((this.omnitureView == null)?"<null>":this.omnitureView));
        sb.append(',');
        sb.append("omnitureDismiss");
        sb.append('=');
        sb.append(((this.omnitureDismiss == null)?"<null>":this.omnitureDismiss));
        sb.append(',');
        sb.append("businessEventReasonView");
        sb.append('=');
        sb.append(((this.businessEventReasonView == null)?"<null>":this.businessEventReasonView));
        sb.append(',');
        sb.append("businessEventReasonDismiss");
        sb.append('=');
        sb.append(((this.businessEventReasonDismiss == null)?"<null>":this.businessEventReasonDismiss));
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
        result = ((result* 31)+((this.actionItemName == null)? 0 :this.actionItemName.hashCode()));
        result = ((result* 31)+((this.omnitureDismiss == null)? 0 :this.omnitureDismiss.hashCode()));
        result = ((result* 31)+((this.businessEventReasonView == null)? 0 :this.businessEventReasonView.hashCode()));
        result = ((result* 31)+((this.businessEventReasonDismiss == null)? 0 :this.businessEventReasonDismiss.hashCode()));
        result = ((result* 31)+((this.actionId == null)? 0 :this.actionId.hashCode()));
        result = ((result* 31)+((this.omnitureView == null)? 0 :this.omnitureView.hashCode()));
        result = ((result* 31)+((this.urlfr == null)? 0 :this.urlfr.hashCode()));
        result = ((result* 31)+((this.urlen == null)? 0 :this.urlen.hashCode()));
        result = ((result* 31)+((this.order == null)? 0 :this.order.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OnboardingActionItemType) == false) {
            return false;
        }
        OnboardingActionItemType rhs = ((OnboardingActionItemType) other);
        return ((((((((((this.actionItemName == rhs.actionItemName)||((this.actionItemName!= null)&&this.actionItemName.equals(rhs.actionItemName)))&&((this.omnitureDismiss == rhs.omnitureDismiss)||((this.omnitureDismiss!= null)&&this.omnitureDismiss.equals(rhs.omnitureDismiss))))&&((this.businessEventReasonView == rhs.businessEventReasonView)||((this.businessEventReasonView!= null)&&this.businessEventReasonView.equals(rhs.businessEventReasonView))))&&((this.businessEventReasonDismiss == rhs.businessEventReasonDismiss)||((this.businessEventReasonDismiss!= null)&&this.businessEventReasonDismiss.equals(rhs.businessEventReasonDismiss))))&&((this.actionId == rhs.actionId)||((this.actionId!= null)&&this.actionId.equals(rhs.actionId))))&&((this.omnitureView == rhs.omnitureView)||((this.omnitureView!= null)&&this.omnitureView.equals(rhs.omnitureView))))&&((this.urlfr == rhs.urlfr)||((this.urlfr!= null)&&this.urlfr.equals(rhs.urlfr))))&&((this.urlen == rhs.urlen)||((this.urlen!= null)&&this.urlen.equals(rhs.urlen))))&&((this.order == rhs.order)||((this.order!= null)&&this.order.equals(rhs.order))));
    }

}
