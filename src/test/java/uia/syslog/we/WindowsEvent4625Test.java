package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4625;

public class WindowsEvent4625Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Logon Type: 3 " +
                "Account For Which Logon Failed: " +
                "Security ID:  NULL SID " +
                "Account Name:  asdf " +
                "Account Domain: " +
                "Failure Information: " +
                "Failure Reason:  Unknown user name or bad password. " +
                "Status:   0xc000006d " +
                "Sub Status:  0xc0000064 " +
                "Process Information: " +
                "Caller Process ID: 0x1ac " +
                "Caller Process Name: C:\\Windows\\System32\\cmd.exe " +
                "Network Information: " +
                "Workstation Name: WIN-R9H529RIO4Y" +
                "Source Network Address: 10.42.42.201" +
                "Source Port:  53176" +
                "Detailed Authentication Information: " +
                "Logon Process:  NtLmSsp" +
                "Authentication Package: NTLM" +
                "Transited Services: No " +
                "Package Name (NTLM only): - " +    // ignore = true
                "Key Length: 5";                    // ignore = true

        WindowsEvent4625 evt = parse2Object("4625", content, Locale.US);
        Assert.assertEquals("4625", evt.getEventId());

        Assert.assertEquals("ACME\\Administrator", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("ACME", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());

        Assert.assertEquals("3", evt.getLogonType());

        Assert.assertEquals("NULL SID", evt.getFailedSecurityId());
        Assert.assertEquals("asdf", evt.getFailedAccountName());
        Assert.assertEquals("", evt.getFailedAccountDomain());

        Assert.assertEquals("Unknown user name or bad password.", evt.getFailureReason());
        Assert.assertEquals("0xc000006d", evt.getFailureStatus());
        Assert.assertEquals("0xc0000064", evt.getFailureSubStatus());

        Assert.assertEquals("0x1ac", evt.getCallerProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\cmd.exe", evt.getCallerProcessName());

        Assert.assertEquals("WIN-R9H529RIO4Y", evt.getWorkstationName());
        Assert.assertEquals("10.42.42.201", evt.getSourceNetworkAddress());
        Assert.assertEquals(53176, evt.getSourcePort());

        Assert.assertEquals("NtLmSsp", evt.getLogonProcess());
        Assert.assertEquals("NTLM", evt.getAuthenticationPackage());
        Assert.assertEquals("No", evt.getTransitedServices());
        Assert.assertEquals("-", evt.getPackageNameNTLMOnly());
        Assert.assertEquals(5, evt.getKeyLength());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Logon Type: 3 " +
                "Account For Which Logon Failed: " +
                "Security ID:  NULL SID " +
                "Account Name:  asdf " +
                "Account Domain: " +
                "Failure Information: " +
                "Failure Reason:  Unknown user name or bad password. " +
                "Status:   0xc000006d " +
                "Sub Status:  0xc0000064 " +
                "Process Information: " +
                "Caller Process ID: 0x1ac " +
                "Caller Process Name: C:\\Windows\\System32\\cmd.exe " +
                "Network Information: " +
                "Workstation Name: WIN-R9H529RIO4Y" +
                "Source Network Address: 10.42.42.201" +
                "Source Port:  53176" +
                "Detailed Authentication Information: " +
                "Logon Process:  NtLmSsp" +
                "Authentication Package: NTLM" +
                "Transited Services: No" +
                "Package Name (NTLM only): - " +
                "Key Length: 5";

        Assert.assertNotNull(parse2Map("4625", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  ACME\\Administrator " +
                "帳戶名稱:  Administrator " +
                "帳戶網域:  ACME " +
                "登入識別碼:  0x1f41e " +
                "登入類型: 3 " +
                "登入失敗的帳戶: " +
                "安全性識別碼:  NULL SID " +
                "帳戶名稱:  asdf " +
                "帳戶網域: " +
                "失敗資訊: " +
                "失敗原因:  Unknown user name or bad password. " +
                "狀態:   0xc000006d " +
                "子狀態:  0xc0000064 " +
                "處理程序資訊: " +
                "呼叫者處理程序識別碼: 0x1ac " +
                "呼叫者處理程序名稱: C:\\Windows\\System32\\cmd.exe " +
                "網路資訊: " +
                "工作站名稱: WIN-R9H529RIO4Y" +
                "來源網路位址: 10.42.42.201" +
                "來源連接埠:  53176" +
                "詳細驗證資訊: " +
                "登入處理程序: NtLmSsp" +
                "驗證封裝: NTLM" +
                "轉送的服務: No" +
                "封裝名稱 (僅限 NTLM): - " +
                "金鑰長度: 5";

        Assert.assertNotNull(parse2Map("4625", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "ACME\\Administrator");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "ACME");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");

        Assert.assertEquals(result.get("failedSecurityId"), "NULL SID");
        Assert.assertEquals(result.get("failedAccountName"), "asdf");
        Assert.assertEquals(result.get("failedAccountDomain"), "");

        Assert.assertEquals(result.get("callerProcessId"), "0x1ac");
        Assert.assertEquals(result.get("callerProcessName"), "C:\\Windows\\System32\\cmd.exe");

        Assert.assertEquals(result.get("failureReason"), "Unknown user name or bad password.");
        Assert.assertEquals(result.get("failureStatus"), "0xc000006d");
        Assert.assertEquals(result.get("failureSubStatus"), "0xc0000064");

        Assert.assertEquals(result.get("workstationName"), "WIN-R9H529RIO4Y");
        Assert.assertEquals(result.get("sourceNetworkAddress"), "10.42.42.201");
        Assert.assertEquals((Integer) result.get("sourcePort"), 53176, 0);

        Assert.assertEquals(result.get("logonProcess"), "NtLmSsp");
        Assert.assertEquals(result.get("authenticationPackage"), "NTLM");
        Assert.assertEquals(result.get("transitedServices"), "No");
        Assert.assertEquals(result.get("packageNameNTLMOnly"), "-");
        Assert.assertEquals(result.get("keyLength"), 5);
    }
}
