package com.iiitb.imageEffectApplication.exception;
import java.lang.Exception;
import libraryInterfaces.Pixel;
public class NoParameterException extends Exception{
    protected NoParameterException(String exceptionstring){
        super(exceptionstring+"(NoParameterException)");
    }
}