package freshui.gui;

import acm.graphics.GCanvas;
import freshui.util.FColor;
import freshui.graphics.FCompound;
import freshui.graphics.FRect;

import javax.swing.*;
import java.awt.*;

public class Input extends FCompound {

    FRect shape;
    String label;
    JFormattedTextField input;
    Color color;
    StackWalker walker = StackWalker
            .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
    Class<?> callerClass = walker.getCallerClass();
    GCanvas gc;
    // TODO assign gc to the caller class getGCanvas()

    /**
     * Creates an input using default values and a single string input
     */
    public Input(String s){
        color = FColor.getRandomColor();
        input = new JFormattedTextField(10);
        shape = new FRect(120,40);
        label = s;

        // find the parent


        // shape setup
        shape.setFillColor(color);
        shape.setOutlineColor(color.darker());
        shape.setOutlineVisible(true);
        shape.setOutlineThickness(2);
        add(shape);

        // input setup
        add(input,shape.getWidth()/2,shape.getHeight()/2 - input.getHeight()/2,gc);

    }

    public void setRounded(){
        shape.setRounded();
    }

    public void setSharp(){
        shape.setSharp();
    }
}
