package com.iiitb.imageEffectApplication.exception;

import com.iiitb.imageEffectApplication.exception.SingleParameterException;

public class GaussianBlurException extends SingleParameterException {
    GaussianBlurException(float value, String exceptionstring) {
        super(value, exceptionstring+"BrightnessException detected");
    }
}
