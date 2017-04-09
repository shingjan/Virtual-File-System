package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

/**
 * Created by user on 2017/4/8.
 */

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.handler.CatHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;




public class CatHandlerTest {
    private VisualDisk mydisk;
    private CatHandler myhandler;
    private String[] cmd;


    @Before
    public void setup(){
        mydisk = new VisualDisk("test","test",13224);
        mydisk.initializeFileSystem();

        cmd = new String[]{"cat","file3"};
        myhandler = new CatHandler();

    }

@Test
    public void testcat(){
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"cat","1st"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"cat","1st111"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"cat"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    }

@After
    public void tardown(){
        myhandler= null;
}

}
