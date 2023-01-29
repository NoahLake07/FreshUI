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
    public final static Color DEFAULT_COLOR_OFF = new Color(183, 183, 183);
    public final static Color DEFAULT_COLOR_ON = new Color(63, 155, 78);
    public final static double HANDLE_FACTOR_SPACE = 0.9;

    // UI Components
    private FRect track = new FRect(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    private FRect handle = new FRect(track.getHeight()*HANDLE_FACTOR_SPACE, track.getHeight()*HANDLE_FACTOR_SPACE);

    // Switch Data
    boolean status;
    protected Color colorA, colorB, handleColor;

    // FreshUI data
    boolean isAdded = false;
    boolean isVisible = false;
    FreshProgram progPar = null;

    /// region Constructors

    public Toggle(boolean s){
        status = s;
        colorA = DEFAULT_COLOR_OFF;
        colorB = DEFAULT_COLOR_ON;
    }

    public Toggle(){
        this(false);
    }

    public Toggle (int w, int h){
        track = new FRect(w,h);
        handle = new FRect(track.getHeight()*HANDLE_FACTOR_SPACE, track.getHeight()*HANDLE_FACTOR_SPACE);
        handle.setCornerRadius(handle.getWidth()/2);

    }

    /// endregion

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

    /**
     * Sets the color of the toggle's handle
     * @param c
     */
    public void setHandleColor(Color c){
        handleColor = c;
    }

    /**
     * @return the toggle's handle color
     */
    public Color getHandleColor(){
        return handleColor;
    }

    /**
     * Sets color-A to a new color (the toggle's track color when on)
     * @param c
     */
    public void setColorA(Color c){
        colorA = c;
    }

    /**
     * Sets color-B to a new color (the toggle's track color when off)
     * @param c
     */
    public void setColorB(Color c){
        colorB = c;
    }

    /**
     * @return color-A (the toggle's track color when on)
     */
    public Color getColorA(){
        return colorA;
    }

    /**
     * @return color-B (the toggle's track color when off)
     */
    public Color getColorB(){
        return colorB;
    }

    /// endregion

    /// region Component Updater Methods

    private void updateAppearance(){
        if(this.status){
            track.setColor(colorA);
        } else {
            track.setColor(colorB);
        }
        handle.setColor(colorB);
    }

    private void updateSize(){

    }

    private void updateAll(){
        updateSize();
        updateAppearance();
    }

    /// endregion

    /// region FreshComponent Interface Methods

    @Override
    public void setLocation(double x, double y) {
        track.setLocation(x,y);
        // set handle location
    }

    @Override
    public double getX() {
        return track.getX();
    }

    @Override
    public double getY() {
        return track.getY();
    }

    @Override
    public double getWidth() {
        return track.getWidth();
    }

    @Override
    public double getHeight() {
        return track.getHeight();
    }

    @Override
    public void setWidth(double w) {
        track.setWidth(w);
    }

    @Override
    public void setHeight(double h) {
        track.setHeight(h);
    }

    @Override
    public void setBounds(double x, double y, double w, double h) {
        track.setLocation(x,y);
        // update handle
        track.setSize(w,h);
    }

    @Override
    public void setSize(double w, double h) {
        track.setSize(w,h);
    }

    @Override
    public void addToParent(double x, double y) {
        isAdded = true;
        isVisible = true;
        // add to parent
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
        handle.setVisible(b);
        track.setVisible(true);
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


