package com.iiitb.imageEffectApplication.exception;

import com.iiitb.imageEffectApplication.exception.SingleParameterException;

public class ContrastException extends SingleParameterException {
    ContrastException(float value, String exceptionstring) {
        super(value, exceptionstring+"ContrastException detected");
    }
}
