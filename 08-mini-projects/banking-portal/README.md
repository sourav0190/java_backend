# Banking Portal (mjeme)

## 📌 Project Overview
**mjeme** is a robust **Banking Portal** application built with Spring Boot. It provides a secure and user-friendly platform for essential banking operations. The system is designed to handle user accounts, secure transactions, and administrative tasks, all wrapped in a responsive web interface served by Thymeleaf.

## 🚀 Key Features
- **User Authentication**: Secure login and registration using Spring Security.
- **Account Management**: Create, update, and view bank account details.
- **Transaction Processing**: Secure fund transfers, deposits, and withdrawals.
- **Role-Based Access Control (RBAC)**: Distinct features for Admins, Tellers, and Customers.
- **Data Validation**: Comprehensive input validation to ensure data integrity.

## 🛠 Tech Stack
| Component | Technology | Version |
|-----------|------------|---------|
| **Language** | Java | 17 |
| **Framework** | Spring Boot | 3.2.3 |
| **Security** | Spring Security | 6.x |
| **Frontend** | Thymeleaf, HTML5, CSS3 | - |
| **Database** | H2 (In-memory) | Runtime |
| **Utilities** | Lombok | Latest |
| **Build Tool** | Maven | 3.x |

## ⚙️ Setup & Installation

### Prerequisites
- **Java Development Kit (JDK) 17** or higher.
- **Maven** installed.

### Installation Steps
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd learnig-spring/mjeme
   ```

2. **Build the Project**
   ```bash
   ./mvnw clean package
   ```

3. **Run the Application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the Portal**
   Open your browser and navigate to:
   ```
   http://localhost:8080
   ```
   *Default Login Credentials (if applicable, check `SecurityConfig.java` or database initialization scripts).*

## 📂 Project Structure
```
mjeme/
├── src/
│   ├── main/
│   │   ├── java/com/banking/       # Controllers, Services, Entities
│   │   └── resources/
│   │       ├── templates/          # Thymeleaf HTML views
│   │       └── static/             # CSS, JS, Images
│   └── test/                       # Security and Service tests
├── pom.xml                         # Dependencies (Spring Security, Data JPA, etc.)
└── README.md                       # Project documentation
```
