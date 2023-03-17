package freshui.gui;

import freshui.graphics.FRect;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;
import jdk.jfr.Percentage;

import java.awt.*;
import java.awt.event.*;

public class Toggle implements freshui.interfaces.Toggle, FreshComponent {

    /* - TODO Complete Implementation of FreshUI Methods
       - TODO Complete the object instantiation and placement of the toggle
     */

    // * Constants
    public final static int DEFAULT_WIDTH = 50;
    public final static int DEFAULT_HEIGHT = 20;
    public final static Color DEFAULT_COLOR_OFF = new Color(183, 183, 183);
    public final static Color DEFAULT_COLOR_ON = new Color(63, 155, 78);
    public final static Color DEFAULT_HANDLE_COLOR = new Color(217, 217, 217);
    public final static double HANDLE_FACTOR_SPACE = 0.7;
    public final static int DEFAULT_SWITCH_CORNER_RADIUS = 8;

    // * UI Components
    private FRect track, handle;

    // * Switch Data
    boolean status;
    boolean enabled = true;

    /** The toggle's preset track color when ON **/
    protected Color colorA = null;
    /** The toggle's preset track color when OFF **/
    protected Color colorB = null;
    protected Color handleColor = null;
    protected boolean doAnimation = false;

    // * FreshUI data
    boolean isAdded = false;
    boolean isVisible = false;
    FreshProgram progPar = null;

    /// region Constructors

    public Toggle(boolean status){
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT,status);
    }

    public Toggle(){
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT,false);
    }

    public Toggle(int w, int h, boolean status){
        this.status = status;
        track = new FRect(w,h);
        handle = new FRect(track.getHeight()*HANDLE_FACTOR_SPACE, track.getHeight()*HANDLE_FACTOR_SPACE);
        handle.setCornerRadius(handle.getWidth()/2);
        track.setCornerRadius(DEFAULT_SWITCH_CORNER_RADIUS);
        handle.setCornerRadius(DEFAULT_SWITCH_CORNER_RADIUS);
        colorA = DEFAULT_COLOR_ON;
        colorB = DEFAULT_COLOR_OFF;
        handleColor = DEFAULT_HANDLE_COLOR;
    }

    public Toggle (int w, int h){
        this(w,h,false);
    }

    /// endregion

    /// region Toggle Specific Methods

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean b) {
        status = b;
    }

    public boolean isEnabled(){
        return enabled;
    }

    public void setEnabled(boolean b){
        enabled = b;
    }

    public boolean getDoAnimation(){
        return doAnimation;
    }

    public void setDoAnimation(boolean b) {
        this.doAnimation = b;
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

    /**
     * Updates the looks (color) of the toggle component. This does not affect positions or sizes.
     */
    private void updateAppearance(){
        if(this.status){
            track.setColor(colorA);
        } else {
            track.setColor(colorB);
        }
        handle.setColor(handleColor);
        updateHandle();
    }

    /**
     * Updates the sizes of the toggle component based on existing inner class data.
     */
    private void updateSize(){
        // update sizes
    }

    private void updateAll(){
        updateSize();
        updateAppearance();
    }

    /**
     * Updates the handle position to match current status of toggle
     */
    private void updateHandle(){
        final double dis = (track.getHeight()-handle.getHeight()) /2; // calculate the distance for the handle

        if(!status){
            progPar.add(handle,
                    this.track.getX()+dis,
                    this.track.getY()+dis);
        } else {
            progPar.add(handle,
                    this.track.getX()+this.track.getWidth()-this.handle.getWidth()-dis,
                    this.track.getY()+dis);
        }
    }

    /// endregion

    /// region FreshComponent Implementations

    @Override
    public void setLocation(double x, double y) {
        track.setLocation(x,y);
        // update locations
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
        progPar.add(track,x,y); // add the track to the exact coordinates
        double dis = (track.getHeight()-handle.getHeight()) /2; // calculate the distance for the handle
        progPar.add(handle,track.getX()+dis,track.getY()+dis); // add the handle based off the calculated offset

        updateAppearance();

        if(progPar.debug) {
            System.out.println("Toggle-{handle} coordinates: ("+handle.getX() + ", " + handle.getY() + ")");
        }

        this.addListeners();
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

    // region ActionListener Implementations

    public void addActionListener(ActionListener al){
        track.addActionListener(al);
    }

    public void addMouseListener(MouseListener ml){
        track.addMouseListener(ml);
    }

    // endregion

    // region Other Implementations
    public String toString(){
        if(status){
            return "true";
        } else {
            return "false";
        }
    }
    // endregion

    /// region Animation Methods

    private void addListeners(){
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicked();
            }
        };
        track.addMouseListener(ml);
    }

    /**
     * The method called on the action of the toggle being clicked.
     */
    private void clicked(){
        if(progPar.debug){ System.out.println("TOGGLE CLICKED");}
        if(enabled){
            if(doAnimation){

            } else {
                if(status){
                    status = false;
                } else {
                    status = true;
                }

                updateAppearance();
                if(progPar.debug){
                    System.out.println("Toggle status is now: [" + status + "]");
                }
            }

        }
    }

    /// endregion
}


