package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4616;

public class WindowsEvent4616Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "AUDIT_SUCCESS 系統時間已經變更。 " +
                "Subject: " +
                "Security ID: S-1-5-19 " +
                "Account Name: LOCAL SERVICE " +
                "Account Domain: NT AUTHORITY " +
                "Logon ID: 0x3e5 " +
                "Process Information: " +
                "Process ID: 0x3a0 " +
                "Name: C:\\Windows\\System32\\svchost.exe " +
                "Previous Time: 2017-04-16T17:00:17.117145200Z " +
                "New Time: 2017-04-16T17:00:17.117145201Z " +
                "當系統時間改變時，就會產生此事件。對於以系統權限執行的 Windows 時間服務而言，定期變更系統時間是正常的。其他的系統時間變更則可能表示有人意圖竄改電腦。";

        WindowsEvent4616 evt = parse2Object("4616", content, Locale.US);
        Assert.assertEquals("4616", evt.getEventId());

        Assert.assertEquals("S-1-5-19", evt.getSecurityId());
        Assert.assertEquals("LOCAL SERVICE", evt.getAccountName());
        Assert.assertEquals("NT AUTHORITY", evt.getAccountDomain());
        Assert.assertEquals("0x3e5", evt.getLogonId());

        Assert.assertEquals("0x3a0", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\svchost.exe", evt.getProcessName());

        Assert.assertEquals("2017-04-16T17:00:17.117145200Z", evt.getPreviousTime());
        Assert.assertEquals("2017-04-16T17:00:17.117145201Z", evt.getNewTime());
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS 系統時間已經變更。 " +
                "Subject: " +
                "Security ID: S-1-5-19 " +
                "Account Name: LOCAL SERVICE " +
                "Account Domain: NT AUTHORITY " +
                "Logon ID: 0x3e5 " +
                "Process Information: " +
                "Process ID: 0x3a0 " +
                "Name: C:\\Windows\\System32\\svchost.exe " +
                "Previous Time: 2017-04-16T17:00:17.117145200Z " +
                "New Time: 2017-04-16T17:00:17.117145201Z " +
                "當系統時間改變時，就會產生此事件。對於以系統權限執行的 Windows 時間服務而言，定期變更系統時間是正常的。其他的系統時間變更則可能表示有人意圖竄改電腦。";

        Assert.assertNotNull(parse2Map("4616", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS 系統時間已經變更。 " +
                "主旨: " +
                "安全性識別碼: S-1-5-19 " +
                "帳戶名稱: LOCAL SERVICE " +
                "帳戶網域: NT AUTHORITY " +
                "登入識別碼: 0x3e5 " +
                "處理程序資訊: " +
                "處理程序識別碼: 0x3a0 " +
                "名稱: C:\\Windows\\System32\\svchost.exe " +
                "之前的時間: 2017-04-16T17:00:17.117145200Z " +
                "新時間: 2017-04-16T17:00:17.117145201Z " +
                "當系統時間改變時，就會產生此事件。對於以系統權限執行的 Windows 時間服務而言，定期變更系統時間是正常的。其他的系統時間變更則可能表示有人意圖竄改電腦。";

        Assert.assertNotNull(parse2Map("4616", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-19");
        Assert.assertEquals(result.get("accountName"), "LOCAL SERVICE");
        Assert.assertEquals(result.get("accountDomain"), "NT AUTHORITY");
        Assert.assertEquals(result.get("logonId"), "0x3e5");
        Assert.assertEquals(result.get("processId"), "0x3a0");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\svchost.exe");
        Assert.assertEquals(result.get("previousTime"), "2017-04-16T17:00:17.117145200Z");
        Assert.assertEquals(result.get("newTime"), "2017-04-16T17:00:17.117145201Z");
    }
}
