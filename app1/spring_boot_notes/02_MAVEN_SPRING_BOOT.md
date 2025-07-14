# Spring Boot and Maven

## Maven Crash Course

1. Viewing dependencies in the Maven pom.xml file
2. Spring Boot Starters for Maven

### What is Maven?

Maven is a project management tool for your application that manages how your
project is built and its dependencies.

**JAR files** = {Spring, Hibernate, Commons Logging, JSON, ... }

Without Maven, you would have to *download those JAR files* to your
project, and then manually add them to your *build or class path*.

### Maven Solution

You tell Maven the projects (**dependencies**) you are working with and then

&#x2611; Maven will download the corresponding JAR files from the internet.

&#x2611; Maven will make those JAR files available during compile and run time.

Maven uses the **Maven Central Repository** = https://mvnrepository.com

Maven reads your read configuration file (pom.xml), then checks your local repo,
if the required JAR files are not in there, then it will go on the internet
and download the files from the Maven Central Repository and save them in your
local repo.

&#x2611; Maven also handles additional sub-dependencies.

## Maven Project Structure

Maven solves the problem of each dev team having their own directory structure by
**providing a standard directory structure:**

```
/my-super-cool-app/
    pom.xml # Main Project Object Model (pom) XML file
    src/main/java/com/ ... # Your Java source code
    src/main/resources/ # properties, config files used by your app
    src/main/webapp/ # JSP files, web config files, web assets (js, css, images, ...)
        /WEB-INF/view
        index.jsp 
    src/test/ # Unit testing code and properties
    
    target/ # Destination directory for the compiled code, automatically created by Maven
```

&#x2611; New developers can eadily find code, properties files, unit tests, etc.

&#x2611; Most major IDEs have built-in support for Maven projects, that is, **Maven projects
are portable**

There's no need or point to fight about which IDE is the best!!
Whatever works for you, go ahead.
Don't even go there;
it's like trying to convert someone into a religion, and that sucks in the STEM world.

&#x2611; Once you learn Maven, you can join a new project and be productive.
You can build and run a project with **minimal local configuration!**

# Maven Key Concepts

### pom.xml = Project Object Model XML file

This is your main configuration file (like a "shopping list" for Maven) and has to be
located at the root level of your application directory structure.

### POM File Structure

1. Project meta data (project name, version, JAR/WAR output)
2. Dependencies (Spring, Hibernate, JSON)
3. Plug-ins (Additional custom tasks to run: e.g. generate JUnit test resports)

#### pom.xml example:

```xml
<project>...
<modelVersion>4.0.0</modelVersion>

<groupId>com.neo_1642</groupId>
<artifactId>mycoolapp</artifactId>
<version>1.0.FINAL</version>
<packaging>jar</packaging>

<name>mycoolapp</name>

<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.9.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
    <!--Add plugins for customization -->
    
</project>
```

## Project Coordinates = [groupId, artifactId, version] = GAV

Uniquely identify a project (just like cartesian coordinates)
```xml
<groupId>com.neo_1642</groupId> <!-- City -->
<artifactId>mycoolapp</artifactId>  <!-- Street -->
<version>1.0.FINAL</version> <!-- House Number -->
```

```groupId``` = Name of the company or organization. Convention is to use the reverse
domain name (com.apple)

```artifactId``` = Name for this project (**mycoolapp**)

```version``` = 1.0.SNAPSHOT (if the project is under active development)

To add a dependency to the POM file, the version is *optional* but strongly
recommended.

### How to Find Dependency Coordinates?

1. Visit the project page
2. Visit (https://central.sonatype.com) (easiest approach)


