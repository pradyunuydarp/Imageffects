// // Sharpen.h

// #ifndef SHARPEN_H
// #define SHARPEN_H

// #include <vector>
// #include "../Pixel.h"

// class Sharpen {
// public:
//     static vector<vector<Pixel> > applySharpen(const vector<vector<Pixel> >& image);
//     static Pixel calculateSharpenPixel(const vector<vector<Pixel> >& image, int x, int y);
// };

// #endif // SHARPEN_H
// Sharpen.h

#ifndef SHARPEN_H
#define SHARPEN_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class Sharpen {
public:
    static vector<vector<Pixel> > applySharpen(const vector<vector<Pixel> >& image, float amount);
    static Pixel calculateSharpenPixel(const vector<vector<Pixel> >& image, int x, int y, float amount);
};

#endif // SHARPEN_H
