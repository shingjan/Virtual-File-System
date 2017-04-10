package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

/**
 * Created by user on 2017/4/9.
 */
import hk.edu.polyu.comp3222.vfs.core.handler.ImportResponseHandler;

import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import org.junit.Before;
import org.junit.Test;




public class ImportHandlerTest {
    private VisualDisk mydisk;
    private ImportResponseHandler myhandler;
    private String[] cmd;

    @Before
    public void setup() {
        mydisk = new VisualDisk("test", "test", 13224);
        mydisk.initializeFileSystem();
        myhandler = new ImportResponseHandler();
    }

    @Test
    public void testimport()

    {
        cmd = new String[]{"import"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"import","-f","direct"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
        cmd = new String[]{"import","-r","media"};
        myhandler.handlerResponse(cmd, mydisk, mydisk.getROOT_FS(), mydisk.getCurrentDir());
    }
}
