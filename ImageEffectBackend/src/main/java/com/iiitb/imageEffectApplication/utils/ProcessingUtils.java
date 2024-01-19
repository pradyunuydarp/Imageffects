package com.iiitb.imageEffectApplication.utils;

import libraryInterfaces.Pixel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class ProcessingUtils {

    public Pixel[][] convertBufferedImageToPixelArray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        Pixel[][] pixelArray = new Pixel[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                pixelArray[y][x] = new Pixel(
                        (rgb >> 16) & 0xFF,  // Red
                        (rgb >> 8) & 0xFF,   // Green
                        rgb & 0xFF           // Blue
                );
            }
        }

        return pixelArray;
    }

    public BufferedImage convertPixelArrayToBufferedImage(Pixel[][] pixelArray) {
        int height = pixelArray.length;
        int width = pixelArray[0].length;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel pixel = pixelArray[y][x];
                int rgb = new Color(pixel.getR(), pixel.getG(), pixel.getB()).getRGB();
                bufferedImage.setRGB(x, y, rgb);
            }
        }

        return bufferedImage;
    }

    public ResponseEntity<byte[]> postProcessing(Pixel[][] modifiedImage) throws IOException {
        // Convert modified image to BufferedImage
        BufferedImage modifiedBufferedImage = convertPixelArrayToBufferedImage(modifiedImage);

        // Convert BufferedImage to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(modifiedBufferedImage, "png", baos);
        byte[] imageBytes = baos.toByteArray();

        // Set up HttpHeaders for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "modified_image.png");

        // Return the modified image as a downloadable file
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    public Pixel[][] preprocessing(MultipartFile imageFile) throws IOException {
        // Convert MultipartFile to BufferedImage
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageFile.getBytes()));
        return convertBufferedImageToPixelArray(originalImage);
    }
}
