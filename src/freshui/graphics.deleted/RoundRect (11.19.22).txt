package freshui.graphics;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import freshui.interfaces.FreshComponent;
import java.awt.Color;

public abstract class RoundRect implements FreshComponent {

    private RoundRectOutline outline;
    private GOval topLeftCorner, topRightCorner, bottomLeftCorner, bottomRightCorner;
    private GRect vertPortion, horPortion;
    private double cornerRadius, width, height;
    private GraphicsProgram programParent;
    private boolean isAdded = false;
    double baseX, baseY;

    /**
     * Constructs a RoundRect using a width and a height,
     * while the corner radius will be defaulted.
     */
    public RoundRect(double w, double h){
        this(w,h,10,null);
    }

    public RoundRect(double w, double h, double cR){
        this(w,h,cR,null);
    }

    public RoundRect(double w, double h, double cR, GraphicsProgram prPa){
        programParent = prPa;
        width = w;
        height = h;
        cornerRadius = cR;

        // create corners
        topLeftCorner = new GOval(cornerRadius*2,cornerRadius*2);
        topRightCorner = new GOval(cornerRadius*2,cornerRadius*2);
        bottomLeftCorner = new GOval(cornerRadius*2,cornerRadius*2);
        bottomRightCorner = new GOval(cornerRadius*2,cornerRadius*2);

        // create filler rectangles
        vertPortion = new GRect(width - (cornerRadius * 2), height);
        horPortion = new GRect(width, height - (cornerRadius * 2));

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
        outline = new RoundRectOutline(width,height,cornerRadius,programParent);
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
    public Color getOutlineColor(){
        return outline.getColor();
    }

    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

    public boolean isOutlineVisible(){
        return outline.isVisible();
    }

    public int getOutlineThickness(){
        return (int) outline.getThickness();
    }

    public void setBounds(int x, int y, int w, int h){
        setLocation(x,y);
        setSize(w,h);
    }

    public void addToParent(){
        baseX = 0;
        baseY = 0;

        programParent.add(outline,baseX - (outline.getThickness()/2), baseY - (outline.getThickness()/2));

        programParent.add(topLeftCorner,baseX,baseY);
        programParent.add(topRightCorner,baseX+width-(cornerRadius*2),baseY);
        programParent.add(bottomLeftCorner,baseX,baseY+height - (cornerRadius*2));
        programParent.add(bottomRightCorner,baseX+width-(cornerRadius*2),baseY+height-(cornerRadius*2));

        programParent.add(vertPortion,baseX+cornerRadius,baseY);
        programParent.add(horPortion,baseX,baseY+cornerRadius);
    }
}
