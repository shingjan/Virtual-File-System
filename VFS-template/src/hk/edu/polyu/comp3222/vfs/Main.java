package hk.edu.polyu.comp3222.vfs;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.client.ClientController;
import hk.edu.polyu.comp3222.vfs.server.ServerController;

import java.util.HashMap;

/**
 * Created by Isaac on 1/24/17.
 */
public class Main {
    /**
     * Default main class
     */

    public static void main(String[] args){
        ConsoleIO ConsoleIO = new ConsoleIO();
        ConsoleIO.printInstructions();
        new ClientController();
        new ServerController();

    }
}
