package freshui;

import freshui.graphics.FRect;
import freshui.gui.Input;
import freshui.program.FreshProgram;
import freshui.util.FColor;
import freshui.util.Resizer;

public class FreshUI extends FreshProgram {

    public void init(){
        FRect rect = new FRect(45,45);
        add(rect,50,50);

        Resizer resizer = new Resizer(this);
        resizer.add(rect);
        resizer.startResizing();

    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
