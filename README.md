#### **BDD testing framework of a REST API application using Cucumber and written in Java12 with Retrofit at HTTP client**

#### **Instructions for running the tests (make sure you have JDK 12):**


##### **From IDE:**
1. Use JDK 12
2. Use IntelliJ IDEA and import as Maven project
3. Install [Lombok Plugin](https://plugins.jetbrains.com/plugin/6317-lombok) for IntelliJ
4. Additional IntelliJ plugins that might help: [Cucumber for Java](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java), [Gherkin](https://plugins.jetbrains.com/plugin/9164-gherkin/versions)
* Navigate to /src/test/java/runners and execute MainRunner for full suite or SanityRunner for sanity suite
* Navigate to /src/test/features and run the tests from feature file

![Image](/src/test/resources/iderunner.png)


##### **From terminal:**
1. Make sure you use JDK 12
2. Navigate to the project
* To run the full testing suite execute `mvn surefire:test -Dtest=MainRunner`
* To run the sanity suite execute `mvn surefire:test -Dtest=SanityRunner`

![Image](/src/test/resources/terminalrunner.png)
![Image](/src/test/resources/terminalrunner2.png)

----------------------------------------------------------------------------------

**The reasons for creating the challenge using this tech stack are the following:**

* I am also a fan of BDD and that is the reason why I chose Cucumber for the outer layer.
* I have played with Karate framework in the past but I did not use it for this project as I wanted 
to also showcase some of my programming skills
* I chose Retrofit as HTTP Client because it's a straight forward tool that allows you to handle the 
client simply using a Java interface.
* Another reason for choosing Retrofit is because I have never built a framework from scratch using
this combination of tools (Cucumber and Retrofit) and I wanted to make this challenge a learning experience for me.
(as a matter of fact I just searched on google and on a first look I couldn't find any article/frameworks using the same tech stack)

----------------------------------------------------------------------------------

This framework might seem like an overkill for this simple application with just a few endpoints but the way it is designed it 
makes it very scalable and can be easily adapted to much larger project.

**Future improvements needed:**
* add a logging tool (Apache Log4j or Flogger)
* create some conversion functions that unifies the shared responses into a generic JsonObject, this way we don't need to 
store the response in separate objects.
* add the bookings dto fields from the list of bookings inside the user response payload
* add a date generator function and pass it either in the feature file or in a function, depending how we want the tests to be designed
* add a reporting tool like Allure Framework
