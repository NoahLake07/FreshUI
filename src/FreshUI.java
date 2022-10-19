import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import javax.swing.*;
import java.awt.*;

public class FreshUI extends GraphicsProgram {

    public final int CENTER = SwingConstants.CENTER;
    public final int LEFT = SwingConstants.LEFT;
    public final int RIGHT = SwingConstants.RIGHT;

    public void init(){
        this.getMenuBar().setVisible(false);
        RoundRect rect = new RoundRect(100,100);
        add(rect, 100,100);
        rect.setFillColor(Color.GRAY);
        rect.setOutlineVisibility(true);
        rect.setOutlineThickness(30);
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
