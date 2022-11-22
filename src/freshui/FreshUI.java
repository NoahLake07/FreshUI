package freshui;

import freshui.graphics.FRect;
import freshui.gui.Header;
import freshui.gui.Input;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;
import freshui.util.FColor;
import freshui.util.Resizer;

import javax.swing.*;
import java.awt.*;

public class FreshUI extends FreshProgram {
    /*
    FreshUI - Java Toolkit
    Developed by Noah Lake
    */

    public void init(){
        Header header = new Header(getWidth(),"FreshUI Java Development", SwingConstants.CENTER, this);
        add(header,0,0);

        Input input = new Input("Input",this);
        add(input,30,header.getHeight() + 30);
        input.setColor(new Color(108, 169, 206));

    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
