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
 * The handle to an object was closed
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4658 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String objectServer;

    private String handleId;

    private String processId;

    private String processName;

    public WindowsEvent4658() {
        super("Security-Auditing", "4658");
    }

    public String getSecurityId() {
        return this.securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountDomain() {
        return this.accountDomain;
    }

    public void setAccountDomain(String accountDomain) {
        this.accountDomain = accountDomain;
    }

    public String getLogonId() {
        return this.logonId;
    }

    public void setLogonId(String logonId) {
        this.logonId = logonId;
    }

    public String getObjectServer() {
        return this.objectServer;
    }

    public void setObjectServer(String objectServer) {
        this.objectServer = objectServer;
    }

    public String getHandleId() {
        return this.handleId;
    }

    public void setHandleId(String handleId) {
        this.handleId = handleId;
    }

    public String getProcessId() {
        return this.processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
