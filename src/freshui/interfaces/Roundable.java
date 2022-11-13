package freshui.interfaces;

public interface Roundable {

    boolean isRounded();
    boolean isSharp();
    void setRounded(boolean b);
    void setCornerRadius(double radius);
    double getCornerRadius();

}
