package hk.edu.polyu.comp3222.vfs;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.client.ClientController;
import hk.edu.polyu.comp3222.vfs.client.fileSystem;
import hk.edu.polyu.comp3222.vfs.handler.*;
import hk.edu.polyu.comp3222.vfs.server.ServerController;
import org.omg.CORBA.portable.ResponseHandler;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Isaac on 1/24/17.
 */
public class Main {
    /**
     * Default main class
     */

    public static void main(String[] args) {

        fileSystem testSystem = fileSystem.loadFS();
        testSystem.boot();

        //new ClientController();
        //new ServerController();

    }
}
