package freshui.interfaces;

import acm.program.GraphicsProgram;
import freshui.program.FreshProgram;

public interface FreshComponent {

    GraphicsProgram programParent = null;
    void setLocation(double x, double y);
    double getX();
    double getY();

    double getWidth();
    double getHeight();

    void setWidth(double w);
    void setHeight(double h);
    void setBounds(double x, double y, double w, double h);
    void setSize(double w, double h);

    void addToParent(double x, double y);
    boolean isAdded();

    boolean isVisible();
    void setVisible(boolean b);

    FreshProgram getProgramParent();
    void setProgramParent(FreshProgram fpParent);
}
