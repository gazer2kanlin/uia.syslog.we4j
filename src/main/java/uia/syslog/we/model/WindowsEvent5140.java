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

public class WindowsEvent5140 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String objectType;

    private String sourceAddress;

    private int sourcePort;

    private String shareName;

    private String sharePath;

    private String accessMask;

    private String accesses;

    public WindowsEvent5140() {
        super("Security-Auditing", "5140");
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

    public String getObjectType() {
        return this.objectType;
    }

    public String getSourceAddress() {
        return this.sourceAddress;
    }

    public int getSourcePort() {
        return this.sourcePort;
    }

    public String getShareName() {
        return this.shareName;
    }

    public String getSharePath() {
        return this.sharePath;
    }

    public String getAccessMask() {
        return this.accessMask;
    }

    public String getAccesses() {
        return this.accesses;
    }

}
