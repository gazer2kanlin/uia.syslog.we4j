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
 * A user account was enabled.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4722 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String targetSecurityId;

    private String targetAccountName;

    private String targetAccountDomain;

    public WindowsEvent4722() {
        super("Security-Auditing", "4722");
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

    public String getTargetSecurityId() {
        return this.targetSecurityId;
    }

    public String getTargetAccountName() {
        return this.targetAccountName;
    }

    public String getTargetAccountDomain() {
        return this.targetAccountDomain;
    }
}
