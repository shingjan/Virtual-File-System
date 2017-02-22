package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;

/**
 * Created by Isaac on 1/27/17.
 */
public class RenameResponseHandler extends ResponseHandler{
    public void handlerResponse(String[] cmd, Directory CurrentDir, IOService ioService){
        ioService.printLine("This is the rename command");
    }
}
