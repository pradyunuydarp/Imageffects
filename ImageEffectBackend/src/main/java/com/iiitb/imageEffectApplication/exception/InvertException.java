package com.iiitb.imageEffectApplication.exception;

public class InvertException extends NoParameterException {
    InvertException(String exceptionstring) {
        super(exceptionstring+"InvertException detected");
    }
}
