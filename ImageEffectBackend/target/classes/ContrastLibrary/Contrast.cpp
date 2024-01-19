#include "Contrast.h"
#include "../Pixel.h"
#include <algorithm>
using namespace std;
// Clamp function to ensure a value is within a specified range
int clamp(int value, int min, int max) {
    return std::max(min, std::min(value, max));
}

// Function to apply contrast to the given image
vector<vector<Pixel> > Contrast::applyContrast(const vector<vector<Pixel> >& image, float amount) {
    vector<vector<Pixel> > resultVector;
    resultVector.reserve(image.size());

    // Applying contrast to each row in the image
    for (const auto& row : image) {
        vector<Pixel> newRow;
        newRow.reserve(row.size());

        // Applying contrast to each pixel in the row
        for (const auto& pixel : row) {
            // Applying contrast algorithm to each RGB component
            int r = pixel.r;
            int g = pixel.g;
            int b = pixel.b;

            // Computing the contrast factor
            float factor = (259.0f * (amount + 255.0f)) / (255.0f * (259.0f - amount));

            // Applying contrast transformation to each RGB component
            r = clamp(static_cast<int>(factor * (r - 128) + 128), 0, 255);
            g = clamp(static_cast<int>(factor * (g - 128) + 128), 0, 255);
            b = clamp(static_cast<int>(factor * (b - 128) + 128), 0, 255);

            // Creating a new pixel with contrast applied and adding it to the row
            newRow.emplace_back(Pixel(r, g, b));
        }

        // Adding the row with contrast-applied pixels to the result
        resultVector.emplace_back(newRow);
    }

    return resultVector;
}
