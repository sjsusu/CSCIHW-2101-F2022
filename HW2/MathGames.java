package HW2;

import java.util.Scanner;

public class MathGames {
    Scanner scan = new Scanner(System.in);

    // Asks for a non-negative (>=0) double from the user
    double askDouble(String prompt, String lessThanZeroMessage) {
        double num;

        do {
            System.out.print(prompt);
            num = scan.nextDouble();

            if (num < 0) {
                System.out.println(lessThanZeroMessage);
            }

        } while (num < 0);

        return num;
    }

    // 1. Create a method that will calculate the Pythagorean Theorem
    // (https://en.wikipedia.org/wiki/Pythagorean_theorem)
    // c = sqrt(a^2+b^2)
    // NOTE: You can assume you will only need to calculate the Hypotenuse
    // Hint 1: Method should take in 2 sides(a and b) of the triangle and return the
    // missing side.
    // Remember the Triangle has a base, Perpendicular, and Hypotenuse
    // Hint 2: Math.pow and Math.sqrt are your friend here
    // Bonus points: Try to make it accept any 2 sides and return the 3rd. So it can
    // take in
    // Hypotenuse and Perpendicular and return the base.

    double askSide(char letter) {
        String prompt = "side " + letter + ": ";
        String lessThanZeroMessage = "You can't have a negative length. Try again.";

        double length = askDouble(prompt, lessThanZeroMessage);

        return length;
    }

    double CalcMissingSide(double a, double b, double c) {
        double missingSide = 0;

        if (a != 0 && b != 0 && c != 0) {
            System.out.println("Please enter no more than 2 side lengths.");

        } else if (a == 0 && b == 0 && c == 0) {
            System.out.println("Please enter 2 side lengths.");

        } else if ((a == 0 && b == 0) || (a == 0 && c == 0) || (b == 0 && c == 0)) {
            System.out.println("Please enter one more side length.");

        } else if (c != 0) {
            missingSide = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2) - Math.pow(b, 2));

        } else {
            missingSide = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        }

        return missingSide;
    }

    // 2. Create a method that will calcuate my grade in the class. You can use the
    // grade range as follows
    // A: 100 - 90
    // B: 89 - 80
    // C: 79 - 70
    // D: 69 - 60
    // F: 60 - 0
    // method should accept the grade as a double and return the letter grade of
    // what I got
    // NOTE: Im a really nice guy and always round up on my grading so a 69.3 will
    // round up to a 70.0
    // Hint 1: if statements are your friend here you will probably need at the
    // least 5 if / ifelse / else statments
    // Hint 2: You will probably need to cast the double to an int
    // Hint 3: You will probably need to use the Math.ceil() method

    double askNum() {
        String prompt = "Please enter a number grade: ";
        String lessThanZeroMessage = "You can't have a negative grade. Try agian.";

        double num = askDouble(prompt, lessThanZeroMessage);

        return num;
    }

    char calcGrade(double numGrade) {
        char grade = 'F';
        int num = (int) Math.ceil(numGrade);

        if (num >= 90) {
            grade = 'A';

        } else if (num >= 80 && num <= 89) {
            grade = 'B';

        } else if (num >= 70 && num <= 79) {
            grade = 'C';

        } else if (num >= 60 && num <= 69) {
            grade = 'D';

        }

        return grade;
    }

    // 3. Create a method that will calculate the tip on a bill per person
    // Method parameters: total bill, amount of people splitting the bill,
    // percentage to tip.
    // Note: I would like the total always rounded up to a whole number
    // Hint 1: percentage can be made easier to work with if you divide by 100 so
    // 18% is 18/100 = 0.18
    // Hint 2: Using doubles will be helpful for when you need to calculate decimals
    // Hint 3: It is possible you might need to Cast a double to an int or vice
    // versa
    // Hint 4: You will probably need to use the Math.ceil() method

    double askBill() {
        String prompt = "Bill total: $";
        String lessThanZeroMessage = "You can't have a negative total. Try again.";

        double total = askDouble(prompt, lessThanZeroMessage);

        return total;
    }

    int askNumPeople() {
        int numPeople;

        do {
            System.out.print("Number of People Paying: ");
            numPeople = scan.nextInt();

            if (numPeople == 0) {
                System.out.println("You must have at least one person paying. Try again.");

            } else if (numPeople < 0) {
                System.out.println("You can't have negative people. Try again.");

            }

        } while (numPeople < 1);

        return numPeople;
    }

    double askpercentTip() {
        String prompt = "Percent tip: ";
        String lessThanZeroMessage = "You can't have a negative % tip. Try again.";

        double percentTip = askDouble(prompt, lessThanZeroMessage);

        percentTip /= 100;
        return percentTip;
    }

    double calcTipPerPerson(double bill, int people, double percentTip) {
        double tipPerPerson = (bill * percentTip) / people;
        tipPerPerson = Math.ceil(tipPerPerson);

        return tipPerPerson;
    }

}