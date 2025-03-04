package com.td.mbna.msec.midtier.util;

import java.util.List;

import com.td.mbna.msec.midtier.content.payload.LinkContentType;
import com.td.mbna.msec.midtier.content.payload.PageDisplayStyleType;
/**
 * This class encapsulates all functionality needed to retrieve content from CMS.
 * The functionality is exposed as utility functions because that makes it possible
 * return content in any MidTier services.
 * 
 */
public class ContentUtil {
	


	private final static boolean LoadFromCms = com.td.mbna.msec.midtier.util.CmsContentUtil.getLoadfromcms();
	
	
    /**
     * Return relevant information, such as URL and Alt Text, of content maintained by CMS.
     * Supported content types are images and pdf.  Please note that a list is returned 
     * to support affinity images, since an affinity could have more than one images
     * (e.g. a big and a small image).  Also, please note that each request is for one locale only.
     * So if both English and French content is needed, two calls have to be made. 
     * 
     * @param request payload containing the content key and language ID of the requested content
     * @return response payload containing the URL and Alt Text of the requested content.
     */
	public static List<LinkContentType> getLinkContent(String linkContentId, String langId, String path) throws Exception {
		List<LinkContentType> rc = LoadFromCms ? com.td.mbna.msec.midtier.util.CmsContentUtil.getLinkContent(linkContentId, langId, path) :
												 com.td.mbna.msec.midtier.util.LocalContentUtil.getLinkContent(linkContentId, langId);
		return rc;
	}
	
    /**
     * Return the title and HTML content of a static page maintained by CMS.
     * 
     * @param key and language ID of the requested content
     * @return title and HTML content of the page
     */
	public static String[] getPageTitleAndContent(String pageId, PageDisplayStyleType pageDisplayStyle, String langId) throws Exception {
		String[] rc = LoadFromCms ? com.td.mbna.msec.midtier.util.CmsContentUtil.getPageTitleAndContent(pageId, pageDisplayStyle, langId) :
									com.td.mbna.msec.midtier.util.LocalContentUtil.getPageTitleAndContent(pageId, pageDisplayStyle, langId);
		return rc;
	}
	
	/**
	 * return a image link based on logo id
	 * @param logoId id(filename) of the logo
	 * @param langId key and language ID of the requested content
	 * @return
	 * @throws Exception
	 */
	public static String getImgLink(String logoId, String langId, String path) {
		String rc = LoadFromCms? CmsContentUtil.getImgLink(logoId,  langId, path) :
								 LocalContentUtil.getImgLink(logoId, langId);
		return rc;
	}
	

}
