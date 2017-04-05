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
                "Security ID:  SYSTEM " +
                "Account Name:  ONE " +
                "Account Domain:  WORKGROUP " +
                "Logon ID:  0x1f41e " +
                "Service: " +
                "Server:  NT Local Security Authority " +
                "Server Name:  LsaRegisterLogonProcess() " +
                "Process: " +
                "Process ID:  0x238 " +
                "Process Name:  C:\\Windows\\System32\\lsass.exe " +
                "Service Request Information: " +
                "Privileges:  SeTcbPrivilege ";

        WindowsEvent4673 evt = parse2Object("4673", content, Locale.US);
        Assert.assertEquals("4673", evt.getEventId());
        Assert.assertEquals("SYSTEM", evt.getSecurityId());
        Assert.assertEquals("ONE", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());
        Assert.assertEquals("NT Local Security Authority", evt.getServer());
        Assert.assertEquals("LsaRegisterLogonProcess()", evt.getServerName());
        Assert.assertEquals("0x238", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\lsass.exe", evt.getProcessName());
        Assert.assertEquals("SeTcbPrivilege", evt.getPrivileges());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  SYSTEM " +
                "Account Name:  ONE " +
                "Account Domain:  WORKGROUP " +
                "Logon ID:  0x1f41e " +
                "Service: " +
                "Server:  NT Local Security Authority " +
                "Server Name:  LsaRegisterLogonProcess() " +
                "Process: " +
                "Process ID:  0x238 " +
                "Process Name:  C:\\Windows\\System32\\lsass.exe " +
                "Service Request Information: " +
                "Privileges:  SeTcbPrivilege ";

        Assert.assertNotNull(parse2Map("4673", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  SYSTEM " +
                "帳戶名稱:  ONE " +
                "帳戶網域:  WORKGROUP " +
                "登入識別碼:  0x1f41e " +
                "Service: " +
                "Server:  NT Local Security Authority " +
                "Server Name:  LsaRegisterLogonProcess() " +
                "處理程序資訊: " +
                "處理程序識別碼:  0x238 " +
                "處理程序名稱:  C:\\Windows\\System32\\lsass.exe " +
                "Service Request Information: " +
                "特殊權限:  SeTcbPrivilege ";

        Assert.assertNotNull(parse2Map("4673", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "SYSTEM");
        Assert.assertEquals(result.get("accountName"), "ONE");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");
    }
}
