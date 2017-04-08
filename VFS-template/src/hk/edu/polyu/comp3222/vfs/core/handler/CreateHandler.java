package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
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
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory root, VFSDirectory CurrentDir){
        //ioService.printLine("This is the touch handler.");
        String fileName = null;
        if (cmd.length ==3 ) {

            fileName = cmd[1];
            VFSFile tempFile = new VFSFile(CurrentDir.getPath(), fileName, new Date(), cmd[2].getBytes());
            //VFSunit tempFileUnit = new File();
            CurrentDir.getDirContent().put(tempFile.getPath(),tempFile);
        } else {
            ConsoleIO.printLine("Wrong Argument for touch command");
        }

        VFSFile tempFile = new VFSFile(CurrentDir.getPath(), fileName, new Date(), cmd[2].getBytes());
        //VFSunit tempFileUnit = new File();
        CurrentDir.getDirContent().put(tempFile.getPath(),tempFile);


        return this.saveState(cmd,  currentDisk,root, CurrentDir);


    }
}
