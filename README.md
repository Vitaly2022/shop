## Description

As part of my graduation project, I implemented an online-store using **Spring**. In the project I used **Spring Boot**, **Spring Security 5**, **Spring Data JPA** with **MySql database**, for views I used **Thymeleaf** template and **Bootstrap** CSS framework. Tests are made on **JUnit 5** with test **H2 database **. For accelerated development, I used **Spring BootDevTools**.

## Screenshots

<img src="src/main/resources/siteexample.jpg" height=60% width=95%>
<img src="src/main/resources/adminpanel.jpg" height=60% width=95%>

## Installation

You can clone this repository and use it localy:
```sh
$ git clone https://github.com/Vitaly2022/shop
```

**Using Maven plugin**

First you should do clean installation:
```sh
$ mvn clean install
```
You can start application using Spring Boot custom command:
```sh
$ mvn spring-boot:run
```

**Using Maven plugin and running JAR**

You can create JAR file using:
```sh
$ mvn clean package
```
and then run it with:
```sh
$ java -jar target/*jar
```

## Logins

ADMIN role is assigned by MySql query.

The USER role is given to all registered.

## Roles

**ADMIN** In personal account, can add, edit and delete site content (product, category, manufacturer, order, review, supplier, user).

**USER** can add, edit and delete products in cart. Send cart to order. In personal account see your orders and their status. Edit profile.

## Tests

You can run tests using:
```sh
$ mvn test
```
