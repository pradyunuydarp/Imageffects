package libraryInterfaces;
public class ArithmeticInterface {
    static {
        String libraryPath = System.getProperty("user.dir") + "/Libraries/ArithmeticLibrary/ArithmeticLib.so";
        System.load(libraryPath);
    }

    public static native int add(int a, int b);
}