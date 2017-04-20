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

import uia.syslog.we.model.WindowsEvent5140;

public class WindowsEvent5140Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "AUDIT_SUCCESS 已存取網路共用物件。 " +
                "Subject: " +
                "Security ID: S-1-5-20 " +
                "Account Name: Administrator " +
                "Account Domain: VM-EDU-WEB1 " +
                "Logon ID: 0x151160206 " +
                "Network Information: " +
                "Object Type: File " +
                "Source Address: ::1 " +
                "Source Port: 54960 " +
                "Share Information: " +
                "Share Name: \\*\\C$ " +
                "Share Path: \\??\\C:\\ " +
                "Access Request Information: " +
                "Access Mask: 0x1 " +
                "Accesses: ReadData (或 ListDirectory) ";

        WindowsEvent5140 evt = parse2Object("5140", content, Locale.US);
        Assert.assertEquals("5140", evt.getEventId());

        Assert.assertEquals("S-1-5-20", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("VM-EDU-WEB1", evt.getAccountDomain());
        Assert.assertEquals("0x151160206", evt.getLogonId());

        Assert.assertEquals("File", evt.getObjectType());
        Assert.assertEquals("::1", evt.getSourceAddress());
        Assert.assertEquals(54960, evt.getSourcePort());

        Assert.assertEquals("\\*\\C$", evt.getShareName());
        Assert.assertEquals("\\??\\C:\\", evt.getSharePath());

        Assert.assertEquals("0x1", evt.getAccessMask());
        Assert.assertEquals("ReadData (或 ListDirectory)", evt.getAccesses());
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS 已存取網路共用物件。 " +
                "Subject: " +
                "Security ID: S-1-5-20 " +
                "Account Name: Administrator " +
                "Account Domain: VM-EDU-WEB1 " +
                "Logon ID: 0x151160206 " +
                "Network Information: " +
                "Object Type: File " +
                "Source Address: ::1 " +
                "Source Port: 54960 " +
                "Share Information: " +
                "Share Name: \\*\\C$ " +
                "Share Path: \\??\\C:\\ " +
                "Access Request Information: " +
                "Access Mask: 0x1 " +
                "Accesses: ReadData (或 ListDirectory) ";

        Assert.assertNotNull(parse2Map("5140", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS 已存取網路共用物件。 " +
                "主體: " +
                "安全性識別碼: S-1-5-20 " +
                "帳戶名稱: Administrator " +
                "帳戶網域: VM-EDU-WEB1 " +
                "登入識別碼: 0x151160206 " +
                "網路資訊: " +
                "物件類型: File " +
                "來源位址: ::1 " +
                "來源連接埠: 54960 " +
                "共用資訊: " +
                "共用名稱: \\*\\C$  " +
                "共用路徑: \\??\\C:\\ " +
                "存取要求資訊: " +
                "存取遮罩: 0x1 " +
                "存取: ReadData (或 ListDirectory)";

        Assert.assertNotNull(parse2Map("5140", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-20");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "VM-EDU-WEB1");
        Assert.assertEquals(result.get("logonId"), "0x151160206");
        Assert.assertEquals(result.get("objectType"), "File");
        Assert.assertEquals(result.get("sourceAddress"), "::1");
        Assert.assertEquals(result.get("sourcePort"), 54960);
        Assert.assertEquals(result.get("shareName"), "\\*\\C$");
        Assert.assertEquals(result.get("sharePath"), "\\??\\C:\\");
        Assert.assertEquals(result.get("accessMask"), "0x1");
        Assert.assertEquals(result.get("accesses"), "ReadData (或 ListDirectory)");
    }
}
