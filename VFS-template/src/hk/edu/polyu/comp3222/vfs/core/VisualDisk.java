package hk.edu.polyu.comp3222.vfs.core;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.server.SerializationController;
import hk.edu.polyu.comp3222.vfs.handler.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Isaac on 2/15/17.
 */
public class VisualDisk {
    public final Directory ROOT_FS;
    public final String ROOT_PATH;
    private String username, password;
    private int diskSize;
    private Directory currentDir;
    public IOService ioService;
    public final Map<String, ResponseHandler> themap = new HashMap<>();

    public VisualDisk(String username, String password, int diskSize) {
        ROOT_FS = new Directory("", "root.", new Date());
        ROOT_PATH = ROOT_FS.getPath();
        currentDir = ROOT_FS;
        themap.put("cd", new DirectResponseHandler());
        themap.put("ls", new ListResponseHandler());
        themap.put("mv", new MoveResponseHandler());
        themap.put("cp", new CopyResponseHandler());
        themap.put("mkdir", new MkdirHandler());
        themap.put("touch", new CreateHandler());
        themap.put("cat", new CatHandler());
        themap.put("rename", new RenameResponseHandler());
        themap.put("search", new SearchResponseHandler());
        themap.put("help", new HelpHandler());
        themap.put("quit", new QuitResponseHandler());
    }

    public void boot(){
        //String command;
        String[] cmd_segments;
        ioService = new ConsoleIO();
        //ioService.printInstructions();
        while (true){
            ioService.printLine("Current Working Directory is:");
            ioService.printLine(currentDir.getPath());
            cmd_segments = ioService.readLine("-->").split(" ");
            ResponseHandler cmd = themap.get(cmd_segments[0]);
            if(cmd != null){
                currentDir = (Directory) cmd.handlerResponse(cmd_segments, ROOT_FS, currentDir, ioService);
                if(currentDir == null){
                    System.exit(0);
                }
            }else{
                ioService.printLine("wrong command, input again");
            }

        }
    }

    public void initializeFileSystem(){
        Directory firstFolder = new Directory(ROOT_PATH, "1st", new Date());
        File file1 = new File(firstFolder.getPath(), "foo", new Date(), "This is the content of foo".getBytes());
        Directory secondFolder = new Directory(ROOT_PATH, "2nd", new Date());
        File file2 = new File(secondFolder.getPath(), "bar", new Date(), "This is the content of bar".getBytes());
        currentDir.getDirContent().put(firstFolder.getPath(), firstFolder);
        currentDir.getDirContent().put(secondFolder.getPath(), secondFolder);
        firstFolder.getDirContent().put(file1.getPath(),file1);
        secondFolder.getDirContent().put(file2.getPath(), file2);
    }

    public static VisualDisk loadFS(String username, String password, int diskSize) {
        VisualDisk fileSystem = SerializationController.getInstance().deserialize(username);
        if (fileSystem != null) {
            return fileSystem;
        } else {
            fileSystem = new VisualDisk(username, password, diskSize);
            fileSystem.initializeFileSystem();
        }
        return fileSystem;
    }

    public String getName(){
        return username;
    }
}
