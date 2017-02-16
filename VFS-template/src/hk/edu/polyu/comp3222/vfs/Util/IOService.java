package hk.edu.polyu.comp3222.vfs.Util;

/**
 * Created by Isaac on 2/7/17.
 */
public interface IOService {
    /**
     *
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
     * @param player player;
     * @param msg The state of the game to be displayed
     */
    abstract void printConsole(String str, Boolean inline);

    abstract void printInstructions();
}
