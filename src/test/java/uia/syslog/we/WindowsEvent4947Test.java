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

import uia.syslog.we.model.WindowsEvent4947;

public class WindowsEvent4947Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "AUDIT_SUCCESS Windows 防火牆的例外清單已變更。規則已經修改。 " +
                "Profile Changed: All " +
                "Modified Rule: " +
                "Rule ID: {CD8D2D3C-0794-4B78-8D89-0CBE779C5D03} " +
                "Rule Name: 8009";

        WindowsEvent4947 evt = parse2Object("4947", content, Locale.US);
        Assert.assertEquals("4947", evt.getEventId());

        Assert.assertEquals("All", evt.getProfileChanged());
        Assert.assertEquals("{CD8D2D3C-0794-4B78-8D89-0CBE779C5D03}", evt.getRuleId());
        Assert.assertEquals("8009", evt.getRuleName());
    }

    @Test
    public void testUS() throws Exception {
        String content = "AUDIT_SUCCESS Windows 防火牆的例外清單已變更。規則已經修改。 " +
                "Profile Changed: All " +
                "Modified Rule: " +
                "Rule ID: {CD8D2D3C-0794-4B78-8D89-0CBE779C5D03} " +
                "Rule Name: 8009";

        Assert.assertNotNull(parse2Map("4947", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "AUDIT_SUCCESS Windows 防火牆的例外清單已變更。規則已經修改。 " +
                "變更的設定檔: All " +
                "修改的規則: " +
                "規則識別碼: {CD8D2D3C-0794-4B78-8D89-0CBE779C5D03} " +
                "規則名稱: 8009";

        Assert.assertNotNull(parse2Map("4947", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("logHeader"), "AUDIT_SUCCESS Windows 防火牆的例外清單已變更。規則已經修改。");
        Assert.assertEquals(result.get("profileChanged"), "All");
        Assert.assertEquals(result.get("ruleId"), "{CD8D2D3C-0794-4B78-8D89-0CBE779C5D03}");
        Assert.assertEquals(result.get("ruleName"), "8009");
    }
}
