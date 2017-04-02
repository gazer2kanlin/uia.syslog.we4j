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
 * A user account was changed.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4738 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String targetSecurityId;

    private String targetAccountName;

    private String targetAccountDomain;

    private String samAccountName;

    private String displayName;

    private String userPrincipalName;

    private String homeDirectory;

    private String homeDrive;

    private String scriptPath;

    private String profilePath;

    private String userWorkstations;

    private String passwordLastSet;

    private String accountExpires;

    private String primaryGroupId;

    private String allowedToDelegateTo;

    private String oldUacValue;

    private String newUacValue;

    private String userAccountControl;

    private String userParameters;

    private String sidHistory;

    private String logonHours;

    private String privileges;

    public WindowsEvent4738() {
        super("Security-Auditing", "4738");
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

    public String getSamAccountName() {
        return this.samAccountName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getUserPrincipalName() {
        return this.userPrincipalName;
    }

    public String getHomeDirectory() {
        return this.homeDirectory;
    }

    public String getHomeDrive() {
        return this.homeDrive;
    }

    public String getScriptPath() {
        return this.scriptPath;
    }

    public String getProfilePath() {
        return this.profilePath;
    }

    public String getUserWorkstations() {
        return this.userWorkstations;
    }

    public String getPasswordLastSet() {
        return this.passwordLastSet;
    }

    public String getAccountExpires() {
        return this.accountExpires;
    }

    public String getPrimaryGroupId() {
        return this.primaryGroupId;
    }

    public String getAllowedToDelegateTo() {
        return this.allowedToDelegateTo;
    }

    public String getOldUacValue() {
        return this.oldUacValue;
    }

    public String getNewUacValue() {
        return this.newUacValue;
    }

    public String getUserAccountControl() {
        return this.userAccountControl;
    }

    public String getUserParameters() {
        return this.userParameters;
    }

    public String getSidHistory() {
        return this.sidHistory;
    }

    public String getLogonHours() {
        return this.logonHours;
    }

    public String getPrivileges() {
        return this.privileges;
    }

}
