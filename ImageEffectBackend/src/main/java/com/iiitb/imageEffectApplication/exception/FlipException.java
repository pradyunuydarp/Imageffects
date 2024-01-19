package com.iiitb.imageEffectApplication.exception;

public class FlipException extends DoubleParameterException {
    FlipException(String exceptionstring) {
        super(exceptionstring+"FlipException detected");
    }
}
