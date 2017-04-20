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
 * A Windows Filtering Platform sub-layer has been changed.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent5450 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String processId;

    private String providerId;

    private String providerName;

    private String changeType;

    private String subLayerId;

    private String subLayerName;

    private String subLayerType;

    private String weight;

    public WindowsEvent5450() {
        super("Security-Auditing", "5450");
    }

    public String getSecurityId() {
        return this.securityId;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getProcessId() {
        return this.processId;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getChangeType() {
        return this.changeType;
    }

    public String getSubLayerId() {
        return this.subLayerId;
    }

    public String getSubLayerName() {
        return this.subLayerName;
    }

    public String getSubLayerType() {
        return this.subLayerType;
    }

    public String getWeight() {
        return this.weight;
    }
}
