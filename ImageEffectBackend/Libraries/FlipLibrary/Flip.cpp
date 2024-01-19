#include "Flip.h"
#include <algorithm>

std::vector<std::vector<Pixel> > Flip::flip(const std::vector<std::vector<Pixel> >& image, int horizontalFlipValue, int verticalFlipValue) {
    std::vector<std::vector<Pixel> > flippedImage = image;

    // Horizontal flip
    if (horizontalFlipValue != 0) {
        for (size_t i = 0; i < image.size(); ++i) {
            if (horizontalFlipValue > 0) {
                std::reverse(flippedImage[i].begin(), flippedImage[i].end());
            }
            // else: Don't perform horizontal flip
        }
    }

    // Vertical flip
    if (verticalFlipValue != 0) {
        if (verticalFlipValue > 0) {
            std::reverse(flippedImage.begin(), flippedImage.end());
        }
        // else: Don't perform vertical flip
    }

    return flippedImage;
}
