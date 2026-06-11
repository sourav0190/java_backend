# Internal Working of Spring Boot (IWS)

## 📌 Project Overview
**IWS (Internal Working of Spring Boot)** is a comprehensive learning project designed to explore the core mechanics of the Spring Boot framework. It dives deep into how Spring Boot's "magic" works under the hood, focusing on auto-configuration, dependency injection, and the request processing lifecycle.

This project is ideal for developers who want to move beyond just *using* Spring Boot to *understanding* it.

## 🚀 Key Features
- **Deep Dive into Auto-Configuration**: Exploration of `@EnableAutoConfiguration`, `META-INF/spring.factories`, and conditional annotations (`@ConditionalOnClass`, `@ConditionalOnMissingBean`).
- **Spring MVC Internals**: detailed look at `DispatcherServlet`, `HandlerMapping`, and `ViewResolver`.
- **Dependency Injection (DI)**: In-depth usage of Spring's IoC container, bean scopes, and lifecycle management.
- **Database Integration**: configurations for both in-memory (H2) and persistent (MySQL) databases using Hibernate and JPA.

## 🛠 Tech Stack
| Component | Technology | Version |
|-----------|------------|---------|
| **Language** | Java | 21 |
| **Framework** | Spring Boot | 4.0.1 (Experimental) |
| **Build Tool** | Maven | 3.x |
| **Database** | MySQL, H2 | 8.0.33, Runtime |
| **ORM** | Hibernate | 5.6.15.Final |
| **Persistence** | JPA (Java Persistence API) | 2.2 |

> **Note**: This project uses Spring Boot `4.0.1`, which is an experimental/placeholder version. Production applications should typically use the latest stable 3.x release.

## ⚙️ Setup & Installation

### Prerequisites
- **Java Development Kit (JDK) 21** or higher installed.
- **Maven** installed and configured (or use the provided `mvnw` wrapper).
- **MySQL Server** running locally (if using the MySQL profile).

### Installation Steps
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd learnig-spring/IWS
   ```

2. **Configure Database**
   Update `src/main/resources/application.properties` with your database credentials if running with MySQL.

3. **Build the Project**
   ```bash
   ./mvnw clean install
   ```

4. **Run the Application**
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080`.

## 📂 Project Structure
```
IWS/
├── src/
│   ├── main/
│   │   ├── java/com/IWS/      # Source code
│   │   └── resources/         # Config files (application.properties)
│   └── test/                  # Unit and integration tests
├── pom.xml                    # Maven dependencies and build config
└── README.md                  # Project documentation
```
