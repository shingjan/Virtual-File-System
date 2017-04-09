package hk.edu.polyu.comp3222.vfs.core.handler;


import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by Isaac on 2/17/17.
 */
public class ImportResponseHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String [] cmd, VisualDisk currentDisk, VFSDirectory Root, VFSDirectory CurrentDir){
        ConsoleIO.printLine("This is the import handler");
        this.saveState(cmd, currentDisk, Root, CurrentDir);
        if(cmd.length == 2) {
            byte[] content = readFile(cmd[1]);
            ConsoleIO.printLine(new String(content));
            VFSFile newFile = new VFSFile(CurrentDir.getPath(), cmd[1], new Date(), content);
            CurrentDir.getDirContent().put(newFile.getPath(), newFile);
            return this.saveState(cmd, currentDisk, Root, CurrentDir);
        }
        else
            ConsoleIO.printLine("Please input an argument");
        return null;
    }

    /**
     * read file in host file system and output as byte array
     * @param filePath path of the file to be read
     * @return return the byte array of the content of the file
     */
    public byte[] readFile(String filePath){
        //List<String> records = new ArrayList<String>();
        try
        {
            byte[] encoded = Files.readAllBytes(Paths.get("host/"+filePath));

            return encoded;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }
    }

}
