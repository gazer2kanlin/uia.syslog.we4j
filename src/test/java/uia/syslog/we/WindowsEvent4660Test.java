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

import uia.syslog.we.model.WindowsEvent4660;

public class WindowsEvent4660Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "AUDIT_SUCCESS 物件已刪除。 " +
                "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: VM-EDU-DB$ " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Object: " +
                "Object Server: Security " +
                "Handle ID: 0xa4 " +
                "Process Information: " +
                "Process ID: 0xb0c " +
                "Process Name: C:\\Windows\\System32\\mcbuilder.exe " +
                "Transaction ID: {00000000-0000-0000-0000-000000000000}";

        WindowsEvent4660 evt = parse2Object("4660", content, Locale.US);
        Assert.assertEquals("4660", evt.getEventId());

        Assert.assertEquals("S-1-5-18", evt.getSecurityId());
        Assert.assertEquals("VM-EDU-DB$", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x3e7", evt.getLogonId());

        Assert.assertEquals("Security", evt.getObjectServer());
        Assert.assertEquals("0xa4", evt.getHandleId());

        Assert.assertEquals("0xb0c", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\mcbuilder.exe", evt.getProcessName());
        Assert.assertEquals("{00000000-0000-0000-0000-000000000000}", evt.getTransactionId());
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS 物件已刪除。 " +
                "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: VM-EDU-DB$ " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Object: " +
                "Object Server: Security " +
                "Handle ID: 0xa4 " +
                "Process Information: " +
                "Process ID: 0xb0c " +
                "Process Name: C:\\Windows\\System32\\mcbuilder.exe " +
                "Transaction ID: {00000000-0000-0000-0000-000000000000}";

        Assert.assertNotNull(parse2Map("4660", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS 物件已刪除。 " +
                "主旨: " +
                "安全性識別碼: S-1-5-18 " +
                "帳戶名稱: VM-EDU-DB$ " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "物件: " +
                "物件伺服器: Security " +
                "控制代碼識別碼: 0xa4 " +
                "處理程序資訊: " +
                "處理程序識別碼: 0xb0c " +
                "處理程序名稱: C:\\Windows\\System32\\mcbuilder.exe " +
                "交易識別碼: {00000000-0000-0000-0000-000000000000}";

        Assert.assertNotNull(parse2Map("4660", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-18");
        Assert.assertEquals(result.get("accountName"), "VM-EDU-DB$");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");
        Assert.assertEquals(result.get("objectServer"), "Security");
        Assert.assertEquals(result.get("handleId"), "0xa4");
        Assert.assertEquals(result.get("processId"), "0xb0c");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\mcbuilder.exe");
        Assert.assertEquals(result.get("transactionId"), "{00000000-0000-0000-0000-000000000000}");
    }
}
