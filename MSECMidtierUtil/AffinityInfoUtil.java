package com.td.mbna.msec.midtier.util;

import org.apache.commons.lang3.StringUtils;

import com.mbnaweb.xsd.types.common.AcctOverviewType;
import com.mbnaweb.xsd.types.common.AffinityInfoType;
import com.mbnaweb.xsd.types.common.AffinityInfoTypeLanguageSpecific;
import com.mbnaweb.xsd.types.common.AffinitySpecType;
import com.mbnaweb.xsd.types.common.CustAcctType;
import com.td.mbna.msec.midtier.persistance.entity.AffinityInfo;
import com.td.mbna.msec.midtier.persistance.entity.PlasticsCode;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.services.IMBNAConstants;

/**
 * This class contains utility methods for interacting with the AFFINITYINFO table in the local database. 
 * 
 */
public class AffinityInfoUtil {

	private static final String FR = "FR";
	private static final String EN = "EN";
	private static final String BLANK = " ";
	private static MbnaLogger logger = new MbnaLogger(AffinityInfoUtil.class);
	
	public static AffinityInfoType getAffinityInfo(String productCodes,String poCode, String arqCode) throws Exception {

		AffinityInfo aie;
		AffinityInfo aif;
		PlasticsCode pce;
		PlasticsCode pcf;

		AffinityInfoType ait = new AffinityInfoType();
		AffinityInfoTypeLanguageSpecific englishInfo = new AffinityInfoTypeLanguageSpecific();
		AffinityInfoTypeLanguageSpecific frenchInfo = new AffinityInfoTypeLanguageSpecific();

		if (productCodes == null) {
			productCodes = "DEFAULT"; // map to the DEFAULT entry in the AffinityInfo table 
		}
		
		try {
//			aie = DBService.getAffinityInfo(productCodes, arqCode, EN, poCode);
//			aif = DBService.getAffinityInfo(productCodes, arqCode, FR, poCode);
//			pce = DBService.getPlasticsCode(productCodes, arqCode, EN, poCode);
//			pcf = DBService.getPlasticsCode(productCodes, arqCode, FR, poCode);
			aie = DBMybatisService.getAffinityInfo(productCodes, arqCode, EN, poCode);
			aif = DBMybatisService.getAffinityInfo(productCodes, arqCode, FR, poCode);
			pce = DBMybatisService.getPlasticsCode(productCodes, arqCode, EN, poCode);
			pcf = DBMybatisService.getPlasticsCode(productCodes, arqCode, FR, poCode);

			// these two are not language specific
			ait.setAffinityCode(aie.getProductCodes());
			ait.setProductCodes(aie.getProductCodes());

			// language specific - for English
			setCardAffinityInfo(aie, englishInfo, IMBNAConstants.ENGLISH_LOCALE);
			setCardAffinityInfo(aif, frenchInfo, IMBNAConstants.FRENCH_LOCALE);

			// setting the card pictures
			setCardPicture(pce, englishInfo, IMBNAConstants.ENGLISH_LOCALE);
			setCardPicture(pcf, frenchInfo, IMBNAConstants.FRENCH_LOCALE);
			
			//setting the card pictures for mobile app
			setCardPicture(pce, englishInfo, IMBNAConstants.ENGLISH_LOCALE, true);
			setCardPicture(pcf, frenchInfo, IMBNAConstants.FRENCH_LOCALE, true);
			
		} catch (Exception e) {			
			//set a flag to indicate affinity retrieval failed. 
			ait.setFailed(true);
			logger.error("AffinityInfoUtil:getAffinityInfo", "error in DB Service.getAffinityInfo or DB Service.getPlasticsCode");
		} finally {
			ait.setEnglishInfo(englishInfo);
			ait.setFrenchInfo(frenchInfo);
		}
		return ait;
	}
	
	
	public static void setAccountAffinityRelatedInfo(CustAcctType acct, AcctOverviewType acctOverviewType) throws Exception {

		String tsysProductCode = null;
		String clientProductCode = null;
		String branchCode = null;

		String poCode = "";

		if (StringUtils.isNotBlank(acctOverviewType.getPoCode())) {
			poCode = acctOverviewType.getPoCode();
		}

		String arqCode = null;
		if (StringUtils.isNotBlank(acctOverviewType.getArqCode())) {
			arqCode = acctOverviewType.getArqCode();
			acct.setArqCode(arqCode);
		}

		String productCodes = null;
		if (StringUtils.isNotBlank(acctOverviewType.getProductCodes())) {
			productCodes = acctOverviewType.getProductCodes();
			String[] productCodeDetails = productCodes.split("-");
			tsysProductCode = productCodeDetails[0];
			clientProductCode = productCodeDetails[1];
			branchCode = productCodeDetails[2];
		}


		acct.setProductCodes(productCodes);
		acct.setPoCode(poCode);
		AffinityInfoType affInfo = AffinityInfoUtil.getAffinityInfo(productCodes, poCode, arqCode);
		affInfo.setProductCodes(productCodes);
		affInfo.setAffinityCode(productCodes);
		acct.setAffinity(affInfo);
		AffinitySpecType affSpec = new AffinitySpecType();
		affSpec.setTsysProductCode(tsysProductCode);
		affSpec.setClientProductCode(clientProductCode);
		affSpec.setMiscInfo(branchCode);
		acct.setAffinitySpec(affSpec);
	}


