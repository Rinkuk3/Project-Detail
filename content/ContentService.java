package com.td.mbna.msec.midtier.content;

import com.td.mbna.msec.midtier.content.payload.getlinkcontent.GetLinkContentRequest;
import com.td.mbna.msec.midtier.content.payload.getlinkcontent.GetLinkContentResponse;
import com.td.mbna.msec.midtier.content.payload.getpagecontent.GetPageContentRequest;
import com.td.mbna.msec.midtier.content.payload.getpagecontent.GetPageContentResponse;

public interface ContentService {
	public GetLinkContentResponse getLinkContent(GetLinkContentRequest getLinkContentRequest);
	
	public GetPageContentResponse getPageContent(GetPageContentRequest getPageContentRequest);
}
