package hk.edu.polyu.comp3222.vfs.core.vfs;

import hk.edu.polyu.comp3222.vfs.Util.IOService;

import java.util.*;

/**
 * Created by Isaac on 1/23/17.
 */
public class VFSDirectory extends VFSunit {
    private String dirName;
    private final Map<String, VFSunit> dirContent = new LinkedHashMap<>();
    private int dirCount;
    public static boolean rootHasNext;
    /**
     * Default constructor.
     */
    public VFSDirectory(String sourcePath, String name, Date dateCreated){
        super(sourcePath + name + "/", name, dateCreated);
    }

    public Map<String, VFSunit> getDirContent() {
        return dirContent;
    }

    @Override
    public void list(boolean detailed,  IOService ioservice) {
        final StringBuilder sb = new StringBuilder();
/*
        if (!noTree) {
            if (detailed) {
                sb.append(toString());
            } else {
                sb.append(getName());
            }
            ioservice.printLine(sb.toString());
        }
*/
        dirCount++;

        final Iterator<Map.Entry<String, VFSunit>> iterator = dirContent.entrySet().iterator();
        VFSunit fileSystemUnit;

        while (iterator.hasNext()) {
            fileSystemUnit = iterator.next().getValue();
            ioservice.printLine(fileSystemUnit.toString());

        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;

        if (!(o instanceof VFSDirectory)) return false;

        if (!super.equals(o)) return false;

        VFSDirectory that = (VFSDirectory) o;
        return dirContent.equals(that.dirContent);

    }

    @Override
    public VFSunit getItem(String[] itemname, IOService ioservice){
        //final Iterator<Map.Entry<String, VFSunit>> iterator = dirContent.entrySet().iterator();
        VFSunit fileSystemUnit;
        int level = 0;
        for (String key:dirContent.keySet()) {

            fileSystemUnit = dirContent.get(key);
            //ioservice.printLine(fileSystemUnit.getName());
            if (fileSystemUnit.getName().equals(itemname[level])) {
                //ioservice.printLine(String.valueOf(itemname.length));
                if(itemname.length == level + 1){
                    return fileSystemUnit;
                }else{
                    String[] newItemName = Arrays.copyOfRange(itemname, level, itemname.length);
                    return fileSystemUnit.getItem(newItemName, ioservice);
                }
            }
            //break;
        }
        return null;
    }

    @Override
    public int getSize(){

        int sum = 2;
        for (Object value : dirContent.values()) {
            if(value.getClass() == VFSFile.class){
                VFSFile tempFile = (VFSFile) value;
                sum += tempFile.getSize();
            }else if(value.getClass() == VFSDirectory.class){
                VFSDirectory tempFile = (VFSDirectory) value;
                sum += tempFile.getSize();
            }

        }

        return sum;
    }

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
