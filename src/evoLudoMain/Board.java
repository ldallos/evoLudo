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
        setBounds(0, 0, 1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        /**
         * Setting up the red player's yard, where the tokens stand.
         */
        redsYard.setBounds(0, 0, 350, 350);
        redsYard.setBackground(new Color(255, 0, 0));
        redsYard.setVisible(true);

        /**
         * Setting up the blue player's yard, where the tokens stand.
         */
        bluesYard.setBounds(650, 0, 350, 350);
        bluesYard.setBackground(new Color(0, 0, 255));
        bluesYard.setVisible(true);

        /**
         * Setting up the green player's yard, where the tokens stand.
         */
        greensYard.setBounds(650, 650, 350, 350);
        greensYard.setBackground(new Color(0, 255, 0));
        greensYard.setVisible(true);


        /**
         * Setting up the yellow player's yard, where the tokens stand.
         */
        yellowsYard.setBounds(0, 650, 350, 350);
        yellowsYard.setBackground(new Color(255, 255, 0));
        yellowsYard.setVisible(true);

        /**
         * Setting up the home yard.
         */
        homeYard.setBounds(350, 350, 300, 300);
        homeYard.setVisible(true);

        /**
         * The route under red's yard.
         */
        redRoute.setBounds(0, 350, 350, 300);
        redRoute.setVisible(true);

        /**
         * The route on the left of blue's yard.
         */
        blueRoute.setBounds(350, 0, 300, 350);
        blueRoute.setVisible(true);

        /**
         * The route above green's yard.
         */
        greenRoute.setBounds(650, 350, 350, 300);
        greenRoute.setVisible(true);

        /**
         * The route on the right of yellow's yard.
         */
        yellowRoute.setBounds(350, 650, 300, 350);
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
    }
}

