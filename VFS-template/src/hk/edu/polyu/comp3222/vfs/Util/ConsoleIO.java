package hk.edu.polyu.comp3222.vfs.Util;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.Serializable;
/**
 * Created by Isaac on 1/27/17.
 */
public class ConsoleIO {

    private static PrintStream output = new PrintStream(System.out);

    public static void printInstructions(){
        output.println("This is the instruction!");
    }

    public static void printLine(String str) {
        output.println(str);
    }

    public static String readLine(String str){
        System.out.print(str);
        Scanner input = new Scanner(System.in);
        String nextLine = input.nextLine();
        return nextLine;
    }

    public static void printConsole(String str, Boolean inline) {
        if (inline) {
            System.out.printf("%s", str);
        }
    }

    public static void printHelp(){
        System.out.println("This is the help");
    }

}
