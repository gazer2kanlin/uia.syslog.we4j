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

import uia.syslog.we.model.WindowsEvent4778;

public class WindowsEvent4778Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Session: " +
                "Session Name: RDP-Tcp#0 " +
                "Additional Information: " +
                "Client Name: J00A2054 " +
                "Client Address: 211.75.72.225 " +
                "當使用者重新連線到現有的終端機服務工作階段，或使用者使用「快速切換使用者」切換到現有桌面，就會產生這個事件。";

        WindowsEvent4778 evt = parse2Object("4778", content, Locale.US);
        Assert.assertEquals("4778", evt.getEventId());

        Assert.assertEquals("103PRSDB", evt.getAccountName());
        Assert.assertEquals("WORKGROUP", evt.getAccountDomain());
        Assert.assertEquals("0x3e7", evt.getLogonId());

        Assert.assertEquals("RDP-Tcp#0", evt.getSessionName());

        Assert.assertEquals("J00A2054", evt.getClientName());
        Assert.assertEquals("211.75.72.225", evt.getClientAddress());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Account Name: 103PRSDB " +
                "Account Domain: WORKGROUP " +
                "Logon ID: 0x3e7 " +
                "Session: " +
                "Session Name: RDP-Tcp#0 " +
                "Additional Information: " +
                "Client Name: J00A2054 " +
                "Client Address: 211.75.72.225 " +
                "當使用者重新連線到現有的終端機服務工作階段，或使用者使用「快速切換使用者」切換到現有桌面，就會產生這個事件。";

        Assert.assertNotNull(parse2Map("4778", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "帳戶名稱: 103PRSDB " +
                "帳戶網域: WORKGROUP " +
                "登入識別碼: 0x3e7 " +
                "工作階段: " +
                "工作階段名稱: RDP-Tcp#0 " +
                "其他資訊: " +
                "用戶端名稱: J00A2054 " +
                "用戶端位址: 211.75.72.225 " +
                "當使用者重新連線到現有的終端機服務工作階段，或使用者使用「快速切換使用者」切換到現有桌面，就會產生這個事件。";

        Assert.assertNotNull(parse2Map("4778", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("accountName"), "103PRSDB");
        Assert.assertEquals(result.get("accountDomain"), "WORKGROUP");
        Assert.assertEquals(result.get("logonId"), "0x3e7");
        Assert.assertEquals(result.get("sessionName"), "RDP-Tcp#0");
        Assert.assertEquals(result.get("clientName"), "J00A2054");
        Assert.assertEquals(result.get("clientAddress"), "211.75.72.225");
    }
}
