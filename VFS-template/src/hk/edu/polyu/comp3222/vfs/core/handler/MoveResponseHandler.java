package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.io.Console;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Isaac on 1/27/17.
 */
public class MoveResponseHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory Root, VFSDirectory CurrentDir){
        ConsoleIO.printLine("This is the mv handler.");
        if (cmd.length != 3){
            ConsoleIO.printLine("Move command requires two arguments");
        } else if(cmd[1].equals(cmd[2])){
            ConsoleIO.printLine("two argument shouldn't be the same");
        } else{
            VFSunit tempUnit = CurrentDir.getItem(cmd[1].split("/"));
            if(tempUnit == null) {
                ConsoleIO.printLine("No such file found.");
                return this.saveState(cmd, currentDisk, Root, CurrentDir);
            }

            String filename;
            if(cmd[2].split("/").length == 1){
                filename = cmd[2];
                if(tempUnit.getClass() == VFSFile.class) {
                    VFSFile tempFile = (VFSFile) tempUnit;
                    VFSFile targetFile = new VFSFile(CurrentDir.getPath(), filename, new Date(), tempFile.getContent().getBytes());
                    CurrentDir.getDirContent().put(targetFile.getPath(),targetFile);
                }else{
                    VFSDirectory tempDir = (VFSDirectory) tempUnit;
                    ConsoleIO.printLine(tempDir.getPath());
                    tempDir.setName(filename);
                    ConsoleIO.printLine(tempDir.getPath());
                    CurrentDir.getDirContent().put(tempDir.getPath(),tempDir);
                    //CurrentDir.getDirContent().remove(tempUnit.getPath());
                }
                CurrentDir.getDirContent().remove(tempUnit.getPath());
            }else {
                String[] subPath = Arrays.copyOfRange(cmd[2].split("/"), 0, cmd[2].split("/").length - 1);
                filename = cmd[2].split("/")[cmd[2].split("/").length - 1];
                VFSDirectory targetDir = (VFSDirectory) CurrentDir.getItem(subPath);
                if(tempUnit.getClass() == VFSFile.class) {
                    VFSFile tempFile = (VFSFile) tempUnit;
                    VFSFile targetFile = new VFSFile(targetDir.getPath(), filename, new Date(), tempFile.getContent().getBytes());
                    targetDir.getDirContent().put(targetFile.getPath(),targetFile);
                    CurrentDir.getDirContent().remove(tempUnit.getPath());
                }else{
                    VFSDirectory tempDir = (VFSDirectory) tempUnit;
                    tempDir.setName(filename);
                    targetDir.getDirContent().put(tempDir.getPath(),tempDir);
                    CurrentDir.getDirContent().remove(tempUnit.getPath());
                }

            }
            //CurrentDir.getDirContent().remove(tempUnit.getPath(), tempUnit);
        }

        return this.saveState(cmd, currentDisk, Root, CurrentDir);
    }
}
