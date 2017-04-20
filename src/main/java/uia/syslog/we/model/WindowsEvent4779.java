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
 * A session was disconnected from a Window Station.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4779 extends WindowsEvent {

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String sessionName;

    private String clientName;

    private String clientAddress;

    public WindowsEvent4779() {
        super("Security-Auditing", "4779");
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

    public String getSessionName() {
        return this.sessionName;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getClientAddress() {
        return this.clientAddress;
    }

}
