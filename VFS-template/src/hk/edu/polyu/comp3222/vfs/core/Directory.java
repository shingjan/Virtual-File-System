package hk.edu.polyu.comp3222.vfs.core;

import hk.edu.polyu.comp3222.vfs.Util.IOService;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Isaac on 1/23/17.
 */
public class Directory extends VFSunit{
    private String dirName;
    private final Map<String, VFSunit> dirContent = new LinkedHashMap<>();
    private int dirCount;
    public static boolean rootHasNext;
    /**
     * Default constructor.
     */
    public Directory(String sourcePath, String name, Date dateCreated){
        super(sourcePath + name + "/", name, dateCreated);
    }

    public Map<String, VFSunit> getDirContent() {
        return dirContent;
    }

    @Override
    public void list(boolean detailed, boolean noTree, IOService ioservice) {
        final StringBuilder sb = new StringBuilder();

        if (!noTree) {
            if (detailed) {
                sb.append(toString());
            } else {
                sb.append(getName());
            }
            ioservice.printLine(sb.toString());
        }

        dirCount++;

        final Iterator<Map.Entry<String, VFSunit>> iterator = dirContent.entrySet().iterator();
        VFSunit fileSystemUnit;

        while (iterator.hasNext()) {
            fileSystemUnit = iterator.next().getValue();
            if (noTree) {
                ioservice.printLine(fileSystemUnit.toString());
            } else {
                if ("./".equals(getPath())) {
                    rootHasNext = iterator.hasNext();
                }
                //ioservice.printLine(iterator.hasNext()), true);
                fileSystemUnit.list(detailed, false, ioservice);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;

        if (!(o instanceof VirtualDisk)) return false;

        if (!super.equals(o)) return false;

        Directory that = (Directory) o;
        return dirContent.equals(that.dirContent);

    }
}
