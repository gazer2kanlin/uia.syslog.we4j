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
package uia.syslog.we.model.xml;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author Kyle K. Lin
 *
 */
@Root(name = "WindowsEvents")
public class WindowsEventsType {

    @ElementList(entry = "WindowsEvent", inline = true, required = false)
    protected List<WindowsEventType> windowsEvent;

    public List<WindowsEventType> getWindowsEvent() {
        if (this.windowsEvent == null) {
            this.windowsEvent = new ArrayList<WindowsEventType>();
        }
        return this.windowsEvent;
    }

}
