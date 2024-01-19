
package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.ContrastException;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.ContrastInterface;
import libraryInterfaces.Pixel;

public class Contrast extends ContrastInterface implements SingleParameterEffects {
    private float value; // The contrast value to be set
    private final LoggingService loggingService; // Logging service to log the effect

    // Constructor to initialize the logging service
    public Contrast(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    // Method to set the contrast value
    @Override
    public void SetParameter(float value) throws ContrastException, IllegalParameterException {
        System.out.println("Setting Contrast value: " + value);
        this.value = value;
    }

    // Method to apply the contrast effect to an image
    @Override
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws ContrastException {
        Pixel[][] modifiedImage;
        modifiedImage = applyContrast(inputImage, this.value);
        logContrastEffect(filename); // Logging the contrast effect
        return modifiedImage;
    }

    // Method to log the contrast effect
    public void logContrastEffect(String filename) {
        String effectName = "Contrast";
        String optionValues = "ContrastValue: " + value;
        // Log the Contrast effect call using the LoggingService
        loggingService.addLog(filename, effectName, optionValues);
        System.out.println("Contrast effect logged.");
    }
}
