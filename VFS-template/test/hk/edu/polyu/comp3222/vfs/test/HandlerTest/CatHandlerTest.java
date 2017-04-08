package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

/**
 * Created by user on 2017/4/8.
 */

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.handler.CatHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;




public class CatHandlerTest {
    private VisualDisk mydisk;
    private VFSFile nullfile;
    private CatHandler myhandler;
    private IOService myios;
    private String[] cmd;

    @Before
    public void setup(){
        mydisk.initializeFileSystem();
        cmd = new String[]{"cd",};
        myhandler = new CatHandler()
    }

    @Test
    public void testcat(){




    }



}
