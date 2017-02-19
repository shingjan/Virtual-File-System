package hk.edu.polyu.comp3222.vfs.core;

import hk.edu.polyu.comp3222.vfs.Util.IOService;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * A virtual disk.
 */
public class VirtualDisk extends VFSunit{
    private String diskName;
    private final Map<String, VFSunit> diskContent = new LinkedHashMap<>();
    private int dirsCount;
    public static boolean rootHasNext;
    public String username;
    public String password;
    /**
     * Default constructor.
     */
    public VirtualDisk(String sourcePath, String name, Date dateCreated, String username, String password){
        super(sourcePath + name + "/", name, dateCreated);
    }

    public Map<String, VFSunit> getDiskContent() {
        return diskContent;
    }

    @Override
    public void list(boolean detailed, boolean noTree, IOService ioservice) {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;

        if (!(o instanceof VirtualDisk)) return false;

        if (!super.equals(o)) return false;

        VirtualDisk that = (VirtualDisk) o;
        return diskContent.equals(that.diskContent);

    }


}
