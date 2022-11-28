package HW3;

import java.util.Scanner;

public class Loops {

    static Scanner scan = new Scanner(System.in);

    // NOTE: DO NOT change anything in the boiler plate
    // If I added default code it is meant to be there
    // and should not be adjusted unless otherwise noted
    // (return statments are usually changed)

    // Make a method that will return true if a given
    // String contains between 1 and 3 'e' chars.
    // Ex.
    // loopE("eat") -> true
    // eeat -> true
    // eeeat -> true
    // eeeeat -> false

    public static boolean loopE(String str) {
        char[] strChars = str.toCharArray();
        int length = str.length();
        int count = 0;

        for (int i = 0; i < length; i++) {

            if (strChars[i] == 'e') {
                count++;
            }

            if (count > 3) {
                break;
            }
        }

        if (count == 0 || count > 3) {
            return false;
        }

        return true;
    }

    // Given a String str and int n return a larger string
    // that is n copies of the original string
    // Ex.
    // stringTimes("Code",2) ->"CodeCode"
    // stringTimes("Code",4) ->"CodeCodeCodeCode"
    public static String stringTimes(String str, int n) {
        String str2 = str;

        for (int i = 0; i < n - 1; i++) {
            str2 += str;
        }

        return str2;
    }

    // Create a method Given a string, return the string where all of the "z"
    // Have been removed. Except do not remove a z at the start
    // or end
    // Ex.
    // stringZ("zHelloz") -> "zHelloz"
    // stringZ("nozthaznks") -> "nothanks"
    // stringZ("xksiazdjaasldzsajzasdz") -> "xksiadjaasldsajasdz"
    public static String stringZ(String str) {
        int length = str.length();
        char[] strChars = str.toCharArray();

        char c = strChars[0];
        String str2 = Character.toString(c);

        for (int i = 1; i < length - 1; i++) {
            if (strChars[i] != 'z') {
                str2 += strChars[i];
            }
        }

        str2 += strChars[length - 1];

        return str2;
    }

    // Create a method that contains a while loop that allows for
    // The user to input numbers until the number 0 is entered. Each time a number
    // is
    // entered the total will be summed and then prompted for a second number.
    // NOTE: I require the use of scanner here to get each integer from the user
    // Assume the numbers entered are integers
    // Also note that the method is void meaning you will not need to return
    // anything
    // It will need to sysout the numbers however
    // Below is a sample output what I would like
    // I will add up the numbers you give me....
    // Number: 12
    // The total so far is 12.
    // Number: 2
    // The total so far is 14.
    // Number: 3
    // The total so far is 17.
    // Number: 4
    // The total so far is 21.
    // Number: 1
    // The total so far is 22.
    // Number: 2
    // The total so far is 24.
    // Number: 3
    // The total so far is 27.
    // Number: 0
    // TOTAL ENDED --- The total is 27.
    public static void sums() {

        int num = -1;
        int total = 0;

        System.out.println("I will add up the numbers you give me.");

        while (num != 0) {
            System.out.print("Number: ");
            num = scan.nextInt();
            total += num;

            if (num != 0) {
                System.out.println("The total so far is " + total + ".");
            }
        }

        System.out.println("TOTAL ENDED --- The total is " + total + ".");

    }

    public static void main(String[] args) {
        // Add code to help test your methods here
        System.out.println("Start of Main");

        // Loop E
        System.out.println("----------Loop-E----------");
        System.out.print("Please enter a string: ");
        String str = scan.nextLine();

        boolean isLoopE = loopE(str);
        System.out.println(isLoopE);

        // //String Times
        System.out.println("--------String-Times--------");
        System.out.println("Please enter a word.");
        str = scan.nextLine();
        int times = askIntMin("How many times would you like to repeat the word?",
                "A minimum integer of 1 is required. Try again.", 1);

        String str2 = stringTimes(str, times);
        System.out.println(str2);

        // String z
        System.out.println("---------String-Z---------");
        System.out.println("Please enter a word.");
        str = scan.nextLine();

        str2 = stringZ(str);
        System.out.println(str2);

        // Sums
        System.out.println("-----------Sums-----------");
        sums();

        scan.close();

    }

    // Modified so there is a minimum value accepted from user
    public static int askIntMin(String prompt, String errorMessage, int min) {
        int num = min - 1;

        do {
            System.out.println(prompt);
            num = Integer.parseInt(scan.nextLine());

            if (num < min) {
                System.out.println(errorMessage);
            }

        } while (num < min);

        return num;

    }

}
