package freshui.graphics;

import acm.graphics.GOval;
import acm.graphics.GRect;
import freshui.interfaces.Colorable;
import freshui.interfaces.FreshComponent;
import freshui.interfaces.ObjectOutline;
import freshui.interfaces.Roundable;
import freshui.program.FreshProgram;
import java.awt.Color;

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
    int outlineThickness = 1;

    // rectangle individual shapes
    GOval topLeft, topRight, bottomLeft, bottomRight; // corners
    GRect vertical, horizontal; // fillers
    Outline outline = null;

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
        cornerRadius = 0;
        outlineThickness = 2;

        // value defaults
        outlineColor = Color.BLACK;
        fillColor = Color.GRAY;
        outline = new Outline(width,height,cornerRadius,outlineColor,outlineThickness,fpParent);

        // setup of individual shapes
        topLeft = new GOval(cornerRadius*2,cornerRadius*2);
        topRight = new GOval(cornerRadius*2,cornerRadius*2);
        bottomLeft = new GOval(cornerRadius*2,cornerRadius*2);
        bottomRight = new GOval(cornerRadius*2,cornerRadius*2);
        vertical = new GRect(width - (cornerRadius * 2), height);
        horizontal = new GRect(width, height - (cornerRadius * 2));

        // enable color features
        Color transparent = new Color(0,0,0,0);
        topLeft.setFilled(true);
        topRight.setFilled(true);
        bottomRight.setFilled(true);
        bottomLeft.setFilled(true);
        vertical.setFilled(true);
        horizontal.setFilled(true);
        topLeft.setColor(transparent);
        topRight.setColor(transparent);
        bottomLeft.setColor(transparent);
        bottomRight.setColor(transparent);
        vertical.setColor(transparent);
        horizontal.setColor(transparent);
        setColor(fillColor);
        setOutlineColor(outlineColor);
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
        outline.setOutlineThickness(outlineThickness);
        outline.setCornerRadius(cornerRadius);
        outline.setSize(width,height);
        outline.setLocation(baseX-outlineThickness,baseY-outlineThickness);

        // update colors
        setColor(fillColor);
        outline.setColor(outlineColor);
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
        outline.setWidth(w);
        updateBounds();
    }

    @Override
    public void setHeight(double h) {
        height = h;
        outline.setHeight(h);
        updateBounds();
    }

    @Override
    public void setLocation(double x, double y) {
        baseX = x;
        baseY = y;
        outline.setLocation(x-outlineThickness,y-outlineThickness);
        updateBounds();
    }

    @Override
    public void setBounds(double x, double y, double w, double h) {
        setSize(w,h);
        setLocation(x,y);
        outline.setBounds(x,y,w,h);
    }

    @Override
    public void setSize(double w, double h) {
        setWidth(w);
        setHeight(h);
        outline.setSize(w,h);
    }

    @Override
    public void addToParent(double x, double y) {
        isAdded = true;
        baseX = x;
        baseY = y;
        isVisible = true;
        outline.addToParent(x-outlineThickness,y-outlineThickness);
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
        outline.setVisible(b);
    }

    @Override
    public FreshProgram getProgramParent() {
        return parent;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent){
        parent = fpParent;
        outline.setProgramParent(fpParent);
    }

    @Override
    public void setColor(Color c) {
        fillColor = c;
        topLeft.setFillColor(c);
        topRight.setFillColor(c);
        bottomLeft.setFillColor(c);
        bottomRight.setFillColor(c);
        vertical.setFillColor(c);
        horizontal.setFillColor(c);
        outline.setColor(c);
    }

    @Override
    public Color getColor() {
        return fillColor;
    }

    @Override
    public void setOutlineThickness(int pixels) {
        outlineThickness = pixels;
    }

    @Override
    public int getOutlineThickness() {
        return outlineThickness;
    }

    @Override
    public void setOutlineColor(Color c) {
        outline.setColor(c);
    }

    @Override
    public Color getOutlineColor() {
        return outline.getColor();
    }

    @Override
    public void setOutlineVisible(boolean b) {
        outline.setVisible(b);
    }

    @Override
    public boolean isOutlineVisible() {
        return outline.isVisible;
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
        outline.setRounded(b);
        if(!b){
            cornerRadius = 0;
            updateBounds();
        } else {
            if(cornerRadius==0){
                cornerRadius = width/8;
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



    // ============================================================= //



    /**
     * The outline component of a FRect. Entirely managed by FRect, and not to be access or
     * constructed from members outside the FRect class.
     */
     private class Outline implements FreshComponent, Roundable, Colorable {

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
            topLeft = new GOval(cornerRadius*2 +(2*outlineThickness),cornerRadius*2 +(2*outlineThickness));
            topRight = new GOval(cornerRadius*2 +(2*outlineThickness),cornerRadius*2 +(2*outlineThickness));
            bottomLeft = new GOval(cornerRadius*2 +(2*outlineThickness),cornerRadius*2 +(2*outlineThickness));
            bottomRight = new GOval(cornerRadius*2 +(2*outlineThickness),cornerRadius*2 +(2*outlineThickness));
            vertical = new GRect(width - (cornerRadius * 2) +(2*outlineThickness), height +(2*outlineThickness));
            horizontal = new GRect(width +(2*outlineThickness), height - (cornerRadius * 2) +(2*outlineThickness));

            // enable color features
            Color transparent = new Color(0,0,0,0);
            topLeft.setFilled(true);
            topRight.setFilled(true);
            bottomRight.setFilled(true);
            bottomLeft.setFilled(true);
            vertical.setFilled(true);
            horizontal.setFilled(true);
            topLeft.setColor(transparent);
            topRight.setColor(transparent);
            bottomLeft.setColor(transparent);
            bottomRight.setColor(transparent);
            vertical.setColor(transparent);
            horizontal.setColor(transparent);

            setColor(fillColor);
        }

        @Override
        public void setLocation(double x, double y) {
            baseX = x;
            baseY = y;
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
        }

        @Override
        public void setHeight(double h) {
            height = h;
        }

        @Override
        public void setBounds(double x, double y, double w, double h) {
            width = w;
            height = h;
            baseX = x;
            baseY = y;

            updateBounds();
        }

        public void updateBounds(){
            // update sizes of shapes
            topLeft.setSize(cornerRadius*2 +(2*outlineThickness),cornerRadius*2 +(2*outlineThickness));
            topRight.setSize(cornerRadius*2 +(2*outlineThickness),cornerRadius*2 +(2*outlineThickness));
            bottomLeft.setSize(cornerRadius*2 +(2*outlineThickness),cornerRadius*2 +(2*outlineThickness));
            bottomRight.setSize(cornerRadius*2 +(2*outlineThickness),cornerRadius*2 +(2*outlineThickness));
            vertical.setSize(width - (cornerRadius * 2) +(2*outlineThickness), height +(2*outlineThickness));
            horizontal.setSize(width +(2*outlineThickness), height - (cornerRadius * 2) +(2*outlineThickness));

            // update locations of shapes
            topLeft.setLocation(baseX,baseY);
            topRight.setLocation(baseX+width-(cornerRadius*2),baseY);
            bottomLeft.setLocation(baseX,baseY+height - (cornerRadius*2));
            bottomRight.setLocation(baseX+width-(cornerRadius*2),baseY+height-(cornerRadius*2));
            vertical.setLocation(baseX+cornerRadius,baseY);
            horizontal.setLocation(baseX,baseY+cornerRadius);
        }

        @Override
        public void setSize(double w, double h) {
            width = w;
            height = h;
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
        public void setProgramParent(FreshProgram fpParent) {
            parent = fpParent;
        }

        @Override
        public boolean isRounded() {
            return cornerRadius>0;
        }

        @Override
        public boolean isSharp() {
            return cornerRadius == 0;
        }

        @Override
        public void setRounded(boolean b) {
            if(!b){
                cornerRadius = 0;
                updateBounds();
            } else {
                if(cornerRadius==0){
                    cornerRadius = width/8;
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

        @Override
        public void setColor(Color c) {
            outlineColor = c;
            fillColor = c;
            topLeft.setFillColor(c);
            topRight.setFillColor(c);
            bottomLeft.setFillColor(c);
            bottomRight.setFillColor(c);
            vertical.setFillColor(c);
            horizontal.setFillColor(c);
        }

        @Override
        public Color getColor() {
            return outlineColor;
        }

        public void setOutlineThickness(int oT){
            outlineThickness = oT;
        }
    }
}