package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

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
