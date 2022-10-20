import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;

public class RoundRectOutline extends GCompound {

    private GOval topLeftCorner, topRightCorner, bottomLeftCorner, bottomRightCorner;
    private GRect vertPortion, horPortion;
    private int cornerRadius, width, height, outlineThickness;

    private int offset = 0;
    private GCompound parent;

    /**
     * Constructs a RoundRectOutline using a width and a height,
     * while the corner radius and outline thickness will be defaulted.
     * @param w width of the outline
     * @param h height of the outline
     * @param ra corner radius
     * @param gcomp The GCompound that this outline belongs to
     */
    public RoundRectOutline(int w, int h, int ra, GCompound gcomp){
        outlineThickness = 2;
        width = w + (outlineThickness*2);
        height = h + (outlineThickness*2);
        cornerRadius = ra;
        parent = gcomp;
        offset = 1-outlineThickness;

        // create corners
        topLeftCorner = new GOval(cornerRadius*2,cornerRadius*2);
        topRightCorner = new GOval(cornerRadius*2,cornerRadius*2);
        bottomLeftCorner = new GOval(cornerRadius*2,cornerRadius*2);
        bottomRightCorner = new GOval(cornerRadius*2,cornerRadius*2);

        // create filler rectangles
        vertPortion = new GRect(width - (cornerRadius * 2) + outlineThickness, height);
        horPortion = new GRect(width, height - (cornerRadius * 2) + outlineThickness);

        // add objects to the compound
        add(topLeftCorner,offset,offset);
        add(topRightCorner,width - (cornerRadius*2) - (outlineThickness/2),offset);
        add(bottomLeftCorner,offset,height - (cornerRadius*2) - (getThickness()/2));
        add(bottomRightCorner,width-(cornerRadius*2) - (getThickness()/2),height-(cornerRadius*2) - (getThickness()/2));

        add(vertPortion,topLeftCorner.getX() + cornerRadius, topLeftCorner.getY());
        add(horPortion,topLeftCorner.getX(),topLeftCorner.getY() + cornerRadius);

        setFillColor(Color.BLACK);
        System.out.println("Offset" + offset);
        System.out.println("Thickness" + outlineThickness);
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

        topLeftCorner.setLocation(offset,offset);
        topRightCorner.setLocation(width - (cornerRadius*2) - (outlineThickness/2),offset);
        bottomLeftCorner.setLocation(offset,height - (cornerRadius*2) - (getThickness()/2));
        bottomRightCorner.setLocation(width-(cornerRadius*2) - (getThickness()/2),height-(cornerRadius*2) - (getThickness()/2));
        vertPortion.setLocation(topLeftCorner.getX() + cornerRadius, topLeftCorner.getY());
        horPortion.setLocation(topLeftCorner.getX(),topLeftCorner.getY() + cornerRadius);
    }

    public int getThickness(){
        return outlineThickness;
    }
}
