package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;

import java.util.Date;

/**
 * Created by Isaac on 1/27/17.
 * touch cmd need to have at least two argument
 * "touch filename filecontent"
 */
public class QueryHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService){
        String fileName = null;
        if (cmd.length != 1) {
            ioService.printLine("Query command requires no arguments since it only query the whole disk");
            return CurrentDir;
        }

        ioService.printLine(String.valueOf(root.getSize()));
        return CurrentDir;
    }
}
