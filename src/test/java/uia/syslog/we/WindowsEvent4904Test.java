package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4904Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Process: " +
                "Process ID: 0x1140 " +
                "Process Name: C:\\Windows\\System32\\VSSVC.exe " +
                "Event Source: " +
                "Source Name: VSSAudit " +
                "Event Source ID: 0x9c8e0af1";
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Process: " +
                "Process ID: 0x1140 " +
                "Process Name: C:\\Windows\\System32\\VSSVC.exe " +
                "Event Source: " +
                "Source Name: VSSAudit " +
                "Event Source ID: 0x9c8e0af1";

        Assert.assertNotNull(parse2Map("4904", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼: S-1-5-18 " +
                "帳戶名稱: 103PRSDB " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "處理程序: " +
                "處理程序識別碼: 0x1140 " +
                "處理程序名稱: C:\\Windows\\System32\\VSSVC.exe " +
                "事件來源: " +
                "來源名稱: VSSAudit " +
                "事件來源識別碼: 0x9c8e0af1";

        Assert.assertNotNull(parse2Map("4904", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-18");
        Assert.assertEquals(result.get("accountName"), "103PRSDB");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");

        Assert.assertEquals(result.get("processId"), "0x1140");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\VSSVC.exe");

        Assert.assertEquals(result.get("sourceName"), "VSSAudit");
        Assert.assertEquals(result.get("eventSourceId"), "0x9c8e0af1");
    }
}
