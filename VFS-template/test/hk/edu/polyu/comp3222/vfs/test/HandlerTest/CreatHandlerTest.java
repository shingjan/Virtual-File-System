package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

/**
 * Created by user on 2017/4/8.
 */

import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.handler.CreateHandler;

import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import org.junit.Before;
import org.junit.Test;





public class CreatHandlerTest {
    private VisualDisk mydisk;
    private CreateHandler myhandler;
    private IOService myios;
    private String[] cmd;
    @Before
    public void setup(){
        mydisk = new VisualDisk("test","test",13224);
        mydisk.initializeFileSystem();
        myhandler = new CreateHandler();
    }

    @Test
    public void testcreate(){
        cmd = new String[]{"touch"};
        myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
        cmd = new String[]{"touch","testfile","mycontent"};
        myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    }

}
