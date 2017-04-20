/*******************************************************************************
 * Copyright 2017 UIA
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent5154;

public class WindowsEvent5154Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Application Information: " +
                "Process ID: 1648 " +
                "Application Name: \\device\\harddiskvolume1\\windows\\system32\\dns.exe " +
                "Network Information: " +
                "Source Address: 10.42.42.223 " +
                "Source Port: 53 " +
                "Protocol:  6 " +
                "Filter Information: " +
                "Filter Run-Time ID: 65884 " +
                "Layer Name:  Listen " +
                "Layer Run-Time ID: 40 ";

        WindowsEvent5154 evt = parse2Object("5154", content, Locale.US);
        Assert.assertEquals("5154", evt.getEventId());
        Assert.assertEquals("1648", evt.getProcessId());
        Assert.assertEquals("\\device\\harddiskvolume1\\windows\\system32\\dns.exe", evt.getApplicationName());
        Assert.assertEquals("10.42.42.223", evt.getSourceAddress());
        Assert.assertEquals(53, evt.getSourcePort());
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
                "Source Address: 10.42.42.223 " +
                "Source Port: 53 " +
                "Protocol:  6 " +
                "Filter Information: " +
                "Filter Run-Time ID: 65884 " +
                "Layer Name:  Listen " +
                "Layer Run-Time ID: 40 ";

        Assert.assertEquals(9, parse2Map("5154", content, Locale.US).size());
    }

    @Test
    public void testTW() throws Exception {
        String content = "應用程式資訊: " +
                "處理程序識別碼: 1648 " +
                "應用程式名稱: \\device\\harddiskvolume1\\windows\\system32\\dns.exe " +
                "網路資訊: " +
                "來源位址: 10.42.42.223 " +
                "來源連接埠: 53 " +
                "通訊協定:  6 " +
                "篩選器資訊: " +
                "篩選器執行階段識別碼: 65884 " +
                "階層名稱:  Listen " +
                "階層執行階段識別碼: 40 ";

        Assert.assertEquals(9, parse2Map("5154", content, Locale.TAIWAN).size());
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("processId"), "1648");
        Assert.assertEquals(result.get("applicationName"), "\\device\\harddiskvolume1\\windows\\system32\\dns.exe");
        Assert.assertEquals(result.get("sourceAddress"), "10.42.42.223");
        Assert.assertEquals((Integer) result.get("sourcePort"), 53, 0);
        Assert.assertEquals(result.get("protocol"), "6");
        Assert.assertEquals(result.get("filterRunTimeId"), "65884");
        Assert.assertEquals(result.get("layerName"), "Listen");
        Assert.assertEquals(result.get("layerRunTimeId"), "40");
    }
}
