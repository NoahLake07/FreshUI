package freshui;

import freshui.graphics.FRect;
import freshui.gui.Input;
import freshui.program.FreshProgram;

import java.awt.*;

public class FreshUI extends FreshProgram {

    public void init(){

        Input i = new Input("InputA:",myCanvas);
        add(i,40,40);


    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
