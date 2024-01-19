#include "Brightness.h"
#include "../Pixel.h" 
#include <vector>
#include <algorithm>
using namespace std;
vector<vector<Pixel> >Brightness::applyBrightness(vector<vector<Pixel> >& image, float amount) {
    vector<vector<Pixel> > resultImage;

    // adjust brightness to each pixel in the image
    for (const auto& row : image) {
        vector<Pixel> resultRow;
        for (const auto& pixel : row) {
            // Adjust the brightness of the pixel by the below algorithm
            Pixel adjustedPixel;
            adjustedPixel.r = static_cast<int>(pixel.r * amount/100);
            adjustedPixel.g = static_cast<int>(pixel.g * amount/100);
            adjustedPixel.b = static_cast<int>(pixel.b * amount/100);

            // Ensure the values are within the valid range (0 to 255)
            // adjustedPixel.r = clamp(adjustedPixel.r, 0, 255);
            // adjustedPixel.g = clamp(adjustedPixel.g, 0, 255);
            // adjustedPixel.b = clamp(adjustedPixel.b, 0, 255);
            if(adjustedPixel.r>255)
                adjustedPixel.r=255;
            if(adjustedPixel.g>255)
                adjustedPixel.g=255;
            if(adjustedPixel.b>255)
                adjustedPixel.b=255; 

            resultRow.push_back(adjustedPixel);//add the modified pixel to resultVector
        }
        resultImage.push_back(resultRow);//add the modified row to resultVector
    }

    return resultImage;//return the modifiedImage(resultVector)
}

// Helper function to clamp a value within a given range
int clamp(int value, int minValue, int maxValue) {
    return std::max(minValue, std::min(value, maxValue));
}
