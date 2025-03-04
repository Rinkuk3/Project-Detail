package com.td.mbna.msec.midtier.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.mbnaweb.xsd.types.common.BTOfferType;

public class OffersUtil {
	
    // Normalize the fee values based on the idiosyncrasies of the values returned from TSYS or product catalog
    // Note null and zero values are different when used in fee calculations.
    //
    public static void marshalBtOffer(BTOfferType btOffer, final BigDecimal AltNullMin, final BigDecimal AltNullMax) {
    	if (btOffer == null) {
    		return;
    	}
    	if (btOffer.getRate() != null) {
    		btOffer.setRate(btOffer.getRate().setScale(2, RoundingMode.HALF_EVEN));
    	}
    	
    	BigDecimal minFee = btOffer.getMinimumFeeAmount();

    	
    	if (minFee != null && (AltNullMin != null && minFee.compareTo(AltNullMin) == 0)) {
    		btOffer.setMinimumFeeAmount(null);
    	}

    	
    	BigDecimal maxFee = btOffer.getMaximumFeeAmount();
    	if (maxFee != null && (maxFee.compareTo(BigDecimal.ZERO) == 0 || (AltNullMax != null && maxFee.compareTo(AltNullMax) == 0))) {
    		btOffer.setMaximumFeeAmount(null);
    	}
  


    	BigDecimal fixedFee = btOffer.getFixedFeeAmount();
    	if (fixedFee == null || fixedFee.compareTo(BigDecimal.ZERO) == 0) {
    		if (btOffer.getFeePercentage() == null) {
    			btOffer.setFixedFeeAmount(BigDecimal.ZERO);
    		}
    		else {
    			btOffer.setFixedFeeAmount(null);
    		}
    	}
    }
    

}