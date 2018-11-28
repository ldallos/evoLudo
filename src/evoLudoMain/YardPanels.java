package evoLudoMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class YardPanels extends JPanel {
    private int[] xCoordinates = new int[4];
    private int[] yCoordinates = new int[4];
    private int ovalDiameter = 0;
    private JButton diceRollerButton = new JButton("Dice me!");
    private JLabel diceRollingResult = new JLabel();
    private int panelWidth = (int) getSize().getWidth();
    private int panelHeight = (int) getSize().getHeight();


    public void paint(Graphics g) {
        super.paint(g);


        //TODO Elődnek ide kell rajzolnia a köröket.
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
                int n = rand.nextInt(6) + 1;
                diceRollingResult.setText(String.valueOf(n));

                TokenSelectorWindow tokenSelectorWindow = new TokenSelectorWindow();
                tokenSelectorWindow.setDiceResult(n);
            }
        });

        add(diceRollerButton);
        add(diceRollingResult);
    }


    public void refreshSizes() {

        panelWidth = (int) getSize().getWidth();
        panelHeight = (int) getSize().getHeight();

        xCoordinates[0] = (panelWidth / 10 * 3) - (ovalDiameter/2);
        xCoordinates[1] = (panelWidth / 10 * 7) - (ovalDiameter/2);
        xCoordinates[2] = (panelWidth / 10 * 3) - (ovalDiameter/2);
        xCoordinates[3] = (panelWidth / 10 * 7) - (ovalDiameter/2);

        yCoordinates[0] = (panelHeight / 10 * 3) - (ovalDiameter/2);
        yCoordinates[1] = (panelHeight / 10 * 3)- (ovalDiameter/2);
        yCoordinates[2] = (panelHeight / 10 * 7) - (ovalDiameter/2);
        yCoordinates[3] = (panelHeight / 10 * 7) - (ovalDiameter/2);

        this.ovalDiameter = panelWidth / 5;


        diceRollerButton.setBounds(panelWidth / 10 , 5 , panelWidth/10 * 5, panelHeight / 10 );
        diceRollingResult.setBounds(panelWidth / 10 * 8, 5, panelWidth / 10 * 3, panelHeight / 10);
    }

    public int[] getxCoordinates() {
        return xCoordinates;
    }

    public void setxCoordinates(int[] xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    public int[] getyCoordinates() {
        return yCoordinates;
    }

    public void setyCoordinates(int[] yCoordinates) {
        this.yCoordinates = yCoordinates;
    }

    public int getOvalDiameter() {
        return ovalDiameter;
    }

    public void setOvalDiameter(int ovalDiameter) {
        this.ovalDiameter = ovalDiameter;
    }

    public JLabel getDiceRollingResult() {
        return diceRollingResult;
    }

    public JButton getDiceRollerButton() {
        return diceRollerButton;
    }
}
