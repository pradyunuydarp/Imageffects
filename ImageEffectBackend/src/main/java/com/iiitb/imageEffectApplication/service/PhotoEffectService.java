package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.EffectImplementations.*;
import com.iiitb.imageEffectApplication.exception.*;
import com.iiitb.imageEffectApplication.utils.ProcessingUtils;
import libraryInterfaces.Pixel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService;

    /* PROCEDURE FOR EFFECT APPLICATION(COMMON FOR ALL EFFECTS)
     * create a new LoggingService and use it to create an instance of the effect
     * If the effect has parameters, setParameter() and catch the possible IllegalParameterException
     * The call the apply() method to create and return the modifiedImage*/
    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
//            Pixel[][] modifiedImage = applyHueSaturation(inputImage,saturationAmount,hueAmount); // Replace this with actual modified image
            LoggingService loggingService = new LoggingService();
            HueSaturation neweffect = new HueSaturation(loggingService);
            neweffect.SetParameter(saturationAmount,hueAmount);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HueSaturationException e) {
            throw new RuntimeException(e);
        } catch (IllegalParameterException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService loggingService = new LoggingService();
            System.out.println("In brightness setter");
//            Pixel[][] modifiedImage = applyBrightness(inputImage,amount); // Replace this with actual modified image
            Brightness neweffect = new Brightness(loggingService);
            neweffect.SetParameter(amount);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
           return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (BrightnessException e) {
            throw new RuntimeException(e);
        } catch (IllegalParameterException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            System.out.println("In contrast setter");
            LoggingService loggingService = new LoggingService();
//            Pixel[][] modifiedImage = ContrastInterface.applyContrast(inputImage,amount); // Replace this with actual modified image
            Contrast neweffect = new Contrast(loggingService);
            neweffect.SetParameter(amount);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ContrastException e) {
            throw new RuntimeException(e);
        } catch (IllegalParameterException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
//            Pixel[][] modifiedImage = applyFlip(inputImage,horizontalFlipValue,verticalFlipValue); // Replace this with actual modified image
            LoggingService loggingService = new LoggingService();
            Flip neweffect = new Flip(loggingService);
            neweffect.SetParameter(horizontalFlipValue,verticalFlipValue);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (FlipException e) {
            throw new RuntimeException(e);
        } catch (IllegalParameterException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
//            Pixel[][] modifiedImage = applyGaussianBlur(inputImage,radius); // Replace this with actual modified image
            LoggingService loggingService = new LoggingService();
            GaussianBlur neweffect = new GaussianBlur(loggingService);
            neweffect.SetParameter(radius);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (GaussianBlurException e) {
            throw new RuntimeException(e);
        } catch (IllegalParameterException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
//            Pixel[][] modifiedImage = applyGrayscale(inputImage); // Replace this with actual modified image
            LoggingService loggingService = new LoggingService();
            Grayscale neweffect = new Grayscale(loggingService);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (com.iiitb.imageEffectApplication.exception.NoParameterException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            System.out.println("In invert setter");
//            Pixel[][] modifiedImage = applyInvert(inputImage); // Replace this with actual modified image
            LoggingService loggingService = new LoggingService();
            Invert neweffect = new Invert(loggingService);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (com.iiitb.imageEffectApplication.exception.NoParameterException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
//            Pixel[][] modifiedImage = applyRotation(inputImage,value); // Replace this with actual modified image
            LoggingService loggingService = new LoggingService();
            Rotation neweffect = new Rotation(loggingService);
            neweffect.SetParameter(value);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            System.out.println(value);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RotationException e) {
            throw new RuntimeException(e);
        } catch (IllegalParameterException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            System.out.println("In sepia setter");
//            Pixel[][] modifiedImage = applySepia(inputImage); // Replace this with actual modified image
            LoggingService loggingService = new LoggingService();
            Sepia neweffect = new Sepia(loggingService);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (com.iiitb.imageEffectApplication.exception.NoParameterException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            System.out.println("In sharpen setter");
//            Pixel[][] modifiedImage = applySharpen(inputImage,amount); // Replace this with actual modified image
            LoggingService loggingService = new LoggingService();
            Sharpen neweffect = new Sharpen(loggingService);
            neweffect.SetParameter(amount);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (SharpenException e) {
            throw new RuntimeException(e);
        } catch (IllegalParameterException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            System.out.println("In dominant color setter");
//            Pixel[][] modifiedImage = applyDominantColour(inputImage); // Replace this with actual modified image
            LoggingService loggingService = new LoggingService();
            DominantColour neweffect = new DominantColour(loggingService);
            Pixel[][] modifiedImage = neweffect.apply(inputImage,imageName);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (com.iiitb.imageEffectApplication.exception.NoParameterException e) {
            throw new RuntimeException(e);
        }
    }
}
