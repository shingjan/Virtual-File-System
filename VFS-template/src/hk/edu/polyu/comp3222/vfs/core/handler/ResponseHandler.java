package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
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
    private IOService ioService;

    public abstract VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService);

    public VFSDirectory saveState(String[] cmd, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService){
        this.cmd = cmd;
        this.root = root;
        this.CurrentDir = root;
        this.ioService = ioService;

        return CurrentDir;
    }
}


