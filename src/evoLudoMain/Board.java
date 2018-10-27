package evoLudoMain;


import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private JPanel redsYard = new JPanel();
    private JPanel bluesYard = new JPanel();
    private JPanel greensYard = new JPanel();
    private JPanel yellowsYard = new JPanel();
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

    public void paint(Graphics g) {
        super.paint(g);
        /**
         * Squares for route on the left of blue's yard.
         */
        for(int i = 1; i <= 6 ; i++) {
            for(int j = 1; j <= 3; j++) {
                //blue route
                g.setColor(new Color(0, 0, 0));
                g.drawRect(scaleUnitWidth, 0, (scaleUnitWidth/6) * j, (scaleUnitHeight/6) * i);
                g.setColor(new Color(0, 0, 255));
                g.fillRect((scaleUnitWidth*15)/13, 0, (scaleUnitWidth/5) , (scaleUnitHeight/6) * i);
                //yellow route
                g.setColor(new Color(255, 0, 0));
                g.fillRect(0, (scaleUnitHeight*15)/13, (scaleUnitWidth/6) * i, scaleUnitHeight/5);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(0, scaleUnitHeight, (scaleUnitWidth/6) * i, (scaleUnitHeight/6) * j);
                //green route
                g.setColor(new Color(0, 255, 0));
                g.fillRect((scaleUnitWidth /2)*3, (scaleUnitHeight*15)/13, (scaleUnitWidth/6) * i, (scaleUnitHeight/5));
                g.setColor(new Color(0, 0, 0));
                g.drawRect((scaleUnitWidth /2)*3, scaleUnitHeight, (scaleUnitWidth/6) * i, (scaleUnitHeight/6) * j);
                //yellow route
                g.setColor(new Color(255, 255, 0));
                g.fillRect((scaleUnitWidth*15)/13, (scaleUnitHeight /2)*3, scaleUnitWidth/5, (scaleUnitHeight/6) * i);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(scaleUnitWidth, (scaleUnitHeight /2)*3, (scaleUnitWidth/6) * j, (scaleUnitHeight/6) * i);
            }
        }
    }



    public Board() {
        initBoard();
    }

    /**
     * The method init the board with the panels on it.
     */
    private void initBoard() {
        /**
         * Setting up the basic informations about the frame.
         */
        setTitle("Ludo");
        setBounds(0, 0, (int)WIDTH, (int)HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        /**
         * Setting up the red player's yard, where the tokens stand.
         */
        redsYard.setBounds(0, 0, scaleUnitWidth, scaleUnitHeight);
        redsYard.setBackground(new Color(255, 0, 0));
        redsYard.setVisible(true);

        /**
         * Setting up the blue player's yard, where the tokens stand.
         */
        bluesYard.setBounds(scaleUnitWidth /2*3, (int) (0*HEIGHT), scaleUnitWidth, scaleUnitHeight);
        bluesYard.setBackground(new Color(0, 0, 255));
        bluesYard.setVisible(true);

        /**
         * Setting up the green player's yard, where the tokens stand.
         */
        greensYard.setBounds(scaleUnitWidth /2*3, scaleUnitHeight /2*3, scaleUnitWidth, scaleUnitHeight);
        greensYard.setBackground(new Color(0, 255, 0));
        greensYard.setVisible(true);



        /**
         * Setting up the yellow player's yard, where the tokens stand.
         */
        yellowsYard.setBounds((int) (0*WIDTH), scaleUnitHeight /2*3, scaleUnitWidth, scaleUnitHeight);
        yellowsYard.setBackground(new Color(255, 255, 0));
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
        redRoute.setVisible(true);

        /**
         * The route on the left of blue's yard.
         */
        blueRoute.setBounds(scaleUnitWidth, 0, scaleUnitWidth /2, scaleUnitHeight);
        blueRoute.setVisible(true);

        /**
         * The route above green's yard.
         */
        greenRoute.setBounds((scaleUnitWidth /2)*3, scaleUnitHeight, scaleUnitWidth, scaleUnitHeight /2);
        greenRoute.setVisible(true);

        /**
         * The route on the right of yellow's yard.
         */
        yellowRoute.setBounds(scaleUnitWidth, (scaleUnitHeight /2)*3, scaleUnitWidth /2, scaleUnitHeight);
        yellowRoute.setVisible(true);


        /**
         * Adding all elements to the JFrame.
         */
        add(redsYard);
        add(bluesYard);
        add(greensYard);
        add(yellowsYard);
        add(redRoute);
        add(blueRoute);
        add(greenRoute);
        add(yellowRoute);
        add(homeYard);
        refreshSizes();

    }



    public void refreshSizes() {
        this.WIDTH = getWidth();
        this.HEIGHT = getHeight();
        this.scaleUnitWidth = (int) (this.WIDTH / 5 * 2);
        this.scaleUnitHeight = (int) (this.HEIGHT / 5 * 2);
        redsYard.setBounds(0, 0, scaleUnitWidth, scaleUnitHeight);
        bluesYard.setBounds(scaleUnitWidth /2*3, (int) (0*HEIGHT), scaleUnitWidth, scaleUnitHeight);
        greensYard.setBounds(scaleUnitWidth /2*3, scaleUnitHeight /2*3, scaleUnitWidth, scaleUnitHeight);
        yellowsYard.setBounds((int) (0*WIDTH), scaleUnitHeight /2*3, scaleUnitWidth, scaleUnitHeight);
        homeYard.setBounds(scaleUnitWidth, scaleUnitHeight, scaleUnitWidth /2, scaleUnitHeight /2);
        redRoute.setBounds(0, scaleUnitHeight, scaleUnitWidth, scaleUnitHeight /2);
        blueRoute.setBounds(scaleUnitWidth, 0, scaleUnitWidth /2, scaleUnitHeight);
        greenRoute.setBounds((scaleUnitWidth /2)*3, scaleUnitHeight, scaleUnitWidth, scaleUnitHeight /2);
        yellowRoute.setBounds(scaleUnitWidth, (scaleUnitHeight /2)*3, scaleUnitWidth /2, scaleUnitHeight);

    }
}

