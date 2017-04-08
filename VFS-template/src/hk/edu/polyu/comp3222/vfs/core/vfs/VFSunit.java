package hk.edu.polyu.comp3222.vfs.core.vfs;
import hk.edu.polyu.comp3222.vfs.Util.IOService;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.Serializable;
/**
 * Created by selcuk on 23.01.2017.
 */
public abstract class VFSunit implements Serializable{

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");


    private String path;
    private String name;
    private Date dateCreated;

    /**
     * @param path: the path of this VFSunit
     * @param name: the name of this VFSunit
     * @param dateCreated
     * This is something
     */
    protected VFSunit(String path, String name, Date dateCreated) {
        this.path = path;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    /**
     * abstract list method
     * @param detailed: if this list should be detailed
     * @param ioservice: ioservice for this method
     */
    protected abstract void list(boolean detailed, IOService ioservice);

    /**
     * get size method
     * @return return the size of this VFSunit
     */
    protected abstract int getSize();

    /**
     * get path method
     * @return path of this VFSunit in String format
     */
    public String getPath(){
        return path;
    }

    /**
     * getName method
     * @return name of this VFSunit
     */
    public String getName(){
        if(name == null){
            return ".NIL";
        }
        return name;
    }

    /**
     * set name method
     * @param name name to be set for this VFS unit
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * get date created method
     * @return data created in string format
     */
    public String getDateCreated() {
        return dateFormat.format(dateCreated);
    }

    /**
     * retrive VFSunit from a path
     * @param itemName name array of this target item
     * @param ioservice IOservice for this method
     * @return retrived VFS unit from the path
     */
    public abstract VFSunit getItem(String[] itemName, IOService ioservice);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VFSunit)) return false;

        VFSunit that = (VFSunit) o;

        return dateCreated.equals(that.getDateCreated()) && name.equals(that.getName()) && path.equals(that.getPath());
    }
    @Override
    public String toString(){
        return name + " - " + path + " - " + getDateCreated();
    }
}
