package evoLudoMain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyContainingJPanel extends JPanel {

    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private double WIDTH = gd.getDisplayMode().getWidth();
    private double HEIGHT = gd.getDisplayMode().getHeight();
    private int scaleUnitWidth;
    private int scaleUnitHeight;
    private int shiftWidth;
    private int shiftHeight;
    private static MyContainingJPanel instance = null;
    private Route route = Route.getInstance();
    private Tokens tokens = Tokens.getInstance();
    private JButton testButton = new JButton("Test");



    public static MyContainingJPanel getInstance() {
        if (instance == null)
            return new MyContainingJPanel();

        return instance;
    }

    public MyContainingJPanel() {
        setBounds(0, 0, (int)WIDTH, (int)HEIGHT);
        if (this.WIDTH < this.HEIGHT) {
            shiftHeight = (int) ((this.HEIGHT - this.WIDTH) /2);
            this.HEIGHT = this.WIDTH;
        }else {
            shiftWidth = (int) ((WIDTH - HEIGHT) /2);
            this.WIDTH = this.HEIGHT;
        }

        add(testButton);
        testButton.setVisible(true);

        this.scaleUnitWidth = (int) (this.WIDTH / 5 * 2);
        this.scaleUnitHeight = (int) (this.HEIGHT / 5 * 2);
        route.resetPointPositions(scaleUnitWidth, scaleUnitHeight, shiftWidth, shiftHeight);
    }


    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Arial", Font.PLAIN, scaleUnitWidth / 12));

        for (int i = 0; i <= 4; i++) {
                //Drawing red finishing squares.
                g.setColor(new Color(190, 60, 60));
                g.fillRect(shiftWidth + scaleUnitWidth / 6 + scaleUnitWidth / 6 * i, shiftHeight + scaleUnitHeight + scaleUnitHeight / 6, scaleUnitWidth / 6, scaleUnitHeight / 6);

                //Drawing blue finishing squares.
                g.setColor(new Color(130, 165, 230));
                g.fillRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6, shiftHeight + scaleUnitHeight / 6 + scaleUnitHeight / 6 * i, scaleUnitWidth / 6, scaleUnitHeight / 6);

                //Drawing green finishing squares.
                g.setColor(new Color(70, 200, 70));
                g.fillRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 2 + scaleUnitWidth / 6 * i, shiftHeight + scaleUnitHeight + scaleUnitHeight / 6, scaleUnitWidth / 6, scaleUnitHeight / 6);

                //Drawing yellow finishing squares.
                g.setColor(new Color(220, 220, 130));
                g.fillRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6, shiftHeight + scaleUnitHeight + scaleUnitHeight / 2 + scaleUnitHeight / 6 * i, scaleUnitWidth / 6, scaleUnitHeight / 6);
            }


            g.setColor(new Color(0, 0, 0));

            /**
             * Squares for route on the left of blue's yard.
             */
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 3; j++) {

                    //blue route
                    g.drawRect(scaleUnitWidth + shiftWidth, shiftHeight, (scaleUnitWidth / 6) * j, (scaleUnitHeight / 6) * i);
                    //red route
                    g.drawRect(shiftWidth, scaleUnitHeight + shiftHeight, (scaleUnitWidth / 6) * i, (scaleUnitHeight / 6) * j);
                    //green route
                    g.drawRect((scaleUnitWidth / 2) * 3 + shiftWidth, scaleUnitHeight + shiftHeight, (scaleUnitWidth / 6) * i, (scaleUnitHeight / 6) * j);
                    //yellow route
                    g.drawRect(scaleUnitWidth + shiftWidth, (scaleUnitHeight / 2) * 3 + shiftHeight, (scaleUnitWidth / 6) * j, (scaleUnitHeight / 6) * i);

                }
            }


        //Drawing out the tokens for each player.
        drawFillOval(g, "red");
        drawFillOval(g, "blue");
        drawFillOval(g, "green");
        drawFillOval(g, "yellow");

        //Drawing home yard (the middle part of the board)
        g.drawRect(shiftWidth + scaleUnitWidth, scaleUnitHeight + shiftHeight, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.drawRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6 * 2, scaleUnitHeight + shiftHeight, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.drawRect(shiftWidth + scaleUnitWidth, scaleUnitHeight + shiftHeight + scaleUnitHeight / 6 * 2, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.drawRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6 * 2, scaleUnitHeight + shiftHeight + scaleUnitHeight / 6 * 2, scaleUnitWidth / 6, scaleUnitHeight / 6);

        //Drawing out how many tokens had reach the finish.
        g.drawString(String.valueOf(tokens.getFinished("red", 60)), shiftWidth + scaleUnitWidth + scaleUnitWidth / 18, scaleUnitHeight + shiftHeight + scaleUnitHeight / 3 - scaleUnitHeight / 18);
        g.drawString(String.valueOf(tokens.getFinished("blue", 65)), shiftWidth + scaleUnitWidth + scaleUnitWidth / 4 - scaleUnitWidth / 36, shiftHeight + scaleUnitHeight + scaleUnitHeight / 8);
        g.drawString(String.valueOf(tokens.getFinished("green", 70)), shiftWidth + scaleUnitWidth + scaleUnitWidth / 2 - scaleUnitWidth/ 9, scaleUnitHeight + shiftHeight + scaleUnitHeight / 3 - scaleUnitHeight / 18);
        g.drawString(String.valueOf(tokens.getFinished("yellow", 75)), shiftWidth + scaleUnitWidth + scaleUnitWidth / 4 - scaleUnitWidth / 36, shiftHeight + scaleUnitHeight + scaleUnitHeight / 2 - scaleUnitHeight / 18);

        //Drawing squares to give the illusion of disappearing the tokens
        disappearTokens(g);
    }


    public void setSizes(int WIDTH, int HEIGHT, int scaleUnitWidth, int scaleUnitHeight, double shiftWidth, double shiftHeight) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.scaleUnitWidth = scaleUnitWidth;
        this.scaleUnitHeight = scaleUnitHeight;
        this.shiftWidth = (int) shiftWidth;
        this.shiftHeight = (int) shiftHeight;

        testButton.setBounds((int)shiftWidth + scaleUnitWidth + scaleUnitWidth / 6, (int)shiftHeight + scaleUnitHeight + scaleUnitHeight / 6, scaleUnitWidth / 6, scaleUnitHeight / 6);
    }


    public Tokens getTokens() {
        return tokens;
    }

    public Route getRoute() {
        return route;
    }

    public JButton getTestButton() {
        return testButton;
    }


    private void disappearTokens(Graphics g) {
        g.setColor(new Color(190, 60, 60));
        g.fillRect(shiftWidth + scaleUnitWidth / 6 + scaleUnitWidth / 3 * 2, shiftHeight + scaleUnitHeight + scaleUnitHeight / 6, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.setColor(new Color(130, 165, 230));
        g.fillRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6, shiftHeight + scaleUnitHeight / 6 + scaleUnitHeight / 6 * 4, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.setColor(new Color(70, 200, 70));
        g.fillRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 2, shiftHeight + scaleUnitHeight + scaleUnitHeight / 6, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.setColor(new Color(220, 220, 130));
        g.fillRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6, shiftHeight + scaleUnitHeight + scaleUnitHeight / 2, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.setColor(new Color(0, 0, 0));
        g.drawRect(shiftWidth + scaleUnitWidth / 6 + scaleUnitWidth / 3 * 2, shiftHeight + scaleUnitHeight + scaleUnitHeight / 6, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.drawRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6, shiftHeight + scaleUnitHeight / 6 + scaleUnitHeight / 6 * 4, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.drawRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6, shiftHeight + scaleUnitHeight + scaleUnitHeight / 2, scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.drawRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 2, shiftHeight + scaleUnitHeight + scaleUnitHeight / 6, scaleUnitWidth / 6, scaleUnitHeight / 6);
    }


    private void drawFillOval(Graphics g, String player) {

        ArrayList<Integer> drawTokens = new ArrayList<>();
        ArrayList<Integer> drawTokenNumbers = new ArrayList<>();

        switch (player) {
            case "red":
                for (int i = 1; i <5; i++) {
                    drawTokens.add((int)route.getRoute().get(tokens.getRedTokens().get(i)).getX());
                    drawTokens.add((int)route.getRoute().get(tokens.getRedTokens().get(i)).getY());
                    drawTokenNumbers.add((int)route.getRoute().get(tokens.getRedTokens().get(i)).getX()+(scaleUnitWidth / 18));
                    drawTokenNumbers.add((int)route.getRoute().get(tokens.getRedTokens().get(i)).getY()+(scaleUnitHeight / 9));
                    g.setColor(new Color(255, 0, 0));
                }
                break;

            case "blue":
                for (int i = 1; i <5; i++) {
                    drawTokens.add((int)route.getRoute().get(tokens.getBlueTokens().get(i)).getX());
                    drawTokens.add((int)route.getRoute().get(tokens.getBlueTokens().get(i)).getY());
                    drawTokenNumbers.add((int)route.getRoute().get(tokens.getBlueTokens().get(i)).getX()+(scaleUnitWidth / 18));
                    drawTokenNumbers.add((int)route.getRoute().get(tokens.getBlueTokens().get(i)).getY()+(scaleUnitHeight / 9));
                    g.setColor(new Color(0, 0, 255));
                }
                break;

            case "green":
                for (int i = 1; i <5; i++) {
                    drawTokens.add((int)route.getRoute().get(tokens.getGreenTokens().get(i)).getX());
                    drawTokens.add((int)route.getRoute().get(tokens.getGreenTokens().get(i)).getY());
                    drawTokenNumbers.add((int)route.getRoute().get(tokens.getGreenTokens().get(i)).getX()+(scaleUnitWidth / 18));
                    drawTokenNumbers.add((int)route.getRoute().get(tokens.getGreenTokens().get(i)).getY()+(scaleUnitHeight / 9));
                    g.setColor(new Color(0, 255, 0));
                }
                break;

            case "yellow":
                for (int i = 1; i <5; i++) {
                    drawTokens.add((int)route.getRoute().get(tokens.getYellowTokens().get(i)).getX());
                    drawTokens.add((int)route.getRoute().get(tokens.getYellowTokens().get(i)).getY());
                    drawTokenNumbers.add((int)route.getRoute().get(tokens.getYellowTokens().get(i)).getX()+(scaleUnitWidth / 18));
                    drawTokenNumbers.add((int)route.getRoute().get(tokens.getYellowTokens().get(i)).getY()+(scaleUnitHeight / 9));
                    g.setColor(new Color(255, 230, 0));
                }
                break;

            default:
                System.out.println("Not existing player!");
        }

        g.fillOval(drawTokens.get(0), drawTokens.get(1), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval(drawTokens.get(2), drawTokens.get(3), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval(drawTokens.get(4), drawTokens.get(5), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval(drawTokens.get(6), drawTokens.get(7), scaleUnitWidth / 6, scaleUnitHeight / 6);

        g.setColor(new Color(0,0,0));
        g.drawString("1",drawTokenNumbers.get(0), drawTokenNumbers.get(1));
        g.drawString("2",drawTokenNumbers.get(2), drawTokenNumbers.get(3));
        g.drawString("3",drawTokenNumbers.get(4), drawTokenNumbers.get(5));
        g.drawString("4",drawTokenNumbers.get(6), drawTokenNumbers.get(7));

    }

}
