package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.core.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;

/**
 * Created by Isaac on 2/17/17.
 */
public class HelpHandler extends ResponseHandler{
    public VFSunit handlerResponse(String [] cmd, VFSDirectory Root, VFSDirectory CurrentDir, IOService ioService){
            CurrentDir.getPath();
            ioService.printHelp();
            return CurrentDir;
    }
}
