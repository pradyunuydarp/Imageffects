#include "libraryInterfaces_RotationInterface.h"
#include "Rotation.h"
#include "../Pixel.h"
#include <vector>
using namespace std;

// JNI function to apply rotation on a 2D array of Pixel objects
JNIEXPORT jobjectArray JNICALL Java_libraryInterfaces_RotationInterface_applyRotation
  (JNIEnv * env, jclass jobj, jobjectArray image, jint value) {

    // Vector to hold the input image
    vector< vector<Pixel> > imageVector;
    jsize rows = env->GetArrayLength(image);
    jclass pixelArrayClass, pixelClass;

    // Loop through rows of the input image
    for (jsize i = 0; i < rows; ++i) {
        // Get the i-th row array from the 2D array
        jobjectArray rowArray = (jobjectArray)env->GetObjectArrayElement(image, i);
        jsize cols = env->GetArrayLength(rowArray);
        pixelArrayClass = env->GetObjectClass(rowArray);

        // Vector to hold the current row of Pixel objects
        vector<Pixel> rowVector;
        // Loop through columns of the current row
        for (jsize j = 0; j < cols; ++j) {
            // Get the j-th Pixel object from the row array
            jobject pixelObj = env->GetObjectArrayElement(rowArray, j);

            // Extract r, g, b values from Pixel object
            pixelClass = env->GetObjectClass(pixelObj);
            jfieldID rField = env->GetFieldID(pixelClass, "r", "I");
            jfieldID gField = env->GetFieldID(pixelClass, "g", "I");
            jfieldID bField = env->GetFieldID(pixelClass, "b", "I");

            jint rValue = env->GetIntField(pixelObj, rField);
            jint gValue = env->GetIntField(pixelObj, gField);
            jint bValue = env->GetIntField(pixelObj, bField);

            // Create a Pixel object and add it to the row vector
            Pixel pixel;
            pixel.r = static_cast<int>(rValue);
            pixel.g = static_cast<int>(gValue);
            pixel.b = static_cast<int>(bValue);

            rowVector.push_back(pixel);

            // Release local reference to the current Pixel object
            env->DeleteLocalRef(pixelObj);
        }

        // Add the current row vector to the image vector
        imageVector.push_back(rowVector);
        // Release local reference to the current row array
        env->DeleteLocalRef(rowArray);
    }
    // Perform image rotation using the Rotation::rotateImage function
    vector< vector<Pixel> >resultVector = Rotation::rotateImage(imageVector,value);

    // Create a new 2D array to hold the rotated image
    jobjectArray resultArray = env->NewObjectArray(rows, pixelArrayClass, nullptr);

     // Loop through rows of the result image
    for (jsize i = 0; i < rows; ++i) {
        jsize cols = resultVector[i].size();
        // Create a new row array for the result image
        jobjectArray rowArray = env->NewObjectArray(cols, pixelClass, nullptr);

        // Loop through columns of the current row
        for (jsize j = 0; j < cols; ++j) {
            const Pixel &pixel = resultVector[i][j];
             // Create a new Pixel object for the result image
            jobject pixelObj = env->AllocObject(pixelClass);

            // Set r, g, b values for the Pixel object    
            env->SetIntField(pixelObj, env->GetFieldID(pixelClass, "r", "I"), pixel.r);
            env->SetIntField(pixelObj, env->GetFieldID(pixelClass, "g", "I"), pixel.g);
            env->SetIntField(pixelObj, env->GetFieldID(pixelClass, "b", "I"), pixel.b);

            // Set the Pixel object in the current row array
            env->SetObjectArrayElement(rowArray, j, pixelObj);

            // Release local reference to the current Pixel object
            env->DeleteLocalRef(pixelObj);
        }

        // Set the row array in the result array
        env->SetObjectArrayElement(resultArray, i, rowArray);
         // Release local reference to the current row array
        env->DeleteLocalRef(rowArray);
    }

    return resultArray;
}