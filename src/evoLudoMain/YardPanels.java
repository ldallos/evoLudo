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
        //TODO: Ide rajzolhatod a köröket a xCoordinates és yCoordinates alapján.
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
                diceRollingResult.setText(String.valueOf(dicedNumber));
                getSelectorJPanel();
                if (!(!token1.isVisible() && !token2.isVisible() && !token3.isVisible() && !token4.isVisible())) {
                    JOptionPane.showMessageDialog(null, getSelectorJPanel(), "You have " + dicedNumber + " steps to go. Please choose your token to move.", JOptionPane.INFORMATION_MESSAGE);
                }
                controller.moveToken(dicedNumber, chosenToken);
            }
        });

        diceRollerButton.setEnabled(false);

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


        token1.setVisible(controller.canMove(1, Integer.parseInt(this.diceRollingResult.getText())));
        token2.setVisible(controller.canMove(2, Integer.parseInt(this.diceRollingResult.getText())));
        token3.setVisible(controller.canMove(3, Integer.parseInt(this.diceRollingResult.getText())));
        token4.setVisible(controller.canMove(4, Integer.parseInt(this.diceRollingResult.getText())));


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
     * @param chosen
     */
    private void setChosenToken(int chosen) { this.chosenToken = chosen;}

    public int getDicedNumber() {
        return dicedNumber;
    }

    public void setDicedNumber(int dicedNumber) {
        this.dicedNumber = dicedNumber;
    }

    public JLabel getDiceRollingResult() {
        return diceRollingResult;
    }

    public void setDiceRollingResult(JLabel diceRollingResult) {
        this.diceRollingResult = diceRollingResult;
    }

    public int getChosenToken() {
        return chosenToken;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JRadioButton getToken1() {
        return token1;
    }

    public void setToken1(JRadioButton token1) {
        this.token1 = token1;
    }

    public JRadioButton getToken2() {
        return token2;
    }

    public void setToken2(JRadioButton token2) {
        this.token2 = token2;
    }

    public JRadioButton getToken3() {
        return token3;
    }

    public void setToken3(JRadioButton token3) {
        this.token3 = token3;
    }

    public JRadioButton getToken4() {
        return token4;
    }

    public void setToken4(JRadioButton token4) {
        this.token4 = token4;
    }




}
