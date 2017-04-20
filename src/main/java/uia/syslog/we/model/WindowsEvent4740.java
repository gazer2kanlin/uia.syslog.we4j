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
 * A trusted logon process has been registered with the Local Security Authority.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4740 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String lockSecurityId;

    private String lockAccountName;

    private String callerComputerName;

    public WindowsEvent4740() {
        super("Security-Auditing", "4740");
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

    public String getLockSecurityId() {
        return this.lockSecurityId;
    }

    public String getLockAccountName() {
        return this.lockAccountName;
    }

    public String getCallerComputerName() {
        return this.callerComputerName;
    }

}
