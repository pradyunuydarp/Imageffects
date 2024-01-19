package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.InvertException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.InvertInterface;
import libraryInterfaces.Pixel;

public class Invert extends InvertInterface implements NoParameterEffects {
    private final LoggingService loggingService; // Logging service to log the effect

    // Constructor to initialize the logging service
    public Invert(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    // Method to apply the invert effect to an image
    @Override
    public Pixel[][] apply(Pixel[][] inputImage, String filename) throws InvertException {
        Pixel[][] modifiedImage;
        modifiedImage = applyInvert(inputImage); // Applying invert effect
        logInvertEffect(filename); // Logging the invert effect
        return modifiedImage;
    }

    // Method to log the invert effect
    public void logInvertEffect(String filename) {
        String effectName = "Invert";
        String optionValues = "InvertValue: None";
        // Log the Invert effect call using the LoggingService
        loggingService.addLog(filename, effectName, optionValues);
        System.out.println("Invert effect logged.");
    }
}
