package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

import hk.edu.polyu.comp3222.vfs.core.handler.QueryHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 2017/4/9.
 */



public class QueryHandlerTest {
    private VisualDisk mydisk;
    private QueryHandler myhandler;
    private String[] cmd;

    @Before
    public void setup() {
        mydisk = new VisualDisk("test", "test", 13224);
        mydisk.initializeFileSystem();
        myhandler = new QueryHandler();
    }

    @Test
    public void testquery(){
        cmd = new String[]{"query"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"query","hi"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
    }
}
