package evoLudoMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.Random;


public class YardPanels extends JPanel {
    private JButton diceRollerButton = new JButton("Dice me!");
    private JLabel diceRollingResult = new JLabel();
    private int panelWidth = (int) getSize().getWidth();
    private int panelHeight = (int) getSize().getHeight();
    private Controller controller = Controller.getInstance();
    private int chosenToken = 0;
    private int dicedNumber = 0;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton token1 = new JRadioButton("Token 1");
    private JRadioButton token2 = new JRadioButton("Token 2");
    private JRadioButton token3 = new JRadioButton("Token 3");
    private JRadioButton token4 = new JRadioButton("Token 4");



    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(panelWidth / 5 + panelWidth / 2 - panelWidth / 55, panelHeight / 5 + panelHeight / 2 - panelHeight / 55, panelWidth / 5, panelHeight / 5);
        g.drawOval(panelWidth / 5 + panelWidth / 12, panelHeight / 5 + panelHeight / 12, panelWidth / 5, panelHeight / 5);
        g.drawOval(panelWidth / 5 + panelWidth / 2 - panelHeight / 55, panelHeight / 5 + panelHeight / 12, panelWidth / 5, panelHeight / 5);
        g.drawOval(panelWidth / 5 + panelWidth / 12, panelHeight / 5 + panelHeight / 2 - panelHeight / 55, panelWidth / 5, panelHeight / 5);
    }


    public YardPanels() {

        setLayout(null);

        diceRollerButton.setBounds(panelWidth / 10 , 5 , panelWidth/10 * 5, panelHeight / 10 );
        diceRollingResult.setBounds(panelWidth / 10 * 8, 5, panelWidth / 10 * 3, panelHeight / 10);
        diceRollerButton.setVisible(true);
        diceRollingResult.setVisible(true);



        diceRollerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Random rand = new Random();
                dicedNumber = rand.nextInt(6) + 1;
                //diceRollingResult.setText(String.valueOf(dicedNumber));

                setPrintOutText(dicedNumber);

                getSelectorJPanel();

                if (token1.isVisible() || token2.isVisible() || token3.isVisible() || token4.isVisible()) {
                    do {
                        JOptionPane.showMessageDialog(null, getSelectorJPanel(), "You have " + dicedNumber + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                    }while(checkChosenTokenIsValid());

                }
                controller.moveToken(dicedNumber, chosenToken);
            }
        });

        diceRollerButton.setEnabled(false);

        add(diceRollerButton);
        add(diceRollingResult);
    }

    public void setPrintOutText(int dicedNumber) {
        diceRollingResult.setFont(new Font("Unicode", Font.PLAIN, panelWidth / 8));

        if (dicedNumber == 1)
            diceRollingResult.setText("\u2680");
        else if (dicedNumber == 2)
            diceRollingResult.setText("\u2681");
        else if (dicedNumber == 3)
            diceRollingResult.setText("\u2682");
        else if (dicedNumber == 4)
            diceRollingResult.setText("\u2683");
        else if (dicedNumber == 5)
            diceRollingResult.setText("\u2684");
        else if (dicedNumber == 6)
            diceRollingResult.setText("\u2685");
        else
            diceRollingResult.setText(String.valueOf(dicedNumber));
    }


    public void refreshSizes() {
        panelWidth = (int) getSize().getWidth();
        panelHeight = (int) getSize().getHeight();
        diceRollerButton.setBounds(panelWidth / 10 , 5 , panelWidth/10 * 5, panelHeight / 10 );
        diceRollingResult.setBounds(panelWidth / 10 * 8, 5, panelWidth / 10 * 3, panelHeight / 10);
    }


    public JButton getDiceRollerButton() {
        return diceRollerButton;
    }

    /**
     * The selector panel for JOptionPane
     * @return Gives back a panel with JRadioButtons on it.
     */
    public JPanel getSelectorJPanel() {
        JPanel selector = new JPanel();
        selector.setBounds(0, 0, 300, 150);
        selector.setVisible(true);

        token1.setBounds(10, 10,100, 30);
        token2.setBounds(160, 10,100, 30);
        token3.setBounds(10, 70,100, 30);
        token4.setBounds(160, 70,100, 30);

        buttonGroup.add(token1);
        buttonGroup.add(token2);
        buttonGroup.add(token3);
        buttonGroup.add(token4);


        token1.setVisible(controller.canMove(1, dicedNumber));
        token2.setVisible(controller.canMove(2, dicedNumber));
        token3.setVisible(controller.canMove(3, dicedNumber));
        token4.setVisible(controller.canMove(4, dicedNumber));


        token1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setChosenToken(1);
            }
        });

        token2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setChosenToken(2);
            }
        });

        token3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setChosenToken(3);
            }
        });

        token4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setChosenToken(4);
            }
        });

        selector.add(token1);
        selector.add(token2);
        selector.add(token3);
        selector.add(token4);

        selector.setVisible(true);
        return selector;
    }

    /**
     * Sets the chosen token according to the JOptionPane's
     * @param chosen - The number of the token which is chosen.
     */
    private void setChosenToken(int chosen) { this.chosenToken = chosen;}

    public JLabel getDiceRollingResult() {
        return diceRollingResult;
    }

    public int getChosenToken() {
        return chosenToken;
    }

    public JRadioButton getToken1() {
        return token1;
    }

    public JRadioButton getToken2() {
        return token2;
    }

    public JRadioButton getToken3() {
        return token3;
    }

    public JRadioButton getToken4() {
        return token4;
    }


    public Boolean checkChosenTokenIsValid() {

        boolean toContinue = true;

        Boolean[] cont = new Boolean[4];

        cont[0] = !(token1.isVisible() && token1.isSelected());
        cont[1] = !(token2.isVisible() && token2.isSelected());
        cont[2] = !(token3.isVisible() && token3.isSelected());
        cont[3] = !(token4.isVisible() && token4.isSelected());

        for (int i = 0; i < 4; i++) {
            if (!cont[i]) {
                toContinue = false;
            }
        }

        return toContinue;
    }


    public void setDicedNumber(int moveBy) {
        this.dicedNumber = moveBy;
    }
}
