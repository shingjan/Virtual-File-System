package hk.edu.polyu.comp3222.vfs.Util;

/**
 * Created by Isaac on 1/27/17.
 */
public class UserIO {
    public static void printInstructions(){
        log("This is the instruction");
    }

    public static void log(String str) {
        System.out.printf("%s\n", str);
    }

    public static void log(String str, boolean inline) {
        if (inline) {
            System.out.printf("%s", str);
        }
    }

}
