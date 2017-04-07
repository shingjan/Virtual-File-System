package hk.edu.polyu.comp3222.vfs.test;

import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Max.
 */
public class VirtualDiskTest {
    private VisualDisk testDisk;
    private String testName;

    @Before
    public void setup(){
        testDisk = new VisualDisk("test", "test", 13356);
    }

    @Test
    public void testGetName(){
        testName = "test";
        assertEquals(testName, testDisk.getName());
    }

    @After
    public void tarDown(){
        testDisk = null;
    }
}