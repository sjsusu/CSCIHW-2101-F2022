package HW2;

import java.util.Scanner;

public class MathGamesTester {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        MathGames math = new MathGames();

        // Pythagorean Theorem Calculator
        System.out.println("\nPlease enter 2 side lengths of a triangle w/ sides a,b,and c.");
        System.out.println("(c is hypotenuse, enter 0 if side is not included)\n");

        double a = math.askSide('a');
        double b = math.askSide('b');
        double c = math.askSide('c');
        System.out.println();

        double missingSide = math.CalcMissingSide(a, b, c);
        System.out.println("Length of missing side: " + missingSide + "\n");

        // Grade Calculator
        double askNum = math.askNum();
        char grade = math.calcGrade(askNum);

        System.out.println("Grade: " + grade + "\n");

        //Tip on Bill per Person
        double bill = math.askBill();
        int people = math.askNumPeople();
        double percentTip = math.askpercentTip();
        System.out.println();

        double tipPerPerson = math.calcTipPerPerson(bill, people, percentTip);
        System.out.println("Tip per Person: $" + tipPerPerson);

        scan.close();

    }
}
