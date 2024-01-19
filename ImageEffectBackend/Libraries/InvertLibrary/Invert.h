// Invert.h

#ifndef INVERT_H
#define INVERT_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class Invert {
public:
    static vector<vector<Pixel> > invertImage(const vector<vector<Pixel> >& image);
};

#endif // INVERT_H
