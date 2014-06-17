set JAVA_HOME=C:\Programmi\Java\jdk1.6.0_22
set CLASSPATH=C:\SOAP\soap-2_2\lib\soap.jar
set CLASSPATH=%CLASSPATH%;C:\SOAP\javamail-1.2\mail.jar
set CLASSPATH=%CLASSPATH%;C:\SOAP\jaf-1.0.2\activation.jar
set CLASSPATH=%CLASSPATH%;C:\SOAP\xerces-1_2_3\xerces.jar
C:\programmi\java\jdk1.6.0_22\bin\java.exe org.apache.soap.server.ServiceManagerClient http://localhost:8080/soap/servlet/rpcrouter deploy Server.xml
pause