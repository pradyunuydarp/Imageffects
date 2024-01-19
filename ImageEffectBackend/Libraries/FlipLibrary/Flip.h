// Flip.h

#ifndef FLIP_H
#define FLIP_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class Flip {
public:
    static vector<vector<Pixel> > flip(const vector<vector<Pixel> >& image, int horizontalFlipValue, int verticalFlipValue);
};

#endif // FLIP_H
