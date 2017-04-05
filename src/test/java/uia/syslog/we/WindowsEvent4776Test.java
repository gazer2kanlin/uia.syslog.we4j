package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4776;

public class WindowsEvent4776Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Authentication Package: MICROSOFT_AUTHENTICATION_PACKAGE_V1_0 " +
                "Logon Account: administrator" +
                "Source Workstation: WIN-R9H529RIO4Y" +
                "Error Code: 0xc0000064";

        WindowsEvent4776 evt = parse2Object("4776", content, Locale.US);
        Assert.assertEquals("4776", evt.getEventId());
        Assert.assertEquals("MICROSOFT_AUTHENTICATION_PACKAGE_V1_0", evt.getAuthenticationPackage());
        Assert.assertEquals("administrator", evt.getLogonAccount());
        Assert.assertEquals("WIN-R9H529RIO4Y", evt.getSourceWorkstation());
        Assert.assertEquals("0xc0000064", evt.getErrorCode());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Authentication Package: MICROSOFT_AUTHENTICATION_PACKAGE_V1_0 " +
                "Logon Account: administrator" +
                "Source Workstation: WIN-R9H529RIO4Y" +
                "Error Code: 0xc0000064";

        Assert.assertNotNull(parse2Map("4776", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "驗證封裝: MICROSOFT_AUTHENTICATION_PACKAGE_V1_0 " +
                "登入帳戶: administrator" +
                "來源工作站: WIN-R9H529RIO4Y" +
                "錯誤碼: 0xc0000064";

        Assert.assertNotNull(parse2Map("4776", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("authenticationPackage"), "MICROSOFT_AUTHENTICATION_PACKAGE_V1_0");
        Assert.assertEquals(result.get("logonAccount"), "administrator");
        Assert.assertEquals(result.get("sourceWorkstation"), "WIN-R9H529RIO4Y");
        Assert.assertEquals(result.get("errorCode"), "0xc0000064");
    }
}
