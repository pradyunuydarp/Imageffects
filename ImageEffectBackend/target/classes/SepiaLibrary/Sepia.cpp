#include "Sepia.h"
using namespace std;
vector<vector<Pixel> > Sepia::applySepia(const vector<vector<Pixel> >& image) {
    vector<vector<Pixel> > result;//modifiedImage (2D vector of Pixels)
    result.reserve(image.size());//reserve the number of rows in the original image to be the number of rows in the modifiedImage
    const float sepiaMatrix[3][3] = {//create the 3x3 sepia matrix: contains the actual filter values needed to apply the Sepia filter
        {0.393f, 0.769f, 0.189f},
        {0.349f, 0.686f, 0.168f},
        {0.272f, 0.534f, 0.131f}
    };

    for (const auto& row : image) {
        vector<Pixel> newRow;
        newRow.reserve(row.size());

        for (const auto& pixel : row) {
            // Appy Sepia effect pixel-wise
            //as there's no amount(and as we classified Sepia Effect as a NoParameterEffect), we use the below algorithm to calculate the possible r,g,b values of the modifiedImage
            int r = static_cast<int>((pixel.r * sepiaMatrix[0][0]) + (pixel.g * sepiaMatrix[0][1]) + (pixel.b * sepiaMatrix[0][2]));//use static_cast for better accuracy and optimization
            int g = static_cast<int>((pixel.r * sepiaMatrix[1][0]) + (pixel.g * sepiaMatrix[1][1]) + (pixel.b * sepiaMatrix[1][2]));
            int b = static_cast<int>((pixel.r * sepiaMatrix[2][0]) + (pixel.g * sepiaMatrix[2][1]) + (pixel.b * sepiaMatrix[2][2]));
            //you can find more details of the algorithm used above here:
            //https://dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-sepia-image
            
            // Adjust values if they exceed 255(if the rgb value exceeds 255, set it to 255, as it's the maximum value possible)
            r = (r > 255) ? 255 : r;
            g = (g > 255) ? 255 : g;
            b = (b > 255) ? 255 : b;

            newRow.emplace_back(Pixel(r, g, b));//put the Sepia-applied Pixel in the rowVector
            //(emplace_back is slightly better optimized than the standard push_back: https://stackoverflow.com/questions/4303513/push-back-vs-emplace-back)
        }

        result.emplace_back(newRow);//put the row of Pixels(rowVector) into the modifiedImage
    }

    return result;
}
