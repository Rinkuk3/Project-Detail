package com.td.mbna.msec.midtier.service;

import com.td.mbna.msec.midtier.types.common.ValidationException;

public interface MsecValidator {
    public ValidationException validate(Object request);
}
