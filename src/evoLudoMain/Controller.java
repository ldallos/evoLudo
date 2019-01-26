package evoLudoMain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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
                xTurn(dicedNumber, chosenToken, 80, 14, board.getMyContainingJPanel().getTokens().getBlueTokens(), 4, 65, 13);
            } else if (whichPlayers.equalsIgnoreCase("green")) {
                xTurn(dicedNumber, chosenToken, 84, 28, board.getMyContainingJPanel().getTokens().getGreenTokens(), 8, 70, 27);
            } else {
                xTurn(dicedNumber, chosenToken, 88, 42, board.getMyContainingJPanel().getTokens().getYellowTokens(), 12, 75, 41);
            }
        }


        board.getMyContainingJPanel().repaint();

        isTheGameFinished();

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
            else if (currentPosition + dicedNumber > 55) {}
            else{
                putBackEnemyToken(whereToStep);
            }
            if (currentPosition + dicedNumber > 59) {
                whereToStep = 60;
            }
            board.getMyContainingJPanel().getTokens().getRedTokens().replace(chosenToken, whereToStep);
        }
    }

    private void xTurn(int dicedNumber, int chosenToken, int startMin, int boardStart, Map<Integer, Integer> playerTokens, int shiftForHadReachedTheEndList, int lastField, int lastFieldBeforeColorFields) {
        int currentPosition = playerTokens.get(chosenToken);

        if (currentPosition == startMin || currentPosition == startMin + 1 || currentPosition == startMin + 2 || currentPosition == startMin + 3) {

            if (dicedNumber == 6) {
                putBackEnemyToken(boardStart);
                playerTokens.replace(chosenToken, boardStart);
            }

        } else {
            int whereToStep = currentPosition + dicedNumber;

            if (board.getMyContainingJPanel().getTokens().getHadReachTheEnd().get(chosenToken - 1 + shiftForHadReachedTheEndList)) {

                if (currentPosition > lastField - 5) {
                    whereToStep = currentPosition + dicedNumber;
                }else if (currentPosition + dicedNumber > lastFieldBeforeColorFields) {
                    whereToStep = abs(currentPosition + dicedNumber - boardStart) + lastField - 4;
                }else {
                    putBackEnemyToken(whereToStep);
                }

                if (whereToStep > lastField - 1) {
                    whereToStep = lastField;
                }

                playerTokens.replace(chosenToken, whereToStep);

            } else {
                whereToStep = isEndOfTrack(currentPosition, dicedNumber, chosenToken);
                putBackEnemyToken(whereToStep);
                playerTokens.replace(chosenToken, whereToStep);
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
     * @param chosenToken - The token's number (1, 2, 3, 4)
     * @param dicedNumber - The number that was diced by the player.
     * @return - the true, if the player can move with that token, false if he can't.
     */
    public boolean canMove(int chosenToken, int dicedNumber) {
        switch (whoseTurn()) {
            case "red":
                return redCanMove(dicedNumber, chosenToken);
            case "blue":
                return xCanMove(dicedNumber, chosenToken, board.getMyContainingJPanel().getTokens().getBlueTokens(), 80, 14, 65);
            case "green":
                return xCanMove(dicedNumber, chosenToken, board.getMyContainingJPanel().getTokens().getGreenTokens(), 84, 28, 70);
            case "yellow":
                return xCanMove(dicedNumber, chosenToken, board.getMyContainingJPanel().getTokens().getYellowTokens(), 88, 42, 75);
            default:return true;
        }
    }

    private boolean redCanMove(int dicedNumber, int chosenToken) {
        int currentPosition = board.getMyContainingJPanel().getTokens().getRedTokens().get(chosenToken);

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


    private boolean xCanMove(int dicedNumber, int chosenToken, Map<Integer, Integer> playerTokens, int startMin, int boardStart, int lastField) {

        int currentPosition = playerTokens.get(chosenToken);

        boolean canMove1;
        boolean canMove2;
        boolean canMove3 = false;

        if (currentPosition == startMin || currentPosition == startMin + 1 || currentPosition == startMin + 2 || currentPosition == startMin + 3) {

            if (dicedNumber == 6 && !(playerTokens.get(1).equals(boardStart) || playerTokens.get(2).equals(boardStart)
                    || playerTokens.get(3).equals(boardStart) || playerTokens.get(4).equals(boardStart))) {
                canMove1 = true;
            }
            else {
                canMove1 = false;
            }

        }else {
            canMove1 = true;
        }


        if (!(currentPosition == startMin || currentPosition == startMin + 1 || currentPosition == startMin + 2 || currentPosition == startMin + 3)) {
            canMove2 = !(currentPosition == lastField);
        }
        else {
            canMove2 = true;
        }


        if (currentPosition < lastField - 5) {
            if (!(playerTokens.get(1).equals(currentPosition + dicedNumber) || playerTokens.get(2).equals(currentPosition + dicedNumber)
                    || playerTokens.get(3).equals(currentPosition + dicedNumber) || playerTokens.get(4).equals(currentPosition + dicedNumber))) {
                canMove3 = true;
            }
        }else {
            canMove3 = true;
        }

        return (canMove1 && canMove2 && canMove3);
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

    private void isTheGameFinished() {
        JLabel message = new JLabel("");
        message.setFont(new Font("Arial", Font.BOLD, 18));
        if (board.getMyContainingJPanel().getTokens().getFinished("red", 60) == 4) {
            message.setForeground(Color.RED);
            message.setText("The RED player won the game!");
            JOptionPane.showMessageDialog(null, message, "Game over", JOptionPane.INFORMATION_MESSAGE);
            board.getStartFrame().setVisible(true);
            turn = turn - 1;
            board.dispose();

        }
        else if (board.getMyContainingJPanel().getTokens().getFinished("blue", 65) == 4) {
            message.setForeground(Color.BLUE);
            message.setText("The BLUE player won the game!");
            JOptionPane.showMessageDialog(null, message, "Game over", JOptionPane.INFORMATION_MESSAGE);
            board.getStartFrame().setVisible(true);
            turn = turn - 1;
            board.dispose();

        }
        else if (board.getMyContainingJPanel().getTokens().getFinished("green", 70) == 4) {
            message.setForeground(Color.GREEN);
            message.setText("The GREEN player won the game!");
            JOptionPane.showMessageDialog(null, message, "Game over", JOptionPane.INFORMATION_MESSAGE);
            board.getStartFrame().setVisible(true);
            turn = turn - 1;
            board.dispose();
        }
        else if (board.getMyContainingJPanel().getTokens().getFinished("yellow", 75) == 4) {
            message.setForeground(Color.YELLOW);
            message.setText("The YELLOW player won the game!");
            JOptionPane.showMessageDialog(null, message, "Game over", JOptionPane.INFORMATION_MESSAGE);
            board.getStartFrame().setVisible(true);
            turn = turn - 1;
            board.dispose();
        }
    }



    public void setTestButton() {
        board.getMyContainingJPanel().getTestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (whoseTurn()) {

                    case "red": {
                        Integer moveBy = Integer.parseInt(JOptionPane.showInputDialog("Set diced number to exact value!", 6));
                        board.getRedsYard().setPrintOutText(moveBy);
                        board.getRedsYard().setDicedNumber(moveBy);
                        board.getRedsYard().getSelectorJPanel();
                        if (board.getRedsYard().getToken1().isVisible() || board.getRedsYard().getToken2().isVisible() || board.getRedsYard().getToken3().isVisible() || board.getRedsYard().getToken4().isVisible()) {
                            do {
                                JOptionPane.showMessageDialog(null, board.getRedsYard().getSelectorJPanel(), "You have " + moveBy + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                            }while(board.getRedsYard().checkChosenTokenIsValid());
                        }
                        moveToken(moveBy, board.getRedsYard().getChosenToken());
                    }break;

                    case "blue": {
                        Integer moveBy = Integer.parseInt(JOptionPane.showInputDialog("Set diced number to exact value!", 6));
                        board.getBluesYard().setPrintOutText(moveBy);
                        board.getBluesYard().setDicedNumber(moveBy);
                        board.getBluesYard().getSelectorJPanel();
                        if (board.getBluesYard().getToken1().isVisible() || board.getBluesYard().getToken2().isVisible() || board.getBluesYard().getToken3().isVisible() || board.getBluesYard().getToken4().isVisible()) {
                            do {
                                JOptionPane.showMessageDialog(null, board.getBluesYard().getSelectorJPanel(), "You have " + moveBy + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                            }while(board.getBluesYard().checkChosenTokenIsValid());

                        }
                        moveToken(moveBy, board.getBluesYard().getChosenToken());
                    }break;

                    case "green": {
                        Integer moveBy = Integer.parseInt(JOptionPane.showInputDialog("Set diced number to exact value!", 6));
                        board.getGreensYard().setPrintOutText(moveBy);
                        board.getGreensYard().setDicedNumber(moveBy);
                        board.getGreensYard().getSelectorJPanel();
                        if (board.getGreensYard().getToken1().isVisible() || board.getGreensYard().getToken2().isVisible() || board.getGreensYard().getToken3().isVisible() || board.getGreensYard().getToken4().isVisible()) {

                            do {
                                JOptionPane.showMessageDialog(null, board.getGreensYard().getSelectorJPanel(), "You have " + moveBy + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                            }while(board.getGreensYard().checkChosenTokenIsValid());

                        }
                        moveToken(moveBy, board.getGreensYard().getChosenToken());
                    }break;

                    case "yellow": {
                        Integer moveBy = Integer.parseInt(JOptionPane.showInputDialog("Set diced number to exact value!", 6));
                        board.getYellowsYard().setPrintOutText(moveBy);
                        board.getYellowsYard().setDicedNumber(moveBy);
                        board.getYellowsYard().getSelectorJPanel();
                        if (board.getYellowsYard().getToken1().isVisible() || board.getYellowsYard().getToken2().isVisible() || board.getYellowsYard().getToken3().isVisible() || board.getYellowsYard().getToken4().isVisible()) {
                            do {
                                JOptionPane.showMessageDialog(null, board.getYellowsYard().getSelectorJPanel(), "You have " + moveBy + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                            }while(board.getYellowsYard().checkChosenTokenIsValid());
                        }
                        moveToken(moveBy, board.getYellowsYard().getChosenToken());
                    }break;
                    default:
                        System.out.println("Not existing player!");

                }
            }
        });
    }

}