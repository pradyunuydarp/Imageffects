package com.iiitb.imageEffectApplication.exception;
import java.lang.Exception;
import libraryInterfaces.Pixel;
public class DoubleParameterException extends Exception{
    protected DoubleParameterException(String exceptionstring){
        super(exceptionstring+"(DoubleParameterException)");
    }
}