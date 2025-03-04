package com.td.mbna.msec.midtier.framework;

import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.FieldErrorType;
import com.td.mbna.msec.midtier.types.common.ValidationException;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springmodules.validation.valang.ValangValidator;

import java.util.List;

public class MsecVlangValidator implements MsecValidator {

    private ValangValidator valangValidator;

    public MsecVlangValidator(ValangValidator valangValidator) {
       this.valangValidator = valangValidator;
    }

    @Override
    public ValidationException validate(Object request) {

        Errors vErrors = new BindException(request, "target");

        valangValidator.validate(request, vErrors);
        if (vErrors.hasErrors()) {
            ValidationException faultInfo = new ValidationException();
            List<FieldErrorType> fieldErrors = faultInfo.getFieldError();
            for (ObjectError objErr : vErrors.getAllErrors()) {
                FieldErrorType fldErr = new FieldErrorType();
                fldErr.setField(objErr.getCode());
                fldErr.setErrorCode(objErr.getDefaultMessage());
                fldErr.setErrorDescription(objErr.getCode());
                fldErr.setSeverity("ERROR");
                fieldErrors.add(fldErr);
            }
            return faultInfo;
        }
        else
            return null;

    }
}
