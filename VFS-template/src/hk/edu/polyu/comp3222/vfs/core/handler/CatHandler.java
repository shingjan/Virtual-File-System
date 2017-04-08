package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

/**
 * Created by Isaac on 1/27/17.
 */
public class CatHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService){
        //ioService.printLine(cmd[1]);
        VFSunit tempUnit;
        VFSFile tempFile;
        if(cmd.length < 2 ){
            ioService.printLine("cat command requires at least one argument");
        }else {
            String[] searchPath = cmd[1].split("/");
            tempUnit = CurrentDir.getItem(searchPath, ioService);
            if (tempUnit == null) {
                ioService.printLine("No such file exists in current working directory");
            } else {
                if (tempUnit.getClass() == VFSDirectory.class) {
                    ioService.printLine("Target file is a directory. cat command not applicable");
                }else {
                    tempFile = (VFSFile) tempUnit;
                    ioService.printLine(tempFile.getContent());
                }

            }
        }
        return this.saveState(cmd, root, CurrentDir, ioService);

    }
}
