package HW1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of HW1");

        //nextLine error: https://www.freecodecamp.org/news/java-scanner-nextline-call-gets-skipped-solved/
        Scanner scan = new Scanner(System.in);

        // This is our Main Method. Any code we write here will be executed when we run
        // the program.
        // Write some code here to print out "Hello World" to the console.

        // Write some code here to print out the sum of 2 and 3 to the console.

        int num1 = 2;
        int num2 = 3;
        int sum = num1 + num2;
        System.out.println(sum);

        // You will see another file called Pyramid.java
        // Write some code here to call the Output method from the Pyramid class.
        // Note: Since Pyramid is a static method you will need to call it like this:
        // Class.Method()
        // Note2: Look at Pyramid.java for more information

        System.out.print("Height for Pyramid: ");
        int height = Integer.parseInt(scan.nextLine());

        Pyramid.Output(height);

        // Now look at the next file called Adlibs.java
        // Write some code here to call the story method from the Adlibs class.
        // Note: Since story is not a static method you will need to create an object of
        // the Adlibs class
        // and then call the method on that object.
        // Remember to create an object like this:
        // ClassName ObjectName = new ClassName();
        // Remember to call objects like this:
        // Object.Method()
        // Note2: the story method returns a String type so you will
        // need to print out the result of the method call.
        // Note3: Look at Adlibs.java for more information

        System.out.print("Name: ");
        String name = scan.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scan.nextLine());

        System.out.print("Favorite Color: ");
        String favoriteColor = scan.nextLine();

        Adlibs adlib = new Adlibs();
        String story = adlib.story(name, age, favoriteColor);
        System.out.println(story);

        // Finally look at File called Replace.java. This is a little more difficult.
        // Write some code here to call the charReplace method from the Replace class.
        // Note: Since charReplace is not a static method you will need to create an
        // object of the Replace class
        // and then call the method on that object.
        // Remember to create an object like this:
        // ClassName ObjectName = new ClassName();
        // Remember to call objects like this:
        // Object.Method()
        // Note2: the charReplace method returns a String type so you will
        // need to print out the result of the method call.
        // Note3: Look at Replace.java for more information

        System.out.print("String: ");
        String str = scan.nextLine();

        System.out.print("Index: ");
        int index = Integer.parseInt(scan.nextLine());

        //Char input: https://stackoverflow.com/questions/13942701/take-a-char-input-from-the-scanner
        System.out.print("Char:");
        char c = scan.nextLine().charAt(0);

        Replace rep = new Replace();
        String replacedStr = rep.charReplace(str, index, c);
        System.out.println(replacedStr);

        scan.close();

    }
}
