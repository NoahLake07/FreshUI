package freshui.graphics;
import acm.graphics.GCompound;
import acm.graphics.GRect;
import java.awt.Color;
import acm.program.GraphicsProgram;
import freshui.util.Resizer;

/**
 * A rectangle that enhances the usage of GRects, while also creating a freshui.graphics.RoundRect.
 */
public class OldFRect extends GCompound {

    // Objects used for a freshui.graphics.FRect
    private GRect gRect;
    private RectOutline gRectOutline;
    private RoundRect roundRect;

    // freshui.graphics.FRect properties
    private double width, height, outlineThickness;
    private int type;
    private Color myColor, myOutlineColor;

    // Constants
    private final int NONROUNDED = 0;
    private final int ROUNDED = 1;
    private boolean outlineVisibility = false;


    /**
     * Constructs a basic rectangle using parameters width and height.
     * This compound contains a normal GRect, and a freshui.graphics.RoundRect.
     * @param w width of rectangle
     * @param h height of rectangle
     */
    public OldFRect(double w, double h){
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
        // update freshui.graphics.RoundRect outline properties
        roundRect.setOutlineThickness((int) outlineThickness);
        roundRect.setOutlineColor(myOutlineColor);

        gRectOutline.setSize(width+outlineThickness,height+outlineThickness);
        gRectOutline.setLocation(gRect.getX()-(outlineThickness/2),gRect.getY()-(outlineThickness/2));


        if(outlineVisibility == true) {
            if (type == ROUNDED) {
                roundRect.setOutlineVisibility(true);
                gRect.setVisible(false);
            } else if (type == NONROUNDED) {
                roundRect.setOutlineVisibility(false);
                gRect.setVisible(true);
            } else {
                System.out.println("Rectangle Type Invalid");
            }
        } else {

        }
    }

    private void updateRectType(){
        // update rectangle type
        if(type == NONROUNDED){
            gRect.setVisible(true);
            gRectOutline.setVisible(true);
            roundRect.setVisible(false);
        } else if (type == ROUNDED){
            gRect.setVisible(false);
            gRectOutline.setVisible(false);
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
        gRectOutline.setColor(myColor);
        roundRect.setFillColor(myColor);
    }

    private void createGRect(){
        gRect = new GRect(width, height);
        gRect.setColor(myColor);
        gRect.setFilled(true);
        gRect.setFillColor(myColor);

        gRectOutline = new RectOutline(width+outlineThickness,height+outlineThickness);
        add(gRectOutline, gRect.getX()-(outlineThickness/2),gRect.getY()-(outlineThickness/2));
    }

    private void createRoundRect(){
        //roundRect = new RoundRect(width, height);
    }

    public void setRounded(){
        type = ROUNDED;
        updateRectBounds();
    }

    public void setSharp(){
        type = NONROUNDED;
        updateRectBounds();
    }

    public void setCornerRadius(double radius){
        roundRect.setCornerRadius(radius);
    }

    public void setOutlineVisible(boolean status){
        roundRect.setOutlineVisibility(status);
        //gRectOutline.setVisible(status);
        outlineVisibility = status;
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

        // set outline thickness of rectoutline
        gRectOutline.setSize(width+outlineThickness,height+outlineThickness);
        gRectOutline.setLocation(gRect.getX()-(outlineThickness/2),gRect.getY()-(outlineThickness/2));

    }

    public void setSize(double w, double h){
        width = w;
        height = h;
        updateRectBounds();
    }

    public void setBounds(double x, double y, double w, double h){
        // update size
        gRect.setSize(w,h);
        roundRect.setSize(w,h);

        // update location inside compound
        gRect.setLocation(x,y);
        roundRect.setLocation(x,y);
    }


    public void startResizingOnWindow(GraphicsProgram parent){
        double[] rValues = Resizer.getRelativeValues(parent,this);
        Runnable resizeProcess = new Runnable() {
            public void run() {
                while (true) {
                    // TODO resize on parent

                }
            }
        };
        resizeProcess.run();
    }

}
