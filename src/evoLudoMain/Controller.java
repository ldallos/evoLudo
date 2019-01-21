package evoLudoMain;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Math.abs;

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
     * @param dicedNumber - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */
    public  void moveToken(int dicedNumber, int chosenToken) {

        if (chosenToken != 0) {
            String whichPlayers = whoseTurn();
            if (whichPlayers.equalsIgnoreCase("red")) {
                redsTurn(dicedNumber, chosenToken);
            } else if (whichPlayers.equalsIgnoreCase("blue")) {
                bluesTurn(dicedNumber, chosenToken);
            } else if (whichPlayers.equalsIgnoreCase("green")) {
                greensTurn(dicedNumber, chosenToken);
            } else {
                yellowsTrun(dicedNumber, chosenToken);
            }
        }

        System.out.println("whoseTurn: \t" + whoseTurn());
        System.out.println("whichToken: \t" + chosenToken);
        System.out.println("dicedNumber: \t" + dicedNumber);



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
     * @param dicedNumber - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */
    private void redsTurn(int dicedNumber, int chosenToken) {

        int currentPosition = board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken);

        System.out.println("currentPosition\t " + currentPosition);
        System.out.println("0.babu erteke\t " + board.getMyContainingJPanel().getTokens().getRedTokens().get(0));
        if (currentPosition == 76 || currentPosition == 77 || currentPosition == 78 || currentPosition == 79) {
             if (dicedNumber == 6) {
                    putBackEnemyToken(0);
                    board.getMyContainingJPanel().getTokens().getRedTokens().replace(chosenToken, 0);
            }
        }
        else {

            int whereToStep = currentPosition + dicedNumber;

            if (currentPosition > 55) {
                whereToStep = currentPosition + dicedNumber;
            }
            else if (currentPosition + dicedNumber > 55) {

            }else{
                putBackEnemyToken(whereToStep);
            }

            if (currentPosition + dicedNumber > 59) {
                whereToStep = 60;
            }

            board.getMyContainingJPanel().getTokens().getRedTokens().replace(chosenToken, whereToStep);


        }



    }


    /**
     * Moves the selected blue token to a new position.
     * @param dicedNumber - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */
    private void bluesTurn(int dicedNumber, int chosenToken) {

        int currentPosition = board.getMyContainingJPanel().getTokens().getBlueTokens().get(chosenToken);

        System.out.println("currentPosition\t " + currentPosition);
        System.out.println("0.babu erteke\t " + board.getMyContainingJPanel().getTokens().getBlueTokens().get(0));
        if (currentPosition == 80 || currentPosition == 81 ||currentPosition == 82 || currentPosition == 83) {

            if (dicedNumber == 6) {
                putBackEnemyToken(14);
                board.getMyContainingJPanel().getTokens().getBlueTokens().replace(chosenToken, 14);
            }

        }
        else {

            int whereToStep = currentPosition + dicedNumber;

            if (board.getMyContainingJPanel().getTokens().getHadReachTheEnd().get(chosenToken -1 + 4)) {


                if (currentPosition > 60) {
                    whereToStep = currentPosition + dicedNumber;
                }else if (currentPosition + dicedNumber > 13) {
                    whereToStep = abs(currentPosition + dicedNumber - 14) + 61;
                }
                else {
                    putBackEnemyToken(whereToStep);
                }


                if (whereToStep > 64) {
                    whereToStep = 65;
                }

                board.getMyContainingJPanel().getTokens().getBlueTokens().replace(chosenToken, whereToStep);

            }
            else {
                whereToStep = isEndOfTrack(currentPosition, dicedNumber, chosenToken);
                putBackEnemyToken(whereToStep);
                board.getMyContainingJPanel().getTokens().getBlueTokens().replace(chosenToken, whereToStep);
            }


        }

    }


    /**
     * Moves the selected green token to a new position.
     * @param dicedNumber - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */

    private void greensTurn(int dicedNumber, int chosenToken) {

        int currentPosition = board.getMyContainingJPanel().getTokens().getGreenTokens().get(chosenToken);

        System.out.println("currentPosition\t " + currentPosition);
        System.out.println("0.babu erteke\t " + board.getMyContainingJPanel().getTokens().getGreenTokens().get(0));
        if ((currentPosition == 84 || currentPosition == 85 || currentPosition == 86 || currentPosition == 87)) {

            if (dicedNumber == 6) {
                putBackEnemyToken(28);
                board.getMyContainingJPanel().getTokens().getGreenTokens().replace(chosenToken, 28);
            }
        }
        else {


            int whereToStep = currentPosition + dicedNumber;

            if (board.getMyContainingJPanel().getTokens().getHadReachTheEnd().get(chosenToken -1 + 8)) {


                if (currentPosition > 65) {
                    whereToStep = currentPosition + dicedNumber;
                }else if (currentPosition + dicedNumber > 27) {
                    whereToStep = abs(currentPosition + dicedNumber - 28) + 66;
                }
                else {
                    putBackEnemyToken(whereToStep);
                }


                if (whereToStep > 69) {
                    whereToStep = 70;
                }

                board.getMyContainingJPanel().getTokens().getGreenTokens().replace(chosenToken, whereToStep);

            }
            else {
                whereToStep = isEndOfTrack(currentPosition, dicedNumber, chosenToken);
                putBackEnemyToken(whereToStep);
                board.getMyContainingJPanel().getTokens().getGreenTokens().replace(chosenToken, whereToStep);
            }

        }

    }


    /**
     * Moves the selected yellow token to a new position.
     * @param dicedNumber - The thrown value by the dice.
     * @param chosenToken - The number of the chosen token which to move.
     */

    private void yellowsTrun(int dicedNumber, int chosenToken) {

        int currentPosition = board.getMyContainingJPanel().getTokens().getYellowTokens().get(chosenToken);

        System.out.println("currentPosition\t " + currentPosition);
        System.out.println("0.babu erteke\t " + board.getMyContainingJPanel().getTokens().getYellowTokens().get(0));
        if (currentPosition == 88 || currentPosition == 89 || currentPosition == 90 || currentPosition == 91) {

            if (dicedNumber == 6) {
                putBackEnemyToken(42);
                board.getMyContainingJPanel().getTokens().getYellowTokens().replace(chosenToken, 42);
            }

        } else {
            int whereToStep = currentPosition + dicedNumber;

            if (board.getMyContainingJPanel().getTokens().getHadReachTheEnd().get(chosenToken - 1 + 12)) {

                if (currentPosition > 70) {
                    whereToStep = currentPosition + dicedNumber;
                }else if (currentPosition + dicedNumber > 41) {
                    whereToStep = abs(currentPosition + dicedNumber - 42) + 71;
                }else {
                    putBackEnemyToken(whereToStep);
                }


                if (whereToStep > 74) {
                    whereToStep = 75;
                }

                board.getMyContainingJPanel().getTokens().getYellowTokens().replace(chosenToken, whereToStep);

            } else {
                whereToStep = isEndOfTrack(currentPosition, dicedNumber, chosenToken);
                putBackEnemyToken(whereToStep);
                board.getMyContainingJPanel().getTokens().getYellowTokens().replace(chosenToken, whereToStep);
            }
        }
    }

    /**
     * Checks if the given token reached the end of the white fields.
     * @param currentPosition - Current position of the token.
     * @param dicedNumber - The diced number.
     * @param chosenToken - Which token had been chosen.
     * @return The value where the token will be placed.
     */
    private int isEndOfTrack(int currentPosition, int dicedNumber, int chosenToken) {

        if (currentPosition+dicedNumber > 55) {

            switch (whoseTurn()) {
                case "red": board.getMyContainingJPanel().getTokens().getHadReachTheEnd().set(chosenToken - 1, true);break;
                case "blue": board.getMyContainingJPanel().getTokens().getHadReachTheEnd().set(chosenToken -1 + 4, true);break;
                case "green": board.getMyContainingJPanel().getTokens().getHadReachTheEnd().set(chosenToken - 1 + 8, true);break;
                case "yellow": board.getMyContainingJPanel().getTokens().getHadReachTheEnd().set(chosenToken - 1 + 12, true); break;
            }

            return abs(((currentPosition + dicedNumber) - 56));
        }
        else {
            return currentPosition + dicedNumber;
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

                if ((currentPosition == 76 || currentPosition == 77 || currentPosition == 78 || currentPosition == 79)) {
                    if (dicedNumber == 6 && !(board.getMyContainingJPanel().getTokens().getRedTokens().get(1).equals(0) || board.getMyContainingJPanel().getTokens().getRedTokens().get(2).equals(0)
                            || board.getMyContainingJPanel().getTokens().getRedTokens().get(3).equals(0) || board.getMyContainingJPanel().getTokens().getRedTokens().get(4).equals(0))) {
                        canMove1 = true;
                    }
                    else {
                        canMove1 = false;
                    }
                }else {
                    canMove1 = true;
                }


                if (!(currentPosition == 76 || currentPosition == 77 || currentPosition == 78 || currentPosition == 79)) {
                    canMove2 = !(currentPosition == 60);

                }
                else {
                    canMove2 = true;
                }


                if (currentPosition < 55) {
                    if (!(board.getMyContainingJPanel().getTokens().getRedTokens().get(1).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getRedTokens().get(2).equals(currentPosition + dicedNumber)
                            || board.getMyContainingJPanel().getTokens().getRedTokens().get(3).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getRedTokens().get(4).equals(currentPosition + dicedNumber))) {
                        canMove3 = true;
                    }
                }
                else {
                    canMove3 = true;
                }



                return (canMove1 && canMove2 && canMove3);
            }

            case "blue": {

                int currentPosition = board.getMyContainingJPanel().getTokens().getBlueTokens().get(token);

                boolean canMove1;
                boolean canMove2;
                boolean canMove3 = false;

                if ((currentPosition == 80 || currentPosition == 81 || currentPosition == 82 || currentPosition == 83)) {

                    if (dicedNumber == 6 && !(board.getMyContainingJPanel().getTokens().getBlueTokens().get(1).equals(14) || board.getMyContainingJPanel().getTokens().getBlueTokens().get(2).equals(14)
                            || board.getMyContainingJPanel().getTokens().getBlueTokens().get(3).equals(14) || board.getMyContainingJPanel().getTokens().getBlueTokens().get(4).equals(14))) {
                        canMove1 = true;
                    }
                    else {
                        canMove1 = false;
                    }
                }else {
                    canMove1 = true;
                }


                if (!(currentPosition == 80 || currentPosition == 81 || currentPosition == 82 || currentPosition == 83)) {

                    canMove2 = !(currentPosition == 65);

                }
                else {
                    canMove2 = true;
                }




                if (currentPosition < 60) {
                    if (!(board.getMyContainingJPanel().getTokens().getBlueTokens().get(1).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getBlueTokens().get(2).equals(currentPosition + dicedNumber)
                            || board.getMyContainingJPanel().getTokens().getBlueTokens().get(3).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getBlueTokens().get(4).equals(currentPosition + dicedNumber))) {
                        canMove3 = true;
                    }
                }else {
                    canMove3 = true;
                }

                return (canMove1 && canMove2 && canMove3);



            }

            case "green": {

                int currentPosition = board.getMyContainingJPanel().getTokens().getGreenTokens().get(token);

                boolean canMove1;
                boolean canMove2;
                boolean canMove3 = false;

                if ((currentPosition == 84 || currentPosition == 85 || currentPosition == 86 || currentPosition == 87)) {

                    if (dicedNumber == 6 && !(board.getMyContainingJPanel().getTokens().getGreenTokens().get(1).equals(28) || board.getMyContainingJPanel().getTokens().getGreenTokens().get(2).equals(28)
                            || board.getMyContainingJPanel().getTokens().getGreenTokens().get(3).equals(28) || board.getMyContainingJPanel().getTokens().getGreenTokens().get(4).equals(28))) {
                        canMove1 = true;
                    }
                    else {
                        canMove1 = false;
                    }
                }else {
                    canMove1 = true;
                }


                if (!(currentPosition == 84 || currentPosition == 85 || currentPosition == 86 || currentPosition == 87)) {

                    canMove2 = !(currentPosition == 70);

                }
                else {
                    canMove2 = true;
                }


                if (currentPosition < 65) {
                    if (!(board.getMyContainingJPanel().getTokens().getGreenTokens().get(1).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getGreenTokens().get(2).equals(currentPosition + dicedNumber)
                            || board.getMyContainingJPanel().getTokens().getGreenTokens().get(3).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getGreenTokens().get(4).equals(currentPosition + dicedNumber))) {
                        canMove3 = true;
                    }
                }else {
                    canMove3 = true;
                }

                return (canMove1 && canMove2 && canMove3);

            }

            case "yellow": {


                int currentPosition = board.getMyContainingJPanel().getTokens().getYellowTokens().get(token);

                boolean canMove1;
                boolean canMove2;
                boolean canMove3 = false;

                if (currentPosition == 88 || currentPosition == 89 || currentPosition == 90 || currentPosition == 91) {

                    if (dicedNumber == 6 && !(board.getMyContainingJPanel().getTokens().getYellowTokens().get(1).equals(42) || board.getMyContainingJPanel().getTokens().getYellowTokens().get(2).equals(42)
                            || board.getMyContainingJPanel().getTokens().getYellowTokens().get(3).equals(42) || board.getMyContainingJPanel().getTokens().getYellowTokens().get(4).equals(42))) {
                        canMove1 = true;
                    }
                    else {
                        canMove1 = false;
                    }


                }else {
                    canMove1 = true;
                }


                if (!(currentPosition == 88 || currentPosition == 89 || currentPosition == 90 || currentPosition == 91)) {
                    canMove2 = !(currentPosition == 75);
                }
                else {
                    canMove2 = true;
                }


                if (currentPosition < 70) {
                    if (!(board.getMyContainingJPanel().getTokens().getYellowTokens().get(1).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getYellowTokens().get(2).equals(currentPosition + dicedNumber)
                            || board.getMyContainingJPanel().getTokens().getYellowTokens().get(3).equals(currentPosition + dicedNumber) || board.getMyContainingJPanel().getTokens().getYellowTokens().get(4).equals(currentPosition + dicedNumber))) {
                        canMove3 = true;
                    }
                }else {
                    canMove3 = true;
                }




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
                    case 9: board.getMyContainingJPanel().getTokens().getGreenTokens().replace(2, Tokens.GREEN2TOKENSTARTING);break;
                    case 10: board.getMyContainingJPanel().getTokens().getGreenTokens().replace(3, Tokens.GREEN3TOKENSTARTING);break;
                    case 11: board.getMyContainingJPanel().getTokens().getGreenTokens().replace(4, Tokens.GREEN4TOKENSTARTING);break;
                    case 12: board.getMyContainingJPanel().getTokens().getYellowTokens().replace(1, Tokens.YELLOW1TOKENSTARTING);break;
                    case 13: board.getMyContainingJPanel().getTokens().getYellowTokens().replace(2, Tokens.YELLOW2TOKENSTARTING);break;
                    case 14: board.getMyContainingJPanel().getTokens().getYellowTokens().replace(3, Tokens.YELLOW3TOKENSTARTING);break;
                    case 15: board.getMyContainingJPanel().getTokens().getYellowTokens().replace(4, Tokens.YELLOW4TOKENSTARTING);break;
                }
                board.getMyContainingJPanel().getTokens().getHadReachTheEnd().set(i, false);
            }
        }

    }

    public void setTestButton() {
        board.getMyContainingJPanel().getTestButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (whoseTurn()) {
                    case "red": {
                        Integer moveBy = Integer.parseInt(JOptionPane.showInputDialog("Set diced number to exact value!", 6));

                        board.getRedsYard().getDiceRollingResult().setText(String.valueOf(moveBy));
                        board.getRedsYard().getSelectorJPanel();
                        if (!(!board.getRedsYard().getToken1().isVisible() && !board.getRedsYard().getToken2().isVisible() && !board.getRedsYard().getToken3().isVisible() && !board.getRedsYard().getToken4().isVisible())) {

                            do {
                                JOptionPane.showMessageDialog(null, board.getRedsYard().getSelectorJPanel(), "You have " + moveBy + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                            }while(!(board.getRedsYard().getToken1().isSelected() || board.getRedsYard().getToken2().isSelected() || board.getRedsYard().getToken3().isSelected() || board.getRedsYard().getToken4().isSelected()));


                        }
                        moveToken(moveBy, board.getRedsYard().getChosenToken());


                    }break;

                    case "blue": {

                        Integer moveBy = Integer.parseInt(JOptionPane.showInputDialog("Set diced number to exact value!", 6));

                        board.getBluesYard().getDiceRollingResult().setText(String.valueOf(moveBy));
                        board.getBluesYard().getSelectorJPanel();
                        if (!(!board.getBluesYard().getToken1().isVisible() && !board.getBluesYard().getToken2().isVisible() && !board.getBluesYard().getToken3().isVisible() && !board.getBluesYard().getToken4().isVisible())) {

                            do {
                                JOptionPane.showMessageDialog(null, board.getBluesYard().getSelectorJPanel(), "You have " + moveBy + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                            }while(!(board.getBluesYard().getToken1().isSelected() || board.getBluesYard().getToken2().isSelected() || board.getBluesYard().getToken3().isSelected() || board.getBluesYard().getToken4().isSelected()));

                        }
                        moveToken(moveBy, board.getBluesYard().getChosenToken());

                    }break;

                    case "green": {

                        Integer moveBy = Integer.parseInt(JOptionPane.showInputDialog("Set diced number to exact value!", 6));

                        board.getGreensYard().getDiceRollingResult().setText(String.valueOf(moveBy));
                        board.getGreensYard().getSelectorJPanel();
                        if (!(!board.getGreensYard().getToken1().isVisible() && !board.getGreensYard().getToken2().isVisible() && !board.getGreensYard().getToken3().isVisible() && !board.getGreensYard().getToken4().isVisible())) {

                            do {
                                JOptionPane.showMessageDialog(null, board.getGreensYard().getSelectorJPanel(), "You have " + moveBy + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                            }while(!(board.getGreensYard().getToken1().isSelected() || board.getGreensYard().getToken2().isSelected() || board.getGreensYard().getToken3().isSelected() || board.getGreensYard().getToken4().isSelected()));

                        }
                        moveToken(moveBy, board.getGreensYard().getChosenToken());


                    }break;

                    case "yellow": {


                        Integer moveBy = Integer.parseInt(JOptionPane.showInputDialog("Set diced number to exact value!", 6));

                        board.getYellowsYard().getDiceRollingResult().setText(String.valueOf(moveBy));
                        board.getYellowsYard().getSelectorJPanel();
                        if (!(!board.getYellowsYard().getToken1().isVisible() && !board.getYellowsYard().getToken2().isVisible() && !board.getYellowsYard().getToken3().isVisible() && !board.getYellowsYard().getToken4().isVisible())) {
                            do {
                                JOptionPane.showMessageDialog(null, board.getYellowsYard().getSelectorJPanel(), "You have " + moveBy + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                            }while(!(board.getYellowsYard().getToken1().isSelected() || board.getYellowsYard().getToken2().isSelected() || board.getYellowsYard().getToken3().isSelected() || board.getYellowsYard().getToken4().isSelected()));

                        }
                        moveToken(moveBy, board.getYellowsYard().getChosenToken());

                    }break;
                    default:
                        System.out.println("Eliratad...");

                }
            }
        });
    }


}
