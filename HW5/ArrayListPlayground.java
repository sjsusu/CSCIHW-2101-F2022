package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPlayground {
    public static void main(String[] args) {
        System.out.println("Start of HW5");
        // Question 1
        // Write Java statements that do the following:
        // a) Declare an arrayList nums of 15 elements of type Integer.
        ArrayList<Integer> nums = new ArrayList<Integer>(
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));

        // b) Output the value of the tenth element of the array nums. --> index 9
        System.out.println(nums.get(9));

        // c) Set the value of the 5th element of the array nums to 99. --> index 4
        nums.add(4, 99);

        // d) set the value of the 13th element to 15 --> index 12
        nums.add(12, 15);

        // e) set the value of the 2nd element to 6 --> index 1
        nums.add(1, 6);

        // f) Set the value of the 9th element of the array nums to the sum of the 13th
        // and 2nd elements of the array nums. --> index 8
        nums.add(8, nums.get(12) + nums.get(1));
        // --------------------------------------------------------------------------------

        // Question 2
        // a) create an arrayList of Strings that contain each day of the week.(starting
        // on monday)
        ArrayList<String> days = new ArrayList<String>();
        days.add("monday");
        days.add("tuesday");
        days.add("wednesday");
        days.add("thursday");
        days.add("friday");
        days.add("saturday");
        days.add("sunday");

        // b) output each of the days of the week
        System.out.println(days);

        // c) output the days of the week that we have class
        System.out.println("We have class on " + days.get(1) + " and " + days.get(3));

        // d) change the arrayList to start on Sunday
        Collections.rotate(days, 1);
        // --------------------------------------------------------------------------------

        // Question 3
        // a) create an ArrayList and prompt the user for numbers to add to it until the
        // number 0 is selected
        ArrayList<Integer> userNums = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int num = 1;
        while (num != 0) {
            System.out.println("Enter a number to add to the list. Enter 0 to stop.");
            num = scan.nextInt();
            userNums.add(num);
        }
        // b) return the largest and smallest number
        int max = Collections.max(userNums);
        System.out.println("Max: " + max);
        
        int min = Collections.min(userNums);
        System.out.println("Min: " + min);

        // c) return the ArrayList sorted smallest to largest
        Collections.sort(userNums);

        // d) take that ArrayList see if its size is divisable by 3 and then output the
        // ArrayList in a matrix format
        // NOTE: make the matrix n X 3 so it can be n rows by 3 columns
        // EX. ArrayList [1,2,3,4,5,6,7,8,9]
        // 1 2 3
        // 4 5 6
        // 7 8 9
        // NOTE: If the ArrayList is NOT divisable by 3 ask the user for more numbers
        // and add them until it is
        // ArrayList Size: 7
        // Please enter 2 more numbers to create the matrix...
        //
        // Hint 1: use collections sort to sort the numbers
        // Hint 2: you can see if the size of the array list is divisible by 3 by
        // running:
        // numbers.size()%3==0
        // Hint 3: You can use this logic to print the array list in a 3x3 pattern once
        // its created:
        // for(int i=0;i<numbers.size();i++)
        // {
        // System.out.print(numbers.get(i)+" ");
        // if((i+1)%3==0)
        // {
        // System.out.println();
        // }
        // }

        while (userNums.size() % 3 != 0) {

            if (userNums.size() % 3 == 1) {
                System.out.println("Please enter 2 more number to create the matrix...");

            } else if (userNums.size() % 3 == 2) {
                System.out.println("Please enter 1 more numbers to create the matrix...");

            }

            num = scan.nextInt();
            userNums.add(num);
        }

        int position = 0;
        for (int i = 0; i < userNums.size()/3; i++) {
            for (int j = 0; j < 3;j++) {
                System.out.print(userNums.get(position) + " ");
                position++;
            }
            System.out.println();
        }

        scan.close();

    }
}
