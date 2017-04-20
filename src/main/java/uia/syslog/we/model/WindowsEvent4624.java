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
 * An account was successfully logged on.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4624 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String logonType;

    private String restrictedAdminMode;

    private String virtualAccount;

    private String elevatedToken;

    private String impersonationLevel;

    private String newSecurityId;

    private String newAccountName;

    private String newAccountDomain;

    private String newLogonId;

    private String linkedLogonId;

    private String networkAccountName;

    private String networkAccountDomain;

    private String newLogonGuid;

    private String processId;

    private String processName;

    private String workstationName;

    private String sourceNetworkAddress;

    private int sourcePort;

    private String logonProcess;

    private String authenticationPackage;

    private String transitedServices;

    private String packageNameNTLMOnly;

    private int keyLength;

    public WindowsEvent4624() {
        super("Security-Auditing", "4624");
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

    public String getLogonType() {
        return this.logonType;
    }

    public String getRestrictedAdminMode() {
        return this.restrictedAdminMode;
    }

    public String getVirtualAccount() {
        return this.virtualAccount;
    }

    public String getElevatedToken() {
        return this.elevatedToken;
    }

    public String getImpersonationLevel() {
        return this.impersonationLevel;
    }

    public String getNewSecurityId() {
        return this.newSecurityId;
    }

    public String getNewAccountName() {
        return this.newAccountName;
    }

    public String getNewAccountDomain() {
        return this.newAccountDomain;
    }

    public String getNewLogonId() {
        return this.newLogonId;
    }

    public String getLinkedLogonId() {
        return this.linkedLogonId;
    }

    public String getNetworkAccountName() {
        return this.networkAccountName;
    }

    public String getNetworkAccountDomain() {
        return this.networkAccountDomain;
    }

    public String getNewLogonGuid() {
        return this.newLogonGuid;
    }

    public String getProcessId() {
        return this.processId;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getWorkstationName() {
        return this.workstationName;
    }

    public String getSourceNetworkAddress() {
        return this.sourceNetworkAddress;
    }

    public int getSourcePort() {
        return this.sourcePort;
    }

    public String getLogonProcess() {
        return this.logonProcess;
    }

    public String getAuthenticationPackage() {
        return this.authenticationPackage;
    }

    public String getTransitedServices() {
        return this.transitedServices;
    }

    public String getPackageNameNTLMOnly() {
        return this.packageNameNTLMOnly;
    }

    public int getKeyLength() {
        return this.keyLength;
    }

}
