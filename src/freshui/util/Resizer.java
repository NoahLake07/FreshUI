package freshui.util;

import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import acm.program.Program;
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

    /**
     * Creates a new Resizer object linked to the parent window with no FreshComponents added to the list yet.
     */
    public Resizer(FreshProgram parent){
        resizeList = new ArrayList<>();
        programParent = parent;
    }

    public void add(FreshComponent freshComponent){
        resizeList.add(freshComponent);
    }

    public void remove(FreshComponent freshComponent){
        resizeList.remove(freshComponent);
    }

    public int indexOf(FreshComponent freshComponent){
        return resizeList.indexOf(freshComponent);
    }

    public void startResizing(){
        doResize = true;
        Runnable resizeThread = new Runnable(){
            @Override
            public void run() {
                while(doResize) {
                    int i = 0;
                    if (i > resizeList.size()) {
                        i = 0;
                    }

                    resizeObject(resizeList.get(i));
                    i++;
                }
            }
        };
    }

    public void resizeObject(FreshComponent obj){
        double objRelWidth = getRelativeWidth(programParent,obj);
        double objRelHeight = getRelativeHeight(programParent,obj);
        double objRelX = getRelativeX(programParent,obj);
        double objRelY = getRelativeY(programParent,obj);
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

}
