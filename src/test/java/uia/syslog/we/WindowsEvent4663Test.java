package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4663;

public class WindowsEvent4663Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Object: " +
                "Object Server: Security " +
                "Object Type: File " +
                "Object Name: C:\\sharedFiles\\MasterEncryptionCode.txt " +
                "Handle ID: 0x40 " +
                "Resource Attributes: S:AI " +
                "Process Information: " +
                "Process ID: 0x1ac " +
                "Process Name: C:\\Windows\\System32\\cmd.exe " +
                "Access Request Information: " +
                "Accesses: DELETE " +
                "Access Mask: 0x10000 ";

        WindowsEvent4663 evt = parse2Object("4663", content, Locale.US);
        Assert.assertEquals("4663", evt.getEventId());
        Assert.assertEquals("ACME\\Administrator", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("ACME", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());
        Assert.assertEquals("Security", evt.getObjectServer());
        Assert.assertEquals("File", evt.getObjectType());
        Assert.assertEquals("C:\\sharedFiles\\MasterEncryptionCode.txt", evt.getObjectName());
        Assert.assertEquals("0x40", evt.getHandleId());
        Assert.assertEquals("0x1ac", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\cmd.exe", evt.getProcessName());
        Assert.assertEquals("DELETE", evt.getAccesses());
        Assert.assertEquals("0x10000", evt.getAccessMask());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Object: " +
                "Object Server: Security " +
                "Object Type: File " +
                "Object Name: C:\\sharedFiles\\MasterEncryptionCode.txt " +
                "Handle ID: 0x40 " +
                "Resource Attributes: S:AI " +
                "Process Information: " +
                "Process ID: 0x1ac " +
                "Process Name: C:\\Windows\\System32\\cmd.exe " +
                "Access Request Information: " +
                "Accesses: DELETE " +
                "Access Mask: 0x10000 ";

        Assert.assertNotNull(parse2Map("4663", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  ACME\\Administrator " +
                "帳戶名稱:  Administrator " +
                "帳戶網域:  ACME " +
                "登入識別碼:  0x1f41e " +
                "物件: " +
                "物件伺服器: Security " +
                "物件類型: File " +
                "物件名稱: C:\\sharedFiles\\MasterEncryptionCode.txt " +
                "控制代碼識別碼: 0x40 " +
                "資源屬性: S:AI " +
                "處理程序資訊: " +
                "處理程序識別碼: 0x1ac " +
                "處理程序名稱: C:\\Windows\\System32\\cmd.exe " +
                "存取要求資訊: " +
                "存取: DELETE " +
                "存取遮罩: 0x10000 ";

        Assert.assertNotNull(parse2Map("4663", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "ACME\\Administrator");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "ACME");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");
        Assert.assertEquals(result.get("objectServer"), "Security");
        Assert.assertEquals(result.get("objectType"), "File");
        Assert.assertEquals(result.get("objectName"), "C:\\sharedFiles\\MasterEncryptionCode.txt");
        Assert.assertEquals(result.get("handleId"), "0x40");
        Assert.assertEquals(result.get("processId"), "0x1ac");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\cmd.exe");
        Assert.assertEquals(result.get("accesses"), "DELETE");
        Assert.assertEquals(result.get("accessMask"), "0x10000");
    }
}
