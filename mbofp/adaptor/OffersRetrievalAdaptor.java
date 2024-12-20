package com.td.mbna.msec.midtier.mbofp.adaptor;

import com.td.api.mbofp.response.retrieveofferlist.Offer;
import com.td.api.mbofp.response.retrieveofferlist.RetrieveOfferListRs;
import com.td.api.mbofp.shared.Rate;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersResponse;
import com.td.mbna.msec.midtier.types.common.BTOfferType;
import com.td.mbna.msec.midtier.types.common.CAOfferType;
import com.td.mbna.msec.midtier.types.common.CLIOfferType;
import com.td.mbna.msec.midtier.types.common.IPOfferType;
import com.td.mbna.msec.midtier.types.common.IPRate;
import com.td.mbna.msec.midtier.types.common.PCOfferType;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;
import com.td.mbna.msec.midtier.types.common.ROfferType;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OffersRetrievalAdaptor extends MbnaOfpAdaptor {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static MbnaLogger logger = new MbnaLogger(OffersRetrievalAdaptor.class);

    public RetrieveOffersResponse getResponse(RetrieveOfferListRs offerListRs, Map<String, String> params) {
        String strCreditLimit = params.get(MSECConstants.TD_OFP_API_CREDIT_LIMIT);
        BigDecimal creditLimitAmt = BigDecimal.ZERO;
        if (strCreditLimit != null && strCreditLimit.trim().length() > 0) {
            creditLimitAmt = new BigDecimal(strCreditLimit);
        }
        List<PromotionOfferType> promotionOffer = new ArrayList<>();

        com.td.mbna.msec.midtier.offers.payload.retrieveoffers.ResponsePayload responsePayload = new com.td.mbna.msec.midtier.offers.payload.retrieveoffers.ResponsePayload();
        responsePayload.setPromotionOffer(promotionOffer);

        RetrieveOffersResponse response = new RetrieveOffersResponse();
        response.setResponsePayload(responsePayload);
        if (offerListRs == null || offerListRs.getOffer() == null || offerListRs.getOffer().size() == 0) {
            return response;
        }
        logger.mandatory("Total # of offers: "+offerListRs.getOffer().size());


        for (Offer o : offerListRs.getOffer()) {
        	if (toFilterOut(o)){
        		continue;
        	}
        	
            PromotionOfferType offer = new PromotionOfferType();
            offer.setOfferID(o.getOfferId());
            offer.setOfferDescription(o.getOfferDesc());
            
            if (o.getPromotionOfferDispositionCd() != null){
            	offer.setDisposition(o.getPromotionOfferDispositionCd());
            } else {
            	offer.setDisposition("");
            }
            logger.mandatory("OffersUtil :: doRetrieveOffers :: dumpOffer: "+ offer.toString());
            
            com.td.api.mbofp.response.retrieveofferlist.Promotion promotion = o.getPromotion();
            if (promotion != null) {
                offer.setSubProductId(o.getPromotion().getPromotionId());
                if (promotion.getPromotionType() != null) {
                	String offerType = offerTypeMap.get(promotion.getPromotionType().getTypeCd());
                	if (offerType == null){
                		offerType = "";
                	}
                	
                    offer.setOfferType(offerType);
                    offer.setAgreementFeature(offerType);
                    offer.setSubProductType(promotion.getPromotionType().getTypeCd());
                    offer.setSubProductDescription(promotion.getPromotionType().getTypeDesc());
                }
            }
            // disclosureTemplateId

            BTOfferType btOffer = null;
            CLIOfferType cliOffer = null;
            IPOfferType ipOffer = null;
            PCOfferType pcOffer = null;
            CAOfferType caOffer = null;
            ROfferType roffer = null;
            
            if (OFP_OFFER_TYPE_BT.equals(offer.getSubProductType())) {
                if (promotion != null && promotion.getFeatureGroup() != null) {
                    btOffer = new BTOfferType();
                	btOffer.setDuration(0);
                    if (promotion.getFeatureGroup().getRate() != null && promotion.getFeatureGroup().getRate().size() > 0) {
                        com.td.api.mbofp.shared.Rate rate = promotion.getFeatureGroup().getRate().get(0);
                        if (rate != null) {
                            btOffer.setRate(rate.getFixedRate());
                            Long endDate = null;
                            if (rate.getPromotionTerm() != null){
                            	if (rate.getPromotionTerm().getFixedEndDt() != null) {
	            					try {
	                                    DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	                                    Date end_date;
	            						end_date = df.parse(rate.getPromotionTerm().getFixedEndDt());
	                                    endDate = end_date.getTime();
	            					} catch (ParseException e) {
	            						endDate = null;
	            					}
                            	}
                            	btOffer.setExpiryDate(endDate);
                            	if (rate.getPromotionTerm().getUntilAgeNum() != null){
	            					try {
	            						btOffer.setDuration(Integer.valueOf(rate.getPromotionTerm().getUntilAgeNum()));
	            					} catch (NumberFormatException e) {
	            						btOffer.setDuration(0);
	            					}
                            	}
                            }
                        }
                    }

                    com.td.api.mbofp.shared.Fee fee = promotion.getFeatureGroup().getFee();
                    if (fee != null) {
                        btOffer.setFixedFeeAmount(fee.getFixedFeeAmt());
                        if (fee.getPercentageBasedFee() != null) {
                            btOffer.setFeePercentage(fee.getPercentageBasedFee().getPercentageRate());
                            btOffer.setMaximumFeeAmount(fee.getPercentageBasedFee().getUpperLimitAmt());
                            btOffer.setMinimumFeeAmount(fee.getPercentageBasedFee().getLowerLimitAmt());
                        }
                    }
                }/*
                btOffer.setEarlyExpired(earlyExpired);
                btOffer.setEligibleNegotiatedType(eligibleNegotiatedType);*/
            } else if (OFP_OFFER_TYPE_CLI.equals(offer.getSubProductType())) {
                if (promotion != null && promotion.getFeatureGroup() != null) {
                    cliOffer = new CLIOfferType();
                    cliOffer.setCliAmount(creditLimitAmt);
                    if (promotion.getFeatureGroup().getCreditLimit() != null && promotion.getFeatureGroup().getCreditLimit().size() > 0) {
                        com.td.api.mbofp.response.retrieveofferlist.CreditLimit creditLimit = promotion.getFeatureGroup().getCreditLimit().get(0);
                        if (creditLimit != null && creditLimit.getCreditLimitAmt() != null) {
                            cliOffer.setCliAmount(creditLimitAmt.add(creditLimit.getCreditLimitAmt()));
                        }
                    }
                }
            } else if (OFP_OFFER_TYPE_IP.equals(offer.getSubProductType())) {
                if (promotion != null && promotion.getFeatureGroup() != null) {
                    ipOffer = new IPOfferType();
                    
                    if (promotion.getFeatureGroup().getRate() != null && promotion.getFeatureGroup().getRate().size() > 0) {
                    	Rate r = promotion.getFeatureGroup().getRate().get(0);
                		IPRate ipRate = new IPRate();
                		ipRate.setFixedRate(r.getFixedRate());//BigDecimal.ZERO);//ZERO for MVP1
                		ipRate.setUntilAgeCd(r.getPromotionTerm().getUntilAgeCd());
                		ipRate.setUntilAgeNum(r.getPromotionTerm().getUntilAgeNum());
                		ipOffer.getRate().add(ipRate);
                    }

                    com.td.api.mbofp.shared.Fee fee = promotion.getFeatureGroup().getFee();
                    if (fee != null) {
                        ipOffer.setFixedFeeAmount(fee.getFixedFeeAmt());
                        if (fee.getPercentageBasedFee() != null) {
                            ipOffer.setFeePercentage(fee.getPercentageBasedFee().getPercentageRate());
                            ipOffer.setMaximumFeeAmount(fee.getPercentageBasedFee().getUpperLimitAmt());
                            ipOffer.setMinimumFeeAmount(fee.getPercentageBasedFee().getLowerLimitAmt());
                        }
                    }
                }

                Long endDate = null;
                if (o.getFeatureGroup() != null && o.getFeatureGroup().getTowTerm() != null && o.getFeatureGroup().getTowTerm().getFixedEndDt() != null) {
					try {
                        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                        Date end_date;
						end_date = df.parse(o.getFeatureGroup().getTowTerm().getFixedEndDt());
                        endDate = end_date.getTime();
					} catch (ParseException e) {
						endDate = null;
					}
                }

                ipOffer.setExpiryDate(endDate);/*
                ipOffer.setEarlyExpired(earlyExpired);
                ipOffer.setDuration(duration);
                ipOffer.setEligibleNegotiatedType(eligibleNegotiatedType);*/
            } else if (OFP_OFFER_TYPE_PC.equals(offer.getSubProductType())) {
            	pcOffer = new PCOfferType();
            	pcOffer.setDisclosureId(o.getPromotion().getDisclosureTemplateId().get(0));
            	//OOMS removed PC offer
            } else if (OFP_OFFER_TYPE_CA.equals(offer.getSubProductType())) {
            	caOffer = new CAOfferType();
            	caOffer.setDisclosureId(o.getPromotion().getDisclosureTemplateId().get(0));
            	//caOffer.setEligibleNegotiatedType(eligibleNegotiatedType);
            } else if (OFP_OFFER_TYPE_RT.equals(offer.getSubProductType())) {
            	roffer = new ROfferType();
            	roffer.setDisclosureId(o.getPromotion().getDisclosureTemplateId().get(0));
            }

            //featureGroup/towTerm

            offer.setBtOffer(btOffer);
            offer.setCliOffer(cliOffer);
            offer.setIpOffer(ipOffer);
            offer.setPcOffer(pcOffer);
            offer.setCaOffer(caOffer);
            offer.setRoffer(roffer);
            
            promotionOffer.add(offer);
        }

        return response;
    }

    private boolean toFilterOut(Offer offer){
    	if (offer == null || offer.getPromotion() == null || offer.getPromotion().getPromotionType() == null || offer.getPromotion().getPromotionType().getTypeCd() == null) {
    		return true;
    	}
    	
    	if (offer.getOfferId() == null || offer.getOfferId().length() == 0 ){
    		return true;
    	}
    	
    	String offerType = offer.getPromotion().getPromotionType().getTypeCd();

    	if (!OFP_OFFER_TYPE_CLI.equalsIgnoreCase(offerType) && 
    			!OFP_OFFER_TYPE_BT.equalsIgnoreCase(offerType) &&
    			!OFP_OFFER_TYPE_PC.equalsIgnoreCase(offerType) &&
    			!OFP_OFFER_TYPE_CA.equalsIgnoreCase(offerType) &&
    			!OFP_OFFER_TYPE_RT.equalsIgnoreCase(offerType) &&
    			!OFP_OFFER_TYPE_CI.equalsIgnoreCase(offerType) &&
    			!OFP_OFFER_TYPE_IP.equalsIgnoreCase(offerType) &&
    			!OFP_OFFER_TYPE_MPD.equalsIgnoreCase(offerType)) {
    		logger.error("toFilterOut(Offer offer)","SSMT002: marketing offer is not of a known type: " + offer.toString());
    		return true;
    	}
    	
    	if (OFP_OFFER_TYPE_PC.equalsIgnoreCase(offerType) || 
    			OFP_OFFER_TYPE_CA.equalsIgnoreCase(offerType) || 
    			OFP_OFFER_TYPE_RT.equalsIgnoreCase(offerType)) {
        	List<String> disclosureIds = offer.getPromotion().getDisclosureTemplateId();
        	if (disclosureIds == null || disclosureIds.size() == 0) {
        		logger.error("toFilterOut(Offer offer)","SSMT002: marketing offer does not have a disclosure id: " + offer.toString());
        		return true;
        	}
        	
        	String disclosureId = disclosureIds.get(0);
        	if (disclosureId == null || disclosureId.length() == 0){
        		logger.error("toFilterOut(Offer offer)","SSMT002: marketing offer does not have a disclosure id: " + offer.toString());
        		return true;
        	}
    	}
    	
    	return false;
    } 
}
