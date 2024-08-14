# Advanced CRUD Application with Spring Boot

This project is a comprehensive CRUD application built with Spring Boot, featuring several advanced capabilities for enhanced logging, validation, and multi-database support. The application is designed following the MVC architecture, ensuring a clean separation of concerns and maintainability.

## Features

- **MVC Architecture:** Clear separation between Controller, Service, and Repository layers for easy maintainability and scalability.
- **Advanced Logging with MDC:** Integrated MDC (Mapped Diagnostic Context) logging for efficient tracking and debugging. Logs are printed in a custom format specified in `logback-spring.xml`.
- **Spring Boot Validation:** Implemented robust validation for incoming requests using Spring Boot's validation framework.
- **Multiple Profiles for Databases:** Configured YAML files for different database environments (MySQL, Oracle, PostgreSQL). Users can switch databases by simply modifying the YAML file.
- **Custom Logging Format:** Logs are printed in a specific format using `logback-spring.xml`, making it easy to trace and analyze log data.

## Dependencies

The project utilizes the following key dependencies:

```xml
<dependencies>
    <!-- Spring Boot Data JPA for ORM and database interactions -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Spring Boot Web Starter for building web applications -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- DevTools for hot swapping and faster development -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

    <!-- MySQL Connector for MySQL database -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Uncomment the below dependencies if using Oracle or PostgreSQL -->
    <!-- Oracle JDBC Driver -->
    <!--<dependency>
        <groupId>com.oracle.database.jdbc</groupId>
        <artifactId>ojdbc11</artifactId>
        <scope>runtime</scope>
    </dependency>-->

    <!-- PostgreSQL JDBC Driver -->
    <!--<dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>-->

    <!-- Spring Boot Test Starter for unit and integration testing -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- Spring Boot Validation Starter for request validation -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
</dependencies>
