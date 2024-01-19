package com.iiitb.imageEffectApplication.exception;

import com.iiitb.imageEffectApplication.exception.SingleParameterException;

public class SharpenException extends SingleParameterException {
    SharpenException(float value, String exceptionstring) {
        super(value, exceptionstring+"SharpenException detected");
    }
}
