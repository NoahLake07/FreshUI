package freshui;

import freshui.graphics.FRect;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;
import freshui.util.Resizer;

public class FreshUI extends FreshProgram {
    /*
    FreshUI - Java Toolkit
    Developed by Noah Lake
    */

    public void init(){
        FRect x = new FRect(20,40,this);
        add((FreshComponent) x, 40,40);
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
