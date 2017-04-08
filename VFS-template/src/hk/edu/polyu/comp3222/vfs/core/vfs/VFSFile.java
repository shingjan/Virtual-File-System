package hk.edu.polyu.comp3222.vfs.core.vfs;
import hk.edu.polyu.comp3222.vfs.Util.IOService;

import java.util.Date;
/**
 * Created by Isaac on 1/23/17.
 */
public class VFSFile extends VFSunit {
    private byte[] content;

    /**
     * VFS file
     * @param path path of VFSFile's parent directory
     * @param name name of this VFSFile
     * @param dateCreated date created of this VFSFile
     * @param content content of this VFSFile
     */
    public VFSFile(String path, String name, Date dateCreated, byte[] content) {
        super(path + name, name, dateCreated);
        this.content = content;
    }

    /**
     * get content of this VFSfile
     * @return return the content in string format
     */
    public String getContent() {
        String s = new String(content);
        return s;
    }

    @Override
    public VFSunit getItem(String cmd[], IOService ioService){
        return this;
    }


    @Override
    public int getSize(){
        return content.length;
    }


    
}
