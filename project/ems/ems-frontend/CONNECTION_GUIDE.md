# Connection Guide: EMS Frontend & Backend

Follow these steps to connect and run your Employee Management System.

## 1. Backend Configuration (Done)
I have already added `@CrossOrigin("*")` to your `EmployeeController.java`. This allows your React frontend (running on port 5173) to communicate with your Spring Boot backend (running on port 8080).

## 2. Start the Backend
1. Open a terminal in the `ems-backend` folder.
2. Run the following command:
   ```bash
   ./mvnw spring-boot:run
   ```
   *Make sure your MySQL database is running and the credentials in `src/main/resources/application.properties` are correct.*

## 3. Start the Frontend
1. Open a **new** terminal in the `ems-backend/ems-frontend` folder.
2. Run the following command:
   ```bash
   npm run dev
   ```
3. Open your browser and navigate to `http://localhost:5173`.

## 4. Troubleshooting
- **CORS Error**: Ensure `@CrossOrigin("*")` is present on the controller or a global CORS configuration is set in Spring Security (if used).
- **Network Error**: Ensure the backend is actually running on `http://localhost:8080`.
- **Database Error**: Check the backend logs to ensure it connected to MySQL successfully.

## Features Implemented
- **View All Employees**: See a list of all employees in a clean, modern table.
- **Add Employee**: Add new employees with validation.
- **Update Employee**: Edit existing employee details.
- **Delete Employee**: Remove employees with a confirmation prompt.
- **Responsive UI**: Works on various screen sizes.
- **Lucide Icons**: Modern icons for a premium feel.
- **Toast Notifications**: Interactive feedback for actions.
