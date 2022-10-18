import acm.program.GraphicsProgram;
import javax.swing.*;
import java.awt.*;

public class FreshUI extends GraphicsProgram {

    public final int CENTER = SwingConstants.CENTER;
    public final int LEFT = SwingConstants.LEFT;
    public final int RIGHT = SwingConstants.RIGHT;

    @Override
    public void init(){
        this.getMenuBar().setVisible(false);
        Header header = new Header(this.getWidth(),"MY HEADER",CENTER,this);
        add(header,0,0);
        header.setHeaderColor(new Color(1, 82, 105));
        header.setText("Application");
        header.setTextColor(Color.white);
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
