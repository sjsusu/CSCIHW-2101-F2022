package Project1;

import java.util.Scanner;

public class ExtraMethods {
    Scanner scan = new Scanner(System.in);

    // Accepts a non-negative integer from user and returns response
    int askInt(String prompt, String lessThanZeroMessage) {
        int response;

        do {
            System.out.println(prompt);
            response = scan.nextInt();

            if (response < 0) {
                System.out.println(lessThanZeroMessage);
            }

        } while (response < 0);

        return response;
    }

    // Accepts a non-negative double from user and retrurns response
    // Same from HW2
    double askDouble(String prompt, String lessThanZeroMessage) {
        double response;

        do {
            System.out.println(prompt);
            response = scan.nextDouble();

            if (response < 0) {
                System.out.println(lessThanZeroMessage);
            }

        } while (response < 0);

        return response;
    }

    // Gives and accepts 2 choices (1) or (2) from the user and returns response
    int askChoice(String prompt, String choice1, String choice2) {
        int choice;

        do {
            System.out.println(prompt + " (1 for " + choice1 + " || 2 for " + choice2 + ")");
            choice = scan.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid Choice. Try again.");
            }

        } while (choice != 1 && choice != 2);

        return choice;
    }

    // Accepts only either 1(yes) or 2(no) from user and returns response
    int YesOrNo(String prompt) {
        int response = askChoice(prompt, "yes", "no");
        return response;
    }

    // Prints exit message for menu
    void printExitMessage() {
        System.out.println("-------------------------------------------");
        System.out.println("Thank you for using the Bank Account Tester\n");

    }
}
