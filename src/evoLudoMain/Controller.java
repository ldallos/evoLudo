package evoLudoMain;


import java.util.ArrayList;

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

    /**
     * Moves the selected token to a new position.
     * Whose turn gives that which player's token should be moved.
     * @param whereTo - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */
    public  void moveToken(int whereTo, int chosenToken) {
        String whichPlayers = whoseTurn();
        if (whichPlayers.equalsIgnoreCase("red")) {
            redsTurn(whereTo, chosenToken);
        }
        else if (whichPlayers.equalsIgnoreCase("blue")) {
            bluesTurn(whereTo, chosenToken);
        }
        else if (whichPlayers.equalsIgnoreCase("green")) {
            greensTurn(whereTo, chosenToken);
        }
        else {
            yellowsTrun(whereTo, chosenToken);
        }


        System.out.println("whoseTurn: \t" + whoseTurn());
        System.out.println("whichToken: \t" + chosenToken);
        System.out.println("whereTo: \t" + whereTo);


        board.getMyContainingJPanel().repaint();

        nextTurn();

    }


    /**
     * Handles the turn variable, and set the availability of the buttons according to the turn variable.
     */
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

    /**
     * Gives back that whose turn it is now.
     * @return
     */
    public  String whoseTurn() {
        return whoseTurnIsIt[turn];
    }


    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Moves the selected red token to a new position.
     * @param whereTo - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */
    private void redsTurn(int whereTo, int chosenToken) {

        int currentPosition = board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken);

        if (currentPosition == 76 || currentPosition == 77 || currentPosition == 78 || currentPosition == 79) {

             if (whereTo == 6) {
                    board.getMyContainingJPanel().getTokens().getRedTokens().replace(chosenToken, 0);
                    whereTo = 0;
            }
            else {
                whereTo = 0;
            }

            whereTo += board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken);
            board.getMyContainingJPanel().getTokens().getRedTokens().replace(chosenToken, whereTo);

        }
        else {
            putBackEnemyToken((currentPosition+whereTo));
            board.getMyContainingJPanel().getTokens().getRedTokens().replace(chosenToken, (currentPosition + whereTo));
        }



    }


    /**
     * Moves the selected blue token to a new position.
     * @param whereTo - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */
    private void bluesTurn(int whereTo, int chosenToken) {

        int currentPosition = board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken);

        if (currentPosition == 80 || currentPosition == 81 ||
                currentPosition == 82 || currentPosition == 83) {

            if (whereTo == 6) {
                board.getMyContainingJPanel().getTokens().getBlueTokens().replace(chosenToken, 14);
                whereTo = 0;
            }
            else {
                whereTo = 0;
            }

            whereTo += board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken);
            board.getMyContainingJPanel().getTokens().getBlueTokens().replace(chosenToken, whereTo);

        }
        else {
            putBackEnemyToken((currentPosition + whereTo));
            board.getMyContainingJPanel().getTokens().getBlueTokens().replace(chosenToken, currentPosition + whereTo);
        }

    }


    /**
     * Moves the selected green token to a new position.
     * @param whereTo - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */

    private void greensTurn(int whereTo, int chosenToken) {

        int currentPosition = board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken);

        if ((currentPosition == 84 || currentPosition == 85 ||
                currentPosition == 86 || currentPosition == 87)) {

            if (whereTo == 6) {
                board.getMyContainingJPanel().getTokens().getGreenTokens().replace(chosenToken, 28);
                whereTo = 0;
            }
            else {
                whereTo = 0;
            }
            whereTo += board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken);
            board.getMyContainingJPanel().getTokens().getGreenTokens().replace(chosenToken, whereTo);
        }
        else {
            putBackEnemyToken((currentPosition + whereTo));
            board.getMyContainingJPanel().getTokens().getGreenTokens().replace(chosenToken, currentPosition + whereTo);
        }

    }


    /**
     * Moves the selected yellow token to a new position.
     * @param whereTo - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */

    private void yellowsTrun(int whereTo, int chosenToken) {

        int currentPosition = board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken);

        if ((currentPosition == 88 || currentPosition == 89 ||
                currentPosition == 90 || currentPosition == 91)) {

            if (whereTo == 6) {
                board.getMyContainingJPanel().getTokens().getYellowTokens().replace(chosenToken, 42);
                whereTo = 0;
            }
            else {
                whereTo = 0;
            }

            whereTo += board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken);
            board.getMyContainingJPanel().getTokens().getYellowTokens().replace(chosenToken, whereTo);
        }
        else {
            putBackEnemyToken((currentPosition + whereTo));
            board.getMyContainingJPanel().getTokens().getYellowTokens().replace(chosenToken, currentPosition + whereTo);
        }

    }


    /**
     * This method determines whether the player in the turn could move with the given token.
     * @param token - The token's number (1, 2, 3, 4)
     * @param dicedNumber - The number that was diced by the player.
     * @return - the true, if the player can move with that token, false if he can't.
     */
    public boolean canMove(int token, int dicedNumber) {


        switch (whoseTurn()) {

            case "red": {
                int currentPosition = board.getMyContainingJPanel().getTokens().getRedTokens().get(token);

                boolean canMove1;
                boolean canMove2;
                boolean canMove3 = false;

                if ((currentPosition == 76 || currentPosition == 77 ||
                        currentPosition == 78 || currentPosition == 79)) {

                    if (dicedNumber == 6) {
                        canMove1 = true;
                    }
                    else
                        canMove1 = false;

                }else {
                    canMove1 = true;
                }
                System.out.print("canmove1\t" + canMove1);


                if (!(currentPosition == 76 || currentPosition == 77 ||
                        currentPosition == 78 || currentPosition == 79)) {

                    canMove2 = (currentPosition + dicedNumber < 61);

                }
                else {
                    canMove2 = true;
                }

                System.out.println("\tcanmove2\t" + canMove2);


                if (!(board.getMyContainingJPanel().getTokens().getRedTokens().get(1).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getRedTokens().get(2).equals(currentPosition + dicedNumber)
                        || board.getMyContainingJPanel().getTokens().getRedTokens().get(3).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getRedTokens().get(4).equals(currentPosition + dicedNumber))) {
                    canMove3 = true;
                }

                System.out.print("\tcanmove3\t" + canMove3);


                return (canMove1 && canMove2 && canMove3);
            }

            case "blue": {

                int currentPosition = board.getMyContainingJPanel().getTokens().getBlueTokens().get(token);

                boolean canMove1;
                boolean canMove2;
                boolean canMove3 = false;

                if ((currentPosition == 80 || currentPosition == 81 ||
                        currentPosition == 82 || currentPosition == 83)) {

                    if (dicedNumber == 6) {
                        canMove1 = true;
                    }
                    else
                        canMove1 = false;

                }else {
                    canMove1 = true;
                }
                System.out.print("canmove1\t" + canMove1);


                if (!(currentPosition == 80 || currentPosition == 81 ||
                        currentPosition == 82 || currentPosition == 83)) {

                    canMove2 = (currentPosition + dicedNumber < 66);

                }
                else {
                    canMove2 = true;
                }

                System.out.print("\tcanmove2\t" + canMove2);


                if (!(board.getMyContainingJPanel().getTokens().getBlueTokens().get(1).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getBlueTokens().get(2).equals(currentPosition + dicedNumber)
                        || board.getMyContainingJPanel().getTokens().getBlueTokens().get(3).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getBlueTokens().get(4).equals(currentPosition + dicedNumber))) {
                    canMove3 = true;
                }

                System.out.println("\tcanmove3\t" + canMove3);


                return (canMove1 && canMove2 && canMove3);



            }

            case "green": {

                int currentPosition = board.getMyContainingJPanel().getTokens().getGreenTokens().get(token);

                boolean canMove1;
                boolean canMove2;
                boolean canMove3 = false;

                if ((currentPosition == 84 || currentPosition == 85 ||
                        currentPosition == 86 || currentPosition == 87)) {

                    if (dicedNumber == 6) {
                        canMove1 = true;
                    }
                    else
                        canMove1 = false;

                }else {
                    canMove1 = true;
                }
                System.out.print("canmove1\t" + canMove1);


                if (!(currentPosition == 84 || currentPosition == 85 ||
                        currentPosition == 86 || currentPosition == 87)) {

                    canMove2 = (currentPosition + dicedNumber < 71);

                }
                else {
                    canMove2 = true;
                }

                System.out.print("\tcanmove2\t" + canMove2);


                if (!(board.getMyContainingJPanel().getTokens().getGreenTokens().get(1).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getGreenTokens().get(2).equals(currentPosition + dicedNumber)
                        || board.getMyContainingJPanel().getTokens().getGreenTokens().get(3).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getGreenTokens().get(4).equals(currentPosition + dicedNumber))) {
                    canMove3 = true;
                }

                System.out.println("\tcanmove3\t" + canMove3);


                return (canMove1 && canMove2 && canMove3);

            }

            case "yellow": {


                int currentPosition = board.getMyContainingJPanel().getTokens().getYellowTokens().get(token);

                boolean canMove1;
                boolean canMove2;
                boolean canMove3 = false;

                if (currentPosition == 88 || currentPosition == 89 ||
                        currentPosition == 90 || currentPosition == 91) {

                    canMove1 =(dicedNumber == 6);

                }else {
                    canMove1 = true;
                }
                System.out.print("canmove1\t" + canMove1);


                if (!(currentPosition == 88 || currentPosition == 89 ||
                        currentPosition == 90 || currentPosition == 91)) {

                    canMove2 = (currentPosition + dicedNumber < 76);

                }
                else {
                    canMove2 = true;
                }

                System.out.print("\tcanmove2\t" + canMove2);


                if (!(board.getMyContainingJPanel().getTokens().getYellowTokens().get(1).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getYellowTokens().get(2).equals(currentPosition + dicedNumber)
                        || board.getMyContainingJPanel().getTokens().getYellowTokens().get(3).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getYellowTokens().get(4).equals(currentPosition + dicedNumber))) {
                    canMove3 = true;
                }

                System.out.println("\tcanmove3\t" + canMove3);


                return (canMove1 && canMove2 && canMove3);


            }default:return true;


        }

    }


    /**
     * Puts back the token which can be found at the given field.
     * @param numberOfField - The field's number, from the token should be put back to its starting point.
     */
    private void putBackEnemyToken(int numberOfField) {
        ArrayList<Integer> listOfTokenPositions = new ArrayList<>();
        for (int i = 1;i <= 4; i++) {
            listOfTokenPositions.add(board.getMyContainingJPanel().getTokens().getRedTokens().get(i));
        }
        for (int i = 1;i <= 4; i++) {
            listOfTokenPositions.add(board.getMyContainingJPanel().getTokens().getBlueTokens().get(i));
        }
        for (int i = 1;i <= 4; i++) {
            listOfTokenPositions.add(board.getMyContainingJPanel().getTokens().getGreenTokens().get(i));
        }
        for (int i = 1;i <= 4; i++) {
            listOfTokenPositions.add(board.getMyContainingJPanel().getTokens().getYellowTokens().get(i));
        }


        for (int i = 0; i < listOfTokenPositions.size(); i++) {

            if (listOfTokenPositions.get(i) == numberOfField) {
                switch (i) {
                    case 0: board.getMyContainingJPanel().getTokens().getRedTokens().replace(1, Tokens.RED1TOKENSTARTING);break;
                    case 1: board.getMyContainingJPanel().getTokens().getRedTokens().replace(2, Tokens.RED2TOKENSTARTING);break;
                    case 2: board.getMyContainingJPanel().getTokens().getRedTokens().replace(3, Tokens.RED3TOKENSTARTING);break;
                    case 3: board.getMyContainingJPanel().getTokens().getRedTokens().replace(4, Tokens.RED4TOKENSTARTING);break;
                    case 4: board.getMyContainingJPanel().getTokens().getBlueTokens().replace(1, Tokens.BLUE1TOKENSTARTING);break;
                    case 5: board.getMyContainingJPanel().getTokens().getBlueTokens().replace(2, Tokens.BLUE2TOKENSTARTING);break;
                    case 6: board.getMyContainingJPanel().getTokens().getBlueTokens().replace(3, Tokens.BLUE3TOKENSTARTING);break;
                    case 7: board.getMyContainingJPanel().getTokens().getBlueTokens().replace(4, Tokens.BLUE4TOKENSTARTING);break;
                    case 8: board.getMyContainingJPanel().getTokens().getGreenTokens().replace(1, Tokens.GREEN1TOKENSTARTING);break;
                    case 9: board.getMyContainingJPanel().getTokens().getGreenTokens().replace(2, Tokens.GREEN1TOKENSTARTING);break;
                    case 10: board.getMyContainingJPanel().getTokens().getGreenTokens().replace(3, Tokens.GREEN1TOKENSTARTING);break;
                    case 11: board.getMyContainingJPanel().getTokens().getGreenTokens().replace(4, Tokens.GREEN1TOKENSTARTING);break;
                    case 12: board.getMyContainingJPanel().getTokens().getYellowTokens().replace(1, Tokens.YELLOW1TOKENSTARTING);break;
                    case 13: board.getMyContainingJPanel().getTokens().getYellowTokens().replace(2, Tokens.YELLOW2TOKENSTARTING);break;
                    case 14: board.getMyContainingJPanel().getTokens().getYellowTokens().replace(3, Tokens.YELLOW3TOKENSTARTING);break;
                    case 15: board.getMyContainingJPanel().getTokens().getYellowTokens().replace(4, Tokens.YELLOW4TOKENSTARTING);break;
                }
            }
        }

    }



}
