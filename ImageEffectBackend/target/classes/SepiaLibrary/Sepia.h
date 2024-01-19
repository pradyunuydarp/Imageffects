#ifndef SEPIA_H
#define SEPIA_H

#include <vector>
#include "../Pixel.h"
using namespace std;
class Sepia {
public:
    static vector<vector<Pixel> > applySepia(const vector<vector<Pixel> >& image);
};

#endif // SEPIA_H
