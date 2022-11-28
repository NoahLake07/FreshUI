package freshui;

import freshui.graphics.FRect;
import freshui.gui.Header;
import freshui.gui.Input;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;
import freshui.util.FColor;
import freshui.util.Resizer;
import freshui.util.SystemInfo;

import javax.swing.*;
import java.awt.*;

public class FreshUI extends FreshProgram {
    /*
    FreshUI - Java Toolkit
    Developed by Noah Lake
    */

    public void init(){
        // temp code
        Input input = new Input("Input:",this);
        add(input,70,30);
        input.setColor(new Color(108, 169, 206));

        input.enterKeyPressed = () -> System.out.println("ENTER KEY PRESSED");

    }

    private void testMethod(){
        // temp code
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
