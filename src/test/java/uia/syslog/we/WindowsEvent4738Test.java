package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4738;

public class WindowsEvent4738Test extends WindowsEventTest {

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
                "Account Domain:  MAIN" +
                "Attributes: " +
                "SAM Account Name: SAM " +
                "Display Name:  - " +
                "User Principal Name: NO " +
                "Home Directory: c:\\users\\guest " +
                "Home Drive:  c:\\users\\guest\\public " +
                "Script Path:  - " +
                "Profile Path:  c:\\users\\guest " +
                "User Workstations: WS " +
                "Password Last Set: 123456 " +
                "Account Expires:  2016/8/7 " +
                "Primary Group ID: SYS " +
                "Allowed To Delegate To: Y " +
                "Old UAC Value:  0x10 " +
                "New UAC Value:  0x4010 " +
                "User Account Control: 'Not Delegated' - Enabled " +
                "User Parameters:  " +
                "SID History:  - " +
                "Logon Hours:  21 " +
                "Additional Information: " +
                "Privileges: NO";

        WindowsEvent4738 evt = parse2Object("4738", content, Locale.US);
        Assert.assertEquals("4738", evt.getEventId());
        Assert.assertEquals("SYSTEM", evt.getSecurityId());
        Assert.assertEquals("ONE", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());
        Assert.assertEquals("MAIN\\Jack", evt.getTargetSecurityId());
        Assert.assertEquals("Jack", evt.getTargetAccountName());
        Assert.assertEquals("MAIN", evt.getTargetAccountDomain());
        Assert.assertEquals("SAM", evt.getSamAccountName());
        Assert.assertEquals("-", evt.getDisplayName());
        Assert.assertEquals("NO", evt.getUserPrincipalName());
        Assert.assertEquals("c:\\users\\guest", evt.getHomeDirectory());
        Assert.assertEquals("c:\\users\\guest\\public", evt.getHomeDrive());
        Assert.assertEquals("-", evt.getScriptPath());
        Assert.assertEquals("c:\\users\\guest", evt.getProfilePath());
        Assert.assertEquals("WS", evt.getUserWorkstations());
        Assert.assertEquals("123456", evt.getPasswordLastSet());
        Assert.assertEquals("2016/8/7", evt.getAccountExpires());
        Assert.assertEquals("SYS", evt.getPrimaryGroupId());
        Assert.assertEquals("Y", evt.getAllowedToDelegateTo());
        Assert.assertEquals("0x10", evt.getOldUacValue());
        Assert.assertEquals("0x4010", evt.getNewUacValue());
        Assert.assertEquals("'Not Delegated' - Enabled", evt.getUserAccountControl());
        Assert.assertEquals("", evt.getUserParameters());
        Assert.assertEquals("-", evt.getSidHistory());
        Assert.assertEquals(21, evt.getLogonHours());
        Assert.assertEquals("NO", evt.getPrivileges());
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
                "Account Domain:  MAIN" +
                "Attributes: " +
                "SAM Account Name: - " +
                "Display Name:  - " +
                "User Principal Name: - " +
                "Home Directory: c:\\users\\guest " +
                "Home Drive:  c:\\users\\guest\\public " +
                "Script Path:  - " +
                "Profile Path:  c:\\users\\guest " +
                "User Workstations: - " +
                "Password Last Set: 123456 " +
                "Account Expires:  2016/8/7 " +
                "Primary Group ID: - " +
                "Allowed To Delegate To: - " +
                "Old UAC Value:  0x10 " +
                "New UAC Value:  0x4010 " +
                "User Account Control: 'Not Delegated' - Enabled " +
                "User Parameters: - " +
                "SID History:  - " +
                "Logon Hours:  21 " +
                "Additional Information: " +
                "Privileges: NO";

