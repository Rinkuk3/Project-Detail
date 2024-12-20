package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * This class corresponds to individual rows in the ACCOUNTS table in the local database.
 *   
 */
public class KmsKeys implements Serializable{

	private static final long serialVersionUID = 1267407257906915260L;
	private Date effectiveDate;
	private String lookupKey;
	private String keyAlias;
	
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getLookupKey() {
		return lookupKey;
	}
	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}
	public String getKeyAlias() {
		return keyAlias;
	}
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 == null) {
			return false;
		}
		if (this == arg0) {
			return true;
		}
		if (!(arg0 instanceof KmsKeys)) {
			return false;
		}
		KmsKeys arg1 = (KmsKeys) arg0;
		long myTime = effectiveDate == null ? 0 : effectiveDate.getTime();
		long otherTime = arg1.getEffectiveDate() == null ? 0 : arg1.getEffectiveDate().getTime(); 
		if (myTime != otherTime) {
			return false;
		}
		if (lookupKey == null) {
			if (arg1.getLookupKey() != null) {
				return false;
			}
		}
		else {
			if (lookupKey.equals(arg1.getLookupKey()) == false) {
				return false;
			}
		}
		if (keyAlias == null) {
			return (arg1.getKeyAlias() == null); 
		}
		else {
			return keyAlias.equals(arg1.getKeyAlias());
		}
	}
	
	@Override
	public int hashCode() {
		int result;
	    result = (lookupKey != null ? lookupKey.hashCode() : 0);
	    result = 31 * result + (keyAlias != null ? keyAlias.hashCode() : 0);
	    result = 31 * result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
	    return result;
	}

}
