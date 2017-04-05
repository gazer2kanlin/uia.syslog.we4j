package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4648;

public class WindowsEvent4648Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Logon GUID:  {00000000-0000-0000-0000-000000000000} " +
                "Account Whose Credentials Were Used: " +
                "Account Name:  rsmith@mtg.com " +
                "Account Domain:  WIN-R9H529RIO4Y " +
                "Logon GUID:  {10000000-0000-0000-0000-000000000000} " +
                "Target Server: " +
                "Target Server Name: sp01.IceMAIL.com " +
                "Additional Information: sp01.IceMAIL.com " +
                "Process Information: " +
                "Process ID: 0x1ac " +
                "Process Name: C:\\Windows\\System32\\cmd.exe " +
                "Network Information: " +
                "Network Address: 0.0.0.0 " +
                "Port: 514 ";

        WindowsEvent4648 evt = parse2Object("4648", content, Locale.US);
        Assert.assertEquals("4648", evt.getEventId());
        Assert.assertEquals("ACME\\Administrator", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("ACME", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());
        Assert.assertEquals("{00000000-0000-0000-0000-000000000000}", evt.getLogonGuid());
        Assert.assertEquals("rsmith@mtg.com", evt.getCredentialsAccountName());
        Assert.assertEquals("WIN-R9H529RIO4Y", evt.getCredentialsAccountDomain());
        Assert.assertEquals("{10000000-0000-0000-0000-000000000000}", evt.getCredentialsLogonGuid());
        Assert.assertEquals("sp01.IceMAIL.com", evt.getTargetServerName());
        Assert.assertEquals("sp01.IceMAIL.com", evt.getAdditionalInformation());
        Assert.assertEquals("0x1ac", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\cmd.exe", evt.getProcessName());
        Assert.assertEquals("0.0.0.0", evt.getNetworkAddress());
        Assert.assertEquals(514, evt.getPort());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Logon GUID:  {00000000-0000-0000-0000-000000000000} " +
                "Account Whose Credentials Were Used: " +
                "Account Name:  rsmith@mtg.com " +
                "Account Domain:  WIN-R9H529RIO4Y " +
                "Logon GUID:  {10000000-0000-0000-0000-000000000000} " +
                "Target Server: " +
                "Target Server Name: sp01.IceMAIL.com " +
                "Additional Information: sp01.IceMAIL.com " +
                "Process Information: " +
                "Process ID: 0x1ac " +
                "Process Name: C:\\Windows\\System32\\cmd.exe " +
                "Network Information: " +
                "Network Address: 0.0.0.0 " +
                "Port: 514 ";

        Assert.assertNotNull(parse2Map("4648", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  ACME\\Administrator " +
                "帳戶名稱:  Administrator " +
                "帳戶網域:  ACME " +
                "登入識別碼:  0x1f41e " +
                "登入 GUID:  {00000000-0000-0000-0000-000000000000} " +
                "使用其認證的帳戶: " +
                "帳戶名稱:  rsmith@mtg.com " +
                "帳戶網域:  WIN-R9H529RIO4Y " +
                "登入 GUID:  {10000000-0000-0000-0000-000000000000} " +
                "目標伺服器: " +
                "目標伺服器名稱: sp01.IceMAIL.com " +
                "其他資訊: sp01.IceMAIL.com " +
                "處理程序資訊: " +
                "處理程序識別碼: 0x1ac " +
                "處理程序名稱: C:\\Windows\\System32\\cmd.exe " +
                "網路資訊: " +
                "網路位址: 0.0.0.0 " +
                "連接埠: 514 ";

        Assert.assertNotNull(parse2Map("4648", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "ACME\\Administrator");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "ACME");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");
        Assert.assertEquals(result.get("logonGuid"), "{00000000-0000-0000-0000-000000000000}");

        Assert.assertEquals(result.get("credentialsAccountName"), "rsmith@mtg.com");
        Assert.assertEquals(result.get("credentialsAccountDomain"), "WIN-R9H529RIO4Y");
        Assert.assertEquals(result.get("credentialsLogonGuid"), "{10000000-0000-0000-0000-000000000000}");

        Assert.assertEquals(result.get("targetServerName"), "sp01.IceMAIL.com");
        Assert.assertEquals(result.get("additionalInformation"), "sp01.IceMAIL.com");

        Assert.assertEquals(result.get("processId"), "0x1ac");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\cmd.exe");

        Assert.assertEquals(result.get("networkAddress"), "0.0.0.0");
        Assert.assertEquals((Integer) result.get("port"), 514, 0);
    }
}
