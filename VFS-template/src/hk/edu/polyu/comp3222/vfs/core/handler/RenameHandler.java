package hk.edu.polyu.comp3222.vfs.core.handler;


import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

/**
 * Created by Isaac on 2/17/17.
 */
public class RenameHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService){
        ioService.printLine("This is the rename command");

        VFSunit tempFile = CurrentDir.getItem(cmd[1].split("/"), ioService);
        if(tempFile == null){
            ioService.printLine("No such file exists");
            return this.saveState(cmd, root, CurrentDir, ioService);
        }

        if(CurrentDir.getDirContent().containsValue(tempFile))
            tempFile.setName(cmd[2]);
        else
            ioService.printLine("unknown error, remove action abort");

        return this.saveState(cmd, root, CurrentDir, ioService);

    }

}
