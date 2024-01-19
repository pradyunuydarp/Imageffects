package com.iiitb.imageEffectApplication.EffectImplementations;
import java.lang.Exception;
import libraryInterfaces.Pixel;
interface DoubleParameterEffects{
    void SetParameter(float value1,float value2)throws com.iiitb.imageEffectApplication.exception.DoubleParameterException,com.iiitb.imageEffectApplication.exception.IllegalParameterException;
    Pixel[][] apply(Pixel[][]inputImage,String filename)throws com.iiitb.imageEffectApplication.exception.DoubleParameterException;
}