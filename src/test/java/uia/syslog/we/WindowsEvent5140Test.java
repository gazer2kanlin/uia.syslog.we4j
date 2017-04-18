package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent5140Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS 已存取網路共用物件。 " +
                "Subject: " +
                "Security ID: S-1-5-21-3515248096-3037635168-1615503687-500 " +
                "Account Name: Administrator " +
                "Account Domain: VM-EDU-WEB1 " +
                "Logon ID: 0x151160206 " +
                "Network Information: " +
                "Object Type: File " +
                "Source Address: ::1 " +
                "Source Port: 54960 " +
                "Share Information: " +
                "Share Name: \\*\\C$ " +
                "Share Path: \\??\\C:\\ " +
                "Access Request Information: " +
                "Access Mask: 0x1 " +
                "Accesses: ReadData (或 ListDirectory) ";

        Assert.assertNotNull(parse2Map("5140", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS 已存取網路共用物件。 " +
                "主體: " +
                "安全性識別碼: S-1-5-21-3515248096-3037635168-1615503687-500 " +
                "帳戶名稱: Administrator " +
                "帳戶網域: VM-EDU-WEB1 " +
                "登入識別碼: 0x151160206 " +
                "網路資訊: " +
                "物件類型: File " +
                "來源位址: ::1 " +
                "來源連接埠: 54960 " +
                "共用資訊: " +
                "共用名稱: \\*\\C$  " +
                "共用路徑: \\??\\C:\\ " +
                "存取要求資訊: " +
                "存取遮罩: 0x1 " +
                "存取: ReadData (或 ListDirectory)";

        Assert.assertNotNull(parse2Map("5140", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-21-3515248096-3037635168-1615503687-500");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "VM-EDU-WEB1");
        Assert.assertEquals(result.get("logonId"), "0x151160206");
        Assert.assertEquals(result.get("objectType"), "File");
        Assert.assertEquals(result.get("sourceAddress"), "::1");
        Assert.assertEquals(result.get("sourcePort"), 54960);
        Assert.assertEquals(result.get("shareName"), "\\*\\C$");
        Assert.assertEquals(result.get("sharePath"), "\\??\\C:\\");
        Assert.assertEquals(result.get("accessMask"), "0x1");
        Assert.assertEquals(result.get("accesses"), "ReadData (或 ListDirectory)");
    }
}
