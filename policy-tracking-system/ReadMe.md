

## Getting Started


### How to Run

#### Build Spring Boot Project with Maven
To be able to run your Spring Boot app you will need to first build it. To build and package a Spring Boot app into a single executable Jar file with a Maven, use the below command. You will need to run it from the project folder which contains the pom.xml file.
  ```
  maven package
  ```
  or you can also use
  ```
  mvn install
  ```



#### Run Spring Boot app using Maven
You can also use Maven plugin to run your Spring Boot app. Use the below example to run your Spring Boot app with Maven plugin

  ```
  mvn spring-boot:run
