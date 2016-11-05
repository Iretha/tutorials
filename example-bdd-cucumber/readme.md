
example-bdd-cucumber
===========================
This is an example **Stock management application**, which illustartes how to implement test scenarios and features with 
[Cucumber](https://cucumber.io/docs/reference/jvm#java). 


What can you find in this project?
----------------------------------------------
 - Project setup - [build.gradle](https://github.com/Iretha/tutorials/blob/master/example-bdd-cucumber/build.gradle)
	 - Gradle - building a project
	 - Cucumber - BDD framework
> `gradle	
// In this section you declare where to find the dependencies
repositories {
    jcenter()
    mavenCentral()
}

// In this section you declare the dependencies for your production and test code
dependencies {
    // The production code uses the SLF4J logging API at compile time
    compile 'org.slf4j:slf4j-api:1.7.21'

        testCompile 'junit:junit:4.12',
            'info.cukes:cucumber-java:1.2.4',
            'info.cukes:cucumber-junit:1.2.4'
}`
		
 - Guice HOW-TOs in the application
	 - How to write *.feature files
	 - How to implement Definition Steps
	 - How to pass table data to step definitions
	 - How to pass enumaration value as parameter
	 - How to pass java class as parameter
	 - How to pass String as parameter
	 - How to pass Date as parameter
	 - How to pass int as parameter
	 - How to run tests
	 
 - Running the features
	 - [StockTestRunner](https://github.com/Iretha/tutorials/blob/master/example-bdd-cucumber/src/test/java/com/smdev/bdd/cuke/example/StockTestRunner.java)
