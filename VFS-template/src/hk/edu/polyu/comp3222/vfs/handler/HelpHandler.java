package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

/**
 * Created by Isaac on 2/17/17.
 */
public class HelpHandler extends ResponseHandler{
    public VFSunit handlerResponse(String [] cmd, Directory Root, Directory CurrentDir, IOService ioService){
            CurrentDir.getPath();
            ioService.printHelp();
            return CurrentDir;
    }
}