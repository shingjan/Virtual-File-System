package hk.edu.polyu.comp3222.vfs.core.vfs;
import hk.edu.polyu.comp3222.vfs.Util.IOService;

import java.util.Date;
/**
 * Created by Isaac on 1/23/17.
 */
public class VFSFile extends VFSunit {
    private byte[] content;

    public VFSFile(String path, String name, Date dateCreated, byte[] content) {
        super(path + name, name, dateCreated);
        this.content = content;
    }

    public String getContent() {
        String s = new String(content);
        return s;
    }

    public void list(boolean detailed, boolean noTree, IOService ioservice) {

    }

    public VFSunit getItem(String cmd[], IOService ioService){
        return this;
    }


    @Override
    public int getSize(){
        return 4;//content.length;
    }


    
}
