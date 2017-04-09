package hk.edu.polyu.comp3222.vfs.core.vfs;




import hk.edu.polyu.comp3222.vfs.core.handler.*;

import java.util.Date;

import java.io.Serializable;

/**
 * Created by Isaac on 2/15/17.
 */
public class VisualDisk implements Serializable{
    private final VFSDirectory ROOT_FS;
    private final String ROOT_PATH;
    private String username, password;
    private int diskSize;
    private ResponseHandler[] cmdArray;
    private VFSDirectory currentDir;

    /**
     * constructor of visual disk
     * @param username username of the user of this visual disk
     * @param password password of the user of this visual disk
     * @param diskSize disk size of this visual disk
     */
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

    /**
     * initialization of this Visual File System
     */
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

    /**
     * get name method
     * @return the name of this visual disk
     */
    public String getName(){
        return this.username;
    }

    /**
     * get size method
     * @return the size of this visual disk
     */
    public int getSize(){
        return this.diskSize;
    }

    /**
     * current directory of this visual disk
     * @return current directory
     */
    public VFSDirectory getCurrentDir(){
        return currentDir;
    }

    /**
     * get root method
     * @return root directory of this visual disk
     */
    public VFSDirectory getROOT_FS(){
        return ROOT_FS;
    }

    /**
     * set current directory method
     * @param currentDir VFS directory to be set as the current directory
     */
    public void setCurrentDir(VFSDirectory currentDir){
        this.currentDir = currentDir;
    }

    /**
     * returnt the password of this visual disk
     * @return password of this visual disk
     */
    public String getPassword(){
        return this.password;
    }

}