	public static void setAffinityRelatedValues(CustAcctType src, CustAcctType tgt) {
		tgt.setAffinity(src.getAffinity());
		tgt.setAffinitySpec(src.getAffinitySpec());
		tgt.setProductCodes(src.getProductCodes());
		tgt.setPoCode(src.getPoCode());
		tgt.setArqCode(src.getArqCode());
	}

	

	/**
	 * setting language specific affinity info, such as long description, short
	 * description, and logo URL
	 * 
	 * @param aie - The affinityInfo object
	 * @param info - The language specific object, which will become part of the affinityInfo object.
	 */
	private static void setCardAffinityInfo(AffinityInfo aie, AffinityInfoTypeLanguageSpecific info, String locale) {
		if (aie == null) {
			info.setLongDesc(null);
			info.setShortDesc(null);
			info.setLogo(null); // shown in my account
			return;
		}
		// Request by CPT description
		info.setLongDesc(aie.getLongName());
		info.setShortDesc(aie.getShortName());
		info.setCptDescription(aie.getCptDescription());
		
		if (aie.getLogoId()!=null && !aie.getLogoId().equals(BLANK)) {
			info.setLogo(ContentUtil.getImgLink(aie.getLogoId(), locale, CmsContentUtil.CMS_AFFINITY_LOGO_PATH)); // shown in my account
		}

	}

	/**
	 * setting card picture URL
	 * 
	 * @param pce
	 * @param info
	 */
	private static void setCardPicture(PlasticsCode pce,AffinityInfoTypeLanguageSpecific info, String locale, boolean isMobile) {
		if (pce != null && pce.getPictureId() != null && !pce.getPictureId().equals(BLANK)) {
			if(isMobile){
				info.setMobileCardPicture(ContentUtil.getImgLink(pce.getPictureId(), locale, getCardPicturePathForMobile()));
				return;
			}
			info.setCardPicture(ContentUtil.getImgLink(pce.getPictureId(), locale, CmsContentUtil.CMS_CARD_PICTURE_PATH)); // this one is shown in account overview
		}
	}
	
	private static void setCardPicture(PlasticsCode pce,AffinityInfoTypeLanguageSpecific info, String locale){
		setCardPicture(pce, info, locale,false);
	}
	
	private static String getCardPicturePathForMobile(){
		return CmsContentUtil.CMS_MOBILE_CARD_PICTURE_PATH + CmsContentUtil.CMS_CARD_PICTURE_PATH;
	}

}