package hk.edu.polyu.comp3222.vfs.handler;


import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.Directory;
import hk.edu.polyu.comp3222.vfs.core.VFSunit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Isaac on 2/17/17.
 */
public class ImportResponseHandler extends ResponseHandler{
    public VFSunit handlerResponse(String [] cmd, Directory Root, Directory CurrentDir, IOService ioService){
        ioService.printLine("This is the import handler");
        byte[] content = readFile(cmd[1]);
        ioService.printLine(content.toString());
        hk.edu.polyu.comp3222.vfs.core.File newFile = new hk.edu.polyu.comp3222.vfs.core.File(CurrentDir.getPath(), cmd[1], new Date(),content);
        CurrentDir.getDirContent().put(newFile.getPath(), newFile);
        return CurrentDir;
    }


    public byte[] readFile(String filePath){
        //List<String> records = new ArrayList<String>();
        try
        {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            return data;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }
    }

}
