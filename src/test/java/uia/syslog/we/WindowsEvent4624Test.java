package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4624Test extends WindowsEventTest {
	
	
	@Test
	public void testWin10Win2016() throws Exception{
		String content = "Subject: " + 
				"Security ID: S-1-0-0 " + 
				"Account Name: SYS " + 
				"Account Domain: - " + 
				"Logon ID: 0x0 " + 
				"Logon Information: " +
				"Logon Type: 3 " +
				"Restricted Admin Mode: - " +
				"Virtual Account: No " +
				"Elevated Token: No " +
				"Impersonation Level: Impersonation " +
				"New Logon: " + 
				"Security ID: S-1-5-21-2012605678-992955725-2285239756-500 " + 
				"Account Name: Administrator " + 
				"Account Domain: VM-EDU-DB " + 
				"Logon ID: 0x312a4db8 " + 
				"Linked Logon ID: 0xFD5112A " +
			   	"Network Account Name: VPN1 " +
			   	"Network Account Domain: WG " +
			   	"Logon GUID: {00000000-0000-0000-0000-000000000000} " + 
				"Process Information: " + 
				"Process ID: 0x0 " + 
				"Process Name: - " + 
				"Network Information: " + 
				"Workstation Name: OPMANAGER-AP1 " + 
				"Source Network Address: 140.111.12.161 " + 
				"Source Port: 61320 " + 
				"Detailed Authentication Information: " + 
				"Logon Process: NtLmSsp " + 
				"Authentication Package: NTLM " + 
				"Transited Services: - " + 
				"Package Name (NTLM only): NTLM V2 " + 
				"Key Length: 128 Something special";
		
		test("4624", content, Locale.US);
	}

	@Test
	public void testUS() throws Exception{
		String content = "Subject: " + 
				"Security ID: S-1-0-0 " + 
				"Account Name: SYS " + 
				"Account Domain: - " + 
				"Logon ID: 0x0 " + 
				"Logon Type:       3 " + 
				"New Logon: " + 
				"Security ID: S-1-5-21-2012605678-992955725-2285239756-500 " + 
				"Account Name: Administrator " + 
				"Account Domain: VM-EDU-DB " + 
				"Logon ID: 0x312a4db8 " + 
				"Linked Logon ID: 0xFD5112A " +
			   	"Network Account Name: VPN1 " +
			   	"Network Account Domain: WG " +
				"Logon GUID: {00000000-0000-0000-0000-000000000000} " + 
				"Process Information: " + 
				"Process ID: 0x0 " + 
				"Process Name: - " + 
				"Network Information: " + 
				"Workstation Name: OPMANAGER-AP1 " + 
				"Source Network Address: 140.111.12.161 " + 
				"Source Port: 61320 " + 
				"Detailed Authentication Information: " + 
				"Logon Process: NtLmSsp " + 
				"Authentication Package: NTLM " + 
				"Transited Services: - " + 
				"Package Name (NTLM only): NTLM V2 " + 
				"Key Length: 128 Something special";
		
		test("4624", content, Locale.US);
	}

	@Test
	public void testTW() throws Exception{
		String content = "主旨: " + 
				"安全性識別碼: S-1-0-0 " + 
				"帳戶名稱: SYS " + 
				"帳戶網域: - " + 
				"登入識別碼: 0x0 " + 
				"登入類型: 3 " + 
				"新登入: " + 
				"安全性識別碼: S-1-5-21-2012605678-992955725-2285239756-500 " + 
				"帳戶名稱: Administrator " + 
				"帳戶網域: VM-EDU-DB " + 
				"登入識別碼: 0x312a4db8 " + 
				"Linked Logon ID: 0xFD5112A " +
			   	"網路帳戶名稱: VPN1 " +
			   	"網路帳戶網域: WG " +
				"登入 GUID: {00000000-0000-0000-0000-000000000000} " + 
				"處理程序資訊: " + 
				"處理程序識別碼: 0x0 " + 
				"處理程序名稱: - " + 
				"網路資訊: " + 
				"工作站名稱: OPMANAGER-AP1 " + 
				"來源網路位址: 140.111.12.161 " + 
				"來源連接埠: 61320 " + 
				"詳細驗證資訊: " + 
				"登入處理程序: NtLmSsp " + 
				"驗證封裝: NTLM " + 
				"轉送的服務: - " + 
				"封裝名稱 (僅限 NTLM): NTLM V2 " + 
				"金鑰長度: 128 當建立登入工作階段的時候，就會產生這個事件。它在被存取的電腦上產生。 主旨欄位顯示要求登入的本機系統上的帳戶。這通常是發生在服務 (例如伺服器服務) 或是本機處理程序 (例如 Winlogon.exe 或 Services.exe)。 登錄類型欄位顯示?*<";
		
		test("4624", content, Locale.TAIWAN);
	}
	
	@Override
	protected void validate(Map<String, Object> result) {
		Assert.assertEquals(result.get("securityId"), "S-1-0-0");
		Assert.assertEquals(result.get("accountName"), "SYS");
		Assert.assertEquals(result.get("accountDomain"), "-");
		Assert.assertEquals(result.get("logonId"), "0x0");
		Assert.assertEquals(result.get("logonType"), "3");
		Assert.assertEquals(result.get("newSecurityId"), "S-1-5-21-2012605678-992955725-2285239756-500");
		Assert.assertEquals(result.get("newAccountName"), "Administrator");
		Assert.assertEquals(result.get("newAccountDomain"), "VM-EDU-DB");
		Assert.assertEquals(result.get("newLogonId"), "0x312a4db8");
		Assert.assertEquals(result.get("linkedLogonId"), "0xFD5112A");
		Assert.assertEquals(result.get("networkAccountName"), "VPN1");
		Assert.assertEquals(result.get("networkAccountDomain"), "WG");
		Assert.assertEquals(result.get("newLogonGUID"), "{00000000-0000-0000-0000-000000000000}");
		Assert.assertEquals(result.get("processId"), "0x0");
		Assert.assertEquals(result.get("processName"), "-");
		Assert.assertEquals(result.get("workstationName"), "OPMANAGER-AP1");
		Assert.assertEquals(result.get("sourceNetworkAddress"), "140.111.12.161");
		Assert.assertEquals((Integer)result.get("sourcePort"), 61320, 0);
		Assert.assertEquals(result.get("logonProcess"), "NtLmSsp");
		Assert.assertEquals(result.get("authenticationPackage"), "NTLM");
		Assert.assertEquals(result.get("transitedServices"), "-");
		Assert.assertEquals(result.get("packageNameNTLMOnly"), "NTLM V2");
		Assert.assertEquals((Integer)result.get("keyLength"), 128, 0);
	}
}
