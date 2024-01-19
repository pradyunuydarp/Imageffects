package com.iiitb.imageEffectApplication.exception;

public class IllegalParameterException extends Exception {

    public IllegalParameterException() {
        super("IllegalParameterException detected");
    }

    public IllegalParameterException(String message) {
        super(message);
    }

    public IllegalParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalParameterException(Throwable cause) {
        super(cause);
    }
}
