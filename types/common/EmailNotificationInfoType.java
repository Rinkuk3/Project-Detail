package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class EmailNotificationInfoType implements Serializable {

	private static final long serialVersionUID = -5678583865666819414L;
	
    private String primaryUserEmailAddress;
    private String primaryUserLanguage;
    private String primaryUserFirstName;
    private String primaryUserMiddleName;
    private String primaryUserLastName;
    private String primaryCustId;
    private String cardName;
    private String cardEnding;
    private String currentUserFirstName;
    private String currentUserLastName;
    private String primaryUserCardEnding;
    private String oldEmailAddressChange;
    private Boolean sendEmail;

    public String getPrimaryUserEmailAddress() {
        return primaryUserEmailAddress;
    }

    public void setPrimaryUserEmailAddress(String primaryUserEmailAddress) {
        this.primaryUserEmailAddress = primaryUserEmailAddress;
    }

    public String getPrimaryUserLanguage() {
        return primaryUserLanguage;
    }

    public void setPrimaryUserLanguage(String primaryUserLanguage) {
        this.primaryUserLanguage = primaryUserLanguage;
    }

    public String getPrimaryUserFirstName() {
        return primaryUserFirstName;
    }

    public void setPrimaryUserFirstName(String primaryUserFirstName) {
        this.primaryUserFirstName = primaryUserFirstName;
    }

    public String getPrimaryUserMiddleName() {
        return primaryUserMiddleName;
    }

    public void setPrimaryUserMiddleName(String primaryUserMiddleName) {
        this.primaryUserMiddleName = primaryUserMiddleName;
    }

    public String getPrimaryUserLastName() {
        return primaryUserLastName;
    }

    public void setPrimaryUserLastName(String primaryUserLastName) {
        this.primaryUserLastName = primaryUserLastName;
    }

    public String getPrimaryCustId() {
		return primaryCustId;
	}

	public void setPrimaryCustId(String primaryCustId) {
		this.primaryCustId = primaryCustId;
	}

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardEnding() {
        return cardEnding;
    }

    public void setCardEnding(String cardEnding) {
        this.cardEnding = cardEnding;
    }

    public String getCurrentUserFirstName() {
		return currentUserFirstName;
	}

	public void setCurrentUserFirstName(String currentUserFirstName) {
		this.currentUserFirstName = currentUserFirstName;
	}

	public String getCurrentUserLastName() {
		return currentUserLastName;
	}

	public void setCurrentUserLastName(String currentUserLastName) {
		this.currentUserLastName = currentUserLastName;
	}

	public String getPrimaryUserCardEnding() {
		return primaryUserCardEnding;
	}

	public void setPrimaryUserCardEnding(String primaryUserCardEnding) {
		this.primaryUserCardEnding = primaryUserCardEnding;
	}

    public String getOldEmailAddressChange() {
        return oldEmailAddressChange;
    }

    public void setOldEmailAddressChange(String oldEmailAddressChange) {
        this.oldEmailAddressChange = oldEmailAddressChange;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EmailNotificationInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("primaryUserEmailAddress");
        sb.append('=');
        sb.append(((this.primaryUserEmailAddress == null)?"<null>":this.primaryUserEmailAddress));
        sb.append(',');
        sb.append("primaryUserLanguage");
        sb.append('=');
        sb.append(((this.primaryUserLanguage == null)?"<null>":this.primaryUserLanguage));
        sb.append(',');
        sb.append("primaryUserFirstName");
        sb.append('=');
        sb.append(((this.primaryUserFirstName == null)?"<null>":this.primaryUserFirstName));
        sb.append(',');
        sb.append("primaryUserMiddleName");
        sb.append('=');
        sb.append(((this.primaryUserMiddleName == null)?"<null>":this.primaryUserMiddleName));
        sb.append(',');
        sb.append("primaryUserLastName");
        sb.append('=');
        sb.append(((this.primaryUserLastName == null)?"<null>":this.primaryUserLastName));
        sb.append(',');
        sb.append("primaryCustId");
        sb.append('=');
        sb.append(((this.primaryCustId == null)?"<null>":this.primaryCustId));
        sb.append(',');
        sb.append("cardName");
        sb.append('=');
        sb.append(((this.cardName == null)?"<null>":this.cardName));
        sb.append(',');
        sb.append("cardEnding");
        sb.append('=');
        sb.append(((this.cardEnding == null)?"<null>":this.cardEnding));
        sb.append(',');
        sb.append("currentUserFirstName");
        sb.append('=');
        sb.append(((this.currentUserFirstName == null)?"<null>":this.currentUserFirstName));
        sb.append(',');
        sb.append("currentUserLastName");
        sb.append('=');
        sb.append(((this.currentUserLastName == null)?"<null>":this.currentUserLastName));
        sb.append(',');
        sb.append("primaryUserCardEnding");
        sb.append('=');
        sb.append(((this.primaryUserCardEnding == null)?"<null>":this.primaryUserCardEnding));
        sb.append(',');
        sb.append("oldEmailAddressChange");
        sb.append('=');
        sb.append(((this.oldEmailAddressChange == null)?"<null>":this.oldEmailAddressChange));
        sb.append(',');
        sb.append("sendEmail");
        sb.append('=');
        sb.append(((this.sendEmail == null)?"<null>":this.sendEmail));
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
        result = ((result* 31)+((this.primaryUserFirstName == null)? 0 :this.primaryUserFirstName.hashCode()));
        result = ((result* 31)+((this.primaryUserMiddleName == null)? 0 :this.primaryUserMiddleName.hashCode()));
        result = ((result* 31)+((this.primaryUserLastName == null)? 0 :this.primaryUserLastName.hashCode()));
        result = ((result* 31)+((this.primaryUserEmailAddress == null)? 0 :this.primaryUserEmailAddress.hashCode()));
        result = ((result* 31)+((this.primaryCustId == null)? 0 :this.primaryCustId.hashCode()));
        result = ((result* 31)+((this.cardEnding == null)? 0 :this.cardEnding.hashCode()));
        result = ((result* 31)+((this.sendEmail == null)? 0 :this.sendEmail.hashCode()));
        result = ((result* 31)+((this.primaryUserLanguage == null)? 0 :this.primaryUserLanguage.hashCode()));
        result = ((result* 31)+((this.cardName == null)? 0 :this.cardName.hashCode()));
        result = ((result* 31)+((this.currentUserFirstName == null)? 0 :this.currentUserFirstName.hashCode()));
        result = ((result* 31)+((this.currentUserLastName == null)? 0 :this.currentUserLastName.hashCode()));
        result = ((result* 31)+((this.primaryUserCardEnding == null)? 0 :this.primaryUserCardEnding.hashCode()));
        result = ((result* 31)+((this.oldEmailAddressChange == null)? 0 :this.oldEmailAddressChange.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EmailNotificationInfoType) == false) {
            return false;
        }
        EmailNotificationInfoType rhs = ((EmailNotificationInfoType) other);
        return ((((((((((((((this.primaryUserMiddleName == rhs.primaryUserMiddleName)||((this.primaryUserMiddleName!= null)&&this.primaryUserMiddleName.equals(rhs.primaryUserMiddleName)))&&((this.primaryUserFirstName == rhs.primaryUserFirstName)||((this.primaryUserFirstName!= null)&&this.primaryUserFirstName.equals(rhs.primaryUserFirstName))))&&((this.cardEnding == rhs.cardEnding)||((this.cardEnding!= null)&&this.cardEnding.equals(rhs.cardEnding))))&&((this.sendEmail == rhs.sendEmail)||((this.sendEmail!= null)&&this.sendEmail.equals(rhs.sendEmail))))&&((this.primaryUserLanguage == rhs.primaryUserLanguage)||((this.primaryUserLanguage!= null)&&this.primaryUserLanguage.equals(rhs.primaryUserLanguage))))&&((this.cardName == rhs.cardName)||((this.cardName!= null)&&this.cardName.equals(rhs.cardName))))&&((this.primaryUserEmailAddress == rhs.primaryUserEmailAddress)||((this.primaryUserEmailAddress!= null)&&this.primaryUserEmailAddress.equals(rhs.primaryUserEmailAddress))))&&((this.primaryUserLastName == rhs.primaryUserLastName)||((this.primaryUserLastName!= null)&&this.primaryUserLastName.equals(rhs.primaryUserLastName))))&&((this.oldEmailAddressChange == rhs.oldEmailAddressChange)||((this.oldEmailAddressChange!= null)&&this.oldEmailAddressChange.equals(rhs.oldEmailAddressChange))))&&((this.currentUserFirstName == rhs.currentUserFirstName)||((this.currentUserFirstName!= null)&&this.currentUserFirstName.equals(rhs.currentUserFirstName))))&&((this.currentUserLastName == rhs.currentUserLastName)||((this.currentUserLastName!= null)&&this.currentUserLastName.equals(rhs.currentUserLastName))))&&((this.primaryUserCardEnding == rhs.primaryUserCardEnding)||((this.primaryUserCardEnding!= null)&&this.primaryUserCardEnding.equals(rhs.primaryUserCardEnding))))&&((this.primaryCustId == rhs.primaryCustId)||((this.primaryCustId!= null)&&this.primaryCustId.equals(rhs.primaryCustId))));
    }

}
