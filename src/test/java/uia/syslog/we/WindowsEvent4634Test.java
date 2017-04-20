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

import uia.syslog.we.model.WindowsEvent4634;

public class WindowsEvent4634Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  ANONYMOUS LOGON " +
                "Account Name:  ANONYMOUS " +
                "Account Domain:  NT AUTHORITY " +
                "Logon ID:  0x149be " +
                "Logon Type: 3 This means something is special";

        WindowsEvent4634 evt = parse2Object("4634", content, Locale.US);
        Assert.assertEquals("4634", evt.getEventId());
        Assert.assertEquals("ANONYMOUS LOGON", evt.getSecurityId());
        Assert.assertEquals("ANONYMOUS", evt.getAccountName());
        Assert.assertEquals("NT AUTHORITY", evt.getAccountDomain());
        Assert.assertEquals("0x149be", evt.getLogonId());
        Assert.assertEquals("3", evt.getLogonType());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  ANONYMOUS LOGON " +
                "Account Name:  ANONYMOUS  " +
                "Account Domain:  NT AUTHORITY " +
                "Logon ID:  0x149be " +
                "Logon Type: 3 This means something is special";

        Assert.assertNotNull(parse2Map("4634", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼: ANONYMOUS LOGON " +
                "帳戶名稱:  ANONYMOUS " +
                "帳戶網域:  NT AUTHORITY " +
                "登入識別碼:  0x149be " +
                "登入類型: 3 登入工作階段損毀時，就會產生這個事件。";

        Assert.assertNotNull(parse2Map("4634", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "ANONYMOUS LOGON");
        Assert.assertEquals(result.get("accountName"), "ANONYMOUS");
        Assert.assertEquals(result.get("accountDomain"), "NT AUTHORITY");
        Assert.assertEquals(result.get("logonId"), "0x149be");
        Assert.assertEquals(result.get("logonType"), "3");
    }
}
