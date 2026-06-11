# Student Management System

## 📌 Project Overview
The **Student Management System** is a Spring Boot application designed to handle administrative tasks related to student records. It demonstrates the implementation of a classic CRUD application using Spring Boot `4.0.2` and Spring Data JPA.

## 🚀 Key Features
- **Student Records**: Add, edit, view, and delete student information.
- **Search & Filter**: Find students by various criteria (name, ID, major).
- **Data Integrity**: Uses JPA annotations to enforce database constraints.
- **RESTful Design** (if implemented): Exposes endpoints for integration with external clients.

## 🛠 Tech Stack
| Component | Technology | Version |
|-----------|------------|---------|
| **Language** | Java | 17 |
| **Framework** | Spring Boot | 4.0.2 |
| **Database** | MySQL | 8.x |
| **Persistence** | Spring Data JPA | - |
| **Testing** | JUnit 5, Mockito | - |

## ⚙️ Setup & Installation

### Prerequisites
- **Java JDK 17**
- **MySQL Server**

### Configuration
Update your database configuration in `src/main/resources/application.properties`.

### Installation Steps
1. **Clone and Navigate**
   ```bash
   cd learnig-spring/minproject/student
   ```

2. **Clean and Install**
   ```bash
   ./mvnw clean install
   ```

3. **Start the Server**
   ```bash
   ./mvnw spring-boot:run
   ```

The APIs/Frontend will be available at `http://localhost:8080`.

## 📂 Project Structure
```
student/
├── src/
│   ├── main/
│   │   ├── java/com/example/student/  # Entities, Repositories, Controllers
│   │   └── resources/                 # Config
└── pom.xml                            # Dependencies
```
