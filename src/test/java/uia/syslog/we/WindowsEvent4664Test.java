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

import uia.syslog.we.model.WindowsEvent4664;

public class WindowsEvent4664Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "AUDIT_SUCCESS 嘗試建立永久連結。 " +
                "Subject: " +
                "Account Name: S-1-5-18 " +
                "Account Name: VM-EDU-DB$ " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Link Information: " +
                "File Name: C:\\Windows\\winsxs\\msfeedsbs.mfl " +
                "Link Name: C:\\Windows\\SysWOW64\\wbem\\zh-TW\\msfeedsbs.mfl " +
                "Transaction ID: {B17AB753-2789-11E7-8702-005056923306}";

        WindowsEvent4664 evt = parse2Object("4664", content, Locale.US);
        Assert.assertEquals("4664", evt.getEventId());

        Assert.assertEquals("S-1-5-18", evt.getSecurityId());
        Assert.assertEquals("VM-EDU-DB$", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x3e7", evt.getLogonId());

        Assert.assertEquals("C:\\Windows\\winsxs\\msfeedsbs.mfl", evt.getFileName());
        Assert.assertEquals("C:\\Windows\\SysWOW64\\wbem\\zh-TW\\msfeedsbs.mfl", evt.getLinkName());
        Assert.assertEquals("{B17AB753-2789-11E7-8702-005056923306}", evt.getTransactionId());
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS 嘗試建立永久連結。 " +
                "Subject: " +
                "Account Name: S-1-5-18 " +
                "Account Name: VM-EDU-DB$ " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Link Information: " +
                "File Name: C:\\Windows\\winsxs\\msfeedsbs.mfl " +
                "Link Name: C:\\Windows\\SysWOW64\\wbem\\zh-TW\\msfeedsbs.mfl " +
                "Transaction ID: {B17AB753-2789-11E7-8702-005056923306}";

        Assert.assertNotNull(parse2Map("4664", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS 嘗試建立永久連結。 " +
                "主旨: " +
                "帳戶名稱: S-1-5-18 " +
                "帳戶名稱: VM-EDU-DB$ " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "連結資訊: " +
                "檔案名稱: C:\\Windows\\winsxs\\msfeedsbs.mfl " +
                "連結名稱: C:\\Windows\\SysWOW64\\wbem\\zh-TW\\msfeedsbs.mfl " +
                "交易識別碼: {B17AB753-2789-11E7-8702-005056923306}";

        Assert.assertNotNull(parse2Map("4664", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-18");
        Assert.assertEquals(result.get("accountName"), "VM-EDU-DB$");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");
        Assert.assertEquals(result.get("fileName"), "C:\\Windows\\winsxs\\msfeedsbs.mfl");
        Assert.assertEquals(result.get("linkName"), "C:\\Windows\\SysWOW64\\wbem\\zh-TW\\msfeedsbs.mfl");
        Assert.assertEquals(result.get("transactionId"), "{B17AB753-2789-11E7-8702-005056923306}");
    }
}
