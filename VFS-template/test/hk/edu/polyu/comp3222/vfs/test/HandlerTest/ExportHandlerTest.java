package hk.edu.polyu.comp3222.vfs.test.HandlerTest;

/**
 * Created by user on 2017/4/8.
 */






import hk.edu.polyu.comp3222.vfs.core.handler.ExportResponseHandler;

import hk.edu.polyu.comp3222.vfs.core.vfs.VisualDisk;

import org.junit.Before;
import org.junit.Test;







public class ExportHandlerTest {
    private VisualDisk mydisk;
    private ExportResponseHandler myhandler;
    private String[] cmd;

    @Before
    public void setup() {
        mydisk = new VisualDisk("test", "test", 13224);
        mydisk.initializeFileSystem();
        myhandler = new ExportResponseHandler();
    }

@Test
    public void testExport(){
    cmd = new String[]{"export"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"export","file4"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"export","file3"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
    cmd = new String[]{"export","1st"};
    myhandler.handlerResponse(cmd,mydisk,mydisk.getROOT_FS(),mydisk.getCurrentDir());
}



}
