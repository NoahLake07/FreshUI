import acm.program.GraphicsProgram;
import javax.swing.*;

public class FreshUI extends GraphicsProgram {

    public final int CENTER = SwingConstants.CENTER;
    public final int LEFT = SwingConstants.LEFT;
    public final int RIGHT = SwingConstants.RIGHT;

    @Override
    public void init(){
        this.getMenuBar().setVisible(false);
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
