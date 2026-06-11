# Teaching Plan: Spring Boot RestClient & Service Connection

This implementation plan covers the concepts of Spring Boot `RestClient` and how to establish connection between the two projects in your workspace (`prodfeatures` running on port `9090` and `springbootwebtutorial` running on port `8080`). It also fixes current errors and details package-level cleanups.

---

## What We Will Teach/Demonstrate
1. **What is RestClient?**: A modern, synchronous HTTP client introduced in Spring Boot 3.2 / Spring Framework 6.1 with a fluent API.
2. **Why use it?**: Used to make REST calls from one application (client) to another (server/microservice or 3rd-party APIs).
3. **What is the `clients` folder?**: A structured package where we define interfaces and concrete implementations for calling external HTTP APIs.
4. **How they connect**:
   - `springbootwebtutorial` acts as the server (running on `http://localhost:8080`).
   - `prodfeatures` acts as the client (running on `http://localhost:9090`) and will call `springbootwebtutorial`'s `/employees` API using `RestClient`.

---

## Proposed Changes

### 1. Fix Configuration in `prodfeatures`
We will clean up the copy-pasted configuration in `prodfeatures` that contains package errors, bad imports, and incorrect property injection syntax.

#### [MODIFY] [RestClientConfig.java](file:///c:/Users/soura/OneDrive/Desktop/study/java/java%20backend/week4/auditing4.3/prodfeatures/src/main/java/week4/example/prodfeatures/config/RestClientConfig.java)
- Correct package declaration from `com.codingshuttle.springbootwebtutorial.springbootwebtutorial.configs` to `week4.example.prodfeatures.config`.
- Correct `@Value("employeeserviceurl")` to `@Value("${employeeserviceurl}")` so Spring properly retrieves the property value from `application.properties`.
- Remove unused and invalid imports (e.g. `jdk.jfr.ContentType`).

#### [MODIFY] [application.properties](file:///c:/Users/soura/OneDrive/Desktop/study/java/java%20backend/week4/auditing4.3/prodfeatures/src/main/resources/application.properties)
- Configure `employeeserviceurl` property: `employeeserviceurl=http://localhost:8080` (where `springbootwebtutorial` runs).

---

### 2. Implement the Client Layer in `prodfeatures`
To connect both applications, we will create the necessary client-side models and classes in `prodfeatures` to call the `springbootwebtutorial` employee service.

#### [NEW] [EmployeeDto.java](file:///c:/Users/soura/OneDrive/Desktop/study/java/java%20backend/week4/auditing4.3/prodfeatures/src/main/java/week4/example/prodfeatures/dto/EmployeeDto.java)
- A clean DTO class (Lombok-annotated, no validation annotations required since validation is a server-side concern) to deserialize JSON data returned by the employee service.

#### [NEW] [EmployeeClient.java](file:///c:/Users/soura/OneDrive/Desktop/study/java/java%20backend/week4/auditing4.3/prodfeatures/src/main/java/week4/example/prodfeatures/clients/EmployeeClient.java)
- Interface declaring employee API calls (GET all, GET by ID).

#### [NEW] [EmployeeClientImpl.java](file:///c:/Users/soura/OneDrive/Desktop/study/java/java%20backend/week4/auditing4.3/prodfeatures/src/main/java/week4/example/prodfeatures/clients/impl/EmployeeClientImpl.java)
- Implements `EmployeeClient` using the configured `RestClient` bean.

---

### 3. Cleanup Unnecessary Files and Folders
- We will identify and delete unnecessary files (such as duplicate `.idea` structures outside project roots or temp target directories, if any).
- Explain how to avoid nested project folder import problems in IntelliJ IDEA / VS Code.

---

## Verification Plan

### Automated Tests
- We will write an integration test in `prodfeatures`'s [ProdfeaturesApplicationTests.java](file:///c:/Users/soura/OneDrive/Desktop/study/java/java%20backend/week4/auditing4.3/prodfeatures/src/test/java/week4/example/prodfeatures/ProdfeaturesApplicationTests.java) that injects `EmployeeClient` and hits the endpoints.
- We will compile both applications using Maven command: `.\mvnw.cmd clean compile`.
