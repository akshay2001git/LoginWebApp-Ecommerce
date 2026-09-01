# LoginWebApp - E-commerce Demo

A Maven + Java 17 + JSP/Servlet + MySQL e-commerce starter application for Tomcat 9.

## Features

- Modern responsive login/register UI
- BCrypt password hashing
- MySQL user and product persistence
- Product catalog
- Add-to-cart using HTTP session
- Cart and demo checkout page
- Logout
- Dockerfile and Docker Compose

## 1. Local MySQL setup

Create the database and sample data:

    mysql -u root -p < database/schema.sql

The default application credentials are:

    DB_URL=jdbc:mysql://localhost:3306/ecommerce?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
    DB_USER=ecommerce
    DB_PASSWORD=ecommerce

For local MySQL, either create user `ecommerce` with password `ecommerce`, or override the environment variables.

## 2. Build

    mvn clean package

WAR output:

    target/LoginWebApp.war

## 3. Deploy to Tomcat 9

Copy the WAR:

    cp target/LoginWebApp.war /opt/tomcat/webapps/

Start Tomcat:

    /opt/tomcat/bin/startup.sh

Open:

    http://SERVER-IP:8080/LoginWebApp/

If renamed to ROOT.war, open:

    http://SERVER-IP:8080/

## 4. Docker

Build:

    mvn clean package
    docker build -t loginecommerce:1.0 .

Run the application:

    docker run -p 8080:8080       -e DB_URL='jdbc:mysql://HOST:3306/ecommerce?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC'       -e DB_USER=ecommerce       -e DB_PASSWORD=ecommerce       loginecommerce:1.0

## 5. Docker Compose

The included compose file starts MySQL and Tomcat:

    mvn clean package
    docker compose up --build

Open:

    http://localhost:8080/

## Project structure

    src/main/java/com/ecommerce/
      controller/
      dao/
      model/
      util/

    src/main/webapp/
      *.jsp
      css/style.css

    database/schema.sql
    Dockerfile
    docker-compose.yml
    pom.xml

## Important production notes

This is a learning/demo application. Before production use:
- Store secrets in a secret manager/environment, not source control.
- Add CSRF protection and server-side validation.
- Use HTTPS.
- Add secure session cookie settings.
- Implement real order transactions and payment gateway integration.
- Add authorization checks to every customer operation.
- Do not use the demo database password in production.
