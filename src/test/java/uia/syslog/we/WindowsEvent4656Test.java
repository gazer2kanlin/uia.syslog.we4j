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

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import uia.syslog.we.model.WindowsEvent4656;

public class WindowsEvent4656Test extends WindowsEventTest {

    @Test
    public void testObject() throws Exception {
        String content = "Subject: " +
                "Security ID:  WIN-R9H529RIO4Y\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  WIN-R9H529RIO4Y " +
                "Logon ID:  0x1fd23 " +
                "Object: " +
                "Object Server:  Security " +
                "Object Type:  File " +
                "Object Name:  C:\\Users\\Administrator\\testfolder\\New Text Document.txt " +
                "Handle ID:  0xb8 " +
                "Resource Attributes: S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\")) " +
                "Process Information: " +   // maybe missing
                "Process ID: 0xed0 " +
                "Process Name: C:\\Windows\\System32\\notepad.exe " +
                "Access Request Information: " +
                "Transaction ID:  {00000000-0000-0000-0000-000000000000} " +
                "Accesses:  READ_CONTROL " +
                "SYNCHRONIZE " +
                "ReadData (or ListDirectory) " +
                "ReadEA " +
                "ReadAttributes   " +
                "Access Mask:  0x120089 " +
                "Privileges Used for Access Check: - " +
                "Restricted SID Count: 5 ";

        WindowsEvent4656 evt = parse2Object("4656", content, Locale.US);
        Assert.assertEquals("4656", evt.getEventId());

        Assert.assertEquals("WIN-R9H529RIO4Y\\Administrator", evt.getSecurityId());
        Assert.assertEquals("Administrator", evt.getAccountName());
        Assert.assertEquals("WIN-R9H529RIO4Y", evt.getAccountDomain());
        Assert.assertEquals("0x1fd23", evt.getLogonId());

        Assert.assertEquals("0xb8", evt.getHandleId());
        Assert.assertEquals("Security", evt.getObjectServer());
        Assert.assertEquals("File", evt.getObjectType());
        Assert.assertEquals("C:\\Users\\Administrator\\testfolder\\New Text Document.txt", evt.getObjectName());
        Assert.assertEquals("0xb8", evt.getHandleId());
        Assert.assertEquals("S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\"))", evt.getResourceAttributes());

        Assert.assertEquals("0xed0", evt.getProcessId());
        Assert.assertEquals("C:\\Windows\\System32\\notepad.exe", evt.getProcessName());

        Assert.assertEquals("{00000000-0000-0000-0000-000000000000}", evt.getTransactionId());
        Assert.assertEquals("READ_CONTROL SYNCHRONIZE ReadData (or ListDirectory) ReadEA ReadAttributes", evt.getAccesses());
        Assert.assertEquals("0x120089", evt.getAccessMask());
        Assert.assertEquals("-", evt.getPrivilegesUsedForAccessCheck());
        Assert.assertEquals(5, evt.getRestrictedSIDCount());
    }

    @Test
    public void testUS1() throws Exception {
        String content = "Subject: " +
                "Security ID:  WIN-R9H529RIO4Y\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  WIN-R9H529RIO4Y " +
                "Logon ID:  0x1fd23 " +
                "Object: " +
                "Object Server:  Security " +
                "Object Type:  File " +
                "Object Name:  C:\\Users\\Administrator\\testfolder\\New Text Document.txt " +
                "Handle ID:  0xb8 " +
                "Resource Attributes: S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\")) " +
                "Process Information: " +	// maybe missing
                "Process ID: 0xed0 " +
                "Process Name: C:\\Windows\\System32\\notepad.exe " +
                "Access Request Information: " +
                "Transaction ID:  {00000000-0000-0000-0000-000000000000} " +
                "Accesses:  READ_CONTROL " +
                "SYNCHRONIZE " +
                "ReadData (or ListDirectory) " +
                "ReadEA " +
                "ReadAttributes   " +
                "Access Mask:  0x120089 " +
                "Privileges Used for Access Check: - " +
                "Restricted SID Count: 5 ";

        Assert.assertEquals(17, parse2Map("4656", content, Locale.US).size());
    }

