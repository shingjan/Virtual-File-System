package hk.edu.polyu.comp3222.vfs.core.handler;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;

import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSunit;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import java.util.Arrays;

/**
 * Created by Isaac on 1/27/17.
 */
public class SearchResponseHandler extends ResponseHandler{
    @Override
    public VFSunit handlerResponse(String[] cmd, VisualDisk currentDisk, VFSDirectory Root, VFSDirectory CurrentDir){
        if(cmd.length < 6){
            ConsoleIO.printLine("search command needs at least 5 argument\n" +
                    "Case sensitive or not? (Y/N):\n" +
                    "include any keyword or all? (Y/N):\n" +
                    "search in current directory or root? (Y/N):\n" +
                    "only file or file & subdirectory? (Y/N):\n" +
                    "keyword(s)");
        }else{
            /*------case sensitive or not-----*/
            //String caseArg = ConsoleIO.readLine("Case sensitive or not? (Y/N): ");
            if(cmd[1].equals("N") || cmd[1].equals("n")){
                for (int k = 5; k < cmd.length; k++){
                    cmd[k] = cmd[k].toLowerCase();
                }
            }
            /*-------all include or not-------*/
            //String keywordArg = ConsoleIO.readLine("include any keyword or all? (Y/N): ");
            if(cmd[2].equals("N") || cmd[2].equals("n")){
                String tempPath = "root/";
                for (int i = 5; i < cmd.length; i++){
                    tempPath += cmd[i];
                }
                cmd[5] = tempPath;
                cmd = Arrays.copyOfRange(cmd, 0, 5);
            }

            /*-------search in currentDir or root------------*/
            //String dirArg = ConsoleIO.readLine("search in current directory or root? (Y/N): ");
            if(cmd[3].equals("N") || cmd[3].equals("n")){
                CurrentDir = Root;
            }

            /*--------only file or both directory-------------*/
            //String subArg = ConsoleIO.readLine("only file or file & subdirectory? (Y/N): ");

            for (int j = 5; j < cmd.length; j++){
                searchResult(cmd[j], CurrentDir);
            }


        }
        return this.saveState(cmd, currentDisk, Root, CurrentDir);
    }

    /**
     * search a single file inside VFSdirectory
     * @param itemName name of target file
     * @param dir VFSdirectory to be searched
     */
    public void searchResult(String itemName, VFSDirectory dir){
        VFSunit fileSystemUnit = dir.getItem(itemName.split("/"));
        if (fileSystemUnit != null) {
            ConsoleIO.printLine(fileSystemUnit.getPath());
        }
        for(VFSunit s: dir.getDirContent().values()) {
            if(s.getClass() == VFSDirectory.class){
                searchResult(itemName, (VFSDirectory) s);
            }
        }
    }
}
