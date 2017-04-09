package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;

import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;



/**
 * Created by Isaac on 1/27/17.
 * query cmd dont need any command
 *
 */
public class QueryHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir){
        String fileName = null;
        this.saveState(cmd, currentDisk, root, CurrentDir);
        if (cmd.length != 1) {
            ConsoleIO.printLine("Query command requires no arguments since it only query the whole disk");
            return CurrentDir;
        }

        ConsoleIO.printLine(String.valueOf(root.getSize()) + "/" +String.valueOf(currentDisk.getSize()));
        return this.saveState(cmd, currentDisk, root, CurrentDir);
    }
}
