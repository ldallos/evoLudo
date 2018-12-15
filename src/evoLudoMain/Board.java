package evoLudoMain;


import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private MyContainingJPanel myContainingJPanel = MyContainingJPanel.getInstance();
    private YardPanels redsYard = new YardPanels();
    private YardPanels bluesYard = new YardPanels();
    private YardPanels greensYard = new YardPanels();
    private YardPanels yellowsYard = new YardPanels();
    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private double WIDTH = gd.getDisplayMode().getWidth();
    private double HEIGHT = gd.getDisplayMode().getHeight();
    private int scaleUnitWidth = (int) (WIDTH / 5);
    private int scaleUnitHeight = (int) (HEIGHT / 5);


    public Board() {
        /**
         * Setting up the basic information about the frame.
         */
        setTitle("Ludo");
        setBounds(0, 0, (int) WIDTH, (int) HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();

        setContentPane(myContainingJPanel);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        getRedsYard().getDiceRollerButton().setEnabled(true);


    }

    public void refreshSizes() {
        this.WIDTH = getWidth();
        this.HEIGHT = getHeight();
        double shiftWidth = 0;
        double shiftHeight = 0;
        if (this.WIDTH < this.HEIGHT) {
            shiftHeight = (this.HEIGHT - this.WIDTH) /2;
            this.HEIGHT = this.WIDTH;
        }else {
            shiftWidth = (this.WIDTH - this.HEIGHT) /2;
            this.WIDTH = this.HEIGHT;
        }



        this.scaleUnitWidth = (int) (this.WIDTH / 5 * 2);
        this.scaleUnitHeight = (int) (this.HEIGHT / 5 * 2);
        myContainingJPanel.setSizes((int)this.WIDTH, (int)this.HEIGHT, this.scaleUnitWidth, this.scaleUnitHeight, shiftWidth, shiftHeight);

        //yards

        redsYard.setBounds((int) shiftWidth, (int) shiftHeight, this.scaleUnitWidth, this.scaleUnitHeight);

        bluesYard.setBounds((int) (this.scaleUnitWidth /2*3 + shiftWidth),(int) ((0*HEIGHT) + shiftHeight), this.scaleUnitWidth, this.scaleUnitHeight);

        greensYard.setBounds((int) (this.scaleUnitWidth /2*3 + shiftWidth), (int) (this.scaleUnitHeight /2*3 + shiftHeight), this.scaleUnitWidth, this.scaleUnitHeight);

        yellowsYard.setBounds((int) ((int) (0*WIDTH) + shiftWidth), (int) (this.scaleUnitHeight /2*3 + shiftHeight), this.scaleUnitWidth, this.scaleUnitHeight);

        //Refreshing values to work dynamically
        redsYard.refreshSizes();
        bluesYard.refreshSizes();
        greensYard.refreshSizes();
        yellowsYard.refreshSizes();
        myContainingJPanel.getRoute().resetPointPositions(scaleUnitWidth, scaleUnitHeight, shiftWidth, shiftHeight);


    }
    /**
     * The method init the board with the panels on it.
     */
    private void init() {
        /**
         * Setting up the red player's yard, where the tokens stand.
         */
        redsYard.setBounds(0, 0, scaleUnitWidth, scaleUnitHeight);
        redsYard.setVisible(true);

        /**
         * Setting up the blue player's yard, where the tokens stand.
         */
        bluesYard.setBounds(scaleUnitWidth /2*3, (int) (0*HEIGHT), scaleUnitWidth, scaleUnitHeight);
        bluesYard.setVisible(true);

        /**
         * Setting up the green player's yard, where the tokens stand.
         */
        greensYard.setBounds(scaleUnitWidth /2*3, scaleUnitHeight /2*3, scaleUnitWidth, scaleUnitHeight);
        greensYard.setVisible(true);



        /**
         * Setting up the yellow player's yard, where the tokens stand.
         */
        yellowsYard.setBounds((int) (0*WIDTH), scaleUnitHeight /2*3, scaleUnitWidth, scaleUnitHeight);
        yellowsYard.setVisible(true);

        myContainingJPanel.setBounds(0, 0, (int)WIDTH, (int)HEIGHT);
        myContainingJPanel.setVisible(true);





        /**
         * Adding all elements to the JFrame.
         */
        myContainingJPanel.add(redsYard);
        myContainingJPanel.add(bluesYard);
        myContainingJPanel.add(greensYard);
        myContainingJPanel.add(yellowsYard);
        add(myContainingJPanel);


    }


    public MyContainingJPanel getMyContainingJPanel() {
        return myContainingJPanel;
    }

    public YardPanels getRedsYard() {
        return redsYard;
    }

    public YardPanels getBluesYard() {
        return bluesYard;
    }

    public YardPanels getGreensYard() {
        return greensYard;
    }

    public YardPanels getYellowsYard() {
        return yellowsYard;
    }

    public Route getRoute() {
        return myContainingJPanel.getRoute();
    }
}

