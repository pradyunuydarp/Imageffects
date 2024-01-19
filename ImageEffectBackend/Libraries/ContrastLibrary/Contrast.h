#ifndef CONTRAST_H
#define CONTRAST_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class Contrast {
public:
    static vector<vector<Pixel> > applyContrast(const vector<vector<Pixel> >& image, float amount);
};

#endif // CONTRAST_H
