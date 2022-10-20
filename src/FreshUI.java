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
        RoundRect rect = new RoundRect(230,230);
        add(rect, 100,100);
        rect.setFillColor(new Color(134, 134, 134));
        rect.setOutlineVisibility(true);

        GRect boundaries = new GRect(rect.getWidth(),rect.getHeight());
        add(boundaries,100,100);
        boundaries.setColor(new Color(218, 64, 64, 97));
        boundaries.setVisible(false);
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
