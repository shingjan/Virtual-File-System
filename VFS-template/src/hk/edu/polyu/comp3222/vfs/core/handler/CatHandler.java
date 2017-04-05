package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.core.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;

/**
 * Created by Isaac on 1/27/17.
 */
public class CatHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService){
        //ioService.printLine(cmd[1]);
        VFSFile tempFile;
        if(cmd.length < 1){
            ioService.printLine("cat command requires at least one argument");
        }else {
            String[] searchPath = cmd[1].split("/");
            //tempFile = CurrentDir.getItem(searchPath, ioService);
            if (CurrentDir.getItem(searchPath, ioService).getClass() == VFSFile.class) {
                tempFile = (VFSFile) CurrentDir.getItem(searchPath, ioService);
                ioService.printLine(tempFile.getContent());
            } else if (CurrentDir.getItem(searchPath, ioService).getClass() == VFSDirectory.class) {
                ioService.printLine("Target file is a directory. cat command not applicable");
            } else {
                ioService.printLine("No such file exists in current working directory");
            }
        }
        return CurrentDir;
    }
}
