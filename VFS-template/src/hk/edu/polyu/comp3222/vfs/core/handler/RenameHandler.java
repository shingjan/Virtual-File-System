package hk.edu.polyu.comp3222.vfs.core.handler;


import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;

import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

/**
 * Created by Isaac on 2/17/17.
 */
public class RenameHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir){
        ConsoleIO.printLine("This is the rename command");
        if(cmd.length == 3 ) {
            VFSunit tempFile = CurrentDir.getItem(cmd[1].split("/"));
            if (tempFile == null) {
                ConsoleIO.printLine("No such file exists");
                return this.saveState(cmd, currentDisk, root, CurrentDir);
            }else if(CurrentDir.getDirContent().containsValue(tempFile)) {
                tempFile.setName(cmd[2]);
            }
        } else {
            ConsoleIO.printLine("You need to input an argument");
        }

        return this.saveState(cmd, currentDisk, root, CurrentDir);

    }

}
