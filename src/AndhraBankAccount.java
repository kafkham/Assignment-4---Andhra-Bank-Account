//Kasra Afkham

import java.time.LocalDateTime;

public class AndhraBankAccount {

    private static double annualInterestRate;
    private static int nextAccountNb = 300;
    private final int accountNb;
    private String f_name;
    private String l_name;
    private double balance;
    private final LocalDateTime dateCreated;

    // account constructor
    public AndhraBankAccount(String f_name, String l_name, double balance) {
        this.accountNb = nextAccountNb;
        nextAccountNb++; // add 1 so the next account number can be properly assigned
        this.f_name = f_name;
        this.l_name = l_name;
        this.balance = balance;
        this.dateCreated = LocalDateTime.now();
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        AndhraBankAccount.annualInterestRate = annualInterestRate;
    }

    public int getAccountNb() {
        return accountNb;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return getAnnualInterestRate() / 12;
    }

    public void withdraw(double withdrawAmount) {
        //subtract withdrawal amount from balance and set the result as the new balance
        setBalance(getBalance() - withdrawAmount);
    }

    public void deposit(double depositAmount) {
        //add deposit amount to balance and set the result as the new balance
        setBalance(getBalance() + depositAmount);
    }

    public boolean nameChecker(String name) {
        //Name must contain at least one character. The first character must be alphanumeric.
        char c = name.charAt(0);
        if (!isALetter(c)) {
            System.out.println("Error: invalid name");
            return false;
        }
        //loop will verify each char
        for (int i = 0; i < name.length(); i++) {
            c = name.charAt(i);
            //special statement for the final character of the prefix, since d would otherwise be out of range
            if (i == name.length() - 1) {
                //return true if the final character is alphanumeric and is not a special character
                boolean b = isALetter(c) && ((c != ' ') && (c != '-'));
                if (b) return true;
                else {
                    System.out.println("Error: invalid name");
                    return false;
                }
            }
            /*
            name should contain only alphanumeric characters, spaces (‘ ’) or dashes (‘-’)
            a space or a dash must always be followed by one or more alphanumeric characters

            (!isValidChar(c)): calls ValidChar method to verify whether c is valid
            if c is not valid, the method will return false and the expression will return true
            then the if statement will execute and the overall method (isValidPrefix) will return false

            ((c == ' ') || (c == '-')): verifies whether (c) is one of the special characters
            !isAlphanumeric(d): calls isAlphanumeric method to verify if (d), the character after (c), is alphanumeric
            if both statements above return true (i.e. (c) is a special character and (d) is not alphanumeric)
            then the if statement will execute and the overall method (isValidPrefix) will return false
            */
            char d = name.charAt(i + 1);
            if ((!isValidChar(c)) || (((c == ' ') || (c == '-')) && !isALetter(d))) {
                System.out.println("Error: invalid name");
                return false;
            }
        }
        return true;
    }

    public static boolean isALetter(char aC) {
        //return true if c is a letter
        return (Character.isLetter(aC));
    }

    public static boolean isValidChar(char pC) {
        //return true if c is a letter, a space or a dash
        return (isALetter(pC) || pC == ' ' || pC == '-');
    }
}