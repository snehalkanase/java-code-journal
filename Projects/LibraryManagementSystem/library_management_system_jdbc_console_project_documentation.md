# Library Management System (Console Based)

## Project Overview

This project is a **Console-Based Library Management System** built using **Core Java, JDBC, MySQL, and Maven**. The main goal of this project was not just to build a working system, but to **deeply understand real-world backend concepts**, common mistakes, and how production-like systems are designed even without frameworks.

This project follows a **layered architecture inspired by microservices principles**, adapted for a console application.

---

## Objectives of the Project

- Practice **Core Java** in a structured way
- Learn **JDBC from basics to advanced**
- Understand **real database integration**
- Implement **role-based logic (ADMIN / STUDENT)**
- Learn **layered architecture (Controller, Service, DAO)**
- Debug real-world issues instead of toy problems
- Prepare an **interview-ready backend project**

---

## Technology Stack

- Java (Core Java)
- JDBC
- MySQL
- Maven
- Console-based UI

---

## Project Architecture

### Package Structure

```
com.library
│
├── common
│   ├── DatabaseConnection
│   ├── ConsoleUtils
│
├── models
│   ├── User
│   ├── Book
│   ├── BookingDetails
│   ├── Role (Enum)
│
├── userservice
│   ├── UserController
│   ├── UserService
│   ├── UserServiceImpl
│   ├── UserDAO
│
├── bookservice
│   ├── BookController
│   ├── BookService
│   ├── BookServiceImpl
│   ├── BookDAO
│
├── bookingservice
│   ├── BookingController
│   ├── BookingService
│   ├── BookingServiceImpl
│   ├── BookingDAO
│
└── MainApp
```

### Why This Architecture?

- **Controller** → Handles user input (console)
- **Service** → Business logic & validation
- **DAO** → Database access only
- **Model** → Data representation

This separation makes the project:

- Easy to understand
- Easy to debug
- Easy to extend
- Interview-friendly

---

## Database Design

### Tables

#### Users Table

| Column     | Type                     |
| ---------- | ------------------------ |
| id         | INT (PK, Auto Increment) |
| full\_name | VARCHAR(150)             |
| username   | VARCHAR(50) UNIQUE       |
| password   | VARCHAR(255)             |
| role       | ENUM('ADMIN','STUDENT')  |
| reg\_no    | VARCHAR(20)              |

#### Books Table

| Column   | Type                     |
| -------- | ------------------------ |
| id       | INT (PK, Auto Increment) |
| title    | VARCHAR(150)             |
| author   | VARCHAR(100)             |
| price    | DECIMAL(10, 2)           |
| quantity | INT                      |

#### Booking\_Details Table

| Column         | Type                     |
| -------------- | ------------------------ |
| id             | INT (PK, Auto Increment) |
| student\_id    | INT (FK → users.id)      |
| book\_id       | INT (FK → books.id)      |
| checkout\_date | DATETIME                 |
| return\_date   | DATETIME                 |

---

## Functional Flow

### Authentication

- User logs in using username & password
- Role is fetched from DB
- Role decides menu access

### Admin Capabilities

- Add new books
- Update book quantity
- Register Users
- Search books

### Student Capabilities

- Search books
- Checkout book
- Return book

---

## Step-by-Step Development Journey

### Phase 1: Folder Structure & Planning

- Designed package structure before writing code
- Decided responsibilities of each layer

**Learning:** Good architecture prevents confusion later.

---

### Phase 2: Database Setup

- Created MySQL database and tables
- Designed schema carefully
- Used ENUM for role initially

**Learning:** Database design directly affects application behavior.

---

### Phase 3: JDBC Connection

- Learned how JDBC works internally
- Used DriverManager
- Created reusable DatabaseConnection class

**Learning:** Connection management is critical in real applications.

---

### Phase 4: User Registration & Login

- Implemented role-based login
- Used PreparedStatement to prevent SQL injection

---

## Major Bug Faced & Debugged (Very Important)

### Problem

```
java.sql.SQLException: Data truncated for column 'role'
```

### Initial Assumptions (Wrong)

- ENUM value issue
- Case sensitivity problem
- Java enum mismatch

### Actual Root Cause

**Parameter order mismatch across layers**:

- Controller passed arguments in wrong order
- Service method signature expected different order
- DAO inserted wrong value into `role` column

This caused:

```
role = "Shubham Kanase"
```

which ENUM rejected.

### Resolution

- Aligned method signatures across:
  - Controller
  - Service
  - DAO

**Key Learning:**

> Database errors are often caused by application-layer mistakes.

---

## Key Learnings from This Project

### Technical Learnings

- JDBC PreparedStatement usage
- Transaction management
- ENUM behavior in MySQL
- Role-based access control
- Layered architecture

### Debugging Learnings

- Always verify data flow end-to-end
- SQL error messages can be misleading
- Bugs can exist across layers, not just in code

### Design Learnings

- DTOs prevent parameter mismatch
- ENUM vs VARCHAR trade-offs
- Separation of concerns is critical

---

## Interview Talking Points

- Why DAO pattern?
- Why Service layer?
- How JDBC works internally
- Why PreparedStatement?
- ENUM vs VARCHAR
- How transactions & rollback work
- How this project can be converted to Spring Boot

---

## Future Improvements

- Password hashing (SHA-256 / BCrypt)
- DTO implementation
- Return book flow with fine calculation
- Logging framework
- Convert to REST API using Spring Boot
- More Features will be included

---

## Conclusion

This project represents my **learning journey**, not just a finished product. Every bug, fix, and design decision helped me understand how **real backend systems are built and debugged**.

I intentionally worked without frameworks to strengthen my fundamentals, making this project a strong base for advanced backend development.

---

**Author:** Snehal Kanase 
