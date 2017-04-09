package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

import hk.edu.polyu.comp3222.vfs.core.handler.RemoveHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 2017/4/9.
 */
public class RemoveHandlerTest {
    private VisualDisk mydisk;
    private RemoveHandler myhandler;
    private String[] cmd;

    @Before
    public void setup() {
        mydisk = new VisualDisk("test", "test", 13224);
        mydisk.initializeFileSystem();
        myhandler = new RemoveHandler();
    }

    @Test
    public void testRemove(){
        cmd = new String[]{"remove"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"remove","file6"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"remove","file3"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
    }

}
