package evoLudoMain;

import javax.swing.*;
import java.awt.*;

public class MyContainingJPanel extends JPanel {

    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private double WIDTH = gd.getDisplayMode().getWidth();
    private double HEIGHT = gd.getDisplayMode().getHeight();
    private int scaleUnitWidth = (int) (WIDTH / 5);
    private int scaleUnitHeight = (int) (HEIGHT / 5);
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
    }


    public void paint(Graphics g) {
        super.paint(g);
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

                /*
                 * Drawing circles
                 * I will need the positions from Krisztián's methods. Now it just draws circles in every route positions!
                 * */


        }
        }

        //TODO: ÁRON try to draw all of the positions of tokens, based on the values you can query from tokens and route.
        //TODO: for example: int place = tokens.getRedTokens().get(1) gives you the red players first token's number, which refers to the route.get(place)
        //tokens.getRedTokens().get(1) gives back an integer, which represents the number in the route list.
        //route.get(place) gives back a Position, where you should draw the circle.

        g.setColor(new Color(255, 0,0));
        g.fillOval((int)route.getRoute().get(getTokens().getRedTokens().get(1)).getX(),(int)route.getRoute().get(getTokens().getRedTokens().get(1)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getRedTokens().get(2)).getX(),(int)route.getRoute().get(getTokens().getRedTokens().get(2)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getRedTokens().get(3)).getX(),(int)route.getRoute().get(getTokens().getRedTokens().get(3)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getRedTokens().get(4)).getX(),(int)route.getRoute().get(getTokens().getRedTokens().get(4)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );

        g.setColor(new Color(0, 0,255));
        g.fillOval((int)route.getRoute().get(getTokens().getBlueTokens().get(1)).getX(),(int)route.getRoute().get(getTokens().getBlueTokens().get(1)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getBlueTokens().get(2)).getX(),(int)route.getRoute().get(getTokens().getBlueTokens().get(2)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getBlueTokens().get(3)).getX(),(int)route.getRoute().get(getTokens().getBlueTokens().get(3)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getBlueTokens().get(4)).getX(),(int)route.getRoute().get(getTokens().getBlueTokens().get(4)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );

        g.setColor(new Color(0, 255,0));
        g.fillOval((int)route.getRoute().get(getTokens().getGreenTokens().get(1)).getX(),(int)route.getRoute().get(getTokens().getGreenTokens().get(1)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getGreenTokens().get(2)).getX(),(int)route.getRoute().get(getTokens().getGreenTokens().get(2)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getGreenTokens().get(3)).getX(),(int)route.getRoute().get(getTokens().getGreenTokens().get(3)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getGreenTokens().get(4)).getX(),(int)route.getRoute().get(getTokens().getGreenTokens().get(4)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );

        g.setColor(new Color(255, 255,0));
        g.fillOval((int)route.getRoute().get(getTokens().getYellowTokens().get(1)).getX(),(int)route.getRoute().get(getTokens().getYellowTokens().get(1)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getYellowTokens().get(2)).getX(),(int)route.getRoute().get(getTokens().getYellowTokens().get(2)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getYellowTokens().get(3)).getX(),(int)route.getRoute().get(getTokens().getYellowTokens().get(3)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );
        g.fillOval((int)route.getRoute().get(getTokens().getYellowTokens().get(4)).getX(),(int)route.getRoute().get(getTokens().getYellowTokens().get(4)).getY(), scaleUnitWidth / 6 , scaleUnitHeight / 6 );


    }


    public void setSizes(int WIDTH, int HEIGHT, int scaleUnitWidth, int scaleUnitHeight, double shiftWidth, double shiftHeight) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.scaleUnitWidth = scaleUnitWidth;
        this.scaleUnitHeight = scaleUnitHeight;
        this.shiftWidth = (int) shiftWidth;
        this.shiftHeight = (int) shiftHeight;

    }


    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public int getScaleUnitWidth() {
        return scaleUnitWidth;
    }

    public int getScaleUnitHeight() {
        return scaleUnitHeight;
    }

    public int getShiftWidth() {
        return shiftWidth;
    }

    public int getShiftHeight() {
        return shiftHeight;
    }

    //If its called it do nothing, but triggers the paint method with the same size values and the refreshed position values for tokens.
    public void refreshMoves() {
        this.WIDTH = getWIDTH();
        this.HEIGHT = getHEIGHT();
        this.scaleUnitWidth = getScaleUnitWidth();
        this.scaleUnitHeight = getShiftHeight();
        this.shiftWidth = getShiftWidth();
        this.shiftHeight = getShiftHeight();
    }


    public Tokens getTokens() {
        return tokens;
    }

    public Route getRoute() {
        return route;
    }
}
