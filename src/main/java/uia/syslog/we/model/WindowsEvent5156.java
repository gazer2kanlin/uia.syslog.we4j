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
 * The Windows Filtering Platform has allowed a connection.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent5156 extends WindowsEvent {

    private String processId;

    private String applicationName;

    private String direction;

    private String sourceAddress;

    private int sourcePort;

    private String destinationAddress;

    private int destinationPort;

    private String protocol;

    private String filterRunTimeId;

    private String layerName;

    private String layerRunTimeId;

    public WindowsEvent5156() {
        super("Security-Auditing", "5156");
    }

    public String getProcessId() {
        return this.processId;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getSourceAddress() {
        return this.sourceAddress;
    }

    public int getSourcePort() {
        return this.sourcePort;
    }

    public String getDestinationAddress() {
        return this.destinationAddress;
    }

    public int getDestinationPort() {
        return this.destinationPort;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getFilterRunTimeId() {
        return this.filterRunTimeId;
    }

    public String getLayerName() {
        return this.layerName;
    }

    public String getLayerRunTimeId() {
        return this.layerRunTimeId;
    }

}
