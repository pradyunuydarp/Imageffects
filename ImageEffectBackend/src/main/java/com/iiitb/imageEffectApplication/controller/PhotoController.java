package com.iiitb.imageEffectApplication.controller;

import com.iiitb.imageEffectApplication.service.PhotoEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/effect")
public class PhotoController {

    @Autowired
    private PhotoEffectService photoEffectService;

    @PostMapping("/hue-saturation")
    public ResponseEntity<byte[]> applyHueSaturationEffect(
            @RequestParam("hueAmount") float hueAmount,
            @RequestParam("saturationAmount") float saturationAmount,
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applyHueSaturationEffect(hueAmount, saturationAmount, imageFile);
    }

    @PostMapping("/brightness")
    public ResponseEntity<byte[]> applyBrightnessEffect(
            @RequestParam("amount") float amount,
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applyBrightnessEffect(amount, imageFile);
    }

    @PostMapping("/contrast")
    public ResponseEntity<byte[]> applyContrastEffect(
            @RequestParam("amount") float amount,
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applyContrastEffect(amount, imageFile);
    }

    @PostMapping("/flip")
    public ResponseEntity<byte[]> applyFlipEffect(
            @RequestParam("horizontalFlipValue") int horizontalFlipValue,
            @RequestParam("verticalFlipValue") int verticalFlipValue,
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applyFlipEffect(imageFile, horizontalFlipValue, verticalFlipValue);
    }

    @PostMapping("/gaussian-blur")
    public ResponseEntity<byte[]> applyGaussianBlurEffect(
            @RequestParam("radius") float radius,
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applyGaussianBlurEffect(radius, imageFile);
    }

    @PostMapping("/grayscale")
    public ResponseEntity<byte[]> applyGrayscaleEffect(
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applyGrayscaleEffect(imageFile);
    }

    @PostMapping("/invert")
    public ResponseEntity<byte[]> applyInvertEffect(
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applyInvertEffect(imageFile);
    }

    @PostMapping("/rotation")
    public ResponseEntity<byte[]> applyRotationEffect(
            @RequestParam("value") int value,
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applyRotationEffect(value, imageFile);
    }

    @PostMapping("/sepia")
    public ResponseEntity<byte[]> applySepiaEffect(
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applySepiaEffect(imageFile);
    }

    @PostMapping("/sharpen")
    public ResponseEntity<byte[]> applySharpenEffect(
            @RequestParam("amount") float amount,
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.applySharpenEffect(amount, imageFile);
    }

    @PostMapping("/dominant-colour")
    public ResponseEntity<byte[]> getDominantColour(
            @RequestParam("imageFile") MultipartFile imageFile
    ) {
        return photoEffectService.getDominantColour(imageFile);
    }

}
