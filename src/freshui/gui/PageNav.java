package freshui.gui;

import freshui.interfaces.FreshComponent;
import freshui.interfaces.Navigation;
import freshui.program.FreshProgram;

import javax.swing.*;
import java.util.ArrayList;

public class PageNav implements Navigation, FreshComponent {

    ArrayList<Button> tiles = new ArrayList<>();
    int selected = 0;

    /// region Constructors

    public PageNav(ArrayList<Button> ti){
        tiles = ti;
        selected = 0;
    }

    /// endregion

    /// region Interface Methods

    @Override
    public void setSelected(int page) {
        selected = page;
    }

    @Override
    public int getSelected() {
        return selected;
    }

    @Override
    public void addTile(Object tile) {
        tiles.add((Button) tile);
    }

    @Override
    public Object getTile(int index) {
        return tiles.get(index);
    }

    @Override
    public ArrayList getTiles() {
        return tiles;
    }

    @Override
    public void setTiles(ArrayList ti) {
        tiles = ti;
    }

    @Override
    public void setLocation(double x, double y) {

    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public void setWidth(double w) {

    }

    @Override
    public void setHeight(double h) {

    }

    @Override
    public void setBounds(double x, double y, double w, double h) {

    }

    @Override
    public void setSize(double w, double h) {

    }

    @Override
    public void addToParent(double x, double y) {

    }

    @Override
    public boolean isAdded() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public void setVisible(boolean b) {

    }

    @Override
    public FreshProgram getProgramParent() {
        return null;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent) {

    }

    /// endregion


    public class Button extends JButton {

        int assigned = 0;

        public Button(int value){
            assigned = value;
            this.setText(String.valueOf(value));
        }
    }
}
