package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;

/**
 * Created by Isaac on 1/24/17.
 *
 */
public abstract class ResponseHandler {
    abstract void handlerResponse(String xxp, IOService ioService);
}


