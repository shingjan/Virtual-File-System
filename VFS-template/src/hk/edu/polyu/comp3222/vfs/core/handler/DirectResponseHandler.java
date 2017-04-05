package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.core.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;

/**
 * Created by Isaac on 1/27/17.
 */
public class DirectResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VFSDirectory Root, VFSDirectory CurrentDir, IOService ioService){
        //ioService.printLine(String.valueOf(cmd.length));
        if(cmd.length == 1){
            CurrentDir = Root;
        }else{
            String[] seachPath = cmd[1].split("/");
            //ioService.printLine(seachPath[0]);
            VFSunit fileSystemUnit = CurrentDir.getItem(seachPath, ioService);
            ioService.printLine(fileSystemUnit.getClass().toString());
            if(fileSystemUnit.getClass() == VFSDirectory.class){
                ioService.printLine(seachPath[0]);
                CurrentDir = (VFSDirectory) fileSystemUnit;
                //return CurrentDir;
            }else if(fileSystemUnit.getClass() == VFSFile.class){
                ioService.printLine("The target path is not a directory");
            }else{
                ioService.printLine("This directory is not found on this VFS");
            }
        }
        return CurrentDir;

    }
}
