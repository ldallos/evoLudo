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
        if (whichPlayers.equalsIgnoreCase("red"))
            redsTurn(whereTo, chosenToken);
        else if (whichPlayers.equalsIgnoreCase("blue"))
            bluesTurn(whereTo, chosenToken);

        else if (whichPlayers.equalsIgnoreCase("green"))
            greensTurn(whereTo, chosenToken);
        else
            yellowsTrun(whereTo, chosenToken);


        System.out.println("whoseTurn: \t" + whoseTurn());
        System.out.println("whichToken: \t" + chosenToken);
        System.out.println("whereTo: \t" + whereTo);


        board.getMyContainingJPanel().repaint();

        nextTurn();

    }



    public  void nextTurn() {


        if (turn < 3) {
            turn += 1;
        }

        else if (turn == 3) {
            turn = 0;
        }


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

    public  String whoseTurn() {
        return whoseTurnIsIt[turn];
    }


    public void setBoard(Board board) {
        this.board = board;
    }

    private void redsTurn(int whereTo, int chosenToken) {

        if ((board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken) == 76 || board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken) == 77 ||
                board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken) == 78 || board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken) == 79) && whereTo != 6) {
            whereTo = 0;
        }


        else if ((board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken) == 76 || board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken) == 77 ||
                board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken) == 78 || board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken) == 79) && whereTo == 6) {
            board.getMyContainingJPanel().getTokens().getRedTokens().replace(chosenToken, 0);
            whereTo = 0;
        }


        whereTo += board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken);
        board.getMyContainingJPanel().getTokens().getRedTokens().replace(chosenToken, whereTo);

    }

    private void bluesTurn(int whereTo, int chosenToken) {

        if ((board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken) == 80 || board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken) == 81 ||
                board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken) == 82 || board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken) == 83) && whereTo != 6) {
            whereTo = 0;
        }
        else if ((board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken) == 80 || board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken) == 81 ||
                board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken) == 82 || board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken) == 83) && whereTo == 6) {
            board.getMyContainingJPanel().getTokens().getBlueTokens().replace(chosenToken, 14);
            whereTo = 0;
        }

        whereTo += board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken);
        board.getMyContainingJPanel().getTokens().getBlueTokens().replace(chosenToken, whereTo);

    }



    private void greensTurn(int whereTo, int chosenToken) {


        if ((board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken) == 84 || board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken) == 85 ||
                board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken) == 86 || board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken) == 87) && whereTo != 6)
            whereTo = 0;

        else if ((board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken) == 84 || board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken) == 85 ||
                board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken) == 86 || board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken) == 87) && whereTo == 6) {
            board.getMyContainingJPanel().getTokens().getGreenTokens().replace(chosenToken, 28);
            whereTo = 0;
        }

        whereTo += board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken);
        board.getMyContainingJPanel().getTokens().getGreenTokens().replace(chosenToken, whereTo);
    }

    private void yellowsTrun(int whereTo, int chosenToken) {


        if ((board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken) == 88 || board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken) == 89 ||
                board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken) == 90 || board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken) == 91) && whereTo != 6 ) {
            whereTo = 0;
        }

        else if ((board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken) == 88 || board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken) == 89 ||
                board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken) == 90 || board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken) == 91) && whereTo == 6 ) {
            board.getMyContainingJPanel().getTokens().getYellowTokens().replace(chosenToken, 42);
            whereTo = 0;
        }

        whereTo += board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken);
        board.getMyContainingJPanel().getTokens().getYellowTokens().replace(chosenToken, whereTo);
    }



}
