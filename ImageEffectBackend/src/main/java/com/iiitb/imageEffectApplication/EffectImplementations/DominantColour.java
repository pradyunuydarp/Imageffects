
package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.DominantColourException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.DominantColourInterface;
import libraryInterfaces.Pixel;

public class DominantColour extends DominantColourInterface implements NoParameterEffects {
    private final LoggingService loggingService;

    public DominantColour(LoggingService loggingService) {
        this.loggingService = loggingService;//create a LoggingService for the corresponding instance on instantiation
    }

    @Override
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws DominantColourException {
        Pixel[][] modifiedImage;
        modifiedImage = applyDominantColour(inputImage);//Get the DominantColour
        logDominantColourEffect(filename);
        return modifiedImage;//return the modified image
    }

    public void logDominantColourEffect(String filename) {
        String effectName = "DominantColour";
        String optionValues = "DominantColourValue: None"; //DominantColour has no parameters
        // Log the effect by calling 'addLog' method in LoggingService
        loggingService.addLog(filename, effectName, optionValues);
        System.out.println("DominantColour effect logged.");
    }
}
