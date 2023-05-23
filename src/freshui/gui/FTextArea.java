package freshui.gui;

import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class FTextArea implements FreshComponent {

    // * LOCAL OBJECTS
    private JScrollPane scrollPane;
    private JTextPane textPane;
    private Color defaultColor;

    // * FRESH-PROGRAM LOCALS
    private FreshProgram parent = null;
    private boolean isVisible = true, isAdded = false;

    // * PUBLIC CONSTANTS
    public static final int DEFAULT_TEXT_WIDTH = 300;
    public static final int DEFAULT_TEXT_HEIGHT = 200;

    //region Constructors
    public FTextArea(){
        this(DEFAULT_TEXT_WIDTH,DEFAULT_TEXT_HEIGHT);
    }

    public FTextArea(int w, int h){
        textPane = new JTextPane();
        scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(w, h));

        defaultColor = Color.BLACK;
    }
    //endregion

    //region Interaction Methods
    private void append(String text, Color color, Font font) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setForeground(style, color);
        StyleConstants.setFontFamily(style, font.getFamily());
        StyleConstants.setFontSize(style, font.getSize());

        try {
            doc.insertString(doc.getLength(), text, style);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void append(String text, Color color) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setForeground(style, color);

        try {
            doc.insertString(doc.getLength(), text, style);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void append(String text){
        this.append(text,defaultColor);
    }

    public void clear(){
        this.textPane.setText("");
    }

    public String pop(){
        String temp = this.textPane.getText();
        this.clear();
        return temp;
    }

    //endregion

    //region Mutators/Getters

    public void setDefaultColor(Color color){
        this.defaultColor = color;
    }

    public Color getDefaultColor(){
        return this.defaultColor;
    }

    public void setText(String text){
        this.textPane.setText(text);
    }

    public String getText(){
        return this.textPane.getText();
    }

    public void setTextPane(JTextPane newPane){
        this.textPane = newPane;
    }

    public JTextPane getTextPane(){
        return this.textPane;
    }

    //endregion

    //region FreshComponent Interface Implementations
    @Override
    public void setLocation(double v, double v1) {
        this.scrollPane.setLocation((int) v, (int) v1);
    }

    @Override
    public double getX() {
        return this.scrollPane.getX();
    }

    @Override
    public double getY() {
        return this.scrollPane.getY();
    }

    @Override
    public double getWidth() {
        return this.scrollPane.getWidth();
    }

    @Override
    public double getHeight() {
        return this.scrollPane.getWidth();
    }

    @Override
    public void setWidth(double v) {
        this.scrollPane.setSize((int)v,scrollPane.getHeight());
    }

    @Override
    public void setHeight(double v) {
        this.scrollPane.setSize(scrollPane.getWidth(),(int)v);
    }

    @Override
    public void setBounds(double x, double y, double w, double h) {
        this.scrollPane.setSize((int)w,(int)h);
        this.scrollPane.setLocation((int) x, (int) y);
    }

    @Override
    public void setSize(double v, double v1) {
        this.scrollPane.setSize((int)v,(int)v1);
    }

    @Override
    public void addToParent(double v, double v1) {
        this.parent.add(scrollPane,v,v1);
        this.isAdded = true;
        this.isVisible = true;
    }

    @Override
    public boolean isAdded() {
        return this.isAdded;
    }

    @Override
    public boolean isVisible() {
        return this.isVisible;
    }

    @Override
    public void setVisible(boolean b) {
        textPane.setVisible(b);
        scrollPane.setVisible(b);
        this.isVisible = true;
    }

    @Override
    public FreshProgram getProgramParent() {
        return this.parent;
    }

    @Override
    public void setProgramParent(FreshProgram freshProgram) {
        this.parent = freshProgram;
    }

    //endregion
}
