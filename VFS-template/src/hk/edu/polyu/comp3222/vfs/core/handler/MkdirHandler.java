package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Isaac on 1/27/17.
 */
public class MkdirHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir){
        ConsoleIO.printLine("This is the mkdir handler.");
        //this.saveState(cmd, currentDisk, root, CurrentDir);
        if(cmd.length != 2){
            ConsoleIO.printLine("mkdir command requires one argument");
        }else {
            String[] sourcePath = cmd[1].split("/");
            if(CurrentDir.getItem(sourcePath) != null){
                ConsoleIO.printLine("directory already exists!");
            }else {
                if(sourcePath.length > 1) {
                    String fileName = sourcePath[sourcePath.length - 1];
                    String[] parentPath = Arrays.copyOfRange(sourcePath, 0, sourcePath.length - 1);
                    VFSDirectory tempParentDir = (VFSDirectory) CurrentDir.getItem(parentPath);
                    VFSDirectory newDir = new VFSDirectory(tempParentDir.getPath(), fileName, new Date());
                    tempParentDir.getDirContent().put(newDir.getPath(), newDir);
                }else {
                    VFSDirectory newDir = new VFSDirectory(CurrentDir.getPath(), sourcePath[0], new Date());
                    CurrentDir.getDirContent().put(newDir.getPath(), newDir);
                }
            }
        }
        return this.saveState(cmd, currentDisk, root, CurrentDir);
    }
}
