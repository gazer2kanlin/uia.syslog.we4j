package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent0900Test extends WindowsEventTest {

    @Test
    public void testUS() throws Exception {
        Assert.assertNotNull(parse2Map("900", "正在啟動軟體保護服務。", Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        Assert.assertNotNull(parse2Map("900", "正在啟動軟體保護服務。", Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("logHeader"), "正在啟動軟體保護服務。");
    }
}
