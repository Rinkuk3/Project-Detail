package com.td.mbna.msec.midtier.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
public class LocalContentUtil extends GenericContentUtil {
	
	private static MbnaLogger logger = new MbnaLogger(LocalContentUtil.class);
	
	private final static String DefaultLocale = "en_CA";
	private static String ContentDir = ConfigUtil.getConfigDirectory() + "CMS" + ConfigUtil.FS;
	private static final String FILE_EXTENSION = ConfigUtil.getProperty("cms.image.extension");
	
	private static XPathExpression pageTitleXPathExpr, pageBodyXPathExpr;
	private static XPathExpression pdfTitleXPathExpr, pdfUrlXPathExpr;
	private static XPathExpression pageContentXPathExpr, pageToDisplayXPathExpr,pageContentTabletXPathExpr,pageContentMobileXPathExpr,pageDesktopImageXPathExpr,pageTabletImageXPathExpr, pageMobileImageXPathExpr;
	
	private final static String pageBodyXPath = "/txnAppFeeds/txnAppFeed/ContentBody";
	private final static String pageTitleXPath ="/txnAppFeeds/txnAppFeed/title";
	private final static String PdfTitleXPath = "/txnAppFeeds/txnAppFeed/Link/Title";
	private final static String PdfUrlXPath = "/txnAppFeeds/txnAppFeed/Link/ExtLink";
	
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
			pdfTitleXPathExpr = xpath.compile(PdfTitleXPath);
			pdfUrlXPathExpr = xpath.compile(PdfUrlXPath);
			
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
     * Return relevant information, such as URL and Alt Text, of content maintained by CMS.
     * Supported content types are images and pdf.  Please note that a list is returned 
     * to support affinity images, since an affinity could have more than one images
     * (e.g. a big and a small image).  Also, please note that each request is for one locale only.
     * So if both English and French content is needed, two calls have to be made. 
     * 
     * @return response payload containing the URL and Alt Text of the requested content.
     */
	public static List<LinkContentType> getLinkContent(String linkContentId, String langId) throws Exception {
		List<LinkContentType> rc;
		if (linkContentId.toLowerCase(Locale.CANADA).endsWith(".pdf")) {
			LinkContentType pdfLinkContent = getPdfLinkContent(linkContentId, langId);
			rc = new ArrayList<LinkContentType>(1);
			rc.add(pdfLinkContent);
			return rc;
		}
		rc = getImageLinkContent(linkContentId, langId);
		return rc;
	}
	
    /**
     * Return relevant information, such as URL and Alt Text, of a PDF maintained by CMS.
     * Please note that each request is for one locale only, so if both English and 
     * French PDFs are needed, two calls have to be made. 
     * 
     * @return response payload containing the URL and Alt Text of the requested PDF.
     */

	private static LinkContentType getPdfLinkContent(String pdfKey, String langId) throws Exception {
		LinkContentType rc = new LinkContentType();
		Document pdfDom = getPdfXml(pdfKey, langId);
		String pdfTitle;
		synchronized (pdfTitleXPathExpr) {
			pdfTitle = pdfTitleXPathExpr.evaluate(pdfDom);
		}
		String pdfUrl; 
		synchronized (pdfUrlXPathExpr) {
			pdfUrl = pdfUrlXPathExpr.evaluate(pdfDom);
		}
		rc.setAltText(pdfTitle);
		rc.setLink(pdfUrl);
		return rc;
	}

    /**
     * Return relevant information, such as URL and Alt Text, of an image maintained by CMS.
     * Please note that a list is returned to support affinity images, since an affinity
     * could have more than one images (e.g. a big and a small image).  Also, please note
     * that each request is for one locale only. So if both English and French images are needed
     * two calls have to be made. 
     * 
     * @return response payload containing the URL and Alt Text of the requested content.
     */
	private static List<LinkContentType> getImageLinkContent(String imageKey, String langId) throws Exception {
		
		String lang = "en";
		if (langId.contains("fr")) {		
			lang="fr";
		}
		
		List<LinkContentType> rc = new ArrayList<LinkContentType>();
		
		LinkContentType linkType = new LinkContentType();
		linkType.setLink(getImgLink(imageKey,lang));
		
		rc.add(linkType);
		return rc;	
	}
	
