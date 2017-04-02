package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4690Test extends WindowsEventTest {

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Source Handle Information: " +
                "Source Handle ID: 0x401d" +
                "Source Process ID: 0x41ff " +
                "New Handle Information: " +
                "Target Handle ID: 0x301d" +
                "Target Process ID: 0x31ff ";

        Assert.assertNotNull(parse2Map("4690", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  ACME\\Administrator " +
                "帳戶名稱:  Administrator " +
                "帳戶網域:  ACME " +
                "登入識別碼:  0x1f41e " +
                "來源控制代碼資訊: " +
                "來源控制代碼識別碼: 0x401d" +
                "來源處理程序識別碼: 0x41ff " +
                "新控制代碼資訊: " +
                "目標控制代碼識別碼: 0x301d" +
                "目標處理程序識別碼: 0x31ff ";

        Assert.assertNotNull(parse2Map("4690", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "ACME\\Administrator");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "ACME");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");
        Assert.assertEquals(result.get("sourceHandleId"), "0x401d");
        Assert.assertEquals(result.get("sourceProcessId"), "0x41ff");
        Assert.assertEquals(result.get("targetHandleId"), "0x301d");
        Assert.assertEquals(result.get("targetProcessId"), "0x31ff");
    }
}
