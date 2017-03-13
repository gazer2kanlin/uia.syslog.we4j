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

import java.io.InputStream;
import java.util.HashMap;

import org.simpleframework.xml.core.Persister;

import uia.syslog.we.model.xml.WindowsEventType;
import uia.syslog.we.model.xml.WindowsEventsType;

/**
 * Definitions of windows events.
 *
 * @author Kyle K. Lin
 *
 */
public final class WindowsEventFactory {

    private final HashMap<String, WindowsEventType> events;

    /**
     * Constructor.
     *
     * @throws Exception
     */
    public WindowsEventFactory() throws Exception {
        this.events = new HashMap<String, WindowsEventType>();

        WindowsEventsType wesType = decode(WindowsEventFactory.class.getResourceAsStream("WindowsEvents.xml"));
        for (WindowsEventType we : wesType.getWindowsEvent()) {
            this.events.put(we.getId(), we);
        }
    }

    /**
     * Find a definition of structure.
     * @param id Event id.
     * @return Result.
     */
    public WindowsEventType find(String id) {
        return this.events.get(id);
    }

    private WindowsEventsType decode(InputStream stream) throws Exception {
        Persister p = new Persister();
        return p.read(WindowsEventsType.class, stream);
    }
}