	/**
	 * Return a String representation of the link of a logo
	 * @param logoId
	 * @param langId
	 * @return
	 */
	public static String getImgLink(String logoId, String langId) {
		String lang = "en";
		if (langId.contains("fr")) {		
			lang="fr";
		}
		
		return "images/"+lang+"/"+logoId+FILE_EXTENSION;
	}

	
    /**
     * Return the title and HTML content of a static page maintained by CMS.
     * 
     * @return title and HTML content of the page
     */
	public static String[] getPageTitleAndContent(String pageId, PageDisplayStyleType pageDisplayStyle, String langId) throws Exception {
		Document pageXml = getPageXml(pageId, pageDisplayStyle, langId);
		
		String pageTitle;
		synchronized (pageTitleXPathExpr) {
			pageTitle = pageTitleXPathExpr.evaluate(pageXml);
		}
		String pageContentBody; 
		synchronized (pageBodyXPathExpr) {
			pageContentBody = pageBodyXPathExpr.evaluate(pageXml);
		}
		
		String pageContent;
		synchronized(pageContentXPathExpr){
			pageContent = pageContentXPathExpr.evaluate(pageXml);
		}
		
		String toDisaplay;
		synchronized(pageToDisplayXPathExpr){
			toDisaplay = pageToDisplayXPathExpr.evaluate(pageXml);
		}
		
		String ContentTablet;
		synchronized(pageContentTabletXPathExpr){
			ContentTablet = pageContentTabletXPathExpr.evaluate(pageXml);
		}
		
		String ContentMobile;
		synchronized(pageContentMobileXPathExpr){
			ContentMobile = pageContentMobileXPathExpr.evaluate(pageXml);
		}
		
		String desktopImage;
		synchronized(pageDesktopImageXPathExpr){
			desktopImage = pageDesktopImageXPathExpr.evaluate(pageXml);
		}
		
		String tabletImage;
		synchronized(pageTabletImageXPathExpr){
			tabletImage = pageTabletImageXPathExpr.evaluate(pageXml);
		}
		
		String mobileImage;
		synchronized(pageMobileImageXPathExpr){
			mobileImage = pageMobileImageXPathExpr.evaluate(pageXml);
		}
		
		return new String[]{pageTitle, pageContentBody, pageContent, toDisaplay, ContentTablet, ContentMobile, desktopImage, tabletImage, mobileImage};
	}
	
	/**
     * Return the fully-qualified path of the XML file containing HTML content of a static page .
     * 
     * @return fully-qualified path of the XML file
     */
	private static String getPageXmlFileName(String pageId, PageDisplayStyleType pageDisplayStyle, String langId) {
		if (langId == null || langId.trim().length() == 0) {
			langId = DefaultLocale; 
		}
		return ContentDir + langId + ConfigUtil.FS + "xml" + ConfigUtil.FS + pageId + ".xml";
	}

	/**
     * Return DOM representation of the XML file containing HTML content of a static page .
     * 
     * @return DOM representation of the  XML file
     */
	private static Document getPageXml(String pageId, PageDisplayStyleType pageDisplayStyle, String langId) throws Exception {
		String pageXmlFn = getPageXmlFileName(pageId, pageDisplayStyle, langId);
		Document pageXml = parse(pageXmlFn);
		return pageXml;
	}
	
	/**
     * Return the fully-qualified path of the XML file containing content info of a PDF.
     * 
     * param key and language ID of the PDF
     * @return fully-qualified path of the XML file
     */
	private static String getPdfXmlFileName(String pdfKey, String langId) {
		if (langId == null || langId.trim().length() == 0) {
			langId = DefaultLocale; 
		}
		String pdfKeyNoSuffix = pdfKey.substring(0, pdfKey.length()-".pdf".length()); // remove ".pdf" suffix
		return ContentDir + langId + ConfigUtil.FS + "pdf" + ConfigUtil.FS + pdfKeyNoSuffix + ".xml";
	}
	
	/**
     * Return the DOM representation of the XML file containing content info of a PDF.
     * 
     * param key and language ID of the PDF
     * @return the DOM representation of the XML file
     */
	private static Document getPdfXml(String pdfKey, String langId) throws Exception {
		String pdfXmlFn = getPdfXmlFileName(pdfKey, langId);
		Document pdfXml = parse(pdfXmlFn);
		return pdfXml;
	}



}