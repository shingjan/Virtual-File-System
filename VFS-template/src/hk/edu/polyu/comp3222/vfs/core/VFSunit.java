package hk.edu.polyu.comp3222.vfs.core;
import hk.edu.polyu.comp3222.vfs.Util.IOService;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Created by selcuk on 23.01.2017.
 */
public abstract class VFSunit {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");


    private String path;
    private String name;
    private Date dateCreated;

    /**
     * This is something
     */
    protected VFSunit(String path, String name, Date dateCreated) {
        this.path = path;
        this.name = name;
        this.dateCreated = dateCreated;
    }
    protected abstract void list(boolean detailed, boolean noTree, IOService ioservice);
    //all the getter
    public String getPath(){
        return path;
    }

    public String getName(){
        if(name == null){
            return ".NIL";
        }
        return name;
    }

    public String getDateCreated() {
        return dateFormat.format(dateCreated);
    }

    public abstract VFSunit getItem(String[] itemName, IOService ioservice);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VFSunit)) return false;

        VFSunit that = (VFSunit) o;

        return dateCreated.equals(that.dateCreated) && name.equals(that.name) && path.equals(that.path);
    }
    @Override
    public String toString(){
        return name + " - " + path + " - " + getDateCreated();
    }
}
