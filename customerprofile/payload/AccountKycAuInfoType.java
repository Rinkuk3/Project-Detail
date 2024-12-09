package com.td.mbna.msec.midtier.customerprofile.payload;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;
import com.td.mbna.msec.midtier.types.common.UserNameType;

import java.io.Serializable;

public class AccountKycAuInfoType implements Serializable {

	private static final long serialVersionUID = -5294559659782308842L;
    private UserNameType kycAuName;
    private String kycAuBirthDate;
    private String kycAliasCustomerID;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long kycPersonLastUpdatedTS;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long kycBookOfBusLastUpdatedTS;

    private CustomerAcctInfoType kycAuCustAcctInfo;

    public UserNameType getKycAuName() {
        return kycAuName;
    }

    public void setKycAuName(UserNameType kycAuName) {
        this.kycAuName = kycAuName;
    }

    public String getKycAuBirthDate() {
        return kycAuBirthDate;
    }

    public void setKycAuBirthDate(String kycAuBirthDate) {
        this.kycAuBirthDate = kycAuBirthDate;
    }

    public String getKycAliasCustomerID() {
        return kycAliasCustomerID;
    }

    public void setKycAliasCustomerID(String kycAliasCustomerID) {
        this.kycAliasCustomerID = kycAliasCustomerID;
    }

    public Long getKycPersonLastUpdatedTS() {
        return kycPersonLastUpdatedTS;
    }

    public void setKycPersonLastUpdatedTS(Long kycPersonLastUpdatedTS) {
        this.kycPersonLastUpdatedTS = kycPersonLastUpdatedTS;
    }

    public Long getKycBookOfBusLastUpdatedTS() {
        return kycBookOfBusLastUpdatedTS;
    }

    public void setKycBookOfBusLastUpdatedTS(Long kycBookOfBusLastUpdatedTS) {
        this.kycBookOfBusLastUpdatedTS = kycBookOfBusLastUpdatedTS;
    }

    public CustomerAcctInfoType getKycAuCustAcctInfo() {
        return kycAuCustAcctInfo;
    }

    public void setKycAuCustAcctInfo(CustomerAcctInfoType kycAuCustAcctInfo) {
        this.kycAuCustAcctInfo = kycAuCustAcctInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AccountKycAuInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("kycAuName");
        sb.append('=');
        sb.append(((this.kycAuName == null)?"<null>":this.kycAuName));
        sb.append(',');
        sb.append("kycAuBirthDate");
        sb.append('=');
        sb.append(((this.kycAuBirthDate == null)?"<null>":this.kycAuBirthDate));
        sb.append(',');
        sb.append("kycAliasCustomerID");
        sb.append('=');
        sb.append(((this.kycAliasCustomerID == null)?"<null>":this.kycAliasCustomerID));
        sb.append(',');
        sb.append("kycPersonLastUpdatedTS");
        sb.append('=');
        sb.append(((this.kycPersonLastUpdatedTS == null)?"<null>":this.kycPersonLastUpdatedTS));
        sb.append(',');
        sb.append("kycBookOfBusLastUpdatedTS");
        sb.append('=');
        sb.append(((this.kycBookOfBusLastUpdatedTS == null)?"<null>":this.kycBookOfBusLastUpdatedTS));
        sb.append(',');
        sb.append("kycAuCustAcctInfo");
        sb.append('=');
        sb.append(((this.kycAuCustAcctInfo == null)?"<null>":this.kycAuCustAcctInfo));
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
        result = ((result* 31)+((this.kycPersonLastUpdatedTS == null)? 0 :this.kycPersonLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.kycAuCustAcctInfo == null)? 0 :this.kycAuCustAcctInfo.hashCode()));
        result = ((result* 31)+((this.kycAuName == null)? 0 :this.kycAuName.hashCode()));
        result = ((result* 31)+((this.kycBookOfBusLastUpdatedTS == null)? 0 :this.kycBookOfBusLastUpdatedTS.hashCode()));
        result = ((result* 31)+((this.kycAliasCustomerID == null)? 0 :this.kycAliasCustomerID.hashCode()));
        result = ((result* 31)+((this.kycAuBirthDate == null)? 0 :this.kycAuBirthDate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccountKycAuInfoType) == false) {
            return false;
        }
        AccountKycAuInfoType rhs = ((AccountKycAuInfoType) other);
        return (((((((this.kycPersonLastUpdatedTS == rhs.kycPersonLastUpdatedTS)||((this.kycPersonLastUpdatedTS!= null)&&this.kycPersonLastUpdatedTS.equals(rhs.kycPersonLastUpdatedTS)))&&((this.kycAuCustAcctInfo == rhs.kycAuCustAcctInfo)||((this.kycAuCustAcctInfo!= null)&&this.kycAuCustAcctInfo.equals(rhs.kycAuCustAcctInfo))))&&((this.kycAuName == rhs.kycAuName)||((this.kycAuName!= null)&&this.kycAuName.equals(rhs.kycAuName))))&&((this.kycBookOfBusLastUpdatedTS == rhs.kycBookOfBusLastUpdatedTS)||((this.kycBookOfBusLastUpdatedTS!= null)&&this.kycBookOfBusLastUpdatedTS.equals(rhs.kycBookOfBusLastUpdatedTS))))&&((this.kycAliasCustomerID == rhs.kycAliasCustomerID)||((this.kycAliasCustomerID!= null)&&this.kycAliasCustomerID.equals(rhs.kycAliasCustomerID))))&&((this.kycAuBirthDate == rhs.kycAuBirthDate)||((this.kycAuBirthDate!= null)&&this.kycAuBirthDate.equals(rhs.kycAuBirthDate))));
    }

}
