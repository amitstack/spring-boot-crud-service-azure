# Spring Boot CRUD Service

This project is a simple Spring Boot application that provides a RESTful web service for managing user details and preferences. It supports basic CRUD operations and exposes endpoints for persisting and fetching user information.

## Project Structure

```
spring-boot-crud-service
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── crudservice
│   │   │               ├── CrudServiceApplication.java
│   │   │               ├── controller
│   │   │               │   └── UserController.java
│   │   │               ├── model
│   │   │               │   └── User.java
│   │   │               ├── repository
│   │   │               │   └── UserRepository.java
│   │   │               └── service
│   │   │                   └── UserService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── crudservice
│       │               └── CrudServiceApplicationTests.java
│       └── resources
│           └── application-test.properties
├── pom.xml
└── README.md
```

## Endpoints

### 1. Create User

- **URL:** `/api/users`
- **Method:** `POST`
- **Request Body:** JSON representation of the user (name, email, preferences).
- **Response:** The created user object.

### 2. Get User

- **URL:** `/api/users/{id}`
- **Method:** `GET`
- **Path Variable:** `id` (User ID).
- **Response:** The user object corresponding to the provided ID.

## Setup Instructions

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```
   cd spring-boot-crud-service
   ```

3. Build the project using Maven:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

5. Access the API at `http://localhost:8080/api/users`.

## Deploying to Azure

Follow these steps to deploy the application to Azure as a web service:

### Prerequisites
1. Install the [Azure CLI](https://learn.microsoft.com/en-us/cli/azure/install-azure-cli).
2. Ensure you have an active Azure subscription.
3. Package the application as a JAR file:
   ```bash
   mvn clean package
   ```

### Steps to Deploy
1. **Log in to Azure**:
   ```bash
   az login
   ```

2. **Create a Resource Group**:
   ```bash
   az group create --name <resource-group-name> --location <location>
   ```

3. **Create an App Service Plan**:
   ```bash
   az appservice plan create --name <app-service-plan-name> --resource-group <resource-group-name> --sku B1 --is-linux
   ```

4. **Create a Web App**:
   ```bash
   az webapp create --resource-group <resource-group-name> --plan <app-service-plan-name> --name <app-service-name> --runtime "JAVA:17-java17"
   ```

5. **Deploy the JAR File**:
   ```bash
   az webapp deploy --resource-group <resource-group-name> --name <app-service-name> --src-path target/spring-boot-crud-service-0.0.1-SNAPSHOT.jar
   ```

6. **Configure Application Settings**:
   - Navigate to the Azure portal.
   - Go to your Web App > Configuration > Application Settings.
   - Add any required environment variables or connection strings.

7. **Access the Application**:
   - The application will be accessible at: `https://<app-service-name>.azurewebsites.net`.

### Deploying with Maven Plugin

You can also deploy the application to Azure using the Azure Web App Maven Plugin. Ensure the plugin is configured in the `pom.xml` file.

#### Steps to Deploy with Maven Plugin
1. **Build the Project**:
   ```bash
   mvn clean package
   ```

2. **Deploy to Azure**:
   ```bash
   mvn azure-webapp:deploy
   ```

This will use the configuration specified in the `pom.xml` file to deploy the application to Azure App Service.

### Notes
- Ensure the database connection details (e.g., MySQL) are correctly configured in the application properties or environment variables.
- Monitor the application using Azure's monitoring tools.

## Usage

You can use tools like Postman or curl to interact with the API endpoints. Make sure to set the appropriate headers for content type as `application/json` when sending requests.