        Assert.assertNotNull(parse2Map("4738", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String c = "主旨: 安全性識別碼: S-1-5-21-669216072-2446163755-4094068255-500 " +
                "帳戶名稱: Administrator " +
                "帳戶網域: 103SCHPRS " +
                "登入識別碼: 0xf0b8ce33 " +
                "目標帳戶: " +
                "安全性識別碼: S-1-5-21-669216072-2446163755-4094068255-1000 " +
                "帳戶名稱: hyweb " +
                "帳戶網域: 103SCHPRS " +
                "變更的屬性: " +
                "SAM 帳戶名稱: hyweb " +
                "顯示名稱: hyweb " +
                "使用者主體名稱: - " +
                "主目錄: <數值未設定> " +
                "主磁碟: <數值未設定> " +
                "指令檔路徑: <數值未設定> " +
                "設定檔路徑: <數值未設定> " +
                "使用者工作站: <數值未設定> " +
                "最近的密碼設定: 2016/12/19 上午 09:35:22 " +
                "帳戶有效期: <永不> " +
                "主要群組識別碼: 513 " +
                "允許委派於: - " +
                "舊的 UAC 數值: 0x10 " +
                "新的 UAC 數值: 0x11 " +
                "使用者帳戶控制: 帳戶已停用 " +
                "使用者參數: <數值未設定> " +
                "SID 歷程記錄: - " +
                "登入時段: 全部 " +
                "其他資訊: " +
                "特殊權限: -";

        String content = "主旨: " +
                "安全性識別碼:  SYSTEM " +
                "帳戶名稱:  ONE " +
                "帳戶網域:  WORKGROUP " +
                "登入識別碼:  0x1f41e " +
                "目標帳戶: " +
                "安全性識別碼:  MAIN\\Jack " +
                "帳戶名稱:  Jack " +
                "帳戶網域:  MAIN " +
                "變更的屬性: " +
                "SAM 帳戶名稱: - " +
                "顯示名稱:  - " +
                "使用者主體名稱: - " +
                "主目錄: c:\\users\\guest " +
                "主磁碟:  c:\\users\\guest\\public " +
                "指令檔路徑:  - " +
                "設定檔路徑:  c:\\users\\guest " +
                "使用者工作站: - " +
                "最近的密碼設定: 123456 " +
                "帳戶有效期:  2016/8/7 " +
                "主要群組識別碼: - " +
                "允許委派於: - " +
                "舊的 UAC 數值:  0x10 " +
                "新的 UAC 數值:  0x4010 " +
                "使用者帳戶控制: 'Not Delegated' - Enabled " +
                "使用者參數: - " +
                "SID 歷程記錄:  - " +
                "登入時段:  21 " +
                "其他資訊: " +
                "特殊權限: NO";

        Assert.assertNotNull(parse2Map("4738", content, Locale.TAIWAN));
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

        Assert.assertEquals(result.get("samAccountName"), "-");
        Assert.assertEquals(result.get("displayName"), "-");
        Assert.assertEquals(result.get("userPrincipalName"), "-");
        Assert.assertEquals(result.get("homeDirectory"), "c:\\users\\guest");
        Assert.assertEquals(result.get("homeDrive"), "c:\\users\\guest\\public");
        Assert.assertEquals(result.get("scriptPath"), "-");
        Assert.assertEquals(result.get("profilePath"), "c:\\users\\guest");
        Assert.assertEquals(result.get("userWorkstations"), "-");
        Assert.assertEquals(result.get("accountExpires"), "2016/8/7");
        Assert.assertEquals(result.get("primaryGroupId"), "-");
        Assert.assertEquals(result.get("allowedToDelegateTo"), "-");
        Assert.assertEquals(result.get("oldUacValue"), "0x10");
        Assert.assertEquals(result.get("newUacValue"), "0x4010");
        Assert.assertEquals(result.get("userParameters"), "-");
        Assert.assertEquals(result.get("sidHistory"), "-");
        Assert.assertEquals(result.get("logonHours"), 21);

        Assert.assertEquals(result.get("targetSecurityId"), "MAIN\\Jack");
        Assert.assertEquals(result.get("privileges"), "NO");
    }
}
