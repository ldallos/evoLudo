package evoLudoMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TokenSelectorWindow extends JFrame {
    private static JButton token1 = new JButton("Token 1");
    private static JButton token2 = new JButton("Token 2");
    private static JButton token3 = new JButton("Token 3");
    private static JButton token4 = new JButton("Token 4");
    private int chosenToken = 0;
    //private static TokenSelectorWindow instance = null;
    private int diceResult = 0;
/*

    public static TokenSelectorWindow getInstance() {
        if (instance == null) {
            return new TokenSelectorWindow();
        }

        return instance;
    }
*/

    public TokenSelectorWindow() {
        setTitle("Token selector..");
        setBounds(0, 0, 300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


        token1.setBounds(10, 10,100, 30);
        token2.setBounds(160, 10,100, 30);
        token3.setBounds(10, 70,100, 30);
        token4.setBounds(160, 70,100, 30);

        token1.setVisible(true);
        token2.setVisible(true);
        token3.setVisible(true);
        token4.setVisible(true);


        token1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller.setChosenToken(1);
                Controller.moveToken(diceResult);
                setVisible(false);
                Controller.nextTurn();
                dispose();
            }
        });

        token2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller.setChosenToken(2);
                Controller.moveToken(diceResult);
                setVisible(false);
                Controller.nextTurn();
                dispose();
            }
        });

        token3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller.setChosenToken(3);
                Controller.moveToken(diceResult);
                setVisible(false);
                Controller.nextTurn();
                dispose();
            }
        });

        token4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Controller.setChosenToken(4);
                Controller.moveToken(diceResult);
                setVisible(false);
                Controller.nextTurn();
                dispose();
            }
        });


        add(token1);
        add(token2);
        add(token3);
        add(token4);

    }

    public int getChosenToken() {
        return chosenToken;
    }


    public void setDiceResult(int diceResult) {
        this.diceResult = diceResult;
    }
}
