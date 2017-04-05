package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

/**
 * Created by Isaac on 2/17/17.
 */
public class ExportResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String [] cmd, VFSDirectory Root, VFSDirectory CurrentDir, IOService ioService){
        ioService.printLine("This is the export handler");
        if(cmd.length != 2){
            ioService.printLine("export command expects at least/most one argument");
        }

        VFSunit tempFile = CurrentDir.getItem(cmd[1].split("/"), ioService);

        ioService.printLine(tempFile.getClass().toString());

        return CurrentDir;
    }

    public void createFile(VFSFile outFile){

    }

    public void createDirectory(VFSDirectory ourDir){

    }
}
