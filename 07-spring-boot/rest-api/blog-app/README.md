# Blogging Platform (Blog)

## 📌 Project Overview
The **Blogging Platform** is a feature-rich content management system (CMS) developed using Spring Boot. It allows users to create, read, update, and delete (CRUD) blog posts. The application emphasizes clean architecture and utilizes Spring Data JPA for efficient data interaction.

## 🚀 Key Features
- **Post Management**: Full CRUD capabilities for blog posts.
- **Rich Text Content**: Support for storing and rendering formatted text.
- **User Interface**: Clean, server-side rendered UI using Thymeleaf.
- **Data Persistence**: Robust data storage using MySQL.
- **MVC Architecture**: Strictly follows Model-View-Controller design pattern.

## 🛠 Tech Stack
| Component | Technology | Version |
|-----------|------------|---------|
| **Language** | Java | 17 |
| **Framework** | Spring Boot | 3.2.3 |
| **Web Layer** | Spring MVC, Thymeleaf | - |
| **Database** | MySQL | 8.x |
| **Persistence** | Spring Data JPA, Hibernate | - |
| **Build Tool** | Maven | 3.x |

## ⚙️ Setup & Installation

### Prerequisites
- **Java JDK 17**
- **Maven**
- **MySQL Server** installed and running.

### Configuration
1. Create a MySQL database named `blog_db` (or updated name in properties).
2. Configure database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

### Installation Steps
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd learnig-spring/bloggingpost/Blog
   ```

2. **Run the Application**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access the Blog**
   Visit `http://localhost:8080` to view and manage posts.

## 📂 Project Structure
```
Blog/
├── src/
│   ├── main/
│   │   ├── java/com/example/Blog/  # Application logic
│   │   └── resources/              # Properties and Views
└── pom.xml                         # Project dependencies
```
