package hk.edu.polyu.comp3222.vfs.client;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.VirtualDisk;
import hk.edu.polyu.comp3222.vfs.handler.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Isaac on 2/15/17.
 */
public class fileSystem {
    public final VirtualDisk ROOT_FS;
    public final String ROOT_PATH;
    private VirtualDisk currentDisk;
    public IOService ioService;
    public final Map<String, ResponseHandler> themap = new HashMap<>();

    public fileSystem() {
        ROOT_FS = new VirtualDisk("", "root.", new Date());
        ROOT_PATH = ROOT_FS.getPath();
        currentDisk = ROOT_FS;
        themap.put("cd", new DirectResponseHandler());
        themap.put("ls", new ListResponseHandler());
        themap.put("mv", new MoveResponseHandler());
        themap.put("rename", new RenameResponseHandler());
        themap.put("search", new SearchResponseHandler());
    }

    public void boot(){
        ioService = new ConsoleIO();
        while (true){
            ioService.printInstructions();
            ioService.printLine(currentDisk.getPath());
            ioService.readLine("-->");
        }
    }

    public void initializeFileSystem(){
        
    }

    public static fileSystem loadFS() {
        fileSystem fileSystem = SerializationController.getInstance().deserialize();
        if (fileSystem != null) {
            return fileSystem;
        } else {
            fileSystem = new fileSystem();
            fileSystem.initializeFileSystem();
        }
        return fileSystem;
    }
}
