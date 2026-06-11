# Java Programming Assignments (NetBeans/Maven)

This repository contains a collection of simple Java applications developed using the NetBeans IDE and the Maven build system. These projects focus on basic programming concepts, GUI design with Java Swing, and simple networking.

## Projects Overview

| Folder | Application | Topics Covered | Description |
| :--- | :--- | :--- | :--- |
| **`ip-finder`** | IP Address Finder | `java.net.InetAddress`, Exception Handling | Resolves a website URL (e.g., google.com) to its corresponding IPv4 address. |
| **`greeting-app`** | Basic Greeting | GUI Components (JTextArea, JButton), String Concatenation | A simple app that takes a user's name and displays a personalized greeting. |
| **`simple-calculator`** | Simple Calculator | Data Type Conversion (`Integer.parseInt`), Basic Arithmetic | A two-number addition calculator with a graphical interface. |
| **`todo-list`** | To-Do List | `DefaultListModel`, `JList` interaction | A task management app that allows adding items to a list and deleting selected items. |

---

## Key Topics Explained

### 1. Java Swing (GUI)
All these projects use **Java Swing**, which is a powerful library for creating Graphical User Interfaces. 
*   **JFrame**: The main window of the application.
*   **JButton**: Used to trigger actions (like "Add" or "Get IP").
*   **JTextField/JTextArea**: Used to take text input from the user or show output.
*   **Events**: Handled via `ActionListeners` (the code inside the `jButtonActionPerformed` methods).

### 2. Networking (`java.net`)
The `ip-finder` project uses the `InetAddress` class. This allows Java to communicate with the system's DNS (Domain Name System) to turn a human-readable URL into a machine-readable IP address.

### 3. Data Conversion
In the calculator (`simple-calculator`), we use `Integer.parseInt(string)` to convert the text typed in the box (a String) into a number (an Integer) so that we can perform math on it.

---

## How to Run the Projects

### Prerequisites
*   **Java Development Kit (JDK)**: Version 8 or higher.
*   **NetBeans IDE** (Recommended for GUI editing).

### Method 1: Using NetBeans (Easiest)
1.  Open NetBeans.
2.  Go to `File > Open Project`.
3.  Navigate to the specific folder (e.g., `todo-list`) and click **Open Project**.
4.  Right-click the project in the left sidebar and select **Run**.

### Method 2: Using Command Line (Maven)
If you have Maven installed, you can run these from the terminal inside any project folder:
```bash
# To build the project
mvn clean install

# To run the GUI (Example for TodoList)
mvn exec:java -Dexec.mainClass="com.mycompany.todolist.TodoList"
```

---

## Project Structure
- `pom.xml`: The Maven configuration file.
- `src/main/java`: Where the Java source code lives.
- `src/main/resources`: (If applicable) Configuration files or images.
- `target/`: Where compiled `.class` files and JARs are generated.
