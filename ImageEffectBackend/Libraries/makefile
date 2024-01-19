CC = g++
JAVA_HOME = /Library/Java/JavaVirtualMachines/jdk-20.jdk/Contents/Home

HUE_SATURATION_LIBRARY_DESTINATION = ./HueSaturationLibrary
HUE_SATURATION_CPP_SRC = ./HueSaturationLibrary/HueSaturation.cpp ./HueSaturationLibrary/HueSaturationInterface.cpp
HUE_SATURATION_JAVA_SRC = ./libraryInterfaces/HueSaturationInterface.java
HUE_SATURATION_JNI_HEADER = ./HueSaturationLibrary/libraryInterfaces_HueSaturationInterface.h
HUE_SATURATION_LIB_NAME = ./HueSaturationLibrary/HueSaturationLib.so

DOMINANT_COLOUR_LIBRARY_DESTINATION = ./DominantColourLibrary
DOMINANT_COLOUR_CPP_SRC = ./DominantColourLibrary/DominantColour.cpp ./DominantColourLibrary/DominantColourInterface.cpp
DOMINANT_COLOUR_JAVA_SRC = ./libraryInterfaces/DominantColourInterface.java
DOMINANT_COLOUR_JNI_HEADER = ./DominantColourLibrary/libraryInterfaces_DominantColourInterface.h
DOMINANT_COLOUR_LIB_NAME = ./DominantColourLibrary/DominantColourLib.so

BRIGHTNESS_LIBRARY_DESTINATION = ./BrightnessLibrary
BRIGHTNESS_CPP_SRC = ./BrightnessLibrary/Brightness.cpp ./BrightnessLibrary/BrightnessInterface.cpp
BRIGHTNESS_JAVA_SRC = ./libraryInterfaces/BrightnessInterface.java
BRIGHTNESS_JNI_HEADER = ./BrightnessLibrary/libraryInterfaces_BrightnessInterface.h
BRIGHTNESS_LIB_NAME = ./BrightnessLibrary/BrightnessLib.so

CONTRAST_LIBRARY_DESTINATION = ./ContrastLibrary
CONTRAST_CPP_SRC = ./ContrastLibrary/Contrast.cpp ./ContrastLibrary/ContrastInterface.cpp
CONTRAST_JAVA_SRC = ./libraryInterfaces/ContrastInterface.java
CONTRAST_JNI_HEADER = ./ContrastLibrary/libraryInterfaces_ContrastInterface.h
CONTRAST_LIB_NAME = ./ContrastLibrary/ContrastLib.so

FLIP_LIBRARY_DESTINATION = ./FlipLibrary
FLIP_CPP_SRC = ./FlipLibrary/Flip.cpp ./FlipLibrary/FlipInterface.cpp
FLIP_JAVA_SRC = ./libraryInterfaces/FlipInterface.java
FLIP_JNI_HEADER = ./FlipLibrary/libraryInterfaces_FlipInterface.h
FLIP_LIB_NAME = ./FlipLibrary/FlipLib.so

GAUSSIAN_BLUR_LIBRARY_DESTINATION = ./GaussianBlurLibrary
GAUSSIAN_BLUR_CPP_SRC = ./GaussianBlurLibrary/GaussianBlur.cpp ./GaussianBlurLibrary/GaussianBlurInterface.cpp
GAUSSIAN_BLUR_JAVA_SRC = ./libraryInterfaces/GaussianBlurInterface.java
GAUSSIAN_BLUR_JNI_HEADER = ./GaussianBlurLibrary/libraryInterfaces_GaussianBlurInterface.h
GAUSSIAN_BLUR_LIB_NAME = ./GaussianBlurLibrary/GaussianBlurLib.so

GRAYSCALE_LIBRARY_DESTINATION = ./GrayscaleLibrary
GRAYSCALE_CPP_SRC = ./GrayscaleLibrary/Grayscale.cpp ./GrayscaleLibrary/GrayscaleInterface.cpp
GRAYSCALE_JAVA_SRC = ./libraryInterfaces/GrayscaleInterface.java
GRAYSCALE_JNI_HEADER = ./GrayscaleLibrary/libraryInterfaces_GrayscaleInterface.h
GRAYSCALE_LIB_NAME = ./GrayscaleLibrary/GrayscaleLib.so

