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

import uia.syslog.we.WindowsEventFactory;
import uia.syslog.we.WindowsEventParser;
import uia.syslog.we.model.xml.WindowsEventType;

public abstract class WindowsEventTest {

    protected Map<String, Object> parse2Map(String id, String content, Locale locale) throws Exception {
        WindowsEventFactory factory = new WindowsEventFactory();
        WindowsEventType weType = factory.find(id);
        WindowsEventParser parser = new WindowsEventParser(locale);
        Map<String, Object> result = parser.toMap(content, weType);

        System.out.println(weType.getId() + "(" + weType.getName() + ")> " + result);
        validate(result);

        return result;
    }

    protected <T> T parse2Object(String id, String content, Locale locale) throws Exception {
        WindowsEventFactory factory = new WindowsEventFactory();
        WindowsEventType weType = factory.find(id);
        WindowsEventParser parser = new WindowsEventParser(locale);
        return parser.toObject(content, weType);
    }

    protected abstract void validate(Map<String, Object> result);
}
