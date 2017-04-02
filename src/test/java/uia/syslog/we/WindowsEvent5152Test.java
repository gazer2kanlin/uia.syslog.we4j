package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent5152;

public class WindowsEvent5152Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Application Information: " +
                "Process ID: 1648 " +
                "Application Name: \\device\\harddiskvolume1\\windows\\system32\\dns.exe " +
                "Network Information: " +
                "Direction: Inbound " +
                "Source Address: 10.42.42.223 " +
                "Source Port: 53 " +
                "Destination Address: 10.42.42.123 " +
                "Destination Port: 153 " +
                "Protocol:  6 " +
                "Filter Information: " +
                "Filter Run-Time ID: 65884 " +
                "Layer Name:  Listen " +
                "Layer Run-Time ID: 40 ";

        WindowsEvent5152 evt = parse2Object("5152", content, Locale.US);
        Assert.assertEquals("5152", evt.getEventId());
        Assert.assertEquals("1648", evt.getProcessId());
        Assert.assertEquals("\\device\\harddiskvolume1\\windows\\system32\\dns.exe", evt.getApplicationName());
        Assert.assertEquals("Inbound", evt.getDirection());
        Assert.assertEquals("10.42.42.223", evt.getSourceAddress());
        Assert.assertEquals(53, evt.getSourcePort());
        Assert.assertEquals("10.42.42.123", evt.getDestinationAddress());
        Assert.assertEquals(153, evt.getDestinationPort());
        Assert.assertEquals("6", evt.getProtocol());
        Assert.assertEquals("65884", evt.getFilterRunTimeId());
        Assert.assertEquals("Listen", evt.getLayerName());
        Assert.assertEquals("40", evt.getLayerRunTimeId());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Application Information: " +
                "Process ID: 1648 " +
                "Application Name: \\device\\harddiskvolume1\\windows\\system32\\dns.exe " +
                "Network Information: " +
                "Direction: Inbound " +
                "Source Address: 10.42.42.223 " +
                "Source Port: 53 " +
                "Destination Address: 10.42.42.123 " +
                "Destination Port: 153 " +
                "Protocol:  6 " +
                "Filter Information: " +
                "Filter Run-Time ID: 65884 " +
                "Layer Name:  Listen " +
                "Layer Run-Time ID: 40 ";

        Assert.assertNotNull(parse2Map("5152", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "應用程式資訊: " +
                "處理程序識別碼: 1648 " +
                "應用程式名稱: \\device\\harddiskvolume1\\windows\\system32\\dns.exe " +
                "網路資訊: " +
                "方向: Inbound " +
                "來源位址: 10.42.42.223 " +
                "來源連接埠: 53 " +
                "目的地位址: 10.42.42.123 " +
                "目的地連接埠: 153 " +
                "通訊協定:  6 " +
                "篩選器資訊: " +
                "篩選器執行階段識別碼: 65884 " +
                "階層名稱:  Listen " +
                "階層執行階段識別碼: 40 ";

        Assert.assertNotNull(parse2Map("5152", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("processId"), "1648");
        Assert.assertEquals(result.get("applicationName"), "\\device\\harddiskvolume1\\windows\\system32\\dns.exe");
        Assert.assertEquals(result.get("direction"), "Inbound");
        Assert.assertEquals(result.get("sourceAddress"), "10.42.42.223");
        Assert.assertEquals((Integer) result.get("sourcePort"), 53, 0);
        Assert.assertEquals(result.get("destinationAddress"), "10.42.42.123");
        Assert.assertEquals((Integer) result.get("destinationPort"), 153, 0);
        Assert.assertEquals(result.get("protocol"), "6");
        Assert.assertEquals(result.get("filterRunTimeId"), "65884");
        Assert.assertEquals(result.get("layerName"), "Listen");
        Assert.assertEquals(result.get("layerRunTimeId"), "40");
    }
}
