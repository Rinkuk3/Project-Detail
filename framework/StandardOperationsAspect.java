package com.td.mbna.msec.midtier.framework;

import com.td.mbna.msec.midtier.mbalert.MbnaAlert;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.services.AuditService;
import com.td.mbna.msec.midtier.services.DisclosureService;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

@Aspect
@Component
public class StandardOperationsAspect {

    private static MbnaLogger logger = new MbnaLogger(StandardOperationsAspect.class);
    private static final String GENERAL_ERROR = "MS601";
    @Autowired
    private Executor midtierExecutor;

    @Autowired
    private MbnaCCA mbnaCCA;

    @Autowired
    private MbnaAlert mbnaAlert;
    
    @Around("execution(* com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations.invokeService(..))")
    public BaseResponse invokeService(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = "StandardOperationsAspect:invokeService";
        Date startTime = new Date();

        final MsecMidtierCommonOperations<?, ?> midtierServiceOperation = (MsecMidtierCommonOperations<?, ?>) joinPoint.getTarget();

        //this shouldn't happen, but in case it does
        if (midtierServiceOperation == null) {
            throw ExceptionUtil.genRuntimeException(new Exception("Failed to invoke service."));
        }

        final BaseRequest request = (BaseRequest) joinPoint.getArgs()[0];
        logger.setSessionInfo(request);
        try {
            final String[] tokens = (String[]) (joinPoint.getArgs().length > 1 ? joinPoint.getArgs()[1] : null);
            final String token = tokens != null && tokens.length > 0 ? tokens[0] : null;
            Class<?> returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();

            if (midtierServiceOperation.getValidator() != null) {
                com.td.mbna.msec.midtier.types.common.ValidationException validationException = midtierServiceOperation.getValidator().validate(request);

                if (validationException != null) {
                    BaseResponse response = (BaseResponse) returnType.newInstance();
                    response.setStatus("Failed");
                    response.setValidationErrors(validationException.getFieldError());
                    throw validationException;
                }
            }

            //process consentDisclosure before calling any operation
            //such as balanceTransfer, depositToChecking, or requestCheques
            if (midtierServiceOperation.requiresDisclosureConsent()) {

                logger.debug("StandardOperationsAspect:invokeService - Calling DisclosureService to capture the required consents.");

                try {
                    DisclosureService.consentDisclosure(request);
                } catch (Exception e) {
                    String msgCode = midtierServiceOperation.getConsentDisclosureFailedMsgCode();
                    if (msgCode != null) {
                        logger.error(methodName, "msgCode =" + msgCode, e);
                        throw MidtierUtilHelper.prepareBusinessException(msgCode, "Failed to capture consent", e);
                    } else {
                        throw ExceptionUtil.genRuntimeException(e);
                    }
                }
            }

//            logger.debug("StandardOperationsAspect:invokeService - About to invoke the actual service");
            final BaseResponse response = (BaseResponse) joinPoint.proceed();
            //check if any errors, return
            if (response == null) {
            	String message = "";
            	logger.error(methodName, message);
                throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR, GENERAL_ERROR);
            }

            if (response.getErrorMessages() != null && response.getErrorMessages().size() > 0) {
                throw MidtierUtilHelper.prepareBusinessException(response.getErrorMessages().get(0).getErrorCode(), response.getErrorMessages().get(0).getErrorCode());
            }

            //proceed with post service operations if call was successful

            try {
                if (ConfigUtil.emailActive()) {
                    EmailInfo emailInfo = midtierServiceOperation.getEmailInfoBean(request, response);
                    if (emailInfo != null) {
                        logger.debug("StandardOperationsAspect:invokeService - EmailInfo: " + emailInfo.toString());
                        if (emailInfo.isTriggerEmailNotification()) {
                            midtierExecutor.execute(() -> {
                                try {
                                    //migrated email notification: call MbnaAlert to send emails.
                                	if (token == null){
                                    	logger.error("callEmailNotification", "token is null for alert event");	
                                	} else if (emailInfo.getBusinessEventID() != null && emailInfo.getBusinessEventID().startsWith("MBNA_INTEG_")){
                                    	emailInfo.setToken(token);
                                    	mbnaAlert.addAlertEvent(emailInfo);
                                    } else {
                                    	logger.error("not supported BusinessEventID: ", emailInfo.getBusinessEventID());	
                                    }
                                } catch (Exception e) {
                                    logger.error("callEmailNotification", "sendEmail failed", e);
                                    emailInfo.retry(emailInfo);
                                }
                            });
                        } else {
                            logger.debug("EmailNotification is not triggered for " + request.getAcctNum());
                        }
                    } else {
                        logger.debug("emailInfo is null " + request.getAcctNum());
                    }
                }

                if (midtierServiceOperation.generateAutoComment()) {
                    logger.debug("StandardOperationsAspect:invokeService - auto comment");
                    midtierExecutor.execute(() -> {
                        List<String> comment = midtierServiceOperation.createAutoComment(request, response);
                        if (comment == null) {
                        	return;
                        }
                        mbnaCCA.creatCustomerNotes(comment, request, token);
                    });
                } else {
                    logger.debug("no comment generated");
                }

            } catch (Throwable ex) {
                //Don't throw exception since application should still function normally
                logger.error(methodName, "Failed in getting work manager for CustomerNote, Email", ex);
            }

            if (request != null) {
                logger.debug("StandardOperationsAspect:invokeService - Creating the auditlog");
                Date stopTime = new Date();
                AuditService.createAuditLog(request, response, startTime, stopTime.getTime() - startTime.getTime());
            }

            return response;
        } finally {
//            logger.removeMDC();
        }
    }
}