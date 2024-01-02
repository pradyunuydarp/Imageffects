
						👾**Imageffects**👾

Imageffects is a software that applies various image effects to an input image. It takes an image input of the format jpeg or png and returns the output processed image with the applied effect and the option to download the processed image. The effects that can be applied are:

	Brightness
	Contrast
	Dominant Colour
	Flip
	Blur
	Greyscale
	Hue Saturation
	Invert
	Rotation
	Sepia
	Sharpen

This software also has a logging service that can track all the effects applied and print them.

Photo Effect Service

	The image effects are written in cpp and have a Java wrapper using JNI. This is to allow Java to call these cpp functions. These functions are called in the PhotoEffectService.java file inside the src folder. The images are stored as a vector of vector of pixels and are then modified inside cpp functions according to the effect.

Logging Service

	Logging service is a thread that runs parallel with the image effect thread. This thread creates a log for each effect and stores it. This is done using the functions add logs, get all logs, get logs by effect, clear all logs, and get logs between timestamps.

Run-tutorial:

	First, we have to modify the makefile according to our OS. Then we have to run this makefile using the make clean command followed by the make command in the ImageEffectBackend/Libraries directory. This will create shared object (so) files. Next, we have to go to the project directory and run the "npm i" command, we do the same thing in the ImageEffectFrontend directory. Now we run the "npm start" command in the ImageEffectFrontend directory. This will create a link which can be opened. If you face "Server took too long to respond", try disabling your firewall or antivirus. Now we go to the ImageEffectBackend/src/main/java and run the ImageEffectApplication.java file after setting the Libraries directory as the 'sources' root. This will enable all the effects and the logging service. We can now use the link opened in the browser to use the application

	We've attached a few Test images in /TestImages which you can play around with


General Project Design:

	Effects in Java are divided into 3 broad categories(as of now):

				NoParameterEffects-
									Sepia
									Grayscale
									Invert
									DominantColour

				SingleParameterEffects-
									Brightness
									Contrast
									GaussianBlur
									Sharpen
									Rotation

				DoubleParameterEffects-
									Hue Saturation
									Flip

	We have made 3 abstract classes corresponding to each classification and 11 concrete classes, each inheriting their respective classification's abstract class

	Similarly to handle various Exceptions(some have been handled now, others might need handling later), we've made 3 broad classifications:

				NoParameterException
				SingleParameterException
				DoubleParameterException
	
	There are 11 concrete EffectExceptions which inherit their respective classification's class

	Other than these exceptions, there is the IllegalParameterException which handles unnecessary/junk parameter values.
