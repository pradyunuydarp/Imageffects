#include "DominantColour.h"
#include <unordered_map>
#include <algorithm>
using namespace std;

bool compareColours(const pair<int, int>& a, const pair<int, int>& b) {
    return a.second < b.second;//
}

vector<vector<Pixel> > DominantColor::createDominantImage(const vector<vector<Pixel> >& image) {
    
    // Create a frequency map to count occurrences of each color
    unordered_map<int, int> colorfreq;//each coloe has a corresponding frequency
    // Iterate pixel-wise in the original image and fill the frequency map
    for (const auto& row : image) {//for each row in the image
        for (const auto& pixel : row) {//for each pixel in the row
            int colour = (pixel.r << 16) | (pixel.g << 8) | pixel.b;//create a unique key(identifier to each color)
            //we could've also used a pair<int,<pair<int>> to store r,g,b values which'll have no collisions whatsoever,
            //but it'll take up a lot of space
            colorfreq[colour]++;//increment the color's corresponding frequency 
        }
    }

    // Find the color with the highest frequency (dominant colour)
    auto maxfreqColor = max_element(colorfreq.begin(), colorfreq.end(), compareColours);
    //find the color with maximum frequency, using the comparator 'compareColours'
    // Extract rgb values from the dominant colour's key
    int dominantColourValue = maxfreqColor->first;
    int r = (dominantColourValue >> 16) & 255;
    int g = (dominantColourValue >> 8) & 255;
    int b = dominantColourValue & 255;
    // Create and return an image filled with the dominant colour
    vector<vector<Pixel> > dominantcolourImage(image.size(), vector<Pixel>(image[0].size(), Pixel(r, g, b)));
    return dominantcolourImage;
}
