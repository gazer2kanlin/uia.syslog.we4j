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
 * An account failed to log on.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4625 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String logonType;

    private String failedSecurityId;

    private String failedAccountName;

    private String failedAccountDomain;

    private String failureReason;

    private String failureStatus;

    private String failureSubStatus;

    private String callerProcessId;

    private String callerProcessName;

    private String workstationName;

    private String sourceNetworkAddress;

    private int sourcePort;

    private String logonProcess;

    private String authenticationPackage;

    private String transitedServices;

    private String packageNameNTLMOnly;

    private int keyLength;

    public WindowsEvent4625() {
        super("Security-Auditing", "4625");
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

    public String getFailedSecurityId() {
        return this.failedSecurityId;
    }

    public String getFailedAccountName() {
        return this.failedAccountName;
    }

    public String getFailedAccountDomain() {
        return this.failedAccountDomain;
    }

    public String getFailureReason() {
        return this.failureReason;
    }

    public String getFailureStatus() {
        return this.failureStatus;
    }

    public String getFailureSubStatus() {
        return this.failureSubStatus;
    }

    public String getCallerProcessId() {
        return this.callerProcessId;
    }

    public String getCallerProcessName() {
        return this.callerProcessName;
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
