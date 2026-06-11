# HumorCode (Legacy Web App)

## 📌 Project Overview
**HumorCode** is a traditional Java Web Application designed to run on **Apache Tomcat**. Unlike the Spring Boot projects in this workspace, this project likely utilizes standard **Java Servlets** and **JSP (JavaServer Pages)**, making it an excellent reference for understanding the foundations of Java web development before frameworks like Spring abstraction.

## 🚀 Key Features
- **Servlet-based Request Handling**: Direct manipulation of `HttpServletRequest` and `HttpServletResponse`.
- **JSP Views**: Server-side dynamic content rendering.
- **Standard Deployment**: Built as a WAR (Web Application Archive) for deployment to external servlet containers.

## 🛠 Tech Stack
| Component | Technology |
|-----------|------------|
| **Language** | Java SE/EE |
| **Server** | Apache Tomcat 9/10 |
| **Web Tech** | Servlets, JSP |
| **IDE** | Eclipse (Recommended) |

## ⚙️ Setup & Installation

### Prerequisites
- **Eclipse IDE for Enterprise Java Developers**.
- **Apache Tomcat Server** installed locally.
- **Java JDK**.

### Importing into Eclipse
1. **Open Eclipse** and go to `File > Import`.
2. Select `General > Projects from Folder or Archive`.
3. Choose the `tomcat/humorcode` directory.
4. Click `Finish`.

### Running the Application
1. Right-click on the project in the **Project Explorer**.
2. Select `Run As > Run on Server`.
3. Choose your configured **Tomcat Server**.
4. The application will launch in the internal Eclipse browser or your default web browser at:
   ```
   http://localhost:8080/humorcode
   ```

## 📂 Project Structure
```
humorcode/
├── src/
│   └── main/java/       # Java Servlet code
├── WebContent/          # JSP files, HTML, CSS, WEB-INF/web.xml
└── .project             # Eclipse project configuration
```
