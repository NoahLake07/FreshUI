package freshui.graphics;

import acm.graphics.GCanvas;
import acm.graphics.GCompound;
import acm.graphics.GMath;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

import java.awt.*;

public class FCompound extends GCompound implements FreshComponent {

    FreshProgram parent;

    public void add(FreshComponent fc, int x, int y){
        fc.setProgramParent(parent);
        fc.addToParent(x,y);
    }

    public void add(FreshComponent fc){
        add(fc,0,0);
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
    public FreshProgram getProgramParent() {
        return parent;
    }

    @Override
    public void setProgramParent(FreshProgram fpParent) {
        parent= fpParent;
    }
}
