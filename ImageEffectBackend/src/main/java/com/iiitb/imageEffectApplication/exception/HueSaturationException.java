package com.iiitb.imageEffectApplication.exception;

public class HueSaturationException extends DoubleParameterException {
    HueSaturationException(String exceptionstring) {
        super(exceptionstring+"HueSaturationException detected");
    }
}
