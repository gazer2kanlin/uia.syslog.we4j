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
 * A logon was attempted using explicit credentials.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4648 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String logonGuid;

    private String credentialsAccountName;

    private String credentialsAccountDomain;

    private String credentialsLogonGuid;

    private String targetServerName;

    private String additionalInformation;

    private String processId;

    private String processName;

    private String networkAddress;

    private int port;

    public WindowsEvent4648() {
        super("Security-Auditing", "4648");
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

    public String getLogonGuid() {
        return this.logonGuid;
    }

    public String getCredentialsAccountName() {
        return this.credentialsAccountName;
    }

    public String getCredentialsAccountDomain() {
        return this.credentialsAccountDomain;
    }

    public String getCredentialsLogonGuid() {
        return this.credentialsLogonGuid;
    }

    public String getTargetServerName() {
        return this.targetServerName;
    }

    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    public String getProcessId() {
        return this.processId;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getNetworkAddress() {
        return this.networkAddress;
    }

    public int getPort() {
        return this.port;
    }

}
