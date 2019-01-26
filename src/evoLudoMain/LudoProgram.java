package evoLudoMain;

import javax.swing.*;
import java.io.IOException;

public class LudoProgram {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            StartFrame startFrame = new StartFrame();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | IOException e1) {
            e1.printStackTrace();
        }

    }

}
