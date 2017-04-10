package hk.edu.polyu.comp3222.vfs.core.handler;


import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;

import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by Isaac on 2/17/17.
 */
public class ImportResponseHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String [] cmd, VisualDisk currentDisk, VFSDirectory Root, VFSDirectory CurrentDir) {
        ConsoleIO.printLine("import command requires two argument:");
        ConsoleIO.printLine("import <-f filename> or <-r directoryname>");
        this.saveState(cmd, currentDisk, Root, CurrentDir);
        if (cmd.length == 3 && cmd[1].equals("-f")) {
            byte[] content = readFile(cmd[1]);
            //ConsoleIO.printLine(new String(content));
            VFSFile newFile = new VFSFile(CurrentDir.getPath(), cmd[1], new Date(), content);
            CurrentDir.getDirContent().put(newFile.getPath(), newFile);
            return this.saveState(cmd, currentDisk, Root, CurrentDir);
        }else if(cmd.length == 3 && cmd[1].equals("-r")){
            String dirName = readDirectory(cmd[2]);
            VFSDirectory tempDirectory = new VFSDirectory(CurrentDir.getPath(), dirName, new Date());
            CurrentDir.getDirContent().put(tempDirectory.getPath(), tempDirectory);
            return this.saveState(cmd, currentDisk, Root, CurrentDir);
        }else {
            ConsoleIO.printLine("import file will require one argument, import directory with one more argument 'r'");
            return null;
        }

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
            Path tempPath = Paths.get("host/" + filePath);
            return Files.readAllBytes(tempPath);
        }
        catch (IOException e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * read directory from host file system
     * @param dirPath path of directory on host file system
     * @return return the name of the directory
     */
    public String readDirectory(String dirPath){
            Path dir = Paths.get("host/" + dirPath);
            return dirPath;
    }

}
