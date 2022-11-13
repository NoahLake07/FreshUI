package freshui;

import freshui.graphics.FRect;
import freshui.gui.Input;
import freshui.program.FreshProgram;
import freshui.util.FColor;

public class FreshUI extends FreshProgram {

    public void init(){
        Input x = new Input("Input",this);
        x.setColor(FColor.getRandomColor(FColor.presetColors));
        x.addToParent();
        x.setLocation(100,100);
        x.setOutlineVisible(true);
        x.setOutlineThickness(1);

    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
