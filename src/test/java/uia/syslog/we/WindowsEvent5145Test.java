package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent5145;

public class WindowsEvent5145Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "AUDIT_SUCCESS 已檢查網路共用物件，查看是否可授與用戶端想要的存取權。 " +
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
                "Relative Target Name: Users\\Administrator\\Desktop " +
                "Access Request Information: " +
                "Access Mask: 0x100080 " +
                "Accesses: SYNCHRONIZE ReadAttributes " +
                "Access Check Results: -";

        WindowsEvent5145 evt = parse2Object("5145", content, Locale.US);
        Assert.assertEquals("5145", evt.getEventId());

        Assert.assertEquals("S-1-5-21-3515248096-3037635168-1615503687-500", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("VM-EDU-WEB1", evt.getAccountDomain());
        Assert.assertEquals("0x151160206", evt.getLogonId());

        Assert.assertEquals("File", evt.getObjectType());
        Assert.assertEquals("::1", evt.getSourceAddress());
        Assert.assertEquals(54960, evt.getSourcePort());

        Assert.assertEquals("\\*\\C$", evt.getShareName());
        Assert.assertEquals("\\??\\C:\\", evt.getSharePath());
        Assert.assertEquals("Users\\Administrator\\Desktop", evt.getRelativeTargetName());

        Assert.assertEquals("0x100080", evt.getAccessMask());
        Assert.assertEquals("SYNCHRONIZE ReadAttributes", evt.getAccesses());
        Assert.assertEquals("-", evt.getAccessCheckResults());
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS 已檢查網路共用物件，查看是否可授與用戶端想要的存取權。 " +
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
                "Relative Target Name: Users\\Administrator\\Desktop " +
                "Access Request Information: " +
                "Access Mask: 0x100080 " +
                "Accesses: SYNCHRONIZE ReadAttributes " +
                "Access Check Results: -";

        Assert.assertNotNull(parse2Map("5145", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS 已檢查網路共用物件，查看是否可授與用戶端想要的存取權。 " +
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
                "共用名稱: \\*\\C$ " +
                "共用路徑: \\??\\C:\\ " +
                "相對目標名稱: Users\\Administrator\\Desktop " +
                "存取要求資訊: " +
                "存取遮罩: 0x100080 " +
                "存取: SYNCHRONIZE ReadAttributes " +
                "存取檢查結果: -";

        Assert.assertNotNull(parse2Map("5145", content, Locale.TAIWAN));
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
        Assert.assertEquals(result.get("relativeTargetName"), "Users\\Administrator\\Desktop");
        Assert.assertEquals(result.get("accessMask"), "0x100080");
        Assert.assertEquals(result.get("accesses"), "SYNCHRONIZE ReadAttributes");
        Assert.assertEquals(result.get("accessCheckResults"), "-");
    }
}
