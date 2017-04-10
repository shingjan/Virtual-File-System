package hk.edu.polyu.comp3222.vfs.core.vfs;

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;


import java.util.*;

/**
 * Created by Isaac on 1/23/17.
 */
public class VFSDirectory extends VFSunit {
    private final Map<String, VFSunit> dirContent = new LinkedHashMap<>();
    /**
     * Default constructor.
     * @param sourcePath sourcePath from parent directory
     * @param name name of this vfs directory
     * @param dateCreated date created of this VFSDirectory
     */
    public VFSDirectory(String sourcePath, String name, Date dateCreated){
        super(sourcePath + name + "/", name, dateCreated);
    }

    /**
     * get directory content method
     * @return the content of directory
     */
    public Map<String, VFSunit> getDirContent() {
        return dirContent;
    }

    /**
     * list all content inside this directory
     * @param detailed if detailed content is shown
     */
    public void list(boolean detailed) {

        final Iterator<Map.Entry<String, VFSunit>> iterator = dirContent.entrySet().iterator();
        VFSunit fileSystemUnit;

        while (iterator.hasNext()) {
            fileSystemUnit = iterator.next().getValue();
            ConsoleIO.printLine(fileSystemUnit.toString());

        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;

        if (!(o instanceof VFSDirectory)) return false;

        if (!super.equals(o)) return false;

        VFSDirectory that = (VFSDirectory) o;
        return dirContent.equals(that.getDirContent());
    }

    /**
     * get item from current directory method
     * @param itemname string array of the path & name of target item
     * @return return the target item or null if not found
     */
    public VFSunit getItem(String[] itemname){
        //final Iterator<Map.Entry<String, VFSunit>> iterator = dirContent.entrySet().iterator();
        VFSunit fileSystemUnit;
        int level = 0;
        for (String key:dirContent.keySet()) {

            fileSystemUnit = dirContent.get(key);

            if (fileSystemUnit.getName().equals(itemname[level])) {

                if(itemname.length == level + 1){
                    return fileSystemUnit;
                }else{
                    level++;

                    String[] newItemName = Arrays.copyOfRange(itemname, level, itemname.length);
                    VFSDirectory tempDir = (VFSDirectory) fileSystemUnit;
                    return tempDir.getItem(newItemName);
                }
            }
            //break;
        }
        return null;
    }

    @Override
    public int getSize(){
        int sum = 2;
        for (VFSunit value : dirContent.values()) {
                sum += value.getSize();
        }
        return sum;
    }

    /**
     * retrive item from current directory by path
     * @param path path of the target item
     * @param root to-be-searched directory
     * @return return the search result
     */
    public VFSunit getItemByPath(String path, VFSDirectory root) {
        if (path.equals(root.getPath()))
            return root;

        VFSunit fileSystemUnit;

        // check first whether the object with the specified path exists in source folder
        if ((fileSystemUnit = root.getDirContent().get(path)) != null) {
            return fileSystemUnit;
        }

        // if not, deep check every single entry in the current directory
        for (VFSunit value : root.getDirContent().values()) {
            ConsoleIO.printLine(value.getPath());
            if (value.getClass() == VFSDirectory.class) {
                fileSystemUnit = getItemByPath(path, (VFSDirectory) value);
            } else {
                fileSystemUnit = value;
            }

            if (fileSystemUnit != null && path.equals(fileSystemUnit.getPath()))
                return fileSystemUnit;
        }
        return null;
    }

}
