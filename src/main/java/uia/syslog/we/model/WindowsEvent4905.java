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
package uia.syslog.we.model;

/**
 * An attempt was made to unregister a security event source.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4905 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String processId;

    private String processName;

    private String sourceName;

    private String eventSourceId;

    public WindowsEvent4905() {
        super("Security-Auditing", "4905");
    }

    public String getSecurityId() {
        return this.securityId;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountDomain() {
        return this.accountDomain;
    }

    public String getLogonId() {
        return this.logonId;
    }

    public String getProcessId() {
        return this.processId;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public String getEventSourceId() {
        return this.eventSourceId;
    }

}
