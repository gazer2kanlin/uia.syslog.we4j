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

import uia.syslog.we.model.WindowsEvent4698;

public class WindowsEvent4698Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Task Information: " +
                "Task Name: NiteWork" +
                "Task Content: <html><body>\"good\" &nsbp <hr /></body></html>";

        WindowsEvent4698 evt = parse2Object("4698", content, Locale.US);
        Assert.assertEquals("4698", evt.getEventId());

        Assert.assertEquals("ACME\\Administrator", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("ACME", evt.getAccountDomain());
        Assert.assertEquals("0x1f41e", evt.getLogonId());

        Assert.assertEquals("NiteWork", evt.getTaskName());
        Assert.assertEquals("<html><body>\"good\" &nsbp <hr /></body></html>", evt.getTaskNewContent());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID:  ACME\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  ACME " +
                "Logon ID:  0x1f41e " +
                "Task Information: " +
                "Task Name: NiteWork" +
                "Task Content: <html><body>\"good\" &nsbp <hr /></body></html>";

        Assert.assertNotNull(parse2Map("4698", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  ACME\\Administrator " +
                "帳戶名稱:  Administrator " +
                "帳戶網域:  ACME " +
                "登入識別碼:  0x1f41e " +
                "工作資訊: " +
                "工作名稱: NiteWork" +
                "工作新內容: <html><body>\"good\" &nsbp <hr /></body></html>";

        Assert.assertNotNull(parse2Map("4698", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "ACME\\Administrator");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "ACME");
        Assert.assertEquals(result.get("logonId"), "0x1f41e");
        Assert.assertEquals(result.get("taskName"), "NiteWork");
        Assert.assertEquals(result.get("taskNewContent"), "<html><body>\"good\" &nsbp <hr /></body></html>");
    }
}
