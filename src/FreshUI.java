import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import javax.swing.*;
import java.awt.*;

public class FreshUI extends GraphicsProgram {

    public void init(){
        this.getMenuBar().setVisible(false);
        this.setProgramName("FreshUI Window");

        FRect x = new FRect(100,100);
        add(x, 30,30);

        x.makeRounded();
        x.setCornerRadius(30);
        x.makeSharp();
        x.setColor(Color.BLUE);
        x.makeRounded();
        x.setOutlineVisible(true);
        x.setOutlineThickness(6);
        x.setOutlineColor(Color.BLACK);
    }

    public void setProgramName(String s){
        this.setTitle(s);
        this.getMenuBar().setName(s);
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
