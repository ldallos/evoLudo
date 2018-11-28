package evoLudoMain;


public class Controller {

    private static Controller instance = null;
    private static String[] whoseTurnIsIt = new String[]{"red", "blue", "green", "yellow"};
    private static int turn = 3;
    private static Board board = new Board();
    private static int chosenToken = 0;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
            return instance;
        }

        return instance;
    }

    public Controller() {
        nextTurn();
    }

    public static void moveToken(int whereTo) {
        String whichPlayers = Controller.whoseTurn();
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


        System.out.println("whoseTurn: \t" + Controller.whoseTurn());
        System.out.println("whichToken: \t" + chosenToken);
        System.out.println("whereTo: \t" + whereTo);

        Controller.drawMove();

        if (Controller.turn < 3) {
            Controller.turn += 1;
        }

        else if (turn == 3) {
            Controller.turn = 0;
        }
    }

    public static void nextTurn() {
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

    public static void drawMove() {
        board.getMyContainingJPanel().refreshMoves();
    }


    public static String whoseTurn() {
        return whoseTurnIsIt[turn];
    }

    public static void setChosenToken(int chosenToken) {
        Controller.chosenToken = chosenToken;
    }

    public Board createBoard() {
        return this.board;
    }
}
