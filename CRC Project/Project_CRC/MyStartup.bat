set JAVA_HOME=C:\Programmi\Java\jdk1.6.0_22
set TOMCAT_HOME=c:\SOAP\jakarta-tomcat-3.2.4
set CLASSPATH=C:\SOAP\soap-2_2\lib\soap.jar
set CLASSPATH=%CLASSPATH%;C:\SOAP\javamail-1.2\mail.jar
set CLASSPATH=%CLASSPATH%;C:\SOAP\jaf-1.0.2\activation.jar
set CLASSPATH=%CLASSPATH%;C:\SOAP\xerces-1_2_3\xerces.jar
set CLASSPATH=%CLASSPATH%;C:\SOAP\mysql-connector-java-5.1.5\mysql-connector-java-5.1.15-bin.jar
set CLASSPATH=%CLASSPATH%;C:\SOAP\jakarta-tomcat-3.2.4\webapps\soap\WEB-INF\classes
set CLASSPATH=%CLASSPATH%;C:\SOAP\soap-2_2\webapps
set CLASSPATH=%CLASSPATH%;C:\php
set CLASSPATH=%CLASSPATH%;C:\php\ext
/c start /MIN
%TOMCAT_HOME%\bin\startup.bat
/c start /MIN