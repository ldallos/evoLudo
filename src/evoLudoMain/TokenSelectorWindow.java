package evoLudoMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TokenSelectorWindow extends JFrame {
    private JButton token1 = new JButton("Token 1");
    private JButton token2 = new JButton("Token 2");
    private JButton token3 = new JButton("Token 3");
    private JButton token4 = new JButton("Token 4");
    private int chosenToken;

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
                chosenToken = 1;
                setVisible(false);
                dispose();
            }
        });

        token2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chosenToken = 2;
                setVisible(false);
                dispose();
            }
        });

        token3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chosenToken = 3;
                setVisible(false);
                dispose();
            }
        });

        token4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chosenToken = 4;
                setVisible(false);
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


    public JButton getToken1() {
        return token1;
    }

    public JButton getToken2() {
        return token2;
    }

    public JButton getToken3() {
        return token3;
    }

    public JButton getToken4() {
        return token4;
    }
}
