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

import uia.syslog.we.model.WindowsEvent4800;

public class WindowsEvent4800Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Session ID: 21";

        WindowsEvent4800 evt = parse2Object("4800", content, Locale.US);
        Assert.assertEquals("4800", evt.getEventId());

        Assert.assertEquals("S-1-5-18", evt.getSecurityId());
        Assert.assertEquals("103PRSDB", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x3e7", evt.getLogonId());
        Assert.assertEquals("21", evt.getSessionId());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Session ID: 21";

        Assert.assertNotNull(parse2Map("4800", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼: S-1-5-18 " +
                "帳戶名稱: 103PRSDB " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "工作階段識別碼: 21";

        Assert.assertNotNull(parse2Map("4800", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-18");
        Assert.assertEquals(result.get("accountName"), "103PRSDB");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");
        Assert.assertEquals(result.get("sessionId"), "21");
    }
}
