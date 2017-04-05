package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

/**
 * Created by Isaac on 1/27/17.
 */
public class ListResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VFSDirectory Root, VFSDirectory CurrentDir, IOService ioService){
            CurrentDir.list(true, true, ioService);
        return CurrentDir;
    }
}
