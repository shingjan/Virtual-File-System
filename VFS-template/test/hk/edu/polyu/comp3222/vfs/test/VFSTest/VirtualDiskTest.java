
package hk.edu.polyu.comp3222.vfs.test.VFSTest;

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
    private VFSDirectory currentdir;
    private int size;



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
        assertEquals(stfile.getName(),testDisk.getROOT_FS().getItemByPath(path,testDisk.getROOT_FS()).getName());
        path="root/1st/foo";
        assertEquals(foofile.getName(),testDisk.getROOT_FS().getItemByPath(path,testDisk.getROOT_FS()).getName());
       path="root/1st/foo/1st";
        assertEquals(nullfile,testDisk.getROOT_FS().getItemByPath(path,testDisk.getROOT_FS()));
    }


    @Test
    public void testgetsize(){
        size = 13356;
        assertEquals(size,testDisk.getSize());
    }

    @Test
    public void testgetCurrentdir(){
        currentdir = testDisk.getCurrentDir();
     assertEquals(currentdir,testDisk.getCurrentDir());

    }

    @Test
    public void testsetCurrentdir(){
        currentdir = new VFSDirectory("root/2nd","3rd",new Date());
        testDisk.setCurrentDir(currentdir);
        currentdir= testDisk.getCurrentDir();
        assertEquals(currentdir,testDisk.getCurrentDir());
    }
    @After
    public void tarDown(){
        testDisk = null;
    }

}