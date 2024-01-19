package com.iiitb.imageEffectApplication.exception;

public class DominantColourException extends NoParameterException {
    DominantColourException(String exceptionstring) {
        super(exceptionstring+"DominantColourException detected");
    }
}
