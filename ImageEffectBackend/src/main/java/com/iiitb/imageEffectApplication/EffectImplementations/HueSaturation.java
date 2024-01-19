
package com.iiitb.imageEffectApplication.EffectImplementations;

import com.iiitb.imageEffectApplication.exception.HueSaturationException;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.HueSaturationInterface;
import libraryInterfaces.Pixel;

public class HueSaturation extends HueSaturationInterface implements DoubleParameterEffects {
    private float value1;
    private float value2;
    private final LoggingService loggingService;

    public HueSaturation(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public void SetParameter(float value1,float value2) throws HueSaturationException, IllegalParameterException {
        System.out.println("Setting HueSaturation value: " + value1+","+value2);
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public Pixel[][] apply(Pixel[][] inputImage,String filename) throws HueSaturationException {
        Pixel[][] modifiedImage;
        modifiedImage = applyHueSaturation(inputImage, this.value1,this.value2);
        logHueSaturationEffect(filename);//instantiate with a LoggingService
        return modifiedImage;
    }

    public void logHueSaturationEffect(String filename) {
        String effectName = "HueSaturation";
        String optionValues = "sat:"+value1 +",hue:"+value2;
        // Log the HueSaturation effect call using the LoggingService
        loggingService.addLog(filename, effectName, optionValues);
        System.out.println("HueSaturation effect logged.");
    }
}
