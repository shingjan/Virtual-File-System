package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Max.
 */
public class VirtualDiskTest {
    private VisualDisk testDisk;
    private String testName;
    private String path;
    private VFSDirectory stfile;
    private VFSFile foofile;
    private VFSFile nullfile;




    @Before
    public void setup(){
        testDisk = new VisualDisk("test", "test", 13356);
    }

    @Test
    public void testGetName(){
        testName = "test";
        assertEquals(testName, testDisk.getName());
    }

    @Test
    public void testgetItemByPath(){
        VFSDirectory stfile = new VFSDirectory("root/", "1st", new Date());
        VFSFile foofile = new VFSFile("root/1st/","foo",new Date(), "1111".getBytes());
        VFSFile nullfile = null;
        path = "root/1st/";
        assertEquals(stfile.getName(),testDisk.getItemByPath(path,testDisk.ROOT_FS).getName());
        path="root/1st/foo";
        assertEquals(foofile.getName(),testDisk.getItemByPath(path,testDisk.ROOT_FS).getName());
        path="root/1st/foo/1st";
        assertEquals(nullfile,testDisk.getItemByPath(path,testDisk.ROOT_FS));
    }




    @After
    public void tarDown(){
        testDisk = null;
    }
}