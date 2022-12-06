package freshui;

import freshui.graphics.FButton;
import freshui.graphics.FRect;
import freshui.gui.input.Input;
import freshui.program.FreshProgram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FreshUI extends FreshProgram {
    /*
    FreshUI - Java Toolkit
    Developed by Noah Lake
    */

    public void init(){

    }

    public void actionPerformed(ActionEvent ae){
        switch (ae.getActionCommand()){
            case "Hello":
                System.out.println("Button hit");
                break;
        }
    }

    private void testMethod(){
        // temp code
    }

    public static void main(String[] args) {
        new FreshUI().start();
    }

}
