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
 * The domain controller attempted to validate the credentials for an account.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4776 extends WindowsEvent {

    private String authenticationPackage;

    private String logonAccount;

    private String sourceWorkstation;

    private String errorCode;

    public WindowsEvent4776() {
        super("Security-Auditing", "4776");
    }

    public String getAuthenticationPackage() {
        return this.authenticationPackage;
    }

    public String getLogonAccount() {
        return this.logonAccount;
    }

    public String getSourceWorkstation() {
        return this.sourceWorkstation;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
