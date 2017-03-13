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
 * The Windows Filtering Platform has permitted an application or service to listen on a port for incoming connections
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent5154 extends WindowsEvent {

    private String processId;

    private String applicationName;

    private String direction;

    private String sourceAddress;

    private int sourcePort;

    private String protocol;

    private String filterRunTimeId;

    private String layerName;

    private String layerRunTimeId;

    public WindowsEvent5154() {
        super("Security-Auditing", "5154");
    }

    public String getProcessId() {
        return this.processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSourceAddress() {
        return this.sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public int getSourcePort() {
        return this.sourcePort;
    }

    public void setSourcePort(int sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getFilterRunTimeId() {
        return this.filterRunTimeId;
    }

    public void setFilterRunTimeId(String filterRunTimeId) {
        this.filterRunTimeId = filterRunTimeId;
    }

    public String getLayerName() {
        return this.layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public String getLayerRunTimeId() {
        return this.layerRunTimeId;
    }

    public void setLayerRunTimeId(String layerRunTimeId) {
        this.layerRunTimeId = layerRunTimeId;
    }
}
