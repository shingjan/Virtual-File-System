package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

import hk.edu.polyu.comp3222.vfs.core.handler.RenameHandler;
import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 2017/4/9.
 */
public class RenameHandlerTest {
    private VisualDisk mydisk;
    private RenameHandler myhandler;
    private String[] cmd;

    @Before
    public void setup() {
        mydisk = new VisualDisk("test", "test", 13224);
        mydisk.initializeFileSystem();
        myhandler = new RenameHandler();
    }

@Test
    public void testRename(){
    cmd = new String[]{"rename"};
    myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
    cmd = new String[]{"rename","file6","file5"};
    myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
    cmd = new String[]{"rename","file3","file4"};
    myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
}
}
