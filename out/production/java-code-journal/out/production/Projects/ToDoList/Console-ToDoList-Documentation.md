# 📝 Console-Based To-Do List Application – Documentation

## 📘 Overview

This is a **Java console-based To-Do List application** built for strengthening **core logic and programming concepts**.  
The app allows users to **add**, **view**, **mark as completed**, **delete**, and **exit** tasks — all through simple console interactions.

The purpose of this project is to:
- Build problem-solving and logical thinking skills.
- Practice using **classes, objects, lists, streams, and optionals** in Java.
- Learn how to handle **user input** and design **console-based workflows**.

---

## ⚙️ Architecture Overview

The application consists of two main classes within the same package:

### 1️⃣ `ConsoleToDoList` (Main Class)
This class contains:
- The `main()` method — entry point of the app.
- Core application flow control (menu loop, user interaction, and actions).

### 2️⃣ `Task` (Model Class)
Represents a **single task** in the system with:s without imports.

---

## 🚀 Application Flow

### **1. Application Entry Point**
- The `main()` method starts the application by calling:
  ```java
  startApp();
  ```
- This initializes the console program and displays a **welcome message**.

---

### **2. `startApp()` Method**
- Displays the welcome message and starts the main loop.
- Contains a **boolean flag** `isExit` used to control when to exit the application.
- Checks whether the task list is empty:
  - If empty → Prompts the user to **add the first task**.
  - Otherwise → Displays existing tasks and a menu of options.

**Menu options:**
- Add a new task  
- Delete a task  
- Mark a task as completed  
- Exit the app  

The loop continues until the user chooses to exit.

---

### **3. `addTask()` Method**
Handles task creation logic.

#### Flow:
1. Uses a global `Scanner` object to take user input.
2. Prompts for:
   - Task **ID**
   - Task **Name**
3. Validates:
   - ID must be **unique** (checks list using `stream().anyMatch()`).
   - Name must **not be empty**.
4. If validation passes:
   - Creates a new `Task` object:
     ```java
     new Task(id, name)
     ```
   - Returns the `Task` object to be added to the main list.
5. If invalid:
   - Returns `null` and shows appropriate error message.

Finally, valid tasks are added to:
```java
List<Task> tasks = new ArrayList<>();
```

and displayed using:
```java
tasks.forEach(System.out::println);
```

---

### **4. `selectTaskAction()` Method**
- Displays the list of possible actions (`Add`, `Delete`, `Mark as Done`, `Exit`).
- Takes input from the user and returns the chosen action.
- The returned value is used in an `if-else` or `switch` statement to perform the required operation.

---

### **5. Application Behavior Controller**
Based on the user’s selected action:
- `Add` → Calls `addTask()`
- `Delete` → Calls `removeTask()`
- `Done` → Calls `markTaskCompleted()`
- `Exit` → Sets `isExit = true`

---

### **6. `markTaskCompleted()` Method**
Marks a task as completed.

#### Flow:
1. Takes Task ID as input.
2. Uses Java **Streams** to filter:
   ```java
   Optional<Task> taskOpt = tasks.stream()
       .filter(t -> t.getId() == inputId)
       .findFirst();
   ```
3. Uses **Optional** to handle potential null values:
   - If task is present → Calls `task.setCompleted(true)` and prints success message.
   - If task is not found → Displays “Task not found” message.

This approach ensures **null-safety** and clean, readable code.

---

### **7. `removeTask()` Method**
Deletes a task from the list.

#### Flow:
1. Takes Task ID as input.
2. Uses:
   ```java
   boolean removed = tasks.removeIf(t -> t.getId() == inputId);
   ```
3. If `removed == true` → Task deleted successfully.
4. Otherwise → Displays “Task not found.”

This method demonstrates concise and efficient list manipulation.

---

## 🧱 Core Class: `Task`
A simple model class representing a to-do item.

```java
public class Task {
    private int id;
    private String name;
    private boolean completed;

    // Constructor
    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.completed = false;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String toString() {
        return id + ". " + name + (completed ? " ✅" : " ❌");
    }
}
```

---

## 🧠 Key Concepts Practiced

| Concept | Description | Example |
|----------|--------------|----------|
| **Classes & Objects** | Core structure of Java OOP | `Task`, `ConsoleToDoList` |
| **Encapsulation** | Using private fields with public getters/setters | `Task` class |
| **Lists & Collections** | Storing and managing multiple tasks | `List<Task>` |
| **Streams & Optionals** | Clean filtering and null-safe lookups | `tasks.stream().filter(...).findFirst()` |
| **Validation Logic** | Preventing duplicates and empty inputs | Inside `addTask()` |
| **Console I/O** | Using `Scanner` for input | `scanner.nextLine()` |
| **Control Flow & Loops** | Menu-driven program with exit control | `while (!isExit)` |
| **Method Design** | Breaking logic into smaller reusable parts | `addTask()`, `markTaskCompleted()`, etc. |

---

## 🔍 Improvements Made During Development

| Issue Faced | Resolution |
|--------------|-------------|
| **Couldn’t access Task inside static context** | Moved `Task` out as a separate top-level class |
| **Duplicate task IDs allowed** | Added validation check before adding task |
| **Empty names being added** | Added input validation for task name |
| **Unsafe null access when searching tasks** | Used `Optional` with `isPresent()` |
| **Code cluttered inside main loop** | Refactored logic into smaller methods |

---

## 🧩 Possible Future Enhancements
- Add **edit task** feature.
- Implement **task persistence** (save to a file or database).
- Add **task priority or due dates**.
- Build a **simple GUI** using JavaFX or Swing.
- Add **sorting or filtering** by status.

---

## 🧾 Summary

This small console project demonstrates how to:
- Apply **OOP principles** effectively.
- Use **Java collections and streams** for data handling.
- Build clean and maintainable **modular code**.
- Practice **logical problem-solving** and **structured programming**.
