#include "HueSaturation.h"
#include <cmath>
using namespace std;
float HueToRGB(float p, float q, float t) {
    if (t < 0.0f) t += 1.0f;
    if (t > 1.0f) t -= 1.0f;

    if (t < 1.0f / 6.0f) return p + (q - p) * 6.0f * t;
    if (t < 1.0f / 2.0f) return q;
    if (t < 2.0f / 3.0f) return p + (q - p) * (2.0f / 3.0f - t) * 6.0f;

    return p;
}

vector<vector<Pixel> > HueSaturation::adjustHueSaturation(const vector<vector<Pixel> >& image, float saturationValue, float hueValue) {
    vector<vector<Pixel> > adjustedImage = image;

    for (auto& row : adjustedImage) {
        for (auto& pixel : row) {
            // Convert RGB to HSV (Hue, Saturation, Value/Brightness)
            float r = pixel.r / 255.0f;
            float g = pixel.g / 255.0f;
            float b = pixel.b / 255.0f;
            //to do it use this algorithm
            //https://www.geeksforgeeks.org/program-change-rgb-color-model-hsv-color-model/
            float maxVal = fmaxf(fmaxf(r, g), b);
            float minVal = fminf(fminf(r, g), b);
            float delta = maxVal - minVal;

            float hue = 0.0f, saturation = 0.0f, value = maxVal;
            if (delta > 0.00001f) {
                if (maxVal == r) hue = 60.0f * fmodf(((g - b) / delta), 6.0f);
                else if(maxVal == g) hue = 60.0f * (((b - r) / delta) + 2.0f);
                else hue = 60.0f * (((r - g) / delta) + 4.0f);

                if (maxVal > 0.0f) saturation = delta / maxVal;
            }

            // Adjust hue and saturation values of converted pixels
            hue += hueValue;
            if (hue < 0.0f) hue += 360.0f;
            if (hue > 360.0f) hue -= 360.0f;

            saturation *= saturationValue;
            if (saturation < 0.0f) saturation = 0.0f;
            if (saturation > 1.0f) saturation = 1.0f;

            // Convert adjusted pixels back to RGB
            float c = value * saturation;
            float x = c * (1.0f - fabsf(fmodf((hue / 60.0f), 2.0f) - 1.0f));
            float m = value - c;

            float r1, g1, b1;
            if (0.0f <= hue && hue < 60.0f){
                r1 = c;
                g1 = x; 
                b1 = 0.0f;
            }
            else if(60.0f <= hue && hue < 120.0f) {
                r1 = x; 
                g1 = c; 
                b1 = 0.0f;
            }
            else if(120.0f <= hue && hue < 180.0f){ 
                r1 = 0.0f; 
                g1 = c; 
                b1 = x;
            }
            else if(180.0f <= hue && hue < 240.0f){ 
                r1 = 0.0f; 
                g1 = x; 
                b1 = c;
            }
            else if(240.0f <= hue && hue < 300.0f){
                r1 = x; 
                g1 = 0.0f; 
                b1 = c;
            }
            else{
                r1 = c; 
                g1 = 0.0f; 
                b1 = x;
            }
            pixel.r = static_cast<int>((r1 + m) * 255.0f);
            pixel.g = static_cast<int>((g1 + m) * 255.0f);
            pixel.b = static_cast<int>((b1 + m) * 255.0f);
        }
    }

    return adjustedImage;
}