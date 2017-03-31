package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

import javax.xml.transform.dom.DOMResult;

/**
 * Created by Isaac on 1/27/17.
 */
public class MkdirHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, Directory root, Directory CurrentDir, IOService ioService){
        ioService.printLine("This is the mkdir handler.");
        return CurrentDir;
    }
}
