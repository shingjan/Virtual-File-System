package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;

/**
 * Created by Isaac on 2/17/17.
 */
public class CopyResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService){
        ioService.printLine("This is the copy command");
        return CurrentDir;
    }
    public void handlerResponse(String[] cmd, VFSDirectory CurrentDir, String path,IOService ioService){

    }
}
