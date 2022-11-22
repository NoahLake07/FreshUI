package freshui;

import freshui.graphics.FRect;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;
import freshui.util.FColor;
import freshui.util.Resizer;
import java.awt.*;

public class FreshUI extends FreshProgram {
    /*
    FreshUI - Java Toolkit
    Developed by Noah Lake
    */

    public void init(){
        FRect x = new FRect(100,100,this);
        add(x, 30,30);
        x.setColor(Color.GRAY);
        x.setOutlineVisible(true);
        x.setRounded(true);
        x.setOutlineColor(Color.BLACK);
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
