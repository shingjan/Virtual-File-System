package hk.edu.polyu.comp3222.vfs.Util;
import java.util.Scanner;
import java.io.PrintStream;

/**
 * Created by Isaac on 1/27/17.
 */
public class ConsoleIO {

    private static PrintStream output = new PrintStream(System.out);

    /**
     * print instruction method
     */
    public static void printInstructions(){
        output.println("This is the instruction!");
    }

    /**
     * print line method
     * @param str string to be printed
     */
    public static void printLine(String str) {
        output.println(str);
    }

    /**
     * read line method
     * @param str str to be displayed before read
     * @return line input from user
     */
    public static String readLine(String str){
        System.out.print(str);
        Scanner input = new Scanner(System.in);
        String nextLine = input.nextLine();
        return nextLine;
    }

    /**
     * print help method
     */
    public static void printHelp(){
        System.out.println("This is the help");
    }

}
