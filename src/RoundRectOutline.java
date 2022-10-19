import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;

public class RoundRectOutline extends GCompound {

    private GOval topLeftCorner, topRightCorner, bottomLeftCorner, bottomRightCorner;
    private GRect vertPortion, horPortion;
    private int cornerRadius, width, height, outlineThickness;
    private int base;
    private GCompound parent;

    /**
     * Constructs a RoundRectOutline using a width and a height,
     * while the corner radius will be defaulted.
     */
    public RoundRectOutline(int w, int h, int ra, GCompound gcomp){
        width = w+2;
        height = h+2;
        cornerRadius = ra;
        parent = gcomp;

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

        setFillColor(Color.BLACK);
        base = 0;
    }

    public void setCornerRadius(int radius){
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

    public void setSize(int w, int h){
        width = w+(outlineThickness/2);
        height = h+(outlineThickness/2);

        topLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        topRightCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomRightCorner.setSize(cornerRadius*2,cornerRadius*2);
        vertPortion.setSize(width - (cornerRadius * 2), height);
        horPortion.setSize(width, height - (cornerRadius * 2));
    }

    public void setThickness(int pixels){
        outlineThickness = pixels;
        width = (int) (parent.getWidth()+(outlineThickness));
        height = (int) (parent.getHeight()+(outlineThickness));
        base = 0 - outlineThickness;

        // update size
        topLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        topRightCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomLeftCorner.setSize(cornerRadius*2,cornerRadius*2);
        bottomRightCorner.setSize(cornerRadius*2,cornerRadius*2);
        vertPortion.setSize(width + (cornerRadius * 1.25), height);
        horPortion.setSize(width, height + (cornerRadius * 1.25));
        horPortion.setColor(Color.BLUE);
        vertPortion.setColor(Color.CYAN);

        // update location
        topLeftCorner.setLocation(base,base);
        topRightCorner.setLocation(width-(cornerRadius*2),base);
        bottomLeftCorner.setLocation(base,height-(cornerRadius*2));
        bottomRightCorner.setLocation(width-(cornerRadius*2),height-(cornerRadius*2));
        vertPortion.setLocation(cornerRadius + base, base);
        horPortion.setLocation(base,cornerRadius + base);

    }
}
