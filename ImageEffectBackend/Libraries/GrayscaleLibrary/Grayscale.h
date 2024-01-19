// Grayscale.h

#ifndef GRAYSCALE_H
#define GRAYSCALE_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class Grayscale {
public:
    static vector<vector<Pixel> > applyGrayscaleFilter(const vector<vector<Pixel> >& image);
};

#endif // GRAYSCALE_H
