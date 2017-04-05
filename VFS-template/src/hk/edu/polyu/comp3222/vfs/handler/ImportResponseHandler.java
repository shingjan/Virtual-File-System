package hk.edu.polyu.comp3222.vfs.handler;


import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
