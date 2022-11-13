package freshui.graphics;

public class FRect extends RoundRect {

    public FRect(double width, double height){
        super(width,height);
        setCornerRadius(0);
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

}
