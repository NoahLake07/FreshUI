package freshui.util;

import acm.program.GraphicsProgram;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;
import java.util.ArrayList;

/**
 * A collection of static and non-static tools to help quickly resize objects
 */
public class Resizer {

    private static double windowWidth, windowHeight, objWidth, objHeight;
    private static double rWidth, rHeight, rX, rY;
    private boolean doResize = false;
    private FreshProgram programParent;

    private ArrayList<FreshComponent> resizeList;
    private ArrayList<LockedValues> objectOriginalValues;

    /**
     * Creates a new Resizer object linked to the parent window with no FreshComponents added to the list yet.
     */
    public Resizer(FreshProgram parent){
        resizeList = new ArrayList<>();
        objectOriginalValues = new ArrayList<>();
        programParent = parent;
    }

    public void add(FreshComponent freshComponent){
        double rX,rY,rW,rH;
        rX = getRelativeX(programParent, freshComponent);
        rY = getRelativeY(programParent, freshComponent);
        rW = getRelativeWidth(programParent, freshComponent);
        rH = getRelativeHeight(programParent, freshComponent);

        LockedValues lV = new LockedValues(rX,rY,rW,rH);

        resizeList.add(freshComponent);
        objectOriginalValues.add(lV);
    }

    public void remove(FreshComponent freshComponent){
        resizeList.remove(freshComponent);
        objectOriginalValues.remove(indexOf(freshComponent));
    }

    public int indexOf(FreshComponent freshComponent){
        return resizeList.indexOf(freshComponent);
    }

    public void startResizing(){
        doResize = true;
        Runnable resizeThread = () -> {
            while(doResize) {
                int i = 0;
                if (i > resizeList.size()-1) {
                    i = 0;
                }

                resizeObject(resizeList.get(i));
                i++;
            }
        };
        resizeThread.run();
    }

    public void resizeObject(FreshComponent obj){
        LockedValues objOriginals = objectOriginalValues.get(indexOf(obj));
        double newX, newY, newW, newH;

        newX = programParent.getWidth() * objOriginals.getRelX();
        newY = programParent.getHeight() * objOriginals.getRelY();
        newW = programParent.getWidth() * objOriginals.getRelW();
        newH = programParent.getHeight() * objOriginals.getRelH();

        obj.setLocation(newX,newY);
        obj.setWidth(newW);
        obj.setHeight(newH);
    }

    /**
     *
     * @param parent The GraphicsProgram parent to be compared to
     * @param obj The GObject to be compared with the parent
     * @return a double[] containing the relative values in the following order:
     *         0- the relative width,
     *         1- the relative height,
     *         2- the relative x position,
     *         3- the relative y position
     *
     */
    public static double[] getRelativeValues(GraphicsProgram parent, FreshComponent obj){
        windowWidth = parent.getWidth();
        windowHeight = parent.getHeight();
        objWidth = obj.getWidth();
        objHeight = obj.getHeight();

        rWidth = objWidth / windowWidth;
        rHeight = objHeight / windowHeight;
        rX = windowWidth;

        return new double[]{
                rWidth,
                rHeight
        };
    }

    public double getRelativeWidth(GraphicsProgram parent, FreshComponent obj){
        return obj.getWidth() / parent.getWidth();
    }

    public double getRelativeHeight(GraphicsProgram parent, FreshComponent obj){
        return obj.getHeight() / parent.getHeight();
    }

    public double getRelativeX(GraphicsProgram parent, FreshComponent obj){
        return obj.getX() / parent.getWidth();
    }

    public double getRelativeY(GraphicsProgram parent, FreshComponent obj){
        return obj.getY() / parent.getHeight();
    }

    /**
     * Used for storing object data upon locking it
     */
    public class LockedValues {

        double relX,relY,relW,relH;

        public LockedValues(double rX,double rY,double rW, double rH){
            relX = rX;
            relY = rY;
            relW = rW;
            relH = rH;
        }

        public double getRelH() {
            return relH;
        }

        public double getRelW() {
            return relW;
        }

        public double getRelX() {
            return relX;
        }

        public double getRelY() {
            return relY;
        }
    }

}
