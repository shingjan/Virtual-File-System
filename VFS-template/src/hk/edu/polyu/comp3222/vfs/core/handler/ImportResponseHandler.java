package hk.edu.polyu.comp3222.vfs.core.handler;


import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by Isaac on 2/17/17.
 */
public class ImportResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String [] cmd, VFSDirectory Root, VFSDirectory CurrentDir, IOService ioService){
        ioService.printLine("This is the import handler");
        byte[] content = readFile(cmd[1]);
        ioService.printLine(new String(content));
        VFSFile newFile = new VFSFile(CurrentDir.getPath(), cmd[1], new Date(),content);
        CurrentDir.getDirContent().put(newFile.getPath(), newFile);
        return CurrentDir;
    }


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