INVERT_LIBRARY_DESTINATION = ./InvertLibrary
INVERT_CPP_SRC = ./InvertLibrary/Invert.cpp ./InvertLibrary/InvertInterface.cpp
INVERT_JAVA_SRC = ./libraryInterfaces/InvertInterface.java
INVERT_JNI_HEADER = ./InvertLibrary/libraryInterfaces_InvertInterface.h
INVERT_LIB_NAME = ./InvertLibrary/InvertLib.so

ROTATION_LIBRARY_DESTINATION = ./RotationLibrary
ROTATION_CPP_SRC = ./RotationLibrary/Rotation.cpp ./RotationLibrary/RotationInterface.cpp
ROTATION_JAVA_SRC = ./libraryInterfaces/RotationInterface.java
ROTATION_JNI_HEADER = ./RotationLibrary/libraryInterfaces_RotationInterface.h
ROTATION_LIB_NAME = ./RotationLibrary/RotationLib.so

SEPIA_LIBRARY_DESTINATION = ./SepiaLibrary
SEPIA_CPP_SRC = ./SepiaLibrary/Sepia.cpp ./SepiaLibrary/SepiaInterface.cpp
SEPIA_JAVA_SRC = ./libraryInterfaces/SepiaInterface.java
SEPIA_JNI_HEADER = ./SepiaLibrary/libraryInterfaces_SepiaInterface.h
SEPIA_LIB_NAME = ./SepiaLibrary/SepiaLib.so

SHARPEN_LIBRARY_DESTINATION = ./SharpenLibrary
SHARPEN_CPP_SRC = ./SharpenLibrary/Sharpen.cpp ./SharpenLibrary/SharpenInterface.cpp
SHARPEN_JAVA_SRC = ./libraryInterfaces/SharpenInterface.java
SHARPEN_JNI_HEADER = ./SharpenLibrary/libraryInterfaces_SharpenInterface.h
SHARPEN_LIB_NAME = ./SharpenLibrary/SharpenLib.so


all: $(HUE_SATURATION_LIB_NAME) $(DOMINANT_COLOUR_LIB_NAME) $(BRIGHTNESS_LIB_NAME) $(CONTRAST_LIB_NAME) $(FLIP_LIB_NAME) $(GAUSSIAN_BLUR_LIB_NAME) $(GRAYSCALE_LIB_NAME) $(INVERT_LIB_NAME) $(ROTATION_LIB_NAME) $(SEPIA_LIB_NAME) $(SHARPEN_LIB_NAME)



