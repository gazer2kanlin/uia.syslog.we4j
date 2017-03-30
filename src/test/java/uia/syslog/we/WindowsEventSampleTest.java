package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEventSampleTest extends WindowsEventTest {
	
	@Test
	public void test001() throws Exception{
		String content = "File: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx " +
				"File: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx ";

		try {
			test("-001", content, Locale.US);
			Assert.assertTrue(false);
		}
		catch(WindowsEventException ex) {
			Assert.assertEquals("-001> 'file2' can't be translated.", ex.getMessage());
		}
	}
	
	@Test
	public void test002() throws Exception{
		String content = "Subject: " + 
				"File: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx " + 
				"Subject: " + 
				"File: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx ";

		try {
			test("-002", content, Locale.US);
			Assert.assertTrue(false);
		}
		catch(WindowsEventException ex) {
			Assert.assertEquals("-002> 'subject2' can't be translated.", ex.getMessage());
		}
	}
	
	@Test
	public void test003() throws Exception{
		String content = "Subject: " + 
				"Logon Information: " + 
				"Logon Type: 3 ";

		try {
			Map<String, Object> result = test("-003", content, Locale.US);
			Assert.assertEquals("3", result.get("logonType"));
		}
		catch(WindowsEventException ex) {
		}
	}
	
	@Test
	public void test() throws Exception {
		String[] data = new String[] {
			"1105: 事件記錄檔自動備份 記錄檔: Security 檔案: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2017-02-16-16-44-39-204.evtx"
			,"4624: AUDIT_SUCCESS 帳戶成功登入。 主旨: 安全性識別碼: S-1-0-0 帳戶名稱: - 帳戶網域: - 登入識別碼: 0x0 登入類型: 3 新登入: 安全性識別碼: S-1-5-21-2012605678-992955725-2285239756-500 帳戶名稱: Administrator 帳戶網域: VM-EDU-DB 登入識別碼: 0x31298d43 登入 GUID: {00000000-0000-0000-0000-000000000000} 處理程序資訊: 處理程序識別碼: 0x0 處理程序名稱: - 網路資訊: 工作站名稱: OPMANAGER-AP1 來源網路位址: 140.111.12.161 來源連接埠: 61312 詳細驗證資訊: 登入處理程序: NtLmSsp 驗證封裝: NTLM 轉送的服務: - 封裝名稱 (僅限 NTLM): NTLM V2 金鑰長度: 128 當建立登入工作階段的時候，就會產生這個事件。它在被存取的電腦上產生。 主旨欄位顯示要求登入的本機系統上的帳戶。這通常是發生在服務 (例如伺服器服務) 或是本機處理程序 (例如 Winlogon.exe 或 Services.exe)。 登錄類型欄位顯示?*<"
			,"4625: AUDIT_FAILURE 帳戶無法登入。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: VM-EDU-DB$ 帳戶網域: WORKGROUP 登入識別碼: 0x3e7 登入類型: 4 登入失敗的帳戶: 安全性識別碼: S-1-0-0 帳戶名稱: hamastar 帳戶網域: VM-EDU-DB 失敗資訊: 失敗原因: 不明的使用者名稱或錯誤密碼。 狀態: 0xc000006d 子狀態: 0xc000006a 處理程序資訊: 呼叫者處理程序識別碼: 0x36c 呼叫者處理程序名稱: C:/Windows/System32/svchost.exe 網路資訊: 工作站名稱: VM-EDU-DB 來源網路位址: - 來源連接埠: - 詳細驗證資訊: 登入處理程序: Advapi 驗證封裝: Negotiate 轉送的服務: - 封裝名稱 (僅限 NTLM): - 金鑰長度: 0 當登入要求失敗的時候，就會產生這個事件。這個事件在嘗試存取的電腦上產生。 主旨欄位顯示要求登入的本機系統上的帳戶。這通常是發生在服務 (例如伺服器服務) 或是本機處理程序 (例如 Winlogo<"
			,"4634: AUDIT_SUCCESS 帳戶已登出。 主旨: 安全性識別碼: S-1-5-21-3515248096-3037635168-1615503687-500 帳戶名稱: Administrator 帳戶網域: VM-EDU-WEB1 登入識別碼: 0x7a41d94a 登入類型: 3 當登入工作階段損毀時，就會產生這個事件。這個事件可能與使用登入識別碼數值的登入事件正面相關。登入識別碼僅有在重新啟動相同電腦之間才會是唯一的。"
			,"4648: AUDIT_SUCCESS 使用明確宣告的認證嘗試登入。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: VM-EDU-DB$ 帳戶網域: WORKGROUP 登入識別碼: 0x3e7 登入 GUID: {00000000-0000-0000-0000-000000000000} 使用其認證的帳戶: 帳戶名稱: Administrator 帳戶網域: VM-EDU-DB 登入 GUID: {00000000-0000-0000-0000-000000000000} 目標伺服器: 目標伺服器名稱: localhost 其他資訊: localhost 處理程序資訊: 處理程序識別碼: 0x36c 處理程序名稱: C:/Windows/System32/svchost.exe 網路資訊: 網路位址: - 連接埠: - 當處理程序嘗試以帳戶的明確宣告認證登入那個帳戶時，就會產生這個事件。這通常發生在批次類型的設定，例如排程工作，或是當使用 RUNAS 命令時。"
			,"4656: AUDIT_SUCCESS 已要求物件控制代碼。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: VM-EDU-WEB2$ 帳戶網域: WORKGROUP 登入識別碼: 0x3e7 物件: 物件伺服器: PlugPlayManager 物件類型: Security 物件名稱: PlugPlaySecurityObject 控制代碼識別碼: 0x0 處理程序資訊: 處理程序識別碼: 0x2b0 處理程序名稱: C:/Windows/System32/svchost.exe 存取要求資訊: 交易識別碼: {00000000-0000-0000-0000-000000000000} 存取: 不明的指定存取 (位元1) 存取原因: - 存取遮罩: 0x2 存取檢查所使用的權限: - 限制的 SID 數目: 0"
			,"4658: AUDIT_SUCCESS 物件控制代碼已關閉。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: VM-EDU-DB$ 帳戶網域: WORKGROUP 登入識別碼: 0x3e7 物件: 物件伺服器: Security 控制代碼識別碼: 0x1d84 處理程序資訊: 處理程序識別碼: 0x760 處理程序名稱: C:/Program Files (x86)/Symantec/Symantec Endpoint Protection/12.1.4112.4156.105/Bin/ccSvcHst.exe"
			,"4663: AUDIT_SUCCESS 嘗試存取物件。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: VM-EDU-DB$ 帳戶網域: WORKGROUP 登入識別碼: 0x3e7 物件: 物件伺服器: Security 物件類型: File 物件名稱: C:/Windows/SysWOW64/AdvancedInstallers 控制代碼識別碼: 0x1d84 處理程序資訊: 處理程序識別碼: 0x760 處理程序名稱: C:/Program Files (x86)/Symantec/Symantec Endpoint Protection/12.1.4112.4156.105/Bin/ccSvcHst.exe 存取要求資訊: 存取: READ_CONTROL 存取遮罩: 0x20000"
			,"4672: AUDIT_SUCCESS 特殊權限已指派給新登入。 主旨: 安全性識別碼: S-1-5-21-2012605678-992955725-2285239756-500 帳戶名稱: Administrator 帳戶網域: VM-EDU-DB 登入識別碼: 0x31298d43 特殊權限: SeSecurityPrivilege SeBackupPrivilege SeRestorePrivilege SeTakeOwnershipPrivilege SeDebugPrivilege SeSystemEnvironmentPrivilege SeLoadDriverPrivilege SeImpersonatePrivilege"
			,"4690: AUDIT_SUCCESS 嘗試複製物件控制代碼。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: VM-EDU-DB$ 帳戶網域: WORKGROUP 登入識別碼: 0x3e7 來源控制代碼資訊: 來源控制代碼識別碼: 0x1de8 來源處理程序識別碼: 0x760 新控制代碼資訊: 目標控制代碼識別碼: 0x1ddc 目標處理程序識別碼: 0x760"
			,"4702: AUDIT_SUCCESS 已更新排定的工作。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: VM-EDU-WEB2$ 帳戶網域: WORKGROUP 登入識別碼: 0x3e7 工作資訊: 工作名稱: /Microsoft/Windows/Customer Experience Improvement Program/Server/ServerCeipAssistant 工作新內容: <?xml version=\"1.0\" encoding=\"UTF-16\"?> <Task version=\"1.3\" xmlns=\"http://schemas.microsoft.com/windows/2004/02/mit/task\"> <RegistrationInfo> <Source>客戶經驗改進計畫</Source> <Author>Microsoft Corporation</Author> <Version>1.0</Version> <Description>這個工作是屬於 Windows Server 客戶經驗改進計畫。請不要手動刪除這個工作。如需詳細資訊，請參閱 http://go.microsoft.com/fwlink/?linkid=52095。</Description> <URI>/Microsoft/Windows/Customer Experience Improvement Program/Server/ServerCeipAssistant</URI> <SecurityDescriptor>D:(A;;FA;;;BA)(A;;FA;;;SY)</SecurityDescriptor> </RegistrationInfo> <Triggers> <TimeTrigger> <Repetition> <Interva<"
			,"4776: AUDIT_SUCCESS 電腦嘗試驗證帳戶的認證。 驗證封裝: MICROSOFT_AUTHENTICATION_PACKAGE_V1_0 登入帳戶: administrator 來源工作站: OPMANAGER-AP1 錯誤碼: 0x0"
			,"4985: AUDIT_SUCCESS 交易的狀態已經變更。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: VM-EDU-WEB2$ 帳戶網域: WORKGROUP 登入識別碼: 0x3e7 交易資訊: RM 交易識別碼: {DC02E755-EDBD-11E6-BE87-00505692592C} 新狀態: 48 資源管理員: {B4F295D7-25A6-11DF-8F4C-E9933530C3BE} 處理程序資訊: 處理程序識別碼: 0x388 處理程序名稱: C:\\Windows\\System32\\svchost.exe"
			,"5154: AUDIT_SUCCESS Windows 篩選平台已經允許應用程式或服務接聽連接埠是否有連入連線。 應用程式資訊: 處理程序識別碼: 1432 應用程式名稱: /device/harddiskvolume2/program files/arcsightsmartconnectors/current/jre/bin/java.exe 網路資訊: 來源位址: 7f00:1::d8b0:2807:80fa:ffff 來源連接埠: 60045 通訊協定: 6 篩選器資訊: 篩選器執行階段識別碼: 0 階層名稱: 接聽 階層執行階段識別碼: 42"
			,"5156: AUDIT_SUCCESS Windows 篩選平台已經允許一個連線。 應用程式資訊: 處理程序識別碼: 4 應用程式名稱: System 網路資訊: 方向: 輸入 來源位址: 140.111.14.181 來源連接埠: 80 目的地位址: 223.140.201.191 目的地連接埠: 17581 通訊協定: 6 篩選器資訊: 篩選器執行階段識別碼: 0 階層名稱: 接收/接受 階層執行階段識別碼: 44"
			,"5158: AUDIT_SUCCESS Windows 篩選平台已經允許繫結到本機連接埠。 應用程式資訊: 處理程序識別碼: 3000 應用程式名稱: /device/harddiskvolume2/program files (x86)/symantec/symantec endpoint protection/12.1.4112.4156.105/bin64/smc.exe 網路資訊: 來源位址: 0.0.0.0 來源連接埠: 53442 通訊協定: 6 篩選器資訊: 篩選器執行階段識別碼: 0 階層名稱: 資源指派 階層執行階段識別碼: 36"
			,"5446: AUDIT_SUCCESS Windows 篩選平台圖說文字已經變更。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: NT AUTHORITY/SYSTEM 處理程序資訊: 處理程序識別碼: 4 提供者資訊: 識別碼: {D4BD4A0F-7591-4DA2-AE67-3AA97C3C34C2} 名稱: Symantec IPS Provider 變更資訊: 變更類型: 刪除 圖說資訊: 識別碼: {0C30A6A5-E172-4963-97DC-02422CA301C1} 名稱: Symantec Inbound Transport V4 Callout 類型: 不持續 執行階段識別碼: 259 階層資訊: 識別碼: {5926DFC8-E3CF-4426-A283-DC393F5D0F9D} 名稱: 輸入傳輸層 v4 執行階段識別碼: 12"
			,"5447: AUDIT_SUCCESS Windows 篩選平台篩選器已經變更。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: NT AUTHORITY/SYSTEM 處理程序資訊: 處理程序識別碼: 4 提供者資訊: 識別碼: {D4BD4A0F-7591-4DA2-AE67-3AA97C3C34C2} 名稱: Symantec IPS Provider 變更資訊: 變更類型: 刪除 篩選器資訊: 識別碼: {2DCB4349-05C8-4B58-9FD8-0173551416F0} 名稱: Symantec Inbound Transport V4 Callout 類型: 不持續 執行階段識別碼: 76948 階層資訊: 識別碼: {5926DFC8-E3CF-4426-A283-DC393F5D0F9D} 名稱: 輸入傳輸層 v4 執行階段識別碼: 12 圖說資訊: 識別碼: {0C30A6A5-E172-4963-97DC-02422CA301C1} 名稱: Symantec Inbound Transport V4 Callout 其他資訊: 權數: 0 狀況: - 篩選器動作: 圖說文字"
			,"5448: AUDIT_SUCCESS Windows 篩選平台提供者已經變更。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: NT AUTHORITY/SYSTEM 處理程序資訊: 處理程序識別碼: 4 變更資訊: 變更類型: 刪除 提供者資訊: 識別碼: {D4BD4A0F-7591-4DA2-AE67-3AA97C3C34C2} 名稱: Symantec IPS Provider 類型: 不持續"
			,"5450: AUDIT_SUCCESS Windows 篩選平台子階層已經變更。 主旨: 安全性識別碼: S-1-5-18 帳戶名稱: NT AUTHORITY/SYSTEM 處理程序資訊: 處理程序識別碼: 4 提供者資訊: 提供者識別碼: {D4BD4A0F-7591-4DA2-AE67-3AA97C3C34C2} 提供者名稱: Symantec IPS Provider 變更資訊: 變更類型: 刪除 子階層資訊: 子階層識別碼: {14FE6222-5323-42BD-B277-E05A8DFC1169} 子階層名稱: Symantec Network Driver Sub layer 子階層類型: 不持續 其他資訊: 權數: 5120"
		};
		
		for(int i=0; i<data.length; i++) {
			String id = data[i].substring(0, 4);
			String content = data[i].substring(6);
			test(id, content, Locale.TAIWAN);
		}
		
	}
}
