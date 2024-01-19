#include "Invert.h"
#include "../Pixel.h"
using namespace std;
// Function to invert the given image's colours
vector<vector<Pixel> > Invert::invertImage(const vector<vector<Pixel> >& image) {
    vector<vector<Pixel> > resultVector;
    resultVector.reserve(image.size());

    // Inverting each row in the image
    for (const auto& row : image) {
        vector<Pixel> newRow;
        newRow.reserve(row.size());

        // Inverting each pixel in the row
        for (const auto& pixel : row) {
            // Inverting RGB values
            int r = 255 - pixel.r;
            int g = 255 - pixel.g;
            int b = 255 - pixel.b;

            // Creating a new inverted pixel and adding it to the row
            newRow.emplace_back(Pixel(r, g, b));
        }

        // Adding the inverted row to the result
        resultVector.emplace_back(newRow);
    }

    return resultVector;
}