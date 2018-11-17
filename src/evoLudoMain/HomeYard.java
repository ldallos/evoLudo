package evoLudoMain;

import javax.swing.*;
import java.awt.*;

public class HomeYard extends JPanel {

    private int[][] triangle1Values = new int[2][4];
    private int[][] triangle2Values = new int[2][4];
    private int[][] triangle3Values = new int[2][4];
    private int[][] triangle4Values = new int[2][4];

    public HomeYard() {
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0,0,0));
        //TODO Draw here the circles. Use the super.getxCoordinates[0]..... etc. to define the position of the coordinates.
    }




    public void refreshSizes() {

        triangle1Values[0] = new int[]{0, ((int) getSize().getWidth()), ((int) getSize().getWidth())/2};
        triangle1Values[1] = new int[]{0, 0, ((int) getSize().getHeight())/2};

        triangle2Values[0] = new int[]{((int) getSize().getWidth()), ((int) getSize().getWidth()), ((int) getSize().getWidth())/2};
        triangle2Values[1] = new int[]{0, ((int) getSize().getHeight()), ((int) getSize().getHeight())/2};

        triangle3Values[0] = new int[]{0, ((int) getSize().getWidth()), ((int) getSize().getWidth())/2};
        triangle3Values[1] = new int[]{((int) getSize().getHeight()), ((int) getSize().getHeight()), ((int) getSize().getHeight())/2};

        triangle4Values[0] = new int[]{0, 0, ((int) getSize().getWidth())/2};
        triangle4Values[1] = new int[]{0, ((int) getSize().getHeight()), ((int) getSize().getHeight())/2};

    }
}
