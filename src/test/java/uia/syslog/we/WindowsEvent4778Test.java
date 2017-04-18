package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4778Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Session: " +
                "Session Name: RDP-Tcp#0 " +
                "Additional Information: " +
                "Client Name: J00A2054 " +
                "Client Address: 211.75.72.225 " +
                "當使用者重新連線到現有的終端機服務工作階段，或使用者使用「快速切換使用者」切換到現有桌面，就會產生這個事件。";
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Session: " +
                "Session Name: RDP-Tcp#0 " +
                "Additional Information: " +
                "Client Name: J00A2054 " +
                "Client Address: 211.75.72.225 " +
                "當使用者重新連線到現有的終端機服務工作階段，或使用者使用「快速切換使用者」切換到現有桌面，就會產生這個事件。";

        Assert.assertNotNull(parse2Map("4778", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "帳戶名稱: 103PRSDB " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "工作階段: " +
                "工作階段名稱: RDP-Tcp#0 " +
                "其他資訊: " +
                "用戶端名稱: J00A2054 " +
                "用戶端位址: 211.75.72.225 " +
                "當使用者重新連線到現有的終端機服務工作階段，或使用者使用「快速切換使用者」切換到現有桌面，就會產生這個事件。";

        Assert.assertNotNull(parse2Map("4778", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("accountName"), "103PRSDB");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");
        Assert.assertEquals(result.get("sessionName"), "RDP-Tcp#0");
        Assert.assertEquals(result.get("clientName"), "J00A2054");
        Assert.assertEquals(result.get("clientAddress"), "211.75.72.225");
    }
}
