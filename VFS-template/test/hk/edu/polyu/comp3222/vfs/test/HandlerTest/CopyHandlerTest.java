package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

/**
 * Created by user on 2017/4/8.
 */
import hk.edu.polyu.comp3222.vfs.Util.ConsoleIO;
import hk.edu.polyu.comp3222.vfs.Util.IOService;
import hk.edu.polyu.comp3222.vfs.core.handler.CopyResponseHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSDirectory;
import hk.edu.polyu.comp3222.vfs.core.vfs.VFSFile;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;





public class CopyHandlerTest {
    private VisualDisk mydisk;
    private CopyResponseHandler myhandler;
    private IOService myios;
    private String[] cmd;
    @Before
    public void setup(){
        mydisk = new VisualDisk("test","test",13224);
        mydisk.initializeFileSystem();
        myhandler = new CopyResponseHandler();
    }

@Test
    public void testcopy(){
    cmd = new String[]{"cp"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"cp","file3","file3"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"cp","file3","1st/file3"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"cp","file4","root/"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"cp","file3","file565"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"cp","1st","5th"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"cp","5th","2nd/new"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
}




}
