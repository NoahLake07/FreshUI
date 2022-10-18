import acm.graphics.GCompound;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;

public class Header extends GCompound {

    private int headerHeight;
    private JLabel headerLabel;
    private GRect headerShape;
    private Color headerColor, textColor;
    private int scaleFactor;

    /**
     * Constructs a header that contains a label inside. The label can be repositioned
     * and moved at will, and the fill color can also be changed.
     * With this constructor, the color of the header is defaulted to gray, and the
     * text color is defaulted to black.
     * @param width The width of the header
     * @param text Text to be used as the title in the header
     * @param alignment The horizontal alignment of the text inside the header
     * @param parent the GraphicsProgram parent this object belongs to
     */
    public Header (int width, String text, int alignment, GraphicsProgram parent){

        // setting variables to default
        scaleFactor = 10;
        headerColor = Color.GRAY;
        textColor = Color.BLACK;
        headerHeight = parent.getHeight()/scaleFactor;

        // instantiating components
        headerLabel = new JLabel(text);
        headerShape = new GRect(width+1,headerHeight+1);

        // adding headerShape, setting headerShape color
        add(headerShape,-1,-1);
        headerShape.setFilled(true);
        headerShape.setFillColor(headerColor);
        headerShape.setColor(headerColor);

        // adding headerLabel, setting headerLabel color
        parent.add(headerLabel,0,0);
        headerLabel.setForeground(textColor);

        // positioning headerLabel
        headerLabel.setHorizontalAlignment(alignment);
        headerLabel.setLocation((int) (headerShape.getWidth()/2 - headerLabel.getWidth()/2),
                                (int) (headerShape.getLocation().getY() + headerShape.getHeight()/2 - headerLabel.getHeight()/2));


    }

    public String getHeaderText(){
        return headerLabel.getText();
    }

    public GRect getHeaderShape(){
        return headerShape;
    }

    public Color getHeaderColor() {
        return headerColor;
    }

    public int getHeaderHeight() {
        return headerHeight;
    }

    public Color getTextColor() {
        return textColor;
    }

    public JLabel getHeaderLabel() {
        return headerLabel;
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setHeaderLabel(JLabel headerLabel) {
        this.headerLabel = headerLabel;
    }

    public void setHeaderShape(GRect headerShape) {
        this.headerShape = headerShape;
    }

    public void setHeaderHeight(int headerHeight) {
        this.headerHeight = headerHeight;
        headerShape.setSize(headerShape.getWidth(), headerHeight);
    }

    public void setHeaderColor(Color headerColor) {
        this.headerColor = headerColor;
    }

    public void setPosition(int x, int y){

    }
}
