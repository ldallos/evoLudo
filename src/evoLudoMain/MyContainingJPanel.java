package evoLudoMain;

import javax.swing.*;
import java.awt.*;

public class MyContainingJPanel extends JPanel {

    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private double WIDTH = gd.getDisplayMode().getWidth();
    private double HEIGHT = gd.getDisplayMode().getHeight();
    private int scaleUnitWidth = (int) (WIDTH / 5);
    private int scaleUnitHeight = (int) (HEIGHT / 5);



    public void paint(Graphics g) {
        super.paint(g);
        this.WIDTH = getWidth();
        this.HEIGHT = getHeight();
        int shiftWidth = 0;
        int shiftHeight = 0;
        if (WIDTH < HEIGHT) {
            shiftHeight = (int) ((HEIGHT - WIDTH) /2);
            HEIGHT = WIDTH;
        }else {
            shiftWidth = (int) ((WIDTH - HEIGHT) /2);
            WIDTH = HEIGHT;
        }
        /**
         * Squares for route on the left of blue's yard.
         */
        for(int i = 1; i <= 6 ; i++) {
            for(int j = 1; j <= 3; j++) {

                //blue route
                g.setColor(new Color(0, 0, 0));
                g.drawRect(scaleUnitWidth+shiftWidth, shiftHeight, (scaleUnitWidth/6) * j, (scaleUnitHeight/6) * i);
                g.setColor(new Color(0, 0, 255));
                g.fillRect((scaleUnitWidth*15)/13 +shiftWidth, shiftHeight, (scaleUnitWidth/5) , (scaleUnitHeight/6) * i);
                //red route
                g.setColor(new Color(255, 0, 0));
                g.fillRect(shiftWidth, (scaleUnitHeight*15)/13 + shiftHeight, (scaleUnitWidth/6) * i, scaleUnitHeight/5);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(shiftWidth, scaleUnitHeight + shiftHeight, (scaleUnitWidth/6) * i, (scaleUnitHeight/6) * j);
                //green route
                g.setColor(new Color(0, 255, 0));
                g.fillRect((scaleUnitWidth /2)*3 + shiftWidth, (scaleUnitHeight*15)/13 + shiftHeight, (scaleUnitWidth/6) * i, (scaleUnitHeight/5));
                g.setColor(new Color(0, 0, 0));
                g.drawRect((scaleUnitWidth /2)*3 + shiftWidth, scaleUnitHeight + shiftHeight, (scaleUnitWidth/6) * i, (scaleUnitHeight/6) * j);
                //yellow route
                g.setColor(new Color(255, 255, 0));
                g.fillRect((scaleUnitWidth*15)/13 + shiftWidth, (scaleUnitHeight /2)*3 + shiftHeight, scaleUnitWidth/5, (scaleUnitHeight/6) * i);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(scaleUnitWidth + shiftWidth, (scaleUnitHeight /2)*3 + shiftHeight, (scaleUnitWidth/6) * j, (scaleUnitHeight/6) * i);

            }
        }
    }


    public void setSizes(int WIDTH, int HEIGHT, int scaleUnitWidth, int scaleUnitHeight) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.scaleUnitWidth = scaleUnitWidth;
        this.scaleUnitHeight = scaleUnitHeight;

    }


}
