package freshui;

import freshui.graphics.FRect;
import freshui.gui.Input;
import freshui.program.FreshProgram;
import freshui.util.FColor;

public class FreshUI extends FreshProgram {

    public void init(){
        Input x = new Input("Input",this);
        add(x, 100,100);
        x.setColor(FColor.getRandomColor(FColor.presetColors));

    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
