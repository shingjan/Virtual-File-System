package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;

import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

/**
 * Created by Isaac on 2/17/17.
 */
public class HelpHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String [] cmd, VisualDisk currentDisk, VFSDirectory Root, VFSDirectory CurrentDir){
        //this.saveState(cmd, currentDisk, Root, CurrentDir);
        ConsoleIO.printHelp();
        return this.saveState(cmd, currentDisk, Root, CurrentDir);
    }
}
