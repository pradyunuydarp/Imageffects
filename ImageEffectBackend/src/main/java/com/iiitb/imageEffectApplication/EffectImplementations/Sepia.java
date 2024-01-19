
package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.SepiaException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.SepiaInterface;
import libraryInterfaces.Pixel;

public class Sepia extends SepiaInterface implements NoParameterEffects {
    private final LoggingService loggingService;

    public Sepia(LoggingService loggingService) {
        this.loggingService = loggingService;//create a LoggingService for the corresponding instance on instantiation
    }

    @Override
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws SepiaException {
        Pixel[][] modifiedImage;
        modifiedImage = applySepia(inputImage);//apply Sepia effect
        logSepiaEffect(filename);//Create a log post-application of sepia effect
        return modifiedImage;//return the modified image
    }

    public void logSepiaEffect(String filename) {
        String effectName = "Sepia";
        String optionValues = "SepiaValue: None";//Sepia has no parameters
        // Log the Sepia effect by calling 'addLog' method in LoggingService
        loggingService.addLog(filename, effectName, optionValues);
        System.out.println("Sepia effect logged.");
    }
}
