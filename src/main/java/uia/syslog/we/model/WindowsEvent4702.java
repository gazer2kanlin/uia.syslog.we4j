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
 * A scheduled task was updated
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4702 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String taskName;

    private String taskNewContent;

    public WindowsEvent4702() {
        super("Security-Auditing", "4702");
    }

    public String getSecurityId() {
        return securityId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountDomain() {
        return accountDomain;
    }

    public String getLogonId() {
        return logonId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskNewContent() {
        return taskNewContent;
    }
}
