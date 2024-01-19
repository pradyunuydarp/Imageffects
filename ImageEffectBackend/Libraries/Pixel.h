#ifndef PIXEL_H
#define PIXEL_H

struct Pixel {
    int r, g, b;
    Pixel(){}
    Pixel(int r, int g, int b){
        this->r = r;
        this->g = g;
        this->b = b;
    }
};

#endif