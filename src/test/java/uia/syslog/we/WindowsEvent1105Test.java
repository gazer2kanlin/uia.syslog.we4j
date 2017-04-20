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

import uia.syslog.we.model.WindowsEvent1105;

public class WindowsEvent1105Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Windows Audit Log: Security " +
                "File: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx";

        WindowsEvent1105 evt = parse2Object("1105", content, Locale.US);
        Assert.assertEquals("Eventlog", evt.getEventSource());
        Assert.assertEquals("Windows Audit", evt.getLogHeader());
        Assert.assertEquals("1105", evt.getEventId());
        Assert.assertEquals("Security", evt.getLog());
        Assert.assertEquals("C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx", evt.getFile());
    }

    @Test
    public void testUS() throws Exception {
        String content = "Windows Audit Log: Security " +
                "File: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx";

        Assert.assertNotNull(parse2Map("1105", content, Locale.US));
    }

    @Test
    public void testTW() throws Exception {
        String content = "Windows Audit 記錄檔: Security " +
                "檔案: C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx";

        Assert.assertNotNull(parse2Map("1105", content, Locale.TAIWAN));
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("logHeader"), "Windows Audit");
        Assert.assertEquals(result.get("log"), "Security");
        Assert.assertEquals(result.get("file"), "C:\\Windows\\System32\\Winevt\\Logs\\Archive-Security-2007-12-11-23-55-03-007.evtx");
    }
}
