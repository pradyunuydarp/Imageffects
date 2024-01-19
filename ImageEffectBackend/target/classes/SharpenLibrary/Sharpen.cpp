#include "Sharpen.h"
#include <cmath>
using namespace std;
vector<vector<Pixel> > Sharpen::applySharpen(const vector<vector<Pixel> >& image, float amount) { // Function to apply sharpening filter to an input image
    vector<vector<Pixel> > result;
    result.reserve(image.size());

    for (size_t i = 0; i < image.size(); ++i) {      // Loop through each row of the input image
        vector<Pixel> newRow;
        newRow.reserve(image[i].size());

        for (size_t j = 0; j < image[i].size(); ++j) {       // Loop through each pixel in the current row
            Pixel sharpenedPixel = calculateSharpenPixel(image, i, j, amount);  // Calculate the sharpened pixel using the sharpening mask
            newRow.emplace_back(sharpenedPixel);
        }

        result.emplace_back(newRow);         // Add the sharpened row to the result image
    }

    return result;
}

Pixel Sharpen::calculateSharpenPixel(const vector<vector<Pixel> >& image, int x, int y, float amount) {      // Function to calculate a sharpened pixel value using a convolutional sharpening mask
    const int maskSize = 3;            // Define the sharpening mask
    const float sharpenMask[maskSize][maskSize] = {
        {-1.0f, -1.0f, -1.0f},
        {-1.0f,  9.0f, -1.0f},
        {-1.0f, -1.0f, -1.0f}
    };

    float rSum = 0.0f, gSum = 0.0f, bSum = 0.0f;
 
    for (int i = -1; i <= 1; ++i) {        // Loop through each element in the sharpening mask
        for (int j = -1; j <= 1; ++j) {
            int newX = x + i;               // new coordinates in the image
            int newY = y + j;

            if (newX >= 0 && newX < static_cast<int>(image.size()) && newY >= 0 && newY < static_cast<int>(image[x].size())) {      // Check boundaries and apply the mask to calculate the weighted sum
                rSum += image[newX][newY].r * sharpenMask[i + 1][j + 1];
                gSum += image[newX][newY].g * sharpenMask[i + 1][j + 1];
                bSum += image[newX][newY].b * sharpenMask[i + 1][j + 1];
            }
        }
    }

    int r = static_cast<int>((1 - amount) * image[x][y].r + amount * rSum);          // Calculate the final sharpened pixel values using the weighted sum and the original pixel values
    int g = static_cast<int>((1 - amount) * image[x][y].g + amount * gSum);
    int b = static_cast<int>((1 - amount) * image[x][y].b + amount * bSum);

    r = (r < 0) ? 0 : (r > 255) ? 255 : r;          // Clamp the values to the valid range [0, 255]
    g = (g < 0) ? 0 : (g > 255) ? 255 : g;
    b = (b < 0) ? 0 : (b > 255) ? 255 : b;

    return Pixel(r, g, b);         // Return the resulting sharpened pixel
}
