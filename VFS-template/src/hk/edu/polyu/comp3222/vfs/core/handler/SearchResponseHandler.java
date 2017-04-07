package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

/**
 * Created by Isaac on 1/27/17.
 */
public class SearchResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory Root, VFSDirectory CurrentDir, IOService ioService){
        this.saveState(cmd, Root, CurrentDir, ioService);
        if(cmd.length == 1){
            ioService.printLine("search command needs at least one argument");
        }else{
            String[] seachPath = cmd[1].split("/");
            //ioService.printLine(seachPath[0]);
            //ioService.printLine(seachPath[1]);
            VFSunit fileSystemUnit = Root.getItem(cmd[1].split("/"), ioService);
            if(fileSystemUnit != null){
                ioService.printLine(fileSystemUnit.getPath());
            }else{
                ioService.printLine("no such file found in this VFS");
            }

        }
        return CurrentDir;
    }
}
