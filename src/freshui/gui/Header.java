package freshui.gui;

import freshui.graphics.FRect;
import freshui.interfaces.Colorable;
import freshui.interfaces.FreshComponent;
import freshui.interfaces.HeaderTraits;
import freshui.program.FreshProgram;
import javax.swing.*;
import java.awt.*;

public class Header implements FreshComponent, Colorable, HeaderTraits {

    // objects part of header
    private FRect shape;
    private JLabel headerLabel;

    // freshProgram parent identities
    private FreshProgram freshProgramParent;
    private boolean isAdded, isVisible;

    // header features
    double headerHeight;
    private Color headerColor, textColor;
    private Font headerFont;
    private String headerText;

    // default values
    public final int DEFAULT_HEIGHT = 50;
    public final int DEFAULT_PADDING = 10;

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
        shape = new FRect(width, DEFAULT_HEIGHT,parent);
        headerText = text;
        headerLabel = new JLabel(headerText);
        headerFont = new Font("Arial",Font.PLAIN, (int) (shape.getHeight()/2));
        isAdded = false;
        isVisible = false;
        headerColor = new Color(115, 234, 189);
        textColor = new Color(0,0,0);

        shape.setColor(headerColor);

        if(width>(DEFAULT_PADDING*2)){
            headerLabel.setSize(width-(2*DEFAULT_PADDING), (int) shape.getHeight());
        } else {
            headerLabel.setSize(width-(2*DEFAULT_PADDING), (int) shape.getHeight());
        }

        headerLabel.setVerticalAlignment(SwingConstants.CENTER);
        headerLabel.setHorizontalAlignment(alignment);
        headerLabel.setForeground(textColor);
    }

    @Override
    public void setColor(Color c) {
        shape.setColor(c);
    }

    @Override
    public Color getColor() {
        return shape.getColor();
    }

    @Override
    public void setLocation(double x, double y) {
        shape.setLocation(x,y);
        updateBounds();
    }

    @Override
    public double getX() {
        return shape.getX();
    }

    @Override
    public double getY() {
        return shape.getY();
    }

    @Override
    public double getWidth() {
        return shape.getWidth();
    }

    @Override
    public double getHeight() {
        return shape.getHeight();
    }

    @Override
    public void setWidth(double w) {
        shape.setWidth(w);
        updateBounds();
    }

    @Override
    public void setHeight(double h) {
        shape.setHeight(h);
        updateBounds();
    }

    @Override
    public void setBounds(double x, double y, double w, double h) {
        shape.setBounds(x,y,w,h);
    }

    public void updateBounds(){
        headerLabel.setFont(headerFont);
        headerLabel.setLocation((int) (shape.getX() + shape.getWidth()/2 - headerLabel.getWidth()/2), (int) (shape.getY() + shape.getHeight()/2 - headerLabel.getHeight()/2));
    }

    @Override
    public void setSize(double w, double h) {
        shape.setSize(w,h);
        updateBounds();
    }

    @Override
    public void addToParent(double x, double y) {
        shape.addToParent(x,y);
        freshProgramParent.add(headerLabel,x + shape.getWidth()/2 - headerLabel.getWidth()/2,y + shape.getHeight()/2 - headerLabel.getHeight()/2);
        isAdded = true;
    }

    @Override
    public boolean isAdded() {
        return isAdded;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisible(boolean b) {
        isVisible = b;
        shape.setVisible(b);
        headerLabel.setVisible(b);
    }

    @Override
    public FreshProgram getProgramParent() {
        return freshProgramParent;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent) {
        freshProgramParent = fpParent;
        shape.setProgramParent(fpParent);
    }

    @Override
    public String getText() {
        return headerLabel.getText();
    }

    @Override
    public void setText(String s) {
        headerLabel.setText(s);
    }

    @Override
    public Font getFont() {
        return headerLabel.getFont();
    }

    @Override
    public void setFont(Font f) {
        headerLabel.setFont(f);
    }

    @Override
    public void setFont(String fontName, int fontType, int size) {
        setFont(new Font(fontName,fontType,size));
    }

    @Override
    public void setFont(String fontName){
        headerLabel.setFont(new Font(fontName, headerLabel.getFont().getStyle(), headerLabel.getFont().getSize()));
    }

    @Override
    public Color getTextColor() {
        return headerLabel.getForeground();
    }

    @Override
    public void setTextColor(Color c) {
        headerLabel.setForeground(c);
    }
}
