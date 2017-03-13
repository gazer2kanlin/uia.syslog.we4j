UIA Windows Event Parser
================

[![Build Status](https://travis-ci.org/gazer2kanlin/uia.syslog.we4j.svg?branch=master)](https://travis-ci.org/gazer2kanlin/uia.syslog.we4j)
[![Codecov](https://img.shields.io/codecov/c/github/gazer2kanlin/uia.syslog.we4j.svg)](https://codecov.io/gh/gazer2kanlin/uia.syslog.we4j)
[![License](https://img.shields.io/github/license/gazer2kanlin/uia.syslog.we4j.svg)](LICENSE)

Decode windows event to key-value result.


## Locale Supported

* en_US - English

* zh_TW - Traditional Chinese

## Event Supported

* 1105 - Event log automatic backup

* 4624 - An account was successfully logged on

* 4625 - An account failed to log on

* 4634 - An account was logged off

* 4648 - A logon was attempted using explicit credentials

* 4656 - A handle to an object was requested

* 4658 - The handle to an object was closed

* 4663 - An attempt was made to access an object

* 4672 - Special privileges assigned to new logon

* 4690 - An attempt was made to duplicate a handle to an object

* 4702 - A scheduled task was updated

* 4776 - The domain controller attempted to validate the credentials for an account

* 4985 - A logon was attempted using explicit credentials

* 5154 - The Windows Filtering Platform has permitted an application or service to listen on a port for incoming connections

* 5156 - The Windows Filtering Platform has allowed a connection

* 5158 - he Windows Filtering Platform has permitted a bind to a local port



## Maven
pom.xml in your project:
```
<dependency>
    <groupId>uia</groupId>
    <artifactId>syslog.we</artifactId>
    <version>0.0.1</version>
</dependency>
```

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
