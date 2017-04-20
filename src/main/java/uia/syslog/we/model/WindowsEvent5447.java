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
 * A Windows Filtering Platform filter has been changed.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent5447 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String processId;

    private String providerId;

    private String providerName;

    private String changeType;

    private String filterId;

    private String filterName;

    private String filterType;

    private String filterRunTimeId;

    private String layerId;

    private String layerName;

    private String layerRunTimeId;

    private String calloutId;

    private String calloutName;

    private String weight;

    private String condition;

    private String filterAction;

    public WindowsEvent5447() {
        super("Security-Auditing", "5447");
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

    public String getFilterId() {
        return this.filterId;
    }

    public String getFilterName() {
        return this.filterName;
    }

    public String getFilterType() {
        return this.filterType;
    }

    public String getFilterRunTimeId() {
        return this.filterRunTimeId;
    }

    public String getLayerId() {
        return this.layerId;
    }

    public String getLayerName() {
        return this.layerName;
    }

    public String getLayerRunTimeId() {
        return this.layerRunTimeId;
    }

    public String getCalloutId() {
        return this.calloutId;
    }

    public String getCalloutName() {
        return this.calloutName;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getFilterAction() {
        return this.filterAction;
    }

}
