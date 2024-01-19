#include "libraryInterfaces_SharpenInterface.h"
#include "Sharpen.h"
#include "../Pixel.h"
#include <vector>
using namespace std;

JNIEXPORT jobjectArray JNICALL Java_libraryInterfaces_SharpenInterface_applySharpen
  (JNIEnv * env, jclass jobj, jobjectArray image, jfloat amount) {

    vector< vector<Pixel> > imageVector;             // Convert Java 2D array (image) to C++ vector of vectors
    jsize rows = env->GetArrayLength(image);
    jclass pixelArrayClass, pixelClass;

    for (jsize i = 0; i < rows; ++i) {                  // Iterate through each row of the Java 2D array
        jobjectArray rowArray = (jobjectArray)env->GetObjectArrayElement(image, i);         //i-th row as a Java array
        jsize cols = env->GetArrayLength(rowArray);
        pixelArrayClass = env->GetObjectClass(rowArray);

        vector<Pixel> rowVector;               // Vector to store Pixels for the current row
        for (jsize j = 0; j < cols; ++j) {           // Iterate through each element (Pixel) of the row
            jobject pixelObj = env->GetObjectArrayElement(rowArray, j);         //j-th element (Pixel) from the Java array

            pixelClass = env->GetObjectClass(pixelObj);           // Extract r, g, b values from Pixel object
            jfieldID rField = env->GetFieldID(pixelClass, "r", "I");
            jfieldID gField = env->GetFieldID(pixelClass, "g", "I");
            jfieldID bField = env->GetFieldID(pixelClass, "b", "I");

            jint rValue = env->GetIntField(pixelObj, rField);
            jint gValue = env->GetIntField(pixelObj, gField);
            jint bValue = env->GetIntField(pixelObj, bField);

            Pixel pixel;              // Creating a C++ Pixel object and adding it to the rowVector.
            pixel.r = static_cast<int>(rValue);
            pixel.g = static_cast<int>(gValue);
            pixel.b = static_cast<int>(bValue);

            rowVector.push_back(pixel);

            env->DeleteLocalRef(pixelObj);           // Releasing the reference to the Java Pixel object
        }

        imageVector.push_back(rowVector);             //Add the rowVector to the imageVector
        env->DeleteLocalRef(rowArray);
    }
    // Call the function here(To sharpen)
    vector< vector<Pixel> >resultVector = Sharpen::applySharpen(imageVector,amount);             // Applying sharpen and getting the modifiedImage
    jobjectArray resultArray = env->NewObjectArray(rows, pixelArrayClass, nullptr);             // Creating a new Java 2D array for the result
    for (jsize i = 0; i < rows; ++i) {
        jsize cols = resultVector[i].size();
        jobjectArray rowArray = env->NewObjectArray(cols, pixelClass, nullptr);

        for (jsize j = 0; j < cols; ++j) {
            const Pixel &pixel = resultVector[i][j];
            jobject pixelObj = env->AllocObject(pixelClass);

            env->SetIntField(pixelObj, env->GetFieldID(pixelClass, "r", "I"), pixel.r);                // Setting r, g, b values for each Pixel object in the row
            env->SetIntField(pixelObj, env->GetFieldID(pixelClass, "g", "I"), pixel.g);
            env->SetIntField(pixelObj, env->GetFieldID(pixelClass, "b", "I"), pixel.b);

            env->SetObjectArrayElement(rowArray, j, pixelObj);        // Setting the Pixel object in the row array
            env->DeleteLocalRef(pixelObj);
        }

        env->SetObjectArrayElement(resultArray, i, rowArray);       // Setting the row array in the result array
        env->DeleteLocalRef(rowArray);
    }

    return resultArray;
}