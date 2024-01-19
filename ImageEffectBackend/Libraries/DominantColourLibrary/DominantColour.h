// // DominantColor.h

// #ifndef DOMINANTCOLOR_H
// #define DOMINANTCOLOR_H

// #include <vector>
// #include "../Pixel.h"

// class DominantColor {
// public:
//     static vector<vector<Pixel> > createDominantImage(const vector<vector<Pixel> >& image);
// };

// #endif // DOMINANTCOLOR_H
// DominantColour.h

#ifndef DOMINANT_COLOUR_H
#define DOMINANT_COLOUR_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class DominantColor {
public:
    static vector<vector<Pixel> > createDominantImage(const vector<vector<Pixel> >& image);
};

#endif // DOMINANT_COLOUR_H
