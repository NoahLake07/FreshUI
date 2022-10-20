import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;

/**
 * A rectangle that enhances the usage of GRects, while also creating a RoundRect.
 */
public class FRect extends GCompound {

    // Objects used for a FRect
    private GRect gRect;
    private RoundRect roundRect;

    // FRect properties
    private double width, height, outlineThickness;
    private int type;
    private Color myColor, myOutlineColor;

    // Constants
    private final int NONROUNDED = 0;
    private final int ROUNDED = 1;


    /**
     * Constructs a basic rectangle using parameters width and height.
     * This compound contains a normal GRect, and a RoundRect.
     * @param w width of rectangle
     * @param h height of rectangle
     */
    public FRect(double w, double h){
        width = w;
        height = h;
        type = NONROUNDED;
        outlineThickness = 1;

        createGRect();
        createRoundRect();

        add(gRect);
        add(roundRect);
        updateRectBounds();
    }

    private void updateRectBounds(){
        // update all bounds of the rectangle
        updateRectType();
        updateRectSize();
        updateOutline();
        updateColor();
    }

    private void updateOutline(){
        // update RoundRect outline properties
        roundRect.setOutlineThickness((int) outlineThickness);
        roundRect.setOutlineColor(myOutlineColor);

        //TODO update RectOutline outline properties
    }

    private void updateRectType(){
        // update rectangle type
        if(type == NONROUNDED){
            gRect.setVisible(true);
            roundRect.setVisible(false);
        } else if (type == ROUNDED){
            gRect.setVisible(false);
            roundRect.setVisible(true);
        }
    }

    private void updateRectSize(){
        // update rectangle sizes
        gRect.setSize(width,height);
        roundRect.setSize(width,height);
    }

    private void updateColor(){
        // update color
        gRect.setFillColor(myColor);
        gRect.setColor(myColor);
        roundRect.setFillColor(myColor);
    }

    private void createGRect(){
        gRect = new GRect(width, height);
        gRect.setColor(myColor);
        gRect.setFilled(true);
        gRect.setFillColor(myColor);
    }

    private void createRoundRect(){
        roundRect = new RoundRect(width, height);
    }

    public void makeRounded(){
        type = ROUNDED;
        updateRectBounds();
    }

    public void makeSharp(){
        type = NONROUNDED;
        updateRectBounds();
    }

    public void setCornerRadius(double radius){
        roundRect.setCornerRadius(radius);
    }

    public void setOutlineVisible(boolean status){
        roundRect.setOutlineVisibility(status);
        updateOutline();
    }

    public void setFillColor(Color c){
        myColor = c;
        updateColor();
    }

    public void setOutlineColor(Color c){
        roundRect.setOutlineColor(c);
        updateOutline();
    }

    public void setOutlineThickness(int pixels){
        // set outline thickness of roundrect
        roundRect.setOutlineThickness(pixels);

        // TODO set outline thickness of grect
    }

}
