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

import uia.syslog.we.model.WindowsEvent4767;

public class WindowsEvent4767Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  S-1-5-21-669216072-2446163755-4094068255-500 " +
                "Account Name:  Administrator " +
                "Account Domain:  103PRSDB " +
                "Logon ID:  0xe3344593 " +
                "Target Account: " +
                "Security ID:  S-1-5-21-669216072-2446163755-4094068255-1004 " +
                "Account Name:  hyweb " +
                "Account Domain:  103PRSDB";

        WindowsEvent4767 evt = parse2Object("4767", content, Locale.US);
        Assert.assertEquals("4767", evt.getEventId());

        Assert.assertEquals("S-1-5-21-669216072-2446163755-4094068255-500", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("103PRSDB", evt.getAccountDomain());
        Assert.assertEquals("0xe3344593", evt.getLogonId());

        Assert.assertEquals("S-1-5-21-669216072-2446163755-4094068255-1004", evt.getTargetSecurityId());
        Assert.assertEquals("hyweb", evt.getTargetAccountName());
        Assert.assertEquals("103PRSDB", evt.getTargetAccountDomain());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  S-1-5-21-669216072-2446163755-4094068255-500 " +
                "Account Name:  Administrator " +
                "Account Domain:  103PRSDB " +
                "Logon ID:  0xe3344593 " +
                "Target Account: " +
                "Security ID:  S-1-5-21-669216072-2446163755-4094068255-1004 " +
                "Account Name:  hyweb " +
                "Account Domain:  103PRSDB";

        Assert.assertNotNull(parse2Map("4767", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS 已解除鎖定使用者帳戶。 " +
                "主旨: " +
                "安全性識別碼: S-1-5-21-669216072-2446163755-4094068255-500 " +
                "帳戶名稱: Administrator " +
                "帳戶網域: 103PRSDB " +
                "登入識別碼: 0xe3344593 " +
                "目標帳戶: " +
                "安全性識別碼: S-1-5-21-669216072-2446163755-4094068255-1004 " +
                "帳戶名稱: hyweb " +
                "帳戶網域: 103PRSDB";

        Assert.assertNotNull(parse2Map("4767", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-21-669216072-2446163755-4094068255-500");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "103PRSDB");
        Assert.assertEquals(result.get("logonId"), "0xe3344593");
        Assert.assertEquals(result.get("targetSecurityId"), "S-1-5-21-669216072-2446163755-4094068255-1004");
        Assert.assertEquals(result.get("targetAccountName"), "hyweb");
        Assert.assertEquals(result.get("targetAccountDomain"), "103PRSDB");
    }
}
