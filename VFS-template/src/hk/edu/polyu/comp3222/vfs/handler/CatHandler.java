package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.File;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

import javax.xml.transform.dom.DOMResult;

/**
 * Created by Isaac on 1/27/17.
 */
public class CatHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, Directory root, Directory CurrentDir, IOService ioService){
        //ioService.printLine(cmd[1]);
        File tempFile;
        if(cmd.length < 1){
            ioService.printLine("cat command requires at least one argument");
        }else if(CurrentDir.getDirContent().get(cmd[1]) == null){
            ioService.printLine("No such file exists in current working directory");
        }else if(CurrentDir.getDirContent().get(cmd[1]).getClass() == Directory.class){
            ioService.printLine("Target file is a directory. cat command not applicable");
        }else{
            tempFile = (File) CurrentDir.getDirContent().get(cmd[1]);
            ioService.printLine(tempFile.getContent()) ;
        }
        return CurrentDir;
    }
}
