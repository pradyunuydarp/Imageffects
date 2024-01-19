
package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.BrightnessException;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.BrightnessInterface;
import libraryInterfaces.Pixel;

public class Brightness extends BrightnessInterface implements SingleParameterEffects {
    private float value;
    private final LoggingService loggingService;

    public Brightness(LoggingService loggingService) {
        this.loggingService = loggingService;//create instance with LoggingService
    }

    @Override
    public void SetParameter(float value) throws BrightnessException, IllegalParameterException {
        System.out.println("Setting Brightness value: " + value);
        this.value = value;//set parameter
    }

    @Override
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws BrightnessException {
        Pixel[][] modifiedImage;
        modifiedImage = applyBrightness(inputImage, this.value);
        logBrightnessEffect(filename);//log the current application
        return modifiedImage;
    }

    public void logBrightnessEffect(String filename) {
        String effectName = "Brightness";
        String optionValues = "BrightnessValue: " + value;
        // Log the Brightness effect, call using the addLog method in LoggingService
        loggingService.addLog(filename, effectName, optionValues);
        System.out.println("Brightness effect logged.");
    }
}
