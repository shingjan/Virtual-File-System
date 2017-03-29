package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

/**
 * Created by Isaac on 1/27/17.
 */
public class ListResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, Directory Root, Directory CurrentDir, IOService ioService){
            CurrentDir.list(true, true, ioService);
        return CurrentDir;
    }
}
