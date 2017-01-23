package hk.edu.polyu.comp3222.vfs.core;
import java.util.Date;
/**
 * Created by Isaac on 1/23/17.
 */
public class File extends VFSunit{
    private byte[] content;

    public File(String path, String name, Date dateCreated, byte[] content) {
        super(path + name, name, dateCreated);
        this.content = content;
    }

    public String getContent(){
        return content.toString();
    }

    
}
