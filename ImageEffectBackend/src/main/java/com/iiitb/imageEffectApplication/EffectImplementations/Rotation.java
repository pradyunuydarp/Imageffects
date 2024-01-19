
package com.iiitb.imageEffectApplication.EffectImplementations;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.exception.RotationException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.RotationInterface;
import libraryInterfaces.Pixel;

// Class definition for the Rotation effect implementation
public class Rotation extends RotationInterface implements SingleParameterEffects {
    private float value;    // Private member to store the rotation value

    // LoggingService instance to log the rotation effect
    private final LoggingService loggingService;

    // Constructor to initialize the LoggingService
    public Rotation(LoggingService loggingService) {
        this.loggingService = loggingService;
    }


    @Override
    public void SetParameter(float value) throws RotationException, IllegalParameterException {
        // Check if the provided rotation value is valid
        if(value!=3.0 && value !=2.0 && value!=1.0 && value!=0.0){
            throw new IllegalParameterException("Invalid Parameters: Rotation can have possible parameters: 0,1,2, or 3 ONLY");
        }
        // Print a message indicating the rotation value is being set and set the rotation value
        System.out.println("Setting Rotation value: " + (int)value);
        this.value = value;
    }

    // Method to apply the rotation effect on the input image
    @Override
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws RotationException {
        Pixel[][] modifiedImage;
        // Apply rotation to the input image based on the stored rotation value
        modifiedImage = applyRotation(inputImage, (int)this.value);
        logRotationEffect(filename);
        return modifiedImage;
    }

    // Method to log the rotation effect
    public void logRotationEffect(String filename) {
        String effectName = "Rotation";
        String optionValues = "Value: " + (int)value +" / "+((int)value*90)+"degrees";
        // Log the Rotation effect call using the LoggingService
        loggingService.addLog(filename, effectName, optionValues);
        System.out.println("Rotation effect logged.");
    }
}