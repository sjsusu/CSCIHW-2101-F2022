package HW1;

/*
Make the output look like this:
#
##
###
####
#####
####
###
##
#
Hint: the object is created for you (Pyramid) and so is the method (Output)
Hint2: Also notice the method is void meaning you will not be returning anything
*/
public class Pyramid {
    public static void Output(int height) {
        // Put your code here
        if (height > 0) {

            // Top half of pyramid
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }

            // Bottom Half of Pyramid
            int bottomHeight = height - 1;
            for (int i = 0; i < bottomHeight; i++) {
                for (int j = 0; j < bottomHeight - i; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }
        } else {
            System.out.println("Please enter a height 1 or greater.");
        }
    }
}
