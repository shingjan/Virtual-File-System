package hk.edu.polyu.comp3222.vfs.core.vfs;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.controller.SerializationController;
import hk.edu.polyu.comp3222.vfs.core.handler.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

/**
 * Created by Isaac on 2/15/17.
 */
public class VisualDisk implements Serializable{
    public final VFSDirectory ROOT_FS;
    public final String ROOT_PATH;
    private String username, password;
    private int diskSize;
    private ResponseHandler[] cmdArray;
    public VFSDirectory currentDir;
    public IOService ioService;


    public VisualDisk(String username, String password, int diskSize) {
        //global variable
        this.username = username;
        this.password = password;
        this.diskSize = diskSize;


        //root directory
        ROOT_FS = new VFSDirectory("", "root", new Date());
        ROOT_PATH = ROOT_FS.getPath();
        currentDir = ROOT_FS;

        //initialization
        this.initializeFileSystem();
    }

    public void initializeFileSystem(){
        VFSDirectory firstFolder = new VFSDirectory(ROOT_PATH, "1st", new Date());
        VFSFile file1 = new VFSFile(firstFolder.getPath(), "foo", new Date(), "This is the content of foo".getBytes());
        VFSDirectory secondFolder = new VFSDirectory(ROOT_PATH, "2nd", new Date());
        VFSFile file2 = new VFSFile(secondFolder.getPath(), "bar", new Date(), "This is the content of bar".getBytes());
        VFSFile file3 = new VFSFile(ROOT_PATH, "file3", new Date(), "This is the content of file3".getBytes());
        currentDir.getDirContent().put(firstFolder.getPath(), firstFolder);
        currentDir.getDirContent().put(secondFolder.getPath(), secondFolder);
        currentDir.getDirContent().put(file3.getPath(), file3);
        firstFolder.getDirContent().put(file1.getPath(),file1);
        secondFolder.getDirContent().put(file2.getPath(), file2);
    }

    public String getName(){
        return username;
    }

    public VFSunit getItemByPath(String path, VFSDirectory root) {
        if (path.equals(root.getPath()))
            return root;

        VFSunit fileSystemUnit;

        // check first whether the object with the specified path exists in source folder
        if ((fileSystemUnit = root.getDirContent().get(path)) != null) {
            return fileSystemUnit;
        }

        // if not, deep check every single entry in the current directory
        for (VFSunit value : root.getDirContent().values()) {
            if (value.getClass() == VFSDirectory.class) {
                fileSystemUnit = getItemByPath(path, (VFSDirectory) value);
            } else {
                fileSystemUnit = value;
            }

            if (fileSystemUnit != null && path.equals(fileSystemUnit.getPath()))
                return fileSystemUnit;
        }
        return null;
    }


}
