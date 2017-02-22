package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;

/**
 * Created by Isaac on 2/17/17.
 */
public class CopyResponseHandler extends ResponseHandler{
    public void handlerResponse(String[] cmd, Directory CurrentDir, IOService ioService){
        ioService.printLine("This is the copy command");
    }
    public void handlerResponse(String[] cmd, Directory CurrentDir, String path,IOService ioService){

    }
}
