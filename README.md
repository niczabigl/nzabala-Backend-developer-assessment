# BACKEND-DEVELOPMENT-ASSESSMENT

@Author : Nicolas Zabala Iglesias
This project was generated with Java 6 as Spring-boot Application, and also Maven Dependency Manager

## Development back server

Git Clone this repository at `https://github.com/niczabigl/nzabala-Backend-developer-assessment` and open it as new Workspace, then update Maven Proyect. 
Run as Java Application. Server will listen at `http://localhost:8080/`. EndPoints start at this URl.
If http request fails because mock server is down. /nzabala-backend-development-assessment/src/main/resources/static has two files that mocks the response as backup.

## Deploy app manual

This is a Spring-boot application without web.xml, so we let maven-plugin set a non web.xml and just override the default parameters to deploy war into tomcat server.

Download and install tomcat server at `https://tomcat.apache.org/download-80.cgi`.
Copy between <Host></Host> tags 
<Context path="/axa" reloadable="true" docBase="path\to\war -> nzabala-backend-development-assessment\target\backend-development-assessment-0.0.1-SNAPSHOT.war" />

Deploy backend-development-assessment-0.0.1-SNAPSHOT.war into webapps tomcat folder.

Run Tomcat and Backend will be listen at `http://localhost:8080/axa/`

That url will be your API EndoPoint to set into AppConfig class in front-side app.
	

