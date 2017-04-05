package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4779;

public class WindowsEvent4779Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Account Name:  ONE " +
                "Account Domain:  WORKGROUP " +
                "Logon ID:  0x1f41e " +
                "Session: " +
                "Session Name: -" +
                "Additional Information: " +
                "Client Name:  HOME" +
                "Client Address:  192.168.5.2";

        WindowsEvent4779 evt = parse2Object("4779", content, Locale.US);
        Assert.assertEquals("4779", evt.getEventId());
        Assert.assertEquals("ONE", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());
        Assert.assertEquals("-", evt.getSessionName());
        Assert.assertEquals("HOME", evt.getClientName());
        Assert.assertEquals("192.168.5.2", evt.getClientAddress());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Account Name:  ONE " +
                "Account Domain:  WORKGROUP " +
                "Logon ID:  0x1f41e " +
                "Session: " +
                "Session Name: -" +
                "Additional Information: " +
                "Client Name:  HOME" +
                "Client Address:  192.168.5.2";

        Assert.assertNotNull(parse2Map("4779", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "帳戶名稱:  ONE " +
                "帳戶網域:  WORKGROUP " +
                "登入識別碼:  0x1f41e " +
                "Session: " +
                "Session Name: -" +
                "其他資訊: " +
                "Client Name:  HOME" +
                "Client Address:  192.168.5.2";

        Assert.assertNotNull(parse2Map("4779", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("accountName"), "ONE");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");
        Assert.assertEquals(result.get("sessionName"), "-");
        Assert.assertEquals(result.get("clientName"), "HOME");
        Assert.assertEquals(result.get("clientAddress"), "192.168.5.2");
    }
}
