package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4946Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS Windows 防火牆的例外清單已變更。規則已經新增。 " +
                "Profile Changed: All " +
                "Added Rule: " +
                "Rule ID: {CD8D2D3C-0794-4B78-8D89-0CBE779C5D03} " +
                "Rule Name: 8009";

        Assert.assertNotNull(parse2Map("4946", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS Windows 防火牆的例外清單已變更。規則已經新增。 " +
                "變更的設定檔: All " +
                "新增的規則: " +
                "規則識別碼: {CD8D2D3C-0794-4B78-8D89-0CBE779C5D03} " +
                "規則名稱: 8009";

        Assert.assertNotNull(parse2Map("4946", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("logHeader"), "AUDIT_SUCCESS Windows 防火牆的例外清單已變更。規則已經新增。");
        Assert.assertEquals(result.get("profileChanged"), "All");
        Assert.assertEquals(result.get("ruleId"), "{CD8D2D3C-0794-4B78-8D89-0CBE779C5D03}");
        Assert.assertEquals(result.get("ruleName"), "8009");
    }
}
