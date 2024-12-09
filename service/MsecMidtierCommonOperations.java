package com.td.mbna.msec.midtier.service;

import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;


import java.util.List;

public interface MsecMidtierCommonOperations<T,R> {
    String GENERAL_ERROR = "MS601";


    public R invokeService(T request, String... token);
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
    public List<String> createAutoComment(BaseRequest request, BaseResponse response);
    /**
     * enable/disable email notification
     * @param request
     * @param response
     * @return
     */
    public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response);


    public MsecValidator getValidator();

}
