package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.util.Date;

/**
 * Created by Isaac on 1/27/17.
 * touch cmd need to have at least two argument
 * "touch filename filecontent"
 */
public class CreateHandler extends ResponseHandler{
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir, IOService ioService){
        //ioService.printLine("This is the touch handler.");
        String fileName = null;
        if (cmd.length > 1 && !cmd[1].equals(null)) {
            fileName = cmd[1];
        } else {
            ioService.printLine("Wrong Argument for touch command");
        }
        VFSFile tempFile = new VFSFile(CurrentDir.getPath(), fileName, new Date(), cmd[2].getBytes());
        //VFSunit tempFileUnit = new File();
        CurrentDir.getDirContent().put(tempFile.getPath(),tempFile);


        this.saveState(cmd, root, CurrentDir, ioService);
        return CurrentDir;
    }
}
