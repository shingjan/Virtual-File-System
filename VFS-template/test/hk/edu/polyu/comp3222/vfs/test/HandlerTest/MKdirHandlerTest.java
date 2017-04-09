package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

import hk.edu.polyu.comp3222.vfs.core.handler.MkdirHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 2017/4/9.
 */
public class MKdirHandlerTest {
    private VisualDisk mydisk;
    private MkdirHandler myhandler;
    private String[] cmd;

    @Before
    public void setup() {
        mydisk = new VisualDisk("test", "test", 13224);
        mydisk.initializeFileSystem();
        myhandler = new MkdirHandler();
    }

    @Test
    public void testMKdir(){
        cmd = new String[]{"MKdir"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"MKdir","1st"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());

    }
}
