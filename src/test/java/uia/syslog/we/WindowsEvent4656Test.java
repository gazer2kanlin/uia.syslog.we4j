package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4656Test extends WindowsEventTest {

    @Test
    public void testUS1() throws Exception {
        String content = "Subject: " +
                "Security ID:  WIN-R9H529RIO4Y\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  WIN-R9H529RIO4Y " +
                "Logon ID:  0x1fd23 " +
                "Object: " +
                "Object Server:  Security " +
                "Object Type:  File " +
                "Object Name:  C:\\Users\\Administrator\\testfolder\\New Text Document.txt " +
                "Handle ID:  0xb8 " +
                "Resource Attributes: S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\")) " +
                "Process Information: " +	// maybe missing
                "Process ID: 0xed0 " +
                "Process Name: C:\\Windows\\System32\\notepad.exe " +
                "Access Request Information: " +
                "Transaction ID:  {00000000-0000-0000-0000-000000000000} " +
                "Accesses:  READ_CONTROL " +
                "SYNCHRONIZE " +
                "ReadData (or ListDirectory) " +
                "ReadEA " +
                "ReadAttributes   " +
                "Access Mask:  0x120089 " +
                "Privileges Used for Access Check: - " +
                "Restricted SID Count: 0 ";

        Assert.assertEquals(16, parse2Map("4656", content, Locale.US).size());
    }

    @Test
    public void testUS2() throws Exception {
        String content = "Subject: " +
                "Security ID:  WIN-R9H529RIO4Y\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  WIN-R9H529RIO4Y " +
                "Logon ID:  0x1fd23 " +
                "Object: " +
                "Object Server:  Security " +
                "Object Type:  File " +
                "Object Name: C:\\Users\\Administrator\\testfolder\\New Text Document.txt " +
                "Handle ID: 0xb8 " +
                "Resource Attributes: S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\")) " +
                "Process ID: 0xed0 " +
                "Process Name: C:\\Windows\\System32\\notepad.exe " +
                "Access Request Information: " +
                "Transaction ID:  {00000000-0000-0000-0000-000000000000} " +
                "Accesses:  READ_CONTROL " +
                "SYNCHRONIZE " +
                "ReadData (or ListDirectory) " +
                "ReadEA " +
                "ReadAttributes   " +
                "Access Mask:  0x120089 " +
                "Privileges Used for Access Check: - " +
                "Restricted SID Count: 0 ";

        Assert.assertEquals(16, parse2Map("4656", content, Locale.US).size());
    }

    @Test
    public void testTW1() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  WIN-R9H529RIO4Y\\Administrator " +
                "帳戶名稱:  Administrator " +
                "帳戶網域:  WIN-R9H529RIO4Y " +
                "登入識別碼:  0x1fd23 " +
                "物件: " +
                "物件伺服器:  Security " +
                "物件類型:  File " +
                "物件名稱:  C:\\Users\\Administrator\\testfolder\\New Text Document.txt " +
                "控制代碼識別碼:  0xb8 " +
                "資源屬性: S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\"))" +
                "處理程序資訊: " +
                "處理程序識別碼:  0xed0 " +
                "處理程序名稱:  C:\\Windows\\System32\\notepad.exe " +
                "存取要求資訊: " +
                "交易識別碼:  {00000000-0000-0000-0000-000000000000} " +
                "存取:  READ_CONTROL " +
                "SYNCHRONIZE " +
                "ReadData (or ListDirectory) " +
                "ReadEA " +
                "ReadAttributes   " +
                "存取遮罩:  0x120089 " +
                "存取檢查所使用的權限: - " +
                "限制的 SID 數目: 0 ";

        Assert.assertEquals(16, parse2Map("4656", content, Locale.TAIWAN).size());
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "WIN-R9H529RIO4Y\\Administrator");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "WIN-R9H529RIO4Y");
        Assert.assertEquals(result.get("logonId"), "0x1fd23");

        Assert.assertEquals(result.get("objectServer"), "Security");
        Assert.assertEquals(result.get("objectType"), "File");
        Assert.assertEquals(result.get("objectName"), "C:\\Users\\Administrator\\testfolder\\New Text Document.txt");
        Assert.assertEquals(result.get("handleId"), "0xb8");
        Assert.assertEquals(result.get("resourceAttributes"), "S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\"))");

        Assert.assertEquals(result.get("processId"), "0xed0");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\notepad.exe");

        Assert.assertEquals(result.get("transactionId"), "{00000000-0000-0000-0000-000000000000}");
        Assert.assertEquals(result.get("accesses"), "READ_CONTROL SYNCHRONIZE ReadData (or ListDirectory) ReadEA ReadAttributes");
        Assert.assertEquals(result.get("accessMask"), "0x120089");
        Assert.assertEquals(result.get("privilegesUsedForAccessCheck"), "-");
        Assert.assertEquals((Integer) result.get("restrictedSIDCount"), 0, 0);
    }
}
