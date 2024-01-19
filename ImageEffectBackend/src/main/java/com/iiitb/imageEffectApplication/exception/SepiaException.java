package com.iiitb.imageEffectApplication.exception;

public class SepiaException extends NoParameterException {
    SepiaException(String exceptionstring) {
        super(exceptionstring+"SepiaException detected");
    }
}
