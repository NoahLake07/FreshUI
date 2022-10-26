package freshui.graphics;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import java.awt.*;

public class RectOutline extends GCompound {

    private double width, height;
    private GRect outline;
    private Color outlineColor;

    public RectOutline(double w, double h){
        outlineColor = Color.BLACK;
        width = w;
        height = h;
        outline = new GRect(width, height);
        outline.setFilled(true);
        setColor(outlineColor);
        add(outline);
    }

    public void setSize(double w, double h){
        width = w;
        height = h;
        outline.setSize(width,height);
    }

    public void setColor(Color c){
        outlineColor = c;
        outline.setColor(c);
        outline.setFillColor(c);
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

}
