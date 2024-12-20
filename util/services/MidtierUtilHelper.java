package com.td.mbna.msec.midtier.util.services;

import com.td.mbna.msec.midtier.exceptions.BusinessException;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.Error;
import com.td.mbna.msec.midtier.types.common.FieldErrorType;
import com.td.mbna.msec.midtier.types.common.ValidationException;
import com.td.mbna.msec.midtier.util.MbnaLogger;

import java.util.ArrayList;
import java.util.List;

public class MidtierUtilHelper {

    private final static MbnaLogger logger = new MbnaLogger(MidtierUtilHelper.class);

    public static  <T extends BaseResponse> T preparePlainErrorResponse(Class<T> responseClass, String errorMessage) {

        List<String> errorMessages = new ArrayList<>();
        errorMessages.add(errorMessage);

        return preparePlainErrorResponse(responseClass,errorMessages);
    }

    public static  <T extends BaseResponse> T preparePlainErrorResponse(Class<T> responseClass, List<String> errorMessage) {
        T rc;
        try {
            rc =  responseClass.newInstance();
        }
        catch (Exception e) {
            logger.error("Error generate Error Response", e.getMessage(),e);
            throw new RuntimeException(e);
        }

        Error anError;
        for(String anErrorMessage : errorMessage) {
            anError = new Error();
            anError.setSeverity("ERROR");
            anError.setErrorDescription(anErrorMessage);
            anError.setErrorCode(anErrorMessage);
            rc.getErrorMessages().add(anError);
        }


        return rc;
    }
    public static BusinessException prepareBusinessException(String errorCode, String errorDescription) {
        return prepareBusinessException(errorCode, errorDescription, null);
    }
    public static BusinessException prepareBusinessException(String errorCode, String errorDescription, Throwable cause) {

        com.td.mbna.msec.midtier.types.common.BusinessException faultInfo = new com.td.mbna.msec.midtier.types.common.BusinessException();
        faultInfo.setErrorCode(errorCode);
        faultInfo.setSeverity("ERROR");
        faultInfo.setErrorDescription(errorDescription);
        BusinessException businessException = cause == null? new BusinessException("Business Error",faultInfo): new BusinessException("Business Error",faultInfo, cause);
        return businessException;
    }

    public static ValidationException prepareValidationException(String errorCode, String errorDescription) {
        return prepareValidationException(errorCode,errorCode,errorDescription);
    }

    public static ValidationException prepareValidationException(String fieldName, String errorCode, String errorDescription) {
        ValidationException faultInfo = new ValidationException();
        FieldErrorType fldErr = new FieldErrorType();
        fldErr.setField(fieldName);
        fldErr.setErrorCode(errorCode);
        fldErr.setErrorDescription(errorDescription);
        fldErr.setSeverity("ERROR");
        faultInfo.getFieldError().add(fldErr);
        return faultInfo;
    }

}