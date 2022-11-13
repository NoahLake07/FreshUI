package freshui.gui;

import freshui.graphics.FRect;
import freshui.interfaces.*;
import freshui.program.FreshProgram;
import freshui.util.FColor;
import javax.swing.*;
import java.awt.Color;

public class Input implements InputTraits, Colorable, Roundable, ObjectOutline, FreshComponent {

    FreshProgram freshProgramParent;
    FRect shape;
    String label;
    JLabel inputLabel;
    JFormattedTextField inputField;
    Color color;
    boolean isAdded = false;
    boolean isVisible = false;

    /**
     * Constructs an input using a String label, and the FreshProgram parent that the Input belongs to.
     * All input details will be defaulted, and the color will be randomized.
     */
    public Input(String s, FreshProgram parent){
        freshProgramParent = parent;
        color = FColor.getRandomColor(FColor.presetColors);
        inputField = new JFormattedTextField();
        inputField.setSize(40,inputField.getHeight());
        shape = new FRect(120,40);
        label = s;

        // shape setup
        shape.setFillColor(color);
        shape.setOutlineVisibility(true);
        shape.setRounded();
        shape.setOutlineThickness(2);
        shape.setOutlineColor(color);
    }

    public void setOutlineThickness(int i) {
        shape.setOutlineThickness(i);
    }

    @Override
    public int getOutlineThickness() {
        return shape.getOutlineThickness();
    }

    @Override
    public void setOutlineColor(Color c) {
        shape.setOutlineColor(c);
    }

    @Override
    public Color getOutlineColor() {
        return shape.getOutlineColor();
    }

    public void setOutlineVisible(boolean b) {
        shape.setOutlineVisibility(b);
    }

    @Override
    public boolean isOutlineVisible() {
        return shape.isOutlineVisible();
    }

    @Override
    public void setColor(Color c) {
        shape.setFillColor(c);

        Color outlineC = FColor.darker(c,0.8);
        shape.setOutlineColor(outlineC);
    }

    @Override
    public Color getColor() {
        return shape.getColor();
    }

    @Override
    public void setLocation(double x, double y) {

        if(isAdded){
            shape.setLocation(x,y);
            inputField.setLocation((int) (x + 2*(shape.getWidth()/3)), (int) (y + shape.getHeight()/2 - inputField.getHeight()/2));
            inputLabel.setLocation((int) (x+shape.getWidth()/5), (int) (y+shape.getHeight()/2 - inputLabel.getHeight()/2));
        } else {
            try {
                throw new Exception("You cannot invoke FreshComponent that is not yet added to a FreshProgram parent");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public double getX() {
        return this.getX();
    }

    @Override
    public double getY() {
        return this.getY();
    }

    @Override
    public void addToParent() {
        freshProgramParent.add(shape);

        // label setup
        inputLabel = new JLabel(label);
        freshProgramParent.add(inputLabel,0,0);

        // input setup
        freshProgramParent.add(inputField,0,0);

        isAdded = true;
        isVisible = true;
        setLocation(0,0);
    }

    @Override
    public boolean isAdded() {
        return isAdded;
    }

    @Override
    public boolean isVisible() {
        return isVisible();
    }

    @Override
    public void setVisible(boolean b) {
        shape.setVisible(b);
        inputLabel.setVisible(b);
        inputField.setVisible(b);
        isVisible = b;
    }

    @Override
    public void setLabel(String s) {
        label = s;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getInputText() {
        return inputField.getText();
    }

    @Override
    public void setInputText(String s) {
        inputLabel.setText(s);
    }

    @Override
    public Color getLabelColor() {
        return inputLabel.getForeground();
    }

    @Override
    public void setLabelColor(Color c) {
        inputLabel.setForeground(c);
    }

    @Override
    public boolean isRounded() {
        return shape.isRounded();
    }

    @Override
    public boolean isSharp() {
        return shape.isSharp();
    }

    @Override
    public void setRounded(boolean b) {

        if(b) {
            if (shape.isSharp() == true) {
                shape.setRounded();
                shape.setCornerRadius(10);
            }
        } else {
            shape.setSharp();
        }
    }

    @Override
    public void setCornerRadius(double radius) {
        shape.setCornerRadius(radius);
    }

    @Override
    public double getCornerRadius() {
        return shape.getCornerRadius();
    }
}
