package freshui.graphics;

import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

import java.awt.*;
import java.util.ArrayList;

public class FPanel implements FreshComponent {

    // FPanel data
    private ArrayList<ObjectData> objects = new ArrayList<>();
    private FreshProgram parent = null;
    private boolean isAdded = false;
    private boolean isVisible = true;

    // location and bound data
    private Point panelLocation = null;
    private double panelWidth = DEFAULT_WIDTH;
    private double panelHeight = DEFAULT_HEIGHT;


    // constants
    public static final int DEFAULT_WIDTH = 40;
    public static final int DEFAULT_HEIGHT = 40;

    /// region Constructors
    public FPanel(){
        // instantiate objects with either null or preset empty lists
        ArrayList<ObjectData> objects = new ArrayList<>();
        FreshProgram parent = null;
    }
    /// endregion

    /// region Location Methods

    public void setLocation(double x, double y){
        panelLocation = new Point(x,y);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).fc.setLocation(panelLocation.x + objects.get(i).x, panelLocation.y + objects.get(i).y);
        }
    }

    public Point getLocation(){
        return panelLocation;
    }

    public double getX(){
        return panelLocation.x;
    }

    public double getY(){
        return panelLocation.y;
    }

    /// endregion

    /// region Dimension Methods

    public double getWidth(){
        return panelWidth;
    }

    public double getHeight(){
        return panelHeight;
    }

    public void setWidth(double w){
        panelWidth = w;
    }

    public void setHeight(double h){
        panelHeight = h;
    }

    public void setBounds(double x, double y, double w, double h){
        setLocation(x,y);
        setWidth(w);
        setHeight(h);
    }

    public void setSize(double w, double h){
        setWidth(w);
        setHeight(h);
    }

    /// endregion

    /// region Visibility Methods

    public void setVisible(boolean b){
        isVisible = b;
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).fc.setVisible(b);
        }
    }

    public boolean isVisible(){
        return isVisible;
    }

    /// endregion

    /// region Parent Interaction Methods

    public void add(FreshComponent fc, int x, int y){
        if(isAdded){
            objects.add(new ObjectData(fc, x, y));
            parent.add(fc, x + panelLocation.x, y + panelLocation.y);
        } else {
            objects.add(new ObjectData(fc, x, y));
        }
    }

    public void addToParent(double x, double y){
        panelLocation = new Point(x,y);
        for (int i = 0; i < objects.size(); i++) {
            parent.add(objects.get(i).fc, objects.get(i).x + panelLocation.x, objects.get(i).y + panelLocation.y);
        }
        isAdded = true;
    }

    public void setProgramParent(FreshProgram fp){
        parent = fp;
    }

    public FreshProgram getProgramParent(){
        return parent;
    }

    public boolean isAdded(){
        return isAdded;
    }

    /// endregion

    /// region Inner Class Data

    private class ObjectData {
        FreshComponent fc = null;
        int x = 0;
        int y = 0;

        public ObjectData(FreshComponent freshComp){
            this(freshComp,0,0);
        }

        public ObjectData(FreshComponent freshComp, int locX, int locY){
            x = locX;
            y = locY;
            fc = freshComp;
        }
    }

    private class Point {
        double x = 0;
        double y = 0;

        public Point(double x0, double y0){
            x = x0;
            y = y0;
        }
    }

    /// endregion

    /// region Shape Mods

    public void addOutline(){
        FRect outline = new FRect(this.panelWidth, this.panelHeight);
        outline.setOutlineVisible(true);
        outline.setOutlineColor(Color.BLACK);
        outline.setColor(new Color(255, 255, 255, 0));
        objects.add(new ObjectData(outline,0,0));
    }

    /// endregion

}