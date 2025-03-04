package com.td.mbna.msec.midtier.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import com.td.mbna.msec.midtier.content.payload.LinkContentType;
import com.td.mbna.msec.midtier.content.payload.PageDisplayStyleType;


/**
 * This class encapsulates all functionality needed to retrieve content from CMS.
 * The functionality is exposed as utility functions because that makes it possible
 * return content in any MidTier services.
 * 
 */
public class CmsContentUtil extends GenericContentUtil {
	
	private static MbnaLogger logger = new MbnaLogger(CmsContentUtil.class);

	public static final String CMS_GENERIC_PICTURE_PATH = ConfigUtil.getProperty("cms.image.path");
	public static final String CMS_AFFINITY_LOGO_PATH = ConfigUtil.getProperty("cms.image.affinitylogo.path");
	public static final String CMS_CARD_PICTURE_PATH = ConfigUtil.getProperty("cms.image.cardpicture.path");
	public static final String CMS_OFFER_BANNER_PATH = ConfigUtil.getProperty("cms.image.offerbanner.path");
	public static final String CMS_MOBILE_CARD_PICTURE_PATH = "mobile/";
	private static final String CMS_HOST = ConfigUtil.getProperty("cms.server.url");
	private static final String CMS_EXTERNAL_HOST = ConfigUtil.getProperty("cms.server.external.url");	
	private static final String FILE_EXTENSION = ConfigUtil.getProperty("cms.image.extension");
	private final static String CMS_XML_PATH=ConfigUtil.getProperty("cms.xml.path");
	private final static Boolean LoadFromCms = CMS_HOST != null;	
	
	private final static String OFFER_BANNER_SMALL="_banner_small";
	private final static String OFFER_BANNER_LARGE="_banner_large";
	private final static String OFFER_BANNER_MOBILE="_banner_mobile";
	
