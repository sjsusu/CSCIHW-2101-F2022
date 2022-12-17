package Project3;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int lives;
    private int livesLost;
    ArrayList<Integer> answers = new ArrayList<>();
    int currentAnswer = 0;


    public Player(){
        lives = 10;
    }

    public Player (int lives){
        this.lives = lives;
    }

    public int getLives(){
        return lives;
    }

    public int getLivesLost(){
        return livesLost;
    }

    public void death(){
        lives -= 1;
        livesLost += 1;
    }

    static Scanner scan = new Scanner(System.in);

    public int leftOrRight() {
        char choice = ' ';

        do {
            System.out.println("L or R? ");
            choice = scan.next().charAt(0);

            if (choice != 'L' && choice != 'l' && choice != 'R' && choice != 'r') {
                System.out.println("Invalid Choice. Try again.");
            }

        } while (choice != 'L' && choice != 'l' && choice != 'R' && choice != 'r');

        int direction = -1;

        if (choice == 'L' || choice == 'l'){
            System.out.println("L selected");
            direction = 0;
        }else if (choice == 'R' || choice == 'r'){
            System.out.println("R selected");
            direction = 1;
        }

        answers.add(direction);
        return direction;
    }

    public void checkAnswer (int answer, Ladder ladder){
        if (answer == 0 && ladder.panels[ladder.currentRow][0] == 1){
            ladder.nextRow();
            checkWin(ladder);
            System.out.println("Nice Job Next Round");

        }else if (answer == 1 && ladder.panels[ladder.currentRow][1] == 1){
            ladder.nextRow();
            checkWin(ladder);
            System.out.println("Nice Job Next Round");

        }else {
            death();
            checkLoss(ladder);
            System.out.println("You lost 1 life");

        }

        System.out.println("--------------------------");
    }

    public void checkWin(Ladder ladder){
        if (ladder.currentRow == ladder.panelRows){
            PrintMethods.printWinMessage();
            ladder.printLadder("answer");
            System.exit(0);
        }
    }

    public void checkLoss(Ladder ladder) {
        if (lives == 0){
            ladder.printLadder("current");
            PrintMethods.printLoseMessage(livesLost);
            System.exit(0);

        }
    }

}
