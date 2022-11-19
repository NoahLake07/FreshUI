package freshui.graphics;

import acm.program.GraphicsProgram;
import freshui.interfaces.FreshComponent;
import freshui.program.FreshProgram;

public class FRect extends RoundRect implements FreshComponent {

    private boolean isAdded = false;

    public FRect(double width, double height){
        super(width,height,0);
        isAdded = false;
    }

    public FRect(double width, double height, GraphicsProgram parent){
        super(width,height,0, parent);
        setCornerRadius(0);
        isAdded = false;
    }

    public void setRounded(){
    }

    public void setSharp(){
    }

    public boolean isRounded(){
        return this.getCornerRadius()>0;
    }

    public boolean isSharp(){
        return this.getCornerRadius()<1;
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
    public void addToParent() {
        isAdded = true;
    }

    @Override
    public boolean isAdded() {
        return false;
    }

    @Override
    public GraphicsProgram getProgramParent() {
        return programParent;
    }
}
