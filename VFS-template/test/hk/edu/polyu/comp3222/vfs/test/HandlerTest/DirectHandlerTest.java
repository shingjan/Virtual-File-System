package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

/**
 * Created by user on 2017/4/8.
 */

import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.handler.DirectResponseHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;





public class DirectHandlerTest {
    private VisualDisk mydisk;
    private DirectResponseHandler myhandler;
    private String[] cmd;
    @Before
    public void setup(){
        mydisk = new VisualDisk("test","test",13224);
        mydisk.initializeFileSystem();
        myhandler = new DirectResponseHandler();
    }

    @Test
    public void testdircet(){
      cmd = new String[]{"cd"};
      myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
        cmd = new String[]{"cd","1st"};
        myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
        cmd = new String[]{"cd","3rd"};
        myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
        cmd = new String[]{"cd","file3"};
        myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    }

}
