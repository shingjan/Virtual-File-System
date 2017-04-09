package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

import hk.edu.polyu.comp3222.vfs.core.handler.MoveResponseHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 2017/4/9.
 */



public class MoveHandlerTest {
    private VisualDisk mydisk;
    private MoveResponseHandler myhandler;
    private String[] cmd;

    @Before
    public void setup() {
        mydisk = new VisualDisk("test", "test", 13224);
        mydisk.initializeFileSystem();
        myhandler = new MoveResponseHandler();
    }

    @Test
    public void testmove(){
        cmd = new String[]{"mv"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"mv","file3","file3"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"mv","file1","1st"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"mv","file3","file4"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"mv","file4","1st/file4"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"mv","2nd","3rd"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"mv","3rd","1st/3rd"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());

    }

}
