package hk.edu.polyu.comp3222.vfs.core.handler;


import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

/**
 * Created by Isaac on 1/27/17.
 */
public class ListResponseHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk disk, VFSDirectory Root, VFSDirectory CurrentDir){
        CurrentDir.list(true);
        return this.saveState(cmd, disk, Root, CurrentDir);
    }
}
