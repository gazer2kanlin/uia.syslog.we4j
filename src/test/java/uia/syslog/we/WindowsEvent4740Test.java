package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4740Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Process: " +
                "Process ID: 0x1140 " +
                "Process Name: C:\\Windows\\System32\\VSSVC.exe " +
                "Event Source: " +
                "Source Name: VSSAudit " +
                "Event Source ID: 0x9c8e0af1";
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Account That Was Locked Out: " +
                "Security ID: S-1-5-21-669216072-2446163755 " +
                "Account Name: Administrator " +
                "Additional Information: " +
                "Caller Computer Name: 103PRSDB1";

        Assert.assertNotNull(parse2Map("4740", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼: S-1-5-18 " +
                "帳戶名稱: 103PRSDB " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "鎖定的帳戶: " +
                "安全性識別碼: S-1-5-21-669216072-2446163755 " +
                "帳戶名稱: Administrator " +
                "其他資訊: " +
                "呼叫者電腦名稱: 103PRSDB1";

        Assert.assertNotNull(parse2Map("4740", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-18");
        Assert.assertEquals(result.get("accountName"), "103PRSDB");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");

        Assert.assertEquals(result.get("lockSecurityId"), "S-1-5-21-669216072-2446163755");
        Assert.assertEquals(result.get("lockAccountName"), "Administrator");

        Assert.assertEquals(result.get("callerComputerName"), "103PRSDB1");
    }
}
