
package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.GaussianBlurException;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.GaussianBlurInterface;
import libraryInterfaces.Pixel;

public class GaussianBlur extends GaussianBlurInterface implements SingleParameterEffects {
    private float value;
    private final LoggingService loggingService;

    public GaussianBlur(LoggingService loggingService) {
        this.loggingService = loggingService;//instantiate with a LoggingService
    }

    @Override
    public void SetParameter(float value) throws GaussianBlurException, IllegalParameterException {
        System.out.println("Setting GaussianBlur radius: " + value);
        this.value = value;
    }

    @Override
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws GaussianBlurException {
        Pixel[][] modifiedImage;
        modifiedImage = applyGaussianBlur(inputImage, this.value);
        logGaussianBlurEffect(filename);//log the instantiation
        return modifiedImage;
    }

    public void logGaussianBlurEffect(String filename) {
        String effectName = "GaussianBlur";
        String optionValues = "Radius: " + value;
        // Log the GaussianBlur effect, call using the addLog method of LoggingService
        loggingService.addLog(filename, effectName, optionValues);
        System.out.println("GaussianBlur effect logged.");
    }
}
