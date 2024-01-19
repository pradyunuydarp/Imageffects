package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.exception.SharpenException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.SharpenInterface;
import libraryInterfaces.Pixel;

public class Sharpen extends SharpenInterface implements SingleParameterEffects {             // Class declaration for the Sharpen extending SharpenInterface and implementing SingleParameterEffects.
    private float value;
    private final LoggingService loggingService;      // Private variable to store the instance of LoggingService.

    public Sharpen(LoggingService loggingService) {               // Constructor for Sharpen class with LoggingService instance as parameter
        this.loggingService = loggingService;
    }

    @Override            // Method to set the sharpening value
    public void SetParameter(float value) throws SharpenException, IllegalParameterException {
        System.out.println("Setting Sharpen value: " + value);        // Print that the sharpen value is being set
        this.value = value;         // Set the sharpening value
    }

    @Override
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws SharpenException {       // This method applies the Sharpen effect to the input image using the specified sharpening value and logs the effect
        Pixel[][] modifiedImage;             // Variable to store the modified image
        modifiedImage = applySharpen(inputImage, this.value);    // Applying the Sharpen effect to the input image
        logSharpenEffect(filename);
        return modifiedImage;           // Returning the modified image
    }

    public void logSharpenEffect(String filename) {        // Method to log the Sharpen effect using the LoggingService
        String effectName = "Sharpen";
        String optionValues = "SharpenValue: " + value;
        loggingService.addLog(filename, effectName, optionValues);  // Log the Sharpen effect call using the LoggingService
        System.out.println("Sharpen effect logged.");       // Printing that the Sharpen effect has been logged
    }
}
