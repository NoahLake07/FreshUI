package freshui.interfaces;

public interface FreshComponent {

    void setLocation(double x, double y);
    double getX();
    double getY();

    double getWidth();
    double getHeight();

    void addToParent();
    boolean isAdded();

    boolean isVisible();
    void setVisible(boolean b);

}
