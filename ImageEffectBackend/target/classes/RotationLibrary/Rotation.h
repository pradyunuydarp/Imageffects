// Rotation.h

#ifndef ROTATION_H
#define ROTATION_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class Rotation {
public:
    static vector<vector<Pixel> > rotateImage(const vector<vector<Pixel> >& image, int angle);
};

#endif // ROTATION_H
