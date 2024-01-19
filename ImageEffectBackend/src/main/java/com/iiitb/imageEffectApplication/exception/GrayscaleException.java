package com.iiitb.imageEffectApplication.exception;

public class GrayscaleException extends NoParameterException {
    GrayscaleException(String exceptionstring) {
        super(exceptionstring+"GrayscaleException detected");
    }
}
