#include "GaussianBlur.h"
#include <cmath>
using namespace std;
vector<vector<Pixel> > GaussianBlur::applyGaussianBlur(const vector<vector<Pixel> >& image, float radius) {
    
    //refer to the following link to learn more about the algorithm
    //https://aryamansharda.medium.com/image-filters-gaussian-blur-eb36db6781b1
    
    if (radius <= 0) {
        return image; // If radius is 0 or negative, return the original image (no blur)
    }

    vector<vector<Pixel> > blurredImage = image;

    int kernelSize = 2 * static_cast<int>(radius) + 1;
    float sigma = radius / 2.0f;
    vector<float> kernel(kernelSize);

    // Create 1D Gaussian kernel
    float sum = 0.0f;
    for (int i = 0; i < kernelSize; ++i) {
        int x = i - static_cast<int>(radius);
        kernel[i] = exp(-(x * x) / (2 * sigma * sigma)) / (sqrt(2 * M_PI) * sigma);
        sum += kernel[i];
    }

    // Normalize the kernel
    for (int i = 0; i < kernelSize; ++i) {
        kernel[i] /= sum;
    }

    //Gaussian blur is just the 2D convolution of the image with a kernel. Radius is the size of the kernel. The kernel has a gaussian distribution and is prefferably odd sized to have a central pixel.

    // Apply horizontal blur
    for (size_t i = 0; i < image.size(); ++i) {
        for (size_t j = 0; j < image[i].size(); ++j) {
            float rAcc = 0.0f, gAcc = 0.0f, bAcc = 0.0f;
            for (int k = -static_cast<int>(radius), idx = 0; k <= static_cast<int>(radius); ++k, ++idx) {
                int col = j + k;
                if (col >= 0 && col < static_cast<int>(image[i].size())) {
                    rAcc += image[i][col].r * kernel[idx];
                    gAcc += image[i][col].g * kernel[idx];
                    bAcc += image[i][col].b * kernel[idx];
                    //We multiply pixel values with kernel values while shifting the kernel and add them, this is convolution 
                }
            }
            blurredImage[i][j] = Pixel(static_cast<int>(rAcc), static_cast<int>(gAcc), static_cast<int>(bAcc));
        }
    }

    // Apply vertical blur
    vector<vector<Pixel> > tempImage = blurredImage;
    for (size_t i = 0; i < image.size(); ++i) {
        for (size_t j = 0; j < image[i].size(); ++j) {
            float rAcc = 0.0f, gAcc = 0.0f, bAcc = 0.0f;
            for (int k = -static_cast<int>(radius), idx = 0; k <= static_cast<int>(radius); ++k, ++idx) {
                int row = i + k;
                if (row >= 0 && row < static_cast<int>(image.size())) {
                    rAcc += tempImage[row][j].r * kernel[idx];
                    gAcc += tempImage[row][j].g * kernel[idx];
                    bAcc += tempImage[row][j].b * kernel[idx];
                }
            }
            blurredImage[i][j] = Pixel(static_cast<int>(rAcc), static_cast<int>(gAcc), static_cast<int>(bAcc));
        }
    }

    return blurredImage;
}