package freshui.graphics;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import freshui.interfaces.Colorable;
import freshui.interfaces.FreshComponent;
import freshui.interfaces.ObjectOutline;
import freshui.interfaces.Roundable;
import freshui.program.FreshProgram;

import java.awt.*;

/**
 * A Basic Rectangle Object that contains intuitive features.
 */
public class FRect implements FreshComponent, Colorable, Roundable, ObjectOutline {

    // rectangle parent properties
    FreshProgram parent;

    // rectangle bound variables
    double baseX, baseY, width, height, cornerRadius;
    boolean isAdded, isVisible;
    Color outlineColor, fillColor;

    // rectangle individual shapes
    GOval topLeft, topRight, bottomLeft, bottomRight; // corners
    GRect vertical, horizontal; // fillers

    /**
     * Constructs a new FRect using a width, height, and FreshProgram parent.
     * @param w
     * @param h
     * @param fpParent FreshProgram parent that this objects belongs to
     */
    public FRect(double w, double h, FreshProgram fpParent){
        width = w;
        height = h;
        parent = fpParent;

        // setup of individual shapes
        topLeft = new GOval(cornerRadius*2,cornerRadius*2);
        topRight = new GOval(cornerRadius*2,cornerRadius*2);
        bottomLeft = new GOval(cornerRadius*2,cornerRadius*2);
        bottomRight = new GOval(cornerRadius*2,cornerRadius*2);
        vertical = new GRect(width - (cornerRadius * 2), height);
        horizontal = new GRect(width, height - (cornerRadius * 2));
    }

    /**
     * Constructs a new FRect using a width and height. The FreshProgram Parent is set to null.
     * @param w
     * @param h
     */
    public FRect(double w, double h){
        this(w,h,null);
    }

    private void updateBounds(){
        // update sizes of shapes
        topLeft.setSize(cornerRadius*2,cornerRadius*2);
        topRight.setSize(cornerRadius*2,cornerRadius*2);
        bottomLeft.setSize(cornerRadius*2,cornerRadius*2);
        bottomRight.setSize(cornerRadius*2,cornerRadius*2);
        vertical.setSize(width - (cornerRadius * 2), height);
        horizontal.setSize(width, height - (cornerRadius * 2));

        // update locations of shapes
        topLeft.setLocation(baseX,baseY);
        topRight.setLocation(baseX+width-(cornerRadius*2),baseY);
        bottomLeft.setLocation(baseX,baseY+height - (cornerRadius*2));
        bottomRight.setLocation(baseX+width-(cornerRadius*2),baseY+height-(cornerRadius*2));
        vertical.setLocation(baseX+cornerRadius,baseY);
        horizontal.setLocation(baseX,baseY+cornerRadius);

        // update the outline:
        // outline.setCornerRadius(cornerRadius);
        //outline.setSize(width,height);
    }

    @Override
    public double getX() {
        return baseX;
    }

    @Override
    public double getY() {
        return baseY;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void setWidth(double w) {
        width = w;
        updateBounds();
    }

    @Override
    public void setHeight(double h) {
        height = h;
        updateBounds();
    }

    @Override
    public void setLocation(double x, double y) {
        baseX = x;
        baseY = y;
        updateBounds();
    }

    @Override
    public void setBounds(double x, double y, double w, double h) {
        setSize(w,h);
        setLocation(x,y);
    }

    @Override
    public void setSize(double w, double h) {
        setWidth(w);
        setHeight(h);
    }

    @Override
    public void addToParent(double x, double y) {
        isAdded = true;
        baseX = x;
        baseY = y;
        isVisible = true;
        parent.add(topLeft, baseX, baseY);
        parent.add(topRight,baseX+width-(cornerRadius*2),baseY);
        parent.add(bottomLeft, baseX,baseY+height - (cornerRadius*2));
        parent.add(bottomRight,baseX+width-(cornerRadius*2),baseY+height-(cornerRadius*2));
        parent.add(vertical, baseX+cornerRadius,baseY);
        parent.add(horizontal, baseX,baseY+cornerRadius);
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

        topLeft.setVisible(b);
        topRight.setVisible(b);
        bottomLeft.setVisible(b);
        bottomRight.setVisible(b);
        vertical.setVisible(b);
        horizontal.setVisible(b);
    }

    @Override
    public FreshProgram getProgramParent() {
        return parent;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent){
        parent = fpParent;
    }

    @Override
    public void setColor(Color c) {
        fillColor = c;
    }

    @Override
    public Color getColor() {
        return fillColor;
    }

    @Override
    public void setOutlineThickness(int pixels) {

    }

    @Override
    public int getOutlineThickness() {
        return 0;
    }

    @Override
    public void setOutlineColor(Color c) {

    }

    @Override
    public Color getOutlineColor() {
        return null;
    }

    @Override
    public void setOutlineVisible(boolean b) {

    }

    @Override
    public boolean isOutlineVisible() {
        return false;
    }

    @Override
    public boolean isRounded() {
        return cornerRadius>0;
    }

    @Override
    public boolean isSharp() {
        return cornerRadius==0;
    }

    @Override
    public void setRounded(boolean b) {
        if(!b){
            cornerRadius = 0;
            updateBounds();
        } else {
            if(cornerRadius==0){
                cornerRadius = 10;
                updateBounds();
            }
        }
    }

    @Override
    public void setCornerRadius(double radius) {
        cornerRadius = radius;
        updateBounds();
    }

    @Override
    public double getCornerRadius() {
        return cornerRadius;
    }

    /**
     * The outline component of a FRect. Entirely managed by FRect, as all inside variables are public.
     */
     private class Outline {

        // rectangle parent properties
        FreshProgram parent;

        // rectangle bound variables
        public double baseX, baseY, width, height, cornerRadius;
        public int outlineThickness = 1;
        public boolean isAdded, isVisible;
        public Color fillColor;

        // rectangle individual shapes
        public GOval topLeft, topRight, bottomLeft, bottomRight; // corners
        public GRect vertical, horizontal; // fillers

        public Outline(double w, double h, double cR, Color assignedColor, int oT, FreshProgram freshParent){
            outlineThickness = oT;
            width = w;
            height = h;
            cornerRadius = cR;
            parent = freshParent;
            fillColor = assignedColor;
            isAdded = false;
            isVisible = false;

            // setup of individual shapes
            topLeft = new GOval(cornerRadius*2+outlineThickness,cornerRadius*2+outlineThickness);
            topRight = new GOval(cornerRadius*2+outlineThickness,cornerRadius*2+outlineThickness);
            bottomLeft = new GOval(cornerRadius*2+outlineThickness,cornerRadius*2+outlineThickness);
            bottomRight = new GOval(cornerRadius*2+outlineThickness,cornerRadius*2+outlineThickness);
            vertical = new GRect(width - (cornerRadius * 2)+outlineThickness, height+outlineThickness);
            horizontal = new GRect(width+outlineThickness, height - (cornerRadius * 2)+outlineThickness);
        }

    }
}