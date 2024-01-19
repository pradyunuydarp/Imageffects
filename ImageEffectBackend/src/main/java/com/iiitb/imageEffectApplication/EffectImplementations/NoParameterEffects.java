package com.iiitb.imageEffectApplication.EffectImplementations;

//import com.iiitb.imageEffectApplication.exception;
import libraryInterfaces.Pixel;
//class NoParameterException extends Exception{
//    NoParameterException(String exceptionstring){
//
//    }
//}
interface NoParameterEffects{
    Pixel[][] apply(Pixel[][]inputImage,String filename) throws com.iiitb.imageEffectApplication.exception.NoParameterException;
}