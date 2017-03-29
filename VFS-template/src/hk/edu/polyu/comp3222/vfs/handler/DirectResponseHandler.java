package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

/**
 * Created by Isaac on 1/27/17.
 */
public class DirectResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, Directory Root, Directory CurrentDir, IOService ioService){
        ioService.printLine(String.valueOf(cmd.length));
        if(cmd.length == 1){
            CurrentDir = Root;
        }else{
            String[] seachPath = cmd[1].split("/");
            //ioService.printLine(seachPath[0]);
            VFSunit fileSystemUnit = Root.getItem(seachPath, ioService);
            if(fileSystemUnit.getClass() == Directory.class){
                ioService.printLine(seachPath[0]);
                CurrentDir = (Directory) fileSystemUnit;
                //return CurrentDir;
            }else if(fileSystemUnit.getClass() != Directory.class){
                ioService.printLine("The target path is not a directory");
            }else{
                ioService.printLine("This directory is not found on this VFS");
            }
        }
        return CurrentDir;

    }
}
