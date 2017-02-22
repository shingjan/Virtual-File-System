package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;

/**
 * Created by Isaac on 1/24/17.
 *
 */
public abstract class ResponseHandler {
    public abstract void handlerResponse(String[] cmd, Directory CurrentDir, IOService ioService);
}


