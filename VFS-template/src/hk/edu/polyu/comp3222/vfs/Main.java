package hk.edu.polyu.comp3222.vfs;

import hk.edu.polyu.comp3222.vfs.core.fileSystem;

/**
 * Created by Isaac on 1/24/17.
 */
public class Main {
    /**
     * Default main class
     */

    public static void main(String[] args) {

        fileSystem testSystem = fileSystem.loadFS("test","test",13356);
        testSystem.boot();

        //new ClientController();
        //new ServerController();

    }
}
