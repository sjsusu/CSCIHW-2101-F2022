package Project3;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Ladder ladder = new Ladder();
        int round = 1;

        ladder.createLadder();
        ladder.printBlankLadder();
        
        do {
            PrintMethods.printLives(player.getLives());

            if (round >1) {
                ladder.printLadder("current");
            }

            PrintMethods.printLegend();
            PrintMethods.printCurrentPlace(ladder.currentRow);
            PrintMethods.printRound(round);
            System.out.println();

            int answer = player.leftOrRight();
            player.checkAnswer(answer, ladder);

            round++;

        } while (round != 2 * player.getLives());

    }
}
