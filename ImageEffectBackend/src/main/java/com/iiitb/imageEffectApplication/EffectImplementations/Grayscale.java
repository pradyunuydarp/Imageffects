package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.GrayscaleException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.GrayscaleInterface;
import libraryInterfaces.Pixel;

public class Grayscale extends GrayscaleInterface implements NoParameterEffects {          // Class declaration for the Grayscale effect, extending GrayscaleInterface and implementing NoParameterEffects
    private final LoggingService loggingService;                 // Private variable

    public Grayscale(LoggingService loggingService) {          // Constructor for Grayscale class that takes a LoggingService instance as a parameter
        this.loggingService = loggingService;
    }

    @Override                                        // Overridden apply method from the GrayscaleInterface
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws GrayscaleException {
        Pixel[][] modifiedImage;                      // Variable to store the modified image after applying the Grayscale effect
        modifiedImage = applyGrayscale(inputImage);          // Applying the Grayscale effect to the input image
        logGrayscaleEffect(filename);
        return modifiedImage;                // Returning the modified image
    }

    public void logGrayscaleEffect(String filename) {            // Method to log the Grayscale effect using the LoggingService
        String effectName = "Grayscale";
        String optionValues = "GrayscaleValue: None";
        loggingService.addLog(filename, effectName, optionValues);         // Log the Grayscale effect call using the LoggingService
        System.out.println("Grayscale effect logged.");           // Printing that the Grayscale effect has been logged
    }
}
