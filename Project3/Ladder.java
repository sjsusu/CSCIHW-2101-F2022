package Project3;

public class Ladder {
    int panelRows = 5;
    int currentRow = 0;
    int[][] panels = new int[panelRows][2];
    String ladderStart = "||||| ---- Start";
    String ladderFinish = "||||| ---- Finish";

    public Ladder(int panelRows) {
        this.panelRows = panelRows;
    }

    public Ladder() {
        panelRows = 5;
    }

    public int getPanelRows() {
        return panelRows;
    }

    public void nextRow() {
        currentRow += 1;
    }

    public void createLadder() {
        for (int i = 0; i < panelRows; i++) {
            int random = (int) (Math.random() * 2);
            panels[i][0] = random;

            if (random == 0) {
                panels[i][1] = 1;
            } else {
                panels[i][1] = 0;
            }

        }
    }

    public void printBlankLadder() {
        System.out.println(ladderStart);
        for (int i = 0; i < panelRows; i++) {
            System.out.println("| | |");
        }
        System.out.println(ladderFinish);
    }

    public void printLadder(String type) {
        System.out.println(ladderStart);

        for (int i = 0; i < currentRow; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("|" + panels[i][j]);
            }

            System.out.println("|");
        }

        if (type.equalsIgnoreCase("answer")) {
            printLadderFinish();

        } else if (type.equalsIgnoreCase("current")) {
            System.out.println("|?|?|");

        } 
    }

    public void printLadderFinish() {
        System.out.println(ladderFinish);
    }

}
