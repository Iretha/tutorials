example-google-guice
===========================
This is an example **Message application**, which simulates sending messages.  The application has currently two modules - *Facebook module* and *Mail module*. The modules are not fully implemented, because their main purpose is to illustrate the usage of [Google Guice DI framework](https://github.com/google/guice/wiki/GettingStarted).


What can you find in this project?
----------------------------------------------
 - Project setup - [pom.xml](https://github.com/Iretha/tutorials/blob/master/example-google-guice/pom.xml)
	 - Maven - building a project
	 - Google Guice - DI framework
> `		<dependency>
			<groupId>com.google.inject</groupId>
			<artifactId>guice</artifactId>
			<version>4.1.0</version>
		</dependency>`
		
	 - Google Guice AssistedInject - Support for factories 
> `		<dependency>
		<groupId>com.google.inject.extensions</groupId>
			<artifactId>guice-assistedinject</artifactId>
			<version>4.1.0</version>
		</dependency>`

 - Guice HOW-TOs in the application
	 - Linked Bindings
	 - Binding Annotations
	 - Custom Annotations
	 - Named Annotations
	 - Instance Bindings
	 - Constructor Bindings
	 - Setter Bindings
	 - Bindings depending on the module
	 - Creating Object Factories
	 - Assisted Injections
	 
 - Simulation of a Message Client
	 - [Entry Point - Simple JUnit Test Case](https://github.com/Iretha/tutorials/blob/master/example-google-guice/src/test/java/com/smdev/guice/msg/MessageAppTest.java)
