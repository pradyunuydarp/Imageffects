#include "Grayscale.h"
using namespace std;
vector<vector<Pixel> > Grayscale::applyGrayscaleFilter(const vector<vector<Pixel> >& image) {       // Function to convert a color image to grayscale
    //refer more about the algorithm here:
    //https://dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-grayscale-image-in-java
    vector<vector<Pixel> > grayscaleImage(image.size(), vector<Pixel>(image[0].size()));    // new vector to store the grayscale image
    for (size_t i = 0; i < image.size(); ++i) {         // Iterate through each row of the input image
        for (size_t j = 0; j < image[i].size(); ++j) {          // Iterate through each pixel in the current row
            int luminosity = static_cast<int>(0.21 * image[i][j].r + 0.72 * image[i][j].g + 0.07 * image[i][j].b);   // Calculate the luminosity value using the luminosity method
            grayscaleImage[i][j] = Pixel(luminosity, luminosity, luminosity);      // Set the grayscale pixel in the corresponding position
        }
    }

    return grayscaleImage;        // Return the resulting grayscale image
}