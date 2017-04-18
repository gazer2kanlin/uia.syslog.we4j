UIA Windows Event Parser
================

[![Build Status](https://travis-ci.org/gazer2kanlin/uia.syslog.we4j.svg?branch=master)](https://travis-ci.org/gazer2kanlin/uia.syslog.we4j)
[![Codecov](https://img.shields.io/codecov/c/github/gazer2kanlin/uia.syslog.we4j.svg)](https://codecov.io/gh/gazer2kanlin/uia.syslog.we4j)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c48a821f715549adafca7dd853fc71eb)](https://www.codacy.com/app/gazer2kanlin/uia-syslog-we4j?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=gazer2kanlin/uia.syslog.we4j&amp;utm_campaign=Badge_Grade)
[![License](https://img.shields.io/github/license/gazer2kanlin/uia.syslog.we4j.svg)](LICENSE)

Parse windows event to key-value pairs (Map) or POJO.

## Locale Supported

* en_US - English

* zh_TW - Traditional Chinese (繁體中文)

## Event Supported (current: 42)

|ID|Description|Key|
|--|----|---|
| 1105 | Event log automatic backup | - |
| 1105 | Event log automatic backup | - |
| 4611 | A trusted logon process has been registered with the Local Security Authority | - |
| 4616 | The system time was changed | - |
| 4624 | An account was successfully logged on | - |
| 4625 | An account failed to log on | - |
| 4634 | An account was logged off | - |
| 4647 | User initiated logoff | - |
| 4648 | A logon was attempted using explicit credentials | - |
| 4656 | A handle to an object was requested | - |
| 4658 | The handle to an object was closed | - |
| 4663 | An attempt was made to access an object | - |
| 4672 | Special privileges assigned to new logon | - |
| 4673 | A privileged service was called | - |
| 4690 | An attempt was made to duplicate a handle to an object | - |
| 4702 | A scheduled task was updated | - |
| 4722 | A user account was enabled | - |
| 4723 | An attempt was made to change an account's password | - |
| 4724 | An attempt was made to reset an accounts password | - |
| 4725 | A user account was disabled | - |
| 4738 | A user account was changed | - |
| 4740 | A user account was locked out | - |
| 4776 | The domain controller attempted to validate the credentials for an account | - |
| 4778 | A session was reconnected to a Window Station | - |
| 4779 | A session was disconnected from a Window Station | - |
| 4800 | The workstation was locked | - |
| 4904 | An attempt was made to register a security event source | - |
| 4905 | An attempt was made to unregister a security event source | - |
| 4946 | A change has been made to Windows Firewall exception list. A rule was added | - |
| 4947 | A change has been made to Windows Firewall exception list. A rule was modified | - |
| 4985 | A logon was attempted using explicit credentials | - |
| 5058 | Key file operation | - |
| 5061 | Cryptographic operation | - |
| 5140 | A network share object was accessed | - |
| 5145 | A network share object was checked to see whether client can be granted desired access | - |
| 5152 | The Windows Filtering Platform blocked a packet | - |
| 5154 | The Windows Filtering Platform has permitted an application or service to listen on a port for incoming connections | - |
| 5156 | The Windows Filtering Platform has allowed a connection | - |
| 5158 | he Windows Filtering Platform has permitted a bind to a local port | - |
| 5446 | A Windows Filtering Platform callout has been changed | - |
| 5447 | A Windows Filtering Platform filter has been changed | - |
| 5448 | A Windows Filtering Platform provider has been changed | - |
| 5450 | A Windows Filtering Platform sub-layer has been changed | - |

## Example

Event: 5154

#### English
``` yaml
Application Information:

   Process ID:  1647
   Application Name: dns.exe

Network Information:

   Source Address:  192.168.5.3
   Source Port: 1999
   Protocol:  6

Filter Information:

   Filter Run-Time ID: 14411
   Layer Name:  Listen
   Layer Run-Time ID: 36
```

#### Traditional Chinese (繁體中文)
``` yaml
應用程式資訊:

    處理程序識別碼: 1648
    應用程式名稱: dns.exe

網路資訊:

    來源位址: 192.168.5.3
    來源連接埠: 1999
    通訊協定:  6

篩選器資訊:

    篩選器執行階段識別碼: 14411
    階層名稱:  Listen
    階層執行階段識別碼: 36
```
#### Java Code

``` Java
WindowsEventFactory factory = new WindowsEventFactory();
WindowsEventType weType = factory.find("5154");

// US
WindowsEventParser parserUS = new WindowsEventParser(Loacle.US);
Map<String, Object> resultUS = parser.toMap(contentUS, weType);
WindowsEvent5154 evtUS = parser.toObject(contentUS, weType);

// Traditional Chinese (繁體中文)
WindowsEventParser parserTW = new WindowsEventParser(Loacle.TAIWAN);
Map<String, Object> resultTW = parser.toMap(contentTW, weType);
WindowsEvent5154 evtTW = parser.toObject(contentTW, weType);
```

#### Result (Map)
``` yaml
procesId: "1647"
applicationName: "dns.exe"
sourceAddress: "192.168.5.3"
sourcePort: "1999"
protocol: "6"
filterRunTimeId: "14411"
layerName: "Listen"
layerRunTimeId: "36"
```

## Maven
pom.xml in your project:
```
<dependency>
    <groupId>uia</groupId>
    <artifactId>syslog.we</artifactId>
    <version>0.0.1</version>
</dependency>
```

## External links
[Ultimate Windows Security](https://www.ultimatewindowssecurity.com/securitylog/encyclopedia/default.aspx)


## Copyright and License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
