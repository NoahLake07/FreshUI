package freshui.graphics;

import acm.graphics.GOval;
import acm.graphics.GRect;
import java.awt.Color;

public abstract class RoundRect extends FCompound {

    private RoundRectOutline outline;
    private GOval topLeftCorner, topRightCorner, bottomLeftCorner, bottomRightCorner;
    private GRect vertPortion, horPortion;
    private double cornerRadius, width, height;

    /**
     * Constructs a freshui.graphics.RoundRect using a width and a height,
     * while the corner radius will be defaulted.
     */
    public RoundRect(double w, double h){
        width = w;
        height = h;
        cornerRadius = 10;

        // create corners
        topLeftCorner = new GOval(cornerRadius*2,cornerRadius*2);
        topRightCorner = new GOval(cornerRadius*2,cornerRadius*2);
        bottomLeftCorner = new GOval(cornerRadius*2,cornerRadius*2);
        bottomRightCorner = new GOval(cornerRadius*2,cornerRadius*2);

        // create filler rectangles
        vertPortion = new GRect(width - (cornerRadius * 2), height);
        horPortion = new GRect(width, height - (cornerRadius * 2));

        // add objects to the compound
        add(topLeftCorner,0,0);
        add(topRightCorner,width-(cornerRadius*2),0);
        add(bottomLeftCorner,0,height - (cornerRadius*2));
        add(bottomRightCorner,width-(cornerRadius*2),height-(cornerRadius*2));

        add(vertPortion,cornerRadius,0);
        add(horPortion,0,cornerRadius);

        createOutline();
        outline.setVisible(false);
        setFillColor(Color.GRAY);
    }

    public void setCornerRadius(double radius){
        cornerRadius = radius;
        updateBounds();
    }

    public double getCornerRadius(){
        return cornerRadius;
    }

    public void setFillColor(Color color){
        topLeftCorner.setFilled(true);
        topRightCorner.setFilled(true);
        bottomRightCorner.setFilled(true);
        bottomLeftCorner.setFilled(true);
        horPortion.setFilled(true);
        vertPortion.setFilled(true);

        topLeftCorner.setFillColor(color);
        topRightCorner.setFillColor(color);
        bottomLeftCorner.setFillColor(color);
        bottomRightCorner.setFillColor(color);
        topLeftCorner.setColor(color);
        topRightCorner.setColor(color);
        bottomLeftCorner.setColor(color);
        bottomRightCorner.setColor(color);
        vertPortion.setFillColor(color);
        horPortion.setFillColor(color);
        vertPortion.setColor(color);
        horPortion.setColor(color);
    }

    public void setOutlineVisibility(boolean status){
        outline.setVisible(status);
    }

    private void createOutline(){
        outline = new RoundRectOutline(width,height,cornerRadius,this);
        add(outline,0 - (outline.getThickness()/2),- (outline.getThickness()/2));
        outline.sendToBack();
    }

    public void setOutlineThickness(int pixels){
        outline.setThickness(pixels);
        updateBounds();
    }

    public void setSize(double w, double h){
        width = w;
        height = h;
        updateBounds();
    }

    private void updateBounds(){
        // update sizes of shapes
        topLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        topRightCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomRightCorner.setSize(cornerRadius*2,cornerRadius*2);
        vertPortion.setSize(width - (cornerRadius * 2), height);
        horPortion.setSize(width, height - (cornerRadius * 2));

        // update locations of shapes
        topLeftCorner.setLocation(0,0);
        topRightCorner.setLocation(width-(cornerRadius*2),0);
        bottomLeftCorner.setLocation(0,height - (cornerRadius*2));
        bottomRightCorner.setLocation(width-(cornerRadius*2),height-(cornerRadius*2));
        vertPortion.setLocation(cornerRadius,0);
        horPortion.setLocation(0,cornerRadius);

        // update the outline
        outline.setCornerRadius(cornerRadius);
        outline.setSize(width,height);
    }

    public void setOutlineColor(Color c){
        outline.setFillColor(c);
    }

    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

    public void setRounded(){

    }
}
