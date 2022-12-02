package freshui.gui.input;

import acm.program.GraphicsProgram;
import freshui.Constants;
import freshui.graphics.FRect;
import freshui.interfaces.*;
import freshui.program.FreshProgram;
import freshui.util.FColor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Input implements Colorable, Roundable, ObjectOutline, FreshComponent, ActionAware {

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
    boolean isAdded, isVisible;

    // Mouse Actions
    public Runnable mouseClicked, mousePressed, mouseReleased, mouseEntered, mouseExited, mouseWheelMoved, mouseDragged, mouseMoved;
    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            mouseClicked.run();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed.run();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mouseReleased.run();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mouseEntered.run();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            mouseExited.run();
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            mouseWheelMoved.run();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseDragged.run();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mouseMoved.run();
        }
    };

    // Key Actions
    public Runnable enterKeyPressed;
    private KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    };


    /**
     * Constructs an input using a String label, and the FreshProgram parent that the Input belongs to.
     * All input details will be defaulted, and the color will be defaulted to gray.
     */
    public Input(String s, FreshProgram parent){
        freshProgramParent = parent;
        label = s;
        isAdded = false;
        isVisible = false;

        // instantiating objects
        labelFont = new Font("Century Gothic", Font.PLAIN, 13);
        shape = new FRect(124, 32, parent);
        inputLabel = new JLabel(s);
        inputLabel.setFont(labelFont);
        inputField = new JFormattedTextField();

        // aligning label(s) and field(s)
        inputLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setHorizontalAlignment(SwingConstants.LEFT);

        // colors
        shape.setColor(color);
        shape.setOutlineVisible(true);
        shape.setOutlineColor(FColor.darker(color,0.8));
    }

    /**
     * Constructs an input using a String to be used as the input text, while
     * everything else will be defaulted. Program parent is null.
     */
    public Input(String label){
        this(label, null);
    }

    public void updateBounds(){
        // aligning label(s) and field(s)
        inputLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        inputLabel.setVerticalAlignment(SwingConstants.CENTER);

        // updating object locations and sizes
        int labelX, labelY, fieldX, fieldY;
        inputLabel.setSize((int) ((int) shape.getWidth() * .45),inputLabel.getHeight());
        inputField.setSize((int) (shape.getWidth() * .36), (int) ((int) shape.getHeight() * 0.6));
        fieldX = (int) (shape.getX() + shape.getWidth()/2);
        fieldY = (int) (shape.getY() + shape.getHeight()/2 - inputField.getHeight()/2);
        labelX = (int) ((int) shape.getX());
        labelY = (int) ((int) shape.getY() + shape.getHeight()/2 - inputLabel.getHeight()/2);
        inputField.setLocation(fieldX,fieldY);
        inputLabel.setLocation(labelX, labelY);

        // update label fonts
        inputLabel.setFont(labelFont);
    }

    @Override
    public void setColor(Color c) {
        shape.setColor(c);
        shape.setOutlineColor(FColor.darker(c,0.8));
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setLocation(double x, double y) {
        shape.setLocation(x,y);
        updateBounds();
    }

    @Override
    public double getX() {
        return shape.getX();
    }

    @Override
    public double getY() {
        return shape.getY();
    }

    @Override
    public double getWidth() {
        return shape.getY();
    }

    @Override
    public double getHeight() {
        return shape.getHeight();
    }

    @Override
    public void setWidth(double w) {
        shape.setWidth(w);
        updateBounds();
    }

    @Override
    public void setHeight(double h) {
        shape.setHeight(h);
        updateBounds();
    }

    @Override
    public void setBounds(double x, double y, double w, double h) {
        shape.setBounds(x,y,w,h);
        updateBounds();
    }

    @Override
    public void setSize(double w, double h) {
        shape.setSize(w,h);
        updateBounds();
    }

    @Override
    public void addToParent(double x, double y) {
        isAdded = true;
        shape.addToParent(x,y);
        freshProgramParent.add(inputField,0,0);
        freshProgramParent.add(inputLabel, 0,0);
        updateBounds();
    }

    @Override
    public boolean isAdded() {
        return isAdded;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean b) {
        isVisible = b;
    }

    @Override
    public FreshProgram getProgramParent() {
        return freshProgramParent;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent) {
        freshProgramParent = fpParent;
    }

    @Override
    public void setOutlineThickness(int pixels) {
        shape.setOutlineThickness(pixels);
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

    @Override
    public void setOutlineVisible(boolean b) {
        shape.setOutlineVisible(b);
    }

    @Override
    public boolean isOutlineVisible() {
        return shape.isOutlineVisible();
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
        shape.setRounded(b);
    }

    @Override
    public void setCornerRadius(double radius) {
        shape.setCornerRadius(radius);
    }

    @Override
    public double getCornerRadius() {
        return shape.getCornerRadius();
    }

    @Override
    public void setupMouse() {
        // instantiate all mouse runnable actions
        mouseClicked = Constants.emptyRunnable;
        mousePressed = Constants.emptyRunnable;
        mouseReleased = Constants.emptyRunnable;
        mouseEntered = Constants.emptyRunnable;
        mouseExited = Constants.emptyRunnable;
        mouseWheelMoved = Constants.emptyRunnable;
        mouseDragged = Constants.emptyRunnable;
        mouseMoved  = Constants.emptyRunnable;
    }

    @Override
    public void setupKeys() {
        enterKeyPressed = Constants.emptyRunnable;
    }

    @Override
    public void startListening() {
        inputField.addMouseListener(mouseAdapter);
        inputField.addKeyListener(keyAdapter);
    }
}
