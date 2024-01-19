// HueSaturation.h

#ifndef HUESATURATION_H
#define HUESATURATION_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class HueSaturation {
public:
    static vector<vector<Pixel> > adjustHueSaturation(const vector<vector<Pixel> >& image, float saturationValue, float hueValue);
};

#endif // HUESATURATION_H
