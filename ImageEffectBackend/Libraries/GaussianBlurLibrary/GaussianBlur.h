// GaussianBlur.h

#ifndef GAUSSIANBLUR_H
#define GAUSSIANBLUR_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class GaussianBlur {
public:
    static vector<vector<Pixel> > applyGaussianBlur(const vector<vector<Pixel> >& image, float radius);
};

#endif // GAUSSIANBLUR_H
