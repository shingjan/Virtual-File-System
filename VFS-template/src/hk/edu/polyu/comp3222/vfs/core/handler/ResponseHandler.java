package hk.edu.polyu.comp3222.vfs.core.handler;


import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.io.Serializable;

/**
 * Created by Isaac on 1/24/17.
 *
 */
public abstract class ResponseHandler implements Serializable{

    private String[] cmd;
    private VFSDirectory root;
    private VFSDirectory CurrentDir;
    private VisualDisk currentDisk;

    /**
     * method to handler specific command
     * @param cmd cmd array from user input
     * @param currentDisk current visual disk in use
     * @param root root directory in current visual disk
     * @param CurrentDir current working directory
     * @return current directory after command is handled
     */
    public abstract VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir);

    /**
     * save the handler's state for serialization
     * @param cmd cmd array from user input
     * @param root root directory in current visual disk
     * @param CurrentDir current working directory
     * @return current directory after command is handled
     */
    public VFSDirectory saveState(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir){
        this.cmd = cmd;
        this.currentDisk = currentDisk;
        this.root = root;
        this.CurrentDir = CurrentDir;

        return CurrentDir;
    }


    public VFSunit handlerOnServer(){
        return handlerResponse(this.cmd,this.currentDisk, this.root, this.CurrentDir);
    }

}


