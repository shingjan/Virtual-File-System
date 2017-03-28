package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;

/**
 * Created by Isaac on 1/27/17.
 */
public class DirectResponseHandler extends ResponseHandler{
    public void handlerResponse(String[] cmd, Directory root, Directory CurrentDir, IOService ioService){
        if(cmd.length == 1){
            CurrentDir = root;
        }else{
            root.getDirContent();
        }

    }
}
