package evoLudoMain;


public class Controller {

    private Tokens tokens = Tokens.getInstance();
    private static Controller instance = null;
    private String[] whoseTurnIsIt = new String[]{"red", "blue", "green", "yellow"};
    private int turn = 1;
    private MyContainingJPanel myContainingJPanel = MyContainingJPanel.getInstance();

    public static Controller getInstance() {
        if (instance == null)
            return new Controller();
        return instance;
    }


    public void moveToken(String whichPlayers, Integer whichToken, Integer whereTo) {

        if (whichPlayers.equalsIgnoreCase("red")) {
            tokens.getRedTokens().replace(whichToken, whereTo);
        }
        else if (whichPlayers.equalsIgnoreCase("blue"))
            tokens.getBlueTokens().replace(whichToken, whereTo);
        else if (whichPlayers.equalsIgnoreCase("green"))
            tokens.getGreenTokens().replace(whichToken, whereTo);
        else
            tokens.getYellowTokens().replace(whichToken, whereTo);


        this.drawMove();


        if (this.turn != 4)
            this.turn += 1;
        else
            this.turn = 1;
    }

    public void drawMove() {
        myContainingJPanel.refreshMoves();
    }


    public String whoseTurn() {
        return whoseTurnIsIt[turn];
    }
}
