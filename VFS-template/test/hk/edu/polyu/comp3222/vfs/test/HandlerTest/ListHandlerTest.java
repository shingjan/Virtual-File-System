package hk.edu.polyu.comp3222.vfs.test.HandlerTest;


import hk.edu.polyu.comp3222.vfs.core.handler.ListResponseHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 2017/4/9.
 */



public class ListHandlerTest {
    private VisualDisk mydisk;
    private ListResponseHandler myhandler;
    private String[] cmd;

    @Before
    public void setup() {
        mydisk = new VisualDisk("test", "test", 13224);
        mydisk.initializeFileSystem();
        myhandler = new ListResponseHandler();
    }

    @Test
    public void testlist(){
        cmd = new String[]{"ls"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        myhandler.handlerOnServer();
    }

}
