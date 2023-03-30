package freshui.graphics;

import acm.graphics.GObject;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

import javax.swing.*;
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
            objects.get(i).setLocation(panelLocation.x + objects.get(i).x, panelLocation.y + objects.get(i).y);
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
            objects.get(i).setVisible(b);
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

    public void add(JComponent jc, int x, int y){
        if(isAdded){
            objects.add(new ObjectData(jc, x, y));
            parent.add(jc, x + panelLocation.x, y + panelLocation.y);
        } else {
            objects.add(new ObjectData(jc, x, y));
        }
    }

    public void add(GObject go, int x, int y){
        if(isAdded){
            objects.add(new ObjectData(go, x, y));
            parent.add(go, x + panelLocation.x, y + panelLocation.y);
        } else {
            objects.add(new ObjectData(go, x, y));
        }
    }

    public void add(Component co, int x, int y){
        if(isAdded){
            objects.add(new ObjectData(co, x, y));
            parent.add(co, x + panelLocation.x, y + panelLocation.y);
        } else {
            objects.add(new ObjectData(co, x, y));
        }
    }

    public void addToParent(double x, double y){
        panelLocation = new Point(x,y);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).add((int) x, (int) y,parent);
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

    private class ObjectData<C> {

        // region ObjectData Variables

        public final static int FRESH_COMPONENT = 11;
        public final static int JAVA_SWING_COMPONENT = 12;
        public final static int ACM_GRAPHICS_COMPONENT = 13;
        public final static int JAVA_AWT_COMPONENT = 14;

        /**
         * FreshComponent object for the FreshUI Java package
         */
        FreshComponent fc = null;
        /**
         * JComponent for the Java Swing package
         */
        JComponent jc = null;
        /**
         * Component for the Java AWT package
         */
        Component ac = null;
        /**
         * GObject for the ACM Java Library
         */
        GObject gc = null;

        int x = 0;
        int y = 0;
        private int objType = -1;

        // endregion

        // region ObjectData Constructors

        public ObjectData(FreshComponent freshComp){
            this(freshComp,0,0);
        }

        public ObjectData(FreshComponent freshComp, int locX, int locY){
            objType = FRESH_COMPONENT;
            x = locX;
            y = locY;
            fc = freshComp;
        }

        public ObjectData(JComponent jComp, int locX, int locY){
            objType = JAVA_SWING_COMPONENT;
            x = locX;
            y = locY;
            jc = jComp;
        }

        public ObjectData(GObject gObj, int locX, int locY){
            objType = ACM_GRAPHICS_COMPONENT;
            x = locX;
            y = locY;
            gc = gObj;
        }

        public ObjectData(Component comp, int locX, int locY){
            objType = JAVA_AWT_COMPONENT;
            x = locX;
            y = locY;
            ac = comp;
        }

        // endregion

        // region ObjectData Interaction Methods

        public void setVisible(boolean b){
            switch (objType){
                case FRESH_COMPONENT -> {
                    fc.setVisible(b);              }

                case JAVA_SWING_COMPONENT -> {
                    jc.setVisible(b);                    }

                case JAVA_AWT_COMPONENT -> {
                    ac.setVisible(b);                   }

                case ACM_GRAPHICS_COMPONENT -> {
                    gc.setVisible(b);                  }
            }
        }

        public void setLocation(double x, double y){
            switch (objType){
                case FRESH_COMPONENT -> {
                    fc.setLocation(x,y);                }

                case JAVA_SWING_COMPONENT -> {
                    jc.setLocation((int) x, (int) y);                }

                case JAVA_AWT_COMPONENT -> {
                    ac.setLocation((int) x, (int) y);                }

                case ACM_GRAPHICS_COMPONENT -> {
                    gc.setLocation(x,y);                }
            }
        }

        /**
         * Adds the object to a FreshUI program window (FreshProgram)
         * @param sY the specified location for the FPanel
         * @param sY
         */
        public void add(int sX, int sY, FreshProgram parent){

            switch (objType){
                case FRESH_COMPONENT -> {
                    parent.add(fc,sX+x,sY+y);
                }

                case JAVA_SWING_COMPONENT -> {
                    parent.add(jc,sX+x,sY+y);
                }

                case JAVA_AWT_COMPONENT -> {
                    parent.add(ac,sX+x,sY+y);
                }

                case ACM_GRAPHICS_COMPONENT -> {
                    parent.add(gc,sX+x,sY+y);
                }
            }
        }
        // endregion

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