example-di-spring
===========================
> This is an example **Message application**, which simulates sending messages. <br>
> The application has currently two modules: 
>- *Facebook module*
>- *Mail module*
>
> The modules are not fully implemented, because their main purpose is to illustrate the usage of [Spring DI framework](https://spring.io/guides).


What can you find in this project?
----------------------------------------------
 - Project setup - [pom.xml](https://github.com/Iretha/tutorials/blob/master/example-di-spring/pom.xml)
	 - Maven - building a project
	 - Spring DI framework
```xml		
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.12</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>4.3.3.RELEASE</version>
	</dependency>
````

 - Spring HOW-TOs, illustrated in the application
	 - TODO
	 
 - Entry Point
	 - [Message Client](https://github.com/Iretha/tutorials/blob/master/example-di-spring/src/test/java/com/smdev/spring/msg/MessageAppTest.java)
