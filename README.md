#  JDBC CRUD App (Java & MySQL)

A textbook example demonstrating how to perform **CRUD** (Create, Read, Update, Delete) operations in Java using **JDBC** (Java Database Connectivity) with a MySQL database.

---

##  Features

- Establishes a JDBC connection to a MySQL database
- Performs **CRUD operations**:
  - Insert new records
  - Fetch and display existing records
  - Update existing entries
  - Delete unwanted records
- Uses **PreparedStatements** to prevent SQL injection and improve performance
- Manages database resources effectively with **try-with-resources**

---

##  Prerequisites

| Requirement     | Details |
|----------------|---------|
| Java            | JDK 8 or higher |
| MySQL           | Installed and running |
| JDBC Driver     | MySQL Connector/J (e.g., `mysql-connector-java-8.x.x.jar`) |

---
##  Setup Instructions

### 1. Create the MySQL Database & Table
```sql
CREATE DATABASE demo_db;
USE demo_db;

CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  department VARCHAR(50) NOT NULL
);
```

2. Add JDBC Driver to Your Project

If not using Maven/Gradle:

Download mysql-connector-java-x.x.x.jar and add it to your project's classpath.

If using Maven, add to pom.xml:
   ``` <dependency>
    
  <groupId>mysql</groupId>
  
  <artifactId>mysql-connector-java</artifactId>
  
  <version>8.0.33</version>
  
</dependency>
```

3. Configure Database Connection

In your DatabaseConnection.java, update the connection details:

```String url = "jdbc:mysql://localhost:3306/demo_db";
String user = "your_username";
String password = "your_password";
```

4. Run the Application
```
javac -cp .:path/to/mysql-connector-java.jar *.java
java -cp .:path/to/mysql-connector-java.jar Main
```

Example Output
```
Connected to the database successfully!
Inserted Employee: Alice
All Employees:
[Employee{id=1, name='Alice', email='alice@example.com', department='Marketing'}]
Updated Employee with ID 1
Deleted Employee with ID 1
```
Project Structure
```
JDBC_CRUD_APP/
├── src/
│   ├── DatabaseConnection.java  # Establishes DB connection
│   ├── Employee.java            # Employee data model
│   ├── EmployeeDAO.java         # CRUD operations handler
│   └── Main.java                # Application entry point
├── .gitignore                   # (see suggestions below)
└── README.md
```
Suggested Improvements
```
Add .gitignore — Prevent committing class files, credentials, or IDE settings:

*.class
*.jar
.idea/
.vscode/
*.log

```
Add Unit Tests — Use JUnit or TestNG to validate operations.

Externalize Configuration — Store DB credentials in config.properties or environment variables for flexibility.

Better Error Handling — Use logging frameworks like SLF4J or Log4j instead of printStackTrace.

Batch Operations — Support bulk inserts or updates for efficiency.

Dockerize with MySQL — Provide a docker-compose.yml to spin up a MySQL container along with the app for easy setup and testing.

Contributing
```
Contributions are always welcome!
Steps:

Fork the repository

Create a feature branch (feature/your-change)

Commit with clear messages

Open a Pull Request
```
License

This project is open-source and available under the MIT License.

Author: Gurupada Nayak

 



