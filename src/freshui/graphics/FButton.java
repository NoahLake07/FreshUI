package freshui.graphics;

import freshui.interfaces.*;
import freshui.program.FreshProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class FButton implements Colorable, FreshComponent, ObjectOutline, Roundable, Clickable {

    boolean isAdded, isVisible;
    JLabel buttonLabel;
    FRect base;
    FreshProgram parent;
    MouseListener mA;

    public FButton(String text){
        this(text,text.length()*30.4,14);
    }

    public FButton(String text, double width, double height){
        base = new FRect(width,height);
        buttonLabel = new JLabel(text, SwingConstants.CENTER);
        buttonLabel.setVerticalAlignment(SwingConstants.CENTER);
        buttonLabel.setSize((int) width, (int) height);
        isAdded = false;
        isVisible = false;
    }

    @Override
    public void setLocation(double x, double y) {
        buttonLabel.setLocation((int) x, (int) y);
        base.setLocation(x,y);
    }

    @Override
    public double getX() {
        return base.getX();
    }

    @Override
    public double getY() {
        return base.getY();
    }

    @Override
    public double getWidth() {
        return base.getWidth();
    }

    @Override
    public double getHeight() {
        return base.getHeight();
    }

    @Override
    public void setWidth(double w) {
        base.setWidth(w);
        buttonLabel.setSize((int) w, buttonLabel.getHeight());
    }

    @Override
    public void setHeight(double h) {
        base.setHeight(h);
        buttonLabel.setSize(buttonLabel.getWidth(), (int) h);
    }

    @Override
    public void setBounds(double x, double y, double w, double h) {
        base.setBounds(x,y,w,h);
        buttonLabel.setBounds((int) x, (int) y, (int) w, (int) h);
    }

    @Override
    public void setSize(double w, double h) {
        base.setSize(w,h);
        buttonLabel.setSize((int) w, (int) h);
    }

    @Override
    public void addToParent(double x, double y){
        isAdded = true;
        base.setProgramParent(parent);
        base.addToParent(x,y);
        getProgramParent().add(buttonLabel,x,y);
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
        base.setVisible(b);
        buttonLabel.setVisible(b);
    }

    @Override
    public FreshProgram getProgramParent() {
        return parent;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent) {
        parent = fpParent;
    }

    public void setText(String s){
        buttonLabel.setText(s);
    }

    public String getText() {
        return buttonLabel.getText();
    }

    public void setFont(Font f){
        buttonLabel.setFont(f);
    }

    public Font getFont(){
        return buttonLabel.getFont();
    }


    @Override
    public void setColor(Color c) {
        base.setColor(c);
    }

    @Override
    public Color getColor() {
        return base.getColor();
    }

    @Override
    public void setOutlineThickness(int pixels) {
        base.setOutlineThickness(pixels);
    }

    @Override
    public int getOutlineThickness() {
        return base.getOutlineThickness();
    }

    @Override
    public void setOutlineColor(Color c) {
        base.setOutlineColor(c);
    }

    @Override
    public Color getOutlineColor() {
        return base.getOutlineColor();
    }

    @Override
    public void setOutlineVisible(boolean b) {
        base.setOutlineVisible(b);
    }

    @Override
    public boolean isOutlineVisible() {
        return base.isOutlineVisible();
    }

    @Override
    public boolean isRounded() {
        return base.isRounded();
    }

    @Override
    public boolean isSharp() {
        return base.isSharp();
    }

    @Override
    public void setRounded(boolean b) {
        base.setRounded(b);
    }

    @Override
    public void setCornerRadius(double radius) {
        base.setCornerRadius(radius);
    }

    @Override
    public double getCornerRadius() {
        return base.getCornerRadius();
    }

    @Override
    public void addMouseListener(MouseListener ml) {
        mA = ml;
        base.addMouseListener(ml);
    }
}
