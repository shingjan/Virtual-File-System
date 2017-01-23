package hk.edu.polyu.comp3222.vfs.core;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Created by selcuk on 23.01.2017.
 */
public class VFSunit {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy HH:mm");


    private String path;
    private String name;
    private Date dateCreated;

    /*

     */
    protected VFSunit(String path, String name, Date dateCreated) {
        this.path = path;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    //all the getter
    public String getPath(){
        return path;
    }

    public String getName(){
        return name;
    }

    public String getDateCreated(){
        return dateFormat.format(dateCreated);
    }

    @Override
    public String toString(){
        return name + "[" + path + "]" + getDateCreated();
    }
}
