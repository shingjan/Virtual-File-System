package hk.edu.polyu.comp3222.vfs.Util;

import java.io.Serializable;

/**
 * Created by Isaac on 2/7/17.
 */
public interface IOService extends Serializable{
    /**
     * @param str string to be displayed
     * @return This is a description;
     */
    abstract String readLine(String str);

    /**
     *
     * @param str the str to be printed out
     */
    abstract void printLine(String str);

    /**
     *
     * @param str string message;
     * @param inline The state of the game to be isplayed
     */
    abstract void printConsole(String str, Boolean inline);

    /**
     * print instruction method
     */
    abstract void printInstructions();

    /**
     * print help method
     */
    abstract void printHelp();
}
