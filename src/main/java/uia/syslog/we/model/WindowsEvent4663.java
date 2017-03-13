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
 * An attempt was made to access an object
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4663 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String objectServer;

    private String objectType;

    private String objectName;

    private String handleId;

    // TODO: more parameters

    private String processId;

    private String processName;

    private String accesses;

    private String accessMask;

    // TODO: more parameters

    public WindowsEvent4663() {
        super("Security-Auditing", "4663");
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

    public String getObjectType() {
        return this.objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
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

    public String getAccesses() {
        return this.accesses;
    }

    public void setAccesses(String accesses) {
        this.accesses = accesses;
    }

    public String getAccessMask() {
        return this.accessMask;
    }

    public void setAccessMask(String accessMask) {
        this.accessMask = accessMask;
    }

}
