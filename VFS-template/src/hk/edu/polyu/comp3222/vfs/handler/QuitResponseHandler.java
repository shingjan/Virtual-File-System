package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;

/**
 * Created by Isaac on 2/20/17.
 */
public class QuitResponseHandler extends ResponseHandler{
    public void handlerResponse(String[] cmd, Directory CurrentDir, IOService ioService){
        System.exit(0);
    }
}
