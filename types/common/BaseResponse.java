package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 5475704429121609485L;

    protected String status;
    protected List<String> errorMsgs = new ArrayList<String>();
    protected List<Error> errorMessages = new ArrayList<Error>();
    List<FieldErrorType> validationErrors = new ArrayList<>();


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Error> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<Error> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<FieldErrorType> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<FieldErrorType> validationErrors) {
        this.validationErrors = validationErrors;
    }

	public List<String> getErrorMsgs() {
		return errorMsgs;
	}

	public void setErrorMsgs(List<String> errorMsgs) {
		this.errorMsgs = errorMsgs;
	}
    
    
}
