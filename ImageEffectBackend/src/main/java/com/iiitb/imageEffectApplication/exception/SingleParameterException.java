package com.iiitb.imageEffectApplication.exception;
import java.lang.Exception;
import libraryInterfaces.Pixel;
public class SingleParameterException extends Exception{
    protected SingleParameterException(float value, String exceptionstring){
        super(exceptionstring+"(SingleParameterException)");
    }
}