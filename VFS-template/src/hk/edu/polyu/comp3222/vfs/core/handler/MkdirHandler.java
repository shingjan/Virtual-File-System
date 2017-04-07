package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;

import java.util.Date;

/**
 * Created by Isaac on 1/27/17.
 */
public class MkdirHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService){
        ioService.printLine("This is the mkdir handler.");
        if(cmd.length != 2){
            ioService.printLine("mkdir command requires at least/most one argument");
        }

        VFSDirectory newDir = new VFSDirectory(CurrentDir.getPath(), cmd[1], new Date());
        CurrentDir.getDirContent().put(newDir.getPath(), newDir);
        return CurrentDir;
    }
}
