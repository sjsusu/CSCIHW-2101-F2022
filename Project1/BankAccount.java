package Project1;

import java.util.Scanner;

/*
 * This is a Java Doc
 * This is a multi-line comment
 *  
 * Our BankAccount class will represent a bank account
 * It will have a balance and a name
 * It will have methods to deposit and withdraw money
 * It will have a method to print the balance
 * it will have a menu that the user can interact with
 * 
 * 
 */

public class BankAccount {
    static Scanner scan = new Scanner(System.in);
    static ExtraMethods extra = new ExtraMethods();

    private double balance;
    private String name;
    private double interestRate = 0.01;
    private int period = 4; // quarterly

    // Constructors
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }

    public BankAccount(double balance) {
        this.balance = balance;
        this.name = "No Name";
    }

    // Default Constructor
    public BankAccount() {
        this.balance = 0;
        this.name = "No Name";
    }

    // Getters and Setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
    // Setter is replaced w/ deposit and witdraw methods

    // Deposit money
    public void deposit(double amount) {
        if (amount >= 0) {
            this.balance += amount;
        }

    }

    // Withdraws money based on response from overdraft method
    public void withdraw(double amount) {
        int response = overdraft(amount);

        if (response == 1 || response == -1) {

            this.balance -= amount;
        }

    }

    /*
     * Checks if the user will incur an overdraft fee of $35 and returns an int
     * response:
     * If account balance is 0, the fee will automatically be added
     * 
     * If account after withdrawl is <0, the user will be asked if they would like
     * to continue:
     * If the response is yes (1), the fee will be applied.
     * If the response is no (2), the withdrawl will not continue.
     * 
     * returns -1, 1, or 2 based on user response:
     * -1: default value, returned if account had $0 or user could withdraw the
     * amount w/o issue
     * 1: user wishes to continue to withdraw and fee is applied
     * 2: user does not wish to continue withdrawl
     */
    public int overdraft(double withdrawl) {
        int response = -1;
        double balanceAfterWithdrawl = balance - withdrawl;

        if (balance <= 0 && withdrawl > 0) {
            System.out.println("You have been charged an overdraft fee of $35.");
            this.balance -= 35;

        } else if (balanceAfterWithdrawl < 0) {
            String prompt = "Warning, if you withdraw this amount you will be charged an overdraft fee of $35.\nDo you wish to continue?";

            response = extra.YesOrNo(prompt);

            if (response == 1) {
                this.balance -= 35;
            }

        }

        return response;
    }

    // Returns string that can be printed for balance
    public String printBalance() {
        return "Your Balance is: $" + balance;
    }

    // Subtract a monthly fee from the balance
    public void monthlyFee(double fee) {
        withdraw(fee);
    }

    /*
     * Calculates the interest on the balance using Compound interest
     * P(1 + R/n)^(nt) - P
     * P = Principal
     * R = Rate
     * n = number of times interest is compounded per year (annum)
     * t = number of years
     */
    public void calcCompoundInterest(double principal, int time, double rate, int annum) {
        double amount = principal * Math.pow(1 + (rate / annum), annum * time);
        double roundedamount = Math.round(amount * 100.0) / 100.0;
        double compinterest = amount - principal;
        compinterest = Math.round(compinterest * 100.0) / 100.0;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Current Period is: " + annum + " times per year");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Compound Interest after " + time + " years: $" + compinterest);
        System.out.println("Amount after " + time + " years: $" + roundedamount);
    }

    // Calculates Simple Interest from balance : A = P(1+rt)
    public void calcSimpleInterest(double principle, double rate, int time) {
        double amount = principle * (1 + rate * time);
        double rndAmount = Math.round(amount * 100) / 100;
        double interest = amount - principle;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Interest after " + time + " years: $" + interest);
        System.out.println("Amount after " + time + " years: $" + rndAmount);

    }

    // Print a menu to the user
    public static int menu() {
        int choice;
        System.out.println("Welcome to the Bank Account Menu");
        System.out.println("--------------------------------");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Transfer Money");
        System.out.println("4. Print Balance");
        System.out.println("5. Calculate Interest");
        System.out.println("6. Set up Savings Account");
        System.out.println("0. Exit");
        System.out.println("Please enter your choice: ");
        choice = scan.nextInt();
        return choice;
    }

    // Create a method that will interact with the user based on their choice from
    // the menu
    // This method will take a BankAccount object as an argument
    public static void interact(BankAccount account, BankAccount account2) {
        // get the choice from the menu
        int choice = menu();

        if (choice == 1) {
            double amount = extra.askDouble("How much would you like to deposit?",
                    "You can't deposit negative money. Try Again.");

            account.deposit(amount);
            System.out.println(account.printBalance());

            boolean isSavings = account.checkSavings();
            if (isSavings) {
                account.interactSavings();

            } else {
                account.choiceReturnToMenu(account, account2);
            }

        } else if (choice == 2) {
            double amount = extra.askDouble("How much would you like to withdraw?",
                    "You can't have negative money. Try again.");

            account.withdraw(amount);
            System.out.println(account.printBalance());

            account.choiceReturnToMenu(account, account2);

        } else if (choice == 3) {
            if (account.getBalance() <= 0) {
                System.out
                        .println("You currently have no balance to transfer. Please deposit money before transfering.");
                System.out.println("Returning to menu...");

                interact(account, account2);
            } else {
                account.transferMoney(account2);

                System.out.println("Transfer successful! " + account.printBalance());
                System.out.println(account2.getName() + "'s balance is now: " + account2.getBalance());

                account.choiceReturnToMenu(account, account2);

            }

        } else if (choice == 4) {
            System.out.println(account.printBalance());
            account.choiceReturnToMenu(account, account2);

        } else if (choice == 5) {
            int isCompound = extra.askChoice("Would you like to calculate compound or simple interest?", "compound",
                    "simple");
            int time = extra.askInt("What is the time in years to invest (Whole Numbers Only)?",
                    "You can't have negative years. Try again.");
            if (isCompound == 1) {
                account.calcCompoundInterest(account.getBalance(), time, account.interestRate, account.period);
            } else {
                account.calcSimpleInterest(account.getBalance(), account.interestRate, time);
            }

            extra.printExitMessage();

        } else if (choice == 6) {
            boolean isSavings = account.checkSavings();
            if (isSavings) {
                account.interactSavings();
            } else {
                System.out.println(
                        "You currently don't have enough saved for a savings account,\na minimum balance of $10,000 is required.");
                double missingBal = 10000 - account.getBalance();
                System.out.println(account.printBalance() + " You are missing $" + missingBal);

                account.choiceReturnToMenu(account, account2);
            }

        } else if (choice == 0) {
            extra.printExitMessage();

        } else { // this would catch 69420
            System.out.println("Invalid Choice. Try again.");
            interact(account, account2);
        }

    }

    // Gives the user a choice to return to the menu
    public void choiceReturnToMenu(BankAccount account, BankAccount account2) {
        int response = extra.YesOrNo("Would you like to return to the menu?");
        if (response == 1) {
            interact(account, account2);
        } else {
            extra.printExitMessage();
        }
    }

    // Transfers money from user's account to another account
    public void transferMoney(BankAccount Account2) {
        double amount = extra.askDouble("How much would you like to transfer?", "You can't transfer negative money");

        if (amount > balance) {
            System.out.println("You can't transfer more money than you have in your balance. Try again.");
            System.out.println(printBalance());

            transferMoney(Account2);
        } else {

            withdraw(amount);
            Account2.deposit(amount);
        }

    }

    // Updates name and/or balance when user is making account
    public void modifyAccount() {
        int isName = extra.YesOrNo("Would you like to enter a name for your account?");
        if (isName == 1) {
            System.out.println("Please enter a name.");
            String name = scan.nextLine();
            this.name = name;
        }

        int isBalance = extra.YesOrNo("Would you like to enter a balance for your account?");
        if (isBalance == 1) {
            double balance = extra.askDouble("Please enter a balance.",
                    "You can't have a negative balance. Try again.");
            this.balance = balance;
        }

    }

    // Checks if user has anough money in account to make a savings account and asks
    // user if they would like to make one
    public boolean checkSavings() {
        if (balance >= 10000) {
            int response = extra.YesOrNo(
                    "Based on your balance, you are eligible for a savings account.\nWould you like to make one?");

            if (response == 1) {
                return true;
            }
        }

        return false;
    }

    // Calculates compound or flat rate interest w/ fixed apy
    public void interactSavings() {
        int choice = extra.askChoice("Would you like a flat interest rate or compound interest?", "flat rate",
                "compound rate");
        double principal = askPrincipal();
        int time = extra.askInt("How many years would you like to calculate?",
                "You can't have negative years. Try again.");

        if (choice == 1) {
            double apy = 0.001;
            calcSimpleInterest(principal, apy, time);

        } else {
            double apy = 0.0001;
            calcCompoundInterest(principal, time, apy, period);

        }

        extra.printExitMessage();
    }

    // Accepts a non-negative principle that is a minimum of 10000 but not greater
    // than the user's balance
    public double askPrincipal() {
        double principal;
        do {
            principal = extra.askDouble("How much is your principal?",
                    "You can't enter a negative principal. Try again.");

            if (principal > balance) {
                System.out.println("You can't have a principal greater than your balance. Try again.");
            } else if (principal < 10000) {
                System.out.println("The minimum required principle is 10000. Try Again.");
            }

        } while (principal > balance || principal < 10000);

        return principal;
    }
}
