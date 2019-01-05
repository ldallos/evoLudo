package evoLudoMain;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LudoProgram {

    public static void main(String[] args) {
        final Board board = new Board();

        Controller controller = Controller.getInstance();

        controller.setBoard(board);



        board.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                board.refreshSizes();
            }
        });
    }

}
