package evoLudoMain;


import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private MyContainingJPanel myContainingJPanel = MyContainingJPanel.getInstance();
    private YardPanels redsYard = new YardPanels();
    private YardPanels bluesYard = new YardPanels();
    private YardPanels greensYard = new YardPanels();
    private YardPanels yellowsYard = new YardPanels();
    private JPanel homeYard = new JPanel();
    private JPanel yellowRoute = new JPanel();
    private JPanel greenRoute = new JPanel();
    private JPanel redRoute = new JPanel();
    private JPanel blueRoute = new JPanel();
    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private double WIDTH = gd.getDisplayMode().getWidth();
    private double HEIGHT = gd.getDisplayMode().getHeight();
    private int scaleUnitWidth = (int) (WIDTH / 5);
    private int scaleUnitHeight = (int) (HEIGHT / 5);
    private Route route = Route.getInstance();

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

        homeYard.setBounds((int) (this.scaleUnitWidth + shiftWidth), (int) (this.scaleUnitHeight + shiftHeight), this.scaleUnitWidth /2, this.scaleUnitHeight /2);

        //routes

        redRoute.setBounds((int) shiftWidth + scaleUnitWidth/6, (int) (this.scaleUnitHeight + shiftHeight) + scaleUnitWidth/6, this.scaleUnitWidth / 6 * 5, this.scaleUnitHeight / 6);

        blueRoute.setBounds((int) (this.scaleUnitWidth + shiftWidth) + scaleUnitWidth/6, (int) shiftHeight + scaleUnitWidth/6, this.scaleUnitWidth / 6, this.scaleUnitHeight/ 6 *5);

        greenRoute.setBounds((int) ((this.scaleUnitWidth /2)*3 + shiftWidth), (int) (this.scaleUnitHeight + shiftHeight) + scaleUnitWidth/6, this.scaleUnitWidth / 6 * 5, this.scaleUnitHeight /6);

        yellowRoute.setBounds((int) (this.scaleUnitWidth + shiftWidth) + scaleUnitWidth/6, (int) ((this.scaleUnitHeight /2)*3 + shiftHeight) + scaleUnitWidth/6, this.scaleUnitWidth /6, this.scaleUnitHeight/6 * 5);


        //Refreshing values to work dynamically
        redsYard.refreshSizes();
        bluesYard.refreshSizes();
        greensYard.refreshSizes();
        yellowsYard.refreshSizes();
        route.resetPointPositions(scaleUnitWidth, scaleUnitHeight, shiftWidth, shiftHeight);

    }
    /**
     * The method init the board with the panels on it.
     */
    private void init() {
        /**
         * Setting up the red player's yard, where the tokens stand.
         */
        redsYard.setBounds(0, 0, scaleUnitWidth, scaleUnitHeight);
        //redsYard.setBackground(new Color(255, 0, 0));
        redsYard.setVisible(true);

        /**
         * Setting up the blue player's yard, where the tokens stand.
         */
        bluesYard.setBounds(scaleUnitWidth /2*3, (int) (0*HEIGHT), scaleUnitWidth, scaleUnitHeight);
        //bluesYard.setBackground(new Color(0, 0, 255));
        bluesYard.setVisible(true);

        /**
         * Setting up the green player's yard, where the tokens stand.
         */
        greensYard.setBounds(scaleUnitWidth /2*3, scaleUnitHeight /2*3, scaleUnitWidth, scaleUnitHeight);
        //greensYard.setBackground(new Color(0, 255, 0));
        greensYard.setVisible(true);



        /**
         * Setting up the yellow player's yard, where the tokens stand.
         */
        yellowsYard.setBounds((int) (0*WIDTH), scaleUnitHeight /2*3, scaleUnitWidth, scaleUnitHeight);
       // yellowsYard.setBackground(new Color(255, 255, 0));
        yellowsYard.setVisible(true);


        /**
         * Setting up the home yard.
         */
        homeYard.setBounds(scaleUnitWidth, scaleUnitHeight, scaleUnitWidth /2, scaleUnitHeight /2);
        homeYard.setVisible(true);

        /**
         * The route under red's yard.
         */
        redRoute.setBounds(0, scaleUnitHeight, scaleUnitWidth, scaleUnitHeight /2);
        redRoute.setBackground(new Color(255, 0, 0));
        redRoute.setVisible(true);

        /**
         * The route on the left of blue's yard.
         */
        blueRoute.setBounds(scaleUnitWidth, 0, scaleUnitWidth / 2, scaleUnitHeight);
        blueRoute.setBackground(new Color(0, 0, 225));
        blueRoute.setVisible(true);

        /**
         * The route above green's yard.
         */
        greenRoute.setBounds((scaleUnitWidth /2)*3, scaleUnitHeight, scaleUnitWidth, scaleUnitHeight /2);
        greenRoute.setBackground(new Color(0, 255, 0));
        greenRoute.setVisible(true);

        /**
         * The route on the right of yellow's yard.
         */
        yellowRoute.setBounds(scaleUnitWidth, (scaleUnitHeight /2)*3, scaleUnitWidth /2, scaleUnitHeight);
        yellowRoute.setBackground(new Color(255, 255, 0));
        yellowRoute.setVisible(true);



        myContainingJPanel.setBounds(0, 0, (int)WIDTH, (int)HEIGHT);
        myContainingJPanel.setVisible(true);





        /**
         * Adding all elements to the JFrame.
         */
        myContainingJPanel.add(redsYard);
        myContainingJPanel.add(bluesYard);
        myContainingJPanel.add(greensYard);
        myContainingJPanel.add(yellowsYard);
        myContainingJPanel.add(redRoute);
        myContainingJPanel.add(blueRoute);
        myContainingJPanel.add(greenRoute);
        myContainingJPanel.add(yellowRoute);
        myContainingJPanel.add(homeYard);
        add(myContainingJPanel);


    }



}

