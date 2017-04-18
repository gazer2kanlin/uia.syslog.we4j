package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4723;

public class WindowsEvent4723Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  SYSTEM " +
                "Account Name:  ONE " +
                "Account Domain:  WORKGROUP " +
                "Logon ID:  0x1f41e " +
                "Target Account: " +
                "Security ID:  MAIN\\Jack " +
                "Account Name:  Jack " +
                "Account Domain:  MAIN";

        WindowsEvent4723 evt = parse2Object("4723", content, Locale.US);
        Assert.assertEquals("4723", evt.getEventId());
        Assert.assertEquals("SYSTEM", evt.getSecurityId());
        Assert.assertEquals("ONE", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());
        Assert.assertEquals("MAIN\\Jack", evt.getTargetSecurityId());
        Assert.assertEquals("Jack", evt.getTargetAccountName());
        Assert.assertEquals("MAIN", evt.getTargetAccountDomain());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  SYSTEM " +
                "Account Name:  ONE " +
                "Account Domain:  WORKGROUP " +
                "Logon ID:  0x1f41e " +
                "Target Account: " +
                "Security ID:  MAIN\\Jack " +
                "Account Name:  Jack " +
                "Account Domain:  MAIN";

        Assert.assertNotNull(parse2Map("4723", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  SYSTEM " +
                "帳戶名稱:  ONE " +
                "帳戶網域:  WORKGROUP " +
                "登入識別碼:  0x1f41e " +
                "目標帳戶: " +
                "安全性識別碼:  MAIN\\Jack " +
                "帳戶名稱:  Jack " +
                "帳戶網域:  MAIN ";

        Assert.assertNotNull(parse2Map("4723", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "SYSTEM");
        Assert.assertEquals(result.get("accountName"), "ONE");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");
        Assert.assertEquals(result.get("targetSecurityId"), "MAIN\\Jack");
        Assert.assertEquals(result.get("targetAccountName"), "Jack");
        Assert.assertEquals(result.get("targetAccountDomain"), "MAIN");
    }
}
