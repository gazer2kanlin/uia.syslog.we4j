package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4985;

public class WindowsEvent4985Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Transaction Information: " +
                "RM Transaction ID: {7a1beac9-ab0f-11dc-a998-000c29fee385} " +
                "New State: 48 " +
                "Resource Manager: {dbcb1457-a76f-11dc-ae5a-c74dbd19033c} " +
                "Process Information: " +
                "Process ID: 0x1ac " +
                "Process Name: C:\\Windows\\System32\\cmd.exe ";

        WindowsEvent4985 evt = parse2Object("4985", content, Locale.US);
        Assert.assertEquals("4985", evt.getEventId());

        Assert.assertEquals("ACME\\Administrator", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("ACME", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());

        Assert.assertEquals("{7a1beac9-ab0f-11dc-a998-000c29fee385}", evt.getRmTransactionId());
        Assert.assertEquals("48", evt.getNewState());
        Assert.assertEquals("{dbcb1457-a76f-11dc-ae5a-c74dbd19033c}", evt.getResourceManager());

        Assert.assertEquals("0x1ac", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\cmd.exe", evt.getProcessName());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Transaction Information: " +
                "RM Transaction ID: {7a1beac9-ab0f-11dc-a998-000c29fee385} " +
                "New State: 48 " +
                "Resource Manager: {dbcb1457-a76f-11dc-ae5a-c74dbd19033c} " +
                "Process Information: " +
                "Process ID: 0x1ac " +
                "Process Name: C:\\Windows\\System32\\cmd.exe ";

        Assert.assertNotNull(parse2Map("4985", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  ACME\\Administrator " +
                "帳戶名稱:  Administrator " +
                "帳戶網域:  ACME " +
                "登入識別碼:  0x1f41e " +
                "交易資訊: " +
                "RM 交易識別碼: {7a1beac9-ab0f-11dc-a998-000c29fee385} " +
                "新狀態: 48 " +
                "資源管理員: {dbcb1457-a76f-11dc-ae5a-c74dbd19033c} " +
                "處理程序資訊: " +
                "處理程序識別碼: 0x1ac " +
                "處理程序名稱: C:\\Windows\\System32\\cmd.exe ";

        Assert.assertNotNull(parse2Map("4985", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "ACME\\Administrator");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "ACME");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");
        Assert.assertEquals(result.get("rmTransactionId"), "{7a1beac9-ab0f-11dc-a998-000c29fee385}");
        Assert.assertEquals(result.get("newState"), "48");
        Assert.assertEquals(result.get("resourceManager"), "{dbcb1457-a76f-11dc-ae5a-c74dbd19033c}");
        Assert.assertEquals(result.get("processId"), "0x1ac");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\cmd.exe");
    }
}
