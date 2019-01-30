package evoLudoMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class StartFrame extends JFrame {

    private JPanelWithBackground jPanelWithBackground = new JPanelWithBackground();
    private JButton startGameButton = new JButton("Start a new game");
    private JButton quitGameButton = new JButton("Quit game");


    public StartFrame() throws IOException {
        setTitle("Ludo");
        setBounds(0, 0, 360, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanelWithBackground.repaint();
        setResizable(false);
        getContentPane().add(jPanelWithBackground);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);


        startGameButton.setBounds(80, 70, 200, 50);
        quitGameButton.setBounds(80, 230, 200, 50);

        startGameButton.setVisible(true);
        quitGameButton.setVisible(true);

        add(startGameButton);
        add(quitGameButton);


        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final Board board = new Board(getThisFrame());

                Controller controller = Controller.getInstance();

                controller.setBoard(board);

                board.addComponentListener(new ComponentAdapter() {
                    public void componentResized(ComponentEvent evt) {
                        board.refreshSizes();
                    }
                });

                controller.setTestButton();
                //board.getMyContainingJPanel().getTestButton().setVisible(false);
                dispose();
            }
        });

        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });




    }

    public StartFrame getThisFrame() {
        return this;
    }

}
