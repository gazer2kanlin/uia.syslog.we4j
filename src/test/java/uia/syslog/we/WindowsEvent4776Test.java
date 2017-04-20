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

import uia.syslog.we.model.WindowsEvent4776;

public class WindowsEvent4776Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Authentication Package: MICROSOFT_AUTHENTICATION_PACKAGE_V1_0 " +
                "Logon Account: administrator" +
                "Source Workstation: WIN-R9H529RIO4Y" +
                "Error Code: 0xc0000064";

        WindowsEvent4776 evt = parse2Object("4776", content, Locale.US);
        Assert.assertEquals("4776", evt.getEventId());
        Assert.assertEquals("MICROSOFT_AUTHENTICATION_PACKAGE_V1_0", evt.getAuthenticationPackage());
        Assert.assertEquals("administrator", evt.getLogonAccount());
        Assert.assertEquals("WIN-R9H529RIO4Y", evt.getSourceWorkstation());
        Assert.assertEquals("0xc0000064", evt.getErrorCode());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Authentication Package: MICROSOFT_AUTHENTICATION_PACKAGE_V1_0 " +
                "Logon Account: administrator" +
                "Source Workstation: WIN-R9H529RIO4Y" +
                "Error Code: 0xc0000064";

        Assert.assertNotNull(parse2Map("4776", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "驗證封裝: MICROSOFT_AUTHENTICATION_PACKAGE_V1_0 " +
                "登入帳戶: administrator" +
                "來源工作站: WIN-R9H529RIO4Y" +
                "錯誤碼: 0xc0000064";

        Assert.assertNotNull(parse2Map("4776", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("authenticationPackage"), "MICROSOFT_AUTHENTICATION_PACKAGE_V1_0");
        Assert.assertEquals(result.get("logonAccount"), "administrator");
        Assert.assertEquals(result.get("sourceWorkstation"), "WIN-R9H529RIO4Y");
        Assert.assertEquals(result.get("errorCode"), "0xc0000064");
    }
}
