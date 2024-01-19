
package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.FlipException;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.FlipInterface;
import libraryInterfaces.Pixel;

public class Flip extends FlipInterface implements DoubleParameterEffects {
    private float value1;
    private float value2;
    private final LoggingService loggingService;

    public Flip(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public void SetParameter(float value1,float value2) throws FlipException, IllegalParameterException {
        if((value1!=0.0 && value1!=1.0)||(value2!=0.0)&&(value2!=1.0)){
            throw new IllegalParameterException("Invalid Parameters: Flip can have parameters {(0 or 1),(0 or 1)} ONLY");
        }
        System.out.println("Setting Flip value: " + value1+","+value2);
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws FlipException {
        Pixel[][] modifiedImage;
        modifiedImage = applyFlip(inputImage, (int)this.value1,(int)this.value2);
        logFlipEffect(filename);
        return modifiedImage;
    }

    public void logFlipEffect(String filename) {
        String effectName = "Flip";
        String optionValues = "FlipValue: " + "hor:"+(int)value1 +",vert:"+(int)value2;
        loggingService.addLog(filename, effectName, optionValues);
        System.out.println("Flip effect logged.");
    }
}
