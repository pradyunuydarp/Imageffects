#include "Rotation.h"
using namespace std;
// Function to rotate an image by 90 degrees clockwise
vector<vector<Pixel> > rotateBy90Clockwise(const vector<vector<Pixel> >& image) {
    // Get the number of rows and columns in the original image
    int rows = image.size();
    int cols = image[0].size();

    // Create a resultvector to store the rotated image (swap rows and columns)
    vector<vector<Pixel> > rotatedImage(cols, vector<Pixel>(rows));

    // Iterate pixel-wise in the original image and rotate it
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
             // Rotate the pixel and assign it to the corresponding position in the rotated image
            rotatedImage[j][rows - 1 - i] = image[i][j];
        }
    }

    // Return the rotated image
    return rotatedImage;
}

// Function to rotate an image by a specified angle
vector<vector<Pixel> > Rotation::rotateImage(const vector<vector<Pixel> >& image, int angle) {   
    int rotations = angle % 360;   // Calculate the number of 90degree rotations needed (in the range [0, 360))
    if (rotations < 0) {
        rotations += 360; // Convert negative angle to positive equivalent
    }
     // rotate based on angle
    switch (rotations) {
        case 1:
            return rotateBy90Clockwise(image);//rotate once by 90degrees
        case 2:
            return rotateBy90Clockwise(rotateBy90Clockwise(image));//rotate twice(180 degrees)
        case 3:
            return rotateBy90Clockwise(rotateBy90Clockwise(rotateBy90Clockwise(image)));//rotate thrice(270 degrees)
        default: // 0 or 360 degrees
            return image;
    }
}