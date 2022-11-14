package freshui;

import freshui.graphics.FRect;
import freshui.program.FreshProgram;
import freshui.util.Resizer;

public class FreshUI extends FreshProgram {
    /*
    FreshUI - Java Toolkit
    Developed by Noah Lake
    */

    public void init(){
        FRect rect = new FRect(45,45);
        add(rect,50,50);

        Resizer resizer = new Resizer(this);
        resizer.add(rect);
        resizer.startResizing();

        System.out.println("Thread was successful");
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
