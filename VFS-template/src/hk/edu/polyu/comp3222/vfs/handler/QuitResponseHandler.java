package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

/**
 * Created by Isaac on 2/20/17.
 */
public class QuitResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, Directory Root, Directory CurrentDir, IOService ioService){
        ioService.printLine("quitting the VFS system");
        return null;
    }
}
