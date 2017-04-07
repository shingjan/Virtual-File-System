package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;

/**
 * Created by Isaac on 2/20/17.
 */
public class SaveHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VFSDirectory Root, VFSDirectory CurrentDir, IOService ioService){



        ioService.printLine("Current State Saved successfully!");
        return CurrentDir;
    }
}
