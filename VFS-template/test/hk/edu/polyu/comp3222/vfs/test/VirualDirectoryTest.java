package hk.edu.polyu.comp3222.vfs.test;

/**
 * Created by user on 2017/4/7.
 */

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import static org.junit.Assert.*;

public class VirualDirectoryTest {
    private VFSDirectory mydir;
    private IOService myios;
    private VFSDirectory otherdir;
    private VFSFile myfile;
    private int size;

    @Before
    public void Setup(){
        mydir = new VFSDirectory("root/","1st",new Date());
    }

    @Test
    public void Testlist() throws NullPointerException{
        mydir.list(true,myios);
        mydir.list(false,myios);
    }

    @Test
    public void Testequal(){
    otherdir = new VFSDirectory("root/","1st",new Date());
     assertEquals(true,mydir.equals(otherdir));
    }

    @Test
    public void TestgetItem(){
        myfile = new VFSFile("root/","foo",new Date(),"foo".getBytes());
        mydir.getDirContent().put(myfile.getPath(), myfile);




    }


    @Test
    public void TestgetSize(){
       size =2 ;
        assertEquals(size,mydir.getSize());
        myfile = new VFSFile("root/","foo",new Date(),"foo".getBytes());
        mydir.getDirContent().put(myfile.getPath(), myfile);
        size = 6;
      assertEquals(size,mydir.getSize());
    }


    @After
    public void tardonw(){
        mydir = null;
    }
}
