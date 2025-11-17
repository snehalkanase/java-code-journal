ATM PROJECT – FULL DOUBTS, MISTAKES, AND SOLUTIONS (UPDATED)

Beginning of the project
I started building an ATM app with Login, Account, and App classes.
My first approach had wrong inheritance, infinite recursion, wrong deposit logic, and confused separation of responsibilities.

Mistake: Login class extending Account
This was the biggest structural mistake.
Login is not an account type.
This led to wrong constructor calls and unnecessary coupling.

Problem: “No-arg constructor not available”
Reason:
Account only had a parameterized constructor.
Java removes default constructor if any constructor is written.
Subclasses must call super(accountNumber, password).
Because Login extended Account incorrectly, this error kept showing.

My Recursion Mistake
In my older code, I wrote methods like:

getChecking();
getChecking();
getChecking();

Inside each option of the switch.
Example:

case 1:
System.out.println(balance);
getChecking();
break;


This caused infinite recursion because:

• Every call to getChecking() created a new call frame
• No loop controlled the flow
• Repeated calls filled the call stack
• Eventually risked StackOverflowError

Correct approach is:

Use loop instead of recursion.

Mistake: No exit condition in login loop
Old code:

do {
login...
} while (!exit)


But exit was controlled by inside menu only.
If login fails repeatedly, program keeps looping forever without a break option.

Mistake: Poor validation
In withdrawal:
• No check for negative input
• No check for zero
• No check for non-numeric input
Console programs break easily without validation.

Mistake: deposit logic
I wrote:

if(amount < balance){
print error;
}


This is logically wrong.
Deposit must check:
• amount > 0
Not: amount < balance

Correct:

if(amount <= 0){
print error;
}


Mistake: Account responsibilities mixed
The old Account class managed:
• checkingAccountBalance
• savingAccountBalance
• Both in one Account

This was incorrect because:

• One account should be one type
• Should not mix multiple balance fields
• Should not keep both saving and checking balances in one instance

Mistake: Hardcoded HashMap in Login (old version)
I hardcoded:

accounts.put(98979695, 9897);


In the Login class itself.
This violates single-responsibility principle.
Data storage should be in a repository layer.

Mistake: Menu navigation
Old code used recursive calls like:
• getChecking() → call getSaving() → call getAccountType() → call getChecking()

Menus started calling each other repeatedly.

This caused:
• messy flow
• user confusion
• recursion stack growth

The correct approach is using iterative loops and menu switching, not recursive method calls.

Mistake: No abstraction usage
Initially, Account was normal class rather than abstract.
This allowed creating a generic Account instance, which is meaningless.
Proper design:
Account is abstract and only child classes define type.

Mistake: authenticate() returning null
Even valid credentials returned null due to:

• Constructors not being public
• AccountRepository not storing accounts properly
• Incorrect null checking
Solution:
Make constructors public and ensure authenticate method checks null safely.

Mistake: Comparing Integers incorrectly
Used:

if(account.getAccountNumber() == accountNumber)


This works only sometimes because of Integer caching.

Correct:

account.getAccountNumber().equals(accountNumber)


Correct final structure
• App → Start application
• LoginService → Handles login
• AccountRepository → Stores accounts
• Account (abstract) → defines common logic
• CheckingAccount / SavingAccount → concrete types
• ATMMenu → handles UI + operations (withdraw, deposit, check balance)

What I finally understood
• How constructors work
• Why recursion should be avoided in menu-driven console apps
• Why separation of concerns matters
• Why Login should not extend Account
• Why loops are better than recursive menus
• How proper authentication works
• Why making methods public/private matters
• Cleaner architecture principles (SRP, OOP design)