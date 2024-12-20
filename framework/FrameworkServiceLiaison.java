package com.td.mbna.msec.midtier.framework;

import java.util.List;

import com.td.mbna.msec.midtier.services.EmailInfoImpl;

import com.mbnaweb.xsd.types.common.BaseResponse;
import com.mbnaweb.xsd.types.common.TrackableRequest;

/**
 * Implement this interface if the operation needs any of the services that the framework provides 
 *
 */
public interface FrameworkServiceLiaison {
	/**
	 * enable/disable disclosure consent
	 * @return
	 */
	public boolean requiresDisclosureConsent();
	
	/**
	 * return message code when disclosure consent failed
	 * @return
	 */
	public String getConsentDisclosureFailedMsgCode();

	/**
	 * enable/disable auto comment
	 * @return
	 */
	public boolean generateAutoComment();
	/**
	 * how to create auto comment
	 * @param request
	 * @param response
	 * @return
	 */
	public List<String> createAutoComment(TrackableRequest request, BaseResponse response);
	/**
	 * enable/disable email notification
	 * @param request
	 * @param response
	 * @return
	 */
	public EmailInfoImpl getEmailInfoBean(TrackableRequest request, BaseResponse response);
}
