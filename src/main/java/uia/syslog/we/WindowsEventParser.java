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
package uia.syslog.we;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import uia.syslog.we.model.xml.AbstractPropertyType;
import uia.syslog.we.model.xml.PropertySetType;
import uia.syslog.we.model.xml.PropertyType;
import uia.syslog.we.model.xml.WindowsEventType;

/**
 * Windows event parser.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEventParser {

    private String _event;

    private PropertyType _type;

    private int _valueStartIndex;

    private String _content;

    private ResourceBundle bundle;

    private LinkedHashMap<String, Object> properties;

    /**
     * Constructor.
     *
     * @param locale Locale.
     */
    public WindowsEventParser(Locale locale) {
        this.bundle = ResourceBundle.getBundle("uia/syslog/we/Events", locale);
        this.properties = new LinkedHashMap<String, Object>();
    }

    /**
     * Parse log content with specific description of structure.
     * @param content Content.
     * @param weType description of structure.
     * @return Result.
     * @throws WindowsEventException Raise if parsing failed.
     */
    public synchronized Map<String, Object> toMap(String content, WindowsEventType weType) throws WindowsEventException {
        this.properties.clear();
        this._event = weType.getId();
        this._type = null;
        this._valueStartIndex = -1;
        this._content = content;

        List<AbstractPropertyType> props = weType.getPropertySetOrProperty();
        for (AbstractPropertyType prop : props) {
            if (prop instanceof PropertySetType) {
                walk((PropertySetType) prop);
            }
            else if (prop instanceof PropertyType) {
                walk((PropertyType) prop);
            }
        }

        writeProperty(content.length());

        return this.properties;
    }

    /**
     * Parse log content with specific description of structure.
     * @param content Content.
     * @param weType description of structure.
     * @return Result.
     * @throws WindowsEventException Raise if parsing failed.
     */
    @SuppressWarnings("unchecked")
    public synchronized <T> T toObject(String content, WindowsEventType weType) throws WindowsEventException {
        Map<String, Object> map = toMap(content, weType);

        String className = "uia.syslog.we.model.WindowsEvent" + weType.getId();

        Class<T> cls = null;
        try {
            cls = (Class<T>) Class.forName(className);
        }
        catch (ClassNotFoundException e) {
            throw new WindowsEventException(className + " not found", e);
        }

        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(map), cls);
    }

    private void walk(PropertySetType propType) throws WindowsEventException {
        String id = translate(propType.getTranslate());
        if (id == null) {
            throw new WindowsEventException(this._event + "> '" + propType.getId() + "' can't be translated.");
        }

        int index = id != null ? this._content.indexOf(id + ": ", this._valueStartIndex) : -1;
        if (index >= 0) {
            writeProperty(index);

            this._type = null;
            this._valueStartIndex = index + id.length() + 2;

        }

        // TODO: is it right? check event 4656.
        List<AbstractPropertyType> props = propType.getPropertySetOrProperty();
        for (AbstractPropertyType prop : props) {
            if (prop instanceof PropertySetType) {
                walk((PropertySetType) prop);
            }
            else if (prop instanceof PropertyType) {
                walk((PropertyType) prop);
            }
        }
    }

    private void walk(PropertyType propType) throws WindowsEventException {
        String id = translate(propType.getTranslate());
        if (id == null) {
            throw new WindowsEventException(this._event + "> '" + propType.getId() + "' can't be translated.");
        }

        int index = id != null ? this._content.indexOf(id + ": ", this._valueStartIndex) : -1;
        if (index >= 0) {
            writeProperty(index);

            this._type = propType;
            this._valueStartIndex = index + id.length() + 2;
        }
    }

    private void writeProperty(int valueEndIndex) throws WindowsEventException {
        if (this._valueStartIndex < 0) {
            this.properties.put("logHeader", this._content.substring(0, valueEndIndex).trim());
        }

        if (this._type == null || this._type.isIgnore()) {
            return;
        }

        String _value = this._content.substring(this._valueStartIndex, valueEndIndex).trim();
        if (!"".equals(this._type.getSplitStr())) {
            _value = _value.split(this._type.getSplitStr())[this._type.getValueIndex()];
        }

        if ("INT".equalsIgnoreCase(this._type.getDataType())) {
            try {
                this.properties.put(this._type.getId(), Integer.parseInt(_value));
            }
            catch (Exception ex) {
                this.properties.put(this._type.getId(), 0);
            }
        }
        else {
            this.properties.put(this._type.getId(), _value);
        }
    }

    private String translate(String key) {
        return this.bundle.containsKey(key) ? this.bundle.getString(key) : null;
    }
}
