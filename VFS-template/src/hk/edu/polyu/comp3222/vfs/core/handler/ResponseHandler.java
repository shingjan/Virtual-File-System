package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;

/**
 * Created by Isaac on 1/24/17.
 *
 */
public abstract class ResponseHandler {
    public abstract VFSunit handlerResponse(String[] cmd, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService);
}


