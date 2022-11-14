package freshui.interfaces;

public interface FreshComponent {

    void setLocation(double x, double y);
    double getX();
    double getY();

    double getWidth();
    double getHeight();

    void setWidth(double w);
    void setHeight(double h);
    void setBounds(double x, double y, double w, double h);

    void addToParent();
    boolean isAdded();

    boolean isVisible();
    void setVisible(boolean b);

}
