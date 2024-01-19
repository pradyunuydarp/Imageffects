package com.iiitb.imageEffectApplication.EffectImplementations;
import java.lang.Exception;
import libraryInterfaces.Pixel;
//abstract class SingleParameterException extends Exception{
//    SingleParameterException(float value,String exceptionstring){
//
//    }
//}
interface SingleParameterEffects{
    void SetParameter(float value)throws com.iiitb.imageEffectApplication.exception.SingleParameterException,com.iiitb.imageEffectApplication.exception.IllegalParameterException;
     Pixel[][] apply(Pixel[][]inputImage,String filename)throws com.iiitb.imageEffectApplication.exception.SingleParameterException;
}