	private static XPathExpression pageTitleXPathExpr, pageBodyXPathExpr, pageContentXPathExpr, pageToDisplayXPathExpr,pageContentTabletXPathExpr,pageContentMobileXPathExpr,pageDesktopImageXPathExpr,pageTabletImageXPathExpr, pageMobileImageXPathExpr;
	
	
	private final static String pageBodyXPath = "/txnAppFeeds/txnAppFeed/ContentBody";
	private final static String pageTitleXPath ="/txnAppFeeds/txnAppFeed/title";
	private final static String pageContentXPath ="/txnAppFeeds/txnAppFeed/ContentBody/Content";
	private final static String pageToDisplayXPath ="/txnAppFeeds/txnAppFeed/ContentBody/ToDisplay";
	private final static String pageContentTabletXPath ="/txnAppFeeds/txnAppFeed/ContentBody/ContentTablet";
	private final static String pageContentMobileXPath ="/txnAppFeeds/txnAppFeed/ContentBody/ContentMobile";
	private final static String pageDesktopImageXPath ="/txnAppFeeds/txnAppFeed/ContentBody/DesktopImage";
	private final static String pageTabletImageXPath ="/txnAppFeeds/txnAppFeed/ContentBody/TabletImage";
	private final static String pageMobileImageXPath ="/txnAppFeeds/txnAppFeed/ContentBody/MobileImage";
	static {
		try {
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xpath = xPathFactory.newXPath();
			pageTitleXPathExpr = xpath.compile(pageTitleXPath);
			pageBodyXPathExpr = xpath.compile(pageBodyXPath);
			pageContentXPathExpr = xpath.compile(pageContentXPath);
			pageToDisplayXPathExpr = xpath.compile(pageToDisplayXPath);
			pageContentTabletXPathExpr = xpath.compile(pageContentTabletXPath);
			pageContentMobileXPathExpr = xpath.compile(pageContentMobileXPath);
			pageDesktopImageXPathExpr = xpath.compile(pageDesktopImageXPath);
			pageTabletImageXPathExpr = xpath.compile(pageTabletImageXPath);
			pageMobileImageXPathExpr = xpath.compile(pageMobileImageXPath);
			
 		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	
	   /**
     * Return the title and HTML content of a static page maintained by CMS.
     * 
     * @param key and language ID of the requested content
     * @return title and HTML content of the page
     */
	public static String[] getPageTitleAndContent(String pageId, PageDisplayStyleType pageDisplayStyle, String langId) throws Exception {
		String pageUrl = getPageUrl(pageId, pageDisplayStyle, langId);
		byte[] pageBytes = readUrlContent(pageUrl);
		Document pageContentXml = parse(pageBytes);
		
		String pageTitle;
		synchronized (pageTitleXPathExpr) {
			pageTitle = pageTitleXPathExpr.evaluate(pageContentXml);
		}
		
		String pageContentBody; 
		synchronized (pageBodyXPathExpr) {
			pageContentBody = pageBodyXPathExpr.evaluate(pageContentXml);
		}
		
		String pageContent;
		synchronized(pageContentXPathExpr){
			pageContent = pageContentXPathExpr.evaluate(pageContentXml);
		}
		
		String toDisaplay;
		synchronized(pageToDisplayXPathExpr){
			toDisaplay = pageToDisplayXPathExpr.evaluate(pageContentXml);
		}
		
		String ContentTablet;
		synchronized(pageContentTabletXPathExpr){
			ContentTablet = pageContentTabletXPathExpr.evaluate(pageContentXml);
		}
		
		String ContentMobile;
		synchronized(pageContentMobileXPathExpr){
			ContentMobile = pageContentMobileXPathExpr.evaluate(pageContentXml);
		}
		
		String desktopImage;
		synchronized(pageDesktopImageXPathExpr){
			desktopImage = pageDesktopImageXPathExpr.evaluate(pageContentXml);
		}
		
		String tabletImage;
		synchronized(pageTabletImageXPathExpr){
			tabletImage = pageTabletImageXPathExpr.evaluate(pageContentXml);
		}
		
		String mobileImage;
		synchronized(pageMobileImageXPathExpr){
			mobileImage = pageMobileImageXPathExpr.evaluate(pageContentXml);
		}
		
		return new String[]{pageTitle, pageContentBody, pageContent, toDisaplay, ContentTablet, ContentMobile, desktopImage, tabletImage, mobileImage};
	}



    /**
     * Return the CMS image link
     * 
     * @param request payload containing the content key and language ID of the requested content
     * @return response payload containing the URL.
     */
	public static List<LinkContentType> getLinkContent(String contentKey, String langId, String path) throws Exception {
		return getImageLinkContent(contentKey, langId, path);
	}
	

	private static List<LinkContentType> getImageLinkContent(String imageKey, String locale, String path) throws Exception {
		List<LinkContentType> rc = new ArrayList<LinkContentType>();
		
		LinkContentType linkType = new LinkContentType();
		linkType.setLink(getImgLink(imageKey, locale, path));
		
		rc.add(linkType);
		return rc;
	}
	
	
	private static String getPageUrl(String pageId, PageDisplayStyleType pageDisplayStyle, String langId) {
		return CMS_HOST+langId+CMS_XML_PATH+pageId+".xml";
	}
	
	/**
	 * Return a String representation of the link of a logo
	 * @param logoId 
	 * @param locale Locale, can be en_CA, or fr_CA
	 * @secondaryPath whether the pictures are in the affinity_logo folder, or card_picture folder
	 * @return
	 */
	public static String getImgLink(String logoId, String locale, String secondaryPath) {
		if (secondaryPath!=null) {
			return CMS_EXTERNAL_HOST+locale+CMS_GENERIC_PICTURE_PATH+secondaryPath+logoId+FILE_EXTENSION;		
		}
		return CMS_EXTERNAL_HOST+locale+CMS_GENERIC_PICTURE_PATH+logoId+FILE_EXTENSION;
	}
	
	/**
	 * Return offer banner image paths(Large and Small)
	 * @param logoId 
	 * @param locale Locale, can be en_CA, or fr_CA
	 * @secondaryPath whether the pictures are WCM folder
	 * @return
	 */
	public static String getOffersBanner(String offerId, String locale, String imageType) {
		StringBuilder offerBannerPath = new StringBuilder();
		offerBannerPath.append(CMS_EXTERNAL_HOST);
		offerBannerPath.append(locale);
		offerBannerPath.append(CMS_GENERIC_PICTURE_PATH);
		offerBannerPath.append(CMS_OFFER_BANNER_PATH);
		offerBannerPath.append(offerId);
		if(imageType.equalsIgnoreCase("large")){
			offerBannerPath.append(OFFER_BANNER_LARGE);			
		}
		else if(imageType.equalsIgnoreCase("small")){
			offerBannerPath.append(OFFER_BANNER_SMALL);		
		}else{
			offerBannerPath.append(OFFER_BANNER_MOBILE);		
		}
		offerBannerPath.append(FILE_EXTENSION);
		return offerBannerPath.toString();
			
		
	}


	/**
     * Utility function to return the DOM representation of an XML stream  
     * 
     * @param binary content of the XML stream
     * @return DOM representation of the XML stream
     */
	private static Document parse (byte[] xmlBytes) throws Exception {
		Document doc = null;
		ByteArrayInputStream is = null;
		try {
			is = new ByteArrayInputStream(xmlBytes);
			doc = parse(is);
		}
		finally  {
			if (is != null) try {is.close();} catch (Exception e){logger.error(e.getMessage(), e);}
		}
		return doc;
	}
	
	/**
     * Utility function to read the raw bytes from a URL  
     * 
     * @param URL to read from
     * @return the raw bytes read from the URL
     */
	private static byte[] readUrlContent(String urlStr) throws Exception {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		byte[] rc = null;
		try {
			URL url = new URL(urlStr);
			//TODO: harry 2021-02-17 Insertion of Sensitive Information Into Sent Data CWE ID 201
			URLConnection urlConn = url.openConnection();
			in = urlConn.getInputStream();
			int responseLen = urlConn.getContentLength();
			if (responseLen < 0 || responseLen > 32768) { // use HTTP response header content length if available
				responseLen = 32768;
			}
			out = new ByteArrayOutputStream(responseLen);
			int c;
			byte[] b = new byte[4096];
			while ((c = in.read(b)) != -1) {
				out.write(b, 0, c);
			}
			rc = out.toByteArray();
		} finally {
			if (in != null) try {in.close();} catch (Exception e) {logger.error(e.getMessage(), e);}
			if (out != null) try {out.close();} catch (Exception e){logger.error(e.getMessage(), e);}
		}
		return rc;
	}
	

	/**
	 * get load from CMS
	 */
	public static Boolean getLoadfromcms() {
		return LoadFromCms;
	}	
}
