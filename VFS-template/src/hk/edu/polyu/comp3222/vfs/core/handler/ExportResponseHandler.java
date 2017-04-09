package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.io.File;
import java.io.IOException;

/**
 * Created by Isaac on 2/17/17.
 */
public class ExportResponseHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String [] cmd, VisualDisk disk, VFSDirectory Root, VFSDirectory CurrentDir){
        ConsoleIO.printLine("This is the export handler");
        if(cmd.length != 2){
            ConsoleIO.printLine("export command expects one argument");
            return null;
        }

        VFSunit tempFile = CurrentDir.getItem(cmd[1].split("/"));

        ConsoleIO.printLine(tempFile.getClass().toString());
        if(tempFile == null){
            ConsoleIO.printLine("no such file found!");
        }else {
            if (tempFile.getClass() == VFSDirectory.class) {
                createDirectory((VFSDirectory) tempFile);
            } else {
                createFile((VFSFile) tempFile);
            }
        }

        return this.saveState(cmd, disk, Root, CurrentDir);
    }

    /**
     * create file in host file system
     * @param outFile Virtual file to be exported
     */
    public void createFile(VFSFile outFile){
        String tempPath = "host/" + outFile.getPath();
        File tempFile = new File(tempPath);
        try {
            tempFile.getParentFile().mkdirs();
            tempFile.createNewFile();
        }catch (IOException e){
            ConsoleIO.printLine("create file failed, action abort.");
        }
    }

    /**
     * create directory in host file system
     * @param outDir virtual directory to be exported
     */
    public void createDirectory(VFSDirectory outDir){
        String tempPath = "host/" + outDir.getPath();
        File tempDir = new File(tempPath);
        if (!tempDir.exists()) {
            ConsoleIO.printLine("creating directory in host/: " + tempDir.getName());
            boolean result = false;

            try{
                tempDir.mkdirs();
                result = true;
            }
            catch(SecurityException se){
                //handle it
                ConsoleIO.printLine("create directory failed");
            }
            if(result) {
                ConsoleIO.printLine("DIR created");
            }
        }else{
            ConsoleIO.printLine("directory already exists. Operation abort");
        }
    }
}
