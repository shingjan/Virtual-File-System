package hk.edu.polyu.comp3222.vfs.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.File;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

import javax.xml.transform.dom.DOMResult;
import java.util.Date;

/**
 * Created by Isaac on 1/27/17.
 * touch cmd need to have at least two argument
 * "touch filename filecontent"
 */
public class CreateHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, Directory root, Directory CurrentDir, IOService ioService){
        //ioService.printLine("This is the touch handler.");
        String fileName = null;
        if (cmd.length > 1 && !cmd[1].equals(null)) {
            fileName = cmd[1];
        } else {
            ioService.printLine("Wrong Argument for touch command");
        }
        File tempFile = new File(CurrentDir.getPath(), fileName, new Date(), cmd[2].getBytes());
        //VFSunit tempFileUnit = new File();
        CurrentDir.getDirContent().put(tempFile.getPath(),tempFile);
        return CurrentDir;
    }
}
