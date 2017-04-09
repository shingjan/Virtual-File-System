package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;

import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

/**
 * Created by Isaac on 1/27/17.
 */
public class SearchResponseHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory Root, VFSDirectory CurrentDir){

        if(cmd.length != 2){
            ConsoleIO.printLine("search command needs at least one argument");
        }else{
            String[] seachPath = cmd[1].split("/");
            //ioService.printLine(seachPath[0]);
            //ioService.printLine(seachPath[1]);
            VFSunit fileSystemUnit = Root.getItem(cmd[1].split("/"));
            if(fileSystemUnit != null){
                ConsoleIO.printLine(fileSystemUnit.getPath());
            }else{
                ConsoleIO.printLine("no such file found in this VFS");
            }

        }
        return this.saveState(cmd, currentDisk, Root, CurrentDir);
    }
}