    @Test
    public void testUS2() throws Exception {
        String content = "Subject: " +
                "Security ID:  WIN-R9H529RIO4Y\\Administrator " +
                "Account Name:  Administrator " +
                "Account Domain:  WIN-R9H529RIO4Y " +
                "Logon ID:  0x1fd23 " +
                "Object: " +
                "Object Server:  Security " +
                "Object Type:  File " +
                "Object Name: C:\\Users\\Administrator\\testfolder\\New Text Document.txt " +
                "Handle ID: 0xb8 " +
                "Resource Attributes: S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\")) " +
                "Process ID: 0xed0 " +
                "Process Name: C:\\Windows\\System32\\notepad.exe " +
                "Access Request Information: " +
                "Transaction ID:  {00000000-0000-0000-0000-000000000000} " +
                "Accesses:  READ_CONTROL " +
                "SYNCHRONIZE " +
                "ReadData (or ListDirectory) " +
                "ReadEA " +
                "ReadAttributes   " +
                "Access Mask:  0x120089 " +
                "Privileges Used for Access Check: - " +
                "Restricted SID Count: 5 ";

        Assert.assertEquals(17, parse2Map("4656", content, Locale.US).size());
    }

    @Test
    public void testTW1() throws Exception {
        String content = "主旨: " +
                "安全性識別碼:  WIN-R9H529RIO4Y\\Administrator " +
                "帳戶名稱:  Administrator " +
                "帳戶網域:  WIN-R9H529RIO4Y " +
                "登入識別碼:  0x1fd23 " +
                "物件: " +
                "物件伺服器:  Security " +
                "物件類型:  File " +
                "物件名稱:  C:\\Users\\Administrator\\testfolder\\New Text Document.txt " +
                "控制代碼識別碼:  0xb8 " +
                "資源屬性: S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\"))" +
                "處理程序資訊: " +
                "處理程序識別碼:  0xed0 " +
                "處理程序名稱:  C:\\Windows\\System32\\notepad.exe " +
                "存取要求資訊: " +
                "交易識別碼:  {00000000-0000-0000-0000-000000000000} " +
                "存取:  READ_CONTROL " +
                "SYNCHRONIZE " +
                "ReadData (or ListDirectory) " +
                "ReadEA " +
                "ReadAttributes   " +
                "存取遮罩:  0x120089 " +
                "存取檢查所使用的權限: - " +
                "限制的 SID 數目: 5 ";

        Assert.assertEquals(17, parse2Map("4656", content, Locale.TAIWAN).size());
    }

    @Override
    protected void validate(Map<String, Object> result) {
        Assert.assertEquals(result.get("securityId"), "WIN-R9H529RIO4Y\\Administrator");
        Assert.assertEquals(result.get("accountName"), "Administrator");
        Assert.assertEquals(result.get("accountDomain"), "WIN-R9H529RIO4Y");
        Assert.assertEquals(result.get("logonId"), "0x1fd23");

        Assert.assertEquals(result.get("objectServer"), "Security");
        Assert.assertEquals(result.get("objectType"), "File");
        Assert.assertEquals(result.get("objectName"), "C:\\Users\\Administrator\\testfolder\\New Text Document.txt");
        Assert.assertEquals(result.get("handleId"), "0xb8");
        Assert.assertEquals(result.get("resourceAttributes"), "S:AI(RA;ID;;;;WD;(\"Project_MS\",TS,0x10020,\"Transmogrifier\"))");

        Assert.assertEquals(result.get("processId"), "0xed0");
        Assert.assertEquals(result.get("processName"), "C:\\Windows\\System32\\notepad.exe");

        Assert.assertEquals(result.get("transactionId"), "{00000000-0000-0000-0000-000000000000}");
        Assert.assertEquals(result.get("accesses"), "READ_CONTROL SYNCHRONIZE ReadData (or ListDirectory) ReadEA ReadAttributes");
        Assert.assertEquals(result.get("accessMask"), "0x120089");
        Assert.assertEquals(result.get("privilegesUsedForAccessCheck"), "-");
        Assert.assertEquals((Integer) result.get("restrictedSIDCount"), 5, 0);
    }
}
