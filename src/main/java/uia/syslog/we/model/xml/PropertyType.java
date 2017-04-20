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
package uia.syslog.we.model.xml;

import org.simpleframework.xml.Attribute;

/**
 *
 * @author Kyle K. Lin
 *
 */
public class PropertyType extends AbstractPropertyType {

    @Attribute
    protected String dataType;

    @Attribute(required = false)
    protected Boolean ignore;

    @Attribute(required = false)
    protected Integer valueIndex;

    @Attribute(required = false)
    protected String splitStr;

    public PropertyType() {
        this.dataType = "String";
        this.splitStr = "";
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String value) {
        this.dataType = value;
    }

    public boolean isIgnore() {
        if (this.ignore == null) {
            return false;
        }
        else {
            return this.ignore;
        }
    }

    public void setIgnore(Boolean value) {
        this.ignore = value;
    }

    public int getValueIndex() {
        if (this.valueIndex == null) {
            return 0;
        }
        else {
            return this.valueIndex;
        }
    }

    /**
     * Sets the value of the valueIndex property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setValueIndex(Integer value) {
        this.valueIndex = value;
    }

    /**
     * Gets the value of the splitStr property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSplitStr() {
        if (this.splitStr == null) {
            return "";
        }
        else {
            return this.splitStr;
        }
    }

    public void setSplitStr(String value) {
        this.splitStr = value;
    }

}
