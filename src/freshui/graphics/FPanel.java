package freshui.graphics;

import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

import java.util.ArrayList;

public class FPanel implements FreshComponent {

    ArrayList<FreshComponent> objects = new ArrayList<>();

    double width = 0, height = 0, panelX = 0, panelY = 0;
    boolean isAdded = false, isVisible = false;
    FreshProgram parent;

    public FPanel(int w, int h){
        width = w;
        height = h;
    }

    public FPanel(){
        this(0,0);
    }

    private void updateLocation(){
        for (int i = 0; i < objects.size(); i++) {
            FreshComponent fc = objects.get(i);
            objects.get(i).setLocation(panelX+fc.getX(),panelY+fc.getY());
        }
    }

    public void add(FreshComponent fc, int x, int y){
        parent.add(fc,panelX+x,panelY+y);
        objects.add(fc);
        fc.setLocation(panelX+fc.getX(),panelY+fc.getY());
    }

    /// region FreshComponent Interface

    @Override
    public void setLocation(double x, double y) {
        panelX = x;
        panelY = y;
        updateLocation();
    }

    @Override
    public double getX() {
        return panelX;
    }

    @Override
    public double getY() {
        return panelY;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void setWidth(double w) {
        width = w;
    }

    @Override
    public void setHeight(double h) {
        height = h;
    }

    @Override
    public void setBounds(double x, double y, double w, double h) {
        panelX = x;
        panelY = y;
        width = w;
        height = h;
        updateLocation();
    }

    @Override
    public void setSize(double w, double h) {
        width = w;
        height = h;
    }

    @Override
    public void addToParent(double x, double y) {
        for (int i = 0; i < objects.size(); i++) {
            this.add(objects.get(i), (int) x,(int) y);
        }
        updateLocation();
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

    }

    @Override
    public FreshProgram getProgramParent() {
        return parent;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent) {
        parent = fpParent;
    }

    /// endregion
}
