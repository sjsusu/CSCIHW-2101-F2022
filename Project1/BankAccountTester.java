package Project1;

import java.util.Scanner;

public class BankAccountTester {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ExtraMethods extra = new ExtraMethods();

        // Example Bank Account used for Transfer Methods
        BankAccount gregChecking = new BankAccount("Greg", 20000);
        BankAccount account = new BankAccount();

        System.out.println("Welcome to the Bank Account Tester");
        System.out.println("----------------------------------");

        int isYes = extra.YesOrNo("Would you like to create an account?");
        if (isYes == 1) {
            account.modifyAccount();

            boolean isSavings = account.checkSavings();
            if (isSavings) {
                account.interactSavings();

            } else {
                BankAccount.interact(account, gregChecking);

            }
        } else {
            extra.printExitMessage();
        }

        scan.close();
    }
}
