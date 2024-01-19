package com.iiitb.imageEffectApplication.exception;

import com.iiitb.imageEffectApplication.exception.SingleParameterException;

public class BrightnessException extends SingleParameterException {
    BrightnessException(float value, String exceptionstring) {
        super(value, exceptionstring+"BrightnessException detected");
    }
}
