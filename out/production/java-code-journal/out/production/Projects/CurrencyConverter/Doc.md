# Currency Converter – Learning Notes

## 🎯 Overview
A console-based Java currency converter application with:
- User input handling
- Currency validation
- Conversion logic using exchange rates
- Clean separation of concerns across classes

---

## ✅ What I Learned
- How to structure an application using multiple classes:
    - **App** → User input and flow
    - **RateService** → Holds exchange rates and validates them
    - **ConverterService** → Conversion logic
- How to use a **HashMap** for storing and retrieving values.
- Importance of **input validation** using loops.
- Correct mathematical approach for currency conversion:

- How to avoid `NullPointerException` by checking values before using them.
- Why not to use unnecessary `static` variables for storing temporary values.
- Keeping constructor logic minimal and initializing static data only once.

---

## ❓ Doubts I Faced
1. Incorrect conversion results
- INR → USD gave large wrong values.

2. Scanner input issues
- `nextLine()` skipping user input after numeric entry.

3. How to re-ask for currency if user enters wrong value.

4. Exchange rates were getting reloaded multiple times due to constructor initialization.

5. Possible `null` return from `getRate()` if currency was missing.

---

## 🧠 Resolutions & Improvements

### ✔ Correct Conversion Formula
Original (wrong):

### ✔ Input Validation Loop
If currency not present in the map:
- Ask again until valid input is received.

### ✔ Exchange Rates Loaded Once
Replaced constructor initialization with static block so that the map loads only once.

### ✔ Removed Unnecessary Static Variables
`convertedAmount` was removed from class-level state and returned directly.

### ✔ Proper Handling of Scanner Input
Added `input.nextLine()` after numeric reading to avoid skipping prompts.

---

## 🧾 Final Result
Application now:
- Gives correct conversions for all currency combinations.
- Handles invalid input smoothly.
- Has clean and maintainable structure.
- Demonstrates good coding practices:
    - Single Responsibility
    - Separation of concerns
    - Input validation
    - Minimal shared state

---

## 📌 Files in Project
- `App.java` – User interaction and main loop
- `RateService.java` – Exchange rate storage and validation
- `ConverterService.java` – Currency conversion logic

---

## 🏁 Conclusion
A practical implementation of console-driven currency conversion that reinforced:
- Java fundamentals
- Clean architecture
- Correct calculations
- Real-time input handling
