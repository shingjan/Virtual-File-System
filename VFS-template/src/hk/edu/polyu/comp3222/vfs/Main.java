package hk.edu.polyu.comp3222.vfs;

import hk.edu.polyu.comp3222.vfs.core.VisualDisk;
import hk.edu.polyu.comp3222.vfs.client.ClientController;

/**
 * Created by Isaac on 1/24/17.
 */
public class Main {
    /**
     * Default main class
     */

    public static void main(String[] args) {

        //VisualDisk testSystem = VisualDisk.loadFS("test","test",13356);
        //testSystem.boot();

        new ClientController();
        //new ServerController();

    }
}
