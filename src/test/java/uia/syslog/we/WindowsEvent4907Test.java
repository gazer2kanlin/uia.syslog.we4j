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

import uia.syslog.we.model.WindowsEvent4907;

public class WindowsEvent4907Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "AUDIT_SUCCESS 物件的稽核設定已經變更。 " +
                "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103SCHPRS$ " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Object: " +
                "Object Server: Security " +
                "Object Type: File " +
                "Object Name: C:\\Windows\\SysWOW64\\api-ms-win-core-xstate-l2-1-0.dll " +
                "Handle ID: 0x18 " +
                "Process Information: " +
                "Process ID: 0x186c " +
                "Process Name: C:\\Windows\\System32\\poqexec.exe " +
                "Auditing Settings: " +
                "Original Security Descriptor: " +
                "New Security Descriptor: S:ARAI(AU;SAFA;DCLCRPCRSDWDWO;;;WD)​;";

        WindowsEvent4907 evt = parse2Object("4907", content, Locale.US);
        Assert.assertEquals("4907", evt.getEventId());

        Assert.assertEquals("S-1-5-18", evt.getSecurityId());
        Assert.assertEquals("103SCHPRS$", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x3e7", evt.getLogonId());

        Assert.assertEquals("Security", evt.getObjectServer());
        Assert.assertEquals("File", evt.getObjectType());
        Assert.assertEquals("C:\\Windows\\SysWOW64\\api-ms-win-core-xstate-l2-1-0.dll", evt.getObjectName());
        Assert.assertEquals("0x18", evt.getHandleId());

        Assert.assertEquals("0x186c", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\poqexec.exe", evt.getProcessName());

        Assert.assertEquals("", evt.getOrigSecurityDesc());
        Assert.assertEquals("S:ARAI(AU;SAFA;DCLCRPCRSDWDWO;;;WD)​;", evt.getNewSecurityDesc());
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS 物件的稽核設定已經變更。 " +
                "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103SCHPRS$ " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Object: " +
                "Object Server: Security " +
                "Object Type: File " +
                "Object Name: C:\\Windows\\SysWOW64\\api-ms-win-core-xstate-l2-1-0.dll " +
                "Handle ID: 0x18 " +
                "Process Information: " +
                "Process ID: 0x186c " +
                "Process Name: C:\\Windows\\System32\\poqexec.exe " +
                "Auditing Settings: " +
                "Original Security Descriptor: " +
                "New Security Descriptor: S:ARAI(AU;SAFA;DCLCRPCRSDWDWO;;;WD)​;";

        Assert.assertNotNull(parse2Map("4907", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS 物件的稽核設定已經變更。 " +
                "主體: " +
                "安全性識別碼: S-1-5-18 " +
                "帳戶名稱: 103SCHPRS$ " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "物件: " +
                "物件伺服器: Security " +
                "物件類型: File " +
                "物件名稱: C:\\Windows\\SysWOW64\\api-ms-win-core-xstate-l2-1-0.dll " +
                "控制代碼識別碼: 0x18 " +
                "處理程序資訊: " +
                "處理程序識別碼: 0x186c " +
                "處理程序名稱: C:\\Windows\\System32\\poqexec.exe " +
                "稽核設定: " +
                "原始安全性描述元: " +
                "新安全性描述元: S:ARAI(AU;SAFA;DCLCRPCRSDWDWO;;;WD)​;";

        Assert.assertNotNull(parse2Map("4907", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-18");
        Assert.assertEquals(result.get("accountName"), "103SCHPRS$");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");

        Assert.assertEquals(result.get("objectServer"), "Security");
        Assert.assertEquals(result.get("objectType"), "File");
        Assert.assertEquals(result.get("objectName"), "C:\\Windows\\SysWOW64\\api-ms-win-core-xstate-l2-1-0.dll");
        Assert.assertEquals(result.get("handleId"), "0x18");

        Assert.assertEquals(result.get("processId"), "0x186c");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\poqexec.exe");

        Assert.assertEquals(result.get("origSecurityDesc"), "");
        Assert.assertEquals(result.get("newSecurityDesc"), "S:ARAI(AU;SAFA;DCLCRPCRSDWDWO;;;WD)​;");
    }
}
