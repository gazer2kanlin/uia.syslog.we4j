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

import uia.syslog.we.model.WindowsEvent5450;

public class WindowsEvent5450Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "主旨: " +
                "安全性識別碼: S-1-5-18 " +
                "帳戶名稱: NT AUTHORITY/SYSTEM " +
                "處理程序資訊: " +
                "處理程序識別碼: 4 " +
                "提供者資訊: " +
                "提供者識別碼: {D4BD4A0F-7591-4DA2-AE67-3AA97C3C34C2} " +
                "提供者名稱: Symantec IPS Provider " +
                "變更資訊: " +
                "變更類型: 刪除 " +
                "子階層資訊: " +
                "子階層識別碼: {14FE6222-5323-42BD-B277-E05A8DFC1169} " +
                "子階層名稱: Symantec Network Driver Sub layer " +
                "子階層類型: 不持續 " +
                "其他資訊: " +
                "權數: 5120";

        WindowsEvent5450 evt = parse2Object("5450", content, Locale.TAIWAN);
        Assert.assertEquals("5450", evt.getEventId());

        Assert.assertEquals("S-1-5-18", evt.getSecurityId());
        Assert.assertEquals("NT AUTHORITY/SYSTEM", evt.getAccountName());

        Assert.assertEquals("4", evt.getProcessId());

        Assert.assertEquals("{D4BD4A0F-7591-4DA2-AE67-3AA97C3C34C2}", evt.getProviderId());
        Assert.assertEquals("Symantec IPS Provider", evt.getProviderName());

        Assert.assertEquals("刪除", evt.getChangeType());

        Assert.assertEquals("{14FE6222-5323-42BD-B277-E05A8DFC1169}", evt.getSubLayerId());
        Assert.assertEquals("Symantec Network Driver Sub layer", evt.getSubLayerName());
        Assert.assertEquals("不持續", evt.getSubLayerType());

        Assert.assertEquals("5120", evt.getWeight());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Subject: " +
                "Security ID: S-1-5-18 " +
                "Account Name: NT AUTHORITY/SYSTEM " +
                "Process Information: " +
                "Process ID: 4 " +
                "Provider Information: " +
                "ID: {D4BD4A0F-7591-4DA2-AE67-3AA97C3C34C2} " +
                "Name: Symantec IPS Provider " +
                "Change Information: " +
                "Change Type: 刪除 " +
                "Layer Information: " +
                "ID: {14FE6222-5323-42BD-B277-E05A8DFC1169} " +
                "Name: Symantec Network Driver Sub layer " +
                "Type: 不持續 " +
                "Additional Information: " +
                "Weight: 5120";

        Assert.assertNotNull(parse2Map("5450", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "主旨: " +
                "安全性識別碼: S-1-5-18 " +
                "帳戶名稱: NT AUTHORITY/SYSTEM " +
                "處理程序資訊: " +
                "處理程序識別碼: 4 " +
                "提供者資訊: " +
                "提供者識別碼: {D4BD4A0F-7591-4DA2-AE67-3AA97C3C34C2} " +
                "提供者名稱: Symantec IPS Provider " +
                "變更資訊: " +
                "變更類型: 刪除 " +
                "子階層資訊: " +
                "子階層識別碼: {14FE6222-5323-42BD-B277-E05A8DFC1169} " +
                "子階層名稱: Symantec Network Driver Sub layer " +
                "子階層類型: 不持續 " +
                "其他資訊: " +
                "權數: 5120";

        Assert.assertNotNull(parse2Map("5450", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "S-1-5-18");
        Assert.assertEquals(result.get("accountName"), "NT AUTHORITY/SYSTEM");

        Assert.assertEquals(result.get("processId"), "4");

        Assert.assertEquals(result.get("providerId"), "{D4BD4A0F-7591-4DA2-AE67-3AA97C3C34C2}");
        Assert.assertEquals(result.get("providerName"), "Symantec IPS Provider");

        Assert.assertEquals(result.get("changeType"), "刪除");

        Assert.assertEquals(result.get("subLayerId"), "{14FE6222-5323-42BD-B277-E05A8DFC1169}");
        Assert.assertEquals(result.get("subLayerName"), "Symantec Network Driver Sub layer");
        Assert.assertEquals(result.get("subLayerType"), "不持續");

        Assert.assertEquals(result.get("weight"), "5120");
    }
}
