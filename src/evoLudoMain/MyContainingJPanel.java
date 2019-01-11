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

        g.setColor(new Color(255, 0, 0));
        g.fillOval((int)(route.getRoute().get(tokens.getRedTokens().get(1)).getX()), (int)(route.getRoute().get(tokens.getRedTokens().get(1)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getRedTokens().get(2)).getX()), (int)(route.getRoute().get(tokens.getRedTokens().get(2)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getRedTokens().get(3)).getX()), (int)(route.getRoute().get(tokens.getRedTokens().get(3)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getRedTokens().get(4)).getX()), (int)(route.getRoute().get(tokens.getRedTokens().get(4)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);

        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Arial", Font.PLAIN, scaleUnitWidth / 12));
        g.drawString("1",(int) route.getRoute().get(tokens.getRedTokens().get(1)).getX()+(scaleUnitWidth / 18), (int)(route.getRoute().get(tokens.getRedTokens().get(1)).getY()+(scaleUnitHeight / 9)));
        g.drawString("2",(int) route.getRoute().get(tokens.getRedTokens().get(2)).getX()+(scaleUnitWidth / 18), (int)(route.getRoute().get(tokens.getRedTokens().get(2)).getY()+(scaleUnitHeight / 9)));
        g.drawString("3",(int) route.getRoute().get(tokens.getRedTokens().get(3)).getX()+(scaleUnitWidth / 18), (int)(route.getRoute().get(tokens.getRedTokens().get(3)).getY()+(scaleUnitHeight / 9)));
        g.drawString("4",(int) route.getRoute().get(tokens.getRedTokens().get(4)).getX()+(scaleUnitWidth / 18), (int)(route.getRoute().get(tokens.getRedTokens().get(4)).getY()+(scaleUnitHeight / 9)));


        g.setColor(new Color(0, 0, 255));
        g.fillOval((int)(route.getRoute().get(tokens.getBlueTokens().get(1)).getX()), (int)(route.getRoute().get(tokens.getBlueTokens().get(1)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getBlueTokens().get(2)).getX()), (int)(route.getRoute().get(tokens.getBlueTokens().get(2)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getBlueTokens().get(3)).getX()), (int)(route.getRoute().get(tokens.getBlueTokens().get(3)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getBlueTokens().get(4)).getX()), (int)(route.getRoute().get(tokens.getBlueTokens().get(4)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);

        g.setColor(new Color(0,0,0));
        g.drawString("1",(int)(route.getRoute().get(tokens.getBlueTokens().get(1)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getBlueTokens().get(1)).getY()+(scaleUnitHeight / 9)));
        g.drawString("2",(int)(route.getRoute().get(tokens.getBlueTokens().get(2)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getBlueTokens().get(2)).getY()+(scaleUnitHeight / 9)));
        g.drawString("3",(int)(route.getRoute().get(tokens.getBlueTokens().get(3)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getBlueTokens().get(3)).getY()+(scaleUnitHeight / 9)));
        g.drawString("4",(int)(route.getRoute().get(tokens.getBlueTokens().get(4)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getBlueTokens().get(4)).getY()+(scaleUnitHeight / 9)));

        g.setColor(new Color(0, 255, 0));
        g.fillOval((int)(route.getRoute().get(tokens.getGreenTokens().get(1)).getX()), (int)(route.getRoute().get(tokens.getGreenTokens().get(1)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getGreenTokens().get(2)).getX()), (int)(route.getRoute().get(tokens.getGreenTokens().get(2)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getGreenTokens().get(3)).getX()), (int)(route.getRoute().get(tokens.getGreenTokens().get(3)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getGreenTokens().get(4)).getX()), (int)(route.getRoute().get(tokens.getGreenTokens().get(4)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);

        g.setColor(new Color(0,0,0));
        g.drawString("1",(int)(route.getRoute().get(tokens.getGreenTokens().get(1)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getGreenTokens().get(1)).getY()+(scaleUnitHeight / 9)));
        g.drawString("2",(int)(route.getRoute().get(tokens.getGreenTokens().get(2)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getGreenTokens().get(2)).getY()+(scaleUnitHeight / 9)));
        g.drawString("3",(int)(route.getRoute().get(tokens.getGreenTokens().get(3)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getGreenTokens().get(3)).getY()+(scaleUnitHeight / 9)));
        g.drawString("4",(int)(route.getRoute().get(tokens.getGreenTokens().get(4)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getGreenTokens().get(4)).getY()+(scaleUnitHeight / 9)));


        g.setColor(new Color(255, 230, 0));
        g.fillOval((int)(route.getRoute().get(tokens.getYellowTokens().get(1)).getX()), (int)(route.getRoute().get(tokens.getYellowTokens().get(1)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getYellowTokens().get(2)).getX()), (int)(route.getRoute().get(tokens.getYellowTokens().get(2)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getYellowTokens().get(3)).getX()), (int)(route.getRoute().get(tokens.getYellowTokens().get(3)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);
        g.fillOval((int)(route.getRoute().get(tokens.getYellowTokens().get(4)).getX()), (int)(route.getRoute().get(tokens.getYellowTokens().get(4)).getY()), scaleUnitWidth / 6, scaleUnitHeight / 6);

        g.setColor(new Color(0,0,0));
        g.drawString("1",(int)(route.getRoute().get(tokens.getYellowTokens().get(1)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getYellowTokens().get(1)).getY()+(scaleUnitHeight / 9)));
        g.drawString("2",(int)(route.getRoute().get(tokens.getYellowTokens().get(2)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getYellowTokens().get(2)).getY()+(scaleUnitHeight / 9)));
        g.drawString("3",(int)(route.getRoute().get(tokens.getYellowTokens().get(3)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getYellowTokens().get(3)).getY()+(scaleUnitHeight / 9)));
        g.drawString("4",(int)(route.getRoute().get(tokens.getYellowTokens().get(4)).getX()+(scaleUnitWidth / 18)), (int)(route.getRoute().get(tokens.getYellowTokens().get(4)).getY()+(scaleUnitHeight / 9)));


        g.drawRect(shiftWidth + scaleUnitWidth, scaleUnitHeight + shiftHeight, scaleUnitWidth /6, scaleUnitHeight /6);
        g.drawRect(shiftWidth + scaleUnitWidth + scaleUnitWidth / 6 * 2, scaleUnitHeight + shiftHeight, scaleUnitWidth /6, scaleUnitHeight /6);
        g.drawRect(shiftWidth + scaleUnitWidth, scaleUnitHeight + shiftHeight + scaleUnitHeight / 6 * 2, scaleUnitWidth /6, scaleUnitHeight /6);
        g.drawRect(shiftWidth + scaleUnitWidth  + scaleUnitWidth / 6 * 2, scaleUnitHeight + shiftHeight + scaleUnitHeight / 6 * 2, scaleUnitWidth /6, scaleUnitHeight /6);

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
