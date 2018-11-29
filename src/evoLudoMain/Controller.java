package evoLudoMain;


public class Controller {

    private static Controller instance = null;
    private  String[] whoseTurnIsIt = new String[]{"red", "blue", "green", "yellow"};
    private  int turn = 0;
    private  Board board;

    public static Controller getInstance() {
        if (instance == null)
            instance = new Controller();




        return instance;
    }


    public Controller() {

    }

    public  void moveToken(int whereTo, int chosenToken) {
        String whichPlayers = whoseTurn();
        if (whichPlayers.equalsIgnoreCase("red")) {
            whereTo += board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken);
            board.getMyContainingJPanel().getTokens().getRedTokens().replace(chosenToken, whereTo);
        }

        else if (whichPlayers.equalsIgnoreCase("blue")) {
            whereTo += board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken);
            board.getMyContainingJPanel().getTokens().getBlueTokens().replace(chosenToken, whereTo);

        }

        else if (whichPlayers.equalsIgnoreCase("green")) {
            whereTo += board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken);
            board.getMyContainingJPanel().getTokens().getGreenTokens().replace(chosenToken, whereTo);
        }
        else {
            whereTo += board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken);
            board.getMyContainingJPanel().getTokens().getYellowTokens().replace(chosenToken, whereTo);
        }


        System.out.println("whoseTurn: \t" + whoseTurn());
        System.out.println("whichToken: \t" + chosenToken);
        System.out.println("whereTo: \t" + whereTo);

        board.getMyContainingJPanel().repaint();

        if (turn < 3) {
            turn += 1;
        }

        else if (turn == 3) {
            turn = 0;
        }

        nextTurn();

    }

    public  void nextTurn() {
        if (whoseTurn().equalsIgnoreCase("red")) {
            board.getRedsYard().getDiceRollerButton().setEnabled(true);
            board.getBluesYard().getDiceRollerButton().setEnabled(false);
            board.getGreensYard().getDiceRollerButton().setEnabled(false);
            board.getYellowsYard().getDiceRollerButton().setEnabled(false);
        } else if (whoseTurn().equalsIgnoreCase("blue")) {
            board.getRedsYard().getDiceRollerButton().setEnabled(false);
            board.getBluesYard().getDiceRollerButton().setEnabled(true);
            board.getGreensYard().getDiceRollerButton().setEnabled(false);
            board.getYellowsYard().getDiceRollerButton().setEnabled(false);
        } else if (whoseTurn().equalsIgnoreCase("green")) {
            board.getRedsYard().getDiceRollerButton().setEnabled(false);
            board.getBluesYard().getDiceRollerButton().setEnabled(false);
            board.getGreensYard().getDiceRollerButton().setEnabled(true);
            board.getYellowsYard().getDiceRollerButton().setEnabled(false);
        } else if (whoseTurn().equalsIgnoreCase("yellow")) {
            board.getRedsYard().getDiceRollerButton().setEnabled(false);
            board.getBluesYard().getDiceRollerButton().setEnabled(false);
            board.getGreensYard().getDiceRollerButton().setEnabled(false);
            board.getYellowsYard().getDiceRollerButton().setEnabled(true);
        }
    }

    public  void drawMove() {
        board.getMyContainingJPanel().refreshMoves();
    }


    public  String whoseTurn() {
        return whoseTurnIsIt[turn];
    }


    public void setBoard(Board board) {
        this.board = board;
    }
}
