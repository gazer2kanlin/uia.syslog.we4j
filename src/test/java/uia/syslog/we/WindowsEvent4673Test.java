package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4673;

public class WindowsEvent4673Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  S-1-5-21-669216072-2446163755-4094068255-500 " +
                "Account Name:  Administrator " +
                "Account Domain:  103PRS " +
                "Logon ID:  0x91d84b17 " +
                "Service: " +
                "Server:  Security Account Manager " +
                "Server Name:  Security Account " +
                "Process: " +
                "Process ID:  0x218 " +
                "Process Name:  C:\\Windows\\System32\\lsass.exe " +
                "Service Request Information: " +
                "Privileges:  SeTcbPrivilege ";

        WindowsEvent4673 evt = parse2Object("4673", content, Locale.US);
        Assert.assertEquals("4673", evt.getEventId());

        Assert.assertEquals("S-1-5-21-669216072-2446163755-4094068255-500", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("103PRS", evt.getAccountDomain());
        Assert.assertEquals("0x91d84b17", evt.getLogonId());

        Assert.assertEquals("Security Account Manager", evt.getServer());
        Assert.assertEquals("Security Account", evt.getServerName());

        Assert.assertEquals("0x218", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\lsass.exe", evt.getProcessName());

        Assert.assertEquals("SeTcbPrivilege", evt.getPrivileges());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  S-1-5-21-669216072-2446163755-4094068255-500 " +
                "Account Name:  Administrator " +
                "Account Domain:  103PRS " +
                "Logon ID:  0x91d84b17 " +
                "Service: " +
                "Server:  Security Account Manager " +
                "Server Name:  Security Account " +
                "Process: " +
                "Process ID:  0x218 " +
                "Process Name:  C:\\Windows\\System32\\lsass.exe " +
                "Service Request Information: " +
                "Privileges:  SeTcbPrivilege ";

        Assert.assertNotNull(parse2Map("4673", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼: S-1-5-21-669216072-2446163755-4094068255-500 " +
                "帳戶名稱: Administrator " +
                "帳戶網域: 103PRS " +
                "登入識別碼: 0x91d84b17 " +
                "服務: " +
                "伺服器: Security Account Manager " +
                "服務名稱: Security Account " +
                "處理程序: " +
                "處理程序識別碼: 0x218 " +
                "處理程序名稱: C:\\Windows\\System32\\lsass.exe " +
                "服務要求資訊: " +
                "特殊權限: SeTcbPrivilege";

        Assert.assertNotNull(parse2Map("4673", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-21-669216072-2446163755-4094068255-500");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "103PRS");
        Assert.assertEquals(result.get("logonId"), "0x91d84b17");
        Assert.assertEquals(result.get("server"), "Security Account Manager");
        Assert.assertEquals(result.get("serverName"), "Security Account");
        Assert.assertEquals(result.get("processId"), "0x218");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\lsass.exe");
        Assert.assertEquals(result.get("privileges"), "SeTcbPrivilege");
    }
}
