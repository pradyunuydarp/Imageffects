#pragma once
#include "../Pixel.h"
#include <vector>
using namespace std;
class Brightness {
public:
   static vector<vector<Pixel> > applyBrightness(vector<vector<Pixel> >& image, float amount);
};

