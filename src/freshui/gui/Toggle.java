package freshui.gui;

import freshui.graphics.FRect;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

import java.awt.*;

public class Toggle implements freshui.interfaces.Toggle, FreshComponent {

    /* - TODO Complete Implementation of FreshUI Methods
       - TODO Complete the object instantiation and placement of the toggle
     */


    // constants
    public final static int DEFAULT_WIDTH = 60;
    public final static int DEFAULT_HEIGHT = 20;
    public final static Color DEFAULT_COLOR_OFF = new Color(175, 175, 175);
    public final static Color DEFAULT_COLOR_ON = new Color(103, 204, 119);

    // UI Components
    private FRect outline = new FRect(DEFAULT_WIDTH,DEFAULT_HEIGHT);

    // Switch Data
    boolean status;
    Color colorA, colorB;

    // FreshUI data
    boolean isAdded = false;
    boolean isVisible = false;
    FreshProgram progPar = null;

    public Toggle(boolean s){
        status = s;
        colorA = DEFAULT_COLOR_OFF;
        colorB = DEFAULT_COLOR_ON;
    }

    public Toggle(){
        this(false);
    }

    /// region Toggle Interface Methods

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean b) {
        status = b;
    }

    /// endregion

    /// region Color Mutator Methods

    public void setColorA(Color c){
        colorA = c;
    }

    public void setColorB(Color c){
        colorB = c;
    }

    public Color getColorA(){
        return colorA;
    }

    public Color getColorB(){
        return colorB;
    }

    /// endregion

    /// region FreshComponent Interface Methods

    @Override
    public void setLocation(double x, double y) {

    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public void setWidth(double w) {

    }

    @Override
    public void setHeight(double h) {

    }

    @Override
    public void setBounds(double x, double y, double w, double h) {

    }

    @Override
    public void setSize(double w, double h) {

    }

    @Override
    public void addToParent(double x, double y) {
        isAdded = true;
        isVisible = true;

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
        // change visibility of all components
    }

    @Override
    public FreshProgram getProgramParent() {
        return progPar;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent) {
        progPar = fpParent;
    }

    /// endregion
}


