package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4634Test extends WindowsEventTest {
	
	@Test
	public void testUS() throws Exception{
		String content = "Subject: " + 
				"Security ID:  ANONYMOUS LOGON " + 
				"Account Name:  ANONYMOUS LOGON " + 
				"Account Domain:  NT AUTHORITY " + 
				"Logon ID:  0x149be " + 
				"Logon Type: 3 This means something is special";
		
		test("4634", content, Locale.US);
	}

	@Test
	public void testTW() throws Exception{
		String content = "主旨: " + 
				"安全性識別碼: ANONYMOUS LOGON " +
				"帳戶名稱:  ANONYMOUS LOGON " +
				"帳戶網域:  NT AUTHORITY " +
				"登入識別碼:  0x149be " +
				"登入類型: 3 登入工作階段損毀時，就會產生這個事件。";
		
		test("4634", content, Locale.TAIWAN);
	}
	
	@Override
	protected void validate(Map<String, Object> result) {
		Assert.assertEquals(result.get("securityId"), "ANONYMOUS LOGON");
		Assert.assertEquals(result.get("accountName"), "ANONYMOUS LOGON");
		Assert.assertEquals(result.get("accountDomain"), "NT AUTHORITY");
		Assert.assertEquals(result.get("logonId"), "0x149be");
		Assert.assertEquals(result.get("logonType"), "3");
	}
}
