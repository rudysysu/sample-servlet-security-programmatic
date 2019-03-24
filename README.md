## tomcat configuration

### server.xml
```
<Connector connectionTimeout="20000" port="8082" protocol="HTTP/1.1" redirectPort="8443"/>
```

### tomcat-users.xml
```
<role rolename="user"/>
<user username="rudy" password="rudy" roles="user"/>
```

## application endpoint
- http://localhost:8082/sample-servlet-security-programmatic/user