//Kasra Afkham

import java.util.Scanner;

public class AndhraBankAccountDriver {
    public static void main(String[] args) {

        AndhraBankAccount.setAnnualInterestRate(4.5);

        //welcome message
        System.out.println("Welcome to ANDHRA Bank\n\nToday's Interest Rate is = "
                + AndhraBankAccount.getAnnualInterestRate() + "%\n");

        AndhraBankAccount account = new AndhraBankAccount("", "", 100);

        Scanner scanner = new Scanner(System.in);

        boolean firstNameCheck = false;
        boolean lastNameCheck = false;

        //prompt user for first name until they enter a valid response
        while (!firstNameCheck) {
            System.out.print("Enter first name: ");
            String F_name = scanner.nextLine();
            firstNameCheck = account.nameChecker(F_name);
            if (firstNameCheck) account.setF_name(F_name);
        }
        //prompt user for last name until they enter a valid response
        while (!lastNameCheck) {
            System.out.print("Enter last name: ");
            String L_name = scanner.nextLine();
            lastNameCheck = account.nameChecker(L_name);
            if (lastNameCheck) account.setL_name(L_name);
        }

        //display newly created account details
        System.out.println("\nYour account details are:" +
                "\nName is: " + account.getF_name() + " " + account.getL_name() +
                "\nAccount Number is " + account.getAccountNb() +
                "\nCurrent balance is $" + account.getBalance() +
                "\nInterest Rate is = " + AndhraBankAccount.getAnnualInterestRate() + "%" +
                "\nMonthly interest for this balance is $" + account.getBalance() * 0.01 * account.getMonthlyInterestRate() +
                "\nThis account was created on " + account.getDateCreated());

        String userChoice = "";

        // ask for, validate, and execute user-selected action
        while (!userChoice.equals("2")) {
            scanner = new Scanner(System.in);
            System.out.print("\nEnter your choice (0: deposit, 1: withdraw, 2: quit): ");
            userChoice = scanner.nextLine();
            switch (userChoice) {

                //deposit
                case "0": {
                    do {
                        scanner = new Scanner(System.in);
                        System.out.print("\nEnter deposit amount in $");
                        //validate user input amount
                        if (scanner.hasNextDouble()) {
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            break;
                        } else System.out.println("Error: invalid amount");
                    } while (!scanner.hasNextDouble());
                }
                break;
                //withdrawal
                case "1": {
                    boolean b;
                    do {
                        scanner = new Scanner(System.in);
                        System.out.print("\nEnter withdrawal amount in $");
                        b = scanner.hasNextDouble();
                        //validate user input amount
                        if (b) {
                            double withdrawAmount = scanner.nextDouble();
                            if (withdrawAmount > account.getBalance()) {
                                System.out.println("Error: withdrawal amount too high. Overdraft not allowed.");
                                b = false;
                            } else {
                                account.withdraw(withdrawAmount);
                                break;
                            }
                        } else System.out.println("Error: invalid amount");
                    } while (!b);
                }
                break;
                //quit
                case "2": break;
                //invalid if user input is not 0, 1, or 2
                default: System.out.println("Error: invalid input");
                break;
            }
        }
        //display new balance & goodbye message
        System.out.print("\nNew balance is $" + account.getBalance() +
                "\n\nGoodbye!");
    }
}