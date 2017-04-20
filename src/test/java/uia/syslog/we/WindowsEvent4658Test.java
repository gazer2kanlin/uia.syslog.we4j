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

import uia.syslog.we.model.WindowsEvent4658;

public class WindowsEvent4658Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Object: " +
                "Object Server: Security " +
                "Handle ID: 0x40 " +
                "Process Information: " +
                "Process ID: 0x1ac " +
                "Process Name: C:\\Windows\\System32\\cmd.exe ";

        WindowsEvent4658 evt = parse2Object("4658", content, Locale.US);
        Assert.assertEquals("4658", evt.getEventId());

        Assert.assertEquals("ACME\\Administrator", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("ACME", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());

        Assert.assertEquals("Security", evt.getObjectServer());
        Assert.assertEquals("0x40", evt.getHandleId());

        Assert.assertEquals("0x1ac", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\cmd.exe", evt.getProcessName());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Object: " +
                "Object Server: Security " +
                "Handle ID: 0x40 " +
                "Process Information: " +
                "Process ID: 0x1ac " +
                "Process Name: C:\\Windows\\System32\\cmd.exe ";

        Assert.assertNotNull(parse2Map("4658", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  ACME\\Administrator " +
                "帳戶名稱:  Administrator " +
                "帳戶網域:  ACME " +
                "登入識別碼:  0x1f41e " +
                "物件: " +
                "物件伺服器: Security " +
                "控制代碼識別碼: 0x40 " +
                "處理程序資訊: " +
                "處理程序識別碼: 0x1ac " +
                "處理程序名稱: C:\\Windows\\System32\\cmd.exe ";

        Assert.assertNotNull(parse2Map("4658", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "ACME\\Administrator");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "ACME");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");
        Assert.assertEquals(result.get("objectServer"), "Security");
        Assert.assertEquals(result.get("handleId"), "0x40");
        Assert.assertEquals(result.get("processId"), "0x1ac");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\cmd.exe");
    }
}
