package Project3;

import java.util.Scanner;

public class PrintMethods {

    static Scanner scan = new Scanner(System.in);

    public static void printLegend() {
        System.out.println("---------LEGEND-----------");
        System.out.println("0: Glass");
        System.out.println("1: Tempered Glass");
        System.out.println("--------------------------");
    }

    public static void printWinMessage() {
        System.out.println("Congrats You Won!");
    }

    public static void printLoseMessage(int livesLost) {
        if (livesLost == 1) {
            System.out.println("You lost 1 life.");
        } else {
            System.out.println("You lost " + livesLost + " lives.");
        }

        System.out.println("Total Lives: 0");
        System.out.println("YOU DIED");

    }

    public static void printLives(int lives) {
        System.out.println("Total Lives: " + lives);
    }

    public static void printCurrentPlace(int place) {
        System.out.println("Current Place in the Ladder: " + place);
    }

    public static void printRound(int round) {
        System.out.println("Round: " + round);
    }

}
