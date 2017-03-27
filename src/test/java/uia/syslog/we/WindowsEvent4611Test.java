package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4611Test extends WindowsEventTest {

    @Test
    public void testUS() throws Exception {
		String content = "Subject: " +
				"Security ID:  SYSTEM " +
				"Account Name:  ONE " +
				"Account Domain:  WORKGROUP " +
				"Logon ID:  0x1f41e " +
				"Logon Process Name:  MAIN";

        test("4611", content, Locale.US);
    }

    @Test
    public void testTW() throws Exception {
		String content = "主旨: " + 
				"安全性識別碼:  SYSTEM " +
				"帳戶名稱:  ONE " +
				"帳戶網域:  WORKGROUP " +
				"登入識別碼:  0x1f41e " +
				"登入處理程序名稱:  MAIN ";

        test("4611", content, Locale.TAIWAN);
    }

    @Override
    protected void validate(Map<String, Object> result) {
		Assert.assertEquals(result.get("securityId"), "SYSTEM");
		Assert.assertEquals(result.get("accountName"), "ONE");
		Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
		Assert.assertEquals(result.get("logonId"), "0x1f41e");
		Assert.assertEquals(result.get("logonProcessName"), "MAIN");
    }
}
