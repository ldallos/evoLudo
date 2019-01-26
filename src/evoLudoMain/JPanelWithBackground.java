package evoLudoMain;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JPanelWithBackground extends JPanel {

    private BufferedImage backgroundImage = ImageIO.read(new File("background.png"));
    private float opacity = 0.08f;

    public void paint(Graphics g) {
        g.drawImage(makeImageTranslucent(backgroundImage, opacity), 0, 0,this);
    }

    public JPanelWithBackground() throws IOException {
        setBounds(0, 0, 360, 360);
        setVisible(true);

    }


    public BufferedImage makeImageTranslucent(BufferedImage source, double alpha) {
        BufferedImage target = new BufferedImage(source.getWidth(), source.getHeight(), java.awt.Transparency.TRANSLUCENT);
        // Get the images graphics
        Graphics2D g = target.createGraphics();
        // Set the Graphics composite to Alpha
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) alpha));
        // Draw the image into the prepared reciver image
        g.drawImage(source, null, 0, 0);
        // let go of all system resources in this Graphics
        g.dispose();
        // Return the image
        return target;
    }


}
