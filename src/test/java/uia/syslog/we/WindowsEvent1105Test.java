package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent1105;

public class WindowsEvent1105Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Log: Security " +
                "File: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx";

        WindowsEvent1105 evt = parse2Object("1105", content, Locale.US);
        Assert.assertEquals("Eventlog", evt.getEventSource());
        Assert.assertEquals("1105", evt.getEventId());
        Assert.assertEquals("Security", evt.getLog());
        Assert.assertEquals("C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx", evt.getFile());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Log: Security " +
                "File: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx";

        Assert.assertNotNull(parse2Map("1105", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "記錄檔: Security " +
                "檔案: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx";

        Assert.assertNotNull(parse2Map("1105", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("log"), "Security");
        Assert.assertEquals(result.get("file"), "C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx");
    }
}
