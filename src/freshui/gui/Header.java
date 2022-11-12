package freshui.gui;

import acm.graphics.GCompound;
import freshui.graphics.FCompound;
import freshui.graphics.OldFRect;
import freshui.program.FreshProgram;

import javax.swing.*;
import java.awt.Color;

public class Header extends FCompound {

    private boolean resizeProcessActive = false;
    private FreshProgram freshProgramParent;
    private int headerHeight;
    private JLabel headerLabel;
    private OldFRect headerShape;
    private Color headerColor, textColor;
    private int scaleFactor;

    /**
     * Constructs a header that contains a label inside. The label can be repositioned
     * and moved at will, and the fill color can also be changed.
     * With this constructor, the color of the header is defaulted to gray, and the
     * text color is defaulted to black.
     *
     * @param width     The width of the header
     * @param text      Text to be used as the title in the header
     * @param alignment The horizontal alignment of the text inside the header
     */
    public Header(int width, String text, int alignment, FreshProgram parent) {
        freshProgramParent = parent;

        // setting variables to default
        scaleFactor = 10;
        headerColor = Color.GRAY;
        textColor = Color.BLACK;
        headerHeight = freshProgramParent.getHeight() / scaleFactor;

        // instantiating components
        headerLabel = new JLabel(text);
        headerShape = new OldFRect(width + 1, headerHeight + 1);

        // adding headerShape, setting headerShape color
        add(headerShape);
        headerShape.setBounds(-1,-1,headerShape.getWidth(),headerShape.getHeight());
        //headerShape.setFilled(true);
        headerShape.setFillColor(headerColor);

        // adding headerLabel, setting headerLabel color
        freshProgramParent.add(headerLabel,0,0);
        headerLabel.setBounds(0,0,headerLabel.getWidth(),headerLabel.getHeight());
        headerLabel.setForeground(textColor);

        // positioning headerLabel
        headerLabel.setHorizontalAlignment(alignment);
        headerLabel.setLocation((int) (headerShape.getWidth() / 2 - headerLabel.getWidth() / 2),
                (int) (headerShape.getLocation().getY() + headerShape.getHeight() / 2 - headerLabel.getHeight() / 2));

    }

    public void setLocation(double x, double y){
        freshProgramParent.setLocation((int) x, (int) y);
        headerLabel.setLocation(headerLabel.getWidth(),headerLabel.getHeight());
    }

    public String getHeaderText() {
        return headerLabel.getText();
    }

    public OldFRect getHeaderShape() {
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

    public void setHeaderShape(OldFRect headerShape) {
        this.headerShape = headerShape;
    }

    public void setHeaderHeight(int headerHeight) {
        this.headerHeight = headerHeight;
        headerShape.setSize(headerShape.getWidth(), headerHeight);
    }

    public void setHeaderColor(Color headerColor) {
        this.headerColor = headerColor;
        headerShape.setFillColor(headerColor);
        headerShape.setColor(headerColor);
    }

    public void setPosition(int x, int y) {
        headerShape.setLocation(x, y);
        headerLabel.setLocation((int) (headerShape.getWidth() / 2 - headerLabel.getWidth() / 2),
                (int) (headerShape.getLocation().getY() + headerShape.getHeight() / 2 - headerLabel.getHeight() / 2));
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
        headerHeight = freshProgramParent.getHeight() / scaleFactor;
        headerLabel.setLocation((int) (headerShape.getWidth() / 2 - headerLabel.getWidth() / 2),
                (int) (headerShape.getLocation().getY() + headerShape.getHeight() / 2 - headerLabel.getHeight() / 2));
    }

    public void setTextColor(Color c) {
        headerLabel.setForeground(c);
    }

    public void setText(String s) {
        headerLabel.setText(s);
        headerLabel.setLocation((int) (headerShape.getWidth() / 2 - headerLabel.getWidth() / 2),
                (int) (headerShape.getLocation().getY() + headerShape.getHeight() / 2 - headerLabel.getHeight() / 2));
    }

    public void resizeOnGParent() {
        headerHeight = freshProgramParent.getHeight() / scaleFactor;
        headerShape.setBounds(-1, -1, freshProgramParent.getWidth() + 1, headerHeight);
        headerLabel.setLocation((int) (headerShape.getWidth() / 2 - headerLabel.getWidth() / 2),
                (int) (headerShape.getLocation().getY() + headerShape.getHeight() / 2 - headerLabel.getHeight() / 2));
    }

    public void startResizing() {
        resizeProcessActive = true;
        Runnable resizeProcess = new Runnable() {
            public void run() {
                while (true) {
                    resizeOnGParent();
                }
            }
        };
        resizeProcess.run();
    }
}
