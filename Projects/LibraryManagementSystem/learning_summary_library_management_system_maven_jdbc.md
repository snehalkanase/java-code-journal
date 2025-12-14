# Learning Summary – LibraryManagementSystem (Maven + JDBC)

This document captures my **practical learning journey** while building the *Library Management System* using **Core Java, JDBC, MySQL, and Maven**. It focuses on **tools, build process, dependency management, common issues, and real fixes**, which are often ignored in beginner projects but are critical in real-world development.

---

## 1. Project Structure & Database Connection

### Project Entry Point
- `Main.java` acts as the **starting point** of the application.
- All flows (login, menu navigation, role-based actions) originate here.

### DatabaseConnection.java
This is a **utility class** responsible for handling database connectivity.

**Responsibilities:**
- Establish a connection to MySQL using JDBC
- Provide a reusable connection method
- Safely close connections to prevent memory leaks

**Key Concepts Learned:**
- `DriverManager.getConnection()` returns a `Connection` object
- A database connection is an **expensive resource**
- Connections must always be closed after use

**Usage Pattern:**
- Get connection when required
- Perform DB operations
- Close connection explicitly

**Important Learning:**
> If database connections are not closed properly, MySQL throws cleanup thread warnings and may cause memory leaks.

---

## 2. Maven Dependency Management

### Initial Problem
- MySQL JDBC driver was not found at runtime
- Application failed with:
  > No suitable driver found

### Root Cause
- MySQL connector dependency was either missing or had an **invalid version**
- Version `8.4.0` does **not exist** in Maven Central

### Resolution
- Verified valid versions from Maven Central
- Added a correct and stable dependency version

**Key Learning:**
> Maven only works correctly if dependency coordinates (groupId, artifactId, version) are valid.

### Why Maven is Important
- Automatically downloads dependencies
- Manages transitive dependencies
- Avoids manual JAR management
- Keeps project clean and portable

---

## 3. Running Maven Projects

### Maven Commands Used

- `mvn compile`
  - Compiles Java source code
  - Does NOT execute the application

- `mvn exec:java -Dexec.mainClass=com.library.app.Main`
  - Compiles and runs the main class

### IntelliJ Execution Behavior
IntelliJ internally generates a long Maven command that includes:
- Java executable path
- Maven home path
- IDE-specific listeners
- Color and logging support

**Understanding This Helped Me:**
- Debug Maven run failures
- Identify whether issues were IDE-related or Maven-related

---

## 4. Maven Build Lifecycle (Practical Understanding)

### Resource Phase
- Copies files from `src/main/resources`
- Places them in `target/classes`

### Compile Phase
- Converts `.java` files into `.class` files
- Stops execution if compilation fails

### Exec Phase
- Uses `exec-maven-plugin`
- Runs the specified main class

### Build Success
- Confirms that:
  - Dependencies resolved
  - Code compiled
  - Application executed successfully

---

## 5. Common Issues Faced & Fixes

### Issue 1: No Suitable Driver Found
**Cause:**
- JDBC driver not available on classpath

**Fix:**
- Add correct MySQL dependency in `pom.xml`

---

### Issue 2: Dependency Version Not Found
**Cause:**
- Invalid or non-existent dependency version

**Fix:**
- Check Maven Central before adding versions

---

### Issue 3: Cleanup Thread Warnings
**Cause:**
- Database connections not closed properly

**Fix:**
- Always close connections
- Prefer try-with-resources

---

### Issue 4: Maven – No Goal Specified
**Cause:**
- Running Maven without specifying lifecycle phase or plugin goal

**Fix:**
- Always specify goals such as:
  - `compile`
  - `package`
  - `exec:java`

---

## 6. Maven Plugins Overview

### exec-maven-plugin
- Used to run Java applications
- Executes the main class from Maven itself

### maven-dependency-plugin
- Helps analyze and debug dependency issues

### maven-surefire-plugin
- Used for running tests
- Can be skipped in early-stage console projects

**Learning:**
> Not all Maven plugins are required for every project. Use only what is needed.

---

## 7. Best Practices Learned

- Always close database connections
- Prefer Maven dependency management over manual JARs
- Use `exec-maven-plugin` for consistent execution
- Validate dependency versions from Maven Central
- Clean and rebuild project when dependencies change

**Recommended Command:**
```
mvn clean compile exec:java -Dexec.mainClass=com.library.app.Main
```

---

## 8. Next Steps for Improvement

- Use try-with-resources everywhere
- Add structured exception handling
- Replace `System.out.println` with logging
- Explore full Maven lifecycle (test, package, install)
- Convert this console project into Spring Boot later

---

## Final Reflection

This phase of the project helped me understand that **building software is not just about writing Java code**, but also about:
- Managing dependencies
- Understanding build tools
- Debugging environment issues
- Reading and interpreting error messages

These learnings significantly improved my confidence in handling **real-world Java backend projects**.

---

**Project:** Library Management System  
**Focus Area:** Maven, JDBC, Build & Runtime Learning  
**Author:** Snehal Kanase

