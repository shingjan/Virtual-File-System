package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

/**
 * Created by Isaac on 1/27/17.
 */
public class SearchResponseHandler extends ResponseHandler{
    public void handlerResponse(String[] cmd, Directory Root, Directory CurrentDir, IOService ioService){
        if(cmd.length == 1){
            ioService.printLine("search command needs at least one argument");
        }else{
            String[] seachPath = cmd[1].split("/");
            //ioService.printLine(seachPath[0]);
            //ioService.printLine(seachPath[1]);
            VFSunit fileSystemUnit = Root.getItem(seachPath, ioService);
            if(fileSystemUnit != null){
                fileSystemUnit.getPath();
            }else{
                ioService.printLine("no such file found in this VFS");
            }
        }
    }
}
