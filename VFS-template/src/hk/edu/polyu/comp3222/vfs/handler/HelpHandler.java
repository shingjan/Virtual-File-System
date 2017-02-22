package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;

/**
 * Created by Isaac on 2/17/17.
 */
public class HelpHandler extends ResponseHandler{
    public void handlerResponse(String [] str, Directory CurrentDir, IOService ioService){
            ioService.printHelp();
    }
}
