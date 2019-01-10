package evoLudoMain;

import javax.swing.*;
import java.awt.*;

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



        this.scaleUnitWidth = (int) (this.WIDTH / 5 * 2);
        this.scaleUnitHeight = (int) (this.HEIGHT / 5 * 2);
        route.resetPointPositions(scaleUnitWidth, scaleUnitHeight, shiftWidth, shiftHeight);
    }


    public void paint(Graphics g) {
        super.paint(g);

        for(int i = 0; i <= 4; i++) {
            //Drawing red finishing squares.
            g.setColor(new Color(190, 60, 60));
            g.fillRect(shiftWidth + scaleUnitWidth / 6 + scaleUnitWidth / 6 * i, shiftHeight + scaleUnitHeight + scaleUnitHeight /6, scaleUnitWidth / 6, scaleUnitHeight /6);

            //Drawing blue finishing squares.
            g.setColor(new Color(130, 165, 230));
            g.fillRect(shiftWidth + scaleUnitWidth + scaleUnitWidth /6, shiftHeight + scaleUnitHeight / 6 + scaleUnitHeight / 6 *i, scaleUnitWidth / 6, scaleUnitHeight /6);

            //Drawing green finishing squares.
            g.setColor(new Color(70, 200, 70));
            g.fillRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 2 + scaleUnitWidth / 6 * i, shiftHeight + scaleUnitHeight + scaleUnitHeight /6, scaleUnitWidth / 6, scaleUnitHeight /6);

            //Drawing yellow finishing squares.
            g.setColor(new Color(220, 220, 130));
            g.fillRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6, shiftHeight + scaleUnitHeight + scaleUnitHeight / 2 + scaleUnitHeight / 6 *i, scaleUnitWidth / 6, scaleUnitHeight /6);
        }


        g.setColor(new Color(0,0,0));

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


        //TODO: ÁRON try to draw all of the positions of tokens, based on the values you can query from tokens and route.
        //TODO: for example: int place = tokens.getRedTokens().get(1) gives you the red players first token's number, which refers to the route.get(place)
        //tokens.getRedTokens().get(1) gives back an integer, which represents the number in the route list.
        //route.get(place) gives back a Position, where you should draw the circle.

    }


    public void setSizes(int WIDTH, int HEIGHT, int scaleUnitWidth, int scaleUnitHeight, double shiftWidth, double shiftHeight) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.scaleUnitWidth = scaleUnitWidth;
        this.scaleUnitHeight = scaleUnitHeight;
        this.shiftWidth = (int) shiftWidth;
        this.shiftHeight = (int) shiftHeight;

    }


    public Tokens getTokens() {
        return tokens;
    }

    public Route getRoute() {
        return route;
    }
}
