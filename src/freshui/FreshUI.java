package freshui;

import acm.program.GraphicsProgram;
import freshui.graphics.FRect;
import javax.swing.*;
import java.awt.*;

public class FreshUI extends GraphicsProgram {

    public final int CENTER = SwingConstants.CENTER;
    public final int LEFT = SwingConstants.LEFT;
    public final int RIGHT = SwingConstants.RIGHT;

    public void init(){
        this.getMenuBar().setVisible(false);
        this.setProgramName("FreshUI Window");

        FRect x = new FRect(60,60);
        add(x,50,100);

        x.startResizingOnWindow(this);

    }

    public void setProgramName(String s){
        this.setTitle(s);
        this.getMenuBar().setName(s);
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
