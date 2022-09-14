# Assignment-4---Andhra-Bank-Account
simple bank account program that: 
a) creates an account for the user when given appropriate information
b) processes deposit/withdrawal instructions without allowing overdraft

Develop a class called AndhraBankAccount (in AndhraBankAccount.java file) that contains:

• A method called getMonthlyInterestRate() that returns the monthly interest rate.
• A method called withdraw that withdraws a specified amount from the account.
• A method called deposit that deposits a specified amount to the account.

You should include appropriate data validation checks, e.g., balance should not be negative, name can include spaces, etc.

Write a driver class called AndhraBankAccountDriver (in AndhraBankAccountDriver.java file) that
uses the Account class to perform the following:

- Displays a welcome message “Welcome to ANDHRA Bank”
- Sets up an interest rate of 4.5% and displays the interest rate as today’s interest rate.
- Prompts the user for first name, last name. Create an account with an initial balance of $100.
- Displays the account details including monthly interest on the current balance.
- Allows user to deposit and withdraw as many times as they want.
- Finally, ends with a good-bye message.

Your test program should access (i.e., get or set method) the static field annualInterestRate before creating accounts, and via an account object.
