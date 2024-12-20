package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

/**
 * This class corresponds to individual rows in the PLASTICSCODE table in the local database.
 *   
 */
public class PlasticsCode implements Serializable {

	private static final long serialVersionUID = -7057116896121790563L;
	private String productCodes;
	private String language;
	private String poCode;
	private String pictureId;
	
	
	public String getProductCodes() {
		return productCodes;
	}
	public void setProductCodes(String productCodes) {
		this.productCodes = productCodes;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPoCode() {
		return poCode;
	}
	public void setPoCode(String poCode) {
		this.poCode = poCode;
	}
	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	
	public String toString() {
		return this.productCodes + " | " + this.poCode + " | " + this.pictureId;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 == null) {
			return false;
		}
		
		if (!(arg0 instanceof PlasticsCode)) {
			return false;
		}
		PlasticsCode arg1 = (PlasticsCode) arg0;
		return this.productCodes.equals(arg1.getProductCodes())
				&& this.language.equals(arg1.getLanguage())
				&& this.poCode.equals(arg1.getPoCode());

	}

	@Override
	public int hashCode() {
		int hsCode;
		hsCode = productCodes.hashCode();
		hsCode = 19 * hsCode + language.hashCode();
		hsCode = 19 * hsCode + poCode.hashCode();
		return hsCode;
	}
}