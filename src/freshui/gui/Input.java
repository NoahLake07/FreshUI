package freshui.gui;

import acm.program.GraphicsProgram;
import freshui.graphics.FRect;
import freshui.interfaces.*;
import freshui.program.FreshProgram;
import freshui.util.FColor;
import javax.swing.*;
import java.awt.*;

public class Input implements InputTraits, Colorable, Roundable, ObjectOutline, FreshComponent {

    // FreshProgram
    FreshProgram freshProgramParent;

    // Input objects
    FRect shape;
    JFormattedTextField inputField;
    JLabel inputLabel;

    // Object attributes
    Color color = new Color(141, 141, 141);

    // Input attributes
    Font labelFont;
    String label;
    boolean isAdded = false;
    boolean isVisible = false;

    /**
     * Constructs an input using a String label, and the FreshProgram parent that the Input belongs to.
     * All input details will be defaulted, and the color will be defaulted to gray.
     */
    public Input(String s, FreshProgram parent){
        freshProgramParent = parent;
        label = s;
        labelFont = new Font("Sans Serif", Font.PLAIN, 10);
        isAdded = false;
        isVisible = false;
        shape = new FRect(100,30,parent);
        inputLabel = new JLabel(s);
        inputLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        inputLabel.setVerticalAlignment(SwingConstants.CENTER);
    }

}
