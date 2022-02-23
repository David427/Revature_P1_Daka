# Daka - A Custom ORM Framework (Project 1)

## Description

Daka is a custom object relational mapping (ORM) framework. It allows for a simplified and SQL-free interaction with the relational data source. It implements JPA standards and uses JDBC to connect to a PostgreSQL database. Currently, it only supports basic CRUD operations.

View the Web API here: https://github.com/David427/Revature_P1_WebAPI

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
- [X] Generated code coverage reports.
- [X] Usage of the java.util.Stream API.
- [X] Custom ORM source code that is included within the web application as a Maven dependency.

**To-Do**
- [ ] 80% line coverage of all Service layer classes.
- [ ] Support advanced data operations.

## Getting Started
- Clone the repository using this link: https://github.com/David427/Revature_P1_Daka
- Run mvn install to package the ORM into a JAR.
- Add daka as a Maven dependency in your API project.

## Usage
- Add @Entity to any class that represents a table in your database.
  - Add @Table(name = "") to specify the name of a table in your database if it differs from the class name.
- Add @Id to a class field that represents the corresponding table's primary key.
- Add @Column(name = "") to map each field with the right column in your table.
- At the service layer, create a com.revature.daka.ModelRepoImpl object to access daka's CRUD operation methods.

# Contributors
- Kainalu Barino (GitHub: @kbarino45)

# License
This project is unlicensed.
