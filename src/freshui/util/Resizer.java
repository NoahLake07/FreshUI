package freshui.util;

import acm.graphics.GObject;
import acm.program.GraphicsProgram;

/**
 * A helpful tool in calculating relative positions and
 * dimensions of a GObject and a GraphicsProgram window.
 */
public class Resizer {

    private static double windowWidth, windowHeight, objWidth, objHeight;
    private static double rWidth, rHeight, rX, rY;

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
    public static double[] getRelativeValues(GraphicsProgram parent, GObject obj){
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

}
