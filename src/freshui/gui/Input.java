package freshui.gui;

import acm.graphics.GCanvas;
import freshui.graphics.FRect;
import freshui.program.FreshProgram;
import freshui.util.FColor;
import freshui.graphics.FCompound;
import javax.swing.*;
import java.awt.*;

public class Input extends FCompound {

    FreshProgram freshProgramParent;
    FRect shape;
    String label;
    JFormattedTextField inputField;
    Color color;
    StackWalker walker = StackWalker
            .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
    Class<FCompound> callerClass = (Class<FCompound>) walker.getCallerClass();
    GCanvas gc;
    // TODO assign gc to the caller class getGCanvas()

    /**
     * Creates an input using default values, a string input,
     */
    public Input(String s, FreshProgram parent){
        freshProgramParent = parent;
        color = FColor.getRandomColor(FColor.presetColors);
        inputField = new JFormattedTextField(10);
        shape = new FRect(120,40);
        label = s;

        // shape setup
        add(shape);
        shape.setFillColor(color);
        shape.setOutlineVisibility(true);
        shape.setRounded();
        shape.setOutlineThickness(2);
        shape.setOutlineColor(color);

        JLabel inputLabel = new JLabel(label + ":");
        parent.add(inputLabel, shape.getHeight()/2 - inputLabel.getHeight()/2, shape.getWidth()/10);

        // input setup
        parent.add(inputField,shape.getWidth()/2,shape.getHeight()/2 - inputField.getHeight()/2);
    }

    public void setRounded(){
        shape.setRounded();
    }

    public void setSharp(){
        shape.setSharp();
    }
}
