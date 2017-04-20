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

import uia.syslog.we.model.WindowsEvent4905;

public class WindowsEvent4905Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Process: " +
                "Process ID: 0x1140 " +
                "Process Name: C:\\Windows\\System32\\VSSVC.exe " +
                "Event Source: " +
                "Source Name: VSSAudit " +
                "Event Source ID: 0x9c8e0af1";

        WindowsEvent4905 evt = parse2Object("4905", content, Locale.US);
        Assert.assertEquals("4905", evt.getEventId());

        Assert.assertEquals("S-1-5-18", evt.getSecurityId());
        Assert.assertEquals("103PRSDB", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x3e7", evt.getLogonId());

        Assert.assertEquals("0x1140", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\VSSVC.exe", evt.getProcessName());

        Assert.assertEquals("VSSAudit", evt.getSourceName());
        Assert.assertEquals("0x9c8e0af1", evt.getEventSourceId());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Process: " +
                "Process ID: 0x1140 " +
                "Process Name: C:\\Windows\\System32\\VSSVC.exe " +
                "Event Source: " +
                "Source Name: VSSAudit " +
                "Event Source ID: 0x9c8e0af1";

        Assert.assertNotNull(parse2Map("4905", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼: S-1-5-18 " +
                "帳戶名稱: 103PRSDB " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "處理程序: " +
                "處理程序識別碼: 0x1140 " +
                "處理程序名稱: C:\\Windows\\System32\\VSSVC.exe " +
                "事件來源: " +
                "來源名稱: VSSAudit " +
                "事件來源識別碼: 0x9c8e0af1";

        Assert.assertNotNull(parse2Map("4905", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-18");
        Assert.assertEquals(result.get("accountName"), "103PRSDB");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");

        Assert.assertEquals(result.get("processId"), "0x1140");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\VSSVC.exe");

        Assert.assertEquals(result.get("sourceName"), "VSSAudit");
        Assert.assertEquals(result.get("eventSourceId"), "0x9c8e0af1");
    }
}
