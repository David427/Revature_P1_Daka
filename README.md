# Project 1 - Custom Object Relational Mapping Framework

## Description

Your first project will be to create a custom object relational mapping (ORM) framework. This framework will allow for a simplified and SQL-free interaction with the relational data source. The requirements of the project are purposefully vague, the intention is to allow for you to be creative in your implementation of this framework. There are many ways that this task can be approached, and you are encouraged to explore existing Java ORM implementations in order to get some inspiration. The minimum requirement for the custom ORM is to abstract JDBC boilerplate logic from the application which uses it.

Additionally, you will need to build a simple CRUD web application (what objects you CRUD is up to you and your team). You should leverage the Java EE Servlet API to expose endpoints that allow for interaction with the application.

## Tech Stack
- [X] Java 8
- [X] JUnit
- [X] Mockito
- [X] Apache Maven
- [X] GSON library
- [X] PostGreSQL deployed on AWS RDS
- [X] Git SCM (GitHub)

## Features
- [X] CRUD operations are supported for one or more domain objects via the web application's exposed endpoints.
- [X] JDBC logic is abstracted away by the custom ORM.
- [X] Programmatic persistence of entities (basic CRUD support) using custom ORM.
- [X] File-based or programmatic configuration of entities.
- [X] Generated Code Coverage reports.
- [X] Usage of the java.util.Stream API within your project.
- [X] Custom ORM source code should be included within the web application as a Maven dependency.

**To-Do**
- [ ] 80% line coverage of all service layer classes.

## Getting Started
- Clone the repository using this link: https://github.com/David427/org_daka_p1.git
- Run mvn install to package the ORM into a JAR.
- Add daka as a Maven dependency in your API project.

## Usage
- Create a ModelRepoImpl object to access daka's CRUD operation methods.

# Contributors
- Kainalu Barino (GitHub: @kbarino45)

# License
This project is unlicensed.
