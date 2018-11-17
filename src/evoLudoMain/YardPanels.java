package evoLudoMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class YardPanels extends JPanel {
    private int[] xCoordinates = new int[4];
    private int[] yCoordinates = new int[4];
    private int ovalDiameter = 0;
    private JButton diceRollerButton = new JButton("Dice me!");
    private JLabel diceRollingResult = new JLabel();


    public YardPanels() {
        diceRollerButton.setVisible(true);
        diceRollingResult.setVisible(true);
        add(diceRollerButton);
        add(diceRollingResult);
    }


    public void refreshSizes() {
        int panelWidth = (int) getSize().getWidth();
        int panelHeight = (int) getSize().getHeight();

        xCoordinates[0] = (panelWidth / 10 * 3) - (ovalDiameter/2);
        xCoordinates[1] = (panelWidth / 10 * 7) - (ovalDiameter/2);
        xCoordinates[2] = (panelWidth / 10 * 3) - (ovalDiameter/2);
        xCoordinates[3] = (panelWidth / 10 * 7) - (ovalDiameter/2);

        yCoordinates[0] = (panelHeight / 10 * 3) - (ovalDiameter/2);
        yCoordinates[1] = (panelHeight / 10 * 3)- (ovalDiameter/2);
        yCoordinates[2] = (panelHeight / 10 * 7) - (ovalDiameter/2);
        yCoordinates[3] = (panelHeight / 10 * 7) - (ovalDiameter/2);

        this.ovalDiameter = panelWidth / 5;

        diceRollerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Random rand = new Random();
                int n = rand.nextInt(6) + 1;
                diceRollingResult.setText(String.valueOf(n));
                diceRollerButton.setBounds(panelWidth / 10 , panelHeight / 10 , panelWidth/10 * 5, panelHeight / 10 );
                diceRollingResult.setBounds(panelWidth / 10 * 8, panelHeight / 10, panelWidth / 10 * 3, panelHeight / 10);

            }
        });

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

    public JButton getDiceRollerButton() {
        return diceRollerButton;
    }

    public void setDiceRollerButton(JButton diceRollerButton) {
        this.diceRollerButton = diceRollerButton;
    }
}
