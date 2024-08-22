# Device-management-service
## Overview

The Device Management Service is a Spring Boot application for managing devices. This README provides instructions on how to build, run, and deploy the application, along with how to access the Swagger API documentation.

## Prerequisites

- Java 17 or later
- Maven 3.8.x or later
- Docker (if deploying with Docker)

## Getting Started

### Clone the Repository

To get started, clone the repository:

```bash
git clone https://github.com/adeelahmedcsku/device-management-service.git
cd device-management-service
```

### Building the Application
Install Maven Dependencies

Ensure Maven is installed. Install dependencies by running:

```
mvn clean install
```

### Build the Application
```
mvn package
```

The JAR file will be located in the target directory (e.g., target/device-management-service.jar).

### Running the Application Locally
```
mvn spring-boot:run

```
By default, the application will run on http://localhost:9091. You can access it through this URL.

### Swagger API Documentation
#### Access Swagger UI

After starting the application, you can view the Swagger API documentation at:

http://localhost:9091/swagger-ui/index.html

Swagger UI provides a user-friendly interface to explore and interact with the API endpoints.