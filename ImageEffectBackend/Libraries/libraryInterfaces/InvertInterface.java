package libraryInterfaces;

public class InvertInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "/Libraries/InvertLibrary/InvertLib.so";
        System.load(libraryPath);
    }

    public static native Pixel[][] applyInvert(Pixel[][] image);
}
