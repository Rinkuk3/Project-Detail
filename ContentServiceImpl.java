package com.td.mbna.msec.midtier.content;

import com.td.mbna.msec.midtier.content.payload.LinkContentType;
import com.td.mbna.msec.midtier.content.payload.getlinkcontent.GetLinkContentRequest;
import com.td.mbna.msec.midtier.content.payload.getlinkcontent.GetLinkContentResponse;
import com.td.mbna.msec.midtier.content.payload.getpagecontent.GetPageContentRequest;
import com.td.mbna.msec.midtier.content.payload.getpagecontent.GetPageContentResponse;
import com.td.mbna.msec.midtier.util.ContentUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("midtierContentService")
public class ContentServiceImpl implements ContentService {
	
	private final static MbnaLogger logger = new MbnaLogger(ContentServiceImpl.class);

    @Override
    @ProfileLog
    public GetLinkContentResponse getLinkContent(final GetLinkContentRequest request) {
    	GetLinkContentResponse res = new GetLinkContentResponse();
    	try {
	    	com.td.mbna.msec.midtier.content.payload.getlinkcontent.ResponsePayload payload = new com.td.mbna.msec.midtier.content.payload.getlinkcontent.ResponsePayload();
	    	res.setResponsePayload(payload);
	    	com.td.mbna.msec.midtier.content.payload.getlinkcontent.RequestPayload reqPayload = request.getRequestPayload();
	    	List<LinkContentType> linkContent = ContentUtil.getLinkContent(reqPayload.getContentId(), reqPayload.getLangId(), reqPayload.getPath());
	    	if (linkContent != null && linkContent.size()>0){
	    		for (LinkContentType lct : linkContent){
		    		payload.getLinkContent().add(JAXBJsonConverter.convertoJAXBToJsonInterface(lct, com.td.mbna.msec.midtier.content.payload.LinkContentType.class));
	    		}
	    	}
    	}
    	catch (Exception e) {
    		logger.error("getLinkContent", e.getLocalizedMessage(), e);
    	}
    	return res;
    }

	@Override
	@ProfileLog
    public GetPageContentResponse getPageContent(final GetPageContentRequest request) {

    	GetPageContentResponse res = new GetPageContentResponse();
    	try {
    		String[] rc = ContentUtil.getPageTitleAndContent(request.getRequestPayload().getPageId(), null, request.getRequestPayload().getLangId());
    		com.td.mbna.msec.midtier.content.payload.getpagecontent.ResponsePayload payload = new com.td.mbna.msec.midtier.content.payload.getpagecontent.ResponsePayload();
    		payload.setTitle(rc[0]);
    		payload.setContent(rc[1]);
    		payload.setContentContent(rc[2]);
    		payload.setToDisplay(rc[3]);
    		payload.setContentTablet(rc[4]);
    		payload.setContentMobile(rc[5]);
    		payload.setDesktopImage(rc[6]);
    		payload.setTabletImage(rc[7]);
    		payload.setMobileImage(rc[8]);
    		res.setResponsePayload(payload);
		}catch(java.io.FileNotFoundException fnfe){
    		logger.warn("java.io.FileNotFoundException:"+ fnfe.getLocalizedMessage()); 
    	}
    	catch (Exception e) {
    		logger.error("getPageContent", e.getLocalizedMessage(), e);
    	}
    	
		return res;
    }

}