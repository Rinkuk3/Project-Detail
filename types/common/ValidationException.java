package com.td.mbna.msec.midtier.types.common;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
    private List<FieldErrorType> fieldError = new ArrayList<>();

    public List<FieldErrorType> getFieldError() {
        return fieldError;
    }

    public void setFieldError(List<FieldErrorType> fieldError) {
        this.fieldError = fieldError;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ValidationException.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("fieldError");
        sb.append('=');
        sb.append(((this.fieldError == null)?"<null>":this.fieldError));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.fieldError == null)? 0 :this.fieldError.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ValidationException)) {
            return false;
        }
        ValidationException rhs = ((ValidationException) other);
        return ((this.fieldError == rhs.fieldError)||((this.fieldError!= null)&&this.fieldError.equals(rhs.fieldError)));
    }

}
