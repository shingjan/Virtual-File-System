package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

/**
 * Created by Isaac on 1/27/17.
 */
public class DirectResponseHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory Root, VFSDirectory CurrentDir){
        //ioService.printLine(String.valueOf(cmd.length));
        this.saveState(cmd, currentDisk, Root, CurrentDir);
        if(cmd.length == 1){
            CurrentDir = Root;
        }else {
            String[] seachPath = cmd[1].split("/");
            VFSunit fileSystemUnit = CurrentDir.getItem(seachPath);

            if (fileSystemUnit == null) {
                ConsoleIO.printLine("This directory is not found on this VFS");

            } else {
                if (fileSystemUnit.getClass() == VFSFile.class) {
                    ConsoleIO.printLine("The target path is not a directory");
                }else {
                    CurrentDir = (VFSDirectory) fileSystemUnit;
                }

            }
        }
        return this.saveState(cmd, currentDisk, Root, CurrentDir);

    }
}
