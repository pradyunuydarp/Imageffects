package libraryInterfaces;

public class FlipInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "/Libraries/FlipLibrary/FlipLib.so";
        System.load(libraryPath);
    }

    public static native Pixel[][] applyFlip(Pixel[][] image, int horizontalFlipValue, int verticalFlipValue);
}
