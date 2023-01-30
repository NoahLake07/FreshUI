package freshui.graphics;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPen;
import freshui.interfaces.Colorable;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

import java.awt.*;

import static acm.util.JTFTools.pause;

public class LineAnimation implements Runnable, FreshComponent, Colorable {
    private GLine line;
    private GOval dot;

    private FreshProgram parent = null;
    private boolean isAdded = false;
    public boolean running = true;

    private double baseDotSize;

    public static final int DEFAULT_DOT_DIAMETER = 2;
    public final static Color DEFAULT_LINE_COLOR = new Color(0, 0, 0);

    public double dotSizeChange = 0.1;
    public double frameDelay = 11;
    private boolean doTrail = false;

    public LineAnimation(int x1,int y1, int x2,int y2) {
        // Create line from two points
        line = new GLine(x1, y1, x2, y2);
        dot = new GOval(DEFAULT_DOT_DIAMETER, DEFAULT_DOT_DIAMETER);
        baseDotSize = dot.getWidth();

        dot.setFilled(true);
        line.setColor(DEFAULT_LINE_COLOR);
        dot.setColor(DEFAULT_LINE_COLOR);
    }

    public void run() {
        if(!isAdded){
            parent.add(line);
            parent.add(dot);
        }

        // Create line from two points with any angle
        double x1 = line.getStartPoint().getX();
        double y1 = line.getStartPoint().getY();
        double x2 = line.getEndPoint().getX();
        double y2 = line.getEndPoint().getY();
        double lineLength = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        GPen pen = new GPen(x1,x2);
        int path = 0;

        // Animate dot along line
        while(running) {
            double dx = (x2 - x1) / 100;
            double dy = (y2 - y1) / 100;
            dot.setLocation(x1-dot.getWidth()/2, y1-dot.getHeight()/2);
            dot.setSize(baseDotSize,baseDotSize);
            pen.setLocation(dot.getX() +dot.getWidth()/2, dot.getY()+dot.getHeight()/2);
            for (int i = 0; i < 100; i++) {
                double sizeChange = sizeChange(lineLength,x1,y1,dot.getX(),dot.getY());
                dot.setSize(dot.getWidth() + sizeChange, dot.getHeight() + sizeChange);
                dot.move(dx-(sizeChange/2), dy-(sizeChange/2));
                pause(frameDelay);
            }
        }
    }

    private double sizeChange(double lineLength, double startX, double startY, double dotX, double dotY){
        double distanceFromStart = Math.sqrt((dotX-startX)*(dotX-startX) + (dotY-startY)*(dotY-startY));

        if(lineLength/2 > distanceFromStart){
            // less than half way
            return dotSizeChange;
        } else {
            // more than half way
            return -dotSizeChange;
        }
    }

    /// region Location Modifier Methods

    @Override
    public void setLocation(double x, double y) {
        line.setLocation(x,y);
        dot.setLocation(x,y);
    }

    @Override
    public double getX() {
        return line.getX();
    }

    @Override
    public double getY() {
        return line.getY();
    }

    /// endregion

    /// region Bound Modifiers

    @Override
    public double getWidth() {
        return line.getWidth();
    }

    @Override
    public double getHeight() {
        return line.getHeight();
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

    /// endregion

    /// region Parent Modifier Methods

    @Override
    public boolean isAdded() {
        return isAdded;
    }

    @Override
    public boolean isVisible() {
        return line.isVisible();
    }

    @Override
    public void setVisible(boolean b) {
        line.setVisible(b);
        dot.setVisible(b);
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
    public void addToParent(double x, double y){
        isAdded = true;
        parent.add(dot, line.getStartPoint().getX(), line.getStartPoint().getY());
    }

    /// endregion

    /// region Color Methods

    @Override
    public void setColor(Color c) {
        line.setColor(c);
        dot.setColor(c);
    }

    @Override
    public Color getColor() {
        return line.getColor();
    }

    public Color getDotColor(){
        return dot.getFillColor();
    }

    public void setDotColor(Color c){
        dot.setFilled(true);
        dot.setFillColor(c);
    }

    public void setDotOutline(Color c){
        dot.setColor(c);
    }

    /// endregion

    /// region Line Modifier

    public void setSizeChange(int dsc){
        dotSizeChange = dsc;
    }

    public void setFrameDelay(double ms){
        frameDelay = ms;
    }

    /// endregion

}