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

import uia.syslog.we.model.WindowsEvent5142;

public class WindowsEvent5142Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "AUDIT_SUCCESS 嘗試建立永久連結。 " +
                "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: VM-EDU-WEB1$ " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Share Information: " +
                "Share Name: \\*\\C$ " +
                "Share Path: C:\\";

        WindowsEvent5142 evt = parse2Object("5142", content, Locale.US);
        Assert.assertEquals("5142", evt.getEventId());

        Assert.assertEquals("S-1-5-18", evt.getSecurityId());
        Assert.assertEquals("VM-EDU-WEB1$", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x3e7", evt.getLogonId());

        Assert.assertEquals("\\*\\C$", evt.getShareName());
        Assert.assertEquals("C:\\", evt.getSharePath());
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS 嘗試建立永久連結。 " +
                "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: VM-EDU-WEB1$ " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Share Information: " +
                "Share Name: \\*\\C$ " +
                "Share Path: C:\\";

        Assert.assertNotNull(parse2Map("5142", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS 已新增網路共用物件。 " +
                "主旨: " +
                "安全性識別碼: S-1-5-18 " +
                "帳戶名稱: VM-EDU-WEB1$ " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "共用資訊: " +
                "共用名稱: \\*\\C$ " +
                "共用路徑: C:\\";

        Assert.assertNotNull(parse2Map("5142", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-18");
        Assert.assertEquals(result.get("accountName"), "VM-EDU-WEB1$");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");
        Assert.assertEquals(result.get("shareName"), "\\*\\C$");
        Assert.assertEquals(result.get("sharePath"), "C:\\");
    }
}
