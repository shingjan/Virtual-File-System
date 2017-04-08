package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
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
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService){
        String fileName = null;
        this.saveState(cmd, currentDisk, root, CurrentDir, ioService);
        if (cmd.length != 1) {
            ioService.printLine("Query command requires no arguments since it only query the whole disk");
            return CurrentDir;
        }

        ioService.printLine(String.valueOf(root.getSize()) + "/" +String.valueOf(currentDisk.getSize()));
        return this.saveState(cmd, currentDisk, root, CurrentDir, ioService);
    }
}
