package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

/**
 * Created by Isaac on 2/17/17.
 */
public class CopyResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, Directory root, Directory CurrentDir, IOService ioService){
        ioService.printLine("This is the copy command");
        return CurrentDir;
    }
    public void handlerResponse(String[] cmd, Directory CurrentDir, String path,IOService ioService){

    }
}
