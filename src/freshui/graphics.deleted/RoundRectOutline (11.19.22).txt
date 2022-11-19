package freshui.graphics;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import freshui.interfaces.Colorable;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

import java.awt.*;

public class RoundRectOutline implements FreshComponent, Colorable {

    private GOval topLeftCorner, topRightCorner, bottomLeftCorner, bottomRightCorner;
    private GRect vertPortion, horPortion;
    private double cornerRadius, width, height, outlineThickness;

    private double offset = 0;
    private GraphicsProgram parent;
    double baseX,baseY;
    boolean isAdded = false;
    boolean isVisible = false;

    /**
     * Constructs a freshui.graphics.RoundRectOutline using a width and a height,
     * while the corner radius and outline thickness will be defaulted.
     * @param w width of the outline
     * @param h height of the outline
     * @param ra corner radius
     * @param gProg The GCompound that this outline belongs to
     */
    public RoundRectOutline(double w, double h, double ra, GraphicsProgram gProg){
        outlineThickness = 2;
        width = w + (outlineThickness*2);
        height = h + (outlineThickness*2);
        cornerRadius = ra;
        parent = gProg;
        offset = 1-outlineThickness;

        // create corners
        topLeftCorner = new GOval(cornerRadius*2,cornerRadius*2);
        topRightCorner = new GOval(cornerRadius*2,cornerRadius*2);
        bottomLeftCorner = new GOval(cornerRadius*2,cornerRadius*2);
        bottomRightCorner = new GOval(cornerRadius*2,cornerRadius*2);

        // create filler rectangles
        vertPortion = new GRect(width - (cornerRadius * 2) + outlineThickness, height);
        horPortion = new GRect(width, height - (cornerRadius * 2) + outlineThickness);

        setFillColor(Color.BLACK);
    }

    public void setCornerRadius(double radius){
        cornerRadius = radius;
        topLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        topRightCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomRightCorner.setSize(cornerRadius*2,cornerRadius*2);

        vertPortion.setSize(width - (cornerRadius * 2), height);
        horPortion.setSize(width, height - (cornerRadius * 2));
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

    public void setSize(double w, double h){
        width = w + (outlineThickness*2);
        height = h + (outlineThickness*2);
        offset = 1-outlineThickness;
        updateBounds();
    }

    public void setThickness(int pixels){
        outlineThickness = pixels;
        updateBounds();
    }

    private void updateBounds(){
        topLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        topRightCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomRightCorner.setSize(cornerRadius*2,cornerRadius*2);
        vertPortion.setSize(width - (cornerRadius * 2) + outlineThickness, height);
        horPortion.setSize(width, height - (cornerRadius * 2) + outlineThickness);

        topLeftCorner.setLocation(baseX+offset,baseY+offset);
        topRightCorner.setLocation(baseX+width - (cornerRadius*2) - (outlineThickness/2),baseY+offset);
        bottomLeftCorner.setLocation(baseX+offset,baseY+height - (cornerRadius*2) - (getThickness()/2));
        bottomRightCorner.setLocation(baseX+width-(cornerRadius*2) - (getThickness()/2),baseY+height-(cornerRadius*2) - (getThickness()/2));
        vertPortion.setLocation(baseX+topLeftCorner.getX() + cornerRadius,baseY+ topLeftCorner.getY());
        horPortion.setLocation(baseX+topLeftCorner.getX(),baseY+topLeftCorner.getY() + cornerRadius);
    }

    public double getThickness(){
        return outlineThickness;
    }

    @Override
    public void setLocation(double x, double y) {
        baseX = x;
        baseY = y;
        updateBounds();
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
    public void setBounds(double x, double y, double w, double h) {
        setWidth(w);
        setHeight(h);
        setLocation(x,y);
    }

    @Override
    public void addToParent() {
        isVisible = true;
        isAdded = true;
        baseX = 0;
        baseY = 0;

        programParent.add(topLeftCorner,baseX,baseY);
        programParent.add(topRightCorner,baseX+width-(cornerRadius*2),baseY);
        programParent.add(bottomLeftCorner,baseX,baseY+height - (cornerRadius*2));
        programParent.add(bottomRightCorner,baseX+width-(cornerRadius*2),baseY+height-(cornerRadius*2));

        programParent.add(vertPortion,baseX+cornerRadius,baseY);
        programParent.add(horPortion,baseX,baseY+cornerRadius);
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
        topLeftCorner.setVisible(b);
        topRightCorner.setVisible(b);
        bottomLeftCorner.setVisible(b);
        bottomRightCorner.setVisible(b);
        vertPortion.setVisible(b);
        horPortion.setVisible(b);
    }

    @Override
    public GraphicsProgram getProgramParent() {
        return programParent;
    }

    @Override
    public void setColor(Color c) {
        topLeftCorner.setFillColor(c);
        topRightCorner.setFillColor(c);
        bottomLeftCorner.setFillColor(c);
        bottomRightCorner.setFillColor(c);
        vertPortion.setFillColor(c);
        horPortion.setFillColor(c);
    }

    @Override
    public Color getColor() {
        return topLeftCorner.getColor();
    }
}
