# Thymeleaf Fragments and Bootstrap Demo

This project demonstrates how to use **Thymeleaf Fragments** and **Bootstrap** in a Spring Boot application.

## 🚀 Features
- **Fragments**: Reusable UI components (Navbar, Footer).
- **Bootstrap 5**: Modern, responsive styling.
- **Dynamic Content**: Multiplication table generation.

## 🛠️ Implementation Details

### 1. Fragments (`fragments.html`)
Fragments allow you to define parts of a page (like a header or footer) once and reuse them across multiple pages.
In this project, we defined:
- `navbar`: A Bootstrap-based navigation bar.
- `footer`: A simple footer at the bottom of the page.

**Usage:**
```html
<div th:replace="~{fragments :: navbar}"></div>
```

### 2. Layouts
Each page (`home.html`, `index.html`) includes the fragments using `th:replace`. This ensures a consistent look and feel throughout the application.

### 3. Bootstrap Integration
Bootstrap is included via CDN in the `<head>` of both the fragments and the main pages to provide:
- **Responsive Navigation**: The navbar collapses on smaller screens.
- **Cards**: Used to wrap the multiplication table for a premium look.
- **Tables**: Styled with `table-striped` and `table-hover`.

## 📂 Project Structure
- `src/main/resources/templates/fragments.html`: Contains the fragment definitions.
- `src/main/resources/templates/home.html`: The landing page.
- `src/main/resources/templates/index.html`: The multiplication table page.
- `Controller/usercontroller.java`: The Spring Boot controller handling requests.

## 🏃 How to Run
1. Navigate to the project directory.
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Visit `http://localhost:8080/` in your browser.
