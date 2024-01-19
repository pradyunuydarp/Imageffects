package com.iiitb.imageEffectApplication.exception;

public class RotationException extends SingleParameterException {
    RotationException(float value, String exceptionstring) {
        super(value, exceptionstring+"RotationException detected");
    }
}