$(HUE_SATURATION_LIB_NAME): $(HUE_SATURATION_CPP_SRC) $(HUE_SATURATION_JNI_HEADER)
	$(CC) -shared -o $@ $(HUE_SATURATION_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(HUE_SATURATION_JNI_HEADER): $(HUE_SATURATION_JAVA_SRC)
	javac -h $(HUE_SATURATION_LIBRARY_DESTINATION) $(HUE_SATURATION_JAVA_SRC)






$(DOMINANT_COLOUR_LIB_NAME): $(DOMINANT_COLOUR_CPP_SRC) $(DOMINANT_COLOUR_JNI_HEADER)
	$(CC) -shared -o $@ $(DOMINANT_COLOUR_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(DOMINANT_COLOUR_JNI_HEADER): $(DOMINANT_COLOUR_JAVA_SRC)
	javac -h $(DOMINANT_COLOUR_LIBRARY_DESTINATION) $(DOMINANT_COLOUR_JAVA_SRC)





$(BRIGHTNESS_LIB_NAME): $(BRIGHTNESS_CPP_SRC) $(BRIGHTNESS_JNI_HEADER)
	$(CC) -shared -o $@ $(BRIGHTNESS_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(BRIGHTNESS_JNI_HEADER): $(BRIGHTNESS_JAVA_SRC)
	javac -h $(BRIGHTNESS_LIBRARY_DESTINATION) $(BRIGHTNESS_JAVA_SRC)





$(CONTRAST_LIB_NAME): $(CONTRAST_CPP_SRC) $(CONTRAST_JNI_HEADER)
	$(CC) -shared -o $@ $(CONTRAST_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(CONTRAST_JNI_HEADER): $(CONTRAST_JAVA_SRC)
	javac -h $(CONTRAST_LIBRARY_DESTINATION) $(CONTRAST_JAVA_SRC)






$(FLIP_LIB_NAME): $(FLIP_CPP_SRC) $(FLIP_JNI_HEADER)
	$(CC) -shared -o $@ $(FLIP_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(FLIP_JNI_HEADER): $(FLIP_JAVA_SRC)
	javac -h $(FLIP_LIBRARY_DESTINATION) $(FLIP_JAVA_SRC)







$(GAUSSIAN_BLUR_LIB_NAME): $(GAUSSIAN_BLUR_CPP_SRC) $(GAUSSIAN_BLUR_JNI_HEADER)
	$(CC) -shared -o $@ $(GAUSSIAN_BLUR_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(GAUSSIAN_BLUR_JNI_HEADER): $(GAUSSIAN_BLUR_JAVA_SRC)
	javac -h $(GAUSSIAN_BLUR_LIBRARY_DESTINATION) $(GAUSSIAN_BLUR_JAVA_SRC)






$(GRAYSCALE_LIB_NAME): $(GRAYSCALE_CPP_SRC) $(GRAYSCALE_JNI_HEADER)
	$(CC) -shared -o $@ $(GRAYSCALE_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(GRAYSCALE_JNI_HEADER): $(GRAYSCALE_JAVA_SRC)
	javac -h $(GRAYSCALE_LIBRARY_DESTINATION) $(GRAYSCALE_JAVA_SRC)






$(INVERT_LIB_NAME): $(INVERT_CPP_SRC) $(INVERT_JNI_HEADER)
	$(CC) -shared -o $@ $(INVERT_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(INVERT_JNI_HEADER): $(INVERT_JAVA_SRC)
	javac -h $(INVERT_LIBRARY_DESTINATION) $(INVERT_JAVA_SRC)




$(ROTATION_LIB_NAME): $(ROTATION_CPP_SRC) $(ROTATION_JNI_HEADER)
	$(CC) -shared -o $@ $(ROTATION_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(ROTATION_JNI_HEADER): $(ROTATION_JAVA_SRC)
	javac -h $(ROTATION_LIBRARY_DESTINATION) $(ROTATION_JAVA_SRC)




$(SEPIA_LIB_NAME): $(SEPIA_CPP_SRC) $(SEPIA_JNI_HEADER)
	$(CC) -shared -o $@ $(SEPIA_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(SEPIA_JNI_HEADER): $(SEPIA_JAVA_SRC)
	javac -h $(SEPIA_LIBRARY_DESTINATION) $(SEPIA_JAVA_SRC)




$(SHARPEN_LIB_NAME): $(SHARPEN_CPP_SRC) $(SHARPEN_JNI_HEADER)
	$(CC) -shared -o $@ $(SHARPEN_CPP_SRC) -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin

$(SHARPEN_JNI_HEADER): $(SHARPEN_JAVA_SRC)
	javac -h $(SHARPEN_LIBRARY_DESTINATION) $(SHARPEN_JAVA_SRC)



clean:
	rm -f $(HUE_SATURATION_LIB_NAME) $(HUE_SATURATION_JNI_HEADER) \
	$(DOMINANT_COLOUR_LIB_NAME) $(DOMINANT_COLOUR_JNI_HEADER) \
	$(BRIGHTNESS_LIB_NAME) $(BRIGHTNESS_JNI_HEADER) \
	$(CONTRAST_LIB_NAME) $(CONTRAST_JNI_HEADER) \
	$(FLIP_LIB_NAME) $(FLIP_JNI_HEADER) \
	$(GAUSSIAN_BLUR_LIB_NAME) $(GAUSSIAN_BLUR_JNI_HEADER) \
	$(GRAYSCALE_LIB_NAME) $(GRAYSCALE_JNI_HEADER) \
	$(INVERT_LIB_NAME) $(INVERT_JNI_HEADER) \
	$(ROTATION_LIB_NAME) $(ROTATION_JNI_HEADER) \
	$(SEPIA_LIB_NAME) $(SEPIA_JNI_HEADER) \
	$(SHARPEN_LIB_NAME) $(SHARPEN_JNI_HEADER)